import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCPostgres {

  // mvn exec:java -Dexec.mainClass="com.yourpackage.MainClassName"
  // mvn exec:java -Dexec.mainClass="JDBCPostgres"
  public static void main(String[] args) {
    try {
      /*
       * usually, you'd want the pg:5432 to be localhost:5432, but I've
       * configured the compose file with the service name "pg", so use that.
      */
      String url = "jdbc:postgresql://pg:5432/rocket_db";

      Properties props = new Properties();
      props.setProperty("user", "postgres");
      props.setProperty("password", "1234");
      // props.setProperty("ssl", "true");

      Connection conn = DriverManager.getConnection(url, props);
      System.out.println("Conexão realizada com sucesso");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
