import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
  }

  public void excluir(Integer id) {
  }

  public List<Cadastro> listar() {
    return null;
  }

  public Cadastro buscar() {
    return null;
  }

}
