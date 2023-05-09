import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GeradorDeArquivo {

    public void salvaJson(List<Endereco> endereco){

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        try {
            FileWriter escrita = new FileWriter("enderecos.json");
            escrita.write(gson.toJson(endereco));
            escrita.close();
            System.out.println("Salvo arquivo .json de endereços!");
        }catch (Exception e){
            System.out.println("Não foi possível gerar arquivo de endereços!");
        }

    }

}
