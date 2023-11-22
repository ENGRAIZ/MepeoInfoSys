package mepeoinfosys;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.util.*;
import javax.swing.JFileChooser;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Row;




public final class infoUI extends javax.swing.JFrame {


    public addUI addUI;
    public editUI editUI;
    public Connection cn;
    public Statement st;
    private int[] columnClickCounts; 
    private TableRowSorter<DefaultTableModel> sorter;
    
    public infoUI() {
        initComponents();
        showTable();
        setLocationRelativeTo(null);
        columnClickCounts = new int[infoTable.getColumnCount()];
        
        infoTable.getTableHeader().addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int columnIndex = infoTable.columnAtPoint(e.getPoint());
            if (columnClickCounts[columnIndex] == 0) {
                sortColumn(columnIndex, true);
            } else if (columnClickCounts[columnIndex] == 1) {
                sortColumn(columnIndex, false);
            } else {
                resetColumnSort(columnIndex);
            }
        }
    });
        
    }
    private void sortColumn(int columnIndex, boolean ascending) {
        if (sorter == null) {
            DefaultTableModel model = (DefaultTableModel) infoTable.getModel();
            sorter = new TableRowSorter<>(model);
            infoTable.setRowSorter(sorter);
        }

        if (columnIndex == 0) {
            // For the ID column, use a custom Comparator to sort as integers
            sorter.setComparator(0, Comparator.comparingInt(id -> Integer.parseInt(id.toString())));
        }

        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(columnIndex, ascending ? SortOrder.ASCENDING : SortOrder.DESCENDING));
        sorter.setSortKeys(sortKeys);
        sorter.sort();

        columnClickCounts[columnIndex]++;
    }

    private void resetColumnSort(int columnIndex) {
         if (sorter == null) return;

        sorter.setComparator(columnIndex, null);

        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sorter.setSortKeys(sortKeys);
        sorter.sort();

        columnClickCounts[columnIndex] = 0;
    }
    
    public void showTable(){
        try{
    
        Class.forName("com.mysql.cj.jdbc.Driver");
        cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mepeoinfotable","root","");
        st=cn.createStatement();
        String sql = "SELECT * FROM  `mepeotable`";
        ResultSet rrs = st.executeQuery(sql);
        
        DefaultTableModel model = (DefaultTableModel) infoTable.getModel();
        model.setRowCount(0); // Clear existing rows
        while (rrs.next()) {
            Object[] row = {
            rrs.getInt("ID"),
            rrs.getString("company"),
            rrs.getString("date_registered"),
            rrs.getString("name_of_mepeo"),
            rrs.getString("permanent"),
            rrs.getString("parttime"),
            rrs.getString("submitted_qualifications"),
            rrs.getString("educational"),
            rrs.getString("experience"),
            rrs.getString("seminar"),
            rrs.getString("remarks")
            
        };
        model.addRow(row);
        }
        rrs.close();
        st.close();
        cn.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void readExcel(File file, DefaultTableModel infoTable) {
    try (FileInputStream fis = new FileInputStream(file);
         Workbook workbook = new XSSFWorkbook(fis)) {

        Sheet sheet = workbook.getSheetAt(0);

        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.iterator();

            Vector<Object> rowData = new Vector<>();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (cell.getCellType()) {
                    case STRING:
                        rowData.add(cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        double numericValue = cell.getNumericCellValue();
                        int intValue = (int) numericValue;
                        rowData.add(String.valueOf(intValue));
                        break;
                    // Add cases for other cell types as needed
                    default:
                        rowData.add("");
                }
            }
            infoTable.addRow(rowData);

            // Save to database
            saveRowToDatabase(rowData);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public void saveRowToDatabase(Vector<Object> rowData) {
        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mepeoinfotable", "root", "");
            Statement st = cn.createStatement();

            String sql = "INSERT INTO `mepeotable` (ID,company,date_registered,name_of_mepeo,permanent,parttime,submitted_qualifications,educational,experience,seminar,remarks)"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cn.prepareStatement(sql);

            for (int i = 0; i < rowData.size(); i++) {
                Object value = rowData.get(i);
                if (value == null) {
                    pst.setNull(i + 1, Types.NULL);
                } else {
                    pst.setObject(i + 1, value);
                }
            }

            pst.executeUpdate();

            pst.close();
            st.close();
            cn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        infoTable = new javax.swing.JTable();
        searchField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MSESDD");

        infoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Company", "Date Registered", "Name of Mepeo", "Permanent", "Part-time", "Submitted Qualifications", "Educational Background", "Work Experience", "Seminars and Workshops Attended", "Remarks"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        infoTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        infoTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                infoTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(infoTable);

        searchField.setMaximumSize(new java.awt.Dimension(13, 28));
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchFieldKeyPressed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mepeoinfosys/edit.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mepeoinfosys/delete.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mepeoinfosys/add.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mepeoinfosys/search.png"))); // NOI18N
        jLabel1.setText("Search");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem2.setText("Export to Excel");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Import");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 449, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void infoTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoTableMouseClicked

        if (evt.getClickCount() == 2) {
            int selectedRow = infoTable.getSelectedRow();
            if (selectedRow != -1) {
                String id = infoTable.getValueAt(selectedRow, 0).toString();
                String company = infoTable.getValueAt(selectedRow, 1).toString();
                String dr = infoTable.getValueAt(selectedRow, 2).toString();
                String nom = infoTable.getValueAt(selectedRow, 3).toString();
                String permanent = infoTable.getValueAt(selectedRow, 4).toString();
                String parttime = infoTable.getValueAt(selectedRow, 5).toString();
                String sq = infoTable.getValueAt(selectedRow, 6).toString();
                String eb = infoTable.getValueAt(selectedRow, 7).toString();
                String we = infoTable.getValueAt(selectedRow, 8).toString();
                String sw = infoTable.getValueAt(selectedRow, 9).toString();
                String remarks = infoTable.getValueAt(selectedRow, 10).toString();
                
                ViewDetailsMepeo vdm = new ViewDetailsMepeo(id,company,dr,nom,permanent,parttime,sq,eb,we,sw,remarks);
                vdm.setVisible(true);
            }
        }
    }//GEN-LAST:event_infoTableMouseClicked

    
    private void searchFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyPressed
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mepeoinfotable", "root", "");
                st=cn.createStatement();
                if(!"".equals(searchField.getText())){
                String sql = "SELECT * FROM mepeotable WHERE company LIKE '%"+searchField.getText()+"%' OR date_registered LIKE '%"+searchField.getText()+"%'"
                        + "OR name_of_mepeo LIKE '%"+searchField.getText()+"%' OR permanent LIKE '%"+searchField.getText()+"%' OR parttime LIKE '%"+searchField.getText()+"%'"
                        + "OR submitted_qualifications LIKE '%"+searchField.getText()+"%' OR remarks LIKE '%"+searchField.getText()+"%'";
                ResultSet rrs = st.executeQuery(sql);
                DefaultTableModel model = (DefaultTableModel) infoTable.getModel();
                model.setRowCount(0); // Clear existing rows
                while (rrs.next()) {
                    Object[] row = {
                        rrs.getInt("ID"),
                        rrs.getString("company"),
                        rrs.getString("date_registered"),
                        rrs.getString("name_of_mepeo"),
                        rrs.getString("permanent"),
                        rrs.getString("parttime"),
                        rrs.getString("submitted_qualifications"),
                        rrs.getString("remarks")
                    };
                    model.addRow(row);
                }
                rrs.close();
                st.close();
                cn.close();
        
                }else{
                   
                    showTable();
                }     
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_searchFieldKeyPressed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked

        int selectedRow = infoTable.getSelectedRow();
        if (selectedRow != -1) {
            String id = infoTable.getValueAt(selectedRow, 0).toString();
            String company = infoTable.getValueAt(selectedRow, 1).toString();
            String dr = infoTable.getValueAt(selectedRow, 2).toString();
            String nom = infoTable.getValueAt(selectedRow, 3).toString();
            String permanent = infoTable.getValueAt(selectedRow, 4).toString();
            String parttime = infoTable.getValueAt(selectedRow, 5).toString();
            String sq = infoTable.getValueAt(selectedRow, 6).toString();
            String eb = infoTable.getValueAt(selectedRow, 7).toString();
            String we = infoTable.getValueAt(selectedRow, 8).toString();
            String sw = infoTable.getValueAt(selectedRow, 9).toString();
            String remarks = infoTable.getValueAt(selectedRow, 10).toString();


            // Create a new EditInfoUI instance and pass the data
            editUI = new editUI(id,company,dr,nom,permanent,parttime,sq,eb,we,sw,remarks);
            editUI.setVisible(true);
            this.dispose();
            
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
     
        int response = JOptionPane.showConfirmDialog(this, "Do you want to delete?", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            int[] selectedRows = infoTable.getSelectedRows();

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mepeoinfotable", "root", "");
                st = cn.createStatement();

                for (int selectedRow : selectedRows) {
                    int idToDelete = (int) infoTable.getValueAt(selectedRow, 0);
                    String sql = "DELETE FROM `mepeotable` WHERE `ID` = " + idToDelete;
                    st.executeUpdate(sql);
                }

                st.close();
                cn.close();
                showTable();
            } catch (Exception e) {
                e.printStackTrace(); // Handle any potential exceptions
            }
        }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
       
            addUI = new addUI();
            addUI.setVisible(true);
            this.dispose();
            
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mepeoinfotable", "root", "");
            st=cn.createStatement();
            if(!"".equals(searchField.getText())){
                String sql = "SELECT * FROM mepeotable WHERE company LIKE '%"+searchField.getText()+"%' OR date_registered LIKE '%"+searchField.getText()+"%'"
                    + "OR name_of_mepeo LIKE '%"+searchField.getText()+"%' OR permanent LIKE '%"+searchField.getText()+"%' OR parttime LIKE '%"+searchField.getText()+"%'"
                    + "OR submitted_qualifications LIKE '%"+searchField.getText()+"%' OR remarks LIKE '%"+searchField.getText()+"%'";
                ResultSet rrs = st.executeQuery(sql);
                DefaultTableModel model = (DefaultTableModel) infoTable.getModel();
                model.setRowCount(0); // Clear existing rows
                while (rrs.next()) {
                    Object[] row = {
                        rrs.getInt("ID"),
                        rrs.getString("company"),
                        rrs.getString("date_registered"),
                        rrs.getString("name_of_mepeo"),
                        rrs.getString("permanent"),
                        rrs.getString("parttime"),
                        rrs.getString("submitted_qualifications"),
                        rrs.getString("remarks")
                        };
                    model.addRow(row);
                    }
                rrs.close();
                st.close();
                cn.close();

                }else{
                    showTable();
                }     
            }catch (Exception e){
                e.printStackTrace();
            }
    }//GEN-LAST:event_jLabel1MouseClicked
    
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");

        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String filePath = fileToSave.getAbsolutePath();
            if (!filePath.endsWith(".xlsx")) {
                fileToSave = new File(filePath + ".xlsx");
            }

            try {
                DefaultTableModel model = (DefaultTableModel) infoTable.getModel();
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("Sheet1");

                // Copy data from JTable to Excel sheet
                for (int i = 0; i < model.getRowCount(); i++) {
                    XSSFRow row = sheet.createRow(i); // Use XSSFRow
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        Cell cell = row.createCell(j);
                        cell.setCellValue(model.getValueAt(i, j).toString());
                    }
                }

                // Save the workbook to the selected file
                try (FileOutputStream out = new FileOutputStream(fileToSave)) {
                    workbook.write(out);
                    System.out.println("Excel file created successfully.");
                    JOptionPane.showMessageDialog(this, "Excel file created successfully.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select Excel File");
        int userSelection = fileChooser.showOpenDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToImport = fileChooser.getSelectedFile();
            readExcel(fileToImport, (DefaultTableModel) infoTable.getModel());
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
            java.util.logging.Logger.getLogger(infoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(infoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(infoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(infoUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new infoUI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable infoTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables

}
