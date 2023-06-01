 import java.io.IOException;
 import java.net.Socket;
 import java.time.LocalDate;
 import java.time.LocalTime;
 
 public class dataclient {
     public static void main(String[] args) {
         String serverAddress = "localhost";
         int serverPort = 1234;
 
         try {
             // Connect to the server
             Socket socket = new Socket(serverAddress, serverPort);
 
             // Display the system date and time on the client side
             LocalDate currentDate = LocalDate.now();
             LocalTime currentTime = LocalTime.now();
             System.out.println("System Date on the Client: " + currentDate);
             System.out.println("System Time on the Client: " + currentTime);
 
             // Close the socket
             socket.close();
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
 }
