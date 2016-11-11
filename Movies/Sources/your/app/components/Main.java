package your.app.components;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;

import ch.filme.Movie;
import ch.filme._Movie;
import er.extensions.eof.ERXFetchSpecification;

public class Main extends BaseComponent {
	private String filmTitel = null;
	private String filmStudio;
	private String filmRegisseur;
	private String movie;
	
	 
	 public String getMovie() {
		 if(filmTitel != null)
		 {
		 EOQualifier qualifier = Movie.TITLE.eq(filmTitel);
		 Movie movie = Movie.fetchMovie(session().defaultEditingContext(), qualifier);
		 String movieName = movie.title();
		 setMovie(movieName);
			return movieName;
		 }
		 
		 return "";

	}

	public void setMovie(String movie) {
		this.movie = movie;
	}



	public String getFilmTitel() {
		return filmTitel;
	}
	public void setFilmTitel(String filmTitel) {
		this.filmTitel = filmTitel;
	}
	public String getFilmStudio() {
		return filmStudio;
	}
	public void setFilmStudio(String filmStudio) {
		this.filmStudio = filmStudio;
	}
	public String getFilmRegisseur() {
		return filmRegisseur;
	}
	public void setFilmRegisseur(String filmRegisseur) {
		this.filmRegisseur = filmRegisseur;
	}
	public Main(WOContext context) {
		super(context);
		
	}
	
	public void letsgo()
	{
		
	}
	
	

}
