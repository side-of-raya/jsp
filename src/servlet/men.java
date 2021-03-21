package servlet;

import DAO.MenDAO;
import model.Man;
import DAO.UpdateArgs;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/men")
public class men extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Man> men = null;
        try {
            men = MenDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("men", men);
        RequestDispatcher dispatcher = request.getRequestDispatcher("menList.jsp");
        dispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        RequestDispatcher dispatcher;
        switch (action) {
            case ("create"):
                String name = request.getParameter("name");
                int age = Integer.parseInt(request.getParameter("age"));
                try {
                    MenDAO.createMan(name, age);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                dispatcher=request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
                break;
            case ("delete"):
                int id = Integer.parseInt(request.getParameter("id"));
                try {
                    MenDAO.deleteMan(id);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                dispatcher=request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
                break;
            case ("update"):
                int updateId = Integer.parseInt(request.getParameter("id"));
                String updateName = request.getParameter("name");
                String ageParam = request.getParameter("age");
                Integer updateAge = 0;
                if (ageParam != "") updateAge = Integer.parseInt(ageParam);
                Man man = new Man();
                if (updateName != "") man.setName(updateName);
                if (updateAge != 0) man.setAge(updateAge);
                try {
                    MenDAO.updateMan(updateId, man);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                dispatcher=request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
                break;
        }
    }
}
