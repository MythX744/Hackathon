package com.example.Project.Controller;

import com.example.Project.Helper.CodeGen;
import java.awt.image.BufferedImage;

import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/barcodes")
public class QRController {
    @GetMapping(value = "/ean13/{campaignId}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> zebraEAN13Barcode(String campaignId, int size)
            throws Exception {
        return okResponse(CodeGen.generateQRCodeImage(campaignId, size));
    }

    @Bean
    public HttpMessageConverter<BufferedImage> createImageHttpMessageConverter() {
        return new BufferedImageHttpMessageConverter();
    }

    private <T> ResponseEntity<T> okResponse(T body) {
        return new ResponseEntity<>(body, HttpStatus.OK);
    }
}
