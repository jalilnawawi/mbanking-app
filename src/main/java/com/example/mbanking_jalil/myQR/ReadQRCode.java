package com.example.mbanking_jalil.myQR;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.ImageReader;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class ReadQRCode {
    //Function to read QR Code
    public static String readQR(String path, String charset, Map hashMap)
            throws FileNotFoundException, IOException,
            NotFoundException
    {
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
                new BufferedImageLuminanceSource(ImageIO.read(
                        new FileInputStream(path)
                ))
        ));

        Result result = new MultiFormatReader().decode(binaryBitmap);

        return result.getText();
    }

    public static void main(String[] args) throws WriterException, IOException,
            NotFoundException
    {
        //image location
        String filePath = "C:\\Users\\USER\\Documents\\mbanking-jalil\\demo.png";

        String charset = "UTF-8";

        Map<EncodeHintType, ErrorCorrectionLevel> map = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
        map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

        System.out.println("QR Code output " + readQR(filePath, charset, map));
    }
}
