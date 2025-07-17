import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCPostgres {

  public static void main(String[] args) {
    try {
      String url = "jdbc:postgresql://localhost:5432/rocket";

      Properties props = new Properties();
      props.setProperty("user", "postgres");
      props.setProperty("password", "1234");
      // props.setProperty("ssl", "true");

      Connection conn = DriverManager.getConnection(url, props);
      System.out.println("Conexão realizada com sucesso");

    } catch (Exception ex) {
      ex.printStackTrace();
    }

  }

}
