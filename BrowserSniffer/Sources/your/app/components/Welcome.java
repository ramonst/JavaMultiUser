package your.app.components;

import com.webobjects.appserver.WOContext;

import er.extensions.appserver.ERXRequest;
import your.app.Application;

import com.webobjects.appserver.WOComponent;

public class Welcome extends WOComponent {
	ERXRequest browserName;
	WOComponent previousPage;
	
	public void setPreviousPage(WOComponent prev)
	{
		previousPage = prev;
	}
	
	public WOComponent getPreviousPage()
	{
		Application application = (Application)Application.application();
		application.incrementBackCounter();
		
		return previousPage;
	}
	
    public Welcome(WOContext context) {
        super(context);
        browserName = (ERXRequest) context.request();
    }
    
    public String getBrowserName()
    {
    	return browserName.headerForKey("user-agent");
    }
}