/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tokobangunan;

import java.awt.Color;
import java.io.File;
import java.io.InputStream;
import java.sql.*;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import tokobangunan.Components.RoundJTextField;

import tokobangunan.Components.RoundedPanel;

/**
 *
 * @author jinry
 */
public class CheckoutTransaksi extends javax.swing.JFrame {

    private String kodeFaktur = "";
    public void kodeTransaksi(String kode){

        try {
            String sql = "SELECT kd_transaksi FROM `transaksi` WHERE kd_transaksi = '"+ kode +"';";
            Connection conn = (Connection) Config.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            if (rs.next()) {
                String transaksi = rs.getString("kd_transaksi");
                if (transaksi.equals(kode)){
                    kodeFaktur = kode;
                    this.nomorFaktur.setText(kodeFaktur);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }




    /**
     * Creates new form CheckoutTransaksi
     */
    public CheckoutTransaksi() {
        initComponents();
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
        jPanel4 = new javax.swing.JPanel();
        btnDashboard = new javax.swing.JLabel();
        btnLogout = new javax.swing.JLabel();
        btnHistory = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        namaKaryawan = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        checkoutTable = new RoundedPanel(10, new Color(187, 225, 250));
        jScrollPane1 = new javax.swing.JScrollPane();
        noteTable = new javax.swing.JTable();
        nomorFaktur = new javax.swing.JLabel();
        karyawanCheckout = new javax.swing.JLabel();
        tanggal = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnBack = new javax.swing.JLabel();
        totalPriceField = new RoundJTextField(10);
        totalPayField = new RoundJTextField(10);
        totalChangeField = new RoundJTextField(10);
        btnPrint = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1360, 760));

        jPanel4.setBackground(new java.awt.Color(50, 130, 184));

        btnDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn-dashboard-primary.png"))); // NOI18N
        btnDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn-dashboard-secondary.png")));
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn-dashboard-primary.png")));
            }
        });
        btnDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDashboardMouseClicked(evt);
            }
        });

        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn-logout-primary.png"))); // NOI18N
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn-logout-secondary.png")));
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn-logout-primary.png")));
            }
        });
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
        });

        btnHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn-history-primary.png"))); // NOI18N
        btnHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn-history-secondary.png")));
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn-history-primary.png")));
            }
        });
        btnHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHistoryMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnDashboard)
            .addComponent(btnLogout)
            .addComponent(btnHistory)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btnDashboard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHistory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogout)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(50, 130, 184));

        namaKaryawan.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        namaKaryawan.setForeground(new java.awt.Color(255, 255, 255));
        namaKaryawan.setText("namaKaryawan");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/CrafterPOS-logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 915, Short.MAX_VALUE)
                .addComponent(namaKaryawan)
                .addGap(64, 64, 64))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(namaKaryawan))
                .addGap(36, 36, 36))
        );

        checkoutTable.setBackground(null);

        noteTable.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        noteTable.getTableHeader().setFont(new java.awt.Font("Lato", 1, 14));
        noteTable.getTableHeader().setBackground(null);
        noteTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Kode Transaksi", "Kode Item", "Nama Item", "Harga", "Kuantitas",  "Total"
            }
        ));
        noteTable.setEnabled(false);
        noteTable.setGridColor(new java.awt.Color(187, 225, 250));
        noteTable.setShowGrid(false);
        noteTable.setOpaque(false);
        ((DefaultTableCellRenderer)noteTable.getDefaultRenderer(Object.class)).setOpaque(false);
        jScrollPane1.setViewportView(noteTable);
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);

        nomorFaktur.setBackground(new java.awt.Color(30, 32, 34));
        nomorFaktur.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        nomorFaktur.setForeground(new java.awt.Color(30, 32, 34));
        nomorFaktur.setText("Kode Faktur : NT0001");

        karyawanCheckout.setBackground(new java.awt.Color(30, 32, 34));
        karyawanCheckout.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        karyawanCheckout.setForeground(new java.awt.Color(30, 32, 34));
        karyawanCheckout.setText("Kasir : Karyawan Arifin");
        karyawanCheckout.setToolTipText("");

        tanggal.setBackground(new java.awt.Color(30, 32, 34));
        tanggal.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        tanggal.setForeground(new java.awt.Color(30, 32, 34));
        tanggal.setText("22/11/2021");

        jLabel5.setBackground(new java.awt.Color(30, 32, 34));
        jLabel5.setFont(new java.awt.Font("Lato", 1, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(30, 32, 34));
        jLabel5.setText("Total");

        jLabel6.setBackground(new java.awt.Color(30, 32, 34));
        jLabel6.setFont(new java.awt.Font("Lato", 1, 22)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(30, 32, 34));
        jLabel6.setText("Bayar");

        jLabel7.setBackground(new java.awt.Color(30, 32, 34));
        jLabel7.setFont(new java.awt.Font("Lato", 1, 22)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(30, 32, 34));
        jLabel7.setText("Kembali");

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_back_primary.png"))); // NOI18N
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_back_secondary.png")));
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_back_primary.png")));
            }
        });
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackMouseClicked(evt);
            }
        });

        totalPriceField.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        totalPriceField.setEnabled(false);

        totalPayField.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        totalPayField.setEnabled(false);

        totalChangeField.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        totalChangeField.setEnabled(false);

        btnPrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_print_secondary.png")));
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_print_primary.png")));
            }
        });
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_print_primary.png"))); // NOI18N
        btnPrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrintMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout checkoutTableLayout = new javax.swing.GroupLayout(checkoutTable);
        checkoutTable.setLayout(checkoutTableLayout);
        checkoutTableLayout.setHorizontalGroup(
            checkoutTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkoutTableLayout.createSequentialGroup()
                .addGroup(checkoutTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, checkoutTableLayout.createSequentialGroup()
                        .addGroup(checkoutTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, checkoutTableLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(checkoutTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(checkoutTableLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(29, 29, 29)
                                        .addComponent(totalPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(checkoutTableLayout.createSequentialGroup()
                                        .addGroup(checkoutTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(29, 29, 29)
                                        .addGroup(checkoutTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(totalChangeField, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(totalPayField, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, checkoutTableLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(nomorFaktur)
                                .addGap(209, 209, 209)
                                .addComponent(karyawanCheckout)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(checkoutTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tanggal, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, checkoutTableLayout.createSequentialGroup()
                                .addGroup(checkoutTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnPrint)
                                    .addComponent(btnBack))
                                .addGap(27, 27, 27))))
                    .addGroup(checkoutTableLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        checkoutTableLayout.setVerticalGroup(
            checkoutTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkoutTableLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(checkoutTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomorFaktur)
                    .addComponent(karyawanCheckout)
                    .addComponent(tanggal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addGroup(checkoutTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(checkoutTableLayout.createSequentialGroup()
                        .addGroup(checkoutTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(checkoutTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalPayField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(checkoutTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalChangeField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(checkoutTableLayout.createSequentialGroup()
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkoutTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(checkoutTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
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
    }// </editor-fold>//GEN-END:initComponents



    private String kodeProfileKaryawan = "";
    public void kodeProfile(String kode){

        try {
            String sql = "SELECT `kd_profil`, `nama`, `kd_akun`, `role` FROM `profil` WHERE kd_profil = '"+ kode +
                    "';";
            Connection conn = (Connection) Config.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            if (rs.next()) {
                String profil = rs.getString("kd_profil");
                if (profil.equals(kode)){
                    this.namaKaryawan.setText(rs.getString("nama"));
                    this.karyawanCheckout.setText("Kasir : " + rs.getString("nama"));
                    kodeProfileKaryawan = kode;
                }
            } else {
                JOptionPane.showMessageDialog(null, null);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }
    
    private void btnDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDashboardMouseClicked
        try {
            String sql = "SELECT * FROM `profil` WHERE kd_profil = '"+ kodeProfileKaryawan +"';";
            Connection conn = (Connection) Config.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            if (rs.next()) {
                DashboardKaryawan DashKaryawan = new DashboardKaryawan();
                DashboardAdmin DashAdmin = new DashboardAdmin();
                String nama = rs.getString("nama");
                String role = rs.getString("role");
                if (role.equals("admin")){
                    DashAdmin.kodeProfile(rs.getString("kd_profil"));
                    DashAdmin.setVisible(true);
                    this.setVisible(false);
                }
                else if (role.equals("kasir")) {
                    DashKaryawan.kodeProfile(rs.getString("kd_profil"));
                    DashKaryawan.setVisible(true);
                    this.setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Invalid");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnDashboardMouseClicked

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        // TODO add your handling code here:
        new LoginPage().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnLogoutMouseClicked

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        // TODO add your handling code here:
        try {
            String sql = "SELECT * FROM `profil` WHERE kd_profil = '"+ kodeProfileKaryawan +"';";
            Connection conn = (Connection) Config.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            if (rs.next()) {
                Transaksi tr = new Transaksi();
                String nama = rs.getString("nama");
                String role = rs.getString("role");
                if (role.equals("admin")){
                    tr.kodeProfile(rs.getString("kd_profil"));
                    tr.setVisible(true);
                    this.setVisible(false);
                }
                else if (role.equals("kasir")) {
                    tr.kodeProfile(rs.getString("kd_profil"));
                    tr.setVisible(true);
                    this.setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Invalid");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnBackMouseClicked

    private void btnHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHistoryMouseClicked
        try {
            String sql = "SELECT * FROM `profil` WHERE kd_profil = '"+ kodeProfileKaryawan +"';";
            Connection conn = (Connection) Config.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            if (rs.next()) {
                RiwayatTransaksi historyTransaction = new RiwayatTransaksi();
                String nama = rs.getString("nama");
                String role = rs.getString("role");
                if (role.equals("admin")){
                    historyTransaction.kodeProfile(rs.getString("kd_profil"));
                    historyTransaction.setVisible(true);
                    this.setVisible(false);
                }
                else if (role.equals("kasir")) {
                    historyTransaction.kodeProfile(rs.getString("kd_profil"));
                    historyTransaction.setVisible(true);
                    this.setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Invalid");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnHistoryMouseClicked

    private void btnPrintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrintMouseClicked
        try {
            java.sql.Connection conn = (Connection)Config.configDB();
            InputStream report = getClass().getResourceAsStream("PrintReport.jasper");
            HashMap kode = new HashMap();
            kode.put("kode", kodeFaktur);

            JasperPrint jp = JasperFillManager.fillReport(report, kode, conn);
            JasperViewer.viewReport(jp, false);


        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnPrintMouseClicked

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
            java.util.logging.Logger.getLogger(CheckoutTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckoutTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckoutTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckoutTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckoutTransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBack;
    private javax.swing.JLabel btnDashboard;
    private javax.swing.JLabel btnHistory;
    private javax.swing.JLabel btnLogout;
    private javax.swing.JLabel btnPrint;
    private javax.swing.JPanel checkoutTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel karyawanCheckout;
    public javax.swing.JLabel namaKaryawan;
    public javax.swing.JLabel nomorFaktur;
    public javax.swing.JTable noteTable;
    public javax.swing.JLabel tanggal;
    public javax.swing.JTextField totalChangeField;
    public javax.swing.JTextField totalPayField;
    public javax.swing.JTextField totalPriceField;
    // End of variables declaration//GEN-END:variables

}
