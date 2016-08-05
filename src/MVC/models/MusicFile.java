package MVC.models;

import MVC.environment.Database;

import java.io.File;
import java.util.List;

public class MusicFile{

    public MusicFile() {
    }

    /**
     * ADDING NEW MUSICFILES
     *
     * @param _title
     * @param _album
     * @param _interpret
     * @param _file
     *
     * Allows the user to add music-files from a local storage to the database
     *
     * The user can add an audio-file with a -mp3-extension (at the moment there are only
     * mp3-Files allowed, could change in the future) and has to add a title and interpret and album
     * of the audio-file. Title, interpret and album could later be used for sorting purposes.
     *
     * At the moment there are no character restrictions for the input of the title, interpret and album
     * because all three Objects can contain characters, digits, whitespaces and non-characters.
     *
     * Also there is at the moment no restriction to add the same files multiple times. Adding a function
     * to prevent the insertion of multiple copies of the same file could be added (and is planned) in the
     * future.
     *
     * Also at the moment there is no function which could allows the user to delete audio-files from the database.
     * This will also added in the future, once the real database is in place.
     */
    public MusicFile(User _user, String _title, String _album,String _interpret, File _file){

        // CHECKING FILE EXTENSION
        /*
        Only Files with the .mp3 extension will be excepted. But the List of the allowed extensions can be extended
        if necessary

         */

        String file_path = _file.getPath().toString();
        String file_extension = file_path.substring(file_path.indexOf(".") + 1, file_path.length());

        if(MusicFile.allowed_to_upload(file_extension)){
            // SETTING ATTRIBUTES

            if(Database.MUSICFILES.size() == 0){
                m_id = 0;
            } else {
                m_id = Database.MUSICFILES.get(Database.MUSICFILES.size() - 1).m_id + 1;
            }

            m_title = _title;
            m_user = _user;
            m_album = _album;
            m_interpret = _interpret;
            m_file = _file;
            Database.MUSICFILES.add(this);
        } else {
            System.out.println("INVALID FILETYPE");
        }
    };

    public int m_id;
    public String m_title;
    public String m_interpret;
    public String m_file_path;
    public String m_album;
    public File m_file;
    public User m_user;
    /**
     * Work in progress!
     *
     * The Function to delete music-files from the database isn't really necessary at the moment,
     * due to the lack of a "real" database.
     * Will added later with certainty.
     *
     * @return
     *
     * How it should work later:
     * Function should search, if there is a file with title x for a certain user with the userid y
     * and to delete this file if it's exist
     */



    public static boolean allowed_to_upload(String _file_extension) {
        boolean result = false;
        for(FileType type : FileType.all()){
            if(type.m_title.equals(_file_extension)){
                result = true;
            }
        }
        return result;
    }

    // DATABASE TRANSACTIONS

    public static MusicFile find(int _id){
        for(MusicFile file : MusicFile.all()){
            if(file.m_id == _id){
                return file;
            }
        }
        return null;
    }

    /**
     * LIST OF ALL MUSICFILES
     *
     */
    public static List<MusicFile> all(){
        return Database.MUSICFILES;
    }

    public void delete(){
        Database.MUSICFILES.remove(this);
    }


    @Override
    public String toString() {
        StringBuilder returnstring = new StringBuilder("<MVC.models.MusicFile::{");
        returnstring.append("m_id: " + m_id);
        returnstring.append(", m_title: " + m_title);
        returnstring.append(", m_interpret: " + m_interpret);
        returnstring.append(", m_album: " + m_album);
        return returnstring.append(" }>").toString();
    }
}
