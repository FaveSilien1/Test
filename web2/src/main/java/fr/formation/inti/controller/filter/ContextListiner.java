package fr.formation.inti.controller.filter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Application Lifecycle Listener implementation class ContextListiner
 *
 */
@WebListener
public class ContextListiner implements ServletContextListener {
	private static final Log log=LogFactory.getLog(FilterLog.class);

    /**
     * Default constructor. 
     */
    public ContextListiner() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
       log.debug("----------------------- the application stopped");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
        log.debug("--------------------- the application started");
    }
	
}
