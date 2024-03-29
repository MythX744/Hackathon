package com.example.Project.Helper;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.awt.image.BufferedImage;

public class CodeGen {

    public static BufferedImage generateQRCodeImage(String barcodeText, int size) throws Exception {
        QRCodeWriter barcodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix =
                barcodeWriter.encode(barcodeText, BarcodeFormat.QR_CODE, size, size);

        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }
}
