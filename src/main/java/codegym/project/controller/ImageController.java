package codegym.project.controller;

import codegym.project.model.Image;
import codegym.project.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Controller
public class ImageController {
    private static final String BASE_PATH = "/images";
    private static final String FILENAME = "{filename:.+}";

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "/images",method = RequestMethod.GET)
    public ResponseEntity<List<Image>> listAllGroup(Pageable pageable){
        List<Image> groups = imageService.findAll();
        if (groups.isEmpty()){
            return new ResponseEntity<List<Image>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Image>>(groups, HttpStatus.OK);
    }

    @RequestMapping(value = "/images",method = RequestMethod.POST)
    public ResponseEntity<?> createStaff(@RequestParam(name = "file") MultipartFile file, HttpServletRequest servletRequest) throws URISyntaxException {
        try{
            imageService.create(file);
            URI locationUri = new URI(servletRequest.getRequestURI().toString() + "/")
                    .resolve(file.getOriginalFilename() + "/raw");
            return ResponseEntity.created(locationUri)
                    .body("success upload");
        } catch (IOException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("fail" + "=>" + e.getMessage());
        }
    }

    @GetMapping("/images/{name:.+}/raw")
    public ResponseEntity<?> oneRawImage (@PathVariable String name){
        try {
            Resource file = imageService.findOneImage(name);
            return ResponseEntity.ok().
                    contentLength(file.contentLength()).
                    contentType(MediaType.IMAGE_JPEG).
                    body(new InputStreamResource(file.getInputStream()));
        } catch (IOException e){
            return ResponseEntity.badRequest().body("couldn't find");
        }
    }
}
