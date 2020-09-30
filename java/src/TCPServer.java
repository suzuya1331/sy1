import java.io.InputStream;   import java.net.ServerSocket;   import java.net.Socket;

public class TCPServer {
  public static final void main(final String[] args) {
    ServerSocket server;           InputStream  is;
    Socket       client;

    try {
      server = new ServerSocket(9999);
      
      for (int j = 5; (--j) >= 0;) {  //procesar sólo 5 clientes, por lo que puedo mostrar (*@\serverBox{5)}@*) a continuación
        client = server.accept(); //esperar la conexión entrante (*@\serverBox{3)}@*)
        System.out.println("La nueva conexión de " + client.getRemoteSocketAddress());

        is     = client.getInputStream(); //obtener el flujo para leer de
        
        int var=(int) is.read();
        System.out.println(var);
        
        if(var<=10 &&var>=1)
        {
          for (int i =0; i< var;i++)
          {
            System.out.print("X");
          }
          System.out.println(" ");
        }
        client.close(); 
      }
      server.close();  
    } catch (Throwable t) {
      t.printStackTrace();
    }
  }
}
