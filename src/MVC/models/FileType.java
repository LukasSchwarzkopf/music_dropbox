package MVC.models;

import MVC.environment.Database;

import java.util.List;

public class FileType {
    public FileType(String _title){
        if(Database.FILETYPES.size() == 0){
            m_id = 0;
        } else {
            m_id = Database.FILETYPES.get(Database.FILETYPES.size() - 1).m_id + 1;
        }
        m_title = _title;
        Database.FILETYPES.add(this);
    }

    public int m_id;
    public String m_title;

    // DATABASE TRANSACTIONS

    //    FIND USER BY ID
    public static FileType find(int _id){
        for(FileType type : FileType.all()){
            if(type.m_id == _id){
                return type;
            }
        }
        return null;
    }

    /**
     * LIST OF ALL FILETYPES
     *
     * @return list of file_types
     *
     * Creates a list of users with the role "user" to
     * seperate ths user-group from other groups
     *
     * Role "user" is the default
     */
    public static List<FileType> all(){
        return Database.FILETYPES;
    }

    public void delete(){
        Database.FILETYPES.remove(this);
    }

    @Override
    public String toString() {
        StringBuilder returnstring = new StringBuilder("<MVC.models.FileType::{");
        returnstring.append("m_id: " + m_id);
        returnstring.append(", m_title: " + m_title);
        return returnstring.append(" }>").toString();
    }
}
