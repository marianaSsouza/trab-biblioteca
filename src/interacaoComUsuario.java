import java.util.Scanner;

public class InteracaoComUsuario {

    private final Scanner leitor;

    public InteracaoComUsuario(Scanner leitor) {
        this.leitor = leitor;
    }

    final String MENU = """

            -------------menu--------------
         selecione uma opcao para continuar:

            1. livros disponiveis
            2. categria de livros
            3. preço
            4. sugestão da vendedora
            5. adicionar livros
            6. livros adicionados no carrinho
            7. finalizar compra

                        """;
       

    public int mostrarOpcoesMenu() {
        System.out.println(MENU);
        int retornar = leitor.nextInt();
        leitor.nextLine();
        return retornar;
    }

    // a unica coisa que o user vai ter que informar vai ser
    // a categoria do livro que ele quer, o titulo do livro e o preco dele
    //só vou chamar esse metodo no case 5
    public Livro adicionarLivro() {

        leitor.nextLine(); // pra que ele consuma linha vazia
        System.out.println("informe o titulo do livro escolhido: ");
        String livroInformado = leitor.nextLine();

        System.out.println("informe a categoria do livro escolhido: ");
        String categoriaInformada = leitor.nextLine();

        System.out.println("informe o preço do livro escolhido: ");
        double precoInformado = leitor.nextDouble();

        return new Livro(livroInformado, categoriaInformada, precoInformado); // irá retornar o input do user

    }

}
