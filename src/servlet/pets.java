package servlet;

import DAO.PetsDAO;
import model.Pet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/pets")
public class pets extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Pet> pets = null;
        try {
            pets = PetsDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("petList", pets);
        RequestDispatcher dispatcher = request.getRequestDispatcher("petList.jsp");
        dispatcher.forward(request, response);
    }
}
