/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;


import controller.login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import controller.errorcheck;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import view.Display;
/**
 *
 * @author JC
 */
public class BloodPack extends javax.swing.JFrame implements DBOperations, Display{

    /**
     * Creates new form category
     */
    public BloodPack() {
        initComponents();
        add_button.setEnabled(false);
        edit_button.setEnabled(false);
        delete_button.setEnabled(false);
        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        jTable1.getTableHeader().setOpaque(false);
        jTable1.getTableHeader().setBackground(new Color(32,136,203));
        jTable1.getTableHeader().setBackground(new Color(255,255,255));
        jTable1.setRowHeight(25);
           
            getContentPane().setBackground(new Color(236, 239, 241)); 
           
        table_update();
        PackType();       
    }
    
    class JPanelGradient extends JPanel{
        protected void paintComponent(Graphics g){
            Graphics2D g2d = (Graphics2D) g;
            int width = getWidth();
            int height = getHeight();
            
            Color color1 = new Color(38,166,154);
            Color color2 = new Color(0, 150, 136);
            GradientPaint gp = new GradientPaint(0,0,color1,180,height,color2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, width, height);
        }
        
    }
    
    String lname;
    String isAdmin;
    String pass;
    int userID;
    int bloodBank_id;
    
     public BloodPack(String name, String isAdmin, String pass, int bloodBank_id) {
        initComponents();
        this.bloodBank_id = bloodBank_id;
        this.lname = name;
        this.isAdmin = isAdmin; 
        this.pass = pass;
        table_update();
        getId();
        PackType();
        
         jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
         jTable1.getTableHeader().setOpaque(false);
         jTable1.getTableHeader().setBackground(new Color(32,136,203));
         jTable1.getTableHeader().setBackground(new Color(255,255,255));
         jTable1.setRowHeight(25);
           
         getContentPane().setBackground(new Color(236, 239, 241)); 
        add_button.setEnabled(false);
        edit_button.setEnabled(false);
        delete_button.setEnabled(false);
       
    }
    
    public void getId(){
        try {
            Connection conl = createConnection();
            PreparedStatement ptsmnt;
            ptsmnt = conl.prepareStatement(GET_ID);
            ptsmnt.setString(1, lname);
            ptsmnt.setString(2, pass);
            ptsmnt.setInt(3, bloodBank_id);
            ResultSet rs = ptsmnt.executeQuery();
            while(rs.next()){
                userID = rs.getInt("id");
            }
            conl.close();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this,SYS_ERROR);
            Logger.getLogger(BloodPack.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void edithistory(String action, int id){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_TIME);
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);
        try {
            Connection conl = createConnection();
            PreparedStatement ptsmnt;
            ResultSet rs;
            ptsmnt = conl.prepareStatement(INSERT_HISTORY_BLOODPACKS);
            ptsmnt.setInt(1, id);
            ptsmnt.setString(2, action);
            ptsmnt.setString(3, date);
            ptsmnt.setInt(4, userID);
            ptsmnt.setInt(5, bloodBank_id);
            ptsmnt.executeUpdate(); 
            conl.close();
            } catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(this,SYS_ERROR);
                Logger.getLogger(BloodPack.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public Connection createConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        //enroll the Oracle MySql JDBC Driver
	Class.forName(JDBC_DRIVER_NAME);
	//create or get a Connection
	connection = DriverManager.getConnection(JDBC_URL,DB_USER_NAME, DB_PASSWORD);
	if (connection != null) {
            
	} else {
            
            JOptionPane.showMessageDialog(this, DB_INVALID);
	}
	return connection;
    }
    
    public class PackTypeItem{
        int id;
        String name;
        
        public PackTypeItem(int id, String name){
            this.id = id;
            this.name = name;
        }
        
        public String toString(){
            return name;
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
        packTypeLink = new javax.swing.JLabel();
        exitLink = new javax.swing.JLabel();
        donorLink = new javax.swing.JLabel();
        bloodPackLink = new javax.swing.JLabel();
        editHistoryLink = new javax.swing.JLabel();
        adminLink = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        viewAllBloodBankLink = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtstatus = new javax.swing.JComboBox<>();
        add_button = new javax.swing.JButton();
        edit_button = new javax.swing.JButton();
        delete_button = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtPack = new javax.swing.JComboBox();
        txtdonor = new javax.swing.JTextField();
        txtdatecollected = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtqty = new javax.swing.JTextField();
        FormatDateLine = new javax.swing.JLabel();
        refresh_button = new javax.swing.JButton();
        txtBlood = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(38, 166, 154));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        packTypeLink.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        packTypeLink.setForeground(new java.awt.Color(255, 255, 255));
        packTypeLink.setIcon(new javax.swing.ImageIcon(getClass().getResource("/z-res-images/icons8_product_30px_1.png"))); // NOI18N
        packTypeLink.setText("Pack Type");
        packTypeLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                packTypeLinkMouseClicked(evt);
            }
        });

        exitLink.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        exitLink.setForeground(new java.awt.Color(255, 255, 255));
        exitLink.setIcon(new javax.swing.ImageIcon(getClass().getResource("/z-res-images/icons8_exit_30px.png"))); // NOI18N
        exitLink.setText("Exit");

        donorLink.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        donorLink.setForeground(new java.awt.Color(255, 255, 255));
        donorLink.setIcon(new javax.swing.ImageIcon(getClass().getResource("/z-res-images/icons8_people_30px_1.png"))); // NOI18N
        donorLink.setText("Donor");
        donorLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                donorLinkMouseClicked(evt);
            }
        });

        bloodPackLink.setBackground(new java.awt.Color(0, 137, 123));
        bloodPackLink.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        bloodPackLink.setForeground(new java.awt.Color(255, 255, 255));
        bloodPackLink.setIcon(new javax.swing.ImageIcon(getClass().getResource("/z-res-images/icons8_rh+_30px.png"))); // NOI18N
        bloodPackLink.setText("Blood Pack");
        bloodPackLink.setOpaque(true);
        bloodPackLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bloodPackLinkMouseClicked(evt);
            }
        });

        editHistoryLink.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        editHistoryLink.setForeground(new java.awt.Color(255, 255, 255));
        editHistoryLink.setIcon(new javax.swing.ImageIcon(getClass().getResource("/z-res-images/icons8_edit_property_30px.png"))); // NOI18N
        editHistoryLink.setText("Edit History");
        editHistoryLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editHistoryLinkMouseClicked(evt);
            }
        });

        adminLink.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        adminLink.setForeground(new java.awt.Color(255, 255, 255));
        adminLink.setIcon(new javax.swing.ImageIcon(getClass().getResource("/z-res-images/icons8_admin_settings_male_30px.png"))); // NOI18N
        adminLink.setText("Admin");
        adminLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminLinkMouseClicked(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/z-res-images/icons8_welfare_70px.png"))); // NOI18N
        jLabel14.setText("jLabel13");

        viewAllBloodBankLink.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        viewAllBloodBankLink.setForeground(new java.awt.Color(255, 255, 255));
        viewAllBloodBankLink.setIcon(new javax.swing.ImageIcon(getClass().getResource("/z-res-images/icons8_view_30px.png"))); // NOI18N
        viewAllBloodBankLink.setText("View Blood Banks");
        viewAllBloodBankLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewAllBloodBankLinkMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bloodPackLink, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(packTypeLink)
                            .addComponent(donorLink)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(exitLink))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(editHistoryLink))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(adminLink))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(viewAllBloodBankLink)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(packTypeLink)
                .addGap(38, 38, 38)
                .addComponent(donorLink)
                .addGap(33, 33, 33)
                .addComponent(bloodPackLink, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(editHistoryLink)
                .addGap(36, 36, 36)
                .addComponent(adminLink)
                .addGap(51, 51, 51)
                .addComponent(viewAllBloodBankLink)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitLink)
                .addGap(32, 32, 32))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Status:");

        txtstatus.setBackground(new java.awt.Color(204, 204, 204));
        txtstatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Expired" }));

        add_button.setBackground(new java.awt.Color(204, 204, 204));
        add_button.setText("Add");
        add_button.setEnabled(false);
        add_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_buttonActionPerformed(evt);
            }
        });

        edit_button.setBackground(new java.awt.Color(204, 204, 204));
        edit_button.setText("Update");
        edit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_buttonActionPerformed(evt);
            }
        });

        delete_button.setBackground(new java.awt.Color(204, 204, 204));
        delete_button.setText("Delete");
        delete_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_buttonActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Blood Bag Type:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Blood Type");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Donor Name:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Date Collected:");

        txtPack.setBackground(new java.awt.Color(204, 204, 204));
        txtPack.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPack.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "none" }));

        txtdonor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtdonor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdonorActionPerformed(evt);
            }
        });
        txtdonor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdonorKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdonorKeyTyped(evt);
            }
        });

        txtdatecollected.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtdatecollected.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdatecollectedKeyReleased(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Quantity:");

        txtqty.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        FormatDateLine.setForeground(new java.awt.Color(102, 102, 102));
        FormatDateLine.setText("Format: YYYY/MM/DD");

        refresh_button.setBackground(new java.awt.Color(204, 204, 204));
        refresh_button.setText("Refresh");
        refresh_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_buttonActionPerformed(evt);
            }
        });

        txtBlood.setText("    ");

        jLabel20.setForeground(java.awt.Color.red);
        jLabel20.setText("NOTE: PRESS ENTER AFTER TYPING!!!!");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPack, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBlood))
                .addGap(75, 75, 75)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtdonor, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                            .addComponent(txtdatecollected)
                            .addComponent(txtqty))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FormatDateLine)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(572, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(refresh_button)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(add_button)
                        .addGap(30, 30, 30)
                        .addComponent(edit_button)
                        .addGap(18, 18, 18)
                        .addComponent(delete_button)
                        .addGap(320, 320, 320))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(refresh_button)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtPack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtdonor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20)
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtdatecollected, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FormatDateLine)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtBlood)
                            .addComponent(jLabel13))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(txtqty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_button)
                    .addComponent(edit_button)
                    .addComponent(delete_button))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Blood Pack Type", "Blood Type", "Date Collected", "Donor Name", "Date Registered", "Registered By", "Quantity", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable1.setOpaque(false);
        jTable1.setRowHeight(25);
        jTable1.setSelectionBackground(new java.awt.Color(82, 223, 219));
        jTable1.setShowVerticalLines(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel3.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/z-res-images/icons8_crown_45px.png"))); // NOI18N
        jLabel7.setText("yormesoftware™");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(428, 428, 428)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(475, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    public void PackType(){
        try {
            Connection conl = createConnection();
            PreparedStatement ptsmnt;
            ResultSet rs;
            ptsmnt = conl.prepareStatement(SELECT_PACKTYPE);
            ptsmnt.setInt(1, bloodBank_id);
            rs = ptsmnt.executeQuery();
            txtPack.removeAllItems();
            
            while(rs.next()){
                txtPack.addItem(new PackTypeItem(rs.getInt(1), rs.getString(2)));
            }
            
            conl.close();
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BloodPack.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,SYS_ERROR);
        }
    }
    
    
    public String getName(int id){
        String name = "";
        try {
            Connection conl = createConnection();
            PreparedStatement ptsmnt;
            ResultSet rs;
            ptsmnt = conl.prepareStatement(GET_NAME);
            ptsmnt.setInt(1, id);
            ptsmnt.setInt(2, bloodBank_id);
            rs = ptsmnt.executeQuery();
            while(rs.next()){
                name = rs.getString("account_name");
            }
            conl.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BloodPack.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(this,SYS_ERROR);
        }
        return name;
    }
    
    
    public String checkExpiration(String date, int id){
        String newDate = "";
        try {    
            int shelfLife = 0;
            SimpleDateFormat sdf = new SimpleDateFormat(DATE);
            Date currentDate = sdf.parse(date);
            
            try {
                Connection conl = createConnection();
                PreparedStatement ptsmnt;
                ResultSet rs;
                ptsmnt = conl.prepareStatement(GET_SHELFLIFE);
                ptsmnt.setInt(1, id);
                ptsmnt.setInt(2, bloodBank_id);
                rs = ptsmnt.executeQuery();
                while(rs.next()){
                    shelfLife = rs.getInt("shelfLife");
                }

                Calendar c = Calendar.getInstance();
                c.setTime(currentDate);
                c.add(Calendar.DATE, shelfLife); 
                newDate = sdf.format(c.getTime());
                
              conl.close();

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(BloodPack.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this,SYS_ERROR);
            }
        } catch (ParseException ex) {
            Logger.getLogger(BloodPack.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,SYS_ERROR);
        }
        return newDate;
    }
      
    public String get_Dname(int id){
        String name = "";
        try {
            Connection conl = createConnection();
            PreparedStatement ptsmnt;
            ResultSet rs;
            ptsmnt = conl.prepareStatement(SELECT_DONOR);
            ptsmnt.setInt(1, id);
            ptsmnt.setInt(2, bloodBank_id);
                rs = ptsmnt.executeQuery();
                while(rs.next()){
                    name = rs.getString("donorName");
                }
            conl.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BloodPack.class.getName()).log(Level.SEVERE, null, ex);
        }
        return name;
    }
    
    public boolean checkDonorExist(String name){
        String name2 = "";
        boolean decision = false;
        try {
            Connection conl = createConnection();
            PreparedStatement ptsmnt;
            ResultSet rs;
            ptsmnt = conl.prepareStatement(CHECK_NAME);
            ptsmnt.setString(1, name);
            ptsmnt.setInt(2, bloodBank_id);
            rs = ptsmnt.executeQuery();
            while(rs.next()){
                name2 = rs.getString("donorName");
            }
            if(name.equalsIgnoreCase(name2)){
                decision = true;
            }
            conl.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BloodPack.class.getName()).log(Level.SEVERE, null, ex);
        }
        return decision;
    }
    
    public String getBloodType(int id){
        String bloodType = "";
        try {
            Connection conl = createConnection();
            PreparedStatement ptsmnt;
            ResultSet rs;
            ptsmnt = conl.prepareStatement(GET_BLOODTYPE);
            ptsmnt.setInt(1, id);
            ptsmnt.setInt(2, bloodBank_id);
            rs = ptsmnt.executeQuery();
            while(rs.next()){
                bloodType = rs.getString("bloodType");
            }
            conl.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BloodPack.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bloodType;
    }
    
    private void table_update(){
        try {
            int c;
            try {
                Connection conl = createConnection();
                PreparedStatement ptsmnt;
                ResultSet rs;
                ptsmnt = conl.prepareStatement(UPDATE_TABLE_BLOODPACKS);
                ptsmnt.setInt(1, bloodBank_id);
                rs = ptsmnt.executeQuery();
                ResultSetMetaData rsd = rs.getMetaData();
                c = rsd.getColumnCount();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE);
                LocalDateTime now = LocalDateTime.now();
                String presentDate = dtf.format(now);  

                DefaultTableModel d = (DefaultTableModel)jTable1.getModel();
                d.setRowCount(0);
                
                
                while(rs.next()){
                    Vector v2 = new Vector();
                    int id = 0;
                    String status = "";
                    String date = "";
                    String expirationDate = "";
                    c = c - 1;
                    for(int i=1; i<=c; i++){
                       v2.add(rs.getString("id"));
                       id = rs.getInt("packType_id");
                       v2.add(rs.getString("packType"));
                       v2.add(rs.getString("bloodType"));
                       date = rs.getString("date_collected");
                       v2.add(date);
                       v2.add(get_Dname(rs.getInt("donor_id")));
                       v2.add(rs.getString("date_registered"));
                       v2.add(getName(rs.getInt("account_id")));
                       v2.add(rs.getString("quantity"));
                       status = rs.getString("status");
                       expirationDate = checkExpiration(date, id);

                       if(presentDate.equals(expirationDate)){
                            status = "Expired";
                        } 
                        v2.add(status);
                    }
                    
                    d.addRow(v2);
                }        
                conl.close();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(BloodPack.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this,SYS_ERROR);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BloodPack.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(this,SYS_ERROR);
        }
    }
    
    
    
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
         add_button.setEnabled(false);
         edit_button.setEnabled(true);
         delete_button.setEnabled(true);
         DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
         int selectIndex = jTable1.getSelectedRow();
         txtPack.setSelectedIndex(-1);
         txtBlood.setText(d1.getValueAt(selectIndex, 2).toString());
         txtdatecollected.setText(d1.getValueAt(selectIndex, 3).toString());
         txtdonor.setText(d1.getValueAt(selectIndex, 4).toString());
         txtqty.setText(d1.getValueAt(selectIndex, 7).toString());
         txtstatus.setSelectedItem(d1.getValueAt(selectIndex, 8).toString());   
         String status = txtstatus.getSelectedItem().toString();   
         if(status.equals("Expired")){
           edit_button.setEnabled(false);
         } else {
            edit_button.setEnabled(true);
         }
          
    }//GEN-LAST:event_jTable1MouseClicked

    private void packTypeLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_packTypeLinkMouseClicked
        // TODO add your handling code here:
        this.dispose();
        new PackType(lname,isAdmin,pass,bloodBank_id).setVisible(true);
        
    }//GEN-LAST:event_packTypeLinkMouseClicked

    private void donorLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_donorLinkMouseClicked
        // TODO add your handling code here:
        this.dispose();
        new Donor(lname,isAdmin,pass,bloodBank_id).setVisible(true);
        
    }//GEN-LAST:event_donorLinkMouseClicked

    private void bloodPackLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bloodPackLinkMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bloodPackLinkMouseClicked

    private void delete_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_buttonActionPerformed
        // TODO add your handling code here:

        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();
        
        int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());

        int dialogResult = JOptionPane.showConfirmDialog(this, DELETE_RECORD, "Warning",JOptionPane.YES_NO_OPTION);

        if(dialogResult == JOptionPane.YES_OPTION){

            try {
                Connection conl = createConnection();
                PreparedStatement ptsmnt;
                ResultSet rs;
                ptsmnt = conl.prepareStatement(DELETE_BLOODPACK);
                ptsmnt.setInt(1, id);
                ptsmnt.setInt(2, bloodBank_id);
                ptsmnt.executeUpdate();
                JOptionPane.showMessageDialog(this, RECORD_DELETED);
                table_update();
                reloadAll();
                txtdonor.requestFocus();
                edithistory(BP_ID_DELETED, id);
                add_button.setEnabled(false);
                edit_button.setEnabled(false);
                delete_button.setEnabled(false);
                reloadAll();
                conl.close();
            } catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(this,SYS_ERROR);
                Logger.getLogger(BloodPack.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_delete_buttonActionPerformed

    public int get_DID(String name){
        int id = 0;
        try {
            Connection conl = createConnection();
            PreparedStatement ptsmnt;
            ResultSet rs;
            ptsmnt = conl.prepareStatement(GET_DID);
            ptsmnt.setString(1, name);
            ptsmnt.setInt(2, bloodBank_id);
            rs = ptsmnt.executeQuery();
            while(rs.next()){
                id = rs.getInt("id");
            }
            conl.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BloodPack.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    private void edit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_buttonActionPerformed
        
        errorcheck err = new errorcheck();// Calls the error and restriction methods 
        PreparedStatement ptsmnt;
        ResultSet rs;
        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        int selectIndex = jTable1. getSelectedRow();
        int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());        
        if(txtPack.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(this, COMBO_EMP);
        } else if(txtstatus.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(this, COMBO_EMP);
        } else {
            String donor = txtdonor.getText();
            if(checkDonorExist(donor) == false){
                JOptionPane.showMessageDialog(this, "Donor's name is not on the Database!!!");
                JOptionPane.showMessageDialog(this, "Register Donor First!!!");
                txtdonor.requestFocus();
            } else if(err.isEmpty(donor)){
                JOptionPane.showMessageDialog(this, NOT_EMPTY);
                txtdonor.requestFocus();
            } else {
               String datec = txtdatecollected.getText();
                PackTypeItem pitem = (PackTypeItem)txtPack.getSelectedItem();
                String qty = txtqty.getText();
                String status = txtstatus.getSelectedItem().toString();
                int donor_id = get_DID(donor);
                txtBlood.setText(getBloodType(donor_id));
                String bloodType = txtBlood.getText();
                try {
                    Connection conl = createConnection();
                    ptsmnt = conl.prepareStatement(UPDATE_BLOODPACK);
                    ptsmnt.setInt(1, donor_id);
                    //If input String value is empty
                    if(err.isEmpty(donor) == true){
                        JOptionPane.showMessageDialog(this, NOT_EMPTY);
                        txtdonor.requestFocus();
                    }
                    //If input contains illegal characters that are not good for databases
                    else if(err.isContainIllegalChar(donor) == true){
                        JOptionPane.showMessageDialog(this, NO_ILLEGAL_CHAR);
                        txtdonor.requestFocus();
                    }
                    //If input is number only
                    else if(err.numberOrNot(donor)== true){
                       JOptionPane.showMessageDialog(this, NAME_NUM);
                       txtdonor.requestFocus();
                    }

                    //Proceeds to data collection checking
                    else{
                         ptsmnt.setString(2, datec);
                        //If input String value is empty
                        if(err.isEmpty(datec) == true){
                            JOptionPane.showMessageDialog(this, DATE_EMPTY);
                        }
                        //If input value does not follow the format that was specified
                        else if(err.isValidFormat(datec) == true){
                            JOptionPane.showMessageDialog(this, DATE_FORMAT);
                        }

                        //Proceeds to data collection checking
                        else{
                            ptsmnt.setInt(3, pitem.id);
                            ptsmnt.setString(4, bloodType);

                            ptsmnt.setString(5, qty);
                            //If input String value is empty
                            if(err.isEmpty(qty) == true){
                                JOptionPane.showMessageDialog(this, NOT_EMPTY);
                                txtqty.requestFocus();
                            }
                            //If input String value contains letters
                            else if(err.isLetter(qty) == true){
                                JOptionPane.showMessageDialog(this, QTY_NUM);
                                txtqty.requestFocus();
                            }

                            //Proceeds to data collection checking
                            else{
                                ptsmnt.setString(6, status);
                                ptsmnt.setInt(7, id);
                                ptsmnt.setInt(8, bloodBank_id);
                                ptsmnt.executeUpdate();
                                JOptionPane.showMessageDialog(this, BP_UPDATED);
                                table_update();
                                reloadAll();
                                edithistory(BP_ID_UPDATED,id); 
                                add_button.setEnabled(false);
                                edit_button.setEnabled(false);
                                delete_button.setEnabled(false);
                                conl.close();
                            }


                        }

                    }


                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(BloodPack.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this,SYS_ERROR);
                } 
            }
            
        }
    }//GEN-LAST:event_edit_buttonActionPerformed

    private void add_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_buttonActionPerformed
        
        errorcheck err = new errorcheck();// Calls the error and restriction methods 
        PreparedStatement ptsmnt;
        ResultSet rs;
       
        
        String donor = txtdonor.getText();
            String datec = txtdatecollected.getText();
            if(txtPack.getSelectedIndex() == -1){
                JOptionPane.showMessageDialog(this, COMBO_EMP);
            } else if(txtstatus.getSelectedIndex() == -1){
                JOptionPane.showMessageDialog(this, COMBO_EMP);
            } else {
                PackTypeItem pitem = (PackTypeItem)txtPack.getSelectedItem();
                String qty = txtqty.getText();
                String status = txtstatus.getSelectedItem().toString();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE);
                LocalDateTime now = LocalDateTime.now();
                String dater = dtf.format(now);
                int donor_id = get_DID(donor);
                String bloodType = txtBlood.getText();


                int generatedID = 0;
                try {
                    Connection conl = createConnection();
                    ptsmnt = conl.prepareStatement(INSERT_BLOODPACK,Statement.RETURN_GENERATED_KEYS);
                    ptsmnt.setInt(1, pitem.id);
                    ptsmnt.setString(2, bloodType);
                    ptsmnt.setString(3, datec);
                    //If input String value is empty
                    if(err.isEmpty(datec) == true){
                        JOptionPane.showMessageDialog(this, DATE_EMPTY);
                        txtdatecollected.requestFocus();
                    }
                    //If input value does not follow the format that was specified
                    else if(err.isValidFormat(datec) == true){
                        JOptionPane.showMessageDialog(this, DATE_FORMAT);
                        txtdatecollected.requestFocus();
                    }
                    
                    else if(err.isExpireTomorrow(datec) == true){
                        JOptionPane.showMessageDialog(this, "HOTDOG EXPIRE YAN BUKAS");
                        txtdatecollected.requestFocus();
                    }

                    //Proceed to checking donorname for any irregularities
                    else{
                        ptsmnt.setInt(4, donor_id);

                        //If input String value is empty
                        if(err.isEmpty(donor) == true){
                            JOptionPane.showMessageDialog(this, NOT_EMPTY);
                            txtdonor.requestFocus();
                        }
                        //If input contains illegal characters that are not good for databases
                        else if(err.isContainIllegalChar(donor) == true){
                            JOptionPane.showMessageDialog(this, NO_ILLEGAL_CHAR);
                            txtdonor.requestFocus();
                        }
                        //If input is number only
                        else if(err.numberOrNot(donor)== true){
                           JOptionPane.showMessageDialog(this, NAME_NUM);
                           txtdonor.requestFocus();
                        }

                        //Proceed to data insertion
                        else{
                            ptsmnt.setString(5, dater);     
                            ptsmnt.setInt(6, userID);
                            ptsmnt.setString(7, qty);
                            //If input String value is empty
                            if(err.isEmpty(qty) == true){
                                JOptionPane.showMessageDialog(this, NOT_EMPTY);
                                txtqty.requestFocus();
                            }
                            //If input String value contains letters
                            else if(err.isLetter(qty) == true){
                                JOptionPane.showMessageDialog(this, QTY_NUM);
                                txtqty.requestFocus();
                            }
                            else{
                                ptsmnt.setString(8, status);
                                ptsmnt.setInt(9, bloodBank_id);
                                ptsmnt.executeUpdate();
                                ResultSet generatedKeyResult = ptsmnt.getGeneratedKeys();
                                if(generatedKeyResult.next()){
                                    generatedID = generatedKeyResult.getInt(1);
                                }
                                JOptionPane.showMessageDialog(this, BP_ADD_ID + generatedID );
                                table_update();
                                reloadAll();
                                edithistory(BP_ADD_ID , generatedID ); 
                                add_button.setEnabled(false);
                                conl.close();
                            }


                        }


                    }

                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(BloodPack.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this,SYS_ERROR);
                }
            }
    }//GEN-LAST:event_add_buttonActionPerformed

    private void editHistoryLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editHistoryLinkMouseClicked
        // TODO add your handling code here:
        this.dispose();
        new EditHistory(lname,isAdmin,pass,bloodBank_id).setVisible(true);
    }//GEN-LAST:event_editHistoryLinkMouseClicked

    private void adminLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminLinkMouseClicked
        // TODO add your handling code here:
       if(isAdmin.equals("Yes")){
            this.dispose();
            new Accounts(lname,isAdmin,pass,bloodBank_id).setVisible(true);
       }  else {
           JOptionPane.showMessageDialog(this, ADMIN_ONLY);
           int dialogResult = JOptionPane.showConfirmDialog(this, LOGIN_AS_ADMIN, "Warning",JOptionPane.YES_NO_OPTION);
            if(dialogResult == JOptionPane.YES_OPTION){
                login l = new  login();
                this.dispose();
                l.setVisible(true);
            }
       }
    }//GEN-LAST:event_adminLinkMouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jPanel1MouseClicked

    private void txtdonorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdonorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdonorActionPerformed

    public void reloadAll(){
        txtdonor.setText("");
        txtdatecollected.setText("");  
        txtqty.setText(""); 
        txtdonor.requestFocus();
        txtstatus.setSelectedIndex(-1);
        txtPack.setSelectedIndex(-1);
        txtBlood.setText("");
        add_button.setEnabled(false);
        edit_button.setEnabled(false);
        delete_button.setEnabled(false);
    }
    
    private void refresh_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_buttonActionPerformed
        // TODO add your handling code here:
        reloadAll();
    }//GEN-LAST:event_refresh_buttonActionPerformed

    private void txtdonorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdonorKeyPressed
        errorcheck err = new errorcheck();// Calls the error and restriction methods 
        String donor = txtdonor.getText();
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(checkDonorExist(donor) == false){
                JOptionPane.showMessageDialog(this, "Donor's name is not on the Database!!!");
                JOptionPane.showMessageDialog(this, "Register Donor First!!!");
                txtdonor.requestFocus();
            } else if(err.isEmpty(donor)){
                JOptionPane.showMessageDialog(this, NOT_EMPTY);
                txtdonor.requestFocus();
            } else {
                txtBlood.setText(getBloodType(get_DID(donor)));
                this.add_button.setEnabled(true);
            }
        }
    }//GEN-LAST:event_txtdonorKeyPressed

    private void txtdonorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdonorKeyTyped
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_txtdonorKeyTyped

    private void viewAllBloodBankLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewAllBloodBankLinkMouseClicked
        // TODO add your handling code here:
        this.hide();
        new ViewAll(lname, isAdmin, pass, bloodBank_id).setVisible(true);
                
    }//GEN-LAST:event_viewAllBloodBankLinkMouseClicked

    private void txtdatecollectedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdatecollectedKeyReleased
        errorcheck err = new errorcheck();
        String dateCheck = txtdatecollected.getText();
        
        if(err.isValidFormat(dateCheck) == true){
               FormatDateLine.setForeground(Color.red);
         }else{
             FormatDateLine.setForeground(Color.gray);
         }
        
    }//GEN-LAST:event_txtdatecollectedKeyReleased

    
  
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
            java.util.logging.Logger.getLogger(BloodPack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BloodPack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BloodPack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BloodPack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BloodPack().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FormatDateLine;
    private javax.swing.JButton add_button;
    private javax.swing.JLabel adminLink;
    private javax.swing.JLabel bloodPackLink;
    private javax.swing.JButton delete_button;
    private javax.swing.JLabel donorLink;
    private javax.swing.JLabel editHistoryLink;
    private javax.swing.JButton edit_button;
    private javax.swing.JLabel exitLink;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel packTypeLink;
    private javax.swing.JButton refresh_button;
    private javax.swing.JLabel txtBlood;
    private javax.swing.JComboBox txtPack;
    private javax.swing.JTextField txtdatecollected;
    private javax.swing.JTextField txtdonor;
    private javax.swing.JTextField txtqty;
    private javax.swing.JComboBox<String> txtstatus;
    private javax.swing.JLabel viewAllBloodBankLink;
    // End of variables declaration//GEN-END:variables
}
