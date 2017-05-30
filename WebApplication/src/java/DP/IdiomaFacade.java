/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

import MD.Idioma;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import MD.Idioma_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import MD.Usuario;
import MD.Peticion;
import MD.Peticion;
import java.util.Collection;

/**
 *
 * @author ALIENWARE
 */
@Stateless
public class IdiomaFacade extends AbstractFacade<Idioma> {

    @PersistenceContext(unitName = "WebApplicationPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IdiomaFacade() {
        super(Idioma.class);
    }

    public boolean isUsuarioCollectionEmpty(Idioma entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Idioma> idioma = cq.from(Idioma.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(idioma, entity), cb.isNotEmpty(idioma.get(Idioma_.usuarioCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Usuario> findUsuarioCollection(Idioma entity) {
        return this.getMergedEntity(entity).getUsuarioCollection();
    }

    public boolean isPeticionCollectionEmpty(Idioma entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Idioma> idioma = cq.from(Idioma.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(idioma, entity), cb.isNotEmpty(idioma.get(Idioma_.peticionCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Peticion> findPeticionCollection(Idioma entity) {
        return this.getMergedEntity(entity).getPeticionCollection();
    }

    public boolean isPeticionCollection1Empty(Idioma entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Idioma> idioma = cq.from(Idioma.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(idioma, entity), cb.isNotEmpty(idioma.get(Idioma_.peticionCollection1)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Peticion> findPeticionCollection1(Idioma entity) {
        return this.getMergedEntity(entity).getPeticionCollection1();
    }
    
}
