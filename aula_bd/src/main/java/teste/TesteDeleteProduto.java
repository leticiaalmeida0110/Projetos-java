package teste;

import dao.ProdutoDao;

public class TesteDeleteProduto {
    public static void main(String[] args) throws Exception {
        ProdutoDao dao = new ProdutoDao();
        dao.excluir(1);
    }
}