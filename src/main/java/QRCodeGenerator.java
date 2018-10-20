import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRCodeGenerator {
    private static final String QR_CODE_IMAGE_PATH = "/home/coder/Desktop/MyQRCode.png";

    private static void generateQRCodeImage(String text, int width, int height, String filePath)
            throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix,"PNG",path);
    }

    public static void main(String[] args) {
        try{
            generateQRCodeImage("www.coder.uz",350,350,QR_CODE_IMAGE_PATH);
        } catch (IOException e) {
            System.out.println("Could not generete QR CODE, IOException :: " +e.getMessage());
        } catch (WriterException e) {
            System.out.println("Could not generete QR CODE, WriterException :: " +e.getMessage());
        }
    }
}
