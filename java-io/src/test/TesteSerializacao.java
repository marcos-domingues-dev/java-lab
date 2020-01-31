package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TesteSerializacao {
    public static void main(final String[] args) throws IOException, ClassNotFoundException {
        WriteToBinFile();
        ReadFromBinFile();
    }

    private static void WriteToBinFile() throws FileNotFoundException, IOException {
        //->  A transformação do objeto em um fluxo binário é chamada de serialização.
        final String nome = "Peter Parker";
        final FileOutputStream fos = new FileOutputStream("java-io/objeto.bin"); 
        final ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(nome);
        oos.close();
    }

    private static void ReadFromBinFile() throws IOException, ClassNotFoundException {
        // -> A transformação de um fluxo binário em um objeto é chamada de desserialização.
        InputStream in = new FileInputStream("java-io/objeto.bin");
        ObjectInputStream ois = new ObjectInputStream(in);
        String nome = (String) ois.readObject();
        ois.close();
        System.out.println(nome);
    }
}