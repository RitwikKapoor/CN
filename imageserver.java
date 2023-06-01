import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JFrame;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = null;
        Socket socket;

        server = new ServerSocket(4000);
        System.out.println("Server waiting for image.");

        socket = server.accept();
        System.out.println("Client connected.");

        InputStream in = socket.getInputStream();
        DataInputStream dis = new DataInputStream(in);
        int len = dis.readInt();

        byte[] data = new byte[len];
        dis.readFully(data);
        dis.close();
        in.close();

        ByteArrayInputStream ian = new ByteArrayInputStream(data);
        BufferedImage bImage = ImageIO.read(ian);

        JFrame f = new JFrame("Server");
        ImageIcon icon = new ImageIcon(bImage);

        // Display the image in a frame
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(new JLabel(icon));
        f.pack();
        f.setVisible(true);

        server.close();
    }
}
