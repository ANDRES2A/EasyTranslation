/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

import MD.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import MD.Usuario_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import MD.Revisor;
import MD.Idioma;
import java.util.Collection;

/**
 *
 * @author ALIENWARE
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "WebApplicationPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    public boolean isRevisorCollectionEmpty(Usuario entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Usuario> usuario = cq.from(Usuario.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(usuario, entity), cb.isNotEmpty(usuario.get(Usuario_.revisorCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Revisor> findRevisorCollection(Usuario entity) {
        return this.getMergedEntity(entity).getRevisorCollection();
    }

    public boolean isIdiomaCollectionEmpty(Usuario entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Usuario> usuario = cq.from(Usuario.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(usuario, entity), cb.isNotEmpty(usuario.get(Usuario_.idiomaCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Idioma> findIdiomaCollection(Usuario entity) {
        return this.getMergedEntity(entity).getIdiomaCollection();
    }

    @Override
    public Usuario findWithParents(Usuario entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Usuario> cq = cb.createQuery(Usuario.class);
        Root<Usuario> usuario = cq.from(Usuario.class);
        usuario.fetch(Usuario_.idiomaCollection, JoinType.LEFT);
        cq.select(usuario).where(cb.equal(usuario, entity));
        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            return entity;
        }
    }
    
}
