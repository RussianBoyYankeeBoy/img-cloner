package com.Zh.photosclone.web.restControllers;

import com.Zh.photosclone.models.Photo;
import com.Zh.photosclone.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import java.io.IOException;


@RestController
public class PhotoRestController {

    @Autowired
    PhotoService photoService;

    @GetMapping("/photos")
    public Iterable<Photo> getPhotos(){
        return photoService.getAll();
    }

    @GetMapping("/photos/{id}")
    public Photo getPhoto(@PathVariable Integer id) {
        Photo photo = photoService.getById(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photos/{id}")
    public void deletePhoto(@PathVariable Integer id) {
        photoService.removeById(id);
    }

    @PostMapping("/photos")
    public Photo createPhoto(@RequestPart("data") MultipartFile file) throws IOException {
        return photoService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
    }
}
