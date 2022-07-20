package horsov;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet("/servlet")
public class Main extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("INITIALIZING");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Service enter\n");
        super.service(req, resp);
        resp.getWriter().write("Service exit\n");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String uri = req.getRequestURI();
        String parameters = formatParams(req);
        resp.getWriter().write("DoGet\nURI: " + uri + "\nParams:\n" + parameters + "\n");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String uri = req.getRequestURI();
        String parameters = formatParams(req);
        resp.getWriter().write("DoPost\nURI: " + uri + "\nParams:\n" + parameters + "\n");
    }

    @Override
    public void destroy() {
        log("DESTROY");
    }

    //Метод форматирования параметров идентичен для пост и гет
    private String formatParams(HttpServletRequest req){
        return req.getParameterMap().entrySet().stream().map(entry -> {
                String parameter = String.join(" and ", entry.getValue());
                return entry.getKey() + " => " + parameter;
                })
                .collect(Collectors.joining("\n"));
    }
}