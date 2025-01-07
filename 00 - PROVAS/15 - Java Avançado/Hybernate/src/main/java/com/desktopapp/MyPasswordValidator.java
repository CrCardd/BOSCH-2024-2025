package com.desktopapp;

public class MyPasswordValidator {
    
    public static boolean Validate(String password) {
        if (password.length() < 8)
            return false;
            
    
        if( !password.contains("@") && 
            !password.contains("!") &&
            !password.contains("_") &&
            !password.contains("#") &&
            !password.contains(">") &&
            !password.contains("<") &&
            !password.contains("*")){
            return false;
        }
        if(!password.chars().anyMatch(c -> c >= '0' && c <= '9')){
            return false;
        }
        if(!password.chars().anyMatch(c -> c >= 'a' && c <= 'z')){
            return false;
        }
        
        return true;
    }
}
