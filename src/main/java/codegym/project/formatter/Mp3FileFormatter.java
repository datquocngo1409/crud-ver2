package codegym.project.formatter;

import codegym.project.model.Mp3File;
import codegym.project.service.Mp3FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class Mp3FileFormatter implements Formatter<Mp3File> {

    private Mp3FileService mp3FileService;

    @Autowired
    public Mp3FileFormatter(Mp3FileService mp3FileService) {
        this.mp3FileService = mp3FileService;
    }

    @Override
    public Mp3File parse(String text, Locale locale) throws ParseException {
        return mp3FileService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Mp3File object, Locale locale) {
        return null;
    }
}
