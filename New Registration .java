import java.net.InetAddress;
import java.net.NetworkInterface;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.security.SecureRandom;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.awt.*;

import java.awt.event.*;

import java.sql.*;import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;


import java.util.Vector;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;




class Frame1
        extends JFrame
        implements ActionListener {

        private Container c;
        private JLabel title;
        private JButton reg;
        private JLabel desc;
        private JButton login;




    public Frame1(){
        setTitle("Welcome");
        setBounds(300, 90, 1000, 750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();


        c.setBackground(new Color(0,0,0,255) );
        JPanel c = new javax.swing.JPanel() {
            protected void paintComponent(Graphics g) {
                Paint p = new GradientPaint(0.0f, 0.0f, new Color(159, 213, 237, 255),
                        getWidth(), getHeight(), new Color(255, 175, 180, 255), true);
                Graphics2D g2d = (Graphics2D)g;
                g2d.setPaint(p);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        setContentPane(c);
        c.setLayout(null);

        title = new JLabel("WELCOME!");
        title.setFont(new Font("Candara", Font.BOLD, 35));
        title.setSize(300, 50);
        title.setLocation(380, 30);
        c.add(title);


        String text = "The information and data within your business is a valuable business asset. It can be the key to growth and success. The security of your data, therefore, must be a priority within your business. It needs to be protected from unauthorised access to prevent it being tampered with, destroyed or disclosed to others. Your security can be breached in a number of ways, for example by system failure, theft, inappropriate usage, unauthorised access or computer viruses. Every time you engage in anything that involves the Internet your data security is being put at risk. So register here today and save your data to yourself!";

        desc = new JLabel("<html><body><p>" + text + "</p></body></html>");
        desc.setFont(new Font("Candara", Font.PLAIN, 25));
        desc.setSize(800, 600);
        desc.setLocation(100, -30);
        c.add(desc);

        reg = new JButton("Register");
        reg.setFont(new Font("Candara", Font.PLAIN, 25));
        reg.setSize(150, 35);
        reg.setLocation(300, 550);
        reg.addActionListener(this);
        c.add(reg);

        login = new JButton("Login");
        login.setFont(new Font("Candara", Font.PLAIN, 25));
        login.setSize(150, 35);
        login.setLocation(500, 550);
        login.addActionListener(this);
        c.add(login);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == reg) {
            Frame2 f2 = new Frame2();
            dispose();
        }
        else if(e.getSource() == login){
            Frame4 f4 = new Frame4();
            dispose();
    }
    }

}

class Frame2
        extends JFrame
        implements ActionListener {

    // Components of the Form 
    private Container c;
    private JLabel title;
    private JLabel name;
    private JTextField tname;
    private JLabel mno;
    private JTextField tmno;
    private JLabel gender;
    private JRadioButton male;
    private JRadioButton female;
    private ButtonGroup gengp;
    private JLabel dob;
    private JComboBox date;
    private JComboBox month;
    private JComboBox year;
    private JLabel add;
    private JTextArea tadd;
    private JCheckBox term;
    private JButton sub;
    private JButton reset;
    private JTextArea tout;
    private JLabel res;
    private JTextArea resadd;
    private JLabel scan;
    private JTextField tscan;
    private JButton OK;

    public String pass;

    private String dates[]
            = { "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31" };
    private String months[]
            = { "Jan", "feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sep", "Oct", "Nov", "Dec" };
    private String years[]
            = { "1995", "1996", "1997", "1998",
            "1999", "2000", "2001", "2002",
            "2003", "2004", "2005", "2006",
            "2007", "2008", "2009", "2010",
            "2011", "2012", "2013", "2014",
            "2015", "2016", "2017", "2018",
            "2019", "2020" };



    public Frame2()
    {

        setTitle("Registration Form");
        setBounds(300, 90, 1000, 750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();


        c.setBackground(new Color(0,0,0,255) );
        JPanel c = new javax.swing.JPanel() {
            protected void paintComponent(Graphics g) {
                Paint p = new GradientPaint(0.0f, 0.0f, new Color(159, 213, 237, 255),
                        getWidth(), getHeight(), new Color(255, 175, 180, 255), true);
                Graphics2D g2d = (Graphics2D)g;
                g2d.setPaint(p);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        setContentPane(c);
        c.setLayout(null);

        title = new JLabel("Registration Form");
        title.setFont(new Font("Candara", Font.BOLD, 35));
        title.setSize(300, 50);
        title.setLocation(380, 30);
        c.add(title);

        name = new JLabel("Username");
        name.setFont(new Font("Candara", Font.PLAIN, 25));
        name.setSize(300, 30);
        name.setLocation(250, 120);
        c.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Candara", Font.PLAIN, 25));
        tname.setSize(250, 30);
        tname.setLocation(400, 120);
        c.add(tname);

        mno = new JLabel("Mobile");
        mno.setFont(new Font("Candara", Font.PLAIN, 25));
        mno.setSize(300, 30);
        mno.setLocation(250, 170);
        c.add(mno);

        tmno = new JTextField();
        tmno.setFont(new Font("Candara", Font.PLAIN, 25));
        tmno.setSize(250, 30);
        tmno.setLocation(400, 170);
        c.add(tmno);

        gender = new JLabel("Gender");
        gender.setFont(new Font("Candara", Font.PLAIN, 25));
        gender.setSize(300, 30);
        gender.setLocation(250, 220);
        c.add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Candara", Font.PLAIN, 25));
        male.setSelected(true);
        male.setSize(80, 30);
        male.setLocation(400, 220);
        c.add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Candara", Font.PLAIN, 25));
        female.setSelected(false);
        female.setSize(110, 30);
        female.setLocation(500, 220);
        c.add(female);

        gengp = new ButtonGroup();
        gengp.add(male);
        gengp.add(female);

        dob = new JLabel("DOB");
        dob.setFont(new Font("Candara", Font.PLAIN, 25));
        dob.setSize(300, 30);
        dob.setLocation(250, 270);
        c.add(dob);

        date = new JComboBox(dates);
        date.setFont(new Font("Candara", Font.PLAIN, 25));
        date.setSize(50, 30);
        date.setLocation(400, 270);
        c.add(date);

        month = new JComboBox(months);
        month.setFont(new Font("Candara", Font.PLAIN, 25));
        month.setSize(90, 30);
        month.setLocation(460, 270);
        c.add(month);

        year = new JComboBox(years);
        year.setFont(new Font("Candara", Font.PLAIN, 25));
        year.setSize(90, 30);
        year.setLocation(560, 270);
        c.add(year);

        add = new JLabel("Address");
        add.setFont(new Font("Candara", Font.PLAIN, 25));
        add.setSize(300, 30);
        add.setLocation(250, 320);
        c.add(add);

        tadd = new JTextArea();
        tadd.setFont(new Font("Candara", Font.PLAIN, 25));
        tadd.setSize(250, 120);
        tadd.setLocation(400, 320);
        tadd.setLineWrap(true);
        c.add(tadd);

        scan = new JLabel("Scanned value of your device's QR/Barcode");
        scan.setFont(new Font("Candara", Font.PLAIN, 25));
        scan.setSize(500, 30);
        scan.setLocation(250, 470);
        c.add(scan);

        tscan = new JTextField();
        tscan.setFont(new Font("Candara", Font.PLAIN, 25));
        tscan.setSize(500, 30);
        tscan.setLocation(250, 500);
        c.add(tscan);

        term = new JCheckBox("Accept Terms And Conditions.");
        term.setFont(new Font("Candara", Font.PLAIN, 25));
        term.setSize(360, 30);
        term.setLocation(280, 550);
        c.add(term);

        sub = new JButton("Submit");
        sub.setFont(new Font("Candara", Font.PLAIN, 25));
        sub.setSize(150, 30);
        sub.setLocation(300, 610);
        sub.addActionListener(this);
        c.add(sub);

        reset = new JButton("Reset");
        reset.setFont(new Font("Candara", Font.PLAIN, 25));
        reset.setSize(150, 30);
        reset.setLocation(470, 610);
        reset.addActionListener(this);
        c.add(reset);



        res = new JLabel("");
        res.setFont(new Font("Candara", Font.PLAIN, 25));
        res.setSize(700, 30);
        res.setLocation(250, 660);
        c.add(res);



        setVisible(true);
    }

    // method actionPerformed() 
    // to get the action performed 
    // by the user and act accordingly 
    public void actionPerformed(ActionEvent e)
    {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        String pass = sb.toString();

        if (e.getSource() == sub) {

                if(tname.getText().equals("")){
                    res.setText("Please enter a valid name");
                }
                else {
                    if (tmno.getText().equals("")) {
                        res.setText("Please enter a valid mobile number");
                    }
                    else{
                        if(tscan.getText().equals("")){
                            res.setText("Please enter a valid scanned code");
                        }
                        else {
                            if (term.isSelected()) {
                                try {
                                    Class.forName("com.mysql.jdbc.Driver");
                                    Connection con = DriverManager.getConnection(
                                            "jdbc:mysql://localhost:3306/project", "root", "root@123");

                                    Statement stmt = con.createStatement();
                                    String gen;
                                    if (male.isSelected())
                                        gen = "Male";
                                    else
                                        gen = "Female";
                                    String dob
                                            =
                                            (String) date.getSelectedItem()
                                                    + "/" + (String) month.getSelectedItem()
                                                    + "/" + (String) year.getSelectedItem();
                                    String nam = tname.getText();
                                    String mob = tmno.getText();
                                    String address = tadd.getText();
                                    String scanned = tscan.getText();
                                    String sql = "INSERT INTO users (Name, Mobile, Gender, DOB, Addr, qr_codes, password) VALUE ('" + nam + "', '" + mob + "', '" + gen + "' , '" + dob + "', '" + address + "', '" + scanned + "', '" + pass + "')";
                                    int rows = stmt.executeUpdate(sql);
                                    if (rows != 0) {
                                        res.setText("Registered Successfully..!");

                                        dispose();
                                    }

                                    con.close();
                                } catch (Exception E) {
                                    System.out.println(E);
                                }

                            } else {

                                res.setText("Please accept the terms & conditions..");
                            }
                        }
                    }
                    Frame3 f3 = new Frame3();
                }

        }

        else if (e.getSource() == reset) {
            String def = "";
            tname.setText(def);
            tadd.setText(def);
            tmno.setText(def);
            res.setText(def);
            //tout.setText(def);
            term.setSelected(false);
            date.setSelectedIndex(0);
            month.setSelectedIndex(0);
            year.setSelectedIndex(0);

        }



    }

}


class Frame3
        extends JFrame
        implements ActionListener {

    private JButton OK;
    public String pass;


    public Frame3() {
        String header = "Congratulations on your successfull registration!";
        String message = " Your password for first login is ";
        JFrame frame = new JFrame();
        frame.setBounds(650, 300, 450, 150);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(450, 200);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 1.0f;
        constraints.weighty = 1.0f;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.BOTH;
        JLabel headingLabel = new JLabel(header);

        headingLabel.setOpaque(false);
        frame.add(headingLabel, constraints);


        headingLabel.setFont(new Font("Candara", Font.PLAIN, 20));

        constraints.gridx = 1;
        constraints.gridy++;
        constraints.weightx = 1.0f;
        constraints.weighty = 1.0f;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.BOTH;
        JLabel messageLabel = new JLabel("<HtMl>" + message);
        messageLabel.setFont(new Font("Candara", Font.PLAIN, 20));
        frame.add(messageLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy++;
        constraints.weightx = 2.0f;
        constraints.weighty = 2.0f;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.BOTH;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/project", "root", "root@123");

            Statement stmt = con.createStatement();



            PreparedStatement pstat = con.prepareStatement(
                    "select password from users ORDER BY ID DESC LIMIT 1"

            );
            ResultSet rs = pstat.executeQuery();
            int i = 0;
            while(rs.next()) {
                String passw = rs.getString("password");
                pass = passw;
                ++i;
            }


            con.close();
        } catch (Exception E) {
            System.out.println(E);
        }
        JLabel passLabel = new JLabel(pass);
        passLabel.setFont(new Font("Candara", Font.PLAIN, 25));
        frame.add(passLabel, constraints);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        OK = new JButton("OK");
        constraints.gridx = 1;
        constraints.gridy++;
        constraints.weightx = 0f;
        constraints.weighty = 0f;
        constraints.fill = GridBagConstraints.NORTH;

        frame.add(OK, constraints);
        frame.setVisible(true);
        OK.setFocusable(true);
        OK.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        storeMAC();
        if(e.getSource() == OK){
            dispose();
            Frame4 f4 = new Frame4();

        }
    }

    public static byte[] getSHA(String input) throws NoSuchAlgorithmException
    {
        // Static getInstance method is called with hashing SHA
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }
    public static String toHexString(byte[] hash)
    {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 32)
        {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }
    private void storeMAC() {
        InetAddress ip;
        String s1 = null;

        try {

            ip = InetAddress.getLocalHost();
            //System.out.println("Current IP address : " + ip.getHostAddress());

            NetworkInterface network = NetworkInterface.getByInetAddress(ip);

            byte[] mac = network.getHardwareAddress();

            //System.out.print("Current MAC address : ");

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            s1 = sb.toString();
            System.out.println(sb.toString());


        } catch (Exception ex) {
            ex.printStackTrace();
        }


        try {
            System.out.println("HashCode Generated by SHA-256 for MAC:");
            System.out.println("\n" + " : " + toHexString(getSHA(s1)));

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/project", "root", "root@123");

            Statement stmt = con.createStatement();
            String mac = toHexString(getSHA(s1));

            PreparedStatement pstat = con.prepareStatement(
                    "select password from users ORDER BY ID DESC LIMIT 1"

            );
            ResultSet rs = pstat.executeQuery();
            int i = 0;
            while(rs.next()) {
                String passw = rs.getString("password");
                String pass = passw;
                ++i;
            }
            String sql = "UPDATE users SET MACID =  '" + mac + "' WHERE password = '" + pass + "'";
            int rows = stmt.executeUpdate(sql);


            con.close();

        } catch (Exception exce) {
            System.out.println(exce);
        }

    }

    }


MAC ID capture and storage:

private void storeMAC() {
    InetAddress ip;
    String s1 = null;

    try {

        ip = InetAddress.getLocalHost();
        //System.out.println("Current IP address : " + ip.getHostAddress());

        NetworkInterface network = NetworkInterface.getByInetAddress(ip);

        byte[] mac = network.getHardwareAddress();

        //System.out.print("Current MAC address : ");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mac.length; i++) {
            sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
        }
        s1 = sb.toString();
        System.out.println(sb.toString());


    } catch (Exception ex) {
        ex.printStackTrace();
    }


    try {
        System.out.println("HashCode Generated by SHA-256 for MAC:");
        System.out.println("\n" + " : " + toHexString(getSHA(s1)));

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/project", "root", "root@123");

        Statement stmt = con.createStatement();
        String mac = toHexString(getSHA(s1));

        PreparedStatement pstat = con.prepareStatement(
                "select password from users ORDER BY ID DESC LIMIT 1"

        );
        ResultSet rs = pstat.executeQuery();
        int i = 0;
        while(rs.next()) {
            String passw = rs.getString("password");
            String pass = passw;
            ++i;
        }
        String sql = "UPDATE users SET MACID =  '" + mac + "' WHERE password = '" + pass + "'";
        int rows = stmt.executeUpdate(sql);


        con.close();

    } catch (Exception exce) {
        System.out.println(exce);
    }

}