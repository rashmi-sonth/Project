import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;


public class Main {
    public static byte[] iv = new SecureRandom().generateSeed(16);
    public static void main(String[] args) throws IOException, GeneralSecurityException {

        String plainText = "";
        int i = 0;


        FileReader fr = null;   //its the input file for encryption ,change the location
        try {
            fr = new FileReader("E:\\pgm\\Sample_input_file.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                if (!((i = fr.read()) != -1)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            plainText += ((char) i);
        }
        //System.out.println("Original plaintext message: " + plainText);

        // Initialize two key pairs
        KeyPair keyPairA = generateECKeys();
        KeyPair keyPairB = generateECKeys();


        //writing into files

        //FileWriter fw1=new FileWriter("C:\\Users\\Kiran\\Desktop\\A_public.txt");
        //fw1.write(String.valueOf(keyPairA.getPublic().getEncoded()));
        //fw1.close();

        FileWriter fw2=new FileWriter("C:\\Users\\Kiran\\Desktop\\A_private1.txt");
        fw2.write(String.valueOf(keyPairA.getPrivate().getEncoded()));
        fw2.close();

        //FileWriter fw3=new FileWriter("C:\\Users\\Kiran\\Desktop\\B_public.txt");
        //fw3.write(String.valueOf(keyPairB.getPublic().getEncoded()));
        //fw3.close();

        FileWriter fw4=new FileWriter("C:\\Users\\Kiran\\Desktop\\B_private1.txt");
        fw4.write(String.valueOf(keyPairB.getPrivate().getEncoded()));
        fw4.close();

        /**
        //reading from these files
        String aprivate="";
        String apublic="";
        String bprivate="";
        String bpublic="";

        File f1=new File("C:\\Users\\Kiran\\Desktop\\A_private.txt");
        Scanner s1=new Scanner(f1);
        while(s1.hasNextLine())
            aprivate+=s1.nextLine();

        File f2=new File("C:\\Users\\Kiran\\Desktop\\A_public.txt");
        Scanner s2=new Scanner(f2);
        while(s2.hasNextLine())
            apublic+=s2.nextLine();

        File f3=new File("C:\\Users\\Kiran\\Desktop\\B_public.txt");
        Scanner s3=new Scanner(f3);
        while(s3.hasNextLine())
            bpublic+=s3.nextLine();

        File f4=new File("C:\\Users\\Kiran\\Desktop\\B_private.txt");
        Scanner s4=new Scanner(f4);
        while(s4.hasNextLine())
            bprivate+=s4.nextLine();


        **/





        // Create two AES secret keys to encrypt/decrypt the message
        SecretKey secretKeyA = generateSharedSecret(keyPairA.getPrivate(),keyPairB.getPublic());
        SecretKey secretKeyB = generateSharedSecret(keyPairB.getPrivate(), keyPairA.getPublic());

        System.out.println("A's private key:" +keyPairA.getPrivate().getEncoded());
        System.out.println("A's public key:"+keyPairA.getPublic().getEncoded());
        System.out.println("B's private key:" +keyPairB.getPublic().getEncoded());
        System.out.println("B's public key:"+keyPairB.getPrivate().getEncoded());



        //System.out.println(secretKeyA.toString());
        //System.out.println(secretKeyB.toString());


        // Encrypt the message using 'secretKeyA'
        String cipherText = encryptString(secretKeyA, plainText);
        //System.out.println("Encrypted cipher text: " + cipherText);

        String path = "C:\\Users\\Kiran\\Desktop\\encrypted_file1.txt";  //change the path
        try {
            Files.writeString(Paths.get(path), cipherText);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Decrypt the message using 'secretKeyB'
        String decryptedPlainText = decryptString(secretKeyB, cipherText);
        //System.out.println("Decrypted cipher text: " + decryptedPlainText);

        String path1 = "C:\\Users\\Kiran\\Desktop\\decrypted_file1.txt";  //outputting the decrypted file
        try {
            Files.writeString(Paths.get(path1), decryptedPlainText);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }






    public static KeyPair generateECKeys() {
        try {
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            ECNamedCurveParameterSpec parameterSpec = ECNamedCurveTable.getParameterSpec("brainpoolp256r1");
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(
                    "ECDH", "BC");


            keyPairGenerator.initialize(parameterSpec);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            return keyPair;

        } catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException
                | NoSuchProviderException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static SecretKey generateSharedSecret(PrivateKey privateKey,
                                                 PublicKey publicKey) {
        try {
            KeyAgreement keyAgreement = KeyAgreement.getInstance("ECDH", "BC");
            keyAgreement.init(privateKey);
            keyAgreement.doPhase(publicKey, true);

            SecretKey key = keyAgreement.generateSecret("AES");
            return key;
        } catch (InvalidKeyException | NoSuchAlgorithmException
                | NoSuchProviderException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public static String encryptString(SecretKey key, String plainText) {
        try {
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding", "BC");
            byte[] plainTextBytes = plainText.getBytes("UTF-8");
            byte[] cipherText;

            cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
            cipherText = new byte[cipher.getOutputSize(plainTextBytes.length)];
            int encryptLength = cipher.update(plainTextBytes, 0,
                    plainTextBytes.length, cipherText, 0);
            encryptLength += cipher.doFinal(cipherText, encryptLength);

            return bytesToHex(cipherText);
        } catch (NoSuchAlgorithmException | NoSuchProviderException
                | NoSuchPaddingException | InvalidKeyException
                | InvalidAlgorithmParameterException
                | UnsupportedEncodingException | ShortBufferException
                | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decryptString(SecretKey key, String cipherText) {
        try {
            Key decryptionKey = new SecretKeySpec(key.getEncoded(),
                    key.getAlgorithm());
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding", "BC");
            byte[] cipherTextBytes = hexToBytes(cipherText);
            byte[] plainText;

            cipher.init(Cipher.DECRYPT_MODE, decryptionKey, ivSpec);
            plainText = new byte[cipher.getOutputSize(cipherTextBytes.length)];
            int decryptLength = cipher.update(cipherTextBytes, 0,
                    cipherTextBytes.length, plainText, 0);
            decryptLength += cipher.doFinal(plainText, decryptLength);

            return new String(plainText, "UTF-8");
        } catch (NoSuchAlgorithmException | NoSuchProviderException
                | NoSuchPaddingException | InvalidKeyException
                | InvalidAlgorithmParameterException
                | IllegalBlockSizeException | BadPaddingException
                | ShortBufferException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String bytesToHex(byte[] data, int length) {
        String digits = "0123456789ABCDEF";
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i != length; i++) {
            int v = data[i] & 0xff;

            buffer.append(digits.charAt(v >> 4));
            buffer.append(digits.charAt(v & 0xf));
        }

        return buffer.toString();
    }

    public static String bytesToHex(byte[] data) {
        return bytesToHex(data, data.length);
    }

    public static byte[] hexToBytes(String string) {
        int length = string.length();
        byte[] data = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            data[i / 2] = (byte) ((Character.digit(string.charAt(i), 16) << 4) + Character
                    .digit(string.charAt(i + 1), 16));
        }
        return data;
    }
}
