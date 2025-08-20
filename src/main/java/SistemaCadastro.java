public class SistemaCadastro {
  public static void main(String[] args) {
    FabricaConexao.conectar();
    CadastroRepository repository = new CadastroRepository();
    Cadastro cadastro = repository.buscar(4);
    if (cadastro != null) {
      System.out.println(cadastro.getId() + " " + cadastro.getNome());
    } else {
      System.out.println("Cadastro não localizado");
    }

    FabricaConexao.close();
  }
}
