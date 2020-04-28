/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static java.lang.String.format;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static javax.management.Query.*;

/**
 *
 * @author Altheo
 */
public class errorcheck {
    
    
    /*
     @Authoriry HOTDOG
    */
    
    //Check if String is all numbers
    public boolean numberOrNot(String input){
        try
        {
            Integer.parseInt(input);
        }
        catch(NumberFormatException ex)
        {
            return false;
        }
        return true;
    }
    
    //Check if First text on String is number
    public boolean firstNumberOrNot(String input) {
        String str = input;
 
        //Check whether the given first character is a number /digit or not ?
 
        for(int i=-1; i<str.length();i++){
           
            
           Boolean flag = Character.isDigit(str.charAt(0));
           
           if(flag == true){
               return true;
           }
           
           else{  
               return false;
           }
     
        }
        return false;
        
     }
     //Checks if their is whitespace
    public boolean CheckWhiteSpace(String input){
         String check_for_whitespace = input;
            
        
        int l=check_for_whitespace.length();
        int count=0;
        for(int i=0;i<l;i++)
        {
            char c=check_for_whitespace.charAt(i);
            if(c==' '){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
     }
     
    //String input character minimum eight
    public boolean CharMinEight(String input){
         String text_count = input;
         int ctr= 0;
         
         //Counts each character
         for(int i = 0; i < text_count.length(); i++) {    
            if(text_count.charAt(i) != ' ')    
                ctr++;    
          } 
         
         if(ctr > 7){
             return false;
         }else{
             return true;
         }
         
     }
     
     //String input character minimum eight
     public boolean CharMinTwelve(String input){
         String text_count = input;
         int ctr= 0;
         
         //Counts each character
         for(int i = 0; i < text_count.length(); i++) {    
            if(text_count.charAt(i) != ' ')    
                ctr++;    
          } 
         
         if(ctr > 11){
             return false;
         }else{
             return true;
         }
         
     }
     
    //If Sting has Illegal Characters 
    public boolean isContainIllegalChar(String input){
        String[] arr = input.split("[~#@$*+%{}<>\\[\\]|\"\\_^]", 2);//Illegal Characters
        return arr.length > 1;
        //if arr.length(1) then one of the char is an invalid character
    }
     
    //Check if altest two numbers in pass input
    public boolean checkInput(String input) {
        char ch;
        boolean capitalFlag = false;
        boolean lowerCaseFlag = false;
        boolean numberFlag = false;
        
        for(int i=0;i < input.length();i++) {
            ch = input.charAt(i);
            if( Character.isDigit(ch)) {
                numberFlag = true;
            }
            else if (Character.isUpperCase(ch)) {
                capitalFlag = true;
            } else if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
            }
            if(numberFlag && capitalFlag && lowerCaseFlag)
                return true;
    }
    return false;
    }
    
    //Check if String is empty 
    public boolean isEmpty(String input){
        String str = input;
        
        String theEmptyString = "";
        
        if(input == null || str.equals(theEmptyString)){
            return true;
        }else{
            return false;
        }
       
    }
    
    //Check if date input follows the specified format
    public  boolean isValidFormat(String input){
     
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
        boolean flag = false;

        try{//parse input to date and check that shit
           dateFormat.parse(input); 
        }catch(ParseException e){
           flag = true;
        }
      return flag;
    }
    
   //Check if String has letter
    public boolean isLetter(String input){
       if(input.matches(".*[a-z].*")) { 
           return true;
        }
       return false;
    }
    
    
    
    
}
