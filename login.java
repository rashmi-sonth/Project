class Frame4
        extends JFrame
    implements ActionListener{
    private Container c;
    private JLabel title;
    private JLabel name;
    private JTextField tname;
    private JLabel pass;
    private JTextField tpass;
    private JButton login;

    public Frame4() {
        setTitle("LOGIN");
        setBounds(300, 90, 700, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();


        c.setBackground(new Color(0, 0, 0, 255));
        JPanel c = new javax.swing.JPanel() {
            protected void paintComponent(Graphics g) {
                Paint p = new GradientPaint(0.0f, 0.0f, new Color(159, 213, 237, 255),
                        getWidth(), getHeight(), new Color(255, 175, 180, 255), true);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(p);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        setContentPane(c);
        c.setLayout(null);

        title = new JLabel("LOGIN");
        title.setFont(new Font("Candara", Font.BOLD, 35));
        title.setSize(350, 50);
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

        pass = new JLabel("Password");
        pass.setFont(new Font("Candara", Font.PLAIN, 25));
        pass.setSize(300, 30);
        pass.setLocation(250, 170);
        c.add(pass);

        tpass = new JTextField();
        tpass.setFont(new Font("Candara", Font.PLAIN, 25));
        tpass.setSize(250, 30);
        tpass.setLocation(400, 170);
        c.add(tpass);

        login = new JButton("Login");
        login.setFont(new Font("Candara", Font.PLAIN, 25));
        login.setSize(150, 35);
        login.setLocation(325, 220);
        login.addActionListener(this);
        c.add(login);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == login) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/project", "root", "root@123");

                Statement stmt = con.createStatement();

                String name = tname.getText();
                String pass = tpass.getText();


                PreparedStatement pstat = con.prepareStatement(
                        "select Name,password from users where Name ='"+ name + "' and password = '"+pass+ "'"
                );
                ResultSet rs = pstat.executeQuery();

                if(!rs.next() && rs.getRow() == 0) {
                    JOptionPane.showMessageDialog(null, "Wrong Username or Password, try again", "Warning !!!", JOptionPane.WARNING_MESSAGE);

                }
                else{
                    dispose();
                    JOptionPane.showMessageDialog(null, "Welcome, you can start sharing data", "Welcome", JOptionPane.WARNING_MESSAGE);
                    //storeMAC();
                    Frame5 f5 = new Frame5();
                }

                con.close();
            } catch (Exception E) {
                System.out.println(E);
            }

        }
    }

}

