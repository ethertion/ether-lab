package com.ethertion.lab.webapp.action;


import java.util.HashMap;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

/**
 *
 * @author amiguel
 */
public class LoginAction extends BaseAction implements ApplicationContextAware{      
        
        private ApplicationContext appContext;
        
        private HashMap credentials = null;
        
        @Override
        public Event setUp(RequestContext context) throws Exception {   
                credentials = new HashMap();
                return success();
        }
        
        public Event authorize (RequestContext context) throws Exception {
                String login = context.getRequestParameters().get("login");
                //TODO: authorization logic  
                context.getFlowScope().put("authorized", Boolean.TRUE);                              
                return success();
        }

        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		appContext = applicationContext;		
	}

        public ApplicationContext getAppContext() {
                return appContext;
        }

        public void setAppContext(ApplicationContext appContext) {
                this.appContext = appContext;
        }
        
}
