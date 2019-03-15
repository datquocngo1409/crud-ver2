package codegym.project.formatter;

import codegym.project.model.Image;
import codegym.project.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class ImageFormatter implements Formatter<Image> {

    private ImageService imageService;

    @Autowired
    public ImageFormatter(ImageService imageService) {
        this.imageService = imageService;
    }

    @Override
    public Image parse(String text, Locale locale) throws ParseException {
        return imageService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Image object, Locale locale) {
        return null;
    }
}
