/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityBeans;

import entities.StepsTakenCounter;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Renny
 */
@Stateless
public class StepsTakenCounterFacade extends AbstractFacade<StepsTakenCounter> {
    @PersistenceContext(unitName = "xMonsterStepperV5PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StepsTakenCounterFacade() {
        super(StepsTakenCounter.class);
    }
    
}
