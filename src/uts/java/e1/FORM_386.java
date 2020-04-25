package uts.java.e1;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.sql.ResultSet;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JOptionPane;
import sun.security.util.Length;


public class FORM_386 extends javax.swing.JFrame {
    DefaultTableModel model;
    //private Koneksi db;
    Connection cn;
    ResultSet rs;
    Statement stat;
    String sql;
    
    private void tampil() {
        int row = tbl_mhs.getRowCount();
        for (int a=0; a<row; a++) {
            model.removeRow(0);
        }
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_uts_java_e1", "kali", "password");
            ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM tb_uts_386");
//            sql = "select * from tb_uts_386";
//            rs  = stat.executeQuery(sql);
            while(rs.next()) {
                String data[]={rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)};
                model.addRow(data);
                tbl_mhs.setModel(model);                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "GAGAL :" + e.getMessage());
        }
    }
    
    public FORM_386() {
        initComponents();

//        Object kolom[] = {"Kode Matkul", "Mata Kuliah", "Semester", "Tahun Ajaran",
//                            "SKS", "Kelompok"};
          String [] kolom = {"Kode Matkul", "Mata Kuliah", "Semester", "Tahun Ajaran","SKS", "Kelompok"};
//        Object baris[][] = {};
        
        model = new DefaultTableModel(kolom, 0);
        tbl_mhs.setModel(model);
        tampil();
       
        
    }
  
    {
        Koneksi DB = new Koneksi();
        DB.config();
        cn= DB.con;
        stat = DB.state;
    }
    
    private void bersih() {
        txtKode.setText("");
        txtMatkul.setText("");
        txtTahun.setText("");
        txtSks.setText("");
        rGanjil.setSelected(false);
        rGenap.setSelected(false);        
        txtKode.requestFocus();
    }
    
    public void ambilsmt (String smt) {
        if (smt.equals("Ganjil")){
            rGanjil.setSelected(true);
        } else if(smt.equals("Genap")) {
            rGenap.setSelected(true);
        }
    }
    
    public void ambilkelompok(String kelompok) {
        String [] kel={"Inti", "Wajib", "Pilihan"};
        cKelompok.removeAllItems();
        cKelompok.addItem(kelompok);
        for (int i=0; i<kel.length; i++){
            if (!kel[i].equals(kelompok)) {
                cKelompok.addItem(kel[i]);
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnsemester = new javax.swing.ButtonGroup();
        jSeparator1 = new javax.swing.JSeparator();
        txtTahun = new java.awt.TextField();
        cKelompok = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        txtMatkul = new java.awt.TextField();
        txtKode = new java.awt.TextField();
        jLabel6 = new javax.swing.JLabel();
        txtCari = new java.awt.TextField();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        rGanjil = new javax.swing.JRadioButton();
        rGenap = new javax.swing.JRadioButton();
        txtSks = new java.awt.TextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_mhs = new javax.swing.JTable();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cKelompok.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Kelompok --", "Inti", "Wajib", "Pilihan" }));
        cKelompok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cKelompokActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Kode Matkul");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Semester");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Mata Kuliah");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Kelompok");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Tahun Ajaran");

        btnSave.setIcon(new javax.swing.ImageIcon("/home/kali/Documents/Dev/Java/Java_Lanjutan/UTS-JAVA-E1/png/24x24/Save.png")); // NOI18N
        btnSave.setText(" Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel6.setText("Pencarian");

        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCariKeyPressed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon("/home/kali/Documents/Dev/Java/Java_Lanjutan/UTS-JAVA-E1/png/24x24/Wrench.png")); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon("/home/kali/Documents/Dev/Java/Java_Lanjutan/UTS-JAVA-E1/png/24x24/Remove.png")); // NOI18N
        btnDelete.setText(" Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnExit.setIcon(new javax.swing.ImageIcon("/home/kali/Documents/Dev/Java/Java_Lanjutan/UTS-JAVA-E1/png/24x24/Exit.png")); // NOI18N
        btnExit.setText(" Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnsemester.add(rGanjil);
        rGanjil.setText("Ganjil");

        btnsemester.add(rGenap);
        rGenap.setText("Genap");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Jumlah SKS");

        tbl_mhs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Kode Matkul", "Mata Kuliah", "Semester", "Tahun Ajaran", "SKS", "Kelompok"
            }
        ));
        tbl_mhs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_mhsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_mhs);

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGap(33, 33, 33)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtMatkul, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(rGanjil)
                                    .addGap(63, 63, 63)
                                    .addComponent(rGenap))
                                .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSks, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(25, 25, 25))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(58, 58, 58)
                            .addComponent(cKelompok, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(btnCancel)
                        .addGap(67, 67, 67)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtMatkul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(rGanjil)
                            .addComponent(rGenap))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(txtSks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cKelompok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addComponent(txtCari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSave)
                            .addComponent(btnUpdate)
                            .addComponent(btnDelete)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExit)))
                .addContainerGap(157, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cKelompokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cKelompokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cKelompokActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        String namaMatkul   = txtMatkul.getText(); 
        String kodeMatkul   = txtKode.getText();         
        String tahun        = txtTahun.getText(); 
        String sks          = txtSks.getText(); 
        String kelompok     = cKelompok.getSelectedItem().toString();
        String semester     = ""; 
        if (rGanjil.isSelected()) {
            semester = "Ganjil";
        } else if (rGenap.isSelected()) {
            semester = "Genap";
        }
//        COMBO BOX
//        if (cKelompok.getSelectedItem().equals("Inti")) {
//            kelompok="Inti";
//        } else if(cKelompok.getSelectedItem().equals("Wajib")) {
//            kelompok="Wajib";            
//        } else if(cKelompok.getSelectedItem().equals("Pilihan")) {
//            kelompok="Pilihan";
//        }
        
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_uts_java_e1", "kali", "password");
            Statement stat =  (Statement) cn.createStatement();
            sql = "INSERT INTO tb_uts_386 VALUES ('"+kodeMatkul+"', '"+namaMatkul+"', '"+semester+"', '"+tahun+"', "
                    + "'"+sks+"', '"+kelompok+"') ";
            stat.executeUpdate(sql);
            stat.close();
            JOptionPane.showMessageDialog(null, "Data berhasil Disimpan");
            cn.close();
            bersih();
            tampil();                        
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal :" + e.getMessage());
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String namaMatkul   = txtMatkul.getText(); 
        String kodeMatkul   = txtKode.getText();      
        String tahun        = txtTahun.getText(); 
        String sks          = txtSks.getText(); 
        String kelompok     = cKelompok.getSelectedItem().toString();
        String semester     = ""; 
        if (rGanjil.isSelected()) {
            semester = "Ganjil";
        } else if (rGenap.isSelected()) {
            semester = "Genap";
        }

        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_uts_java_e1", "kali", "password");
            Statement stat =  (Statement) cn.createStatement();
            sql = "UPDATE tb_uts_386 set kode_matkul='"+kodeMatkul+"',mata_kuliah='"+namaMatkul+"', semester='"+semester+"', "
                    + "tahun_ajaran='"+tahun+"', sks='"+sks+"',  kelompok='"+kelompok+"' "
                    + "where kode_matkul='"+kodeMatkul+"' ";
            stat.executeUpdate(sql);
            stat.close();
            JOptionPane.showMessageDialog(null, "Data berhasil Diubah");
            bersih();
            tampil();                        
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Diubah" + e.getMessage());
        }
        
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        int selectedOption = JOptionPane.showConfirmDialog(null, "Ingin Keluar Aplikasi?", "Tutup Aplikasi", JOptionPane.YES_NO_OPTION);
        if (selectedOption==JOptionPane.YES_OPTION) {
            System.exit(0);
        }
                
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        String kodeMatkul   = txtKode.getText();
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_uts_java_e1", "kali", "password");
            Statement stat =  (Statement) cn.createStatement();
            sql = "DELETE FROM tb_uts_386 WHERE kode_matkul='"+kodeMatkul+"'";
            int selectedOption = JOptionPane.showConfirmDialog(null, "Ingin Menghapus data?", "Hapus Data", JOptionPane.YES_NO_OPTION);
            if (selectedOption==JOptionPane.YES_OPTION) {
            stat.executeUpdate(sql);
            cn.close();
            bersih();
            tampil();
            JOptionPane.showMessageDialog(null, "Data berhasil Dihapus");
        }
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Gagal Dihapus" + e.getMessage());
       }
        
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tbl_mhsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_mhsMouseClicked
        // TODO add your handling code here:
        int row = tbl_mhs.getSelectedRow();
        txtKode.setText((String)tbl_mhs.getValueAt(row, 0));
        txtMatkul.setText((String)tbl_mhs.getValueAt(row, 1));
        String semester=tbl_mhs.getModel().getValueAt(row, 2).toString();
        ambilsmt(semester);
        txtTahun.setText((String)tbl_mhs.getValueAt(row, 3));
        txtSks.setText((String)tbl_mhs.getValueAt(row, 4));
        String kelompok=tbl_mhs.getModel().getValueAt(row, 5).toString();
        ambilkelompok(kelompok);
    }//GEN-LAST:event_tbl_mhsMouseClicked

    
    private void txtCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyPressed
        // TODO add your handling code here:
        int row = tbl_mhs.getRowCount();
        for (int a=0; a<row; a++) {
            model.removeRow(0);
        }
        try {
            sql = ("SELECT * FROM tb_uts_386 WHERE kode_matkul LIKE '%"+txtCari.getText()+"%'");
            rs = stat.executeQuery(sql);
            int no=1;
            while (rs.next()) {
                String data[]={rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), };
                model.addRow(data);
                no++;
            }
            tbl_mhs.setModel(model);
        }  catch(Exception e){
            
        }
    }//GEN-LAST:event_txtCariKeyPressed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        bersih();
    }//GEN-LAST:event_btnCancelActionPerformed

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
            java.util.logging.Logger.getLogger(FORM_386.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FORM_386.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FORM_386.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FORM_386.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FORM_386().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup btnsemester;
    private javax.swing.JComboBox<String> cKelompok;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rGanjil;
    private javax.swing.JRadioButton rGenap;
    private javax.swing.JTable tbl_mhs;
    private java.awt.TextField txtCari;
    private java.awt.TextField txtKode;
    private java.awt.TextField txtMatkul;
    private java.awt.TextField txtSks;
    private java.awt.TextField txtTahun;
    // End of variables declaration//GEN-END:variables
}
