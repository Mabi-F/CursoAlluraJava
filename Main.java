import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Declaração de Variáveis

        String nomeDoCliente = "Mabi Fabrini Costa";
        String tipoConta = "Corrente";
        double saldo = 2500;
        double movimentacao = 0;

        int operacao = -1;

        Scanner leitura = new Scanner(System.in);

        // Impressão dos Dados Iniciais

        System.out.println("**************************");
        System.out.println(String.format("Nome: %s",nomeDoCliente));
        System.out.println(String.format("Tipo de Conta: %s",tipoConta));
        System.out.println(String.format("Saldo Inicial: R$ %.2f",saldo));
        System.out.println("**************************");

        while(operacao != 4){

            System.out.println("""
                    Operações:
                    
                    1 - Consultar Saldo
                    2 - Receber Valor
                    3 - Transferir Valor
                    4 - Sair
                    
                    Digite a opção desejada:""");

            operacao = leitura.nextInt();

            switch(operacao){

                case 1:
                    System.out.println(String.format("Saldo Atualizado: R$ %.2f",saldo));
                    break;

                case 2:
                    System.out.println("Insira o valor recebido:");
                    movimentacao = leitura.nextDouble();

                    if(movimentacao >= 0){
                        saldo += movimentacao;
                        System.out.println(String.format("Saldo Atualizado: R$ %.2f",saldo));
                    } else{
                        System.out.println("Valor recebido não pode ser negativo, tente novamente.");
                    }

                    break;

                case 3:
                    System.out.println("Insira o valor a ser transferido:");
                    movimentacao = leitura.nextDouble();

                    if(movimentacao >= 0){

                        if(movimentacao <= saldo){
                            saldo -= movimentacao;
                            System.out.println(String.format("Saldo Atualizado: R$ %.2f",saldo));
                        } else{
                            System.out.println("Valor final não pode ser negativo, tente novamente.");
                        }
                    } else{
                        System.out.println("Valor recebido não pode ser negativo, tente novamente.");
                    }

                    break;

                case 4:
                    System.out.println("Obrigado por usar nossos sistemas! Volte sempre!");
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;

            }

        }

    }
}