package com.ethertion.lab.webapp.action;

import org.springframework.webflow.action.FormAction;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

/**
 *
 * @author amiguel
 */
public class BaseAction extends FormAction{
        
        public Event setUp(RequestContext context) throws Exception {
                return success();
        }
       
}
