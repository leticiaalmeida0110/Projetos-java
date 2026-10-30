package teste;

import dao.ProdutoDao;
import model.Produto;

public class TesteInsertProduto {
    public static void main(String[] args) throws Exception {

        ProdutoDao dao = new ProdutoDao();

        // 1. Anel de prata
        Produto p1 = new Produto(
            null, "Anel de Prata", 89.90, 5,
            "Anel", "Prata", true, 18, null
        );
        dao.cadastrar(p1);

        // 2. Brinco Rommanel
        Produto p2 = new Produto(
            null, "Brinco Rommanel", 59.90, 10,
            "Brinco", "Rommanel", false, null, null
        );
        dao.cadastrar(p2);

        // 3. Pulseira de prata
        Produto p3 = new Produto(
            null, "Pulseira de Prata", 120.00, 4,
            "Pulseira", "Prata", true, null, 18.0
        );
        dao.cadastrar(p3);

        // 4. Corrente Rommanel
        Produto p4 = new Produto(
            null, "Corrente Rommanel", 150.00, 6,
            "Corrente", "Rommanel", false, null, 45.0
        );
        dao.cadastrar(p4);

        // 5. Anel com pedra
        Produto p5 = new Produto(
            null, "Anel com Pedra", 99.90, 5,
            "Anel", "Prata", true, 18, null
        );
        dao.cadastrar(p5);

        System.out.println("Todas as joias foram cadastradas!");
    }
}