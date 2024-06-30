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

        //ficção
        livros.add(new Livro("harry potter", "ficção", 60.0));;
        livros.add(new Livro("o pequeno principe", "ficção", 20.0));;
        livros.add(new Livro("q revolução dos bichos", "ficção", 15.0));;
        livros.add(new Livro("o paraíso", "ficção", 20.0));;
        livros.add(new Livro("o hobbit", "ficção", 56.0));;

        //ciencia 
        livros.add(new Livro("cosmos", "ciência", 56.0));
        livros.add(new Livro("do atomo ao buraco negro", "ciência", 55.0));
        livros.add(new Livro("o despertar da consciencia", "ciência", 150.0));
        livros.add(new Livro("teoria quantica", "ciência", 27.0));
        livros.add(new Livro("a clavicula de salomão", "ciência", 68.0));

        //filosofia
        livros.add(new Livro("além do bem e do mal", "filosofia", 28.0));
        livros.add(new Livro("assim falou zaratustra", "filosofia", 35.0));
        livros.add(new Livro("genealogia da moral", "filosofia", 35.0));
        livros.add(new Livro("o idiota", "filosofia", 105.0));
        livros.add(new Livro("o catador de pensamentos", "filosofia", 40.0));

        //terror
        livros.add(new Livro("frankenstein", "terror", 50.0));
        livros.add(new Livro("a hora do vampiro", "terror", 46.0));
        livros.add(new Livro("necronomicon", "terror", 76.0));
        livros.add(new Livro("entre sonhos e pesadelos ", "terror", 44.90));
        livros.add(new Livro("a mortalha carmesin", "terror", 49.90));

        //supense 
        livros.add(new Livro("manual de assassinato", "suspense", 47.0));
        livros.add(new Livro("a cirurgiã", "suspense", 46.0));
        livros.add(new Livro("o fabricante de lagrimas", "suspense", 55.0));
        livros.add(new Livro("outsider", "suspense", 75.0));
        livros.add(new Livro("ninguem vai te ouvir gritar", "suspense", 40.0));

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
