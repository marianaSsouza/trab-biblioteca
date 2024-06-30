import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner leitor = new Scanner(System.in);

        // instanciando as classes
        InteracaoComUsuario interacao = new InteracaoComUsuario(leitor);
        LivroService livrosInfo = new LivroService();
        SugestaoVendedora sugestaoVendedora = new SugestaoVendedora(null);
        FinalizarCompra finalizar = new FinalizarCompra();

        /// lista com todos os livros
        List<Livro> livros = new ArrayList<Livro>();
        livros.add(new Livro("livro1", "ficção", 30.0));
        livros.add(new Livro("livro3", "ação", 20.0));
        livros.add(new Livro("livro4", "ciência", 20.0));
        livros.add(new Livro("livro4", "filosofia", 20.0));
        livros.add(new Livro("livro5", "terror", 20.0));
        livros.add(new Livro("livro2", "suspense", 10.0));

        // lista para o carrinho de compras
        List<Livro> carrinho = new ArrayList<>();

        int opcao = -1;

        while (opcao != 0) {
            opcao = interacao.mostrarOpcoesMenu();

            switch (opcao) {

                case 1: // mostrar livros disponiveis
                    livrosInfo.livrosDisponiveis(livros);
                    break;

                case 2: /// mostrar categorias
                    livros.stream()
                            .map(l -> l.categoria)
                            .forEach(System.out::println);
                    System.out.println("informe a categoria");
                    String categoria = leitor.nextLine();
                    livrosInfo.buscarCategoriaPorNome(livros, categoria);
                    break;

                case 3: /// preco dos livros
                    livrosInfo.mostrarPrecoLivros(livros);
                    break;

                case 4: /// sugestãpo da vendedora
                    System.out.println("informe a categoria para gerar uma sugestão: ");
                    String categoriaSugerida = leitor.next();
                    livrosInfo.usarSugestao(livros, categoriaSugerida, sugestaoVendedora);
                    break;

                case 5: /// adicionar livros
                    livrosInfo.livrosDisponiveis(livros);
                    System.out.println("Informe o código do livro que deseja adicionar: ");
                    int codigoInformado = leitor.nextInt();
                    carrinho.add(livros.get(codigoInformado-1));
                    System.out.println("Perfeito, o livro foi adicionado no carrinho!");
                    break;

                case 6: // mostrar livros adicionados no carrinho
                    livrosInfo.mostrarLivrosNoCarrinho(carrinho);
                    break;

                case 7: // finalizar compra e aplicar desconto
                    finalizar.finalizarCompra(carrinho, 10d);
                    break;

                default:
                    break;

            }

        }

        leitor.close();

       

    }
}
