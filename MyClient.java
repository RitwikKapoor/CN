import java.io.*;
import java.net.*;
import java.util.Scanner;
public class MyClient {
        public static void main(String[] args) {
                try{
                        Socket s = new Socket("localhost",6666);
                        DataInputStream din = new DataInputStream(s.getInputStream());
                        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                        Scanner sc = new Scanner(System.in);
                        String str="",str2="";
                        while(!str.equals("stop")){
                                str = sc.nextLine();
                                dout.writeUTF(str);
                                dout.flush();
                                str2 = din.readUTF();
                                System.out.println("Server says: "+str2);
                        }
                        dout.close();
                        s.close();
                }catch(Exception e){
                        System.out.println(e);
                }
        }
}
