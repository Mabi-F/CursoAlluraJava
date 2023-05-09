import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        /*Desafio
        * Criar uma aplicação para consultar a API ViaCEP
        * Menu para o usuário informar o CEP para busca
        * Geração de um arquivo .JSON com os dados do endereço*/

        Scanner leitura = new Scanner(System.in);
        String meuCep;
        Buscador meuBuscador = new Buscador();
        List<Endereco> meusEnderecos = new ArrayList<>();
        GeradorDeArquivo arquivo = new GeradorDeArquivo();

        System.out.println("Bem vindo ao sistema de busca de endereços!");
        System.out.println("Digite 'sair' a qualquer momento para encerrar a aplicação.");

        while(true){

            System.out.println("--------------------------------------------");
            System.out.println("Digite o CEP buscado:");
            meuCep = leitura.nextLine().replace("-","");

            if(meuCep.equalsIgnoreCase("sair")){
                break;
            }

            if(meuCep.length() != 8){
                while (meuCep.length() != 8){
                    System.out.println("CEP inválido, tente novamente:");
                    meuCep = leitura.nextLine().replace("-","");
                }
            }

            try{
                meusEnderecos.add(meuBuscador.buscaNaApi(meuCep));
                System.out.println("Novo endereço adicionado:");
                System.out.println(meuBuscador.buscaNaApi(meuCep));
            } catch (RuntimeException e){
                System.out.println(e.getMessage());
                System.out.println("Tente novamente.");
            }

        }

        arquivo.salvaJson(meusEnderecos);
        System.out.println("Processo finalizado.");

    }
}