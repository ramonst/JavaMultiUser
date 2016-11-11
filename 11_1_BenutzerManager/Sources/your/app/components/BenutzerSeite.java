package your.app.components;

import your.app.Benutzer;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

public class BenutzerSeite extends BaseComponent {

	public BenutzerSeite(WOContext context) {
		super(context);
	}

	private Benutzer benutzerLoopvar;
	private Benutzer currentBenutzer;
	private String message;

	public WOComponent edit() {
		currentBenutzer = benutzerLoopvar;
		return null;
	}
	
	public WOComponent neu() {
		currentBenutzer = new Benutzer();
		return null;
	}
	
	public WOComponent loeschen() {
		if (currentBenutzer != null) {
			application().removeBenutzer(currentBenutzer);
			currentBenutzer = null;
		}
		return null;
	}
	
	public WOComponent speichern() {
		if (alleEingabenOk()) {
			application().addUser(currentBenutzer);
			currentBenutzer = null;	
			message = "OK";
		}
		else {
			message = "Bitte alle Mussfelder ausfüllen!";
		}
		return null;
	}
	
	private boolean alleEingabenOk() {
		if(application().CheckForDoubleBenutzer(currentBenutzer.name()))
			return false;
		
		else
			return true;
	}
	
	public Benutzer benutzerLoopvar() {
		return benutzerLoopvar;
	}

	public void setBenutzerLoopvar(Benutzer benutzerLoopvar) {
		this.benutzerLoopvar = benutzerLoopvar;
	}

	public Benutzer currentBenutzer() {
		return currentBenutzer;
	}

	public void setCurrentBenutzer(Benutzer currentBenutzer) {
		this.currentBenutzer = currentBenutzer;
	}

	public String message() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


}
