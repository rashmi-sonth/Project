class Frame5 extends JFrame implements ActionListener {



    private JFrame frame1;

    private JLabel l0, l1, l2;

    private JComboBox c1;

    private JButton b1;
    private JButton inisend;

    private Connection con;

    private ResultSet rs, rs1;

    private Statement st, st1;

    private PreparedStatement pst;

    private String ids;

    private static JTable table;

    private String[] columnNames = {"ID", "Name", "Gender", "DOB"};

    private String from;



    public Frame5() {

        inisend = new JButton("Initiate send");
        inisend.setFont(new Font("Candara", Font.PLAIN, 15));
        inisend.setSize(250, 20);
        inisend.setLocation(150, 220);
        inisend.addActionListener(this);
        add(inisend);

        l0 = new JLabel("Fetching Information");

        l0.setForeground(Color.red);

        l0.setFont(new Font("Serif", Font.BOLD, 20));

        l1 = new JLabel("Select name");

        b1 = new JButton("submit");
        b1.setSize(150, 35);
        b1.setLocation(300, 180);


        l0.setBounds(100, 50, 350, 40);

        l1.setBounds(75, 110, 75, 20);

        b1.setBounds(150, 150, 150, 20);

        b1.addActionListener(this);



        setTitle("Fetching Info From DataBase");

        setLayout(null);

        setVisible(true);

        setSize(500, 500);
        setLocation(380, 30);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



        add(l0);

        add(l1);;

        add(b1);

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/project", "root", "root@123");


            st = con.createStatement();

            rs = st.executeQuery("select Name from users");

            Vector v = new Vector();

            while (rs.next()) {

                ids = rs.getString(1);

                v.add(ids);

            }

            c1 = new JComboBox(v);

            c1.setBounds(150, 110, 150, 20);



            add(c1);

            st.close();

            rs.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }



    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            showTableData();

        }



    }



    public void showTableData() {



        frame1 = new JFrame("Database Search Result");

        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame1.setLayout(new BorderLayout());
        frame1.setLocation(380, 30);


        DefaultTableModel model = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        model.setColumnIdentifiers(columnNames);




        table = new JTable();

        table.setModel(model);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        table.setFillsViewportHeight(true);


        JScrollPane scroll = new JScrollPane(table);

        scroll.setHorizontalScrollBarPolicy(

                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        scroll.setVerticalScrollBarPolicy(

                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        from = (String) c1.getSelectedItem();



        String ID = "";

        String Name = "";

        String Gender = "";

        String DOB = "";



        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/project", "root", "root@123");

            st1 = con.createStatement();

            ResultSet rs = st1.executeQuery("select * from project.users");
            System.out.println(rs);
            int i = 0;

            while (rs.next()) {

                ID = rs.getString("ID");

                Name = rs.getString("Name");

                Gender = rs.getString("Gender");

                DOB = rs.getString("DOB");

                model.addRow(new Object[]{ID, Name, Gender, DOB});

                i++;

            }

            if (i < 1) {

                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);

            }

            if (i == 1) {

                System.out.println(i + " Record Found");

            } else {

                System.out.println(i + " Records Found");

            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }

        frame1.add(scroll);

        frame1.setVisible(true);

        frame1.setSize(400, 300);
    }

}
