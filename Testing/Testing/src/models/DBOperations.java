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
    
    //perform DML statements
    String GET_ID = "select id from accounts where account_name=? and password = ?";
    String GET_NAME = "select * from accounts where id = ?";
    String GET_PASS = "select password from accounts where id=?";
    String GET_NAME_AND_PASS = "select * from accounts where account_name = ? and password =?";
    
    //Accounts DML statements
    //Accounts
    String INSERT_HISTORY_ACCOUNTS = "insert into account_action (account_id,action,date,admin_id)values(?,?,?,?)";
    String UPDATE_TABLE_ACCOUNTS = "select * from accounts";
    String INSERT_ACCOUNT = "insert into accounts(account_name,password,status,isAdmin)values(?,?,?,?) ";
    String UPDATE_ACCOUNT = "update accounts set account_name=?,paswords=?, status=?, isAdmin=? where id=?";
    String DELETE_ACCOUNT = "delete from accounts where id = ?";
    String GET_ADMIN_COUNT = "SELECT COUNT(*) FROM accounts WHERE isAdmin = ?";
    
    //BloodPack
    String INSERT_HISTORY_BLOODPACKS = "insert into bloodpack_action (bloodPack_id,action,date,account_id)values(?,?,?,?)";
    String SELECT_PACKTYPE = "select * from packtype";
    String SELECT_DONOR = "select donorName from donor where id=?";
    String CHECK_NAME = "select* from donor where donorName = ?";
    String GET_BLOODTYPE = "select bloodType from donor where id = ?";
    String GET_DID = "select id from donor where donorName=?";
    String GET_SHELFLIFE = "select shelfLife from packtype where id=?";
    String UPDATE_TABLE_BLOODPACKS = "select bp.id,bp.packType_id,bp.bloodType, bp.date_collected,bp.donor_id, bp.date_registered, bp.account_id,bp.quantity,bp.status,pt.packType, d.donorName, d.bloodType "
                        + "from bloodpack bp,packtype pt,donor d where bp.packType_id = pt.id and bp.donor_id = d.id";
    String DELETE_BLOODPACK = "delete from bloodpack where id = ?";
    String UPDATE_BLOODPACK = "update bloodpack set donor_id=?,date_collected=?,packType_id=?,bloodType=?,quantity=?,status=? where id=?";
    String INSERT_BLOODPACK = "insert into bloodpack(packType_id,bloodType,date_collected,donor_id,date_registered,account_id,quantity,status)values(?,?,?,?,?,?,?,?)";
    
    ////Donor
    String INSERT_HISTORY_DONOR = "insert into donor_action (donor_id,action,date,account_id)values(?,?,?,?)";
    String UPDATE_TABLE_DONOR = "select * from donor";
    String INSERT_DONOR = "insert into donor(donorName,contactNum,add1,add2,bloodType,age,status)values(?,?,?,?,?,?,?) ";
    String UPDATE_DONOR = "update donor set donorName=?,contactNum=?,add1=?,add2=?,bloodType=?,age=?,status=? where id=?";
    String DELETE_DONOR = "delete from donor where id = ?";
    
    //PackType
    String INSERT_HISTORY_PACKTYPE = "insert into packtype_action (packType_id,action,date,account_id)values(?,?,?,?)";
    String UPDATE_TABLE_PACKTYPE = "select * from packtype";
    String INSERT_PACKTYPE = "insert into packtype (packType,shelfLife,status)values(?,?,?) ";
    String UPDATE_PACKTYPE = "update packtype set packType=?,shelfLife=?,status=? where id=?";
    String DELETE_PACKTYPE = "delete from packtype where id = ?";
    
    //editHistory
    String PACKTYPE_ACTION = "select * from packtype_action";
    String BLOODTYPE_ACTION = "select * from donor_action";
    String BLOODPACK_ACTION = "select * from bloodpack_action";
    String ACCOUNTS_ACTION = "select * from account_action";
    //methods
    Connection createConnection() throws ClassNotFoundException, SQLException;
}
