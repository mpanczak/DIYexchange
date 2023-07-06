package com.example.diyexchange.controller;

import com.example.diyexchange.entity.Picture;
import com.example.diyexchange.service.PictureService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/pictures")
public class PictureController {
    private final PictureService pictureService;

    public PictureController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

//    @PostMapping
//    public ResponseEntity<String> uploadPicture(@RequestParam("file") MultipartFile file) {
//        try {
//            pictureService.savePicture(file);
//            return ResponseEntity.ok("Picture uploaded successfully.");
//        } catch (IOException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload picture.");
//        }
//    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getPicture(@PathVariable("id") Long id) {
        try {
            byte[] imageData = pictureService.getPictureData(id);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            return ResponseEntity.ok().headers(headers).body(imageData);
        } catch (IOException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/upload")
    public String showUploadForm(Model model) {
        model.addAttribute("isLoggedIn", true);
        return "upload";
    }

    @PostMapping("/upload")
    public String uploadPicture(@RequestParam("file") MultipartFile file) {
        try {
            Picture picture = new Picture();
            picture.setName(file.getOriginalFilename());
            picture.setImageData(file.getBytes());
            pictureService.savePicture(picture);

//            pictureService.savePicture(file);
//            return "redirect:/upload-success"; // TODO Redirect to a success page after successful upload
            return "redirect:/pictures/upload";
        } catch (IOException e) {
            return "redirect:/upload-failed"; // TODO Redirect to a error handling page
        }

    }
}