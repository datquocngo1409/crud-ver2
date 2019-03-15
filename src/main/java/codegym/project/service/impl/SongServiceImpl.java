package codegym.project.service.impl;

import codegym.project.model.Song;
import codegym.project.repository.SongRepository;
import codegym.project.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//Đọc comment ở File Service.
public class SongServiceImpl implements SongService {

    @Autowired
    private SongRepository songRepository;

    @Override
    public List<Song> findAll() {
        return (List<Song>) songRepository.findAll();
    }

    @Override
    public Song findById(Long id) {
        return songRepository.findById(id).get();
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public void remove(Long id) {
        songRepository.deleteById(id);
    }
}
