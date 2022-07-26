package horsov;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/jsp-serv")
public class ForJspServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<User> users = new ArrayList<User>(){{
            add(new User("John", "Somalia", 80));
            add(new User("Viktor", "Belarus", 20));
            add(new User("Noa", "Denmark",  34));
        }};
        req.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/first-jsp.jsp").forward(req, resp);
    }
}
