package student.record;

import java.awt.HeadlessException;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class admin_ManageTeacher extends javax.swing.JFrame {

    /**
     * Creates new form admin_ManageTeacher
     */
    public admin_ManageTeacher() {
        initComponents();
        this.setLocationRelativeTo(null);
        display_personal_information();
    }
    PreparedStatement ps;
    ResultSet rs;

    public void reset(){
        email.setText("");
        password.setText("");
        name.setText("");
        age.setText("");
        address.setText("");
        status.setText("");
        degreeFinished.setText("");
        emailAddress.setText("");
        contactNumber.setText("");
        emergencyName.setText("");
        emergencyNumber.setText("");
        courseHandled.setText("");
        id.setText("");
        dateOfBirth.setCalendar(null);
    }

    public String getId(String id) {
        String userID = null;
        String get_id_query = "SELECT `userId` FROM `teacher_info` WHERE teacherId =?";
        try {
            ps = StudentRecord.getConnection().prepareStatement(get_id_query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                userID = rs.getString(1);
            } else {
                userID = "No such an ID";
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return userID;
    }

    public boolean checkUser(String userEmail) {
        boolean checkUser = false;
        String query2 = "SELECT * FROM `users_info` WHERE `userEmail` = ?";
        try {
            ps = StudentRecord.getConnection().prepareStatement(query2);
            ps.setString(1, userEmail);
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
        String query = "SELECT * FROM `teacher_info`";
        try {
            ps = StudentRecord.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            ResultSetMetaData Rss = rs.getMetaData();
            u = Rss.getColumnCount();
            DefaultTableModel df = (DefaultTableModel) teacherInformation.getModel();
            df.setRowCount(0);
            while (rs.next()) {
                Vector v2 = new Vector();
                for (int a = 1; a <= u; a++) {
                    v2.add(rs.getString("teacherId"));
                    v2.add(rs.getString("teacherName"));
                    v2.add(rs.getString("dateOfBirth"));
                    v2.add(rs.getString("age"));
                    v2.add(rs.getString("address"));
                    v2.add(rs.getString("status"));
                    v2.add(rs.getString("degreeFinished"));
                    v2.add(rs.getString("emailAddress"));
                    v2.add(rs.getString("contactNumber"));
                    v2.add(rs.getString("emergencyName"));
                    v2.add(rs.getString("emergencyNumber"));
                    v2.add(rs.getString("courseHandled"));
                }
                df.addRow(v2);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "Error in Viewing Course Table");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        logout = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        id = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        name = new javax.swing.JTextField();
        age = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        status = new javax.swing.JTextField();
        degreeFinished = new javax.swing.JTextField();
        emailAddress = new javax.swing.JTextField();
        contactNumber = new javax.swing.JTextField();
        emergencyName = new javax.swing.JTextField();
        emergencyNumber = new javax.swing.JTextField();
        courseHandled = new javax.swing.JTextField();
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
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        dateOfBirth = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        teacherInformation = new javax.swing.JTable();
        deleteButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        RESET = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 61, 167));
        jPanel1.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/record/srms logo yellow.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 10, 90, 70);

        jLabel2.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("MANAGE TEACHERS");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(120, 40, 190, 24);

        logout.setBackground(new java.awt.Color(255, 51, 0));
        logout.setText("LOG OUT");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        jPanel1.add(logout);
        logout.setBounds(880, 10, 90, 23);

        exit.setBackground(new java.awt.Color(255, 51, 0));
        exit.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        exit.setText("X");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jPanel1.add(exit);
        exit.setBounds(980, 10, 40, 30);

        id.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        id.setForeground(new java.awt.Color(0, 61, 167));
        id.setText("Email");
        jPanel1.add(id);
        id.setBounds(130, 20, 100, 18);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 96));

        jPanel2.setBackground(new java.awt.Color(253, 184, 19));
        jPanel2.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(49, 115, 214));

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Name: ");

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
        jLabel9.setText("Degree Finished: ");

        jLabel10.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Email Address: ");

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
        jLabel14.setText("Course Handled:");

        jLabel17.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Email");

        jLabel18.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Password");

        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("PERSONAL INFORMATION");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(courseHandled, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emergencyNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(degreeFinished, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emergencyName, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel19)))
                .addGap(347, 347, 347))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                    .addComponent(degreeFinished, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
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
                    .addComponent(courseHandled, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18))
        );

        jPanel2.add(jPanel3);
        jPanel3.setBounds(40, 10, 380, 410);

        teacherInformation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Teacher Id", "Teacher Name", "Date of Birth", "Age", "Address", "Status", "Degree Finished", "Email Address", "Contact Number", "Emergency Name", "Emergency No.", "Course Handled"
            }
        ));
        teacherInformation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teacherInformationMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(teacherInformation);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4);
        jPanel4.setBounds(440, 40, 580, 380);

        deleteButton.setBackground(new java.awt.Color(0, 61, 167));
        deleteButton.setFont(new java.awt.Font(".SF NS Text", 1, 13)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jPanel2.add(deleteButton);
        deleteButton.setBounds(230, 430, 90, 25);

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
        updateButton.setBounds(130, 430, 90, 25);

        jLabel16.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel16.setText("TEACHER'S INFORMATION");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(440, 20, 190, 19);

        RESET.setBackground(new java.awt.Color(0, 61, 167));
        RESET.setFont(new java.awt.Font(".SF NS Text", 1, 13)); // NOI18N
        RESET.setForeground(new java.awt.Color(255, 255, 255));
        RESET.setText("RESET");
        RESET.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RESETActionPerformed(evt);
            }
        });
        jPanel2.add(RESET);
        RESET.setBounds(330, 430, 90, 25);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1040, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        String ID = id.getText();
        String Email = email.getText();
        try {
            if (checkUser(Email)) {
                String userId = rs.getString(1);
                String DELETE_FROM_TEACHER = "DELETE FROM `teacher_info` WHERE `teacherId`=?";
                ps = StudentRecord.getConnection().prepareStatement(DELETE_FROM_TEACHER);
                ps.setString(1, ID);
                int i = ps.executeUpdate();
                if (i > 0) {
                    String DELETE_FROM_USER = "DELETE FROM `users_info` WHERE `userId`=?";
                    ps = StudentRecord.getConnection().prepareStatement(DELETE_FROM_USER);
                    ps.setString(1, userId);
                    JOptionPane.showMessageDialog(null, "Deleted Successfully");
                    display_personal_information();
                    reset();
                }
            }
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        try {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String Email = email.getText();
            String Password = password.getText();
            String Teachername = name.getText();
            String Dateofbirth = dateFormat.format(dateOfBirth.getDate());
            String Age = age.getText();
            String Address = address.getText();
            String Status = status.getText();
            String Degreefinished = degreeFinished.getText();
            String Emailaddress = emailAddress.getText();
            String Contactnumber = contactNumber.getText();
            String Emergencyname = emergencyName.getText();
            String Emergencynumber = emergencyNumber.getText();
            String Coursehandled = courseHandled.getText();
            String IDs = getId(id.getText());
            if (Email.equals("") | Password.equals("") | Teachername.equals("") | Dateofbirth == null | Age.equals("") | Address.equals("") | Status.equals("") | Degreefinished.equals("") | Emailaddress.equals("") | Contactnumber.equals("") | Emergencyname.equals("") | Emergencynumber.equals("") | Coursehandled.equals("")) {
                JOptionPane.showMessageDialog(this, "Please Field up the required information!");
            } else {
                String UPDATE_users_info = "UPDATE users_info SET userEmail=?, userPassword=?, roleId=? WHERE userId=?";
                ps = StudentRecord.getConnection().prepareStatement(UPDATE_users_info);
                ps.setString(1, Email);
                ps.setString(2, Password);
                ps.setString(3, "2");
                ps.setString(4, IDs);
                int i = ps.executeUpdate();
                if (i > 0) {
                    String UPDATE_teachers_info = "UPDATE teacher_info SET teacherName=?, dateOfBirth=?, age=?, address=?, status=?, degreeFinished=?, emailAddress=?, contactNumber=?, emergencyName=?, emergencyNumber=?, courseHandled=? WHERE teacherId=?";
                    int row = teacherInformation.getSelectedRow();
                    String value = (teacherInformation.getModel().getValueAt(row, 0).toString());
                    ps = StudentRecord.getConnection().prepareStatement(UPDATE_teachers_info);
                    ps.setString(1, Teachername);
                    ps.setString(2, Dateofbirth);
                    ps.setString(3, Age);
                    ps.setString(4, Address);
                    ps.setString(5, Status);
                    ps.setString(6, Degreefinished);
                    ps.setString(7, Emailaddress);
                    ps.setString(8, Contactnumber);
                    ps.setString(9, Emergencyname);
                    ps.setString(10, Emergencynumber);
                    ps.setString(11, Coursehandled);
                    ps.setString(12, value);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Teacher information Update succesfully!");
                    display_personal_information();
                    reset();
                }
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        logIn Login = new logIn();
        Login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        adminDashboard admin = new adminDashboard();
        admin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed

    }//GEN-LAST:event_emailActionPerformed

    private void teacherInformationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teacherInformationMouseClicked
        DefaultTableModel model = (DefaultTableModel) teacherInformation.getModel();
        int myIndex = teacherInformation.getSelectedRow();
        id.setText(model.getValueAt(myIndex, 0).toString());
        name.setText(model.getValueAt(myIndex, 1).toString());
        try {
            int Myindex = teacherInformation.getSelectedRow();
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(Myindex, 2).toString());
            dateOfBirth.setDate(date);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Unidentified Date of Birth");
        }
        age.setText(model.getValueAt(myIndex, 3).toString());
        address.setText(model.getValueAt(myIndex, 4).toString());
        status.setText(model.getValueAt(myIndex, 5).toString());
        degreeFinished.setText(model.getValueAt(myIndex, 6).toString());
        emailAddress.setText(model.getValueAt(myIndex, 7).toString());
        contactNumber.setText(model.getValueAt(myIndex, 8).toString());
        emergencyName.setText(model.getValueAt(myIndex, 9).toString());
        emergencyNumber.setText(model.getValueAt(myIndex, 10).toString());
        courseHandled.setText(model.getValueAt(myIndex, 11).toString());
        try {
            String ID = getId(id.getText());
            String SELECT_USER_QUERY = "SELECT users_info.userEmail, users_info.userPassword FROM users_info INNER JOIN teacher_info ON teacher_info.userId = users_info.userId WHERE teacher_info.userId = ?";
            ps = StudentRecord.getConnection().prepareStatement(SELECT_USER_QUERY);
            ps.setString(1, ID);
            rs = ps.executeQuery();
            if (rs.next()) {
                email.setText(rs.getString(1));
                password.setText(rs.getString(2));
            } else {
                JOptionPane.showMessageDialog(this, "Error in Finding users");
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Error in Finding users" + e);
        }
    }//GEN-LAST:event_teacherInformationMouseClicked

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        try {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String Email = email.getText();
            String Password = password.getText();
            String Teachername = name.getText();
            String Dateofbirth = dateFormat.format(dateOfBirth.getDate());
            String Age = age.getText();
            String Address = address.getText();
            String Status = status.getText();
            String Degreefinished = degreeFinished.getText();
            String Emailaddress = emailAddress.getText();
            String Contactnumber = contactNumber.getText();
            String Emergencyname = emergencyName.getText();
            String Emergencynumber = emergencyNumber.getText();
            String Coursehandled = courseHandled.getText();
            if (Email.equals("") | Password.equals("") | Teachername.equals("") | Dateofbirth == null | Age.equals("") | Address.equals("") | Status.equals("") | Degreefinished.equals("") | Emailaddress.equals("") | Contactnumber.equals("") | Emergencyname.equals("") | Emergencynumber.equals("") | Coursehandled.equals("")) {
                JOptionPane.showMessageDialog(this, "Please Field up the required information!");
            } else {
                String query2 = "INSERT INTO users_info(userEmail, userPassword, roleId) VALUES(?,?,?)";
                ps = StudentRecord.getConnection().prepareStatement(query2);
                ps.setString(1, Email);
                ps.setString(2, Password);
                ps.setString(3, "2");
                int i = ps.executeUpdate();
                if (i > 0) {
                    if (checkUser(Email)) {
                        String userId = rs.getString(1);
                        String query3 = "INSERT INTO teacher_info(teacherName, dateOfBirth, age, address, status, degreeFinished, emailAddress, contactNumber, emergencyName, emergencyNumber, courseHandled, userId) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
                        ps = StudentRecord.getConnection().prepareStatement(query3);
                        ps.setString(1, Teachername);
                        ps.setString(2, Dateofbirth);
                        ps.setString(3, Age);
                        ps.setString(4, Address);
                        ps.setString(5, Status);
                        ps.setString(6, Degreefinished);
                        ps.setString(7, Emailaddress);
                        ps.setString(8, Contactnumber);
                        ps.setString(9, Emergencyname);
                        ps.setString(10, Emergencynumber);
                        ps.setString(11, Coursehandled);
                        ps.setString(12, userId);
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Teacher information add succesfully!");
                        display_personal_information();
                        reset();
                    } else {
                        JOptionPane.showMessageDialog(this, "Error in adding Student Information!");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Error in adding Student Information!");
                }
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void RESETActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RESETActionPerformed
        reset();
    }//GEN-LAST:event_RESETActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(admin_ManageTeacher.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin_ManageTeacher.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin_ManageTeacher.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin_ManageTeacher.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_ManageTeacher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RESET;
    private javax.swing.JButton addButton;
    private javax.swing.JTextField address;
    private javax.swing.JTextField age;
    private javax.swing.JTextField contactNumber;
    private javax.swing.JTextField courseHandled;
    private com.toedter.calendar.JDateChooser dateOfBirth;
    private javax.swing.JTextField degreeFinished;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField email;
    private javax.swing.JTextField emailAddress;
    private javax.swing.JTextField emergencyName;
    private javax.swing.JTextField emergencyNumber;
    private javax.swing.JButton exit;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JButton logout;
    private javax.swing.JTextField name;
    private javax.swing.JTextField password;
    private javax.swing.JTextField status;
    private javax.swing.JTable teacherInformation;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
