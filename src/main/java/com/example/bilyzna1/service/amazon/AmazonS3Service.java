package com.example.bilyzna1.service.amazon;

//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.model.ObjectMetadata;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.util.UUID;

//@Service
//public class AmazonS3Service {
//
//    private final AmazonS3 amazonS3;
//    private final String bucketName;
//
//    @Autowired
//    public AmazonS3Service(AmazonS3 amazonS3, @Value("${aws.s3.bucketName}") String bucketName) {
//        this.amazonS3 = amazonS3;
//        this.bucketName = bucketName;
//    }
//
//    public String uploadFile(MultipartFile file) {
//        try {
//            String filename = file.getOriginalFilename();
//            ObjectMetadata metadata = new ObjectMetadata();
//            metadata.setContentType(file.getContentType());
//
//            amazonS3.putObject(bucketName, filename, file.getInputStream(), metadata);
//
//            // Generate the S3 URL
//            return amazonS3.getUrl(bucketName, filename).toString();
//        } catch (IOException e) {
//            throw new RuntimeException("Failed to upload file to S3", e);
//        }
//    }
//}

