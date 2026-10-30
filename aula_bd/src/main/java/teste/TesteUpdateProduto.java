package teste;

import dao.ProdutoDao;
import model.Produto;

public class TesteUpdateProduto {
    public static void main(String[] args) throws Exception {
        ProdutoDao dao = new ProdutoDao();

        Produto prod = new Produto(
            1, "Anel de Prata", 99.90, 8,
            "Anel", "Prata", true, 18, null
        );

        dao.alterar(prod);
    }
}