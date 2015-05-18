/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userManagement;

import java.io.Serializable;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author epiphany
 */
public class ValidationInterceptor implements Serializable {

    @AroundInvoke
    public Object validate(InvocationContext context) throws Exception {

        System.out.println("ValidationInterceptor");

        Object parameters[] = context.getParameters();

        for (int i = 0; i < parameters.length; i++) {
            System.out.println("Before: [" + (String) parameters[i] + "]");
            parameters[i] = ((String) parameters[i]).trim();
            System.out.println("After: [" + (String) parameters[i] + "]");
        }

        context.setParameters(parameters);

        // get the Message data from context data
        String msg = (String) context.getContextData().get("Message");
        System.out.println("ValidationInterceptor: Message value is now " + msg);

        // update the Message data
        context.getContextData().put("Message", "Hello back from ValidationInterceptor");

        // proceed with the target object's method call
        Object result = context.proceed();

        return result;
    }
    
}
