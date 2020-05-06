/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;

/**
 *
 * @author JC
 */
public interface DBOperations {

    /**
     * ALl JDBC CODES
     */
    String JDBC_DRIVER_NAME = "com.mysql.jdbc.Driver";
    String JDBC_URL = "jdbc:mysql://localhost/yormebloodbank";
    String DB_USER_NAME = "root";
    String DB_PASSWORD = "";
    String LOGIN = "select * from accounts where account_name = ? and password = ?";
    
    //BloodBank
    String SHOW_BLOODBANK = "select * from bloodbank";
    String CHECK_NAME_BLOODBANK = "select * from bloodBank where bloodBank_name=?";
    String INSERT_BLOODBANK = "insert into bloodbank(bloodBank_name, registration_key)values(?,?)";
    String DELETE_KEY = "delete from registration_key where rKey=?";
    String CHECK_KEY = "select * from registration_key where rKey=?";
    String GET_BANKNAME = "select bloodBank_name from bloodbank where id =?";
    
    //perform DML statements
    String GET_ID = "select id from accounts where account_name=? and password = ? and bloodBank_id=?";
    String GET_NAME = "select * from accounts where id = ? and bloodBank_id=?";
    String GET_PASS = "select password from accounts where id=? and bloodBank_id=?";
   
    
    //Accounts DML statements
    //Accounts
    String INSERT_HISTORY_ACCOUNTS = "insert into account_action (account_id,action,date,admin_id,bloodBank_id)values(?,?,?,?,?)";
    String UPDATE_TABLE_ACCOUNTS = "select * from accounts where bloodBank_id=?";
    String INSERT_ACCOUNT = "insert into accounts(account_name,password,status,isAdmin,bloodBank_id)values(?,?,?,?,?) ";
    String UPDATE_ACCOUNT = "update accounts set account_name=?,paswords=?, status=?, isAdmin=? where id=? and bloodBank_id=?";
    String DELETE_ACCOUNT = "delete from accounts where id = ? and bloodBank_id=?";
    String GET_ADMIN_COUNT = "SELECT COUNT(*) FROM accounts WHERE isAdmin = ? and bloodBank_id=?";
    
    //BloodPack
    String INSERT_HISTORY_BLOODPACKS = "insert into bloodpack_action (bloodPack_id,action,date,account_id,bloodBank_id)values(?,?,?,?,?)";
    String SELECT_PACKTYPE = "select * from packtype where bloodBank_id=?";
    String SELECT_DONOR = "select donorName from donor where id=? and bloodBank_id=?";
    String CHECK_NAME = "select* from donor where donorName = ? and bloodBank_id=?";
    String GET_BLOODTYPE = "select bloodType from donor where id = ? and bloodBank_id=?";
    String GET_DID = "select id from donor where donorName=? and bloodBank_id=?";
    String GET_SHELFLIFE = "select shelfLife from packtype where id=? and bloodBank_id=?";
    String UPDATE_TABLE_BLOODPACKS = "select bp.id,bp.packType_id,bp.bloodType, bp.date_collected,bp.donor_id, bp.date_registered, bp.account_id,bp.quantity,bp.status,pt.packType, d.donorName, d.bloodType "
                        + "from bloodpack bp,packtype pt,donor d where bp.packType_id = pt.id and bp.donor_id = d.id and bp.bloodBank_id = pt.bloodBank_id and bp.bloodBank_id = d.bloodBank_id and bp.bloodBank_id=?";
    String DELETE_BLOODPACK = "delete from bloodpack where id = ? and bloodBank_id=?";
    String UPDATE_BLOODPACK = "update bloodpack set donor_id=?,date_collected=?,packType_id=?,bloodType=?,quantity=?,status=? where id=? and bloodBank_id=?";
    String INSERT_BLOODPACK = "insert into bloodpack(packType_id,bloodType,date_collected,donor_id,date_registered,account_id,quantity,status,bloodBank_id)values(?,?,?,?,?,?,?,?,?)";
    
    ////Donor
    String INSERT_HISTORY_DONOR = "insert into donor_action (donor_id,action,date,account_id,bloodBank_id)values(?,?,?,?,?)";
    String UPDATE_TABLE_DONOR = "select * from donor where bloodBank_id=?";
    String INSERT_DONOR = "insert into donor(donorName,contactNum,add1,add2,bloodType,age,status,bloodBank_id)values(?,?,?,?,?,?,?,?) ";
    String UPDATE_DONOR = "update donor set donorName=?,contactNum=?,add1=?,add2=?,bloodType=?,age=?,status=? where id=? and bloodBank_id=?";
    String DELETE_DONOR = "delete from donor where id = ? and bloodBank_id=?";
    
    //PackType
    String INSERT_HISTORY_PACKTYPE = "insert into packtype_action (packType_id,action,date,account_id,bloodBank_id)values(?,?,?,?,?)";
    String UPDATE_TABLE_PACKTYPE = "select * from packtype where bloodBank_id=?";
    String INSERT_PACKTYPE = "insert into packtype (packType,shelfLife,status,bloodBank_id)values(?,?,?,?) ";
    String UPDATE_PACKTYPE = "update packtype set packType=?,shelfLife=?,status=? where id=? and bloodBank_id=?";
    String DELETE_PACKTYPE = "delete from packtype where id = ? and bloodBank_id=?";
    
    //editHistory
    String PACKTYPE_ACTION = "select * from packtype_action where bloodBank_id=?";
    String BLOODTYPE_ACTION = "select * from donor_action where bloodBank_id=?";
    String BLOODPACK_ACTION = "select * from bloodpack_action where bloodBank_id=?";
    String ACCOUNTS_ACTION = "select * from account_action where bloodBank_id=?";
    //methods
    Connection createConnection() throws ClassNotFoundException, SQLException;
}
