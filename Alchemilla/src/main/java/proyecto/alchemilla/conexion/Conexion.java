package proyecto.alchemilla.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static String urlDeConexion = "jdbc:mysql://127.0.0.1:3306/"
            + "controlhospital?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String usuarioConexion = "root";
    private static String passwordConexion = "11112222";

    
    //elimar static ya que aqui solo es necesario para probar la conexión
    public static Connection getConnection(String url, String driver, String usuario) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, driver, usuario);
            if (conn != null) {
                System.out.println("Conectado a la base de Datos");
            }
        } catch (SQLException ex) {
            System.out.println("ERROR DE CONEXION");
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                }
            }
        }
        return conn;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection;
        connection = getConnection(urlDeConexion, usuarioConexion, passwordConexion);
    }

}
