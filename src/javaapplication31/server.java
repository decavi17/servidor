
package javaapplication31;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class server {
    

    public static void main(String[] args) {
        //1.establecer el servidor
        ServerSocket Server;
        try {
            Server = new ServerSocket(8000);
            System.out.println("esperando conexiones");   
        //2. aceptar conexion
        Socket cliente = Server.accept();
        System.out.println("se conecto un cliente");
        //3.abrir IO
        InputStream flujoEntrada=cliente.getInputStream();
        OutputStream flujoSalida = cliente.getOutputStream();
       //usar depuradores para convertir bytes en texto
        BufferedReader entrada = new BufferedReader(new InputStreamReader(flujoEntrada));
        PrintWriter salida = new PrintWriter(flujoSalida,true);
        BufferedReader datosUsuario = new BufferedReader(new InputStreamReader(System.in));
        String mensaje = " ";
        String mensajeEnviar = " ";
        while(true){
            mensaje = entrada.readLine();
            System.out.println(mensaje);
            System.out.println("enviar: ");
            mensajeEnviar = datosUsuario.readLine();
            
            salida.println(mensaje);
        }
        } catch (IOException ex) {
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // entrada.close();
        // salida.close();
        /* para varios usuario crear una class clientes q implemente Runnableb
        Socket client;
        cliente(socket client){
        this.cliente=cliente
        }
        void run (){        
        }
        en servidor crear while(true){
        socket cliente servidor.accept
        }
        */
    }
    
}
