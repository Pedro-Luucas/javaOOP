
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Map<Integer, ContaBanco> contas = new HashMap<>();

        while (true){
            Scanner input = new Scanner(System.in);
            System.out.println("-----------------------------------");
            System.out.println("BANCO DO PEDRAO:");
            System.out.println("Digite 0 para sair do programa");
            System.out.println("Digite 1 para criar conta");
            System.out.println("Digite 2 para excluir conta");
            System.out.println("Digite 3 para depositar dinheiro");
            System.out.println("Digite 4 para sacar dinheiro");
            System.out.println("-----------------------------------");

            int opcao = input.nextInt();
            if(opcao == 0){
                break;
            }
            switch (opcao) {
                case 1 -> {
                    System.out.println("Escolha um tipo: ( c Para conta corrente OU p Para conta poupanca ) ");
                    String tipo = input.next();
                    System.out.println("Qual o nome do dono da conta?");
                    String dono = input.next();
                    System.out.println("Qual o ID da sua conta? (somente numeros) ");
                    int ID = input.nextInt();

                    ContaBanco conta = new ContaBanco();
                    conta.abrirConta(tipo, dono, ID);
                    contas.put(ID, conta);
                }
                case 2 -> {
                    System.out.println("Qual o ID da conta a ser excluida?");
                    int ID = input.nextInt();
                    ContaBanco fechar = contas.get(ID);
                    if(fechar.fecharConta()){
                        contas.remove(ID);
                    }
                    
                }
                case 3 -> {
                    System.out.println("Qual o ID da conta para o deposito?");
                    int ID = input.nextInt();
                    ContaBanco deposito = contas.get(ID);
                    System.out.println("Qual o valor do deposito? ");
                    float valor = input.nextFloat();
                    deposito.depositar(valor);
                }
                case 4 -> {
                    System.out.println("Qual o ID da conta para o saque?");
                    int ID = input.nextInt();
                    ContaBanco saque = contas.get(ID);
                    System.out.println("Qual o valor do saque? ");
                    float valor = input.nextFloat();
                    saque.sacar(valor);
                }
                default -> System.out.println("Escolha uma opcao valida! ");
            }
        }
    }
}
