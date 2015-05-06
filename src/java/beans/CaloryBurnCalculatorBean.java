/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import static com.sun.xml.ws.security.addressing.impl.policy.Constants.logger;
import entities.CaloriesBurned;
import entities.Player;
import entities.StepsTakenCounter;
import entityBeans.CaloriesBurnedFacade;
import entityBeans.PlayerFacade;
import entityBeans.StepsTakenCounterFacade;
import java.sql.Date;
import java.util.Calendar;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Renny
 */
@Stateless
public class CaloryBurnCalculatorBean {

    @EJB
    private CaloriesBurnedFacade cbfacade;
    @EJB
    private PlayerFacade pFacade;
    @EJB
    private StepsTakenCounterFacade stcf;

    public void calculateKcalBurn(int steps, int playerID) {
        // get today's date
        java.sql.Date timeNow = new Date(Calendar.getInstance().getTimeInMillis());
        //find the right entity using cbfacade and set it to a container

        CaloriesBurned cb = new CaloriesBurned();
        Player player = new Player(); 
        player = pFacade.find(playerID);
        //StepsTakenCounter stc = stcf.find(player);

            //calculate the burned calory amount
        double caloryBurned;
        double duration = 1;// 1 hour
        double weight = player.getWeight();
        /*
         METABOLIC EQUIVALENT (MET) VALUES FOR ACTIVITIES IN AMERICAN TIME USE SURVEY (ATUS)
         http://appliedresearch.cancer.gov/atus-met/met.php
         */
        double METS = 3.80;
        caloryBurned = 1.05 * METS * duration * weight;
        int cBurnedInt = (int) caloryBurned;
        
        cb.setKcalBurned(cBurnedInt);
        cb.setDay(timeNow);
        cb.setPlayerPhone(player);
        
        cbfacade.create(cb);
        System.out.println("calory calc was succesfull!");
    }

    
}
