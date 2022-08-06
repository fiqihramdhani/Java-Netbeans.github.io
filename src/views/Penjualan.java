/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Fiqih Ramdhani
 */
public final class Penjualan extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    public final Connection conn = new koneksi().connect();

    public DefaultTableModel tabmode;
    /**
     * Creates new form Penjualan
     */
    public Penjualan() {
        initComponents();
        dataTable();
        noTable();
    }

   
       protected void kosong(){
        txtKode.setText(null);
        txtNama.setText(null);
        txtJumlah.setText(null);
        txtHarga.setText(null);
        txtTotal.setText(null);
        txt_kembalian1.setText(null);
    }
    
   
      public void noTable(){
        int Baris = tabmode.getRowCount();
        for (int a=0; a<Baris; a++)
        {
            String nomor = String.valueOf(a+1);
            tabmode.setValueAt(nomor +".",a,0);
        }
    }
    
  
    
    
    
 
    
    public  void tanggal(){
        DateFormat tgl;
        tgl = new SimpleDateFormat("dd/MM/YYYY");
        String htgl = tgl.format(Calendar.getInstance().getTime());
        txtTanggal.setText(htgl);
        
    }
    
    private void dataTable(){
        Object[] Baris = {"ID","Tanggal","Kode_Tranksaksi","Nama_Barang","Harga_Barang","Jumlah_Pembelian","Total"};
        tabmode = new DefaultTableModel(null, Baris);
        jTable.setModel(tabmode);
        String sql = "select * from tb_keranjang order by Kode_Tranksaksi asc";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String id = hasil.getString("ID");
                String tanggal = hasil.getString("Tanggal");
                String kode_part = hasil.getString("Kode_Tranksaksi");
                String nama_part = hasil.getString("Nama_Barang");
                String harga = hasil.getString("Harga_Barang");
                String jumlah = hasil.getString("Jumlah_Pembelian");
                String total = hasil.getString("Total");
                
                String[] data = {id,tanggal,kode_part,nama_part,harga,jumlah,total};
                tabmode.addRow(data);
               
            }
            noTable();
        } catch (SQLException e){
        }
    }
    
    private void keranjang(){
        
        
        String tanggal = txtTanggal.getText();
        String kode = txtKode.getText();
        String nama = txtNama.getText();
        String harga = txtHarga.getText();
        String jumlah = txtJumlah.getText();
        String total = txtTotal.getText();
        
        
        
        String query = "INSERT INTO `tb_keranjang` (`Tanggal`, `Kode_Tranksaksi`, `Nama_Barang`, `Harga_Barang`, `Jumlah_Pembelian`, `Total`) "
                + "VALUES ('"+tanggal+"','"+kode+"', '"+nama+"', '"+harga+"', '"+jumlah+"', '"+total+"')";
        
        try{
            //menyiapkan statement untuk di eksekusi
            PreparedStatement stat = conn.prepareStatement(query);
            stat.execute(query);
            JOptionPane.showMessageDialog(null,"Data Masuk Ke-Keranjang");
            
        }catch(SQLException | HeadlessException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Data Gagal Disimpan");
            
        }finally{
            dataTable();
            kosong();
           
            
        }
        totalnya();
    }
    
    private void totalnya(){
        String procedures = "CALL `Total`()";
        
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(procedures);//menjalanakn query\
                while(hasil.next()){
                    txtHarga2.setText(hasil.getString(1));
                }
                
        }catch(SQLException e){
            System.out.println(e);
        }
        
        
    }
    
   public void total(){
        String harga = txtHarga.getText();
        String jumlah = txtJumlah.getText();
        
        int hargaa = Integer.parseInt(harga);
        try{
        int jumlahh = Integer.parseInt(jumlah);
        
        int total = hargaa * jumlahh;
        String total_harga = Integer.toString(total);
        
        txtTotal.setText(total_harga);
        tanggal();
       
       
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Only Number");
            txtJumlah.setText(null);
        }
    }
    
     private void kembalian(){
        String total = txtHarga2.getText();
        String uang = txt_kembalian1.getText();
        
        int totals = Integer.parseInt(total);
        try{
            int uangs = Integer.parseInt(uang);     
            int kembali = (uangs - totals);
            String fix = Integer.toString(kembali);
            txt_kembalian.setText("Rp"+" "+fix);
            JOptionPane.showMessageDialog(null, "Transaksi Berhasil!");
        }catch(NumberFormatException | HeadlessException e){
            JOptionPane.showMessageDialog(null, "Invalid Payment");
        }
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();
        btnpilih = new javax.swing.JButton();
        txtTanggal = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        txtHarga = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        txtJumlah = new javax.swing.JTextField();
        btnKeranjang = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();
        btnInput = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        txtHarga2 = new javax.swing.JTextField();
        txt_kembalian = new javax.swing.JTextField();
        txt_kembalian1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));

        jLabel1.setFont(new java.awt.Font("Sitka Heading", 1, 64)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PENJUALAN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(464, 464, 464))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setBackground(new java.awt.Color(153, 153, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Kode_Barang");

        txtKode.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtKode.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnpilih.setText("Pilih Barang");
        btnpilih.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnpilihMouseClicked(evt);
            }
        });
        btnpilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpilihActionPerformed(evt);
            }
        });

        txtTanggal.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        txtHarga.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtHarga.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtNama.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNama.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        txtJumlah.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtJumlah.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtJumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtJumlahKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtJumlahKeyTyped(evt);
            }
        });

        btnKeranjang.setText("Masuk Keranjang");
        btnKeranjang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeranjangActionPerformed(evt);
            }
        });

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnInput.setText("Simpan");
        btnInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInputActionPerformed(evt);
            }
        });

        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        txtHarga2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtHarga2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txt_kembalian.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        txt_kembalian.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txt_kembalian1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txt_kembalian1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton2.setText("PAYMENT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("PRINT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtNama)
                        .addComponent(txtHarga)
                        .addComponent(txtTotal, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtJumlah)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(111, 111, 111)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnpilih, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnInput, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))))
            .addComponent(txtHarga2)
            .addComponent(txt_kembalian1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 1088, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTanggal)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnpilih, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jRadioButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInput, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(txtHarga2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_kembalian1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txt_kembalian, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnpilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpilihActionPerformed

        new Stock_Barang().setVisible(true);
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_btnpilihActionPerformed

    private void btnKeranjangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeranjangActionPerformed
        keranjang();
        
    }//GEN-LAST:event_btnKeranjangActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
       tanggal();
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        kembalian();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
    
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtJumlahKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJumlahKeyReleased
        total();
    }//GEN-LAST:event_txtJumlahKeyReleased

    private void txtJumlahKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJumlahKeyTyped
    
    }//GEN-LAST:event_txtJumlahKeyTyped

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
          
        try{
            String clear = "TRUNCATE `tb_keranjang`";
            
            PreparedStatement stat = conn.prepareStatement(clear);
            stat.execute();

            
            
        }catch(SQLException e){
            System.out.println(e);
        }finally{
            dataTable();
            totalnya();
            txtHarga2.setText(null);
            kosong();
    
        }
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        int bar = jTable.getSelectedRow();
        
    

       
        
        int ok = JOptionPane.showConfirmDialog (null," Apakah Anda Yakin Ingin "
            + "Menghapus Data","Konfirmasi Dialog", JOptionPane.YES_NO_OPTION);
        if (ok==0){
            String sql="Delete From tb_keranjang where Kode_Tranksaksi='"+txtKode.getText()+"'";
            try {
                PreparedStatement stat=conn.prepareStatement(sql);
                stat.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus");
                dataTable();
                totalnya();
                
                txt_kembalian.setText(null);
                txt_kembalian1.setText(null);
                
                txtKode.requestFocus();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
            }
        }
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btnpilihMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpilihMouseClicked
       
    }//GEN-LAST:event_btnpilihMouseClicked

    private void btnInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInputActionPerformed
        
      
        String tanggal = txtTanggal.getText();
        String kode = txtKode.getText();
        String nama = txtNama.getText();
        String harga = txtHarga.getText();
        String jumlah = txtJumlah.getText();
        String total = txtTotal.getText();
        
        
        
        String query = "INSERT INTO `tranksaksi` (`Tanggal`, `Kode_Tranksaksi`, `Nama`, `Harga`, `Jumlah`, `Total`) "
                + "VALUES ('"+tanggal+"','"+kode+"', '"+nama+"', '"+harga+"', '"+jumlah+"', '"+total+"')";
        
        try{
            //menyiapkan statement untuk di eksekusi
            PreparedStatement stat = conn.prepareStatement(query);
            stat.execute(query);
            JOptionPane.showMessageDialog(null,"Data Masuk Database tranksaksi");
            
        }catch(SQLException | HeadlessException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Data Gagal Disimpan");
            
        }finally{
            dataTable();
            kosong();
            txtHarga2.setText(null);
            txt_kembalian.setText(null);
            
        }
        totalnya();
    
    }//GEN-LAST:event_btnInputActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
         int bar = jTable.getSelectedRow();
      
    
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
        String f = tabmode.getValueAt(bar, 5).toString();
        String g = tabmode.getValueAt(bar, 6).toString();
       
        

        
        txtTanggal.setText(b);
        txtKode.setText(c);
        txtNama.setText(d);
        txtHarga.setText(e);
        txtJumlah.setText(f);
        txtTotal.setText(g);
      
    }//GEN-LAST:event_jTableMouseClicked

    @SuppressWarnings("unchecked")
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         
       try{
            String file = "/iReport/struk.jasper";
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            HashMap param = new HashMap();
            
            param.put("total",txtHarga2.getText());
            param.put("uang",txt_kembalian1.getText());
            param.put("kembalian",txt_kembalian.getText());
            
            JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream(file),param,conn);
            JasperViewer.viewReport(print,false);
            
        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException | JRException e){
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Penjualan().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInput;
    private javax.swing.JButton btnKeranjang;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnpilih;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable;
    public javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtHarga2;
    public javax.swing.JTextField txtJumlah;
    public javax.swing.JTextField txtKode;
    public javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtTanggal;
    public javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txt_kembalian;
    private javax.swing.JTextField txt_kembalian1;
    // End of variables declaration//GEN-END:variables
}
