
package teste;

import dao.ProdutoDao;
import model.Produto;

public class TesteSelectProduto {

    public static void main(String[] args) throws Exception {

        ProdutoDao dao = new ProdutoDao();

        for (Produto prod : dao.listar()) {
            System.out.println(prod);
        }
    }
}