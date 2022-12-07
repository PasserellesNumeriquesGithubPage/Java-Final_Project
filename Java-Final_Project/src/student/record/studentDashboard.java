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
        
    }

    private void users_update() {
        PreparedStatement ps;
        ResultSet rs;
        int u;
        try {
            String query = "SELECT tblcourses.courseCode, tblcourses.courseDescription, tblcourses.courseUnit, student_grades.MG, student_grades.FG "
                    + "FROM tblcourses INNER JOIN student_grades ON student_grades.courseId = tblcourses.courseId ";
            ps = StudentRecord.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            ResultSetMetaData Rss = rs.getMetaData();
            u = Rss.getColumnCount();
            DefaultTableModel df = (DefaultTableModel) courseTable.getModel();
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

    public void display_personal_information() {
        PreparedStatement ps;
        ResultSet rs;
        String i = id.getText();
        String query = "SELECT * FROM student_info WHERE studentId = ?";
        try {
            ps = StudentRecord.getConnection().prepareStatement(query);
            ps.setString(1, i);
            rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString(2);
                String Dateofbirth = rs.getString(3);
                String Age = rs.getString(4);
                String Address = rs.getString(5);
                String Status = rs.getString(6);
                String Course = rs.getString(7);
                String Academiclevel = rs.getString(8);
                String Email = rs.getString(9);
                String Contactnumber = rs.getString(10);
                Completename.setText(name);
                DateOfBirth.setText(Dateofbirth);
                aGe.setText(Age);
                addRess.setText(Address);
                staTus.setText(Status);
                coUrse.setText(Course);
                AcademicLevel.setText(Academiclevel);
                email.setText(Email);
                contactNumbeR.setText(Contactnumber);
            } else {
                System.out.println("FUCK");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanelyellow = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        viewData = new javax.swing.JButton();
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
        contactNumber = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        DateofBirths = new javax.swing.JLabel();
        Completename = new javax.swing.JTextField();
        DateOfBirth = new javax.swing.JTextField();
        aGe = new javax.swing.JTextField();
        AcademicLevel = new javax.swing.JTextField();
        coUrse = new javax.swing.JTextField();
        staTus = new javax.swing.JTextField();
        addRess = new javax.swing.JTextField();
        academicLevel1 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        contactNumbeR = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        courseTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1024, 768));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jpanelyellow.setBackground(new java.awt.Color(253, 184, 19));

        jLabel3.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
        jLabel3.setText("STUDENT DASHBOARD");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/record/srms logo blue.png"))); // NOI18N

        id.setBackground(new java.awt.Color(253, 184, 19));
        id.setForeground(new java.awt.Color(253, 184, 19));
        id.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(253, 184, 19), 1, true));

        viewData.setText("View Information");
        viewData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpanelyellowLayout = new javax.swing.GroupLayout(jpanelyellow);
        jpanelyellow.setLayout(jpanelyellowLayout);
        jpanelyellowLayout.setHorizontalGroup(
            jpanelyellowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelyellowLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jpanelyellowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelyellowLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jpanelyellowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpanelyellowLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jpanelyellowLayout.createSequentialGroup()
                                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 753, Short.MAX_VALUE))))
                    .addGroup(jpanelyellowLayout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addComponent(viewData)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jpanelyellowLayout.setVerticalGroup(
            jpanelyellowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelyellowLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jpanelyellowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpanelyellowLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(viewData)))
                .addContainerGap())
        );

        jpanelWhite.setBackground(new java.awt.Color(255, 255, 255));
        jpanelWhite.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jpanelWhiteComponentShown(evt);
            }
        });
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

        contactNumber.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        contactNumber.setForeground(new java.awt.Color(255, 255, 255));
        contactNumber.setText("Contact Number:");

        jLabel2.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("In case of Emergency Please Contact");

        DateofBirths.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        DateofBirths.setText("                           ");

        coUrse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coUrseActionPerformed(evt);
            }
        });

        academicLevel1.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        academicLevel1.setForeground(new java.awt.Color(255, 255, 255));
        academicLevel1.setText("Email");

        javax.swing.GroupLayout jpanelBlueLayout = new javax.swing.GroupLayout(jpanelBlue);
        jpanelBlue.setLayout(jpanelBlueLayout);
        jpanelBlueLayout.setHorizontalGroup(
            jpanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelBlueLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelBlueLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpanelBlueLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpanelBlueLayout.createSequentialGroup()
                        .addGroup(jpanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(completeName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dateOfBirth, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                .addComponent(contactNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(age, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(course, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(academicLevel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jpanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpanelBlueLayout.createSequentialGroup()
                                .addGroup(jpanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpanelBlueLayout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(Completename)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jpanelBlueLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jpanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(aGe, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(DateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(addRess, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(staTus, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(coUrse, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(AcademicLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(DateofBirths, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jpanelBlueLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(contactNumbeR, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(38, 38, 38))
            .addGroup(jpanelBlueLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(academicLevel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(Completename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateOfBirth)
                    .addComponent(DateofBirths)
                    .addComponent(DateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jpanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aGe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(age))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addRess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(address))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(staTus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(status))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(course)
                    .addComponent(coUrse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AcademicLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(academicLevel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(academicLevel1)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(contactNumber)
                    .addComponent(contactNumbeR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jpanelWhite.add(jpanelBlue);
        jpanelBlue.setBounds(10, 20, 320, 390);

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
                "Course Code", "Course Description", "Course Unit", "MG", "FG"
            }
        ));
        courseTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                courseTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(courseTable);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 10, 540, 370);

        jpanelWhite.add(jPanel1);
        jPanel1.setBounds(350, 20, 560, 390);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpanelWhite, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void courseTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseTableMouseClicked

    }//GEN-LAST:event_courseTableMouseClicked

    private void viewDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDataActionPerformed
        users_update();
        display_personal_information();
    }//GEN-LAST:event_viewDataActionPerformed

    private void coUrseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coUrseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coUrseActionPerformed

    private void jpanelWhiteComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jpanelWhiteComponentShown
        Completename.setEditable(true);
    }//GEN-LAST:event_jpanelWhiteComponentShown

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Completename.setEditable(false);
        DateOfBirth.setEditable(false);
        aGe.setEditable(false);
        addRess.setEditable(false);
        staTus.setEditable(false);
        coUrse.setEditable(false);
        AcademicLevel.setEditable(false);
        email.setEditable(false);
        id.setEditable(false);
         contactNumbeR.setEditable(false);
        courseTable.setEnabled(false);
        
    }//GEN-LAST:event_formWindowActivated

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new studentDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AcademicLevel;
    private javax.swing.JTextField Completename;
    private javax.swing.JTextField DateOfBirth;
    private javax.swing.JLabel DateofBirths;
    private javax.swing.JTextField aGe;
    private javax.swing.JLabel academicLevel;
    private javax.swing.JLabel academicLevel1;
    private javax.swing.JTextField addRess;
    private javax.swing.JLabel address;
    private javax.swing.JLabel age;
    private javax.swing.JTextField coUrse;
    private javax.swing.JLabel completeName;
    private javax.swing.JTextField contactNumbeR;
    private javax.swing.JLabel contactNumber;
    private javax.swing.JLabel course;
    private javax.swing.JTable courseTable;
    private javax.swing.JLabel dateOfBirth;
    private javax.swing.JTextField email;
    public javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpanelBlue;
    private javax.swing.JPanel jpanelWhite;
    private javax.swing.JPanel jpanelyellow;
    private javax.swing.JTextField staTus;
    private javax.swing.JLabel status;
    private javax.swing.JButton viewData;
    // End of variables declaration//GEN-END:variables
}
