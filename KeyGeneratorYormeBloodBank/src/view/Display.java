/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Altheo
 * @author hotdog
 */
public interface Display {
    
    //DEV APP MESSAGE
    String ADMIN_WRONG_CREDENTIALS = "Wrong Dev user or password";
    
    
    
    // ADMIN MESSAGES
    String ADMIN_ONLY = "Only Admin accounts can use this feature";
    String LOGIN_AS_ADMIN = "Do you log in an Admin account?";
    String CANNOT_ADD = "Cannot add more Admin...Only 5 Admin Allowed";
    String DELETE_RECORD = "Do you want to Delete the Record?";
    String RECORD_DELETED = "Record Deleted";
    String ACCT_NOT_ACTIVE = "Your account is not active please contact your admin...";
    String USER_PASS_INVALID = "Username and Password are wrong!!!";
    String PASS_CONFIRMED_WRONG = "Passwords do not match, please try again.";
    
    //DATE FORMAT
    String DATE_TIME = "yyyy/MM/dd HH:mm:ss";
    String DATE = "yyyy/MM/dd";
    
    //SYSTEM ERROR MESSAGE
    String DB_INVALID = "connection to db is INVALID";
    String SYS_ERROR = "System Error Please contact the Developers....";
    String NOT_EMPTY = "Input must not a empty character";
    String NAME_NUM = "Number only not allowed!";
    String FIRST_NOT_NUM = "First text of the username must not be a number!";
    String NO_SPACE = "Input must not contain whitespace";
    String MIN_EIGHT = "Input must be minimum of eight characters";
    String NO_ILLEGAL_CHAR = "Input contains Illegal character!!";
    String MIN_TWELVE = "Input password must be at least twelve characters";
    String ONE_NUM_ONE_UP = "Input password must have at least one number and one uppercase or a (-,_)";
    String COMBO_EMP = "Combo box is empty!!!";
    String QTY_NUM = "Qty must not have a letter";
    String LIFE_NUM = "Input Shelf life must be a number!!!!";
    String NO_LETTER = "Input must contain atleast one letter";
    
    //Accounts
    String USER_ADDED = "User Account Added";
    String ID_ADDED = "Added Account ID: ";
    String UPDATE_ACCT = "Accounts Updated";
    String UPDATE_ID = "Edited Account ID: ";
    String ACCT_DELETED = "Account Deleted";
    String ACCT_ID_DELETED = "Deleted Account ID: ";
    
    //BloodPacks
    String BP_ID_DELETED = "Deleted Blood Pack ID: ";
    String DATE_FORMAT = "Data Collected input must follow the format specified";
    String DATE_EMPTY = "Data Collected input must not have a empty character";
    String BP_UPDATED = "Blood Pack Updated";
    String BP_ID_UPDATED = "Edited Blood Pack ID: ";
    String BP_ADD_ID = "Added Blood Pack ID: ";
    
    //BloodType
    String BT_ID_DELETE = "Deleted Donor: " ;
    String BT_DELETED = "Donor Deleted";
    String BT_ID_UPDATED = "Edited Donor: ";
    String BT_UPDATED = "Donor Updated";
    String BT_ID_ADDED = "Added Donor ID: ";
    String BT_ADDED = "Donor Added";
    String BT_EXIST = "Donor Already Exist try again...";
    
    //PackType
    String PT_ID_DELETE = "Deleted Pack Type ID: ";
    String PT_DELETE = "Key Type Deleted";
    String PT_UPDATED = "Key Updated";
    String PT_ID_UPDATED = "Edited Pack Type ID: ";
    String PT_ID_ADD = "added Pack Type ID: ";
    String PT_ADD = "Pack type added";
    
}
