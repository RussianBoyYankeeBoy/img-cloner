package com.Zh.photosclone.web.restControllers;

import com.Zh.photosclone.models.Photo;
import com.Zh.photosclone.services.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DownloadRestController {

    @Autowired
    PhotoService photoService;

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable Integer id) {
        Photo photo = photoService.getById(id);
        if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        byte [] data = photo.getArr();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.valueOf(photo.getContentType()));
        httpHeaders.setContentDisposition(
            ContentDisposition.builder("attachment").filename(photo.getName()).build()
        );

        return new ResponseEntity<>(data, httpHeaders, HttpStatus.OK);
    }
}
