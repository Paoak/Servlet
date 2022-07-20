package horsov;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.UUID;
import java.util.stream.Collectors;

@WebServlet("/servlet-file")
@MultipartConfig(location = "D:/prog/servletapp")
public class ForFileServlet extends HttpServlet {

   //Если в форме имя то выводится лог, если файл, то он загружается в корень проекта.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (Part part : req.getParts()) {
            if(part.getName().equals("some-name")){
                InputStream inputStream = part.getInputStream();
                InputStreamReader isr = new InputStreamReader(inputStream);
                String someName = new BufferedReader(isr).lines().collect(Collectors.joining("\n"));
                log(someName);
            } else {
                part.write(UUID.randomUUID().toString() + part.getSubmittedFileName());
            }
        }
        resp.sendRedirect("/app/servlet");
    }
}
