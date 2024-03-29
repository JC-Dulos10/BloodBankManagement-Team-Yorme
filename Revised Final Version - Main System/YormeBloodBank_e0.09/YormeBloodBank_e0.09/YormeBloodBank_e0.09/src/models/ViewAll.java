/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;


import controller.login;
import controller.main;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.Display;


/**
 *
 * @author JC
 */
public class ViewAll extends javax.swing.JFrame implements Display,DBOperations {

    /**
     * Creates new form category
     */
    public ViewAll() {
        initComponents();
        bloodBankTable_update();
        getContentPane().setBackground(new Color(236, 239, 241));  
        packTypeTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        packTypeTable.getTableHeader().setOpaque(true);
        packTypeTable.getTableHeader().setBackground(new Color(32,136,203));
        packTypeTable.getTableHeader().setBackground(new Color(255,255,255));
        packTypeTable.setRowHeight(25);     
    }
    
    
    String lname;
    String isAdmin;
    String pass;
    int userID;
    int bloodBank_id;
    
     public ViewAll(String name, String isAdmin, String pass, int bloodBank_id, int userID) {
        initComponents();
        this.bloodBank_id =bloodBank_id;
        this.lname = name;
        this.isAdmin = isAdmin;
        this.pass = pass;
        this.userID = userID;
        bloodBankTable_update();
        
         getContentPane().setBackground(new Color(236, 239, 241)); 
         
         packTypeTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
         packTypeTable.getTableHeader().setOpaque(true);
         packTypeTable.getTableHeader().setBackground(new Color(32,136,203));
         packTypeTable.getTableHeader().setBackground(new Color(255,255,255));
         packTypeTable.setRowHeight(25);
    }

    DefaultTableModel model = new DefaultTableModel();
    
    
    
    
    
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
        jLabel16 = new javax.swing.JLabel();
        viewAllBloodBankLink = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        packTypeTable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(38, 166, 154));

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
        exitLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitLinkMouseClicked(evt);
            }
        });

        donorLink.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        donorLink.setForeground(new java.awt.Color(255, 255, 255));
        donorLink.setIcon(new javax.swing.ImageIcon(getClass().getResource("/z-res-images/icons8_people_30px_1.png"))); // NOI18N
        donorLink.setText("Donor");
        donorLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                donorLinkMouseClicked(evt);
            }
        });

        bloodPackLink.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        bloodPackLink.setForeground(new java.awt.Color(255, 255, 255));
        bloodPackLink.setIcon(new javax.swing.ImageIcon(getClass().getResource("/z-res-images/icons8_rh+_30px.png"))); // NOI18N
        bloodPackLink.setText("Blood Pack");
        bloodPackLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bloodPackLinkMouseClicked(evt);
            }
        });

        editHistoryLink.setBackground(new java.awt.Color(38, 166, 154));
        editHistoryLink.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        editHistoryLink.setForeground(new java.awt.Color(255, 255, 255));
        editHistoryLink.setIcon(new javax.swing.ImageIcon(getClass().getResource("/z-res-images/icons8_edit_property_30px.png"))); // NOI18N
        editHistoryLink.setText("Activity Logs");
        editHistoryLink.setOpaque(true);
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

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/z-res-images/icons8_welfare_70px.png"))); // NOI18N
        jLabel16.setText("jLabel13");

        viewAllBloodBankLink.setBackground(new java.awt.Color(0, 137, 123));
        viewAllBloodBankLink.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        viewAllBloodBankLink.setForeground(new java.awt.Color(255, 255, 255));
        viewAllBloodBankLink.setIcon(new javax.swing.ImageIcon(getClass().getResource("/z-res-images/icons8_edit_property_30px.png"))); // NOI18N
        viewAllBloodBankLink.setText("View Blood Banks");
        viewAllBloodBankLink.setOpaque(true);
        viewAllBloodBankLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewAllBloodBankLinkMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewAllBloodBankLink, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(packTypeLink)
                                    .addComponent(bloodPackLink)
                                    .addComponent(donorLink)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(adminLink))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(exitLink)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(editHistoryLink, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(packTypeLink)
                .addGap(30, 30, 30)
                .addComponent(donorLink)
                .addGap(28, 28, 28)
                .addComponent(bloodPackLink)
                .addGap(28, 28, 28)
                .addComponent(editHistoryLink, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(adminLink)
                .addGap(18, 18, 18)
                .addComponent(viewAllBloodBankLink, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitLink)
                .addGap(29, 29, 29))
        );

        jButton2.setText("Back to Main Menu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Blood Bank Registered", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        packTypeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Blood Bank Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        packTypeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                packTypeTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(packTypeTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/z-res-images/icons8_crown_45px.png"))); // NOI18N
        jLabel8.setText("yormesoftware™");
        jLabel8.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(188, 188, 188))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
     private void bloodBankTable_update(){
        try {
            int c;
            try {
                Connection conl = createConnection();
                PreparedStatement pst;
                ResultSet rs;
                pst = conl.prepareStatement(SHOW_BLOODBANK);
                rs = pst.executeQuery();
                
                ResultSetMetaData rsd = rs.getMetaData();
                c = rsd.getColumnCount();
                
                DefaultTableModel d = (DefaultTableModel)packTypeTable.getModel();
                d.setRowCount(0);
                
                
                while(rs.next()){
                    Vector v2 = new Vector();
                    String bloodbank_id;
                    String bloodbank_name;
                    for(int i=1; i<=c; i++){
                       bloodbank_id = rs.getString("id");
                       bloodbank_name = rs.getString("bloodBank_name");
                       if(!bloodbank_id.equalsIgnoreCase(Integer.toString(bloodBank_id))){
                           v2.add(bloodbank_name);
                       }
                    }
                    
                    d.addRow(v2);
                }
                conl.close();
                
            } catch (ClassNotFoundException ex) {
               JOptionPane.showMessageDialog(this,SYS_ERROR);
            }
             
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,SYS_ERROR);
        }
    }
    
    private void packTypeLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_packTypeLinkMouseClicked
        // TODO add your handling code here:
        this.dispose();
        new PackType(lname,isAdmin,pass,bloodBank_id,userID).setVisible(true); 
    }//GEN-LAST:event_packTypeLinkMouseClicked

    private void donorLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_donorLinkMouseClicked
        // TODO add your handling code here:
       this.dispose();
       new Donor(lname,isAdmin,pass,bloodBank_id,userID).setVisible(true); 
    }//GEN-LAST:event_donorLinkMouseClicked

    private void bloodPackLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bloodPackLinkMouseClicked
        // TODO add your handling code here:
       this.dispose();
        new BloodPack(lname,isAdmin,pass,bloodBank_id,userID).setVisible(true);
    }//GEN-LAST:event_bloodPackLinkMouseClicked

    private void editHistoryLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editHistoryLinkMouseClicked
        // TODO add your handling code here:
        this.dispose();
        new EditHistory(lname, isAdmin, pass, bloodBank_id,userID).setVisible(true);
    }//GEN-LAST:event_editHistoryLinkMouseClicked
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new main(lname,isAdmin,pass,bloodBank_id,userID).setVisible(true);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void adminLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminLinkMouseClicked
        if(isAdmin.equals("Admin")){
            this.dispose();
            new Accounts(lname,isAdmin,pass,bloodBank_id,userID).setVisible(true);
       }  else {
           JOptionPane.showMessageDialog(this, ADMIN_ONLY);
           int dialogResult = JOptionPane.showConfirmDialog(null, LOGIN_AS_ADMIN, "Warning",JOptionPane.YES_NO_OPTION);
            if(dialogResult == JOptionPane.YES_OPTION){
                login l = new  login();
                this.dispose();
                l.setVisible(true);
            }
       }       
    }//GEN-LAST:event_adminLinkMouseClicked

    private void exitLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitLinkMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitLinkMouseClicked

    
    public int getID(String name){
        int id = 0;
        try {
            
            Connection conl = createConnection();
            PreparedStatement pst;
            ResultSet rs;
            pst = conl.prepareStatement(GET_BLOODBANK_ID);
            pst.setString(1, name);
            rs = pst.executeQuery();
            while(rs.next()){
                id = rs.getInt("id");
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ViewAll.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    private void packTypeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_packTypeTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel d1 = (DefaultTableModel)packTypeTable.getModel();
        int selectIndex = packTypeTable.getSelectedRow();
        this.hide();
        new ViewBloodPack(lname, isAdmin, pass, bloodBank_id, userID, getID(d1.getValueAt(selectIndex, 0).toString())).setVisible(true);
    }//GEN-LAST:event_packTypeTableMouseClicked

    private void viewAllBloodBankLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewAllBloodBankLinkMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_viewAllBloodBankLinkMouseClicked

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
            java.util.logging.Logger.getLogger(ViewAll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new ViewAll().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adminLink;
    private javax.swing.JLabel bloodPackLink;
    private javax.swing.JLabel donorLink;
    private javax.swing.JLabel editHistoryLink;
    private javax.swing.JLabel exitLink;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel packTypeLink;
    private javax.swing.JTable packTypeTable;
    private javax.swing.JLabel viewAllBloodBankLink;
    // End of variables declaration//GEN-END:variables

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
}
