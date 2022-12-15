package student.record;

import java.awt.HeadlessException;
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
        this.setLocationRelativeTo(null);
    }

    private void users_update() {
        String i = id.getText();
        PreparedStatement ps;
        ResultSet rs;
        int u;
        String query = "SELECT tblcourses.courseCode, tblcourses.courseDescription, tblcourses.courseUnit, student_info.MG, student_info.FG "
                + "FROM student_info "
                + "INNER JOIN tblcourses ON student_info.courseId = tblcourses.courseId "
                + "WHERE student_info.studentId = ?";
        try {
            ps = StudentRecord.getConnection().prepareStatement(query);
            ps.setString(1, i);
            rs = ps.executeQuery();
            ResultSetMetaData Rss = rs.getMetaData();
            u = Rss.getColumnCount();
            DefaultTableModel df = (DefaultTableModel) studentTable.getModel();
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
            JOptionPane.showMessageDialog(this, "Error in Viewing Course Table");
        }
    }

    public void display_personal_information() {
        PreparedStatement ps;
        ResultSet rs;
        String i = id.getText();
        String query = "SELECT student_info.studentName, student_info.dateOfBirth, student_info.age, student_info.address, "
                + "student_info.status, tblcourses.courseCode, academic_level.academicDescription, student_info.emailAddress, "
                + "student_info.contactNumber, student_info.emergencyName, student_info.emergencyNumber, tblcourses.courseDescription, "
                + "tblcourses.courseUnit, student_info.MG, student_info.FG FROM student_info INNER JOIN tblcourses ON student_info.courseId = tblcourses.courseId "
                + "INNER JOIN academic_level ON student_info.academicId = academic_level.academicId WHERE student_info.studentId =?";
        try {
            ps = StudentRecord.getConnection().prepareStatement(query);
            ps.setString(1, i);
            rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString(1);
                String Dateofbirth = rs.getString(2);
                String Age = rs.getString(3);
                String Address = rs.getString(4);
                String Status = rs.getString(5);
                String Course = rs.getString(6);
                String Academiclevel = rs.getString(7);
                String Email = rs.getString(8);
                String Contactnumber = rs.getString(9);
                String Emergencyname = rs.getString(10);
                String Emergencynumber = rs.getString(11);
                Completename.setText(name);
                DateOfBirth.setText(Dateofbirth);
                aGe.setText(Age);
                addRess.setText(Address);
                staTus.setText(Status);
                coUrse.setText(Course);
                AcademicLevel.setText(Academiclevel);
                email.setText(Email);
                contactNumbeR.setText(Contactnumber);
                emergencyName.setText(Emergencyname);
                emergencyNumber.setText(Emergencynumber);
            } else {
                System.out.println("Error in showing Student Information");
            }
        } catch (SQLException e) {
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
        logout = new javax.swing.JButton();
        exit = new javax.swing.JButton();
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
        emergencyName = new javax.swing.JTextField();
        emergencyNumber = new javax.swing.JTextField();
        contactNumber1 = new javax.swing.JLabel();
        contactNumber2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
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

        logout.setBackground(new java.awt.Color(255, 51, 0));
        logout.setText("LOG OUT");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        exit.setBackground(new java.awt.Color(255, 51, 0));
        exit.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        exit.setText("X");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))))
                    .addGroup(jpanelyellowLayout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addComponent(viewData)
                        .addGap(0, 474, Short.MAX_VALUE))))
        );
        jpanelyellowLayout.setVerticalGroup(
            jpanelyellowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelyellowLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jpanelyellowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpanelyellowLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jpanelyellowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(logout)
                            .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
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

        coUrse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coUrseActionPerformed(evt);
            }
        });

        academicLevel1.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        academicLevel1.setForeground(new java.awt.Color(255, 255, 255));
        academicLevel1.setText("Email:");

        emergencyName.setBackground(new java.awt.Color(0, 61, 167));
        emergencyName.setForeground(new java.awt.Color(255, 255, 255));

        emergencyNumber.setBackground(new java.awt.Color(0, 61, 167));
        emergencyNumber.setForeground(new java.awt.Color(255, 255, 255));
        emergencyNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emergencyNumberActionPerformed(evt);
            }
        });

        contactNumber1.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        contactNumber1.setForeground(new java.awt.Color(255, 255, 255));
        contactNumber1.setText("Mr/Ms:");

        contactNumber2.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        contactNumber2.setForeground(new java.awt.Color(255, 255, 255));
        contactNumber2.setText("in these number:");

        javax.swing.GroupLayout jpanelBlueLayout = new javax.swing.GroupLayout(jpanelBlue);
        jpanelBlue.setLayout(jpanelBlueLayout);
        jpanelBlueLayout.setHorizontalGroup(
            jpanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelBlueLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelBlueLayout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(contactNumber1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emergencyName, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
            .addGroup(jpanelBlueLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jpanelBlueLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jpanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelBlueLayout.createSequentialGroup()
                        .addComponent(contactNumber2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emergencyNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpanelBlueLayout.createSequentialGroup()
                        .addGroup(jpanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(contactNumber, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(academicLevel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(academicLevel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(course, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(status, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(address, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(age, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dateOfBirth, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(completeName, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jpanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(contactNumbeR, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(email)
                            .addComponent(DateOfBirth)
                            .addComponent(Completename)
                            .addComponent(aGe)
                            .addComponent(addRess)
                            .addComponent(staTus)
                            .addComponent(coUrse)
                            .addComponent(AcademicLevel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(38, 38, 38))))
        );
        jpanelBlueLayout.setVerticalGroup(
            jpanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelBlueLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addGroup(jpanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpanelBlueLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpanelBlueLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jpanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Completename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(completeName))
                        .addGap(8, 8, 8)
                        .addGroup(jpanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateOfBirth))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(aGe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(age))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addRess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(address))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(staTus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(status))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(coUrse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(course))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AcademicLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(academicLevel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(academicLevel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(contactNumbeR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contactNumber))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emergencyName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contactNumber1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(contactNumber2)
                            .addComponent(emergencyNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64))))
        );

        jpanelWhite.add(jpanelBlue);
        jpanelBlue.setBounds(10, 20, 320, 420);

        jPanel1.setBackground(new java.awt.Color(253, 184, 19));
        jPanel1.setLayout(null);

        studentTable.setFont(new java.awt.Font(".SF NS Text", 0, 10)); // NOI18N
        studentTable.setModel(new javax.swing.table.DefaultTableModel(
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
        studentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(studentTable);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 10, 630, 370);

        jpanelWhite.add(jPanel1);
        jPanel1.setBounds(350, 20, 650, 390);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpanelyellow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jpanelWhite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpanelyellow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpanelWhite, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void studentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentTableMouseClicked

    }//GEN-LAST:event_studentTableMouseClicked

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
        studentTable.setEnabled(false);
        emergencyName.setEditable(false);
        emergencyNumber.setEditable(false);
    }//GEN-LAST:event_formWindowActivated

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        logIn Login = new logIn();
        Login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void emergencyNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emergencyNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emergencyNumberActionPerformed

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
    private javax.swing.JLabel contactNumber1;
    private javax.swing.JLabel contactNumber2;
    private javax.swing.JLabel course;
    private javax.swing.JLabel dateOfBirth;
    private javax.swing.JTextField email;
    private javax.swing.JTextField emergencyName;
    private javax.swing.JTextField emergencyNumber;
    private javax.swing.JButton exit;
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
    private javax.swing.JButton logout;
    private javax.swing.JTextField staTus;
    private javax.swing.JLabel status;
    private javax.swing.JTable studentTable;
    private javax.swing.JButton viewData;
    // End of variables declaration//GEN-END:variables
}
