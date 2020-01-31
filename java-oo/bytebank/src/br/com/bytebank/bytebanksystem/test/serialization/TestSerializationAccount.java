package br.com.bytebank.bytebanksystem.test.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import br.com.bytebank.bytebanksystem.model.Account;
import br.com.bytebank.bytebanksystem.model.CheckingAccount;
import br.com.bytebank.bytebanksystem.model.Customer;

public class TestSerializationAccount {
   
    public static void main(final String[] args) throws IOException, ClassNotFoundException {
        Account writeableAccount = newAccount();
        WriteToBinFile(writeableAccount);
        
        final Account readedAccount = ReadFromBinFile();

        System.out.println("Saldo atual: " + readedAccount.getBalance());
        System.out.println("Objeto customer (está nulo): " + readedAccount.getCustomer()); // Aplicado no atributo "transient Customer ownerOfAccount;"" //-> Impedindo de serializar o objeto ...
        //System.out.println(readedAccount.toString());
    }

    private static Account newAccount() {
		Customer customer = new Customer();
        customer.setName("Capitão América");
        customer.setCpf("999.665.211-00");
        customer.setEndereco("Rua Z");
        
		Account vpCheckingAccount = new CheckingAccount(100, 444, customer);
		vpCheckingAccount.deposit(1000);
        return vpCheckingAccount;
    }

    private static void WriteToBinFile(Account account) throws FileNotFoundException, IOException {
        // -> A transformação do objeto em um fluxo binário é chamada de serialização.
        final FileOutputStream fos = new FileOutputStream("java-oo/account.bin");
        final ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(account);
        oos.close();
    }

    private static Account ReadFromBinFile() throws IOException, ClassNotFoundException {
        // -> A transformação de um fluxo binário em um objeto é chamada de
        // desserialização.
        final InputStream in = new FileInputStream("java-oo/account.bin");
        final ObjectInputStream ois = new ObjectInputStream(in);       
        Account c = (Account) ois.readObject();
        ois.close();
        return c;
    }
}