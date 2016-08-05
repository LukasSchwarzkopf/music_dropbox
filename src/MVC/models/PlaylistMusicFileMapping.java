package MVC.models;

import MVC.environment.Database;

public class PlaylistMusicFileMapping {
    /**
     * CREATES A M:N RELATION BETWEEN MUSIC_FILES AND A PLAYLIST
     *
     * @param _music_file
     * @param _playlist
     */
    public PlaylistMusicFileMapping(MusicFile _music_file, Playlist _playlist){

        if(Database.PLAYLISTMUSICFILEMAPPINGS.size() == 0){
            m_id = 0;
        } else {
            m_id = Database.PLAYLISTMUSICFILEMAPPINGS.get(Database.PLAYLISTMUSICFILEMAPPINGS.size() - 1).m_id + 1;
        }

        // SETTING ATTRIBUTES

        m_music_file = _music_file;
        m_playlist = _playlist;
        Database.PLAYLISTMUSICFILEMAPPINGS.add(this);
    }

    public int m_id;

    public MusicFile m_music_file;
    public Playlist m_playlist;


    public void delete(){
        Database.PLAYLISTMUSICFILEMAPPINGS.remove(this);
    }

    @Override
    public String toString() {
        StringBuilder returnstring = new StringBuilder("<MVC.models.PlaylistMusicFileMapping::{");
        returnstring.append("m_id: " + m_id);
        returnstring.append(", m_music_file_id: " + m_music_file.m_id);
        returnstring.append(", m_playlist_id: " + m_playlist.m_id);
        return returnstring.append(" }>").toString();
    }

    public static PlaylistMusicFileMapping find_by_playlist_and_file(Playlist _playlist, MusicFile _file) {
        for(PlaylistMusicFileMapping mapping : Database.PLAYLISTMUSICFILEMAPPINGS){
            if(mapping.m_playlist == _playlist && mapping.m_music_file == _file){
                return mapping;
            }
        }
        return null;
    }
}
