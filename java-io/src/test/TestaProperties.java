package test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class TestaProperties {

    public static void main(String[] args) throws IOException {
        writeDefaultProperties();
        readProperties();
    }

    private static void readProperties() throws IOException {
        Properties p = new Properties();
        p.load(new FileReader("java-io/conf.properties"));
        System.out.println( p.getProperty("login") );
        System.out.println( p.getProperty("senha") );
        System.out.println( p.getProperty("endereco") );
    }

    private static void writeDefaultProperties() throws IOException {
        Properties p = new Properties();
        p.setProperty("login", "alura");
        p.setProperty("senha", "alurapass");
        p.setProperty("endereco", "www.alura.com.br");
        p.store(new FileWriter("java-io/conf.properties"), "algum comentário");
    }
}