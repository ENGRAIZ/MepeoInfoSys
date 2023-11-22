package mepeoinfosys;

public class ViewDetailsMepeo extends javax.swing.JFrame {

    public ViewDetailsMepeo(String id,String company,String dr,String nom,String permanent,String parttime,String sq,String eb,String we,String sw,String remarks) {
        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        initComponents();
        
        setLocationRelativeTo(null);
        companyField.setText(company);
        drField.setText("Date Registered: "+ dr);
        nomField.setText("Name of MEPEO Head: "+ nom);
        if(permanent.equals("")){
            ppField.setText("Permanent/Temporary: "+parttime);
        }else if(parttime.equals("")){
            ppField.setText("Permanent/Temporary: "+permanent);
        }
        sqField.setText("Submitted Qualifications: \n"+sq);
        ebField.setText("Educational Backgrounds: \n"+eb);
        weField.setText("Work Experience: \n"+we);
        swField.setText("Seminars and Workshop Attended: \n"+sw);
        remarksField.setText("Remarks: "+remarks);
            
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        companyField = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        nomField = new javax.swing.JLabel();
        drField = new javax.swing.JLabel();
        ppField = new javax.swing.JLabel();
        remarksField = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        swField = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        sqField = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        ebField = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        weField = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(6, 26, 64));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        companyField.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        companyField.setForeground(new java.awt.Color(6, 26, 64));
        companyField.setText("Company Name");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mepeoinfosys/close.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jLabel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(companyField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(companyField)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 26, 1050, -1));

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jPanel3.setFocusCycleRoot(true);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nomField.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        nomField.setForeground(new java.awt.Color(6, 26, 64));
        nomField.setText("Name of MEPEO Head");
        jPanel3.add(nomField, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 28, 872, -1));

        drField.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        drField.setForeground(new java.awt.Color(6, 26, 64));
        drField.setText("Date Registered");
        jPanel3.add(drField, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 79, 872, -1));

        ppField.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        ppField.setForeground(new java.awt.Color(6, 26, 64));
        ppField.setText("Permanent/Temporary");
        jPanel3.add(ppField, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 130, 872, -1));

        remarksField.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        remarksField.setForeground(new java.awt.Color(6, 26, 64));
        remarksField.setText("Remarks");
        jPanel3.add(remarksField, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 970, 872, -1));

        swField.setColumns(20);
        swField.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        swField.setRows(5);
        jScrollPane1.setViewportView(swField);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 770, 850, -1));

        sqField.setColumns(20);
        sqField.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        sqField.setRows(5);
        jScrollPane2.setViewportView(sqField);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 850, -1));

        ebField.setColumns(20);
        ebField.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        ebField.setRows(5);
        jScrollPane3.setViewportView(ebField);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 850, -1));

        weField.setColumns(20);
        weField.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        weField.setRows(5);
        jScrollPane4.setViewportView(weField);

        jPanel3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, 850, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, 1010));

        jScrollPane5.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1069, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel1KeyPressed
        this.dispose();
    }//GEN-LAST:event_jLabel1KeyPressed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

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
    private javax.swing.JLabel companyField;
    private javax.swing.JLabel drField;
    private javax.swing.JTextArea ebField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel nomField;
    private javax.swing.JLabel ppField;
    private javax.swing.JLabel remarksField;
    private javax.swing.JTextArea sqField;
    private javax.swing.JTextArea swField;
    private javax.swing.JTextArea weField;
    // End of variables declaration//GEN-END:variables
}
