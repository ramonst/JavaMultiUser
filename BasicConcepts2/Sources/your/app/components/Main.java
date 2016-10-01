package your.app.components;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSTimestamp;

public class Main extends BaseComponent {
	public Main(WOContext context) {
		super(context);
	}
	
	public NSTimestamp systemZeit()
	{
		return new NSTimestamp();
	}
	
	public Welcome sayHi()
	{
		Welcome nextPage = pageWithName(Welcome.class);
		return nextPage;
	}
	
	public WOComponent reload()
	{
		return null;
	}
}
