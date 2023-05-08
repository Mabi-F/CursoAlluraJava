public class Compra implements Comparable<Compra>{

    private String item;
    private double valor;

    public Compra(String item, double valor){

        this.item = item;
        this.valor = valor;

    }

    public String getItem() {
        return item;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return item + ", R$ " + valor;
    }

    @Override
    public int compareTo(Compra outro) {
        return Double.valueOf(this.valor).compareTo(outro.valor);
    }
}
