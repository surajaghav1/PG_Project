import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Java_Con {
    Connection con=null;
    Statement stmt=null;

      public void createCon(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/pg_management","root","");
            System.out.println("Connection established ");
            stmt = con.createStatement();

        }catch (Exception e){
            System.out.println(e);
            System.out.println("Error in establishing connection");
        }
    }

}
