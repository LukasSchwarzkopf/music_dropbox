package MVC.controllers;

import MVC.models.MusicFile;
import MVC.models.Playlist;

public class PlaylistsController {

    public boolean add_musicfile(int _id, int _musicfile_id){
        Playlist playlist = Playlist.find(_id);
        MusicFile file = MusicFile.find(_musicfile_id);
        playlist.add(file);
        return true;
    }

    public boolean remove_musicfile(int _id, int _musicfile_id){
        Playlist playlist = Playlist.find(_id);
        MusicFile file = MusicFile.find(_musicfile_id);
        playlist.remove(file);
        return true;
    }
}
