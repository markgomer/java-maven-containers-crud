import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class FabricaConexao {
  private static Connection conexao;

  public static void conectar() {
    if (conexao == null) {
      /*
       * usually, you'd want the pg:5432 to be localhost:5432, but I've
       * configured the compose file with the service name "pg", so use that.
       */
      String url = "jdbc:postgresql://pg:5432/rocket";
      Properties props = new Properties();
      props.setProperty("user", "postgres");
      props.setProperty("password", "1234");

      try {
        conexao = DriverManager.getConnection(url, props);
      } catch (SQLException e) {
        e.printStackTrace();
      }
      System.out.println("Conexão realizada com sucesso");
    }
  }

  public static Connection getConnection() {
    return conexao;
  }

}
