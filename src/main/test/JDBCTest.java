import java.sql.*;

/**
 * Created by BUG666 on 2017/1/5.
 */
public class JDBCTest {
    public  static void main(String [] args) {
        Connection con = null;//定义一个MYSQL链接对象
        PreparedStatement ps = null; //创建声明
        String sql = "INSERT INTO information VALUES (NULL ,?,?,?,?,?,?,?,?)";
        try {
            Class.forName("com.mysql.jdbc.Driver"); //MYSQL驱动
            con = DriverManager.getConnection(
                    "jdbc:mysql://139.199.7.26:3306/AISystemServer",
                    "root", "PW324-mysql");
            ps = con.prepareStatement(sql);
            ps.setInt(1, 0);
            ps.setInt(2, 0);
            ps.setInt(3, 0);
            ps.setInt(4, 55);
            ps.setInt(5, 28);
            ps.setInt(6, 458);
            ps.setInt(7, 68);
            ps.setInt(8, 30);
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();

                }
                if (con != null) {
                    con.close();

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


