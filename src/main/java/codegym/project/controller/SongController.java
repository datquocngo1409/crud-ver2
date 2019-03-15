package codegym.project.controller;

import codegym.project.model.Song;
import codegym.project.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class SongController {
    @Autowired
    public SongService songService;

    @RequestMapping(value = "/songs", method = RequestMethod.GET)
    public ResponseEntity<List<Song>> listAllSongs() {
        List<Song> accounts = songService.findAll();
        if (accounts.isEmpty()) {
            return new ResponseEntity<List<Song>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Song>>(accounts, HttpStatus.OK);
    }

    @RequestMapping(value = "/songs/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Song> getSongById(@PathVariable("id") long id) {
        System.out.println("Fetching Song with id " + id);
        Song song = songService.findById(id);
        if (song == null) {
            System.out.println("Song with id " + id + " not found");
            return new ResponseEntity<Song>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Song>(song, HttpStatus.OK);
    }

    @RequestMapping(value = "/songs", method = RequestMethod.POST)
    public ResponseEntity<Void> createSong(@RequestBody Song song, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Song " + song.getName());
        songService.save(song);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/songs/{id}").buildAndExpand(song.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/songs/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Song> updateSong(@PathVariable("id") long id, @RequestBody Song song) {
        System.out.println("Updating Song " + id);

        Song currentSong = songService.findById(id);

        if (currentSong == null) {
            System.out.println("Song with id " + id + " not found");
            return new ResponseEntity<Song>(HttpStatus.NOT_FOUND);
        }

        currentSong.setName(song.getName());
        currentSong.setDescription(song.getDescription());
        currentSong.setSinger_name(song.getSinger_name());
        currentSong.setImage(song.getImage());
        currentSong.setMp3_link(song.getMp3_link());
        currentSong.setId(song.getId());

        songService.save(currentSong);
        return new ResponseEntity<Song>(currentSong, HttpStatus.OK);
    }

    @RequestMapping(value = "/songs/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Song> deleteAdmin(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Song with id " + id);

        Song song = songService.findById(id);
        if (song == null) {
            System.out.println("Unable to delete. Song with id " + id + " not found");
            return new ResponseEntity<Song>(HttpStatus.NOT_FOUND);
        }

        songService.remove(id);
        return new ResponseEntity<Song>(HttpStatus.NO_CONTENT);
    }
}
