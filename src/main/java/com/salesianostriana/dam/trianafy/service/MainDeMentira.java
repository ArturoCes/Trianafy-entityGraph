package com.salesianostriana.dam.trianafy.service;

import com.salesianostriana.dam.trianafy.model.*;
import com.salesianostriana.dam.trianafy.repos.AddedToRepository;
import com.salesianostriana.dam.trianafy.repos.ArtistRepository;
import com.salesianostriana.dam.trianafy.repos.PlaylistRepository;
import com.salesianostriana.dam.trianafy.repos.SongRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component

@RequiredArgsConstructor
public class MainDeMentira {
    public final ArtistRepository artistRepository;
    public final SongRepository songRepository;
    public  final PlaylistRepository playlistRepository;
    public  final AddedToRepository addedToRepository;
    @PostConstruct
    public void run() {
        Artist a1 = Artist.builder()
                .name("Violadores del verso")
                .build();

        Artist a2 = Artist.builder()
                .name("SFDK")
                .build();

        Artist a3 = Artist.builder()
                .name("Dogma Crew")
                .build();

        artistRepository.saveAll(List.of(a1,a2,a3));

        Song s1 = Song.builder()
                .title("Filosofía y letras")
                .album("Vivir para Contarlo")
                .artist(a1)
                .build();

        Song s2 = Song.builder()
                .title("Prúebalo")
                .album("Siempre Fuertes")
                .artist(a2)
                .build();

        Song s3 = Song.builder()
                .title("Antiheroe")
                .album("Nacen de la Bruma")
                .artist(a3)
                .build();

        songRepository.saveAll(List.of(s1, s2, s3));

        Playlist p1 = Playlist.builder()
                .name("Rap pal Body")
                .description("Lista de reproducción con Hip-Hoppity-Hop")
                .build();
        Playlist p2 = Playlist.builder()
                .name("Alternativo")
                .description("Lista de reproducción de música alternativa")
                .build();
        Playlist p3 = Playlist.builder()
                .name("Music")
                .description("Lista de reproducción de música")
                .build();

        playlistRepository.saveAll(List.of(p1,p2,p3));

        AddedPk addedPk1 = new AddedPk(s1.getId(), p1.getId());
        AddedPk addedPk2 = new AddedPk(s2.getId(), p2.getId());
        AddedPk addedPk3 = new AddedPk(s3.getId(), p3.getId());



        AddedTo add1 = AddedTo.builder()
                .id(addedPk1)
                .datetime(LocalDate.now())
                .build();

        add1.addPrimaryKey(p1,s1);

        addedToRepository.save(add1);

        AddedTo add2 = AddedTo.builder()
                .id(addedPk2)
                .datetime(LocalDate.now())
                .build();
        add2.addPrimaryKey(p2,s2);
        addedToRepository.save(add2);

        AddedTo add3 = AddedTo.builder()
                .id(addedPk3)
                .datetime(LocalDate.now())
                .build();
        add3.addPrimaryKey(p3,s3);
        addedToRepository.save(add3);
    }
}

