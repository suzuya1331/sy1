import java.io.OutputStream;  import java.net.InetAddress;  import java.net.Socket; import java.util.*;


public class TCPClient {

  public static final void main(final String[] args) {
    Socket        client;
    OutputStream  os;
    InetAddress   ia;
    Scanner sc=new Scanner(System.in);


    try {
      ia = InetAddress.getByName("localhost");// el direccion de ip 
      
      client = new Socket(ia, 9999); // crear un socket para abrir el port tcp/9999




      os = client.getOutputStream(); //conseguir que la corriente escriba 

        int number=0;
      while (number>=11 || number<=0)
      {  System.out.println(" Ingrese un numero 1 al 10.");
           number = sc.nextInt();

          os = client.getOutputStream(); //conseguir que la corriente escriba 
      }
      os.write(number);
      
      client.close(); 
    } catch (Throwable t) {
      t.printStackTrace();
    }
  }
}
