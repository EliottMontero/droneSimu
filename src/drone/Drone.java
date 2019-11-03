import java.net.*;
import java.io.*;

public class Drone {

  private int x, y, z;

  public Drone(int x, int y, int z){
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public int getX(){
    return this.x;
  }

  public int getY(){
    return this.y;
  }

  public int getZ(){
    return this.z;
  }

  public void move(int x, int y, int z){
    this.x += x;
    this.y += y;
    this.z += z;
  }


  public static void main(String[] args){
	  Drone drone = new Drone(0,0,0);

	  if (args.length < 2) return;

      String hostname = args[0];
      int port = Integer.parseInt(args[1]);

      try (Socket socket = new Socket(hostname, port)) {

          InputStream input = socket.getInputStream();
          BufferedReader reader = new BufferedReader(new InputStreamReader(input));

          String time = reader.readLine();

          System.out.println(time);


      } catch (UnknownHostException ex) {

          System.out.println("Server not found: " + ex.getMessage());

      } catch (IOException ex) {

          System.out.println("I/O error: " + ex.getMessage());
      }
  }
}
