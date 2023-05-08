import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*Aplicação de compras
        * com limite do cartão de crédito
        * comprar ate querer parar ou acabar o limite
        *
        * Digite o limite
        * digite item compra
        * digite valor compra
        * mensagem sucesso/falha
        * 0 para sair ou 1 pra continuar
        * se insuficiente ou sair
        * imprimir compras realizadas (por ordem de valor)
        * imprimir saldo restante
        * fim*/

        Scanner leitura = new Scanner(System.in);

        double limite;
        String item;
        double preco;
        int continuar = 1;

        System.out.println("Bem vindo!");

        System.out.println("Insira o limite do cartão:");
        limite = leitura.nextDouble();

        CartaoDeCredito meuCartao = new CartaoDeCredito(limite);

        while(continuar != 0){

            System.out.println("Insira item comprado:");
            item = leitura.next();

            System.out.println("Insira preço do item:");
            preco = leitura.nextDouble();

            Compra novaCompra = new Compra(item,preco);

            if(meuCartao.lancaCompra(novaCompra)){

                System.out.println("Compra realizada!");
                System.out.println("------------------------------------------");
                System.out.println("Digite 0 para sair ou 1 para continuar");
                continuar = leitura.nextInt();

            } else{

                continuar = 0;
                System.out.println("Saldo Insuficiente!");

            }

            System.out.println("------------------------------------------");

        }

        System.out.println("Compras realizadas");

        Collections.sort(meuCartao.getCompras());

        for(Compra c : meuCartao.getCompras()){
            System.out.println(c);
        }

        System.out.println("------------------------------------------");

        System.out.println("Saldo remanescente: R$ " + meuCartao.getSaldo());



    }
}