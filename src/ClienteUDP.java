import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClienteUDP {
    public static void main(String[] args) {

        try{
            int puerto=5000; //Número de puerto

            //Crear un socket UDP
            DatagramSocket socket = new DatagramSocket();

            //Direccion IP del servidor
            InetAddress direccionIP_servidor=InetAddress.getByName("172.31.118.83");

            //mensaje a enviar
            String mensaje = "Hola,soy el cliente";

            // Arreglos de bytes para enviar los datos
            byte[] bufferSalida = mensaje.getBytes();

            // Crear paquete para enviar datos
            DatagramPacket paquete_enviar = new DatagramPacket(bufferSalida,0, bufferSalida.length,direccionIP_servidor,puerto);

            //Enviar paquete
            socket.send(paquete_enviar);

            // Arreglos de bytes para recibir los datos
            byte[] bufferEntrada = new byte[1024];

            // // Crear paquete para recibir datos
            DatagramPacket paquete_recibir = new DatagramPacket(bufferEntrada,0, bufferEntrada.length);

            //Recibir paquete
            socket.receive(paquete_recibir);

            //Extraer la informacion del paquete recibido
            String mensajeRecibido = new String(paquete_recibir.getData());
            System.out.println("Mensaje recibido: "+mensajeRecibido);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
