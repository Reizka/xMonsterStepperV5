/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import entities.Player;
import java.util.List;
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
@Path("entities.player")
public class PlayerFacadeREST extends AbstractFacade<Player> {
    @PersistenceContext(unitName = "xMonsterStepperV5PU")
    private EntityManager em;

    public PlayerFacadeREST() {
        super(Player.class);
    }
    @POST
    @Path("/login")
    @Consumes({"application/xml", "application/json"}) 
    @Produces({"application/xml", "application/json"})
    public String login(Player entity) {
        
        Player player = find(entity.getId());        
        Gson gson = new Gson();
        String json = null;
        
        if(player == null){
        
            json = gson.toJson(new UserRequestResult(0, "There is no such user"));
        
        }else{
            
            if(entity.getPassword().equals(player.getPassword())){
                json = gson.toJson(new UserRequestResult(1, "successToken"));
            }else{
                 json = gson.toJson(new UserRequestResult(0, "Password is incorrect"));
            }
            
        }
        
        return json;
    }
    @POST
    @Path("/join")
    @Consumes({"application/xml", "application/json"}) 
    @Produces({"application/xml", "application/json"})
    public String register(Player entity) {
        
        Player player = super.find(entity.getId());        
        
        Gson gson = new Gson();
        String json = null;
       
        if(player == null){
        
         json = gson.toJson(new UserRequestResult(1, ""));
         super.create(entity);
        
        }else{         
            json = gson.toJson(new UserRequestResult(0, "User is already registered"));
        }
               
        return json;
       
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Player entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Player entity) {
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
    public Player find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Player> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Player> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
