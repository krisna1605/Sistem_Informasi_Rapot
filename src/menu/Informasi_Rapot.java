package menu;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KrisnaArisandi
 */
public class Informasi_Rapot extends javax.swing.JFrame {

    public String namaxx, nis;
    private Connection con;
    private Statement stat;
    private ResultSet res;

    public Informasi_Rapot() {
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage("src/Gambar/pic/logo.png");
        setIconImage(icon);
        koneksi();
    }

    private void koneksi() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/db_sistem_rapot", "root", "");
            stat = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void itemTerpilih() {
        Data_Siswa Pp = new Data_Siswa();
        Pp.sp = this;
        namasis.setText(namaxx);
        nissis.setText(nis);
    }
    
    public void data() {
        try {
            String semester = (null);
            if (gjl.isSelected()) {
                semester = "1 GANJIL";
            } else if (gnp.isSelected()) {
                semester = "2 GENAP";
            }
            res = stat.executeQuery("select * from data_nilai where nama_siswa='" + namasis.getText() + "' and nis = '" + nissis.getText() + "' and kelas = '" + kelasss.getSelectedItem() + "' and semester = '" + semester + "'");
            if (res.next()) {
                if (nissis.getText().equals(res.getString("nis"))) {
                    kelas.setText(res.getString("kelas"));
                    semseter.setText(res.getString("semester"));
                    tahun.setText(res.getString("tahun_pelajaran"));
                    agama.setText(res.getString("agama"));
                    pkn.setText(res.getString("pkn"));
                    bi.setText(res.getString("bindo"));
                    mtk.setText(res.getString("mtk"));
                    ipa.setText(res.getString("ipa"));
                    ips.setText(res.getString("ips"));
                    kk.setText(res.getString("kerjinan"));
                    pj.setText(res.getString("penjas"));
                    total.setText(res.getString("total"));
                    String X = (null);
                    if (gjl.isSelected()) {
                        X = "1 GANJIL";
                    } else if (gnp.isSelected()) {
                        X = "2 GENAP";
                        int tot = Integer.parseInt(total.getText());
                        int hasil = 490;
                        if (tot > hasil) {
                            status.setText("NAIK KELAS");
                        } else {
                            status.setText("TIDAK NAIK");
                        }
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "terjadi kesalahan");
        }
    }

    private void tabel_siswa() {

        Object[] Baris = {"NO INDUK SISWA", "NAMA", "JENIS KELAMIN"};
        DefaultTableModel tabmode = new DefaultTableModel(null, Baris);
        try {
            String sql = "SELECT * FROM data_SISWA order by nama_siswa asc";
            stat = con.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                tabmode.addRow(new Object[]{
                    hasil.getString(1),
                    hasil.getString(2),
                    hasil.getString(3),});
            }
            tabel_siswa.setModel(tabmode);
        } catch (SQLException e) {
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

        datasiswa = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_siswa = new javax.swing.JTable();
        semesterrr = new javax.swing.ButtonGroup();
        cover = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        namasis = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nissis = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        sd1 = new Gambar.pic.sd();
        jLabel15 = new javax.swing.JLabel();
        kelasss = new javax.swing.JComboBox<>();
        gjl = new javax.swing.JRadioButton();
        gnp = new javax.swing.JRadioButton();
        data = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        kelas = new javax.swing.JLabel();
        semseter = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel33 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel34 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        tahun = new javax.swing.JLabel();
        agama = new javax.swing.JLabel();
        pkn = new javax.swing.JLabel();
        bi = new javax.swing.JLabel();
        mtk = new javax.swing.JLabel();
        ipa = new javax.swing.JLabel();
        ips = new javax.swing.JLabel();
        kk = new javax.swing.JLabel();
        pj = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();

        datasiswa.setIconImage(null);

        jPanel4.setBackground(new java.awt.Color(255, 0, 0));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Data Siswa");

        tabel_siswa.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_siswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_siswaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_siswa);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout datasiswaLayout = new javax.swing.GroupLayout(datasiswa.getContentPane());
        datasiswa.getContentPane().setLayout(datasiswaLayout);
        datasiswaLayout.setHorizontalGroup(
            datasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, datasiswaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        datasiswaLayout.setVerticalGroup(
            datasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datasiswaLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("RAPOT SISWA");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new java.awt.CardLayout());

        cover.setBackground(new java.awt.Color(51, 51, 51));
        cover.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 7, true));
        cover.setForeground(new java.awt.Color(0, 51, 153));
        cover.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NAMA");
        cover.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 364, -1, -1));

        namasis.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cover.add(namasis, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, 180, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NISN / NIS");
        cover.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, -1, -1));

        nissis.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cover.add(nissis, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 400, 180, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/rapot/icons8_List_50px.png"))); // NOI18N
        jLabel3.setText("DAFTAR SISWA");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        cover.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/rapot/icons8_End_48px.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        cover.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 630, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/rapot/icons8_Close_Window_48px.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        cover.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, -1, -1));

        sd1.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout sd1Layout = new javax.swing.GroupLayout(sd1);
        sd1.setLayout(sd1Layout);
        sd1Layout.setHorizontalGroup(
            sd1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 137, Short.MAX_VALUE)
        );
        sd1Layout.setVerticalGroup(
            sd1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 124, Short.MAX_VALUE)
        );

        cover.add(sd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("LAPORAN PENILAIAN SEKOLAH DASAR");
        cover.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, -1));

        kelasss.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "I / SATU", "II / DUA", "III / TIGA", "IV / EMPAT", "V / LIMA", "VI / ENAM" }));
        cover.add(kelasss, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, 270, -1));

        semesterrr.add(gjl);
        gjl.setText("1 GANJIL ");
        cover.add(gjl, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 470, 80, -1));

        semesterrr.add(gnp);
        gnp.setText("2 GENAP");
        cover.add(gnp, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 500, 80, -1));

        getContentPane().add(cover, "card4");

        data.setBackground(new java.awt.Color(255, 255, 255));
        data.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 7, true));
        data.setForeground(new java.awt.Color(0, 51, 153));
        data.setMinimumSize(new java.awt.Dimension(688, 688));
        data.setPreferredSize(new java.awt.Dimension(688, 688));
        data.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("NAMA");
        data.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 368, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/rapot/icons8_Skip_to_Start_48px.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        data.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 630, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/rapot/icons8_Close_Window_48px.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        data.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(565, 8, -1, -1));

        jLabel11.setText("Kelas");
        data.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 8, -1, -1));

        jLabel13.setText("Semester ke");
        data.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 30, -1, -1));

        jLabel14.setText("Tahun Pelajaran");
        data.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 52, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        data.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 680, 10));

        jLabel8.setText("No.");
        data.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel12.setText("Nilai");
        data.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, -1, -1));
        data.add(kelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 8, -1, -1));
        data.add(semseter, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 30, -1, -1));
        data.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 380, -1, -1));

        jLabel16.setText("1.");
        data.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 132, -1, -1));

        jLabel17.setText("Pendidikan Agama");
        data.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        status.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        data.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 380, -1, -1));

        jLabel19.setText("8.");
        data.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        data.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 12, 320));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        data.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, 320));

        jLabel21.setText("2.");
        data.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel22.setText("Pendidikan Pancasila dan Kewarganegaraan");
        data.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jLabel23.setText("Bahasa Indonesia");
        data.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        jLabel24.setText("3.");
        data.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel25.setText("4.");
        data.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jLabel26.setText("Matematika");
        data.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        jLabel27.setText("Ilmu Pengetahuan Alam (IPA)");
        data.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        jLabel28.setText("Ilmu Pengetahuan Sosial (IPS)");
        data.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        jLabel29.setText("Kerajinan Tangan dan Kesenian");
        data.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        jLabel30.setText("5.");
        data.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jLabel31.setText("6.");
        data.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        jLabel32.setText("7.");
        data.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        data.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 82, 680, 10));

        jLabel33.setText("Pendidikan Jasmani dan Kesehatan");
        data.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        data.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 680, 10));

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        data.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 680, 10));

        jLabel34.setText("Mata Pelajaran");
        data.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        data.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 12, 320));
        data.add(tahun, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 52, -1, -1));
        data.add(agama, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, -1, -1));
        data.add(pkn, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, -1, -1));
        data.add(bi, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, -1, -1));
        data.add(mtk, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, -1, -1));
        data.add(ipa, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, -1, -1));
        data.add(ips, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, -1, -1));
        data.add(kk, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, -1, -1));
        data.add(pj, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, -1, -1));

        jLabel35.setText("Total");
        data.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, -1));

        getContentPane().add(data, "card4");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        tabel_siswa();
        datasiswa.setBounds(300, 300, 700, 590);
        datasiswa.setVisible(true);
        ImageIcon ico = new ImageIcon("src/Gambar/pic/logo.png");
        setIconImage(ico.getImage());
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        data.setVisible(true);
        cover.setVisible(false);
        data();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        //new Menu_Utama().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        data.setVisible(false);
        cover.setVisible(true);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void tabel_siswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_siswaMouseClicked
        int i = tabel_siswa.getSelectedRow();
        if (i == -1) {
            return;
        }
        String no = (String) tabel_siswa.getValueAt(i, 0);
        nissis.setText(no);
        String nama = (String) tabel_siswa.getValueAt(i, 1);
        namasis.setText(nama);
    }//GEN-LAST:event_tabel_siswaMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        ImageIcon ico = new ImageIcon("src/Gambar/pic/logo.png");
        setIconImage(ico.getImage());
    }//GEN-LAST:event_formWindowActivated

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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Informasi_Rapot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Informasi_Rapot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Informasi_Rapot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Informasi_Rapot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new RunnableImpl());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel agama;
    private javax.swing.JLabel bi;
    private javax.swing.JPanel cover;
    private javax.swing.JPanel data;
    private javax.swing.JDialog datasiswa;
    private javax.swing.JRadioButton gjl;
    private javax.swing.JRadioButton gnp;
    private javax.swing.JLabel ipa;
    private javax.swing.JLabel ips;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel kelas;
    private javax.swing.JComboBox<String> kelasss;
    private javax.swing.JLabel kk;
    private javax.swing.JLabel mtk;
    private javax.swing.JTextField namasis;
    private javax.swing.JTextField nissis;
    private javax.swing.JLabel pj;
    private javax.swing.JLabel pkn;
    private Gambar.pic.sd sd1;
    private javax.swing.ButtonGroup semesterrr;
    private javax.swing.JLabel semseter;
    private javax.swing.JLabel status;
    private javax.swing.JTable tabel_siswa;
    private javax.swing.JLabel tahun;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables

    private static class RunnableImpl implements Runnable {

        public RunnableImpl() {
        }

        @Override
        public void run() {
            new Informasi_Rapot().setVisible(true);
        }
    }
}
