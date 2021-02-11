package controllers;

import java.awt.Component;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.JFrame;

import core.Controller;
import exceptions.IncorrectStructureException;
import views.DefaultView;

public abstract class DefaultController extends Controller 
{
	private static Logger LOGGER;

	  static {
	      String path = DefaultController.class.getClassLoader()
	                                  .getResource("logging.properties")
	                                  .getFile();
	      System.setProperty("java.util.logging.config.file", path);
	      LOGGER = Logger.getLogger(DefaultController.class.getName());
	      
	      try {  

	          // This block configure the logger with handler and formatter  
	          FileHandler fh = new FileHandler("mvclogfile.log");  
	          LOGGER.addHandler(fh);
	          SimpleFormatter formatter = new SimpleFormatter();  
	          fh.setFormatter(formatter);  


	      } catch (SecurityException e) {  
	          e.printStackTrace();  
	      } catch (IOException e) {  
	          e.printStackTrace();  
	      }  	      
	  }	
	  
	  protected DefaultView defaultView;
	
	@Override
	public void run() throws IncorrectStructureException
	{
		LOGGER.info("Running DefaultController-Run function");
		// Initializes others controllers
		initControllers();
		
		// Initializes HomeView
		initDefaultView( mainFrame  );
		
		if ( this.defaultView == null ) {
			throw new IncorrectStructureException("Default view was not created !!!");
		}
		
		// Displays the program window
		mainFrame.setVisible(true);
		LOGGER.info("Finishing DefaultController-RunFunction");
	}
	
	protected abstract void initControllers();
	
	protected abstract void initDefaultView( JFrame frame );
	
	public abstract Component getEventListView();
	
	public abstract Component getNewEventView();
	
}
