package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Cliente;

public class TesteSerializacaoCliente {
    
    public static void main(final String[] args) throws IOException, ClassNotFoundException {
        WriteToBinFile(novoCliente());
        
        final Cliente clienteNovo = ReadFromBinFile();

        System.out.println(clienteNovo.toString());
    }

    private static Cliente novoCliente() {
        final Cliente cliente = new Cliente();
        cliente.setNome("Peter Parker");
        cliente.setProfissao("Reporter");
        cliente.setCpf("999.777.444-00");
        return cliente;
    }

    private static void WriteToBinFile(Cliente cliente) throws FileNotFoundException, IOException {
        // -> A transformação do objeto em um fluxo binário é chamada de serialização.
        final FileOutputStream fos = new FileOutputStream("java-io/cliente.bin");
        final ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(cliente);
        oos.close();
    }

    private static Cliente ReadFromBinFile() throws IOException, ClassNotFoundException {
        // -> A transformação de um fluxo binário em um objeto é chamada de
        // desserialização.
        final InputStream in = new FileInputStream("java-io/cliente.bin");
        final ObjectInputStream ois = new ObjectInputStream(in);
        Cliente c = (Cliente) ois.readObject();
        ois.close();
        return c;
    }
}