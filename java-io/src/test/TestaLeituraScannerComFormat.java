package test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;

public class TestaLeituraScannerComFormat {

    public static void main(String[] args) throws IOException {
        // A classe Scanner conta com uma série de métodos de alto nível.
    	
        File fileContas = new File("java-io/contas.csv");
    	//File fileContas = new File("contas.csv");
    	Charset utf8 = StandardCharsets.UTF_8;
        java.util.Scanner scannerContas = new Scanner(fileContas, utf8);
        while (scannerContas.hasNextLine()) {
            String linha = scannerContas.nextLine();

            String[] valores = linha.split(",");
            System.out.println();
            System.out.println("> " + valores[3]);
            //System.out.println(Arrays.toString(valores));

            Scanner scannerLinha = new Scanner(linha);
            scannerLinha.useLocale(Locale.US); // -> Padrão para separar decimais ... (No padrão americano, separam os decimais com "." - Ponto)
            scannerLinha.useDelimiter(",");

            String tipoConta = scannerLinha.next();
            int agencia = scannerLinha.nextInt();
            int numero = scannerLinha.nextInt();
            String titular = scannerLinha.next();
            double saldo = scannerLinha.nextDouble();

            // Formatação
            // A legibilidade do nosso código melhora consideravelmente desta forma
            // * Concatenar muitas Strings é sempre má prática.
            // %s -> String
            // %20s -> String, fixada em 20 caracteres.
            // %d -> Inteiro
            // %04d -> Inteiro com 4 dígitos (preenche com zeros a esquerda)
            // %f -> "Float" (double)
            // %010.2f -> "Float" (double) - com 10 caracteres, sendo 2 decimais e 1 vírgula.
            
            //String extrato = String.format(new Locale("pt", "BR"), "%s | %04d/%d, %s: %010.2f", tipoConta, agencia, numero, titular, saldo);
            //System.out.println("Extrato :: " + extrato );           

            System.out.format(new Locale("pt", "BR"), "%s | %04d/%d | Titular: %s | Saldo: %010.2f %n", tipoConta, agencia, numero, titular, saldo);

            scannerLinha.close();
        }
        scannerContas.close();
    }
}