import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.Collections;

public class SugestaoVendedora {

    private Random livrosAleatorios;

    public SugestaoVendedora(Random livrosAleatorios) {
        this.livrosAleatorios = new Random();
    }

   public Livro gerarSugestaoPorCategoria(List<Livro> livros, String categoria){
    
        List<Livro> livrosRecomendadosPorCategoria = livros.stream()
            .filter(livro -> livro.categoria.equalsIgnoreCase(categoria))
            .collect(Collectors.toList());

            if(livrosRecomendadosPorCategoria.isEmpty()){
                return null;
            }

            Collections.shuffle(livrosRecomendadosPorCategoria, livrosAleatorios);

            return livrosRecomendadosPorCategoria.get(0);
   }

}
