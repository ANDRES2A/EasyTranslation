/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

import MD.Peticion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import MD.Peticion_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import MD.Idioma;
import MD.Idioma;
import MD.Usuario;

/**
 *
 * @author ALIENWARE
 */
@Stateless
public class PeticionFacade extends AbstractFacade<Peticion> {

    @PersistenceContext(unitName = "WebApplicationPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PeticionFacade() {
        super(Peticion.class);
    }

    public boolean isAbreviacionIdEmpty(Peticion entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Peticion> peticion = cq.from(Peticion.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(peticion, entity), cb.isNotNull(peticion.get(Peticion_.abreviacionId)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Idioma findAbreviacionId(Peticion entity) {
        return this.getMergedEntity(entity).getAbreviacionId();
    }

    public boolean isIdiAbreviacionIdEmpty(Peticion entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Peticion> peticion = cq.from(Peticion.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(peticion, entity), cb.isNotNull(peticion.get(Peticion_.idiAbreviacionId)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Idioma findIdiAbreviacionId(Peticion entity) {
        return this.getMergedEntity(entity).getIdiAbreviacionId();
    }

    public boolean isCorreoUsEmpty(Peticion entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Peticion> peticion = cq.from(Peticion.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(peticion, entity), cb.isNotNull(peticion.get(Peticion_.correoUs)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Usuario findCorreoUs(Peticion entity) {
        return this.getMergedEntity(entity).getCorreoUs();
    }
    
}
