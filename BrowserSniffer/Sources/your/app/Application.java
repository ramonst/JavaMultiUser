package your.app;

import er.extensions.appserver.ERXApplication;

public class Application extends ERXApplication {
	
	private int mainPageCounter;
	private int sessionCounter;
	private int backCounter;
	public static void main(String[] argv) {
		ERXApplication.main(argv, Application.class);
	}

	public Application() {
		ERXApplication.log.info("Welcome to " + name() + " !");
		/* ** put your initialization code in here ** */
		setAllowsConcurrentRequestHandling(true);		
		
		mainPageCounter=0;
		sessionCounter=0;
		backCounter=0;
	}
	

	
	public void incrementBackCounter()
	{
		backCounter++;
	}
	
	public void decrementSessionCounter()
	{
		sessionCounter --;
	}
	
	public String backCounter()
	{
		return "BackCounter = "+ backCounter;
	}
	
	public String sessionCounter()
	{
		return "SessionCounter = " +sessionCounter;
	}
	
	public void incrementSessionCounter()
	{
		sessionCounter++;
	}
	
	public String mainPageCounter()
	{
		return "MainPageCounter = " +mainPageCounter;
	}
	
	public void incrementMainPageCounter()
	{
		mainPageCounter++;
	}
}
