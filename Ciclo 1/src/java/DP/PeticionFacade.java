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
import MD.Usuario;
import MD.Idioma;
import MD.Idioma;
import java.util.Collection;

/**
 *
 * @author ALIENWARE
 */
@Stateless
public class PeticionFacade extends AbstractFacade<Peticion> {

    @PersistenceContext(unitName = "Ciclo_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PeticionFacade() {
        super(Peticion.class);
    }

    public boolean isUsuarioCollectionEmpty(Peticion entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Peticion> peticion = cq.from(Peticion.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(peticion, entity), cb.isNotEmpty(peticion.get(Peticion_.usuarioCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Usuario> findUsuarioCollection(Peticion entity) {
        return this.getMergedEntity(entity).getUsuarioCollection();
    }

    public boolean isDestinoPeEmpty(Peticion entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Peticion> peticion = cq.from(Peticion.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(peticion, entity), cb.isNotNull(peticion.get(Peticion_.destinoPe)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Idioma findDestinoPe(Peticion entity) {
        return this.getMergedEntity(entity).getDestinoPe();
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
    
}
