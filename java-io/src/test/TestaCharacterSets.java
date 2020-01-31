package test;

import java.io.UnsupportedEncodingException;

public class TestaCharacterSets {

    public static void main(String[] args) throws UnsupportedEncodingException {

        // ASCII (American Standard Code for Information Interchange).
        // Engloba todos os caracteres da língua inglesa

        // http://www.ascii.ca/ascii_standard.htm
        // único formato capaz de englobar a quantidade de informação correspondente ao
        // número de línguas e caracteres existentes.

        // http://www.ascii.ca/iso8859.1.htm
        // Caracteres latinos

        // Para tentar unificar os padrões, e minimizar este tipo de problemas, foi
        // criado o unicode. Trata-se de uma tabela cujo objetivo é de apresentar todos
        // os caracteres existentes no mundo.
        // https://en.wikipedia.org/wiki/List_of_Unicode_characters

        // https://www.unicode.org/
        // https://www.unicode.org/faq/basic_q.html

        // O número utilizado para representar um caracter no Unicode é chamado
        // codepoint.

        // Outro link interessante é contem a tabela completa dos caracteres unicode.
        // https://unicode-table.com/pt/

        // Contudo, o unicode não define a forma como as informações devem ser
        // armazenadas no HD, isto é tarefa dos encodings.
        // É o caso dos "UTFs", como o UTF-8 e UTF-16, esta sigla significa "Unicode
        // Transformation Format.
        // Ela está vinculada desde o nascimento com a tabela de Unicode, para traduzir
        // os codepoints para um formato binário.

        // Além do UTF há outros exemplos de Encodings, como o ASCII e o Windows 1252.

        String[] codes = { "ISO-8859-1", "UTF-8", "UTF-16" };
        String palavra = "ç";

        for (String encoding : codes) {
            byte[] b = palavra.getBytes(encoding);
            System.out.printf("%10s\t%d\t", encoding, b.length);
            for (int k = 0; k < b.length; k++) {
                String hex = Integer.toHexString((b[k] + 256) % 256);
                if (hex.length() == 1)
                    hex = "0" + hex;
                System.out.print(hex);
            }
            System.out.println();
        }

    }
}