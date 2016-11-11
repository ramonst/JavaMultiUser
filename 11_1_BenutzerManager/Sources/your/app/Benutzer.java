package your.app;

public class Benutzer {

	private String name;
	private String vorname;
	private String anrede;
	private String login;
	private String passwort;
	private boolean admin;
	
	public String name() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String vorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String anrede()	{
		return anrede;
	}
	public void setAnrede(String anrede){
		this.anrede = anrede;
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
	public boolean admin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
}
