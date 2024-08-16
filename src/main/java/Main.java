import java.awt.JobAttributes.SidesType;
import java.util.InputMismatchException;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;

public class Main {
  public static void main(String[] args) {
    ArvoreBuscaBinaria estoque = new ArvoreBuscaBinaria();

    estoque.inserirProduto(new Produto(3, "Arroz", 10));
    estoque.inserirProduto(new Produto(1, "Feijão", 20));
    estoque.inserirProduto(new Produto(2, "Milho", 20));
    estoque.inserirProduto(new Produto(5, "Macarrão", 30));
    estoque.inserirProduto(new Produto(4, "Farinha", 40));
    estoque.inserirProduto(new Produto(8, "Ovos", 50));
    estoque.inserirProduto(new Produto(7, "Leite", 60));

    //estoque.buscarProduto(3);
    //estoque.removerProduto(3);
    estoque.imprimirArvore();
    estoque.removerProduto(3);
    System.out.println("");
     estoque.imprimirArvore();
    estoque.extremos();
    //System.out.println(estoque.raiz.direito.produto.nome);

  }

  // @Test
  // void addition() {
  //     assertEquals(2, 1 + 1);
  // }
}