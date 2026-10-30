
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class ProdutoDao {

    // INSERT: cadastrar uma joia
    public void cadastrar(Produto prod) throws SQLException {

        String sql = "INSERT INTO produto "
            + "(nome_produto, valor_produto, qtde_produto, "
            + "tipo_produto, material_produto, possui_pedra, "
            + "tamanho_anel, comprimento_cm) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement comandoSql =
            Conexao.getInstance().prepareStatement(sql);

        comandoSql.setString(1, prod.getNome());
        comandoSql.setDouble(2, prod.getValor());
        comandoSql.setInt(3, prod.getQtde());
        comandoSql.setString(4, prod.getTipo());
        comandoSql.setString(5, prod.getMaterial());
        comandoSql.setObject(6, prod.getPossuiPedra());
        comandoSql.setObject(7, prod.getTamanhoAnel());
        comandoSql.setObject(8, prod.getComprimentoCm());

        comandoSql.executeUpdate();
        Conexao.getInstance().commit();

        comandoSql.close();
    }

    // UPDATE: alterar uma joia
    public void alterar(Produto prod) throws SQLException {

        String sql = "UPDATE produto SET "
            + "nome_produto = ?, valor_produto = ?, "
            + "qtde_produto = ?, tipo_produto = ?, "
            + "material_produto = ?, possui_pedra = ?, "
            + "tamanho_anel = ?, comprimento_cm = ? "
            + "WHERE id_produto = ?";

        PreparedStatement comandoSql =
            Conexao.getInstance().prepareStatement(sql);

        comandoSql.setString(1, prod.getNome());
        comandoSql.setDouble(2, prod.getValor());
        comandoSql.setInt(3, prod.getQtde());
        comandoSql.setString(4, prod.getTipo());
        comandoSql.setString(5, prod.getMaterial());
        comandoSql.setObject(6, prod.getPossuiPedra());
        comandoSql.setObject(7, prod.getTamanhoAnel());
        comandoSql.setObject(8, prod.getComprimentoCm());
        comandoSql.setInt(9, prod.getId());

        int linhas = comandoSql.executeUpdate();
        Conexao.getInstance().commit();

        System.out.println("Registros alterados: " + linhas);
        comandoSql.close();
    }

    // DELETE: excluir uma joia pelo ID
    public void excluir(int id) throws SQLException {

        String sql =
            "DELETE FROM produto WHERE id_produto = ?";

        PreparedStatement comandoSql =
            Conexao.getInstance().prepareStatement(sql);

        comandoSql.setInt(1, id);

        int linhas = comandoSql.executeUpdate();
        Conexao.getInstance().commit();

        System.out.println("Registros excluídos: " + linhas);
        comandoSql.close();
    }

    // SELECT: consultar todas as joias
    public List<Produto> listar() throws SQLException {

        String sql = "SELECT * FROM produto ORDER BY id_produto";

        List<Produto> produtos = new ArrayList<>();

        PreparedStatement comandoSql =
            Conexao.getInstance().prepareStatement(sql);

        ResultSet resultado = comandoSql.executeQuery();

        while (resultado.next()) {

            Produto prod = new Produto();

            prod.setId(resultado.getInt("id_produto"));
            prod.setNome(resultado.getString("nome_produto"));
            prod.setValor(resultado.getDouble("valor_produto"));
            prod.setQtde(resultado.getInt("qtde_produto"));

            prod.setTipo(resultado.getString("tipo_produto"));
            prod.setMaterial(resultado.getString("material_produto"));

            boolean possuiPedra =
                resultado.getBoolean("possui_pedra");

            if (resultado.wasNull()) {
                prod.setPossuiPedra(null);
            } else {
                prod.setPossuiPedra(possuiPedra);
            }

            int tamanho = resultado.getInt("tamanho_anel");
            prod.setTamanhoAnel(
                resultado.wasNull() ? null : tamanho
            );

            double comprimento =
                resultado.getDouble("comprimento_cm");

            prod.setComprimentoCm(
                resultado.wasNull() ? null : comprimento
            );

            produtos.add(prod);
        }

        resultado.close();
        comandoSql.close();

        return produtos;
    }
}