/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;

import static Home.Database.DB_URL;
import static Home.Database.JDBC_DRIVER;
import static Home.Database.PASS;
import static Home.Database.USER;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author HP
 */
public class AdminD extends javax.swing.JFrame {
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    public boolean databaru;
    /**
     * Creates new form AdminD
     */
    public AdminD() {
        initComponents();
        koneksi();
        tampiltable1();
        tampiltable2();
        tableTamu();
        databaru = true;
    }
    
    public void koneksi(){
        try{
           Class.forName(JDBC_DRIVER);
           conn = DriverManager.getConnection(DB_URL, USER, PASS);
           stmt = conn.createStatement();
           
        }catch(ClassNotFoundException | SQLException e){
        }
    }
    public void tampiltable2(){
        DefaultTableModel tb2 = new DefaultTableModel();
        tb2.addColumn("NID");
        tb2.addColumn("Nama");
        tb2.addColumn("username");
        tb2.addColumn("password");
        jTable2.setModel(tb2);
        try{
            rs = stmt.executeQuery("SELECT * FROM resepsionis");
            while(rs.next()){
                tb2.addRow(new Object[]{
                rs.getString("NID"),
                rs.getString("Nama"),
                rs.getString("username"),
                rs.getString("password"),
            });
            }
        }catch(Exception e){
            e.printStackTrace(); 
        }
        
    }
    public void tampiltable1(){
        DefaultTableModel tb1 = new DefaultTableModel();
        tb1.addColumn("No. Laporan");
        tb1.addColumn("No. Kamar");
        tb1.addColumn("NIK Visitor");
        tb1.addColumn("Nama Visitor");
        tb1.addColumn("Harga");
        tb1.addColumn("Tanggal Masuk");
        tb1.addColumn("Tanggal Keluar");
        tb1.addColumn("Waktu");
        tb1.addColumn("Total");
        jTable1.setModel(tb1);
        try{
            rs = stmt.executeQuery("SELECT * FROM laporan");
            while(rs.next()){
                tb1.addRow(new Object[]{
                rs.getString("NoLaporan"),
                rs.getString("NoKamar"),
                rs.getString("NIK"),
                rs.getString("NamaV"),
                rs.getString("Harga"),
                rs.getString("DateIn"),
                rs.getString("DateOut"),
                rs.getString("Waktu"),
                rs.getString("Total"),
            });
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    public void tableTamu(){
        DefaultTableModel tb3 = new DefaultTableModel();
        tb3.addColumn("NIK Pengunjung");
        tb3.addColumn("Nama Pengunjung");
        tb3.addColumn("Alamat Pengunjung");
        tb3.addColumn("Jenis Kelamin");
        dTamu.setModel(tb3);
        try{
            rs = stmt.executeQuery("SELECT * FROM visitor");
            while(rs.next()){
                String jenis;
                if ("L".equals(rs.getString("JK"))){
                    jenis = "Laki - laki";
                }else{
                    jenis = "Perempuan";
                }
                tb3.addRow(new Object[]{
                rs.getString("NIK"),
                rs.getString("Nama"),
                rs.getString("Alamat"),
                jenis,
            });
            }
        }catch(Exception e){
            e.printStackTrace(); 
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        Laporan = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        LogOutBtn = new javax.swing.JButton();
        MUser = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        DltBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        UserField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        NameField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        PassField = new javax.swing.JTextField();
        SaveB = new javax.swing.JButton();
        RstBtn = new javax.swing.JButton();
        INID = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        dTamu = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1080, 720));
        setPreferredSize(new java.awt.Dimension(1080, 720));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Laporan", "NoKamar", "NIK Visitor", "Nama Visitor", "Harga", "Tanggal Masuk", "Tanggal Keluar", "Waktu", "Total"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Kaushan Script", 1, 48)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Laporan Penghasilan");

        LogOutBtn.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        LogOutBtn.setText("LogOut");
        LogOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LaporanLayout = new javax.swing.GroupLayout(Laporan);
        Laporan.setLayout(LaporanLayout);
        LaporanLayout.setHorizontalGroup(
            LaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LaporanLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(271, 271, 271))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LaporanLayout.createSequentialGroup()
                .addGap(436, 945, Short.MAX_VALUE)
                .addComponent(LogOutBtn)
                .addGap(79, 79, 79))
        );
        LaporanLayout.setVerticalGroup(
            LaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LaporanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(LogOutBtn)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Laporan", Laporan);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NID", "Nama", "Username", "Password"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel3.setFont(new java.awt.Font("Kaushan Script", 1, 48)); // NOI18N
        jLabel3.setText("Kelola Resepionis");

        DltBtn.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        DltBtn.setText("Hapus");
        DltBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DltBtnActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        jLabel4.setText("Form Edit");

        jLabel5.setText("NID              :");

        jLabel6.setText("Nama         :");

        UserField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserFieldActionPerformed(evt);
            }
        });

        jLabel7.setText("Username :");

        NameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameFieldActionPerformed(evt);
            }
        });

        jLabel8.setText(" Password :");

        SaveB.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        SaveB.setText("Save");
        SaveB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveBActionPerformed(evt);
            }
        });

        RstBtn.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        RstBtn.setText("Reset");
        RstBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RstBtnActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Perpetua", 3, 14)); // NOI18N
        jLabel9.setText("Jika anda ingin melakukan perubahan data harap tidak merubah NID yang sudah ada");

        jLabel10.setFont(new java.awt.Font("Perpetua", 1, 14)); // NOI18N
        jLabel10.setText("Petunjuk :");

        javax.swing.GroupLayout MUserLayout = new javax.swing.GroupLayout(MUser);
        MUser.setLayout(MUserLayout);
        MUserLayout.setHorizontalGroup(
            MUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MUserLayout.createSequentialGroup()
                .addGroup(MUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MUserLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(MUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(24, 24, 24)
                        .addGroup(MUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MUserLayout.createSequentialGroup()
                                .addComponent(SaveB)
                                .addGap(62, 62, 62)
                                .addComponent(DltBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(RstBtn))
                            .addComponent(UserField)
                            .addComponent(PassField)
                            .addComponent(NameField)
                            .addComponent(INID))
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MUserLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(MUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(MUserLayout.createSequentialGroup()
                .addGap(459, 459, 459)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        MUserLayout.setVerticalGroup(
            MUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MUserLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel3)
                .addGap(42, 42, 42)
                .addGroup(MUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MUserLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(MUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(INID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(MUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(MUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UserField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(22, 22, 22)
                        .addGroup(MUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(PassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(MUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SaveB)
                            .addComponent(RstBtn)
                            .addComponent(DltBtn))
                        .addGap(5, 5, 5)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(118, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Kelola User", MUser);

        dTamu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(dTamu);

        jLabel11.setFont(new java.awt.Font("Kaushan Script", 1, 48)); // NOI18N
        jLabel11.setText("Data Tamu Menginap Hotel ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
                .addGap(197, 197, 197))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(42, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(79, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(585, 585, 585))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(136, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(137, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Data Tamu ", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1113, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UserFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserFieldActionPerformed

    private void NameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameFieldActionPerformed

    private void SaveBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBActionPerformed
        if(databaru){
            try{
                String sql = "INSERT INTO resepsionis VALUES('"+INID.getText()+"', '"+NameField.getText()+"', '"+UserField.getText()+"', '"+PassField.getText()+"')";
                koneksi();
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);
            }
    }//GEN-LAST:event_SaveBActionPerformed
        else{
            try{
                String sql = "UPDATE resepsionis set Nama='"+NameField.getText()+"', username='"+UserField.getText()+"', password='"+PassField.getText()+"' WHERE NID='"+INID.getText()+"'";
                koneksi();
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
        tampiltable2();
    }
    private void RstBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RstBtnActionPerformed
       databaru = true;
       INID.setText("");
       NameField.setText("");
       UserField.setText("");
       PassField.setText("");
    }//GEN-LAST:event_RstBtnActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        databaru = false;
        int i = jTable2.getSelectedRow();
        TableModel model = jTable2.getModel();
        INID.setText(model.getValueAt(i, 0).toString());
        NameField.setText(model.getValueAt(i, 1).toString());
        UserField.setText(model.getValueAt(i, 2).toString());
        PassField.setText(model.getValueAt(i, 3).toString());
    }//GEN-LAST:event_jTable2MouseClicked

    private void DltBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DltBtnActionPerformed
        try {
            String sql = "DELETE FROM resepsionis WHERE NID='"+INID.getText()+"'";
            koneksi();
            stmt.executeUpdate(sql);
            databaru = true;
            INID.setText("");
            NameField.setText("");
            UserField.setText("");
            PassField.setText("");
            tampiltable2();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_DltBtnActionPerformed

    private void LogOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutBtnActionPerformed
        Homepage hp = new Homepage();
        hp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_LogOutBtnActionPerformed

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
            java.util.logging.Logger.getLogger(AdminD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DltBtn;
    private javax.swing.JTextField INID;
    private javax.swing.JPanel Laporan;
    private javax.swing.JButton LogOutBtn;
    private javax.swing.JPanel MUser;
    private javax.swing.JTextField NameField;
    private javax.swing.JTextField PassField;
    private javax.swing.JButton RstBtn;
    private javax.swing.JButton SaveB;
    private javax.swing.JTextField UserField;
    private javax.swing.JTable dTamu;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables

    
}
