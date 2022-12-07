package student.record;

import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class studentDashboard extends javax.swing.JFrame {

    public studentDashboard() {
        
        initComponents();
        users_update();
        display_personal_information();
    }
    public String id;
    private void users_update(){
        PreparedStatement ps;
        ResultSet rs;
        int u;
        try {
            String query = "SELECT * FROM tblcourses";
            ps = StudentRecord.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            ResultSetMetaData Rss = rs.getMetaData();
            u = Rss.getColumnCount();
            DefaultTableModel df = (DefaultTableModel)courseTable.getModel();
            df.setRowCount(0);
            while (rs.next()) {
                Vector v2 = new Vector();
                for (int a = 1; a <= u; a++) {
                    v2.add(rs.getString("courseCode"));
                    v2.add(rs.getString("courseDescription"));
                    v2.add(rs.getString("courseUnit"));
                    v2.add(rs.getString("MG"));
                    v2.add(rs.getString("FG"));
                }
                df.addRow(v2);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "Error in Logging In");
        }
    }
    public void display_personal_information(){
        PreparedStatement ps;
        ResultSet rs;
        try {
            String query = "SELECT * FROM users WHERE userId = id";
            ps = StudentRecord.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            String name = rs.getString(12);
            String dateofbirth = rs.getString("dateOfBirth");
            String AGE = rs.getString("age");
            String ADDRESS = rs.getString("address");
            String STATUS = rs.getString("status");
            String COURSE = rs.getString("course");
            String ACADEMICLEVEL = rs.getString("academicLevel");
            String EMAIL = rs.getString("userEmail");
            String CONTACTNUMBER = rs.getString("contactNumber");
            CompleteName.setText(name);
            JOptionPane.showMessageDialog(this, "Welcome "+ id);
        }catch(Exception e){
            
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanelyellow = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jpanelWhite = new javax.swing.JPanel();
        jpanelBlue = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        completeName = new javax.swing.JLabel();
        dateOfBirth = new javax.swing.JLabel();
        age = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        course = new javax.swing.JLabel();
        academicLevel = new javax.swing.JLabel();
        emailAddress = new javax.swing.JLabel();
        contactNumber = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CompleteName = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        courseTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        academicYear_CB1 = new javax.swing.JComboBox<>();
        academicPeriod_CB2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1024, 768));

        jpanelyellow.setBackground(new java.awt.Color(253, 184, 19));

        jLabel3.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
        jLabel3.setText("STUDENT DASHBOARD");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/record/srms logo blue.png"))); // NOI18N

        javax.swing.GroupLayout jpanelyellowLayout = new javax.swing.GroupLayout(jpanelyellow);
        jpanelyellow.setLayout(jpanelyellowLayout);
        jpanelyellowLayout.setHorizontalGroup(
            jpanelyellowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelyellowLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(638, Short.MAX_VALUE))
        );
        jpanelyellowLayout.setVerticalGroup(
            jpanelyellowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelyellowLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jpanelyellowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addGroup(jpanelyellowLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jpanelWhite.setBackground(new java.awt.Color(255, 255, 255));
        jpanelWhite.setLayout(null);

        jpanelBlue.setBackground(new java.awt.Color(0, 61, 167));

        jLabel1.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PERSONAL INFORMATION");

        completeName.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        completeName.setForeground(new java.awt.Color(255, 255, 255));
        completeName.setText("Complete Name:");

        dateOfBirth.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        dateOfBirth.setForeground(new java.awt.Color(255, 255, 255));
        dateOfBirth.setText("Date of Birth:");

        age.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        age.setForeground(new java.awt.Color(255, 255, 255));
        age.setText("Age:");

        address.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        address.setForeground(new java.awt.Color(255, 255, 255));
        address.setText("Address:");

        status.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        status.setForeground(new java.awt.Color(255, 255, 255));
        status.setText("Status:");

        course.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        course.setForeground(new java.awt.Color(255, 255, 255));
        course.setText("Course:");

        academicLevel.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        academicLevel.setForeground(new java.awt.Color(255, 255, 255));
        academicLevel.setText("Academic Level:");

        emailAddress.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        emailAddress.setForeground(new java.awt.Color(255, 255, 255));
        emailAddress.setText("Email:");

        contactNumber.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        contactNumber.setForeground(new java.awt.Color(255, 255, 255));
        contactNumber.setText("Contact Number:");

        jLabel2.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("In case of Emergency Please Contact");

        CompleteName.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        CompleteName.setText("                           ");

        javax.swing.GroupLayout jpanelBlueLayout = new javax.swing.GroupLayout(jpanelBlue);
        jpanelBlue.setLayout(jpanelBlueLayout);
        jpanelBlueLayout.setHorizontalGroup(
            jpanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelBlueLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel1)
                .addGap(0, 73, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelBlueLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpanelBlueLayout.createSequentialGroup()
                        .addGroup(jpanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(completeName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateOfBirth, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                            .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(course, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(academicLevel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(emailAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(contactNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CompleteName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpanelBlueLayout.createSequentialGroup()
                        .addGap(0, 34, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38))
        );
        jpanelBlueLayout.setVerticalGroup(
            jpanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelBlueLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(completeName)
                    .addComponent(jLabel4)
                    .addComponent(CompleteName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateOfBirth)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(age)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(address)
                .addGap(18, 18, 18)
                .addComponent(status)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(course)
                .addGap(12, 12, 12)
                .addComponent(academicLevel)
                .addGap(15, 15, 15)
                .addComponent(emailAddress)
                .addGap(18, 18, 18)
                .addComponent(contactNumber)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpanelWhite.add(jpanelBlue);
        jpanelBlue.setBounds(10, 20, 320, 330);

        jPanel1.setBackground(new java.awt.Color(253, 184, 19));
        jPanel1.setLayout(null);

        courseTable.setFont(new java.awt.Font(".SF NS Text", 0, 10)); // NOI18N
        courseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Course Code", "Description", "Units", "MG", "FG"
            }
        ));
        jScrollPane1.setViewportView(courseTable);
        if (courseTable.getColumnModel().getColumnCount() > 0) {
            courseTable.getColumnModel().getColumn(0).setHeaderValue("Course Code");
            courseTable.getColumnModel().getColumn(1).setHeaderValue("Description");
            courseTable.getColumnModel().getColumn(2).setHeaderValue("Units");
            courseTable.getColumnModel().getColumn(3).setHeaderValue("MG");
            courseTable.getColumnModel().getColumn(4).setHeaderValue("FG");
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 10, 540, 280);

        jpanelWhite.add(jPanel1);
        jPanel1.setBounds(350, 50, 560, 300);

        jPanel2.setBackground(new java.awt.Color(0, 61, 167));

        academicYear_CB1.setBackground(new java.awt.Color(0, 61, 167));
        academicYear_CB1.setForeground(new java.awt.Color(255, 255, 255));
        academicYear_CB1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " Select Academic Year", "2022", "2021", "2020", "2019", "2018", "2017" }));
        academicYear_CB1.setBorder(null);

        academicPeriod_CB2.setBackground(new java.awt.Color(0, 61, 167));
        academicPeriod_CB2.setForeground(new java.awt.Color(255, 255, 255));
        academicPeriod_CB2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " Select Academic Period", "2022", "2021", "2020", "2019", "2018", "2017" }));
        academicPeriod_CB2.setBorder(null);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addComponent(academicPeriod_CB2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(academicYear_CB1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(academicPeriod_CB2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(academicYear_CB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jpanelWhite.add(jPanel2);
        jPanel2.setBounds(350, 20, 560, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanelyellow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jpanelWhite, javax.swing.GroupLayout.PREFERRED_SIZE, 964, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpanelyellow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jpanelWhite, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new studentDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CompleteName;
    private javax.swing.JLabel academicLevel;
    private javax.swing.JComboBox<String> academicPeriod_CB2;
    private javax.swing.JComboBox<String> academicYear_CB1;
    private javax.swing.JLabel address;
    private javax.swing.JLabel age;
    private javax.swing.JLabel completeName;
    private javax.swing.JLabel contactNumber;
    private javax.swing.JLabel course;
    private javax.swing.JTable courseTable;
    private javax.swing.JLabel dateOfBirth;
    private javax.swing.JLabel emailAddress;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpanelBlue;
    private javax.swing.JPanel jpanelWhite;
    private javax.swing.JPanel jpanelyellow;
    private javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables
}
