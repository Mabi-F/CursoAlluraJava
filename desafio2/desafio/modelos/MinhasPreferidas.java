package desafio.modelos;

public class MinhasPreferidas {

    public void inclui(Audio a){

        if(a.getClassificacao() >= 9){
            System.out.println(a.getTitulo() + " é sucesso absoluto!");
        } else{
            System.out.println(a.getTitulo() + " está crescendo!");
        }

    }

}
