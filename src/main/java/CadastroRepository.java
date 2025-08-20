import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CadastroRepository {
  private Connection conexao;

  public CadastroRepository() {
    this.conexao = FabricaConexao.getConnection();
    this.createTable();
  }

  public void createTable() {
    String sql = "CREATE TABLE IF NOT EXISTS tab_cadastro (id SERIAL PRIMARY KEY, nome VARCHAR(50) NOT NULL, idade INT4);";
    try {
      PreparedStatement ps = conexao.prepareStatement(sql);
      ps.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void incluir(Cadastro cadastro) {
    String sql = "INSERT INTO public.tab_cadastro (nome,idade) VALUES(?,?);";
    try {
      PreparedStatement ps = conexao.prepareStatement(sql);
      ps.setString(1, cadastro.getNome());
      ps.setInt(2, cadastro.getIdade());
      ps.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void alterar(Cadastro cadastro) {
    String sql = "UPDATE public.tab_cadastro SET nome=?, idade=? WHERE id=?;";
    try {
      PreparedStatement ps = conexao.prepareStatement(sql);
      ps.setString(1, cadastro.getNome());
      ps.setInt(2, cadastro.getIdade());
      ps.setInt(3, cadastro.getId());
      ps.execute();
      System.out.println("Cadastro alterado com sucesso");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void excluir(Integer id) {
    String sql = "DELETE FROM public.tab_cadastro WHERE id=?;";
    try {
      PreparedStatement ps = conexao.prepareStatement(sql);
      ps.setInt(1, id);
      ps.execute();
      System.out.println("Cadastro excluido com sucesso");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public List<Cadastro> listar() {
    List<Cadastro> lista = new ArrayList<Cadastro>();

    StringBuilder sql = new StringBuilder();
    sql.append("SELECT id, nome, idade ");
    sql.append("FROM public.tab_cadastro");
    try {
      PreparedStatement ps = conexao.prepareStatement(sql.toString());
      ResultSet result = ps.executeQuery();

      while (result.next()) {
        int id = result.getInt("id");
        String nome = result.getString("nome");
        int idade = result.getInt("idade");

        Cadastro cadastro = new Cadastro();
        cadastro.setId(id);
        cadastro.setNome(nome);
        cadastro.setIdade(idade);

        lista.add(cadastro);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return lista;
  }

  public Cadastro buscar(Integer id) {
    Cadastro cadastro = null;

    StringBuilder sql = new StringBuilder();
    sql.append("SELECT id, nome, idade ");
    sql.append("FROM public.tab_cadastro ");
    sql.append("WHERE id=?;");
    try {
      PreparedStatement ps = conexao.prepareStatement(sql.toString());
      ps.setInt(1, id);

      ResultSet result = ps.executeQuery();

      if (result.next()) {
        String nome = result.getString("nome");
        int idade = result.getInt("idade");

        cadastro = new Cadastro();
        cadastro.setId(id);
        cadastro.setNome(nome);
        cadastro.setIdade(idade);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return cadastro;
  }

}
