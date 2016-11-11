package your.app;


import com.webobjects.foundation.NSMutableArray;

import er.extensions.appserver.ERXApplication;

public class Application extends ERXApplication {
	
	public static void main(String[] argv) {
		ERXApplication.main(argv, Application.class);
	}

	public Application() {
		ERXApplication.log.info("Welcome to " + name() + " !");
		/* ** put your initialization code in here ** */
		setAllowsConcurrentRequestHandling(true);	
		
		// Bei erstem Start, Admin erstellen
		
		benutzerListe = new NSMutableArray<Benutzer>();
		Benutzer benutzer = new Benutzer();
		benutzer.setName("Ramon");
		benutzer.setVorname("Stohr(ADMIN)");
		benutzer.setAnrede("Herr");
		benutzer.setLogin("admin");
		benutzer.setPasswort("admin");
		benutzer.setAdmin(true);
		benutzerListe.add(benutzer);
	}
	
	private NSMutableArray<Benutzer> benutzerListe;

	public void addUser(Benutzer benutzer) {
		if (!benutzerListe.contains(benutzer)) {
			benutzerListe.add(benutzer);
		}
	}
	
	public void removeBenutzer(Benutzer benutzer) {
		benutzerListe.remove(benutzer);
	}
	
	public Benutzer findBenutzer(String login, String passwort) {
		if (login == null) {
			login = "";
		}
		if (passwort == null) {
			passwort = "";
		}
		for (Benutzer b : benutzerListe) {
			if (login.equals(b.login()) && passwort.equals(b.passwort())) {
				return b;
			}
		}
		return null;
	}
	
	public boolean CheckForDoubleBenutzer(String benutzer)
	{
		for(Benutzer b : benutzerListe)
		{
			if(b.name().equals(benutzer))
				return true;
		}
		
		return false;
	}
	
	public NSMutableArray<Benutzer> benutzerListe() {
		return benutzerListe;
	}

	public void setBenutzerListe(NSMutableArray<Benutzer> benutzerListe) {
		this.benutzerListe = benutzerListe;
	}


}
