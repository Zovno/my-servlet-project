package example;

import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    // Известный пароль
    private static final String knownPassword = "Password";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Получите введенный пользователем пароль из параметра запроса
        String userPassword = request.getParameter("MYPSWD");
        String groupID = request.getParameter("groupID");

        if (userPassword != null && userPassword.equals(knownPassword)) {
            // Если введенный пароль совпадает с известным, выдаем приветствие
            response.getWriter().write("u are welcome! Id: " + groupID);
        } else {
            // Иначе выдаем сообщение о нарушении прав доступа
            response.getWriter().write("Cringe");
        }
    }
}

