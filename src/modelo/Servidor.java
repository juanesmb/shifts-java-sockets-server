package modelo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Servidor extends Conexion //Se hereda de conexión para hacer uso de los sockets y demás
{
    public Servidor() throws IOException{super("servidor");} //Se usa el constructor para servidor de Conexion

    public void startServer()//Método para iniciar el servidor
    {
        try
        {
            //esperando conexión
            cs = ss.accept(); //Accept comienza el socket y espera una conexión desde un cliente
            //Se obtiene el flujo de salida del cliente para enviarle mensajes
            salidaCliente = new DataOutputStream(cs.getOutputStream());

            //Se le envía un mensaje al cliente usando su flujo de salida
            //salidaCliente.writeUTF("Petición recibida y aceptada");
            recibirMensaje();
            /*//Se obtiene el flujo entrante desde el cliente
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cs.getInputStream()));

            */
        }catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
    
    public void recibirMensaje ()
    {
        try
        {
        //Se obtiene el flujo entrante desde el cliente
        BufferedReader entrada = new BufferedReader(new InputStreamReader(cs.getInputStream()));
        mensajeServidor = entrada.readLine();
        }catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
    
    
    
}