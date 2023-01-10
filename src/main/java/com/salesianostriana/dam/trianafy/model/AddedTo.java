package com.salesianostriana.dam.trianafy.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AddedTo {

    @EmbeddedId
    private AddedPk id = new AddedPk();
    private LocalDate datetime;
    private int orden;


    @ManyToOne
    @MapsId("song_id")
    @JoinColumn(name = "song_id")
    private Song song;

    @ManyToOne
    @MapsId("playlist_id")
    @JoinColumn(name = "playlist_id")
    private Playlist playlist;

    public void addSong(Song s) {
        song = s;
        s.getAddedToList().add(this);
    }

    public void removeSong(Song s) {
        s.getAddedToList().remove(this);
        song = null;
    }

    public void addPLaylist(Playlist p) {
        playlist = p;
        p.getAddedToList().add(this);
    }

    public void removeFromPlaylist(Playlist p) {
        p.getAddedToList().remove(this);
        playlist = null;
    }
    public void addPrimaryKey(Playlist p, Song s){
        addSong(s);
        addPLaylist(p);
    }
}
