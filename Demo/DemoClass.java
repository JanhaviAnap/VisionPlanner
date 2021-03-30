//Java Database Connectivity thoery

/*
 * 1.import --->java.sql
 * 2.load and register the driver --> com.mysql.jdbc.driver
 * 3.create connection
 * 4.create a statement
 * 5.execte the query
 * 6.process the results
 * 7.close
 */


 /*
 C:\Users\janha\Desktop\VisionPlanner\Demo>javac DemoClass.java

C:\Users\janha\Desktop\VisionPlanner\Demo>cd..

C:\Users\janha\Desktop\VisionPlanner>java Demo.DemoClass
Connecting to database...
Creating statement...
userid = 2
username= Jatin
Bye...

C:\Users\janha\Desktop\VisionPlanner>
 */
//package Demo;
import java.sql.*;

public class DemoClass {
    static final String url = "jdbc:mysql://localhost:3306/school";
    static final String jdbcdriver = "com.mysql.cj.jdbc.Driver";
    static final String username = "root";
    static final String password = "Abcd@1234";
    public static void main(String[] args) throws Exception{
        Connection conn = null;
        Statement st = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(url,username,password);
            
            System.out.println("Creating statement...");
            st = conn.createStatement();
            String query = "select id,sname from studentinfo where id=2;";
            ResultSet rs = st.executeQuery(query);

            rs.next();
            int id = rs.getInt("id");
            String name = rs.getString("sname");

            System.out.println("userid = "+id+"\nusername= "+name);

            rs.close();
            st.close();
            conn.close();
        } catch(SQLException se){
            //System.out.println("OOps,");
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(st!=null)    st.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        /*Connection conn = DriverManager.getConnection(url,username,password);

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        rs.next();
        int id = rs.getInt("userid");
        String name = rs.getString("username");

        System.out.println("userid = "+id+"\nusername= "+name);

        st.close();
        conn.close();*/
        System.out.println("Bye...");
    }
}
