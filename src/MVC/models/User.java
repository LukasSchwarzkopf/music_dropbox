package MVC.models;

import MVC.environment.Database;

import java.util.ArrayList;
import java.util.List;

public class User {

    public User() {
    }

    /**
     * WORK IN PROGRESS
     *
     * CREATES A NEW USER
     *
     * @param _firstname
     * @param _lastname
     * @param _role
     *
     * Allows the user to create a new account.
     */
    public User(String _firstname, String _lastname, String _role, String _username, String _password){
        /*
        * Counts the number of user in the database and creates a new ID.
        *
        * when the database is in place, this function will be expandable, due to
        * the auto_increment function in the database
        */

        // SETTING ID SINCE DATABASE IS REAL
        /*
        * Current Problem: doesnt increment the ID, no idea why
        * */

        // SETTING ATTRIBUTES

        if(Database.USERS.size() == 0){
            m_id = 0;
        } else {
            m_id = Database.USERS.get(Database.USERS.size() - 1).m_id + 1;
        }

        m_firstname = _firstname;
        m_lastname = _lastname;
        m_username = _username;
        m_password = _password;

        m_role = _role;
        Database.USERS.add(this);
    };

    public int m_id;
    public String m_username;
    public String m_password;
    public String m_firstname;
    public String m_lastname;
    public String m_role;

    /**
     * LIST OF ALL ADMIN
     *
     * @return list of admins
     *
     * Creates a list of users with the role "admin" to
     * seperate ths user-group from other groups
     */
    public static List<User> admins(){
        List<User> admins = new ArrayList();
        for(User cur_user : Database.USERS){
            if(cur_user.m_role == "admin"){
                admins.add(cur_user);
            }
        }
        return admins;
    }

    /**
     * LIST OF ALL USERS
     *
     * @return list of users with the role "user"
     *
     * Creates a list of users with the role "user" to
     * seperate ths user-group from other groups
     *
     * Role "user" is the default
     */
    public static List<User> all(){
        List<User> users = new ArrayList();
        for(User cur_user : Database.USERS){
            if(cur_user.m_role == "user"){
                users.add(cur_user);
            }
        }
        return users;
    }

//    FIND USER BY ID
    public static User find(int _id){
        for(User user : User.all()){
            if(user.m_id == _id){
                return user;
            }
        }
        return null;
    }

    /**
     * FIRST USER
     *
     */
    public static User first(){
        return Database.USERS.size() > 0 ? Database.USERS.get(0) : null;
    }

    /**
     * LAST USER
     *
     */
    public static User last(){
        return Database.USERS.size() > 0 ? Database.USERS.get(Database.USERS.size() - 1) : null;
    }

    /**
     * CREATES THE FULLNAME OF A USER
     *
     * @return full name of a user
     *
     */
    public String full_name(){
        return "" + m_firstname + " " + m_lastname;
    }

    public static boolean exists(String _username){
        for(User user : User.all()){
            if(user.m_username == _username){
                return true;
            }

        }
        return false;
    }

    // RELATIONS

    /**
     * ALL
     *
     *
     * MUSICFILES FOR USER
     *
     */
    public List<MusicFile> musicfiles(){
        List<MusicFile> musicfiles = new ArrayList<>();
        for(MusicFile musicfile : Database.MUSICFILES){
            if(musicfile.m_user == this){
                musicfiles.add(musicfile);
            }
        }
        return musicfiles;
    }

    public void delete(){
        Database.USERS.remove(this);
    }

    public static User find_by_authentication_data(String _username, String _password){
        for(User user : User.all()){
            if(user.m_username.equals(_username) && user.m_password == _password){
                return user;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder returnstring = new StringBuilder("<MVC.models.User::{");
        returnstring.append("m_id: " + m_id);
        returnstring.append(", m_firstname: " + m_firstname);
        returnstring.append(", m_lastname: " + m_lastname);
        returnstring.append(", m_role: " + m_role);
        return returnstring.append(" }>").toString();
    }
}
