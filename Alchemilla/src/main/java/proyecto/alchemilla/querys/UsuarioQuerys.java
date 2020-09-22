
package proyecto.alchemilla.querys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import proyecto.alchemilla.transferencias.Usuario;

public class UsuarioQuerys {
    
     public static Usuario login(Connection con, String username, String password) throws SQLException{
        String sql= "SELECT nombre_de_usuario, password, alias FROM usuario WHERE nombre_de_usuario = ? and password = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        int i=1;
        stm.setString(i++, username);
        stm.setString(i++, password);
        
        ResultSet rs=stm.executeQuery();
        if(rs.next()){
            Usuario u = new Usuario();
            u.setNombreDeUsuario(rs.getString("nombre_de_usuario"));
            u.setAlias(rs.getString("alias"));
            
            return u;
        }
        return null;
    }
    
    public static List<Usuario> getUserList(Connection con) throws SQLException{
        String sql = "SELECT nombre_de_usuario, password, alias FROM usuario";
        System.out.println(sql);
        
     
        PreparedStatement stm = con.prepareStatement(sql);
        ResultSet rs =stm.executeQuery();
        
        List <Usuario> list =  new ArrayList<Usuario>();
        
        while(rs.next()){
            Usuario u = new Usuario();
            u.setNombreDeUsuario(rs.getString("nombre_de_usuario"));
            u.setPassword(rs.getString("password"));
            u.setAlias(rs.getString("alias"));
            list.add(u);
        
        }
        return list;
    }
    
}
