/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tokobangunan;

import java.awt.Color;
import java.sql.*;

import tokobangunan.Components.RoundJPasswordField;
import tokobangunan.Components.RoundJTextField;
import tokobangunan.Components.RoundedPanel;
import javax.swing.JOptionPane ;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class Karyawan extends javax.swing.JFrame {

    private String kodeAkun = "";
    private void autonumberKodeAkun(){
        try {
            Connection c = (Connection) Config.configDB();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM akun ORDER BY kd_akun DESC;";
            ResultSet r = s.executeQuery(sql);
            if (r.next()) {
                String kdAkun = r.getString("kd_akun").substring(2);
                String KA = "" +(Integer.parseInt(kdAkun)+1);
                String Nol = "";

                if(KA.length()==1)
                {Nol = "000";}
                else if(KA.length()==2)
                {Nol = "00";}
                else if(KA.length()==3)
                {Nol = "0";}
                else if(KA.length()==4)
                {Nol = "";}
                kodeAkun = "KA" + Nol + KA;
            } else {
                kodeAkun = "TR0001";
            }
            r.close();
            s.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private String kodeProfil = "";
    private void autonumberKodeProfile(){
        try {
            Connection c = (Connection) Config.configDB();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM profil ORDER BY kd_profil DESC;";
            ResultSet r = s.executeQuery(sql);
            if (r.next()) {
                String NoFaktur = r.getString("kd_profil").substring(2);
                String TR = "" +(Integer.parseInt(NoFaktur)+1);
                String Nol = "";

                if(TR.length()==1)
                {Nol = "00";}
                else if(TR.length()==2)
                {Nol = "0";}
                else if(TR.length()==3)
                {Nol = "";}

                kodeProfil = "KP" + Nol + TR;
            } else {
                kodeProfil = "KP001";
            }
            r.close();
            s.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    public void table() {

        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Kode Karyawan");
        tbl.addColumn("Nama Karyawan");
        tbl.addColumn("Status Karyawan");
        tbl.addColumn("Username");

        try {
            Statement st = (Statement) Config.configDB().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM profil JOIN akun ON profil.kd_akun = akun.kd_akun;");

            while (rs.next()) {
                tbl.addRow(new Object[] {

                        rs.getString("kd_profil"),
                        rs.getString("nama"),
                        rs.getString("role"),
                        rs.getString("username"),
                         });
                tableKaryawan.setModel(tbl);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void utama(){
        namaKaryawanField.setText("");
        usernameKaryawanField.setText("");
        passwordKaryawanField.setText("");
        autonumberKodeAkun();
        autonumberKodeProfile();
    }

    public void clear(){
        namaKaryawanField.setText("");
        usernameKaryawanField.setText("");
        passwordKaryawanField.setText("");
    }

    public Karyawan() {
        initComponents();
        table();
        utama();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnDashboard = new javax.swing.JLabel();
        btnHistory = new javax.swing.JLabel();
        btnLogout = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        namaKaryawan = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        warehousePanel = new RoundedPanel(10, new Color(187, 225, 250));
        jScrollPane3 = new javax.swing.JScrollPane();
        tableKaryawan = new javax.swing.JTable();
        warehouseFormPanel1 = new RoundedPanel(10, new Color(187, 225, 250));
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        namaKaryawanField = new RoundJTextField(4);
        btnEnter = new javax.swing.JLabel();
        btnDelete = new javax.swing.JLabel();
        passwordKaryawanField = new RoundJPasswordField(10);
        statusKaryawanBox = new javax.swing.JComboBox<>();
        btnEdit = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        usernameKaryawanField = new RoundJTextField(4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1360, 760));

        jPanel5.setBackground(new java.awt.Color(50, 130, 184));

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

        btnHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn-history-secondary.png")));
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn-history-primary.png")));
            }
        });
        btnHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn-history-primary.png"))); // NOI18N
        btnHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHistoryMouseClicked(evt);
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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnDashboard)
            .addComponent(btnHistory)
            .addComponent(btnLogout)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(btnDashboard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHistory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogout)
                .addGap(0, 387, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(50, 130, 184));

        namaKaryawan.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        namaKaryawan.setForeground(new java.awt.Color(255, 255, 255));
        namaKaryawan.setText("namaKaryawan");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/CrafterPOS-logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(namaKaryawan)
                .addGap(48, 48, 48))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(namaKaryawan))
                .addGap(36, 36, 36))
        );

        warehousePanel.setBackground(null);

        tableKaryawan.getTableHeader().setFont(new java.awt.Font("Lato", 1, 14));
        tableKaryawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Kode Karyawan", "Nama Karyawan", "Status karyawan", "Username"
            }
        ));
        tableKaryawan.setShowGrid(false);
        tableKaryawan.setOpaque(false);
        ((DefaultTableCellRenderer)tableKaryawan.getDefaultRenderer(Object.class)).setOpaque(false);
        tableKaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableKaryawanMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableKaryawan);
        jScrollPane3.setOpaque(false);
        jScrollPane3.getViewport().setOpaque(false);

        javax.swing.GroupLayout warehousePanelLayout = new javax.swing.GroupLayout(warehousePanel);
        warehousePanel.setLayout(warehousePanelLayout);
        warehousePanelLayout.setHorizontalGroup(
            warehousePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(warehousePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        warehousePanelLayout.setVerticalGroup(
            warehousePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(warehousePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        warehouseFormPanel1.setBackground(null);

        jLabel7.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabel7.setText("Password");

        jLabel8.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabel8.setText("Status Karyawan");

        jLabel9.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabel9.setText("Nama Karyawan");

        namaKaryawanField.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        namaKaryawanField.setForeground(new java.awt.Color(82, 97, 107));

        btnEnter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_enter_primary.png"))); // NOI18N
        btnEnter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnEnter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_enter_secondary.png")));
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnEnter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_enter_primary.png")));
            }
        });
        btnEnter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnterMouseClicked(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_delete_primary.png"))); // NOI18N
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_delete_secondary.png")));
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_delete_primary.png")));
            }
        });
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });

        passwordKaryawanField.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N

        statusKaryawanBox.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        statusKaryawanBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "kasir",}));

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn-edit-primary.png"))); // NOI18N
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn-edit-secondary.png")));
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn-edit-primary.png")));
            }
        });
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabel11.setText("Username");

        usernameKaryawanField.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        usernameKaryawanField.setForeground(new java.awt.Color(82, 97, 107));

        javax.swing.GroupLayout warehouseFormPanel1Layout = new javax.swing.GroupLayout(warehouseFormPanel1);
        warehouseFormPanel1.setLayout(warehouseFormPanel1Layout);
        warehouseFormPanel1Layout.setHorizontalGroup(
            warehouseFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(warehouseFormPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(warehouseFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(warehouseFormPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(26, 26, 26)
                        .addComponent(namaKaryawanField, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(warehouseFormPanel1Layout.createSequentialGroup()
                        .addGroup(warehouseFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11))
                        .addGap(26, 26, 26)
                        .addGroup(warehouseFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(warehouseFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(passwordKaryawanField, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(statusKaryawanBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(usernameKaryawanField, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                .addGroup(warehouseFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEnter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete))
                .addGap(31, 31, 31))
        );
        warehouseFormPanel1Layout.setVerticalGroup(
            warehouseFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(warehouseFormPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(warehouseFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(warehouseFormPanel1Layout.createSequentialGroup()
                        .addGroup(warehouseFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(namaKaryawanField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(warehouseFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(statusKaryawanBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(warehouseFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(usernameKaryawanField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(warehouseFormPanel1Layout.createSequentialGroup()
                        .addComponent(btnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(warehouseFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(passwordKaryawanField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(warehousePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(warehouseFormPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(warehousePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(warehouseFormPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getAccessibleContext().setAccessibleName("CrafterPOS");

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
        // TODO add your handling code here:
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


    private void btnEnterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnterMouseClicked

        String nama = namaKaryawanField.getText();
        String username = usernameKaryawanField.getText();

        try {
            Connection c = (Connection) Config.configDB();
            String sql =
                    "INSERT INTO `akun`(`kd_akun`, `username`, `pass`) VALUES ('"+ kodeAkun +"','"+ username +"'," +
                    "'"+ passwordKaryawanField.getText() +"')";
            PreparedStatement p = c.prepareStatement(sql);
            p.executeUpdate();
            p.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        try {
            Connection c = (Connection) Config.configDB();
            String role = statusKaryawanBox.getSelectedItem().toString();
            String sql =
                    "INSERT INTO `profil`(`kd_profil`, `nama`, `role`, `kd_akun`) VALUES ('"+ kodeProfil +
                            "','"+ nama +"','"+ role +"','"+ kodeAkun +"')";
            PreparedStatement p = c.prepareStatement(sql);
            p.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil menambahkan user");
            p.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        DefaultTableModel model = (DefaultTableModel) tableKaryawan.getModel();
        model.addRow(new Object[]{
                kodeProfil,
                nama,
                statusKaryawanBox.getSelectedItem().toString(),
                username
        });

        clear();
        utama();
        autonumberKodeAkun();
        autonumberKodeProfile();
    }//GEN-LAST:event_btnEnterMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked

        int row = tableKaryawan.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tableKaryawan.getModel();
        String kdProfil = model.getValueAt(row, 0).toString();
        String kdAkun = "";

        try {
            String sql = "SELECT `kd_profil`, `nama`, `kd_akun`, `role` FROM `profil` WHERE kd_profil = '"+ kdProfil +
                    "';";
            Connection conn = (Connection) Config.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            if (rs.next()) {
                kdAkun = rs.getString("kd_akun");
            } else {
                JOptionPane.showMessageDialog(null, null);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        try {
            Connection c = (Connection) Config.configDB();
            String sql =
                    "DELETE FROM profil WHERE kd_profil = '"+ kdProfil +"';";
            PreparedStatement p = c.prepareStatement(sql);
            p.executeUpdate();
            p.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        try {
            Connection c = (Connection) Config.configDB();
            String sql =
                    "DELETE FROM akun WHERE kd_akun = '"+ kdAkun +"';";
            PreparedStatement p = c.prepareStatement(sql);
            p.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil menghapus user");
            p.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        model.removeRow(row);
        clear();

    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        int row = tableKaryawan.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tableKaryawan.getModel();
        String kdProfil = model.getValueAt(row, 0).toString();
        String nama = namaKaryawanField.getText();
        String role = statusKaryawanBox.getSelectedItem().toString();
        String password = passwordKaryawanField.getText();
        String user = usernameKaryawanField.getText();
        String kdAkun = "";

        try {
            String sql = "SELECT * FROM profil JOIN akun ON profil.kd_akun = akun.kd_akun WHERE kd_profil = '"+ kdProfil +
                    "';";
            Connection conn = (Connection) Config.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            if (rs.next()) {
                kdAkun = rs.getString("kd_akun");
            } else {
                JOptionPane.showMessageDialog(null, null);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        try {
            Connection c = (Connection) Config.configDB();
            String sql =
                    "UPDATE `profil` SET `nama`='"+ nama +"',`role`='"+ role +"' WHERE kd_profil = '"+ kdProfil +"';";
            PreparedStatement p = c.prepareStatement(sql);
            p.executeUpdate();
            p.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        try {
            Connection c = (Connection) Config.configDB();
            String sql =
                    "UPDATE `akun` SET `username`='"+ user +"',`pass`='"+ password +"' WHERE kd_akun = '"+ kdAkun +"';";
            PreparedStatement p = c.prepareStatement(sql);
            p.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil mengubah data user");
            p.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        model.setValueAt(nama, row, 1);
        model.setValueAt(role, row, 2);
        model.setValueAt(user, row, 3);

    }//GEN-LAST:event_btnEditMouseClicked

    private void tableKaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableKaryawanMouseClicked

        int row = tableKaryawan.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tableKaryawan.getModel();
        String kdProfil = model.getValueAt(row, 0).toString();

        namaKaryawanField.setText(model.getValueAt(row, 1).toString());
        try {
            String sql = "SELECT * FROM profil JOIN akun ON profil.kd_akun = akun.kd_akun WHERE kd_profil = '"+ kdProfil +
                    "';";
            Connection conn = (Connection) Config.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            if (rs.next()) {
                String role = rs.getString("role");
                String password = rs.getString("pass");
                if(role.equals("admin")){
                    statusKaryawanBox.setSelectedIndex(0);
                }
                else if (role.equals("kasir")){
                    statusKaryawanBox.setSelectedIndex(1);
                }
                passwordKaryawanField.setText(password);
            } else {
                JOptionPane.showMessageDialog(null, null);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        usernameKaryawanField.setText(model.getValueAt(row, 3).toString());



    }//GEN-LAST:event_tableKaryawanMouseClicked

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        new LoginPage().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnLogoutMouseClicked

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
            java.util.logging.Logger.getLogger(Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Karyawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel btnDashboard;
    private javax.swing.JLabel btnDelete;
    private javax.swing.JLabel btnEdit;
    private javax.swing.JLabel btnEnter;
    private javax.swing.JLabel btnHistory;
    private javax.swing.JLabel btnLogout;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JLabel namaKaryawan;
    private javax.swing.JTextField namaKaryawanField;
    private javax.swing.JPasswordField passwordKaryawanField;
    private javax.swing.JComboBox<String> statusKaryawanBox;
    private javax.swing.JTable tableKaryawan;
    private javax.swing.JTextField usernameKaryawanField;
    private javax.swing.JPanel warehouseFormPanel1;
    private javax.swing.JPanel warehousePanel;
    // End of variables declaration//GEN-END:variables
}
