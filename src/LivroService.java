import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
        * -------------menu--------------
        * Bem vindo a livraria da may! selecione uma opcao para continuar:
        * 
        * 1. livros disponiveis
        * 2. categria de livros
        * 3. preço
        * 4. sugestão da vendedora
        * 5. adicionar livros
        * 6. livros adicionados no carrinho
        * 7. finalizar compra
        * 
        */

public class LivroService {

    // metodo para mostrar os livros disponiveis (em ordem alfabetica)
    public void livrosDisponiveis(List<Livro> livros) {

        livros.sort((l1, l2) -> l1.titulo.compareTo(l2.titulo));
        livros.forEach(System.out::println); // mostra os
        // livros disponiveis

    }

    // metodo para mostrar livros na categoria escolhida
    public void buscarCategoriaPorNome(List<Livro> livros, String categoria) {

        


        System.out.println("categoria de livros: ");

        List<Livro> livrosPorCategoria = livros.stream()
                .filter(livro -> livro.categoria.equalsIgnoreCase(categoria))
                .collect(Collectors.toList());

        if (livrosPorCategoria.isEmpty()) {
            System.out.println("nenhum livro foi encontrado na categoria: " + categoria);
        } else {
            System.out.println("os livros disponiveis na categoria " + categoria + " são: ");
            livrosPorCategoria.forEach(System.out::println);

        }
        
    }

    // metodo para mostrar o preço dos livros
    public void mostrarPrecoLivros(List<Livro> livros) {

        Livro livroMaisCaro = livros.stream()
                .max((li1, li2) -> Double.compare(li1.preco, li2.preco))
                .orElse(null);

        if (livroMaisCaro != null) {
            System.out.println("o livro mais caro é: " + livroMaisCaro.titulo + " -> " + livroMaisCaro);
        }

        Livro livroMaisBarato = livros.stream()
                .min((li1, li2) -> Double.compare(li1.preco, li2.preco))
                .orElse(null);

        if (livroMaisBarato != null) {
            System.out.println("o livro mais barato é: " + livroMaisBarato.titulo + " -> " + livroMaisBarato.preco);
        }

    }
    // metodo para fazer uma sugestão 
    public void usarSugestao(List<Livro> livros, String categoria, SugestaoVendedora sugestaoVendedora) {
        Livro sugestao = sugestaoVendedora.gerarSugestaoPorCategoria(livros, categoria);
        if (sugestao == null) {
            System.out.println("hmmm não há sugestões disponiveis nessa categoria, tente novamente! ");
            return;
        } else {
            System.out.println("certo! para a categoria '" + categoria + "', sugiro o livro: " + sugestao);
        }

    }
    //metodo para mostrar o livro no carrinho 
    public void mostrarLivrosNoCarrinho(List<Livro> livros) {
        livros.stream()
                .forEach(System.out::println);
    }

   
}
