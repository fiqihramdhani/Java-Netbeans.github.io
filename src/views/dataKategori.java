/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import koneksi.koneksi;
import static views.menuUtama.maximixed;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static javax.print.attribute.Size2DSyntax.MM;


/**
 *
 * @author SUSENO-PC
 */
public class dataKategori extends javax.swing.JDialog {
    
    public final Connection conn = new koneksi().connect();

    private DefaultTableModel tabmode;
    
    // frame maks dan geser panel
    static boolean maximixed = true;
    int xMouse;
    int yMouse;
    
    private void aktif(){
        jTextField2.setEnabled(true);
        txtKodeKategori.setEnabled(true);
        txtNamaKategori.setEnabled(true);
        txtKeterangan.setEnabled(true);
    }
    
        public  void tanggal(){
        DateFormat tgl;
        tgl = new SimpleDateFormat("dd/MM/YYYY");
        String htgl = tgl.format(Calendar.getInstance().getTime());
        jTextField2.setText(htgl);
        
    }
    
    protected void kosong(){
        
        txtKodeKategori.setText(null);
        txtNamaKategori.setText(null);
        txtKeterangan.setText(null);
    }
    
    public void noTable(){
        int Baris = tabmode.getRowCount();
        for (int a=0; a<Baris; a++)
        {
            String nomor = String.valueOf(a+1);
            tabmode.setValueAt(nomor +".",a,0);
        }
    }
    
  
    
    
    public final void dataTable(){
        Object[] Baris = {"No","Tanggal","Kode Kategori","Nama Kategori","Keterangan"};
        tabmode = new DefaultTableModel(null, Baris);
        tabelKategori.setModel(tabmode);
        String sql = "select * from tb_kategori order by kode_kategori asc";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String tanggal = hasil.getString("tanggal");
                String kode_kategori = hasil.getString("kode_kategori");
                String nama_kategori = hasil.getString("nama_kategori");
                String keterangan = hasil.getString("keterangan");
                String[] data = {"",tanggal,kode_kategori,nama_kategori,keterangan};
                tabmode.addRow(data);
                noTable();
            }
        } catch (SQLException e){
        }
    }
    
    public final void lebarKolom(){
        TableColumn column;
        tabelKategori.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tabelKategori.getColumnModel().getColumn(0);
        column.setPreferredWidth(40);
        column = tabelKategori.getColumnModel().getColumn(1);
        column.setPreferredWidth(150);
        column = tabelKategori.getColumnModel().getColumn(2);
        column.setPreferredWidth(200);
        column = tabelKategori.getColumnModel().getColumn(3);
        column.setPreferredWidth(350);
        column = tabelKategori.getColumnModel().getColumn(4);
        column.setPreferredWidth(370); 
    }
    
    public void pencarian(String sql){
        Object[] Baris = {"No","Tanggal","Kode Kategori","Nama Kategori","Keterangan"};
        tabmode = new DefaultTableModel(null, Baris);
        tabelKategori.setModel(tabmode);
        int brs = tabelKategori.getRowCount();
        for (int i = 0; 1 < brs; i++){
            tabmode.removeRow(1);
        }
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String tanggal = hasil.getString("tanggal");
                String kode_kategori = hasil.getString("kode_kategori");
                String nama_kategori = hasil.getString("nama_kategori");
                String keterangan = hasil.getString("keterangan");
                String[] data = {"",tanggal,kode_kategori,nama_kategori,keterangan};
                tabmode.addRow(data);
                noTable();
            }
        } catch(SQLException e){
            
        }
    }

    /**
     * Creates new form dataBarang
     * @param parent
     * @param modal
     */
    public dataKategori(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        aktif();
        dataTable();
       
        lebarKolom();
        txtKodeKategori.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelHeader = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();
        labelNama = new javax.swing.JLabel();
        lbTanggal = new javax.swing.JLabel();
        labelKodeKategori = new javax.swing.JLabel();
        labelNamaKategori = new javax.swing.JLabel();
        labelKeterangan = new javax.swing.JLabel();
        txtKodeKategori = new javax.swing.JTextField();
        txtNamaKategori = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelKategori = new javax.swing.JTable();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBersih = new javax.swing.JButton();
        btnCari = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtKeterangan = new javax.swing.JTextArea();
        jTextField2 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setType(java.awt.Window.Type.POPUP);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        panelHeader.setBackground(new java.awt.Color(204, 102, 255));
        panelHeader.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelHeaderMouseDragged(evt);
            }
        });
        panelHeader.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelHeaderMousePressed(evt);
            }
        });

        btnClose.setBackground(new java.awt.Color(204, 102, 255));
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Delete_30px_4.png"))); // NOI18N
        btnClose.setContentAreaFilled(false);
        btnClose.setOpaque(true);
        btnClose.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Delete_30px_5.png"))); // NOI18N
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCloseMouseExited(evt);
            }
        });
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        labelNama.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelNama.setForeground(new java.awt.Color(255, 255, 255));
        labelNama.setText("Data Kategori");

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNama, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNama, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        lbTanggal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbTanggal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTanggal.setText("Tanggal");
        lbTanggal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelKodeKategori.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelKodeKategori.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelKodeKategori.setText("Kode Kategori");
        labelKodeKategori.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelNamaKategori.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNamaKategori.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelNamaKategori.setText("Nama Kategori");
        labelNamaKategori.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelKeterangan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelKeterangan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelKeterangan.setText("Keterangan");
        labelKeterangan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtKodeKategori.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtKodeKategori.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKodeKategoriKeyPressed(evt);
            }
        });

        txtNamaKategori.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNamaKategori.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNamaKategoriKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText(":");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText(":");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText(":");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText(":");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        tabelKategori.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelKategori.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tabelKategori.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabelKategori.setRowHeight(30);
        tabelKategori.setRowMargin(2);
        tabelKategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelKategoriMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelKategori);

        btnSimpan.setBackground(new java.awt.Color(204, 204, 204));
        btnSimpan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.setContentAreaFilled(false);
        btnSimpan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSimpan.setOpaque(true);
        btnSimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSimpanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSimpanMouseExited(evt);
            }
        });
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnUbah.setBackground(new java.awt.Color(204, 204, 204));
        btnUbah.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnUbah.setText("Ubah");
        btnUbah.setContentAreaFilled(false);
        btnUbah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUbah.setOpaque(true);
        btnUbah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUbahMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUbahMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUbahMouseExited(evt);
            }
        });
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(204, 204, 204));
        btnHapus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.setContentAreaFilled(false);
        btnHapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHapus.setOpaque(true);
        btnHapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHapusMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHapusMouseExited(evt);
            }
        });
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnBersih.setBackground(new java.awt.Color(204, 204, 204));
        btnBersih.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBersih.setText("Bersih");
        btnBersih.setContentAreaFilled(false);
        btnBersih.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBersih.setOpaque(true);
        btnBersih.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBersihMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBersihMouseExited(evt);
            }
        });
        btnBersih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBersihActionPerformed(evt);
            }
        });

        btnCari.setBackground(new java.awt.Color(204, 204, 204));
        btnCari.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCari.setText("Pencarian");
        btnCari.setContentAreaFilled(false);
        btnCari.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCari.setOpaque(true);
        btnCari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCariMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCariMouseExited(evt);
            }
        });
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        txtCari.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCariKeyTyped(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setBackground(new java.awt.Color(255, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Info_30px_6.png"))); // NOI18N
        jLabel1.setText("   Information");
        jLabel1.setOpaque(true);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("\n   * Form ini digunakan untuk menyimpan data\n      kategori baru\n   * Tekan TAMBAH untuk menyimpan data\n   * Tekan UBAH untuk mengedit data\n   * Tekan BERSIH untuk membersihkan field\n   * Tekan HAPUS untuk menghapus data");
        jScrollPane3.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        txtKeterangan.setColumns(20);
        txtKeterangan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtKeterangan.setRows(5);
        jScrollPane2.setViewportView(txtKeterangan);

        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelKodeKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelNamaKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton1))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtKodeKategori)
                                .addComponent(txtNamaKategori))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBersih, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCari)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(137, 137, 137)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBersih, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jRadioButton1)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                    .addComponent(jTextField2))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(txtKodeKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(txtNamaKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(labelKodeKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(labelNamaKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseEntered
        btnClose.setBackground(Color.red);
    }//GEN-LAST:event_btnCloseMouseEntered

    private void btnCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseExited
        btnClose.setBackground(new Color(204,102,255));
    }//GEN-LAST:event_btnCloseMouseExited

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void panelHeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelHeaderMouseDragged
        if(maximixed){
            int x = evt.getXOnScreen();
            int y = evt.getYOnScreen();
            this.setLocation(x - xMouse, y - yMouse);
        }
    }//GEN-LAST:event_panelHeaderMouseDragged

    private void panelHeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelHeaderMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_panelHeaderMousePressed

    private void btnPilihTanggalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPilihTanggalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPilihTanggalMouseClicked

    private void btnPilihTanggalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnPilihTanggalKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPilihTanggalKeyPressed

    private void tabelKategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelKategoriMouseClicked
        int bar = tabelKategori.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();

        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        Date dateValue = null;
        try{
            dateValue = date.parse((String)tabelKategori.getValueAt(bar, 1));
        } catch (ParseException ex){
            Logger.getLogger(dataKategori.class.getName()).log(Level.SEVERE, null, ex);
        }

        jTextField2.setText(b);
        txtKodeKategori.setText(c);
        txtNamaKategori.setText(d);
        txtKeterangan.setText(e);
    }//GEN-LAST:event_tabelKategoriMouseClicked

    private void btnSimpanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSimpanMouseEntered
        btnSimpan.setBackground(new Color(0,0,204));
        btnSimpan.setForeground(Color.white);
    }//GEN-LAST:event_btnSimpanMouseEntered

    private void btnSimpanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSimpanMouseExited
        btnSimpan.setBackground(new Color(204,204,204));
        btnSimpan.setForeground(Color.black);
    }//GEN-LAST:event_btnSimpanMouseExited

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        if(txtKodeKategori.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Kode Kategori tidak boleh kosong");
        } else if (txtNamaKategori.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Nama Kategori tidak boleh kosong");
        } else {
        String sql = "insert into tb_kategori values (?,?,?,?)";
        String tampilan = "dd-MM-yyyy";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
       
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, jTextField2.getText());
            stat.setString(2, txtKodeKategori.getText());
            stat.setString(3, txtNamaKategori.getText());
            stat.setString(4, txtKeterangan.getText());
            stat.execute();
            JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan");
            //            String refresh = "select * from tb_kategori";
            kosong();
            dataTable();
            lebarKolom();
            txtKodeKategori.requestFocus();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan"+e);
        }
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahMouseEntered
        btnUbah.setBackground(new Color(0,0,204));
        btnUbah.setForeground(Color.white);
    }//GEN-LAST:event_btnUbahMouseEntered

    private void btnUbahMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahMouseExited
        btnUbah.setBackground(new Color(204,204,204));
        btnUbah.setForeground(Color.black);
    }//GEN-LAST:event_btnUbahMouseExited

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        String sql = "UPDATE tb_kategori set tanggal=?,kode_kategori=?,nama_kategori=?,keterangan=? where kode_kategori='"+txtKodeKategori.getText()+"'";
        
       
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, jTextField2.getText());
            stat.setString(2, txtKodeKategori.getText());
            stat.setString(3, txtNamaKategori.getText());
            stat.setString(4, txtKeterangan.getText());
            stat.execute();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
            //String refresh="SELECT * FROM tb_kategori";
            kosong();
            dataTable();
            lebarKolom();
            txtKodeKategori.requestFocus();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah"+e);
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseEntered
        btnHapus.setBackground(Color.red);
        btnHapus.setForeground(Color.white);
    }//GEN-LAST:event_btnHapusMouseEntered

    private void btnHapusMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseExited
        btnHapus.setBackground(new Color(204,204,204));
        btnHapus.setForeground(Color.black);
    }//GEN-LAST:event_btnHapusMouseExited

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int ok = JOptionPane.showConfirmDialog (null," Apakah Anda Yakin Ingin "
            + "Menghapus Data","Konfirmasi Dialog", JOptionPane.YES_NO_OPTION);
        if (ok==0){
            String sql="delete from tb_kategori where kode_kategori='"+txtKodeKategori.getText()+"'";
            try {
                PreparedStatement stat=conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus");
                kosong();
                dataTable();
                lebarKolom();
                txtKodeKategori.requestFocus();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Dihapus"+e);
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBersihMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBersihMouseEntered
        btnBersih.setBackground(new Color(0,0,204));
        btnBersih.setForeground(Color.white);
    }//GEN-LAST:event_btnBersihMouseEntered

    private void btnBersihMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBersihMouseExited
        btnBersih.setBackground(new Color(204,204,204));
        btnBersih.setForeground(Color.black);
    }//GEN-LAST:event_btnBersihMouseExited

    private void btnBersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBersihActionPerformed
    
        txtKodeKategori.requestFocus();
        txtKodeKategori.setText(null);
        txtNamaKategori.setText(null);
        txtKeterangan.setText(null);
    }//GEN-LAST:event_btnBersihActionPerformed

    private void btnCariMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCariMouseEntered
        btnCari.setBackground(new Color(0,0,204));
        btnCari.setForeground(Color.white);
    }//GEN-LAST:event_btnCariMouseEntered

    private void btnCariMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCariMouseExited
        btnCari.setBackground(new Color(204,204,204));
        btnCari.setForeground(Color.black);
    }//GEN-LAST:event_btnCariMouseExited

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed

    }//GEN-LAST:event_btnCariActionPerformed

    private void txtCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyTyped
        String sqlPencarian = "select * from tb_kategori where kode_kategori like '%"+txtCari.getText()+"%' or nama_kategori like '%"+txtCari.getText()+"%'";
        pencarian(sqlPencarian);
        lebarKolom();
    }//GEN-LAST:event_txtCariKeyTyped

    private void txtKodeKategoriKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKodeKategoriKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            txtNamaKategori.requestFocus();
        }
    }//GEN-LAST:event_txtKodeKategoriKeyPressed

    private void txtNamaKategoriKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaKategoriKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            txtKeterangan.requestFocus();
        }
    }//GEN-LAST:event_txtNamaKategoriKeyPressed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
           if (jRadioButton1.isSelected()) {
            tanggal();
            
        } else {
            jRadioButton1.setText(null);
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void btnUbahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUbahMouseClicked

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
            java.util.logging.Logger.getLogger(dataKategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dataKategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dataKategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dataKategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            dataKategori dialog = new dataKategori(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBersih;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel labelKeterangan;
    private javax.swing.JLabel labelKodeKategori;
    private javax.swing.JLabel labelNama;
    private javax.swing.JLabel labelNamaKategori;
    private javax.swing.JLabel lbTanggal;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JTable tabelKategori;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextArea txtKeterangan;
    private javax.swing.JTextField txtKodeKategori;
    private javax.swing.JTextField txtNamaKategori;
    // End of variables declaration//GEN-END:variables
}