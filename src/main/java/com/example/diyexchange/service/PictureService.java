package com.example.diyexchange.service;

import com.example.diyexchange.entity.Picture;
import com.example.diyexchange.repository.PictureRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Transactional
public class PictureService {
    private final PictureRepository pictureRepository;

    public PictureService(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    public void savePicture(Picture picture) {
//    public void savePicture(MultipartFile file) throws IOException {
//        Picture picture = new Picture();
//        picture.setName(file.getOriginalFilename());
//        picture.setImageData(file.getBytes());
        pictureRepository.save(picture);
    }

    public byte[] getPictureData(Long id) throws IOException {
        Picture picture = pictureRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Picture not found"));
        return picture.getImageData();
    }
}
