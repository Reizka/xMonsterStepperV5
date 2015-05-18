/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class UserRequestResult {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    private static final long serialVersionUID = 2L;
	private String mExtraValue;
	private Integer mResult;
	 
    public static Integer SUCCESS = 1; 
    public static Integer FAIL = 0;

    public UserRequestResult() {
    }

	public UserRequestResult(Integer result, String extra){

		mResult = result;
		mExtraValue = extra;

	}
        
        
        public int getResult(){
		return mResult;
	}
	
	public String getExtra(){
		return mExtraValue;
	}
        
}
