package codegym.project.service;

import codegym.project.model.Song;

import java.util.List;

public interface SongService {
    List<Song> findAll();

    Song findById(Long id);

    void save(Song song);

    void remove(Long id);
}
