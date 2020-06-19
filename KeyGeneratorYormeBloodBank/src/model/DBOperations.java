/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;

/**
 *
 * @author CHISDOG
 * @author HOTDOG
 * 
 */
public interface DBOperations {

    /**
     * ALl JDBC CODES
     */
    String JDBC_DRIVER_NAME = "com.mysql.jdbc.Driver";
    String JDBC_URL = "jdbc:mysql://localhost/yormebloodbank";
    String DB_USER_NAME = "root";
    String DB_PASSWORD = "";
//    String JDBC_DRIVER_NAME = "com.mysql.jdbc.Driver";
//    String JDBC_URL = "jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12336850";
//    String DB_USER_NAME = "sql12336850";
//    String DB_PASSWORD = "F7SKCzgqMN";

    //TEMPLATE
    //String INSERT_ACCOUNT = "insert into accounts(account_name,password,status,isAdmin,bloodBank_id)values(?,?,?,?,?) ";
    // String UPDATE_ACCOUNT = "update accounts set account_name=?,password=?, status=?, isAdmin=? where id=? and bloodBank_id=?";
    //  String DELETE_BLOODPACK = "delete from bloodpack where id = ? and bloodBank_id=?";
    
    //GET DEV ACCOUNT TABLE ON YormeBloodBank Server
    String DEV_LOGIN = "select * from dev_accounts where devUser =? and devPass =? ";
    
    //GET THOSE KEYS YEAH BABEH
    String INSERT_KEYS = "insert into activationkeys (activationID,designation)VALUES(?,?) ";
    String UPDATE_KEYS = "update activationkeys set activationID=?,designation=? where id = ?";
    String UPDATE_TABLE_KEYS = "select * from activationkeys";
    
    //DELETE THOSE KEYS BABEH
    String DELETE_KEY = "delete from activationkeys where id= ?";
    
    //perform DML statements
    String GET_ID = "select id from accounts where account_name=? and password = ? and bloodBank_id=?";
    String GET_NAME = "select * from accounts where id = ? and bloodBank_id=?";
    String GET_PASS = "select password from accounts where id=? and bloodBank_id=?";
   
    
    //Accounts DML statements
   
    //methods
    Connection createConnection() throws ClassNotFoundException, SQLException;
}
