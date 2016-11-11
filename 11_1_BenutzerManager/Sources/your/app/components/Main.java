package your.app.components;

import your.app.Benutzer;

import com.webobjects.appserver.WOContext;

public class Main extends BaseComponent {
	
	public Main(WOContext context) {
		super(context);
	}

	private String login;
	private String passwort;
	private String message;
	
	public BenutzerSeite go() {
		Benutzer b = application().findBenutzer(login, passwort);
		if (b == null) {
			message = "Ungültiges Login!";
			return null;
		}
		else {
			session().setBenutzer(b);
		}
		return pageWithName(BenutzerSeite.class);
	}
	
	public String login() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String passwort() {
		return passwort;
	}
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
	public String message() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
