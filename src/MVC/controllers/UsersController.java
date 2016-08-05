package MVC.controllers;

import MVC.environment.Database;
import MVC.helpers.Cryptor;
import MVC.models.User;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

public class UsersController {

    public static boolean sign_in(String _username, String _password) throws GeneralSecurityException, UnsupportedEncodingException {
        String encrypted_password = Cryptor.encrypt(Database.secret, Database.secret2, _password);
        User user = User.find_by_authentication_data(_username, encrypted_password);

        if(user != null){
            return true;
        } else {
            return false;
        }
    }

    public static boolean sign_up(String _firstname, String _lastname, String _password, String _username) throws GeneralSecurityException, UnsupportedEncodingException {
        if(User.exists(_username)){
            return false;
        } else {
            User user = new User(_firstname, _lastname, "user", Cryptor.encrypt(Database.secret, Database.secret2, _password), _username);
            return true;
        }
    }

    public static boolean update(String _actual_username, String _actual_password, String _firstname, String _lastname, String _password, String _username) throws GeneralSecurityException, UnsupportedEncodingException {
        String encrypted_password = Cryptor.encrypt(Database.secret, Database.secret2, _actual_password);
        User user = User.find_by_authentication_data(_actual_username, encrypted_password);

        if(user != null){
            user.m_password = _password;
            user.m_username = _username;
            user.m_firstname = _firstname;
            user.m_lastname = _lastname;
            return true;
        } else {
            return false;
        }
    }

    public static boolean destroy(String _username, String _password) throws GeneralSecurityException, UnsupportedEncodingException {
        String encrypted_password = Cryptor.encrypt(Database.secret, Database.secret2, _password);
        User user = User.find_by_authentication_data(_username, encrypted_password);

        if(user != null){
            user.delete();
            return true;
        } else {
            return false;
        }
    }
}
