package com.ashcorp.ssc.photosclone.com.ashcorp.ssc.photosclone.service;

import org.springframework.stereotype.Service;

import com.ashcorp.ssc.photosclone.com.ashcorp.ssc.photosclone.model.Photo;
import com.ashcorp.ssc.photosclone.com.ashcorp.ssc.photosclone.repository.PhotoRepository;

@Service
public class PhotoService {
	

	public PhotoService(PhotoRepository photosRepository) {

		this.photosRepository = photosRepository;
	}

	private final PhotoRepository photosRepository;

   

    public Iterable<Photo> get() {
        return photosRepository.findAll();
    }

    public Photo get(Integer id) {
        return photosRepository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
        photosRepository.deleteById(id);
    }

    public Photo save(String fileName, String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setContentType(contentType);
        photo.setFileName(fileName);
        photo.setData(data);
        photosRepository.save(photo);
        return photo;
    }
}
