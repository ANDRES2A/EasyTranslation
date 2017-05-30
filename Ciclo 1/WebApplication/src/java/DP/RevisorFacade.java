/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

import MD.Revisor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import MD.Revisor_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import MD.Idioma;
import java.util.Collection;

/**
 *
 * @author ALIENWARE
 */
@Stateless
public class RevisorFacade extends AbstractFacade<Revisor> {

    @PersistenceContext(unitName = "WebApplicationPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RevisorFacade() {
        super(Revisor.class);
    }

    public boolean isIdiomaCollectionEmpty(Revisor entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Revisor> revisor = cq.from(Revisor.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(revisor, entity), cb.isNotEmpty(revisor.get(Revisor_.idiomaCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Idioma> findIdiomaCollection(Revisor entity) {
        return this.getMergedEntity(entity).getIdiomaCollection();
    }
    
}
