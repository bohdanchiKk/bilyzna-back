package com.example.bilyzna1.controller;

//import com.example.bilyzna1.entity.Image;
//import com.example.bilyzna1.repository.ImageRepository;
//import com.example.bilyzna1.service.AmazonS3Service;
//import com.example.bilyzna1.service.ImageService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//@RestController
//@RequiredArgsConstructor
//public class ImageController {
//    @Autowired
//    private ImageService imageService;
//    @Autowired
//    private ImageRepository imageRepository;
//    @Autowired
//    private AmazonS3Service amazonS3Service;
//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadFile(@RequestParam("image") MultipartFile image1,@RequestParam("name") String name) {
//        try {
//            String s3Link = amazonS3Service.uploadFile(image1);
//            // Save the S3 link in the database
//            // Your database code here
//            Image image = new Image();
//            image.setName(name);
//            image.setLink(s3Link);
//            imageRepository.save(image);
//            return ResponseEntity.ok("File uploaded successfully. S3 link: " + s3Link);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading the file.");
//        }
//
//    }
//}
