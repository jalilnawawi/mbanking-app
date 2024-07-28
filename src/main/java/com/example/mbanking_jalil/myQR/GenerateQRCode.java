package com.example.mbanking_jalil.myQR;

import com.example.mbanking_jalil.dto.qrCode.CreateQRCodeRequestDto;
import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GenerateQRCode {
    //function to create QR code
    public static void createQR(String data, String path,
                                String charset, Map hashMap,
                                int height, int width) throws WriterException, IOException
    {
        BitMatrix matrix = new MultiFormatWriter().encode(
                new String(data.getBytes(charset), charset),
                BarcodeFormat.QR_CODE, width, height
        );

        MatrixToImageWriter.writeToFile(
                matrix,
                path.substring(path.lastIndexOf('.') + 1),
                new File(path)
        );
    }

    //Driver code
    public static void main(String[] args) throws WriterException, IOException,
            NotFoundException
    {
        //data that contain in QR code
        String data = messageBuilder();

        //path where the image will get saved
        String path = "demo.png";

        //Encoding charset
        String charset = "UTF-8";

        Map<EncodeHintType, ErrorCorrectionLevel> map = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
        map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

        // Create the QR code and save
        // in the specified folder
        // as a jpg file
        createQR(data, path, charset, map, 200, 200);
        System.out.println("QR code generated!!!");
        System.out.println(messageBuilder());
    }

    public static String messageBuilder(){
        StringBuilder message = new StringBuilder();
//        message.append(createQRCodeRequestDto.getUserId());
//        message.append(createQRCodeRequestDto.getSenderAccountNum());
//        message.append(createQRCodeRequestDto.getRecipientAccountNum());
//        message.append(createQRCodeRequestDto.getBankCode());
//        message.append(createQRCodeRequestDto.getNominal());
        String delimiter = ".";
        message.append("1");
        message.append(delimiter);
        message.append("123456789");
        message.append(delimiter);
        message.append("987654321");
        message.append(delimiter);
        message.append("002");
        message.append(delimiter);
        message.append(10000);

//        return message.toString();
        String[] parts = {"1", "123456789", "987654321", "002", String.valueOf(10000)};
        return String.join(delimiter, parts);

    }
}
