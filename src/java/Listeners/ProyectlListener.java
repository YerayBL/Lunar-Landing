package Listeners;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Web application lifecycle listener.
 *
 * @author juanj
 */
@WebListener()
public class ProyectlListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LunarLandingPU");
        arg0.getServletContext().setAttribute("emf", emf);
        
       
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        EntityManagerFactory emf = (EntityManagerFactory) arg0.getServletContext().getAttribute("emf");
        emf.close();
    }
}
