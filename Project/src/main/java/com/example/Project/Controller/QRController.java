package com.example.Project.Controller;

import com.example.Project.Helper.CodeGen;
import java.awt.image.BufferedImage;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/barcodes")
public class QRController {
    @GetMapping(value = "/ean13/{campaignId}&{size}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> zebraEAN13Barcode(String campaignId,int size)
            throws Exception {

        String campaignLink = "https://localhost:8080/" + campaignId;
        return okResponse(CodeGen.generateQRCodeImage(campaignLink, size));
    }

    @Bean
    public HttpMessageConverter<BufferedImage> createImageHttpMessageConverter() {
        return new BufferedImageHttpMessageConverter();
    }

    private String getHomeUrl(HttpServletRequest request) {
        return String.format("%s://%s:%d",request.getScheme(),  request.getServerName(), request.getServerPort());
    }
    private <T> ResponseEntity<T> okResponse(T body) {
        return new ResponseEntity<>(body, HttpStatus.OK);
    }
}
