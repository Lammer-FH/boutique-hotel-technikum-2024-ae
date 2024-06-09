package com.example.boutiquehoteltechnikum.unit;

import com.example.boutiquehoteltechnikum.controllers.ImageController;
import com.example.boutiquehoteltechnikum.services.ImageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class ImageControllerUnitTests {

    @Mock
    private ImageService imageService;

    @InjectMocks
    private ImageController imageController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(imageController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void givenImage_whenGetImage_thenReturnByteArray() throws Exception {
        byte[] mockedResult = new byte[]{1, 2, 3};

        when(imageService.getImage("Image.jpg")).thenReturn(mockedResult);

        byte[] result = this.mockMvc.perform(get("/api/v1/images")
                    .param("filename", "Image.jpg"))
            .andExpect(status().isOk())
            .andReturn().getResponse().getContentAsByteArray();

        assertThat(result).isEqualTo(mockedResult);
    }
}
