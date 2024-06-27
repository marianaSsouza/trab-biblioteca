import java.util.stream.Stream;

public class Livro {

    public String titulo;
    public String categoria;
    public double preco;

    public Livro(String titulo, String categoria, double preco) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Livro -> titulo: " + titulo + " | categoria:  " + categoria + " | preco: " + preco + "";
    }

}
