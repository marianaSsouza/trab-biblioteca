import java.util.List;

public class FinalizarCompra {

     public void finalizarCompra(List<Livro> livros, double descontoPercentual ){

        livros.stream()
            .forEach(livro -> {
               System.out.println("atualmente os livros do seu carrinho são: " + livro); 
            });


        //mostrar o preco dos livros, fazer a soma deles
        double somaDosPrecos = livros.stream()
        .mapToDouble(livro -> livro.preco)
        .sum();

        System.out.println("O valor total de sua compra é: " + somaDosPrecos);

        //aplicar desconto 
        double descontoTotal = somaDosPrecos * (descontoPercentual / 100);
        double descontoFinal = somaDosPrecos - descontoTotal;

        System.out.println("Você recebeu um desconto de " + descontoPercentual + " % !!");
        System.out.println("o valor total, agora com desconto, de sua compra é de " + descontoFinal);

    }

}
