package com.example.bilyzna1.service.amazon;

//import com.amazonaws.HttpMethod;
//import com.amazonaws.services.s3.AmazonS3;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.Calendar;
//import java.util.Date;

//@Service
//public class ImageService {
//    @Autowired
//    private AmazonS3 s3;
//
//    @Value("${aws.s3.bucketName}")
//    private String bucketName;
//
//    public String generateUrl(String originalFileName, HttpMethod http){
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(new Date());
//        cal.add(Calendar.MINUTE,1);
//        URL url = s3.generatePresignedUrl(bucketName,originalFileName,cal.getTime(),http);
//        return url.toString();
//    }
//    public void generatePhotoUrl(MultipartFile file){
//        String link = generateUrl(file.getOriginalFilename(),HttpMethod.PUT);
//        try {
//            URL url = new URL(link);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("PUT");
//            conn.setDoOutput(true);
//            if (file.getName().endsWith(".jpg") || file.getName().endsWith(".jpeg")) {
//                conn.setRequestProperty("Content-Type", "image/jpeg");
//            } else if (file.getName().endsWith(".png")) {
//                conn.setRequestProperty("Content-Type", "image/png");
//            }
//
//            try (DataOutputStream dos = new DataOutputStream(conn.getOutputStream())) {
//                dos.write(file.getBytes());
//            }
//            int statusCode = conn.getResponseCode();
//            if (statusCode == HttpURLConnection.HTTP_OK) {
//                // File uploaded successfully
//                System.out.println("Picture uploaded successfully.");
//            } else {
//                // Error handling
//                System.err.println("Picture upload failed with status: " + statusCode);
//            }
//
//            conn.disconnect();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//}
