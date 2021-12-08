/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tokobangunan;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import jdk.nashorn.internal.scripts.JO;
import tokobangunan.Components.RoundJTextField;
import tokobangunan.Components.RoundedPanel;
/**
 *
 * @author Oki Firdaus Syah Putra
 */
public class Transaksi extends javax.swing.JFrame {


    String Tanggal;
    private DefaultTableModel model;

    public void totalBiaya(){
        int jumlahBaris = transactionTable.getRowCount();
        int totalBiaya = 0;
        int subTotal;
        for (int i = 0; i < jumlahBaris; i++) {
            subTotal = Integer.parseInt(transactionTable.getValueAt(i, 5).toString());
            totalBiaya = totalBiaya + subTotal;
        }
        totalField.setText(String.valueOf(totalBiaya));

    }

    public void jumlahBiaya(){
        int total = Integer.parseInt(totalField.getText());
        int bayar = Integer.parseInt(payField.getText());

        int kembalian = bayar - total;
        changeField.setText(String.valueOf(kembalian));
    }

    private void autonumber(){
        try {
            Connection c = (Connection) Config.configDB();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM transaksi ORDER BY kd_transaksi DESC;";
            ResultSet r = s.executeQuery(sql);
            if (r.next()) {
                String NoFaktur = r.getString("kd_transaksi").substring(2);
                String TR = "" +(Integer.parseInt(NoFaktur)+1);
                String Nol = "";

                if(TR.length()==1)
                {Nol = "000";}
                else if(TR.length()==2)
                {Nol = "00";}
                else if(TR.length()==3)
                {Nol = "0";}
                else if(TR.length()==4)
                {Nol = "";}
                idTransaksiFIeld.setText("TR" + Nol + TR);
            } else {
                idTransaksiFIeld.setText("TR0001");
            }
            r.close();
            s.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    public void loadData(){
        DefaultTableModel model = (DefaultTableModel) transactionTable.getModel();
        model.addRow(new Object[]{
                idTransaksiFIeld.getText(),
                kodeItemField.getText(),
                namaItemField.getText(),
                hargaItemField.getText(),
                kuantitasItemField.getText(),
                totalField.getText()
        });
    }

    public void kosong(){
        DefaultTableModel model = (DefaultTableModel) transactionTable.getModel();

        while (model.getRowCount()>0) {
            model.removeRow(0);
        }
    }

    public void utama(){
        idTransaksiFIeld.setText("");
        kodeItemField.setText("");
        namaItemField.setText("");
        hargaItemField.setText("");
        kuantitasItemField.setText("");
        autonumber();
    }

    public void clear(){
        totalField.setText("");
        payField.setText("");
        changeField.setText("");
    }

    public void clear2(){
        kodeItemField.setText("");
        namaItemField.setText("");
        hargaItemField.setText("");
        kuantitasItemField.setText("");
    }

    public void tambahTransaksi(){
        int jumlah, harga, total;

        jumlah = Integer.valueOf(kuantitasItemField.getText());
        harga = Integer.valueOf(hargaItemField.getText());

        total = jumlah * harga;
        totalField.setText(String.valueOf(total));

        loadData();
        totalBiaya();
        clear2();
        kodeItemField.requestFocus();
    }






    /**
     * Creates new form Transaksi
     */
    public Transaksi() {

        initComponents();
//        table();
        utama();
    }



    public void table() {

        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Kode transaksi");
        tbl.addColumn("Kode item");
        tbl.addColumn("Nama item");
        tbl.addColumn("Harga");
        tbl.addColumn("Kuantitas");
        tbl.addColumn("Total");

        try {
            Statement st = (Statement) Config.configDB().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM detail_transaksi");

            while (rs.next()) {
                tbl.addRow(new Object[] {

                        rs.getString("kd_transaksi"),
                        rs.getString("kd_barang"),
                        rs.getString("nama_barang"),
                        rs.getString("kuantitas"),
                        rs.getString("harga_satuan"),
                        rs.getString("harga_total"), });
                transactionTable.setModel(tbl);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnDashboard = new javax.swing.JLabel();
        btnLogout = new javax.swing.JLabel();
        btnHistory = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        namaKaryawan = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        transactionPanel = new RoundedPanel(10, new Color(187, 225, 250));
        jScrollPane1 = new javax.swing.JScrollPane();
        transactionTable = new javax.swing.JTable();
        transactionPanel1 = new RoundedPanel(10, new Color(187, 225, 250));
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        kodeItemField = new RoundJTextField(4);
        namaItemField = new RoundJTextField(4);
        hargaItemField = new RoundJTextField(4);
        kuantitasItemField = new RoundJTextField(4);
        btnEnter = new javax.swing.JLabel();
        idTransaksiFIeld = new RoundJTextField(4);
        btnDelete = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnClear = new javax.swing.JLabel();
        transactionPanel2 = new RoundedPanel(10, new Color(187, 225, 250));
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        totalField = new RoundJTextField(4);
        payField = new RoundJTextField(4);
        changeField = new RoundJTextField(4);
        btnNext = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1360, 868));

        jPanel4.setBackground(new java.awt.Color(50, 130, 184));

        btnDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn-dashboard-primary.png"))); // NOI18N
        btnDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnDashboard.setIcon(new javax.swing.ImageIcon(ClassLoader.getSystemResource("/img/btn-dashboard-secondary.png")));
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnDashboard.setIcon(new javax.swing.ImageIcon(ClassLoader.getSystemResource("/img/btn-dashboard-primary.png")));
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
                btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn-logout-primary.png")));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(namaKaryawan)
                .addGap(48, 48, 48))
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

        transactionPanel.setBackground(null);

        transactionTable.setBackground(null);
        transactionTable.getTableHeader().setFont(new java.awt.Font("Lato", 1, 14));
        transactionTable.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        transactionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Transaksi", "Kode Item", "Nama Item", "Harga", "Kuantitas",  "Total"
            }
        ));
        transactionTable.setGridColor(new java.awt.Color(187, 225, 250));
        transactionTable.setShowGrid(false);
        transactionTable.setOpaque(false);
        ((DefaultTableCellRenderer)transactionTable.getDefaultRenderer(Object.class)).setOpaque(false);
        transactionTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transactionTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(transactionTable);
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);

        javax.swing.GroupLayout transactionPanelLayout = new javax.swing.GroupLayout(transactionPanel);
        transactionPanel.setLayout(transactionPanelLayout);
        transactionPanelLayout.setHorizontalGroup(
            transactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transactionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        transactionPanelLayout.setVerticalGroup(
            transactionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transactionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addContainerGap())
        );

        transactionPanel1.setBackground(null);

        jLabel2.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabel2.setText("Kode Item");

        jLabel3.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabel3.setText("Nama Item");

        jLabel4.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabel4.setText("Harga");

        jLabel5.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabel5.setText("Kuantitas");

        kodeItemField.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        kodeItemField.setBorder(BorderFactory.createCompoundBorder(
            kodeItemField.getBorder(),
            BorderFactory.createEmptyBorder(0, 0, 0, 5)));
    kodeItemField.setForeground(new java.awt.Color(82, 97, 107));
    kodeItemField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            kodeItemFieldKeyReleased(evt);
        }
    });

    namaItemField.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
    namaItemField.setBorder(BorderFactory.createCompoundBorder(
        namaItemField.getBorder(),
        BorderFactory.createEmptyBorder(0, 0, 0, 5)));
namaItemField.setForeground(new java.awt.Color(82, 97, 107));
namaItemField.addKeyListener(new java.awt.event.KeyAdapter() {
    public void keyReleased(java.awt.event.KeyEvent evt) {
        namaItemFieldKeyReleased(evt);
    }
    });

    hargaItemField.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
    hargaItemField.setBorder(BorderFactory.createCompoundBorder(
        hargaItemField.getBorder(),
        BorderFactory.createEmptyBorder(0, 0, 0, 5)));
hargaItemField.setForeground(new java.awt.Color(82, 97, 107));
hargaItemField.setEnabled(false);

kuantitasItemField.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
kuantitasItemField.setBorder(BorderFactory.createCompoundBorder(
    kuantitasItemField.getBorder(),
    BorderFactory.createEmptyBorder(0, 0, 0, 5)));
    kuantitasItemField.setForeground(new java.awt.Color(82, 97, 107));

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

    idTransaksiFIeld.setEnabled(false);
    idTransaksiFIeld.setBorder(BorderFactory.createCompoundBorder(
        idTransaksiFIeld.getBorder(),
        BorderFactory.createEmptyBorder(0, 0, 0, 5)));

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

    jLabel10.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
    jLabel10.setText("Kode Transaksi");

    btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_clear_primary.png"))); // NOI18N
    btnClear.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent evt) {
            btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_clear_secondary.png")));
        }
        public void mouseReleased(java.awt.event.MouseEvent evt) {
            btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_clear_primary.png")));
        }
    });
    btnClear.setToolTipText("");
    btnClear.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            btnClearMouseClicked(evt);
        }
    });

    javax.swing.GroupLayout transactionPanel1Layout = new javax.swing.GroupLayout(transactionPanel1);
    transactionPanel1.setLayout(transactionPanel1Layout);
    transactionPanel1Layout.setHorizontalGroup(
        transactionPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(transactionPanel1Layout.createSequentialGroup()
            .addGap(32, 32, 32)
            .addGroup(transactionPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(transactionPanel1Layout.createSequentialGroup()
                    .addGroup(transactionPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGap(18, 18, 18)
                    .addGroup(transactionPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(namaItemField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(hargaItemField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(kuantitasItemField, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(transactionPanel1Layout.createSequentialGroup()
                    .addGroup(transactionPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel10)
                        .addComponent(jLabel2))
                    .addGap(22, 22, 22)
                    .addGroup(transactionPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(kodeItemField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(idTransaksiFIeld, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(transactionPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btnEnter, javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(btnClear, javax.swing.GroupLayout.Alignment.TRAILING))
            .addGap(18, 18, 18))
    );
    transactionPanel1Layout.setVerticalGroup(
        transactionPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transactionPanel1Layout.createSequentialGroup()
            .addContainerGap(16, Short.MAX_VALUE)
            .addGroup(transactionPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(transactionPanel1Layout.createSequentialGroup()
                    .addComponent(btnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(transactionPanel1Layout.createSequentialGroup()
                    .addGroup(transactionPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(idTransaksiFIeld, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addGap(18, 18, 18)
                    .addGroup(transactionPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(kodeItemField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(transactionPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(namaItemField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addGap(18, 18, 18)
                    .addGroup(transactionPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(hargaItemField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addGap(18, 18, 18)
                    .addGroup(transactionPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(kuantitasItemField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))))
            .addContainerGap())
    );

    transactionPanel2.setBackground(null);

    jLabel6.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
    jLabel6.setText("Total");

    jLabel7.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
    jLabel7.setText("Bayar");

    jLabel8.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
    jLabel8.setText("Kembali");

    totalField.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
    totalField.setForeground(new java.awt.Color(82, 97, 107));

    payField.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
    payField.setForeground(new java.awt.Color(82, 97, 107));
    payField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            payFieldKeyReleased(evt);
        }
    });

    changeField.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
    changeField.setForeground(new java.awt.Color(82, 97, 107));

    btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_next_primary.png"))); // NOI18N
    btnNext.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent evt) {
            btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_next_secondary.png")));
        }
        public void mouseReleased(java.awt.event.MouseEvent evt) {
            btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btn_next_primary.png")));
        }
    });
    btnNext.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            btnNextMouseClicked(evt);
        }
    });

    javax.swing.GroupLayout transactionPanel2Layout = new javax.swing.GroupLayout(transactionPanel2);
    transactionPanel2.setLayout(transactionPanel2Layout);
    transactionPanel2Layout.setHorizontalGroup(
        transactionPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(transactionPanel2Layout.createSequentialGroup()
            .addGap(80, 80, 80)
            .addGroup(transactionPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(transactionPanel2Layout.createSequentialGroup()
                    .addComponent(jLabel6)
                    .addGap(18, 18, 18)
                    .addComponent(totalField, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(transactionPanel2Layout.createSequentialGroup()
                    .addGroup(transactionPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8))
                    .addGap(18, 18, 18)
                    .addGroup(transactionPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(changeField)
                        .addComponent(payField, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
            .addComponent(btnNext)
            .addGap(23, 23, 23))
    );
    transactionPanel2Layout.setVerticalGroup(
        transactionPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(transactionPanel2Layout.createSequentialGroup()
            .addGap(18, 18, 18)
            .addGroup(transactionPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(transactionPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(transactionPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(payField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel7))
            .addGap(18, 18, 18)
            .addGroup(transactionPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(changeField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel8))
            .addContainerGap(27, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(transactionPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(transactionPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(transactionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(transactionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(transactionPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(transactionPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(22, Short.MAX_VALUE))))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    kodeProfileKaryawan = kode;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }



    private void transactionTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionTableMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_transactionTableMouseClicked
    
    private void btnNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseClicked
        // TODO add your handling code here:

        String nama = this.namaKaryawan.getText();
        int totalBayar = Integer.parseInt(totalField.getText());
        int bayar = Integer.parseInt(payField.getText());
        CheckoutTransaksi checkoutTransaksi = new CheckoutTransaksi();

        if (totalBayar <= bayar){
            String waktu = "";

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
            LocalDateTime now = LocalDateTime.now();
            waktu = dtf.format(now).toString();

            DefaultTableModel model = (DefaultTableModel) transactionTable.getModel();
//            checkoutTransaksi.noteTable.setModel(model);

            Object[] row = new Object[6];
            DefaultTableModel modelNota = (DefaultTableModel) checkoutTransaksi.noteTable.getModel();

            String idTransaksi = idTransaksiFIeld.getText();
            String grandTotal = totalField.getText();
            String namaKar = namaKaryawan.getText();
            String tunai = payField.getText();
            String kembalian = changeField.getText();

            try {
                Connection c = (Connection) Config.configDB();
                String sql = "INSERT INTO `transaksi`(`kd_transaksi`, `tanggal`, `nama`, `harga_total`, `tunai`, " +
                        "`kembali`) " +
                        "VALUES ('"+ idTransaksi +"','"+ waktu +"','" + namaKar +"','"+ grandTotal +"','"+ tunai +"', " +
                        "'"+ kembalian +"')";
                PreparedStatement p = c.prepareStatement(sql);
                p.executeUpdate();
                p.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }

            try {
                Connection c = (Connection) Config.configDB();
                int baris = transactionTable.getRowCount();

                for (int i = 0; i < baris; i++) {

                    row[0] = model.getValueAt(i, 0);
                    row[1] = model.getValueAt(i, 1);
                    row[2] = model.getValueAt(i, 2);
                    row[3] = model.getValueAt(i, 3);
                    row[4] = model.getValueAt(i, 4);
                    row[5] = model.getValueAt(i, 5);
                    modelNota.addRow(row);

                    String sql = "INSERT INTO `detail_transaksi`(`kd_transaksi`, `nama`, `kd_barang`, `nama_barang`, `kuantitas`, `harga_satuan`, `harga_total`, `kd_profil`) " +
                            "VALUES ('"+ idTransaksi +"','" + namaKar +"','"+ transactionTable.getValueAt(i, 1) +"'," +
                            "'"+transactionTable.getValueAt(i, 2)+"', '"+transactionTable.getValueAt(i, 4)+"', '"+transactionTable.getValueAt(i, 3)+"', '"
                            +transactionTable.getValueAt(i, 5)+"', '"+ kodeProfileKaryawan +"')";
                    PreparedStatement p = c.prepareStatement(sql);
                    p.executeUpdate();
                    p.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }

            try {
                String sql =
                        "SELECT `kd_profil`, `nama`, `kd_akun`, `role` FROM `profil` WHERE nama = '"+ nama +
                                "';";
                Connection conn = (Connection) Config.configDB();
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery(sql);

                if (rs.next()) {
                    String karyawanName = rs.getString("nama");
                    if (karyawanName.equals(nama)){
                        checkoutTransaksi.kodeProfile(rs.getString("kd_profil"));
                        checkoutTransaksi.totalPriceField.setText(totalField.getText());
                        checkoutTransaksi.totalPayField.setText(payField.getText());
                        checkoutTransaksi.totalChangeField.setText(changeField.getText());
                        checkoutTransaksi.kodeTransaksi(idTransaksi);
                        checkoutTransaksi.tanggal.setText(waktu);
                        checkoutTransaksi.setVisible(true);
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }

            this.setVisible(false);


            clear();
            utama();
            autonumber();
            kosong();
        } else {
            JOptionPane.showMessageDialog(this, "Uang pembayaran kurang");
        }



    }//GEN-LAST:event_btnNextMouseClicked

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

    private void btnEnterMouseClicked(MouseEvent evt) {//GEN-FIRST:event_btnEnterMouseClicked
        String kodeItem = kodeItemField.getText();
        String qty = kuantitasItemField.getText();


        if (qty != null && !qty.equals("")){
            int kuantitas = Integer.parseInt(qty);
            if (kuantitas > 0){
                try {
                    String sql = "SELECT * FROM `barang` WHERE kd_barang = '"+ kodeItem +"';";
                    Connection c = (Connection) Config.configDB();
                    Statement st = c.createStatement();
                    ResultSet rs = st.executeQuery(sql);
                    if(rs.next()){
                        int stock = Integer.parseInt(rs.getString("stock"));
                        if (kuantitas <= stock){
                            tambahTransaksi();
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Stok tidak cukup");
                        }
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Masukkan kuantitas dengan benar");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Masukkan kuantitas barang");
        }


    }//GEN-LAST:event_btnEnterMouseClicked

    private void kodeItemFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kodeItemFieldKeyReleased
        String kodeItem = kodeItemField.getText();
        try {
            String sql = "SELECT * FROM `barang` WHERE barang.kd_barang = '"+ kodeItem +"';";
            Connection c = (Connection) Config.configDB();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                namaItemField.setText(rs.getString("nama_barang"));
                hargaItemField.setText(rs.getString("harga_satuan"));
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_kodeItemFieldKeyReleased

    private void namaItemFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_namaItemFieldKeyReleased
        String namaItem = namaItemField.getText();
        try {
            String sql = "SELECT * FROM `barang` WHERE nama_barang = '"+ namaItem +"';";
            Connection c = (Connection) Config.configDB();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                kodeItemField.setText(rs.getString("kd_barang"));
                hargaItemField.setText(rs.getString("harga_satuan"));
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_namaItemFieldKeyReleased

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        DefaultTableModel model = (DefaultTableModel) transactionTable.getModel();
        int row = transactionTable.getSelectedRow();
        model.removeRow(row);
        totalBiaya();
        payField.setText("0");
        changeField.setText("0");
        

    }//GEN-LAST:event_btnDeleteMouseClicked

    private void payFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_payFieldKeyReleased
        jumlahBiaya();
    }//GEN-LAST:event_payFieldKeyReleased

    private void btnClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMouseClicked
        DefaultTableModel model = (DefaultTableModel) transactionTable.getModel();
        int row = transactionTable.getRowCount();
        model.setRowCount(0);
    }//GEN-LAST:event_btnClearMouseClicked

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



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new Transaksi().setVisible(true);
            }
        });


    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnClear;
    private javax.swing.JLabel btnDashboard;
    private javax.swing.JLabel btnDelete;
    private javax.swing.JLabel btnEnter;
    private javax.swing.JLabel btnHistory;
    private javax.swing.JLabel btnLogout;
    private javax.swing.JLabel btnNext;
    private javax.swing.JTextField changeField;
    private javax.swing.JTextField hargaItemField;
    private javax.swing.JTextField idTransaksiFIeld;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kodeItemField;
    private javax.swing.JTextField kuantitasItemField;
    private javax.swing.JTextField namaItemField;
    public javax.swing.JLabel namaKaryawan;
    private javax.swing.JTextField payField;
    private javax.swing.JTextField totalField;
    private javax.swing.JPanel transactionPanel;
    private javax.swing.JPanel transactionPanel1;
    private javax.swing.JPanel transactionPanel2;
    private javax.swing.JTable transactionTable;
    // End of variables declaration//GEN-END:variables
}
