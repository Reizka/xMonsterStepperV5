/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Player;
import entities.StepsTakenCounter;
import entityBeans.CaloriesBurnedFacade;
import entityBeans.PlayerFacade;
import entityBeans.StepsTakenCounterFacade;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

/**
 *
 * @author Renny
 */
@Stateless
public class MonsterMoneyCalculatorBean {

   @EJB
    private CaloriesBurnedFacade cbfacade;
    @EJB
    private PlayerFacade pFacade;
    @EJB
    private StepsTakenCounterFacade stcf;
    
    
    public void calculateMoney(int stepsTaken, int playerID){
    StepsTakenCounter stc = new StepsTakenCounter();
    //find the player
    Player player;
    player = pFacade.find(playerID);
    
    //calculating the monsterMoney gained from stepsTaken
    // might add a fancie calculation method later on if there is time (doubtful)
    int mMoney = 2%stepsTaken;
    int pMoney;
    if(player.getMonsterMoney()!=null){pMoney = player.getMonsterMoney();}
    else{pMoney =0;}
    player.setMonsterMoney(mMoney+pMoney);
    //updating the entity
    pFacade.edit(player);
    
    }
    
}
