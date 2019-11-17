
public class Flow {

//	Uma pilha Java faz parte da JVM e armazena os métodos que estão sendo executados.
//	Além do bloco de código a pilha guarda os variáveis e as referências desse bloco.
//	Assim a JVM organiza a execução e sabe exatamente qual método está sendo executado
//	que é sempre o método no topo da pilha. A JVM também sabe quais outros precisam
//	ser executados ainda, que são justamente os métodos abaixo.
	
    public static void main(String[] args) {
        System.out.println("Ini do main");
        metodo1();
        System.out.println("Fim do main");
    }

    private static void metodo1() {
        System.out.println("Ini do metodo1");
        metodo2();
        System.out.println("Fim do metodo1");
    }

    private static void metodo2() {
        System.out.println("Ini do metodo2");
        for(int i = 1; i <= 5; i++) {
            System.out.println(i);
        }
        System.out.println("Fim do metodo2");
    }
}
