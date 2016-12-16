/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.YblScores;
import Entities.YblUsers;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author yeray
 */
public class ScoresService {

    protected EntityManager em;

    public ScoresService(EntityManager em) {
        this.em = em;
    }

    public void actScore(Date inicio, Date fin, int usuario, Double score) {
        
        em.getTransaction().begin();
        YblScores ys = new YblScores();
        ys.setIniDate(inicio);
        ys.setEndDate(fin);
        ys.setUsId(buscarID(usuario));
        ys.setScore(score);
        em.persist(ys);
        em.getTransaction().commit();
        em.close();
    }

    public List<YblScores> topSc() {

        List<YblScores> usuariosMax = null;
        Query scoreUser = em.createQuery("select ys from YblScores ys join fetch ys.us_id order by ys.score DESC").setMaxResults(3);

        try {
            usuariosMax = (List<YblScores>) scoreUser.getResultList();
        } catch (NoResultException e) {
        }
        return usuariosMax;
    }

    public List<YblScores> lastConex() {
        
        List<YblScores> lConex = null;
        Query scoreUser = em.createQuery("select ys from YblScores ys join fetch ys.us_id order by ys.end_date DESC").setMaxResults(3);

        try {
            lConex = (List<YblScores>) scoreUser.getResultList();
        } catch (NoResultException e) {
        }
        return lConex;
    }

    public YblUsers buscarID(int id) {
        
        YblUsers usuario = null;
        Query existeUsuarioQuery = em.createQuery("SELECT yu FROM YblUsers  yu WHERE yu.id = :id")
                .setParameter("id", id);

        try {
            usuario = (YblUsers) existeUsuarioQuery.getSingleResult();
        } catch (NoResultException e) {
        }

        return usuario;
    }
    
}
