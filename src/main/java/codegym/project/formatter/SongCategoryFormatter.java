package codegym.project.formatter;

import codegym.project.model.SongCategory;
import codegym.project.service.SongCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class SongCategoryFormatter implements Formatter<SongCategory> {

    private SongCategoryService songCategoryService;

    @Autowired
    public SongCategoryFormatter(SongCategoryService songCategoryService) {
        this.songCategoryService = songCategoryService;
    }

    @Override
    public SongCategory parse(String text, Locale locale) throws ParseException {
        return songCategoryService.findById(Long.parseLong(text));
    }

    @Override
    public String print(SongCategory object, Locale locale) {
        return null;
    }
}
