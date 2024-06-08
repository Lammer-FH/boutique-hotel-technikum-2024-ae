package com.example.boutiquehoteltechnikum.services;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.io.InputStream;

@Service
public class ImageService {

    public byte[] getImage(String filename) {
        byte[] content;
        try {
            InputStream in = getClass().getResourceAsStream("/images/" + filename);
            content = IOUtils.toByteArray(in);
        } catch (IOException exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Bild konnte nicht geladen werden!");
        }
        return content;
    }
}
