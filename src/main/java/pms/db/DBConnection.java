package pms.db;




import java.sql.Connection;
import java.sql.DriverManager;





public class DBConnection{
   static Connection con;

   public static Connection createConnection(){
     try{
        
         String user="root";
         String pass="";
         String url="jdbc:mysql://localhost:3306/student_db?autoReconnect=true&useSSL=false";

         con = DriverManager.getConnection(url,user,pass);

     }
     catch(Exception ex){
      ex.printStackTrace();
     }
      return con;
   }
   
}