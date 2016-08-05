package MVC.models;

import MVC.environment.Database;

public class PlaylistUserMapping {
    public PlaylistUserMapping(User _user, Playlist _playlist){

        // SETTING ATTRIBUTES

        if(Database.PLAYLISTUSERMAPPINGS.size() == 0){
            m_id = 0;
        } else {
            m_id = Database.PLAYLISTUSERMAPPINGS.get(Database.PLAYLISTUSERMAPPINGS.size() - 1).m_id + 1;
        }

        m_user = _user;
        m_playlist = _playlist;
    }

    public int m_id;
    public User m_user;
    public Playlist m_playlist;
}
