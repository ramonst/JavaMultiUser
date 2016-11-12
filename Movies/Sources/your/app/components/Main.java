package your.app.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSMutableArray;

import ch.filme.Movie;
import ch.filme.Studio;
import ch.filme.Talent;

public class Main extends BaseComponent {
	private String suchFilmTitel = "";
	private String suchFilmStudio = "";
	private String suchFilmRegisseur = "";
	private NSMutableArray<Movie> movieResult;
	private Movie loopvar = null;
	private Talent talentLoop = null;
	private String regName;
	
	public String getRegName() {
		return talentLoop.firstName() + " "+talentLoop.lastName();
	}

	public void setRegName(String regName) {
		this.regName = regName;
	}

	public Talent getTalentLoop() {
		return talentLoop;
	}

	public void setTalentLoop(Talent talentLoop) {
		this.talentLoop = talentLoop;
	}
	private String foundReg;
	private Movie movie;


	 
	 public Movie getLoopvar() {
		return loopvar;
	}

	public void setLoopvar(Movie loopvar) {
		this.loopvar = loopvar;
	}

	public NSMutableArray<Movie> getMovieResult() {
		return movieResult;
	}

	public void setMovieResult(NSMutableArray<Movie> movieResult) {
		this.movieResult = movieResult;
	}

	//SUCHEN
	public String getSuchFilmTitel() {
		return suchFilmTitel;
	}

	public void setSuchFilmTitel(String suchFilmTitel) {
		this.suchFilmTitel = suchFilmTitel;
	}

	public String getSuchFilmStudio() {
		return suchFilmStudio;
	}

	public void setSuchFilmStudio(String suchFilmStudio) {
		this.suchFilmStudio = suchFilmStudio;
	}

	public String getSuchFilmRegisseur() {
		return suchFilmRegisseur;
	}

	public void setSuchFilmRegisseur(String suchFilmRegisseur) {
		this.suchFilmRegisseur = suchFilmRegisseur;
	}

	
	
	public Main(WOContext context) {
		super(context);
		movieResult = new NSMutableArray<Movie>();

	}
	
	public Boolean searched()
	{
		if(movieResult.isEmpty())
			return false;
		else
			return true;
	}
	
	public void loadSpecs()
	{
		
		EOQualifier filmQuali = Movie.TITLE.contains(suchFilmTitel);
		//EOQualifier studioQual = Movie.STUDIO.like(suchFilmStudio);		
		//EOQualifier qualifier = Movie.TITLE.dot(Movie.TITLE.contains(suchFilmTitel).and(Movie.STUDIO.contains(suchFilmStudio)));
		EOQualifier qualifier = Movie.STUDIO.dot(Studio.NAME.contains(suchFilmStudio));
		movieResult = (NSMutableArray<Movie>) Movie.fetchMovies(session().defaultEditingContext(), filmQuali, null);
		//movieResult = (NSMutableArray<Movie>) EOQualifier.filteredArrayWithQualifier(movieResult, filmQuali);
		
	}

	public void getFoundReg() {

	
	}
	
	public void setFoundReg(String foundReg) {
		this.foundReg = foundReg;
	}
	

	
	//output

	

	
//	public String getMovie() {
//	 if(filmTitel != null)
//	 {
//		 EOQualifier qualifier = Movie.TITLE.eq(filmTitel);
//		 Movie movie = Movie.fetchMovie(session().defaultEditingContext(), qualifier);
//		 String movieName = movie.title();
//		 setMovie(movieName);
//		 return movieName;
//	 }
//	 
//	 return "";
//}

}
