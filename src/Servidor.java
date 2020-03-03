import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {

        String mensagemCliente;
        String maiuscula;
        int porta = 55660;

        System.out.println(" * Servido Iniciado *");
        System.out.println(" - Endereço: 127.0.0.1:"+porta);
        System.out.println("-------------------------------");

        try {
            // Cria um SocketServer para iniciar o servidor
            ServerSocket socket = new ServerSocket(porta);

            while(true) {
                Socket connectionSocket = socket.accept();

                // Cria uma buffer que irá armazenar as informações recebidas e uma streamer de retorno para o cliente
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

                // Faz a leitura das informações enviadas pelo cliente as amazenam na variável "mensagemCliente"
                mensagemCliente = inFromClient.readLine();
                maiuscula = mensagemCliente.toUpperCase() + "\n";

                // Mostra o que foi recebido
                System.out.println("Mensagem Recebida:");
                System.out.println(maiuscula);

                // Retorna as informações modificadas, ao cliente
                outToClient.writeBytes(maiuscula);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}