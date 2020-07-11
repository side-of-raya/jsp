package controllers;

import java.util.List;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MenDAO;
import model.Man;

@WebServlet(name = "AllMen", value = "/getMen")
public class getMen extends HttpServlet {
  @Override
  protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
  throws ServletException, IOException {
    List<Man> result = null;
    try {
      result = MenDAO.getAll();
      for (Man obj : result) {
        System.out.print(obj.getName());
      }
    } catch (final Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.print(result.size());
    // String name = request.getParameter("double_kek");
    request.setAttribute("list", result);
    getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
  }

//    @Override
//    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
//            throws ServletException, IOException {
//        this.doGet(request, response);
//    }
 
}