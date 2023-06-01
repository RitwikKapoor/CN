import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MyServer {
        public static void main(String[] args){
                try{
                        ServerSocket ss = new ServerSocket(6666);
                        Socket s = ss.accept();
                        DataInputStream din = new DataInputStream(s.getInputStream());
                        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
                        Scanner sc = new Scanner(System.in);
                        String str="",str2="";
                        while(!str.equals("stop")){
                                str=din.readUTF();
                                System.out.println("client says: "+str);
                                str2=sc.nextLine();
                                dout.writeUTF(str2);
                                dout.flush();
                        }
                        din.close();
                        s.close();
                        ss.close();
                }catch(Exception e){
                        System.out.println(e);
                }
        }
}
