import java.io.*;
import java.net.Socket;
import java.awt.image.BufferedImage;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class Client {
    public static void main(String args[]) throws Exception {
        Socket soc;
        BufferedImage img = null;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the image file path: ");
        String imagePath = scanner.nextLine();

        soc = new Socket("localhost", 4000);
        System.out.println("Client is running.");

        try {
            System.out.println("Reading image from disk.");
            img = ImageIO.read(new File(imagePath));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(img, "jpg", baos);
            baos.flush();
            byte[] bytes = baos.toByteArray();
            baos.close();

            System.out.println("Sending image to server.");
            OutputStream out = soc.getOutputStream();
            DataOutputStream dos = new DataOutputStream(out);
            dos.writeInt(bytes.length);
            dos.write(bytes, 0, bytes.length);
            System.out.println("Image sent to server.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        soc.close();
        scanner.close();
    }
}
