/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Player;
import entityBeans.CaloriesBurnedFacade;
import entityBeans.PlayerFacade;
import entityBeans.StepsTakenCounterFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Renny
 */
@Stateless
public class PlayerExpCalculatorBean {
    @EJB
    private CaloriesBurnedFacade cbfacade;
    @EJB
    private PlayerFacade pFacade;
    @EJB
    private StepsTakenCounterFacade stcf;

   public void calculateEXP(int caloriesBurned, int playerID){
   
       Player player;
       player = pFacade.find(playerID);
       
       int expTotal;
       if(player.getExp()!=null){expTotal = player.getExp();}
       else{expTotal=0;}
       //might add a fancy exp calculation algorithm later (doubtfull)
       int expGained = caloriesBurned;
       expTotal += expGained;
       player.setExp(expTotal);
       pFacade.create(player);
       System.out.println("caloriesBurned: " +caloriesBurned );
       System.out.println("EXP GAINED: " + expGained +" EXPTOTAL: "+expTotal);
       
   }
}
