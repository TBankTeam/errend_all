package com.example.utils;
import com.example.common.Result;
import com.example.controller.FileController;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;


import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ImageFileUtils {

    // 生成二维码图片
    // text：二维码内容
    // size: 二维码尺寸
    public static BufferedImage generateQRCode(String text, int size) {
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        try {
            QRCodeWriter writer = new QRCodeWriter();
            BitMatrix bitMatrix = writer.encode(text, BarcodeFormat.QR_CODE, size, size, hints);
            int width = bitMatrix.getWidth();
            int height = bitMatrix.getHeight();
            BufferedImage qrImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics = qrImage.createGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, size, size);
            graphics.setColor(Color.BLACK);

            for (int x = 0; x < size; x++) {
                for (int y = 0; y < size; y++) {
                    if (bitMatrix.get(x, y)) {
                        graphics.fillRect(x, y, 1, 1);
                    }
                }
            }

            // 渲染二维码
            Graphics2D graphics1 = qrImage.createGraphics();
            // 添加蓝色边框
            int borderSize = 3; // 边框大小
            Color myColor = new Color(99, 141, 204); // 红色
            graphics1.setColor(myColor);
            graphics1.fillRect(0, 0, size, borderSize); // 上边框
            graphics1.fillRect(0, 0, borderSize, size); // 左边框
            graphics1.fillRect(size - borderSize, 0, borderSize, size); // 右边框
            graphics1.fillRect(0, size - borderSize, size, borderSize); // 下边框

            return qrImage;
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }


    // 在图片上添加图片
    public static void addImageToImage(BufferedImage baseImage, BufferedImage overlayImage, int x, int y) {
        Graphics2D g2d = baseImage.createGraphics();
        g2d.drawImage(overlayImage, x, y, null);
        g2d.dispose();
    }

    // 在图片上添加文本，支持手动换行，文本水平居中
    public static void addTextToImage(BufferedImage baseImage, String text, Font font, Color color, int maxWidth, int y) {
        Graphics2D g2d = baseImage.createGraphics();
        g2d.setFont(font);
        g2d.setColor(color);

        FontMetrics fm = g2d.getFontMetrics();
        int lineHeight = fm.getHeight();
        int currentY = y;
        String[] lines = text.split("\n");

        for (String line : lines) {
            int lineWidth = fm.stringWidth(line);
            int lineX = maxWidth; // 居中
            g2d.drawString(line, lineX, currentY);
            currentY += lineHeight;
        }

        g2d.dispose();
    }

    public static String getimage(String code) throws IOException {
        // 1. 读取原始图片
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("files/bg.png")); // 替换成您的图片路径
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (image == null) {
            System.err.println("无法读取图片");
            return null;
        }
        // 2. 在图片上添加透明的二维码
        String qrText = "感谢您对TBank时间银行的支持"; // 替换成您的二维码文本
        int qrSize = 100; // 二维码尺寸
        BufferedImage qrCodeImage = generateQRCode(qrText, qrSize);
        int qrX = (image.getWidth() - qrSize) * 5 / 6;
        int qrY = 660; // 设置二维码的垂直位置
        addImageToImage(image, qrCodeImage, qrX, qrY);

        // 3. 在图片上添加中文文本，支持手动换行
        String chineseText = "    感谢您对TBank时间银行的支持\n" +
                "传递正能量，有爱就有希望！";
        Font font = new Font("微软雅黑", Font.PLAIN, 30); // 替换成所需的字体和大小
        Color textColor = Color.BLACK; // 文本颜色
        int textX = 70; // 文本左侧的边距
        int textY = 200; // 设置文本的垂直位置
        int textWidth = image.getWidth() - 40; // 文本可用的宽度
        addTextToImage(image, chineseText, font, textColor, textX, textY);

        chineseText = "证书编号：" + code;
        textX = 70; // 文本左侧的边距
        textY = 780; // 设置文本的垂直位置
        font = new Font("微软雅黑", Font.PLAIN, 11);
        addTextToImage(image, chineseText, font, textColor, textX, textY);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        byte[] bytes = baos.toByteArray();

        MockMultipartFile multipartFile = new MockMultipartFile(
                "file",           // 文件参数名
                code + ".png",         // 文件名
                "image/png",      // 文件类型
                new ByteArrayInputStream(bytes) // 文件内容
        );

        FileController fileController = new FileController();
        Result res = fileController.upload(multipartFile);

        return (String) res.getData();

        // 4. 保存带有二维码和文本的图片
//        try {
//            ImageIO.write(image, "png", new File("C:\\Users\\86131\\Desktop\\图片素材\\output.jpg")); // 替换成保存的文件路径
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

}
