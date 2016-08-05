package MVC.models;

import MVC.environment.Database;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    public Playlist(User _user, String _title) {
        if(Database.PLAYLISTS.size() == 0){
            m_id = 0;
        } else {
            m_id = Database.PLAYLISTS.get(Database.PLAYLISTS.size() - 1).m_id + 1;
        }

        // SETTING ATTRIBUTES
        m_title = _title;
        m_user = _user;
        Database.PLAYLISTS.add(this);
    }

    public int m_id;
    public User m_user;
    public String m_title;

    public boolean add(MusicFile _file){
        PlaylistMusicFileMapping mapping = new PlaylistMusicFileMapping(_file, this);
        if(mapping != null){
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(MusicFile _file){
        PlaylistMusicFileMapping mapping = PlaylistMusicFileMapping.find_by_playlist_and_file(this, _file);
        if(mapping != null){
            mapping.delete();
            return true;
        } else {
            return false;
        }
    }

    // RELATIONS

    /**
     * ALL MUSICFILES FOR USER
     * M : N RELATION
     *
     */
    public List<MusicFile> musicfiles(){
        List<MusicFile> musicfiles = new ArrayList<>();
        for(PlaylistMusicFileMapping mapping : Database.PLAYLISTMUSICFILEMAPPINGS){
            if(mapping.m_playlist.m_id == this.m_id){
                musicfiles.add(mapping.m_music_file);
            }
        }
        return musicfiles;
    }

    public void delete(){
        Database.PLAYLISTS.remove(this);
    }

    //    FIND PLAYLIST BY ID
    public static Playlist find(int _id){
        for(Playlist list : Playlist.all()){
            if(list.m_id == _id){
                return list;
            }
        }
        return null;
    }

    /**
     * LIST OF ALL MUSICFILES
     *
     */
    public static List<Playlist> all(){
        return Database.PLAYLISTS;
    }

    @Override
    public String toString() {
        StringBuilder returnstring = new StringBuilder("<MVC.models.Playlist::{");
        returnstring.append("m_id: " + m_id);
        returnstring.append(", m_user: " + m_user.m_id);
        returnstring.append(", m_title: " + m_title);
        return returnstring.append(" }>").toString();
    }
}
