import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class pingtrace {
    public static void main(String[] args) {
        String host = "example.com";
        int timeout = 5000; // 5 seconds

        // Simulate Ping
        try {
            InetAddress inetAddress = InetAddress.getByName(host);
            System.out.println("Pinging " + host + " [" + inetAddress.getHostAddress() + "]");

            // Try to establish a TCP connection
            Socket socket = new Socket(inetAddress, 80);
            socket.setSoTimeout(timeout);

            System.out.println("Ping successful!");
            socket.close();
        } catch (IOException e) {
            System.out.println("Ping failed!");
            e.printStackTrace();
        }

        System.out.println("-----------------------");

        // Simulate Trace-route
        try {
            InetAddress inetAddress = InetAddress.getByName(host);
            System.out.println("Tracing route to " + host + " [" + inetAddress.getHostAddress() + "]");

            for (int i = 1; i <= 3; i++) {
                System.out.println("Hop " + i + ": " + inetAddress.getHostAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
