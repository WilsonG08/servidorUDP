import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class HiloCliente extends Thread{
    private DatagramSocket socket;
    private DatagramPacket paquete;

    // Constructor
    public HiloCliente(DatagramSocket socket, DatagramPacket paquete){
        this.socket=socket;
        this.paquete=paquete;
    }

    public void run(){

        //Extraer la informacion del paquete recibido
        String mensajeRecibido = new String(paquete.getData());
        System.out.println("Mensaje recibido: "+mensajeRecibido);

        // Obtener la direccion del cliente
        InetAddress direccionIP_cliente= paquete.getAddress();
        int puerto_cliente = paquete.getPort();

        //Mensaje de respuesta
        String respuesta = "Hola, soy el servidor";

        // Arreglos de bytes para enviar los datos
        byte[] bufferSalida = respuesta.getBytes();

        //Crear paquete para enviar datos
        DatagramPacket paquete_respuesta = new DatagramPacket(bufferSalida,0, bufferSalida.length,direccionIP_cliente,puerto_cliente);

        //Enviar Datgrama
        try {
            socket.send(paquete_respuesta);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }





    }
}
