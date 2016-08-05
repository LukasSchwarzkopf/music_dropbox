package MVC.controllers;

import MVC.models.MusicFile;
import MVC.models.Playlist;
import MVC.models.User;

public class PlaylistsController {

    public static boolean add_musicfile(int _id, int _musicfile_id){
        Playlist playlist = Playlist.find(_id);
        MusicFile file = MusicFile.find(_musicfile_id);
        playlist.add(file);
        return true;
    }

    public static boolean remove_musicfile(int _id, int _musicfile_id){
        Playlist playlist = Playlist.find(_id);
        MusicFile file = MusicFile.find(_musicfile_id);
        playlist.remove(file);
        return true;
    }

    public static boolean invite(int _owner_id, int _invited_id, int _playlist_id){
        User owner = User.find(_owner_id);
        User invited_user = User.find(_invited_id);
        Playlist playlist = Playlist.find(_playlist_id);
        if(playlist.m_user == owner){
            playlist.invite(invited_user);
            return true;
        } else {
            return false;
        }
    };
}
