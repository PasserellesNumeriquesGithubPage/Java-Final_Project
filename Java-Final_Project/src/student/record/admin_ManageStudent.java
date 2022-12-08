package student.record;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class admin_ManageStudent extends javax.swing.JFrame {

    public admin_ManageStudent() {
        initComponents();
        display_personal_information();
    }
    PreparedStatement ps;
    ResultSet rs;

    public boolean checkAcademic(String academic) {
        boolean checkUser = false;
        String query2 = "SELECT * FROM `academic_level` WHERE `academicDescription` = ?";
        try {
            ps = StudentRecord.getConnection().prepareStatement(query2);
            ps.setString(1, academic);
            rs = ps.executeQuery();
            {
                if (rs.next()) {
                    checkUser = true;
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return checkUser;
    }
    public boolean checkCourse(String courseCode) {
        boolean checkUser = false;
        String query = "SELECT * FROM `tblcourses` WHERE `courseCode` = ?";
        try {
            ps = StudentRecord.getConnection().prepareStatement(query);
            ps.setString(1, courseCode);
            rs = ps.executeQuery();
            {
                if (rs.next()) {
                    checkUser = true;
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return checkUser;
    }

    public void display_personal_information() {
        int u;
        String query = "SELECT student_info.studentId, student_info.studentName, student_info.dateOfBirth, student_info.age, student_info.address, student_info.status,tblcourses.courseCode, academic_level.academicDescription, student_info.emailAddress, student_info.contactNumber, student_info.emergencyName, student_info.emergencyNumber, student_info.MG, student_info.FG FROM academic_level INNER JOIN student_info ON student_info.academicId = academic_level.academicId INNER JOIN tblcourses ON student_info.courseId = tblcourses.courseId";
        try {
            ps = StudentRecord.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            ResultSetMetaData Rss = rs.getMetaData();
            u = Rss.getColumnCount();
            DefaultTableModel df = (DefaultTableModel) studentInformation.getModel();
            df.setRowCount(0);
            while (rs.next()) {
                Vector v2 = new Vector();
                for (int a = 1; a <= u; a++) {
                    v2.add(rs.getString("studentId"));
                    v2.add(rs.getString("studentName"));
                    v2.add(rs.getString("dateOfBirth"));
                    v2.add(rs.getString("age"));
                    v2.add(rs.getString("address"));
                    v2.add(rs.getString("status"));
                    v2.add(rs.getString("emailAddress"));
                    v2.add(rs.getString("academicDescription"));
                    v2.add(rs.getString("courseCode"));
                    v2.add(rs.getString("contactNumber"));
                    v2.add(rs.getString("emergencyName"));
                    v2.add(rs.getString("emergencyNumber"));
                    v2.add(rs.getString("MG"));
                    v2.add(rs.getString("FG"));
                }
                df.addRow(v2);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "Error in Viewing Course Table");
        }
    }
   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        User = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        studentName = new javax.swing.JTextField();
        age = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        status = new javax.swing.JTextField();
        course = new javax.swing.JTextField();
        academicLevel = new javax.swing.JTextField();
        emailAddress = new javax.swing.JTextField();
        contactNumber = new javax.swing.JTextField();
        emergencyName = new javax.swing.JTextField();
        emergencyNumber = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        dateOfBirth = new com.toedter.calendar.JDateChooser();
        MG = new javax.swing.JTextField();
        jlabelgrades = new javax.swing.JLabel();
        jlabelgrades1 = new javax.swing.JLabel();
        FG = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentInformation = new javax.swing.JTable();
        reset = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        deleteButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 61, 167));
        jPanel1.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/record/srms logo yellow.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 10, 90, 70);

        User.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
        User.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(User);
        User.setBounds(230, 40, 210, 30);

        id.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        id.setForeground(new java.awt.Color(0, 61, 167));
        id.setText("Student's Name: ");
        jPanel1.add(id);
        id.setBounds(120, 20, 102, 18);

        jLabel16.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("HELLO MR/MS: ");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(120, 40, 100, 30);

        jPanel2.setBackground(new java.awt.Color(253, 184, 19));
        jPanel2.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(49, 115, 214));

        studentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentNameActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Student's Name: ");

        jLabel5.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Date of Birth: ");

        jLabel6.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Age:");

        jLabel7.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Address:");

        jLabel8.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Status:");

        jLabel9.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Course: ");

        jLabel10.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Academic Name:");

        jLabel11.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Contact Number: ");

        jLabel12.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Emergency Name: ");

        jLabel13.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Emergency No. : ");

        jLabel14.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Email Address: ");

        jlabelgrades.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        jlabelgrades.setForeground(new java.awt.Color(255, 255, 255));
        jlabelgrades.setText("MG");

        jlabelgrades1.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        jlabelgrades1.setForeground(new java.awt.Color(255, 255, 255));
        jlabelgrades1.setText("FG");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(studentName, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(course, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(academicLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emergencyNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(emergencyName, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(contactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(emailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(age)
                                    .addComponent(dateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jlabelgrades)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jlabelgrades1)
                                .addGap(9, 9, 9)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(FG)
                            .addComponent(MG, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))))
                .addGap(501, 501, 501))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(dateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(course, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(academicLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emergencyName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emergencyNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabelgrades))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabelgrades1))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3);
        jPanel3.setBounds(20, 30, 450, 380);

        studentInformation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Student ID", "Student name", "Date of Birth", "Age", "Address", "Status", "Email Address", "Academic Level", "Course", "Contact Number", "Emergency Name", "Emergency Number", "MG", "FG"
            }
        ));
        studentInformation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentInformationMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(studentInformation);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4);
        jPanel4.setBounds(490, 40, 690, 400);

        reset.setBackground(new java.awt.Color(0, 61, 167));
        reset.setFont(new java.awt.Font(".SF NS Text", 1, 13)); // NOI18N
        reset.setForeground(new java.awt.Color(255, 255, 255));
        reset.setText("RESET");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        jPanel2.add(reset);
        reset.setBounds(380, 430, 90, 25);

        addButton.setBackground(new java.awt.Color(0, 61, 167));
        addButton.setFont(new java.awt.Font(".SF NS Text", 1, 13)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        jPanel2.add(addButton);
        addButton.setBounds(40, 430, 72, 25);

        updateButton.setBackground(new java.awt.Color(0, 61, 167));
        updateButton.setFont(new java.awt.Font(".SF NS Text", 1, 13)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        jPanel2.add(updateButton);
        updateButton.setBounds(140, 430, 90, 25);

        jLabel15.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel15.setText("STUDENT'S INFORMATION");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(490, 20, 190, 19);

        deleteButton1.setBackground(new java.awt.Color(0, 61, 167));
        deleteButton1.setFont(new java.awt.Font(".SF NS Text", 1, 13)); // NOI18N
        deleteButton1.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton1.setText("DELETE");
        deleteButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(deleteButton1);
        deleteButton1.setBounds(260, 430, 90, 25);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void studentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentNameActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed

    }//GEN-LAST:event_resetActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        String Studentname = studentName.getText();
        String Dateofbirth = dateFormat.format(dateOfBirth.getDate());
        String Age = age.getText();
        String Address = address.getText();
        String Status = status.getText();
        String Course = course.getText();
        String Academiclevel = academicLevel.getText();
        String Emailaddress = emailAddress.getText();
        String Contactnumber = contactNumber.getText();
        String Emergencyname = emergencyName.getText();
        String Emergencynumber = emergencyNumber.getText();
        String mg = MG.getText();
        String fg =FG.getText();
        String query = "SELECT * FROM `tblcourses` WHERE `courseCode` = ?";  
        try {
            if (checkCourse(Course)) {
                ps = StudentRecord.getConnection().prepareStatement(query);
                ps.setString(1, Course);
                rs = ps.executeQuery();
                if (rs.next()) {
                    String courseID = rs.getString(1);
                    if (checkAcademic(Academiclevel)) {
                        String academicId = rs.getString(1);
                        String query1 = "UPDATE student_info SET studentName=?, dateOfBirth=?, age=?, address=?,  status=?, emailAddress=?,  contactNumber=?, emergencyName=?, emergencyNumber=?, courseId=?, academicId=?, MG=?, FG=? WHERE studentId=?";
                         int row = studentInformation.getSelectedRow();
                        String value = (studentInformation.getModel().getValueAt(row, 0).toString());
                        ps = StudentRecord.getConnection().prepareStatement(query1);
                        ps.setString(1, Studentname);
                        ps.setString(2, Dateofbirth);
                        ps.setString(3, Age);
                        ps.setString(4, Address);
                        ps.setString(5, Status);
                        ps.setString(6, Emailaddress);
                        ps.setString(7, Contactnumber);
                        ps.setString(8, Emergencyname);
                        ps.setString(9, Emergencynumber);
                        ps.setString(10, courseID);
                        ps.setString(11, academicId);
                        ps.setString(12, mg);
                        ps.setString(13,fg);
                        ps.setString(14,value);
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Student information Updated succesfully!");
                        display_personal_information();
                    } else {
                        JOptionPane.showMessageDialog(this, "Academic Name doesn't found!");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Not in Database!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Course Doesnt found!");
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_updateButtonActionPerformed
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String Studentname = studentName.getText();
        String Dateofbirth = dateFormat.format(dateOfBirth.getDate());
        String Age = age.getText();
        String Address = address.getText();
        String Status = status.getText();
        String Course = course.getText();
        String Academiclevel = academicLevel.getText();
        String Emailaddress = emailAddress.getText();
        String Contactnumber = contactNumber.getText();
        String Emergencyname = emergencyName.getText();
        String Emergencynumber = emergencyNumber.getText();
        String mg = MG.getText();
        String fg =FG.getText();
        String query = "SELECT * FROM `tblcourses` WHERE `courseCode` = ?";
        try {
            if (checkCourse(Course)) {
                ps = StudentRecord.getConnection().prepareStatement(query);
                ps.setString(1, Course);
                rs = ps.executeQuery();
                if (rs.next()) {
                    String courseID = rs.getString(1);
                    if (checkAcademic(Academiclevel)) {
                        String academicId = rs.getString(1);
                        String query2 = "INSERT INTO student_info(studentName, dateOfBirth, age, address, status, emailAddress, contactNumber, emergencyName, emergencyNumber, courseId, academicId,MG,FG) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
                        ps = StudentRecord.getConnection().prepareStatement(query2);
                        ps.setString(1, Studentname);
                        ps.setString(2, Dateofbirth);
                        ps.setString(3, Age);
                        ps.setString(4, Address);
                        ps.setString(5, Status);
                        ps.setString(6, Emailaddress);
                        ps.setString(7, Contactnumber);
                        ps.setString(8, Emergencyname);
                        ps.setString(9, Emergencynumber);
                        ps.setString(10, courseID);
                        ps.setString(11, academicId);
                        ps.setString(12, mg);
                        ps.setString(13,fg);
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Student information add succesfully!");
                        display_personal_information();
                    } else {
                        JOptionPane.showMessageDialog(this, "Academic Name doesn't found!");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Not in Database!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Course Doesnt found!");
            }
//            //INNER JOIN tblcourses ON tblcourses.courseId = student_grades.courseId INNER JOIN academic_level ON academic_level.academicId = student_grades.academicId   
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void deleteButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton1ActionPerformed
        String ID = id.getText();
        try {
           String query = "DELETE FROM `student_info` WHERE `studentId`=?";
           ps = StudentRecord.getConnection().prepareStatement(query);
           ps.setString(1,ID);
           ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deleted Successfully");
            display_personal_information();
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_deleteButton1ActionPerformed

    private void studentInformationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentInformationMouseClicked
        DefaultTableModel model = (DefaultTableModel) studentInformation.getModel();
        int myIndex = studentInformation.getSelectedRow();
        id.setText(model.getValueAt(myIndex, 0).toString());
        studentName.setText(model.getValueAt(myIndex, 1).toString());
        try {
            int Myindex = studentInformation.getSelectedRow();
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(Myindex, 2).toString());
            dateOfBirth.setDate(date);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Unidentified Date of Birth");
        }
        age.setText(model.getValueAt(myIndex, 3).toString());
        address.setText(model.getValueAt(myIndex, 4).toString());
        status.setText(model.getValueAt(myIndex, 5).toString());
        course.setText(model.getValueAt(myIndex, 8).toString());
        academicLevel.setText(model.getValueAt(myIndex, 7).toString());
        emailAddress.setText(model.getValueAt(myIndex, 6).toString());
        contactNumber.setText(model.getValueAt(myIndex, 9).toString());
        emergencyName.setText(model.getValueAt(myIndex, 10).toString());
         emergencyNumber.setText(model.getValueAt(myIndex, 11).toString());
         MG.setText(model.getValueAt(myIndex, 12).toString());
         FG.setText(model.getValueAt(myIndex, 13).toString());
    }//GEN-LAST:event_studentInformationMouseClicked

    /**
     * @param args the command line arguments
     */
    //VALUES('chemuelkol',12-13-20,22,'can-avid','single','ch@gmail.com',094849123,'akol',82929,1,'C CT')
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(admin_ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin_ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin_ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin_ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_ManageStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FG;
    private javax.swing.JTextField MG;
    public javax.swing.JLabel User;
    private javax.swing.JTextField academicLevel;
    private javax.swing.JButton addButton;
    private javax.swing.JTextField address;
    private javax.swing.JTextField age;
    private javax.swing.JTextField contactNumber;
    private javax.swing.JTextField course;
    private com.toedter.calendar.JDateChooser dateOfBirth;
    private javax.swing.JButton deleteButton1;
    private javax.swing.JTextField emailAddress;
    private javax.swing.JTextField emergencyName;
    private javax.swing.JTextField emergencyNumber;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlabelgrades;
    private javax.swing.JLabel jlabelgrades1;
    private javax.swing.JButton reset;
    private javax.swing.JTextField status;
    private javax.swing.JTable studentInformation;
    private javax.swing.JTextField studentName;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
