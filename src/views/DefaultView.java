package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import controllers.DefaultController;
import core.Model;
import core.View;
import exceptions.NonExistentConfigFileException;

@SuppressWarnings("serial")
public class DefaultView extends JPanel implements View
{
	
	private DefaultController defaultController;
	private JFrame mainFrame;
	private final static int MAIN_FRAME_WIDTH = 500;
	private final static int MAIN_FRAME_HEIGHT = 350;
	private final static int MAIN_FRAME_X = 100;
	private final static int MAIN_FRAME_Y = 100;
	
	private static Logger LOGGER;

	  static {
	      String path = DefaultView.class.getClassLoader()
	                                  .getResource("logging.properties")
	                                  .getFile();
	      System.setProperty("java.util.logging.config.file", path);
	      LOGGER = Logger.getLogger(DefaultView.class.getName());
	      
	      try {  

	          // This block configure the logger with handler and formatter  
	          FileHandler fh = new FileHandler("mvclogfile.log");  
	          LOGGER.addHandler(fh);
	          SimpleFormatter formatter = new SimpleFormatter();  
	          fh.setFormatter(formatter);  


	      } catch (SecurityException e) {  
	        throw new RuntimeException(new NonExistentConfigFileException(e.getMessage()));
	      } catch (IOException e) {  
	    	  throw new RuntimeException(new NonExistentConfigFileException(e.getMessage()));  
	      }  	      
	  }	
	
	public DefaultView(DefaultController defaultController, JFrame mainFrame)
	{
		LOGGER.info("DefaultView constructor");
		this.defaultController = defaultController;
		this.mainFrame = mainFrame;
		
		make_mainFrame();
		make_tabs();
	}

	public void update(Model model, Object data) {	
	}

	private void make_mainFrame()
	{
		LOGGER.info("Making main frame");
		mainFrame.setOpacity(1.0f);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setBounds(MAIN_FRAME_X, MAIN_FRAME_Y, MAIN_FRAME_WIDTH, MAIN_FRAME_HEIGHT);
		mainFrame.setMinimumSize(new Dimension(MAIN_FRAME_WIDTH, MAIN_FRAME_HEIGHT));
		
		
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));
	}

	private void make_tabs()
	{
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("New event", defaultController.getNewEventView());
		tabbedPane.addTab("Events", defaultController.getEventListView());
		add(tabbedPane, BorderLayout.CENTER);
	}
}
