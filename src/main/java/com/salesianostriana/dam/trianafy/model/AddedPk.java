package com.salesianostriana.dam.trianafy.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@NoArgsConstructor
@Embeddable
@Data
public class AddedPk implements Serializable {
    long song_id;
    long playlist_id;
    public AddedPk(long song_id, long playlist_id) {
        this.song_id = song_id;
        this.playlist_id= playlist_id;
    }
}
