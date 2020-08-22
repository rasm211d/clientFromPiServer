import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {
    public static void main(String[] args) throws IOException {

//            Socket socket = new Socket("192.168.1.151", 12345);
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("192.168.1.151", 12346), 2000);
        InputStream inputStream = new DataInputStream(socket.getInputStream());

        byte[] input = inputStream.readAllBytes();
        String string = new String(input, StandardCharsets.UTF_8);
        String temp = string.substring(1, string.indexOf('H')).trim();
        String humid = string.substring(string.indexOf('H') + 1);
        Double temperature = Double.parseDouble(temp);
        Double humidity = Double.parseDouble(humid);


        System.out.println(temp);
        System.out.println(humid);
        System.out.println(temperature+humidity);

    }
}
