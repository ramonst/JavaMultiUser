package your.app.components;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSTimestamp;

import er.extensions.appserver.ERXRequest;
import er.extensions.appserver.ERXResponse;
import er.extensions.components.ERXComponent;
import er.extensions.components.ERXResponseComponent;

public class Main extends BaseComponent {

	public Main(WOContext context) {
		super(context);
		application().incrementMainPageCounter();
	}
	
	public NSTimestamp systemZeit()
	{
		return new NSTimestamp();
	}
	
	public Welcome sayHi()
	{
		
		Welcome nextPage = pageWithName(Welcome.class);
		nextPage.setPreviousPage(this);
		return nextPage;
	}
	

	public WOComponent reload()
	{
		return null;
		
	}
	
	public Main terminateSession()
	{
		session().terminate();
		application().decrementSessionCounter();
		Main nextPage = pageWithName(Main.class);
		return nextPage;
	}
	
	public String getBrowserName()
	{
		String name;
		
		name = this.browser().browserName().toLowerCase();
		
		name += ".png";	
		return name;
	}

}