import java.sql.Connection;
import java.util.List;

public class CadastroRepository {
  private Connection conexao;

  public CadastroRepository() {
    this.conexao = FabricaConexao.getConnection();
  }

  public void salvar(Cadastro cadastro) {
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
