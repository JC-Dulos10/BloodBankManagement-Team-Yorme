/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import static models.DBOperations.DB_PASSWORD;
import static models.DBOperations.DB_USER_NAME;
import static models.DBOperations.JDBC_DRIVER_NAME;
import static models.DBOperations.JDBC_URL;
import static models.DBOperations.UPDATE_TABLE_BLOODPACKS;
import view.Display;
import static view.Display.DB_INVALID;

/**
 *
 * @author JC
 */
public class print extends javax.swing.JFrame implements Display,DBOperations{

    /**
     * Creates new form print
     */
    public print() {
        initComponents();
    }
    
    String lsub;
    String lpay;
    String lbal;
    
  
    
    public print(String name, int bloodBank_id, TableModel packType_logs, TableModel donor_logs, TableModel accounts_logs, TableModel bloodPacks_logs) throws PrinterException {
        initComponents();
        String bloodBankName = getBloodBankName(bloodBank_id);
        
        txtprint.setText(txtprint.getText()+"******************************************************************************************************************************************************\n");
        txtprint.setText(txtprint.getText()+"***************************************************************** Activity Logs **********************************************************************\n");
        txtprint.setText(txtprint.getText()+"\n");
        txtprint.setText(txtprint.getText()+"Requested by: " + name +"\n");
        txtprint.setText(txtprint.getText()+"BloodBank: " + bloodBankName +"\n");
        txtprint.setText(txtprint.getText()+"\n\n\n");
        txtprint.setText(txtprint.getText()+"******************************************************************************************************************************************************\n");
        txtprint.setText(txtprint.getText()+"***************************************************************** PackType Logs **********************************************************************\n");
        txtprint.setText(txtprint.getText()+"Action                      " + "\t" +"Pack Type ID" + "\t     " + "Account ID" + "\t"+"Date" +"\n");
        for(int i = 0; i < packType_logs.getRowCount(); i++){
            String Action = (String)packType_logs.getValueAt(i, 0);
            int PackType_ID = Integer.parseInt(packType_logs.getValueAt(i, 1).toString());
            int Account_ID = Integer.parseInt(packType_logs.getValueAt(i, 2).toString());
            String Date = (String)packType_logs.getValueAt(i, 3);
            
            txtprint.setText(txtprint.getText()+ Action + " \t " + PackType_ID + "\t" + Account_ID + "\t" + Date + "\n");
        }
        txtprint.setText(txtprint.getText()+"\n\n\n");
        txtprint.setText(txtprint.getText()+"******************************************************************************************************************************************************\n");
        txtprint.setText(txtprint.getText()+"******************************************************************** Donor Logs **********************************************************************\n");
        txtprint.setText(txtprint.getText()+"Action                      " + "\t" +"Donor ID" + "\t     " + "Account ID" + "\t"+"Date" +"\n");
        for(int i = 0; i < donor_logs.getRowCount(); i++){
            String Action = (String)donor_logs.getValueAt(i, 0);
            int Donor_ID = Integer.parseInt(donor_logs.getValueAt(i, 1).toString());
            int Account_ID = Integer.parseInt(donor_logs.getValueAt(i, 2).toString());
            String Date = (String)donor_logs.getValueAt(i, 3);
            
            txtprint.setText(txtprint.getText()+ Action + " \t " + Donor_ID + "\t" + Account_ID + "\t" + Date + "\n");
        }
        txtprint.setText(txtprint.getText()+"\n\n\n");
        txtprint.setText(txtprint.getText()+"******************************************************************************************************************************************************\n");
        txtprint.setText(txtprint.getText()+"***************************************************************** Blood Pack Logs ********************************************************************\n");
        txtprint.setText(txtprint.getText()+"Action                      " + "\t" +"Blood Pack ID" + "\t     " + "Account ID" + "\t"+"Date" +"\n");
        for(int i = 0; i < bloodPacks_logs.getRowCount(); i++){
            String Action = (String)bloodPacks_logs.getValueAt(i, 0);
            int BloodPack_ID = Integer.parseInt(bloodPacks_logs.getValueAt(i, 1).toString());
            int Account_ID = Integer.parseInt(bloodPacks_logs.getValueAt(i, 2).toString());
            String Date = (String)bloodPacks_logs.getValueAt(i, 3);
            
            txtprint.setText(txtprint.getText()+ Action + " \t " + BloodPack_ID + "\t" + Account_ID + "\t" + Date + "\n");
        }
        txtprint.setText(txtprint.getText()+"\n\n\n");
        txtprint.setText(txtprint.getText()+"******************************************************************************************************************************************************\n");
        txtprint.setText(txtprint.getText()+"***************************************************************** Accounts Logs **********************************************************************\n");
        txtprint.setText(txtprint.getText()+"Action                      " + "\t" +"Account ID" + "\t     " + "Account ID" + "\t"+"Date" +"\n");
        for(int i = 0; i < accounts_logs.getRowCount(); i++){
            String Action = (String)accounts_logs.getValueAt(i, 0);
            int AccountActivity_ID = Integer.parseInt(accounts_logs.getValueAt(i, 1).toString());
            int Account_ID = Integer.parseInt(accounts_logs.getValueAt(i, 2).toString());
            String Date = (String)accounts_logs.getValueAt(i, 3);
            
            txtprint.setText(txtprint.getText()+ Action + " \t " + AccountActivity_ID + "\t" + Account_ID + "\t" + Date + "\n");
        }
        txtprint.print();
        
    }
    
    public String  getBloodBankName(int bloodBank_id){
        String name = "";
        try {
            Connection conl = createConnection();
            PreparedStatement ptsmnt;
            ResultSet rs;
            ptsmnt = conl.prepareStatement(GET_BANKNAME);
            ptsmnt.setInt(1, bloodBank_id);
            rs = ptsmnt.executeQuery();
            while(rs.next()){
                name = rs.getString("bloodBank_name");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(print.class.getName()).log(Level.SEVERE, null, ex);
        }
        return name;
    }
    
    public print(String sub, String pay, String bal, TableModel tableModel) throws PrinterException {
        initComponents();
        this.lbal = sub;
        this.lpay = pay;
        this.lbal = bal;
        
        txtprint.setText(txtprint.getText()+"*********************************************\n");
        txtprint.setText(txtprint.getText()+"*************** SuperPos ********************\n");
        txtprint.setText(txtprint.getText()+"\n");
        txtprint.setText(txtprint.getText()+"Product" + "\t" +"price" +"\t"+"Total" +"\n");
        for(int i = 0; i < tableModel.getRowCount(); i++){
            String product = (String)tableModel.getValueAt(i, 1);
            String price = (String)tableModel.getValueAt(i, 2);
            int total = (int)tableModel.getValueAt(i, 4);
            
            txtprint.setText(txtprint.getText()+product + "\t" + price +"\t"+total +"\n");
        }
        txtprint.setText(txtprint.getText()+"\n");
        txtprint.setText(txtprint.getText()+"\n");
        txtprint.setText(txtprint.getText()+"          " +  "Subtotal : " + sub + "\n");
        txtprint.setText(txtprint.getText()+"          " +  "Pay :      " + pay + "\n");
        txtprint.setText(txtprint.getText()+"          " +  "Balance :  " + bal + "\n");
        txtprint.setText(txtprint.getText()+"*********************************************\n");
        txtprint.setText(txtprint.getText()+"*********************************************\n");
        txtprint.setText(txtprint.getText()+"Thank you come again********************\n");

        txtprint.print();
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
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtprint = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtprint.setColumns(20);
        txtprint.setRows(5);
        jScrollPane1.setViewportView(txtprint);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1005, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new print().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtprint;
    // End of variables declaration//GEN-END:variables
}
