import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
    public static void main(String[] args) {

        String textoenviado;
        String textorecebido;
        int porta = 55660;

        do {
            try {
                System.out.printf("Digite sua mensagem: ");

                // Socket com o ip e a porta do servidor
                Socket client = new Socket("localhost", porta);

                // Cria o buffer para receber a entrada do teclado
                BufferedReader inFromUSer = new BufferedReader(new InputStreamReader(System.in));

                // Cria um stream de saída e o buffer de informações do servidor
                DataOutputStream outToServer = new DataOutputStream(client.getOutputStream());
                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));

                // Atribui para a variavel, envia para a streamer de saida e atribui para o textomodificad
                textoenviado = inFromUSer.readLine();
                outToServer.writeBytes(textoenviado + "\n");
                textorecebido = inFromServer.readLine();

                System.out.println("Mensagem recebida do Servidor: " + textorecebido);

//                if (textoenviado.equals(textorecebido)){
//                    System.out.println("Mensagem Recebida com Sucesso");
//                }

                client.close();

            } catch (IOException e) {
                System.out.println("Erro");
                break;
            }
        } while (true);
    }
}