public class SistemaCadastro {
  public static void main(String[] args) {
    FabricaConexao.conectar();
    CadastroRepository repository = new CadastroRepository();
    Cadastro cadastro = new Cadastro();
    cadastro.setNome("Batata");
    cadastro.setIdade(17);

    repository.salvar(cadastro);
  }
}
