package MVC.controllers;

import MVC.models.MusicFile;
import MVC.models.User;

import java.io.File;

public class MusicFilesController {
    public boolean create(int _user_id, String _title, String _album, String _interpret, File _file){
        MusicFile musicfile = new MusicFile(User.find(_user_id), _title, _album, _interpret, _file);
        return true;
    }

    public boolean update(int _id, String _title, String _album, String _interpret, File _file){
        MusicFile musicfile = MusicFile.find(_id);
        if(musicfile != null){
            // update musicfile
            musicfile.m_album = _album;
            musicfile.m_file = _file;
            musicfile.m_interpret = _interpret;
            musicfile.m_title = _title;
            return true;
        } else {
            // musicfile not found
            return false;
        }
    }

    public boolean delete(int _id){
        MusicFile file = MusicFile.find(_id);
        file.delete();
        return true;
    }


}
