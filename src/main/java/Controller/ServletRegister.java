package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/registerServlet")
public class ServletRegister extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String age = req.getParameter("age");
        String phone = req.getParameter("phone");
        String gender = req.getParameter("gender");

        HttpSession session = req.getSession();
        session.setAttribute("name", name);
        session.setAttribute("email", email);
        session.setAttribute("age", age);
        session.setAttribute("phone", phone);
        session.setAttribute("gender", gender);

        boolean flag = JDBCConnection.Insert(name, email, age, phone, gender);
        if(flag){
            resp.sendRedirect("success.jsp");
        }
        else{
            resp.sendRedirect("failed.jsp");
        }
    }
}