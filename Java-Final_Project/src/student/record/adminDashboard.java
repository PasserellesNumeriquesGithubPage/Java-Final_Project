package student.record;

public class adminDashboard extends javax.swing.JFrame {
    public adminDashboard() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        manageStudent_btn = new javax.swing.JButton();
        manageTeacher_btn = new javax.swing.JButton();
        logOut_btn = new javax.swing.JButton();
        manageAdmin = new javax.swing.JButton();
        manageAdmin1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(253, 184, 19));
        jPanel1.setLayout(null);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/record/srms logo blue.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 0, 90, 80);

        exit.setBackground(new java.awt.Color(255, 51, 0));
        exit.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        exit.setText("X");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jPanel1.add(exit);
        exit.setBounds(560, 10, 40, 30);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/record/admin logo.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(0, 40, 180, 190);

        jPanel3.setBackground(new java.awt.Color(0, 61, 167));

        manageStudent_btn.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        manageStudent_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/record/student icon.png"))); // NOI18N
        manageStudent_btn.setText("Manage Students");
        manageStudent_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageStudent_btnActionPerformed(evt);
            }
        });

        manageTeacher_btn.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        manageTeacher_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/record/teacher icon.png"))); // NOI18N
        manageTeacher_btn.setText("Manage Teachers");
        manageTeacher_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageTeacher_btnActionPerformed(evt);
            }
        });

        logOut_btn.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        logOut_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/record/log out icon.png"))); // NOI18N
        logOut_btn.setText("Log Out              ");
        logOut_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOut_btnActionPerformed(evt);
            }
        });

        manageAdmin.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        manageAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/record/teacher icon.png"))); // NOI18N
        manageAdmin.setText("Manage Admin");
        manageAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageAdminActionPerformed(evt);
            }
        });

        manageAdmin1.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        manageAdmin1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/record/teacher icon.png"))); // NOI18N
        manageAdmin1.setText("Manage Courses");
        manageAdmin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageAdmin1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(manageStudent_btn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(logOut_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(manageTeacher_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                        .addComponent(manageAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                        .addComponent(manageAdmin1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(manageStudent_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(manageTeacher_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(manageAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(manageAdmin1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(logOut_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logOut_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOut_btnActionPerformed
        logIn Login = new logIn();
        Login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logOut_btnActionPerformed

    private void manageStudent_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageStudent_btnActionPerformed
        admin_ManageStudent student = new admin_ManageStudent();
        student.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_manageStudent_btnActionPerformed

    private void manageTeacher_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageTeacher_btnActionPerformed
        admin_ManageTeacher teacher = new admin_ManageTeacher();
        teacher.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_manageTeacher_btnActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void manageAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageAdminActionPerformed
        admin_ManageAdmin admin = new admin_ManageAdmin();
        admin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_manageAdminActionPerformed

    private void manageAdmin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageAdmin1ActionPerformed
          admin_ManageCourse course = new admin_ManageCourse();
          course.setVisible(true);
          this.dispose();
    }//GEN-LAST:event_manageAdmin1ActionPerformed

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
            java.util.logging.Logger.getLogger(adminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton logOut_btn;
    private javax.swing.JButton manageAdmin;
    private javax.swing.JButton manageAdmin1;
    private javax.swing.JButton manageStudent_btn;
    private javax.swing.JButton manageTeacher_btn;
    // End of variables declaration//GEN-END:variables
}
