

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Test {

	public static final int BUFFER_SIZE = 1024 * 50;
    private byte[] buffer;
    
    public Test() {
         buffer = new byte[BUFFER_SIZE];
    }

    public void startServer() throws Exception {
         ServerSocket socket = new ServerSocket(9000);
         Socket client = socket.accept();
         BufferedInputStream in = 
              new BufferedInputStream(
                   new FileInputStream("U:\\Myname"));

         BufferedOutputStream out = 
              new BufferedOutputStream(client.getOutputStream());
              
         
         int len = 0;
         while ((len = in.read(buffer)) > 0) {
              out.write(buffer, 0, len);
              System.out.print("#");
         }
         in.close();
         out.flush();
         out.close();
         client.close();
         socket.close();
         System.out.println("\nDone!");
    }

    public static void main(String[] args) throws Exception {
         Test test = new Test();
         test.startServer();
    }
		
}
