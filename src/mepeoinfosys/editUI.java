package mepeoinfosys;



import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


public class editUI extends javax.swing.JFrame {

    public String selectedUI;
    public String selectedYear;
    public infoUI infoUI;
    public Connection cn;
    public Statement st;
    public editUI(String id,String company,String dr,String nom,String permanent,String parttime,String sq,String remarks) {
      
        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        initComponents();
        
        setLocationRelativeTo(null);
        idField.setEditable(false);
        idField.setText(id);
        companyField.setText(company);
        drField.setText(dr);
        nomField.setText(nom);
        if(permanent.equals("")){
            populatePPList2();
        }
        else if(parttime.equals("")){
            populatePPList1();
        }
        sqField.setText(sq);
        remarksField.setText(remarks);

        

        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        usertxt = new javax.swing.JTextField();
        loginButton = new javax.swing.JButton();
        passtxt = new javax.swing.JPasswordField();
        jPanel5 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        drField = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        companyField = new javax.swing.JTextField();
        nomField = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        sqField = new javax.swing.JTextField();
        remarksField = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        ppList = new javax.swing.JComboBox<>();
        confirmButton = new javax.swing.JButton();
        idField = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));
        jPanel1.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MGB-CAR");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Information System");

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Username:");

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password:");

        usertxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usertxtActionPerformed(evt);
            }
        });

        loginButton.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        passtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passtxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(loginButton)
                        .addGap(118, 118, 118))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(passtxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                    .addComponent(usertxt, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(56, 56, 56))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(usertxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(passtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(loginButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EDIT INFORMATION");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel27.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(6, 26, 64));
        jLabel27.setText("Edit Information");

        jPanel3.setBackground(new java.awt.Color(6, 26, 64));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Company");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 60, -1, -1));

        drField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drFieldActionPerformed(evt);
            }
        });
        jPanel3.add(drField, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 109, 216, 31));

        jLabel18.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Date Registered");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 109, -1, -1));

        companyField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                companyFieldActionPerformed(evt);
            }
        });
        jPanel3.add(companyField, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 60, 216, 31));

        nomField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomFieldActionPerformed(evt);
            }
        });
        jPanel3.add(nomField, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 158, 216, 31));

        jLabel19.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Name of Mepeo");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 158, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Permanent/Part-Time");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 207, -1, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Submitted Qualifications");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        sqField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqFieldActionPerformed(evt);
            }
        });
        jPanel3.add(sqField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 216, 31));

        remarksField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remarksFieldActionPerformed(evt);
            }
        });
        jPanel3.add(remarksField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 216, 31));

        jLabel22.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Remarks");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, -1, -1));

        jPanel4.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 256, -1, -1));

        ppList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(ppList, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 207, 216, 31));

        confirmButton.setBackground(new java.awt.Color(6, 26, 64));
        confirmButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        confirmButton.setForeground(new java.awt.Color(255, 255, 255));
        confirmButton.setText("Update");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });
        jPanel3.add(confirmButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, 105, -1));

        idField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFieldActionPerformed(evt);
            }
        });
        jPanel3.add(idField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 34, 30));

        cancelButton.setBackground(new java.awt.Color(6, 26, 64));
        cancelButton.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        jPanel3.add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 10, 100, -1));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabel27)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 468));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usertxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usertxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usertxtActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
   

    }//GEN-LAST:event_loginButtonActionPerformed

    private void passtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passtxtActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        infoUI = new infoUI();
        infoUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mepeoinfotable","root","");
            st=cn.createStatement();
            String sql = "UPDATE mepeotable SET company = ?, date_registered = ?, name_of_mepeo = ?, "
                    + "permanent = ?, parttime = ?, submitted_qualifications = ?, remarks = ? WHERE `ID` = ?";

            PreparedStatement pst = cn.prepareStatement(sql);
            if(ppList.getSelectedItem().equals("Permanent")){
                pst.setString(1, companyField.getText());
                pst.setString(2, drField.getText());
                pst.setString(3, nomField.getText());
                pst.setString(4, (String) ppList.getSelectedItem());
                pst.setString(5, "");
                pst.setString(6, sqField.getText());
                pst.setString(7, remarksField.getText());
                pst.setString(8, idField.getText());
                
            }else{
                pst.setString(1, companyField.getText());
                pst.setString(2, drField.getText());
                pst.setString(3, nomField.getText());
                pst.setString(4, "");
                pst.setString(5, (String) ppList.getSelectedItem());
                pst.setString(6, sqField.getText());
                pst.setString(7, remarksField.getText());
                pst.setString(8, idField.getText());
            }

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Info edited successfully");

            infoUI infoUI = new infoUI();
            infoUI.setVisible(true);
            this.dispose();
            st.close();
            cn.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_confirmButtonActionPerformed
    private void populatePPList1(){
        ppList.removeAllItems();
        ppList.addItem("Permanent");
        ppList.addItem("Part-time");
    }
    private void populatePPList2(){
        ppList.removeAllItems();
        ppList.addItem("Part-time");
        ppList.addItem("Permanent");
    }
    private void drFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_drFieldActionPerformed

    private void companyFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_companyFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_companyFieldActionPerformed

    private void nomFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomFieldActionPerformed

    private void sqFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sqFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sqFieldActionPerformed

    private void remarksFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remarksFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_remarksFieldActionPerformed

    private void idFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idFieldActionPerformed

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
            java.util.logging.Logger.getLogger(addUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new infoUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField companyField;
    private javax.swing.JButton confirmButton;
    private javax.swing.JTextField drField;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton loginButton;
    private javax.swing.JTextField nomField;
    private javax.swing.JPasswordField passtxt;
    private javax.swing.JComboBox<String> ppList;
    private javax.swing.JTextField remarksField;
    private javax.swing.JTextField sqField;
    private javax.swing.JTextField usertxt;
    // End of variables declaration//GEN-END:variables
}
