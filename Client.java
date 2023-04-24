package Deploy;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
public static void main(String[] args) {
Scanner scan = new Scanner(System.in);
try{
  // Create a socket to connect to the server
  Socket s=new Socket("localhost",8888);
  // Socket socket = new Socket ("92.168.86.34", 8888);
  // Socket socket = new Socket ("mehran.sarwar.edu", 8888);
DataInputStream dis=new DataInputStream(s.getInputStream());
DataOutputStream dout=new DataOutputStream(s.getOutputStream());

// TAKING USER INPUT
System.out.print("\nEnter a Number : ");
int num = scan.nextInt();
// WRITING INTEGER TO SERVER
dout.writeInt(num);
String ans = (String)dis.readUTF();
System.out.println("\nNumber "+num+
" Is Prime Number: "+ans);
dout.flush();
dout.close();
s.close();
}
catch(Exception e){
System.out.println(e);
}
scan.close();
}
}



