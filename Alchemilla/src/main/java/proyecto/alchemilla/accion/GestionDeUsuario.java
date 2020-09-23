
package proyecto.alchemilla.accion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import proyecto.alchemilla.conexion.Conexion;
import proyecto.alchemilla.querys.UsuarioQuerys;
import proyecto.alchemilla.entidades.Usuario;


@WebServlet(name = "GestionDeUsuario", urlPatterns = {"/GestionDeUsuario"})
public class GestionDeUsuario extends HttpServlet {

   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action=request.getParameter("accion");
        try{
            Connection conn= Conexion.getConnection();
            if(action.equals("lista")){
                List<Usuario>list = UsuarioQuerys.getUserList(conn);
                String msg="no hay información";
                if(list.size()>0){
                    msg=list.size()+(list.size() > 1 ? "records":"record");
                }
                request.setAttribute("MSG", msg);
                request.setAttribute("list",list);
                request.getRequestDispatcher("/WEB-INF/view/usuario/user.jsp").forward(request, response);
            }
            conn.close();
        }catch(IOException | ClassNotFoundException | SQLException | ServletException e){
            request.setAttribute("Error", e.getMessage());
//            request.getRequestDispatcher("/WEB-INF/view/user/error.jsp").forward(request, response);
        }
        
    }

    
    
    
}
