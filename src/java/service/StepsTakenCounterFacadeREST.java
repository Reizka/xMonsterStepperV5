/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import beans.CaloryBurnCalculatorBean;
import beans.MonsterMoneyCalculatorBean;
import beans.PlayerExpCalculatorBean;
import entities.Player;
import entities.StepsTakenCounter;
import entityBeans.CaloriesBurnedFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Renny
 */
@Stateless
@Path("entities.stepstakencounter")
public class StepsTakenCounterFacadeREST extends AbstractFacade<StepsTakenCounter> {
    @PersistenceContext(unitName = "xMonsterStepperV5PU")
    private EntityManager em;
    
    @EJB
    CaloryBurnCalculatorBean cbcb;
    @EJB
    MonsterMoneyCalculatorBean mmcb;
    @EJB 
    PlayerExpCalculatorBean pecb;

    public StepsTakenCounterFacadeREST() {
        super(StepsTakenCounter.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(StepsTakenCounter entity) {

        //Calory calculation bean
        cbcb.calculateKcalBurn( entity.getSteps(),entity.getDuration(), entity.getPlayerPhone().getId());
        //Monster Money calculation bean
        mmcb.calculateMoney(entity.getSteps(),entity.getPlayerPhone().getId());
        //updating total steps for Player entity
        
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, StepsTakenCounter entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public StepsTakenCounter find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<StepsTakenCounter> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<StepsTakenCounter> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
