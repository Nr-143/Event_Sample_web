import java.io.*;
import java.util.*;
import java.net.*;

class server{
public static void main(String args[])
{
   String user_name="test",user="";
   String password="test",password2;
try{
     ServerSocket ssocket=new ServerSocket(3000);
   Socket socket=ssocket.accept();
     DataInputStream din=new DataInputStream(socket.getInputStream());
     DataOutputStream dout=new DataOutputStream(socket.getOutputStream());
     dout.writeUTF("Server connected");
     dout.flush();
   String msg1=(String)din.readUTF();
   System.out.println(msg1);
   user=(String)din.readUTF();
    password2=din.readUTF();
if(user.equals(user_name) && password.equals(password2))
{
    System.out.println("User_name: "+user);
     System.out.println("Password: "+password2);
    dout.writeUTF("ok");
}
else{
    dout.writeUTF("no");
}

   dout.close();
   din.close();
}catch(Exception s){}
}
}