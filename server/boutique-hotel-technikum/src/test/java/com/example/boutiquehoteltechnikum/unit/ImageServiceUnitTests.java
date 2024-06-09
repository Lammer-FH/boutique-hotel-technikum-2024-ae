package com.example.boutiquehoteltechnikum.unit;

import com.example.boutiquehoteltechnikum.services.ImageService;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ImageServiceUnitTests {

    @InjectMocks
    private ImageService imageService;

    @Test
    void givenImage_whenGetImage_thenReturnByteArray() {
        byte[] mockedResult = null;
        try {
            InputStream in = getClass().getResourceAsStream("/images/NoImage.jpg");
            mockedResult = IOUtils.toByteArray(in);
        } catch (IOException exception) {
            fail(exception);
        }

        byte[] result = imageService.getImage("NoImage.jpg");

        assertThat(result).isEqualTo(mockedResult);
    }

    @Test
    void givenWrongFilename_whenGetImage_thenReturnError() {
        Exception exception = assertThrows(ResponseStatusException.class, () -> imageService.getImage("UnkownImage.jpg"));
        assertTrue(exception.getMessage().contains(HttpStatus.INTERNAL_SERVER_ERROR.toString()));
        assertTrue(exception.getMessage().contains("Bild konnte nicht geladen werden!"));
    }
}
