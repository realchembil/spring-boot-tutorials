package com.ashcorp.ssc.photosclone.com.ashcorp.ssc.photosclone.web;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.ashcorp.ssc.photosclone.com.ashcorp.ssc.photosclone.model.Photo;
import com.ashcorp.ssc.photosclone.com.ashcorp.ssc.photosclone.service.PhotoService;

@RestController
public class PhotosController {
	
	private final PhotoService photoService;
	
	//private List<Photo> db = Stream.of(new Photo("1","hello.jpg")).collect(Collectors.toList());
	/*
	 * private Map<String, Photo> db = new HashMap<String, Photo>() {{ put("1",new
	 * Photo("1","hello.jpg")); put("2",new Photo("1","world.jpg")); }};
	 */

	@GetMapping("/")
	public String hello() {
		
		return "Hello World";
	}
	
	@GetMapping("/photos")
	public Iterable<Photo> get() {
		
		return photoService.get();
	}
	
	@GetMapping("/photos/{id}")
	public Photo get(@PathVariable Integer id) {
		Photo photo = photoService.get(id);
		if(photo==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return photo;
	}
	
	@DeleteMapping("/photos/{id}")
	public void delete(@PathVariable Integer id) {
		photoService.remove(id);
	}
	
	
	 @PostMapping("/photos")
	    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
	        return photoService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
	    }

	 public PhotosController(PhotoService photoService) {
	        this.photoService = photoService;
	    }

	
}
