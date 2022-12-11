package student.record;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public final class admin_ManageStudent extends javax.swing.JFrame {

    public admin_ManageStudent() {
        initComponents();
        display_personal_information();
        this.setLocationRelativeTo(null);
    }

    PreparedStatement ps;
    ResultSet rs;

    public void reset() {
        studentName.setText("");
        dateOfBirth.setCalendar(null);
        age.setText("");
        address.setText("");
        status.setText("");
        course.setText("");
        academicLevel.setText("");
        emailAddress.setText("");
        contactNumber.setText("");
        emergencyName.setText("");
        emergencyNumber.setText("");
        MG.setText("");
        FG.setText("");
        email.setText("");
        password.setText("");
        teacher.setText("");
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

    public String getId(String id) {
        String userID = null;
        String get_id_query = "SELECT `usersId` FROM `student_info` WHERE studentId =?";
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

    public boolean checkTeacher(String teacherName) {
        boolean checkUser = false;
        String query = "SELECT * FROM `teacher_info` WHERE `teacherName` = ?";
        try {
            ps = StudentRecord.getConnection().prepareStatement(query);
            ps.setString(1, teacherName);
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
        id = new javax.swing.JLabel();
        User = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        logout = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        emailLabel = new javax.swing.JLabel();
        emailLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jlabelgrades = new javax.swing.JLabel();
        jlabelgrades1 = new javax.swing.JLabel();
        FG = new javax.swing.JTextField();
        MG = new javax.swing.JTextField();
        academicLevel = new javax.swing.JTextField();
        course = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        teacher = new javax.swing.JTextField();
        jlabelgrades2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        dateOfBirth = new com.toedter.calendar.JDateChooser();
        studentName = new javax.swing.JTextField();
        age = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        status = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        emailAddress = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        contactNumber = new javax.swing.JTextField();
        emergencyName = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        emergencyNumber = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentInformation = new javax.swing.JTable();
        reset = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        deleteButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

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

        id.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        id.setForeground(new java.awt.Color(0, 61, 167));
        id.setText("Student's Name: ");
        jPanel1.add(id);
        id.setBounds(120, 20, 104, 18);

        User.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        User.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(User);
        User.setBounds(220, 40, 120, 30);

        jLabel18.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("HELLO MR/MS: ");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(120, 40, 120, 30);

        logout.setBackground(new java.awt.Color(255, 51, 0));
        logout.setText("LOG OUT");
        logout.setBorderPainted(false);
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        jPanel1.add(logout);
        logout.setBounds(1040, 20, 90, 23);

        exit.setBackground(new java.awt.Color(255, 51, 0));
        exit.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        exit.setText("X");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jPanel1.add(exit);
        exit.setBounds(1140, 20, 40, 30);

        jPanel2.setBackground(new java.awt.Color(253, 184, 19));
        jPanel2.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(49, 115, 214));

        jTabbedPane1.setBackground(new java.awt.Color(49, 115, 214));

        jPanel5.setBackground(new java.awt.Color(49, 115, 214));

        emailLabel.setFont(new java.awt.Font("Helvetica", 1, 13)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(255, 255, 255));
        emailLabel.setText("Email");

        emailLabel1.setFont(new java.awt.Font("Helvetica", 1, 13)); // NOI18N
        emailLabel1.setForeground(new java.awt.Color(255, 255, 255));
        emailLabel1.setText("Password");

        jLabel12.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Course");

        jLabel13.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Academic Name");

        jlabelgrades.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        jlabelgrades.setForeground(new java.awt.Color(255, 255, 255));
        jlabelgrades.setText("MG");

        jlabelgrades1.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        jlabelgrades1.setForeground(new java.awt.Color(255, 255, 255));
        jlabelgrades1.setText("FG");

        jlabelgrades2.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        jlabelgrades2.setForeground(new java.awt.Color(255, 255, 255));
        jlabelgrades2.setText("Teacher");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jlabelgrades)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MG, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jlabelgrades2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(teacher, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(emailLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(course, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(emailLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(academicLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jlabelgrades1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FG, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel1)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(course, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(academicLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabelgrades))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabelgrades1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(teacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabelgrades2))
                .addGap(71, 71, 71))
        );

        jTabbedPane1.addTab("Account Info", jPanel5);

        jPanel6.setBackground(new java.awt.Color(49, 115, 214));

        jLabel5.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Date of Birth: ");

        studentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentNameActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Age:");

        jLabel7.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Address:");

        jLabel8.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Status:");

        jLabel19.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Email Address: ");

        jLabel14.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Contact Number: ");

        jLabel16.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Emergency Name: ");

        jLabel17.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Emergency No. : ");

        jLabel4.setFont(new java.awt.Font("Helvetica", 3, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Student's Name: ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emergencyNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentName, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emergencyName, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 47, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(studentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(dateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(contactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emergencyName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emergencyNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(79, 79, 79))))
        );

        jTabbedPane1.addTab("Personal Info", jPanel6);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
        );

        jPanel2.add(jPanel3);
        jPanel3.setBounds(30, 20, 440, 340);

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4);
        jPanel4.setBounds(490, 30, 690, 430);

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
        reset.setBounds(370, 400, 90, 25);

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
        addButton.setBounds(50, 400, 72, 25);

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
        updateButton.setBounds(150, 400, 90, 25);

        jLabel15.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel15.setText("STUDENT'S INFORMATION");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(490, 10, 190, 19);

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
        deleteButton1.setBounds(260, 400, 90, 25);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        reset();
    }//GEN-LAST:event_resetActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        try {
            dateOfBirth.setCalendar(Calendar.getInstance());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String Email = email.getText();
            String Password = password.getText();
            String Teacher = teacher.getText();
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
            String fg = FG.getText();
            String IDs = getId(id.getText());
            if (Email.equals("") | Password.equals("") | Teacher.equals("") | Studentname.equals("") | Dateofbirth == null | Age.equals("") | Address.equals("") | Status.equals("") | Emailaddress.equals("") | Contactnumber.equals("") | Emergencyname.equals("") | Emergencynumber.equals("")) {
                JOptionPane.showMessageDialog(this, "Please Field up the required information!");
            } else {
                String query_teacher = "SELECT * FROM `teacher_info` WHERE teacherName = ?";
                ps = StudentRecord.getConnection().prepareStatement(query_teacher);
                ps.setString(1, Teacher);
                rs = ps.executeQuery();
                if (rs.next()) {
                    String TeacherID = rs.getString(1);
                    String query_academic = "SELECT * FROM `academic_level` WHERE academicDescription = ?";
                    ps = StudentRecord.getConnection().prepareStatement(query_academic);
                    ps.setString(1, Academiclevel);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        String AcademicID = rs.getString(1);
                        String query_course = "SELECT * FROM `tblcourses` WHERE courseCode = ?";
                        ps = StudentRecord.getConnection().prepareStatement(query_course);
                        ps.setString(1, Course);
                        rs = ps.executeQuery();
                        if (rs.next()) {
                            String CourseId = rs.getString(1);
                            String query4 = "UPDATE users_info SET userEmail=?, userPassword=?, roleId=? WHERE userId=?";
                            ps = StudentRecord.getConnection().prepareStatement(query4);
                            ps.setString(1, Email);
                            ps.setString(2, Password);
                            ps.setString(3, "3");
                            ps.setString(4, IDs);
                            int i = ps.executeUpdate();
                            if (i > 0) {
                                String query5 = "UPDATE student_info SET studentName=?, dateOfBirth=?, age=?, address=?,  status=?, emailAddress=?,  contactNumber=?, emergencyName=?, emergencyNumber=?, usersId=?, courseId=?, academicId=?, teacherId=?,MG=?, FG=? WHERE studentId=?";
                                int row = studentInformation.getSelectedRow();
                                String value = (studentInformation.getModel().getValueAt(row, 0).toString());
                                ps = StudentRecord.getConnection().prepareStatement(query5);
                                ps.setString(1, Studentname);
                                ps.setString(2, Dateofbirth);
                                ps.setString(3, Age);
                                ps.setString(4, Address);
                                ps.setString(5, Status);
                                ps.setString(6, Emailaddress);
                                ps.setString(7, Contactnumber);
                                ps.setString(8, Emergencyname);
                                ps.setString(9, Emergencynumber);
                                ps.setString(10, IDs);
                                ps.setString(11, CourseId);
                                ps.setString(12, AcademicID);
                                ps.setString(13, TeacherID);
                                ps.setString(14, mg);
                                ps.setString(15, fg);
                                ps.setString(16, value);
                                ps.executeUpdate();
                                JOptionPane.showMessageDialog(this, "Student information Updated succesfully!");
                                display_personal_information();
                                reset();
                            } else {
                                JOptionPane.showMessageDialog(this, "Academic Name doesn't found!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Course Name doesn't found!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Academic Name doesn't found!");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Teacher Name doesn't found!");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_updateButtonActionPerformed
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        try {
            dateOfBirth.setCalendar(Calendar.getInstance());
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String Email = email.getText();
            String Password = password.getText();
            String Teacher = teacher.getText();
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
            String fg = FG.getText();
            String query = "SELECT * FROM `tblcourses` WHERE `courseCode` = ?";
            if (Email.equals("") | Password.equals("") | Teacher.equals("") | Studentname.equals("") | Dateofbirth == null | Age.equals("") | Address.equals("") | Status.equals("") | Emailaddress.equals("") | Contactnumber.equals("") | Emergencyname.equals("") | Emergencynumber.equals("")) {
                JOptionPane.showMessageDialog(this, "Please Field up the required information!");
            } else {
                if (checkTeacher(Teacher)) {
                    String teacherId = rs.getString(1);
                    ps = StudentRecord.getConnection().prepareStatement(query);
                    ps.setString(1, Course);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        String courseID = rs.getString(1);
                        if (checkAcademic(Academiclevel)) {
                            String academicId = rs.getString(1);
                            String query2 = "INSERT INTO users_info(userEmail, userPassword, roleId) VALUES(?,?,?)";
                            ps = StudentRecord.getConnection().prepareStatement(query2);
                            ps.setString(1, Email);
                            ps.setString(2, Password);
                            ps.setString(3, "3");
                            int i = ps.executeUpdate();
                            if (i > 0) {
                                if (checkUser(Email)) {
                                    String userId = rs.getString(1);
                                    String query3 = "INSERT INTO student_info(studentName, dateOfBirth, age, address, status, emailAddress, contactNumber, emergencyName, emergencyNumber, usersId, courseId, academicId, teacherId,MG,FG) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                                    ps = StudentRecord.getConnection().prepareStatement(query3);
                                    ps.setString(1, Studentname);
                                    ps.setString(2, Dateofbirth);
                                    ps.setString(3, Age);
                                    ps.setString(4, Address);
                                    ps.setString(5, Status);
                                    ps.setString(6, Emailaddress);
                                    ps.setString(7, Contactnumber);
                                    ps.setString(8, Emergencyname);
                                    ps.setString(9, Emergencynumber);
                                    ps.setString(10, userId);
                                    ps.setString(11, courseID);
                                    ps.setString(12, academicId);
                                    ps.setString(13, teacherId);
                                    ps.setString(14, mg);
                                    ps.setString(15, fg);
                                    ps.executeUpdate();
                                    JOptionPane.showMessageDialog(this, "Student information add succesfully!");
                                    //SELECT users_info.userEmail, users_info.userPassword, role_table.Role FROM users_info INNER JOIN role_table ON users_info.roleId = role_table.roleId;
                                    display_personal_information();
                                    reset();
                                } else {
                                    JOptionPane.showMessageDialog(this, "Error in adding Student Information!");
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, "Error in adding Student Information!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Error in adding Student Information!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Error in adding Student Information!");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Error in adding Student Information!");
                }
            }
//            //INNER JOIN tblcourses ON tblcourses.courseId = student_grades.courseId INNER JOIN academic_level ON academic_level.academicId = student_grades.academicId   
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void deleteButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton1ActionPerformed
        String ID = id.getText();
        String Email = email.getText();
        try {
            if (checkUser(Email)) {
                String userId = rs.getString(1);
                String query1 = "DELETE FROM `student_info` WHERE `studentId`=?";
                ps = StudentRecord.getConnection().prepareStatement(query1);
                ps.setString(1, ID);
                int i = ps.executeUpdate();
                if (i > 0) {
                    String query = "DELETE FROM `users_info` WHERE `userId`=?";
                    ps = StudentRecord.getConnection().prepareStatement(query);
                    ps.setString(1, userId);
                    JOptionPane.showMessageDialog(null, "Deleted Successfully");
                    display_personal_information();
                    reset();
                }
            }
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
        try {
            String query = "SELECT users_info.userEmail, users_info.userPassword, teacher_info.teacherName FROM student_info INNER JOIN teacher_info ON teacher_info.teacherId = student_info.teacherId INNER JOIN users_info ON users_info.userId = student_info.usersId WHERE student_info.studentId =?";
            ps = StudentRecord.getConnection().prepareStatement(query);
            ps.setString(1, id.getText());
            rs = ps.executeQuery();
            if (rs.next()) {
                email.setText(rs.getString(1));
                password.setText(rs.getString(2));
                teacher.setText(rs.getString(3));
            } else {
                JOptionPane.showMessageDialog(this, "Error in Finding users!");
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Error in Finding " + e);
        }
    }//GEN-LAST:event_studentInformationMouseClicked

    private void studentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentNameActionPerformed

    }//GEN-LAST:event_studentNameActionPerformed

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
    private javax.swing.JTextField email;
    private javax.swing.JTextField emailAddress;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel emailLabel1;
    private javax.swing.JTextField emergencyName;
    private javax.swing.JTextField emergencyNumber;
    private javax.swing.JButton exit;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel jlabelgrades;
    private javax.swing.JLabel jlabelgrades1;
    private javax.swing.JLabel jlabelgrades2;
    private javax.swing.JButton logout;
    private javax.swing.JTextField password;
    private javax.swing.JButton reset;
    private javax.swing.JTextField status;
    private javax.swing.JTable studentInformation;
    private javax.swing.JTextField studentName;
    private javax.swing.JTextField teacher;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
