import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

      // let's add a pretty little new line registry to the database
      String sqlCommand = "INSERT INTO public.tab_cadastro (nome, idade) VALUES(?,?);";
      String nome = "Mari";
      int idade = 35;

      PreparedStatement p = conn.prepareStatement(sqlCommand);
      p.setString(1, nome);
      p.setInt(2, idade);
      p.execute();

      System.out.println("Registro inserido com sucesso");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
