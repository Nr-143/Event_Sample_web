import java.io.*;
import java.util.*;
import java.net.*;

class client{
public static void main(String args[])
{     
           String user_name="";
            String password ;
  try{
     Socket socket=new Socket("localhost",3000);
     DataInputStream din=new DataInputStream(socket.getInputStream());
     DataOutputStream dout=new DataOutputStream(socket.getOutputStream());
    Scanner get=new Scanner(System.in);
     dout.writeUTF("Client connected");
     dout.flush();
  String msg1=(String)din.readUTF();
 System.out.println(msg1);
System.out.println(); 
System.out.print("Enter username:");
user_name=get.nextLine();
dout.writeUTF(user_name);
System.out.print("\n Enter password:");
password=get.nextLine();
dout.writeUTF(password);
String valid=(String)din.readUTF();
if(valid.equals("ok"))
{
  System.out.println("Connection Established");   
}
else{
  System.out.println("Invalid user or password");
}
   dout.close();
   din.close();
}catch(Exception s){}
}
}