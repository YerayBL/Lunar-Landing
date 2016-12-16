/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Services.UsersService;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yeray
 */
public class ServletLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        ServletContext context = getServletContext();
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/pages/index.jsp");
        rd.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        ServletContext context = getServletContext();
        EntityManagerFactory emf = (EntityManagerFactory) context.getAttribute("emf");
        EntityManager em = emf.createEntityManager();
        UsersService loginService = new UsersService(em);
        String user = request.getParameter("user").toLowerCase();
        String pass = request.getParameter("pass");
        
          if (loginService.validarLogin(user, pass)) {
            request.getSession().setMaxInactiveInterval(15 * 60); // 15 min
            request.getSession().setAttribute("user", user);
            String userID = loginService.buscarID(user);
            response.addCookie(new Cookie("userId", userID));
            response.sendRedirect(request.getContextPath() + "/Game");
        } else {
            request.setAttribute("errorMessage", "Usuario o contraseña incorrectos.");
            RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/pages/index.jsp");
            rd.forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
