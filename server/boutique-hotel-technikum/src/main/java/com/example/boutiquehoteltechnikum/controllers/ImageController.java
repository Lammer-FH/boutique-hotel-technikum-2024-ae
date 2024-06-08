package com.example.boutiquehoteltechnikum.controllers;

import com.example.boutiquehoteltechnikum.services.ImageService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping("")
    public byte[] getImage(@PathParam("filename") String filename) {
       return imageService.getImage(filename);
    }
}
