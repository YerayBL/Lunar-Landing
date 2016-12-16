/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entities.YblScores;
import Services.ScoresService;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yeray
 */
public class ServletGame extends HttpServlet {

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
          response.setContentType("text/html;charset=UTF-8");

        ServletContext context = getServletContext();
        EntityManagerFactory emf = (EntityManagerFactory) context.getAttribute("emf");
        EntityManager em = emf.createEntityManager();
        ScoresService ss = new ScoresService(em);

        List<YblScores> maxUsuarios = ss.topSc();
        List<YblScores> lastConect = ss.lastConex();

        request.setAttribute("primero", "1-" + maxUsuarios.get(0).getUsId().getUser() + " (" + maxUsuarios.get(0).getScore() + ")");
        request.setAttribute("segundo", "2-" + maxUsuarios.get(1).getUsId().getUser() + " (" + maxUsuarios.get(1).getScore() + ")");
        request.setAttribute("tercero", "3-" + maxUsuarios.get(2).getUsId().getUser() + " (" + maxUsuarios.get(2).getScore() + ")");

        request.setAttribute("last", " " + lastConect.get(0).getUsId().getUser() + " (" + lastConect.get(0).getEndDate() + ")");
        request.setAttribute("last2", " " + lastConect.get(1).getUsId().getUser() + " (" + lastConect.get(1).getEndDate() + ")");
        request.setAttribute("last3", " " + lastConect.get(2).getUsId().getUser() + " (" + lastConect.get(2).getEndDate() + ")");

        RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/pages/game.jsp");
        rd.forward(request, response);
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
        Date inicio = new Date(request.getParameter("inicio"));
        Date fin = new Date(request.getParameter("fin"));
        int usuario = Integer.parseInt(request.getParameter("usuario"));
        Double score = Double.parseDouble(request.getParameter("score"));

        ServletContext context = getServletContext();
        EntityManagerFactory emf = (EntityManagerFactory) context.getAttribute("emf");
        EntityManager em = emf.createEntityManager();
        ScoresService ss = new ScoresService(em);

        ss.actScore(inicio, fin, usuario, score);

        processRequest(request, response);
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
