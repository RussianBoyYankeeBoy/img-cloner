package com.Zh.photosclone.services;

import com.Zh.photosclone.models.Photo;
import com.Zh.photosclone.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {

    @Autowired
    PhotoRepository photoRepository;

    public Iterable<Photo> getAll(){
        return photoRepository.findAll();
    }

    public Photo getById(Integer id) {
        return photoRepository.findById(id).orElse(null);
    }

    public void removeById(Integer id) {
        photoRepository.deleteById(id);
    }

    public Photo save(String fileName, String contentType, byte[] data) {
        Photo photo = Photo.builder().name(fileName).arr(data).contentType(contentType).build();
        photoRepository.save(photo);
        return photo;
    }
}
