package codegym.project.controller;

import codegym.project.model.SongCategory;
import codegym.project.service.SongCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class SongCategoryController {

    @Autowired
    private SongCategoryService songCategoryService;

    @RequestMapping(value = "/songs/categories", method = RequestMethod.GET)
    public ResponseEntity<List<SongCategory>> listAllSongCategories() {
        List<SongCategory> accounts = songCategoryService.findAll();
        if (accounts.isEmpty()) {
            return new ResponseEntity<List<SongCategory>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<SongCategory>>(accounts, HttpStatus.OK);
    }

    @RequestMapping(value = "/songs/categories/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SongCategory> getSongById(@PathVariable("id") long id) {
        System.out.println("Fetching Song Category with id " + id);
        SongCategory songCategory = songCategoryService.findById(id);
        if (songCategory == null) {
            System.out.println("Song Category with id " + id + " not found");
            return new ResponseEntity<SongCategory>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<SongCategory>(songCategory, HttpStatus.OK);
    }
}
