
package proyecto.alchemilla.accion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import proyecto.alchemilla.conexion.Conexion;
import proyecto.alchemilla.conexion.Encriptar;
import proyecto.alchemilla.querys.UsuarioQuerys;

import proyecto.alchemilla.entidades.Usuario;


@WebServlet(name = "login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombreDeUsuario = request.getParameter("nombre_de_usuario");
        String password = request.getParameter("password");
        
        password = Encriptar.codificar(password);

        try {
            Connection conn = Conexion.getConnection();
            Usuario u = UsuarioQuerys.login(conn, nombreDeUsuario, password);

            if (u != null) {
                request.getSession().setAttribute("USUARIO_ACTUAL", u);
                conn.close();
                request.getRequestDispatcher("/WEB-INF/vista/principal/index.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Usuario Incorrecto o Contraseña incorrecta");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }

        } catch (IOException | ClassNotFoundException | SQLException | ServletException e) {
            request.setAttribute("error", "ERROR DEL SISTEMA:" + e.getMessage());
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }

}
