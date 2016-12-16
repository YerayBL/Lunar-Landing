/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.YblUsers;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author yeray
 */
public class UsersService {

    EntityManager em;

    public UsersService(EntityManager em) {
        this.em = em;
    }

    //Métodos para Login
    public String buscarID(String us) {

        String userID = "";
        Query existeUsuarioQuery = em.createQuery("SELECT yu FROM YblUsers yu WHERE yu.user = :us")
                .setParameter("user", us);

        try {
            YblUsers usuario = (YblUsers) existeUsuarioQuery.getSingleResult();
            userID = "" + usuario.getId();
        } catch (NoResultException e) {
        }
        return userID;
    }

    public boolean validarLogin(String us, String passwd) {

        boolean resultado = false;
        Query existeUsuarioQuery = em.createQuery("SELECT yu FROM YblUsers yu WHERE yu.user = :us")
                .setParameter("user", us);
        YblUsers usuario = null;

        try {
            usuario = (YblUsers) existeUsuarioQuery.getSingleResult();
        } catch (NoResultException e) {
        }

        if (usuario != null && usuario.getPasswd().equals(passwd)) {
            resultado = true;
        }
        return resultado;
    }

    public boolean existeUsuario(String us) {

        Query existeUsuarioQuery = em.createQuery("SELECT yu FROM YblUsers yu WHERE yu.user = :us")
                .setParameter("user", us);
        YblUsers usuario = (YblUsers) existeUsuarioQuery.getSingleResult();
        return true;
    }

    //Métodos para registro
      public boolean validarUser(String us) {
        boolean resultado = false;

        Query existeUsuarioQuery = em.createQuery("SELECT yu FROM YblUsers yu WHERE yu.user = :us")
                .setParameter("user", us);

        YblUsers usuario = null;

        try {
            usuario = (YblUsers) existeUsuarioQuery.getSingleResult();
        } catch (NoResultException e) {
        }

        if (usuario != null && usuario.getUser().equals(us)) {
            resultado = true;
        }
        return resultado;
    }
      
      public void addUser(String us, String passwd) {
            em.getTransaction().begin();
            YblUsers user = new YblUsers();
            user.setUser(us);
            user.setPasswd(passwd);
            em.persist(user);
            em.getTransaction().commit();
            em.close();
    }
}
