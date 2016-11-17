/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication31;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Estudiante
 */
public class cliente {
    public static void main(String[]args){
        
        //1.establecer la comunicacion con el sevidor
        Socket cliente;
        try {
            cliente = new Socket("localhost",8000);
            //2.abrir IO
        InputStream flujoEntrada=cliente.getInputStream();
        OutputStream flujoSalida = cliente.getOutputStream();
       //usar depuradores para convertir bytes en texto
        BufferedReader entrada = new BufferedReader(new InputStreamReader(flujoEntrada));
        BufferedReader datosUsuario = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter salida = new PrintWriter(flujoSalida,true);
       
        String mensajeAEnviar = " ";
        String mensajeRecibir=" ";
        while(true){
            System.out.println("Enviar: ");
            mensajeAEnviar = datosUsuario.readLine();
            salida.println(mensajeAEnviar);
            mensajeRecibir = entrada.readLine();
            System.out.println(mensajeRecibir);
        }
        
        // entrada.close();
        // salida.close();
        } catch (IOException ex) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
                
    }
    
}
