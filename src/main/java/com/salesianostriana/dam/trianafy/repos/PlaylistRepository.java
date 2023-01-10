package com.salesianostriana.dam.trianafy.repos;

import com.salesianostriana.dam.trianafy.model.Playlist;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {


    @EntityGraph("playlist-con-canciones")
    Optional<Playlist> findById(Long id);

    @Query("""
            select p from Playlist p
            left join fetch p.songs s left join fetch s.artist a
            where a.name = :name
            """)
    Optional<Playlist> playlistByArtist(@Param("name")String name);
}
