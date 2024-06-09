package com.example.boutiquehoteltechnikum.functional;

import com.example.boutiquehoteltechnikum.controllers.ImageController;
import com.example.boutiquehoteltechnikum.repositories.RoomRepository;
import com.example.boutiquehoteltechnikum.services.ImageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration()
@SpringBootTest
public class ImageControllerIntegrationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    void givenImage_whenGetImage_thenReturnByteArray() throws Exception {
        byte[] mockedResult = null;
        try {
            InputStream in = getClass().getResourceAsStream("/images/NoImage.jpg");
            mockedResult = IOUtils.toByteArray(in);
        } catch (IOException exception) {
            fail(exception);
        }

        byte[] result = this.mockMvc.perform(get("/api/v1/images")
                .param("filename", "NoImage.jpg"))
            .andExpect(status().isOk())
            .andReturn().getResponse().getContentAsByteArray();

        assertThat(result).isEqualTo(mockedResult);
    }
}
