// DO NOT EDIT.  Make changes to Movie.java instead.
package ch.filme;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;

import er.extensions.eof.*;
import er.extensions.foundation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("all")
public abstract class _Movie extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Movie";

  // Attribute Keys
  public static final ERXKey<String> CATEGORY = new ERXKey<String>("category");
  public static final ERXKey<NSTimestamp> DATE_RELEASED = new ERXKey<NSTimestamp>("dateReleased");
  public static final ERXKey<String> POSTER_NAME = new ERXKey<String>("posterName");
  public static final ERXKey<String> RATED = new ERXKey<String>("rated");
  public static final ERXKey<Double> REVENUE = new ERXKey<Double>("revenue");
  public static final ERXKey<String> TITLE = new ERXKey<String>("title");
  public static final ERXKey<String> TRAILER_NAME = new ERXKey<String>("trailerName");

  // Relationship Keys
  public static final ERXKey<ch.filme.MovieRole> MOVIE_ROLES = new ERXKey<ch.filme.MovieRole>("movieRoles");
  public static final ERXKey<ch.filme.Review> REVIEWS = new ERXKey<ch.filme.Review>("reviews");
  public static final ERXKey<ch.filme.Studio> STUDIO = new ERXKey<ch.filme.Studio>("studio");
  public static final ERXKey<ch.filme.Talent> TALENTS = new ERXKey<ch.filme.Talent>("talents");
  public static final ERXKey<ch.filme.Video> VIDEOS = new ERXKey<ch.filme.Video>("videos");
  public static final ERXKey<ch.filme.Voting> VOTINGS = new ERXKey<ch.filme.Voting>("votings");

  // Attributes
  public static final String CATEGORY_KEY = CATEGORY.key();
  public static final String DATE_RELEASED_KEY = DATE_RELEASED.key();
  public static final String POSTER_NAME_KEY = POSTER_NAME.key();
  public static final String RATED_KEY = RATED.key();
  public static final String REVENUE_KEY = REVENUE.key();
  public static final String TITLE_KEY = TITLE.key();
  public static final String TRAILER_NAME_KEY = TRAILER_NAME.key();

  // Relationships
  public static final String MOVIE_ROLES_KEY = MOVIE_ROLES.key();
  public static final String REVIEWS_KEY = REVIEWS.key();
  public static final String STUDIO_KEY = STUDIO.key();
  public static final String TALENTS_KEY = TALENTS.key();
  public static final String VIDEOS_KEY = VIDEOS.key();
  public static final String VOTINGS_KEY = VOTINGS.key();

  private static final Logger log = LoggerFactory.getLogger(_Movie.class);

  public Movie localInstanceIn(EOEditingContext editingContext) {
    Movie localInstance = (Movie)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String category() {
    return (String) storedValueForKey(_Movie.CATEGORY_KEY);
  }

  public void setCategory(String value) {
    log.debug( "updating category from {} to {}", category(), value);
    takeStoredValueForKey(value, _Movie.CATEGORY_KEY);
  }

  public NSTimestamp dateReleased() {
    return (NSTimestamp) storedValueForKey(_Movie.DATE_RELEASED_KEY);
  }

  public void setDateReleased(NSTimestamp value) {
    log.debug( "updating dateReleased from {} to {}", dateReleased(), value);
    takeStoredValueForKey(value, _Movie.DATE_RELEASED_KEY);
  }

  public String posterName() {
    return (String) storedValueForKey(_Movie.POSTER_NAME_KEY);
  }

  public void setPosterName(String value) {
    log.debug( "updating posterName from {} to {}", posterName(), value);
    takeStoredValueForKey(value, _Movie.POSTER_NAME_KEY);
  }

  public String rated() {
    return (String) storedValueForKey(_Movie.RATED_KEY);
  }

  public void setRated(String value) {
    log.debug( "updating rated from {} to {}", rated(), value);
    takeStoredValueForKey(value, _Movie.RATED_KEY);
  }

  public Double revenue() {
    return (Double) storedValueForKey(_Movie.REVENUE_KEY);
  }

  public void setRevenue(Double value) {
    log.debug( "updating revenue from {} to {}", revenue(), value);
    takeStoredValueForKey(value, _Movie.REVENUE_KEY);
  }

  public String title() {
    return (String) storedValueForKey(_Movie.TITLE_KEY);
  }

  public void setTitle(String value) {
    log.debug( "updating title from {} to {}", title(), value);
    takeStoredValueForKey(value, _Movie.TITLE_KEY);
  }

  public String trailerName() {
    return (String) storedValueForKey(_Movie.TRAILER_NAME_KEY);
  }

  public void setTrailerName(String value) {
    log.debug( "updating trailerName from {} to {}", trailerName(), value);
    takeStoredValueForKey(value, _Movie.TRAILER_NAME_KEY);
  }

  public ch.filme.Studio studio() {
    return (ch.filme.Studio)storedValueForKey(_Movie.STUDIO_KEY);
  }

  public void setStudio(ch.filme.Studio value) {
    takeStoredValueForKey(value, _Movie.STUDIO_KEY);
  }

  public void setStudioRelationship(ch.filme.Studio value) {
    log.debug("updating studio from {} to {}", studio(), value);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      setStudio(value);
    }
    else if (value == null) {
      ch.filme.Studio oldValue = studio();
      if (oldValue != null) {
        removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _Movie.STUDIO_KEY);
      }
    } else {
      addObjectToBothSidesOfRelationshipWithKey(value, _Movie.STUDIO_KEY);
    }
  }

  public NSArray<ch.filme.MovieRole> movieRoles() {
    return (NSArray<ch.filme.MovieRole>)storedValueForKey(_Movie.MOVIE_ROLES_KEY);
  }

  public NSArray<ch.filme.MovieRole> movieRoles(EOQualifier qualifier) {
    return movieRoles(qualifier, null, false);
  }

  public NSArray<ch.filme.MovieRole> movieRoles(EOQualifier qualifier, boolean fetch) {
    return movieRoles(qualifier, null, fetch);
  }

  public NSArray<ch.filme.MovieRole> movieRoles(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<ch.filme.MovieRole> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = ERXQ.equals(ch.filme.MovieRole.MOVIE_KEY, this);

      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        fullQualifier = ERXQ.and(qualifier, inverseQualifier);
      }

      results = ch.filme.MovieRole.fetchMovieRoles(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = movieRoles();
      if (qualifier != null) {
        results = (NSArray<ch.filme.MovieRole>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<ch.filme.MovieRole>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }

  public void addToMovieRoles(ch.filme.MovieRole object) {
    includeObjectIntoPropertyWithKey(object, _Movie.MOVIE_ROLES_KEY);
  }

  public void removeFromMovieRoles(ch.filme.MovieRole object) {
    excludeObjectFromPropertyWithKey(object, _Movie.MOVIE_ROLES_KEY);
  }

  public void addToMovieRolesRelationship(ch.filme.MovieRole object) {
    log.debug("adding {} to movieRoles relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      addToMovieRoles(object);
    }
    else {
      addObjectToBothSidesOfRelationshipWithKey(object, _Movie.MOVIE_ROLES_KEY);
    }
  }

  public void removeFromMovieRolesRelationship(ch.filme.MovieRole object) {
    log.debug("removing {} from movieRoles relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      removeFromMovieRoles(object);
    }
    else {
      removeObjectFromBothSidesOfRelationshipWithKey(object, _Movie.MOVIE_ROLES_KEY);
    }
  }

  public ch.filme.MovieRole createMovieRolesRelationship() {
    EOEnterpriseObject eo = EOUtilities.createAndInsertInstance(editingContext(),  ch.filme.MovieRole.ENTITY_NAME );
    addObjectToBothSidesOfRelationshipWithKey(eo, _Movie.MOVIE_ROLES_KEY);
    return (ch.filme.MovieRole) eo;
  }

  public void deleteMovieRolesRelationship(ch.filme.MovieRole object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Movie.MOVIE_ROLES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllMovieRolesRelationships() {
    Enumeration<ch.filme.MovieRole> objects = movieRoles().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteMovieRolesRelationship(objects.nextElement());
    }
  }

  public NSArray<ch.filme.Review> reviews() {
    return (NSArray<ch.filme.Review>)storedValueForKey(_Movie.REVIEWS_KEY);
  }

  public NSArray<ch.filme.Review> reviews(EOQualifier qualifier) {
    return reviews(qualifier, null, false);
  }

  public NSArray<ch.filme.Review> reviews(EOQualifier qualifier, boolean fetch) {
    return reviews(qualifier, null, fetch);
  }

  public NSArray<ch.filme.Review> reviews(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<ch.filme.Review> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = ERXQ.equals(ch.filme.Review.MOVIE_KEY, this);

      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        fullQualifier = ERXQ.and(qualifier, inverseQualifier);
      }

      results = ch.filme.Review.fetchReviews(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = reviews();
      if (qualifier != null) {
        results = (NSArray<ch.filme.Review>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<ch.filme.Review>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }

  public void addToReviews(ch.filme.Review object) {
    includeObjectIntoPropertyWithKey(object, _Movie.REVIEWS_KEY);
  }

  public void removeFromReviews(ch.filme.Review object) {
    excludeObjectFromPropertyWithKey(object, _Movie.REVIEWS_KEY);
  }

  public void addToReviewsRelationship(ch.filme.Review object) {
    log.debug("adding {} to reviews relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      addToReviews(object);
    }
    else {
      addObjectToBothSidesOfRelationshipWithKey(object, _Movie.REVIEWS_KEY);
    }
  }

  public void removeFromReviewsRelationship(ch.filme.Review object) {
    log.debug("removing {} from reviews relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      removeFromReviews(object);
    }
    else {
      removeObjectFromBothSidesOfRelationshipWithKey(object, _Movie.REVIEWS_KEY);
    }
  }

  public ch.filme.Review createReviewsRelationship() {
    EOEnterpriseObject eo = EOUtilities.createAndInsertInstance(editingContext(),  ch.filme.Review.ENTITY_NAME );
    addObjectToBothSidesOfRelationshipWithKey(eo, _Movie.REVIEWS_KEY);
    return (ch.filme.Review) eo;
  }

  public void deleteReviewsRelationship(ch.filme.Review object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Movie.REVIEWS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllReviewsRelationships() {
    Enumeration<ch.filme.Review> objects = reviews().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteReviewsRelationship(objects.nextElement());
    }
  }

  public NSArray<ch.filme.Talent> talents() {
    return (NSArray<ch.filme.Talent>)storedValueForKey(_Movie.TALENTS_KEY);
  }

  public NSArray<ch.filme.Talent> talents(EOQualifier qualifier) {
    return talents(qualifier, null);
  }

  public NSArray<ch.filme.Talent> talents(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    NSArray<ch.filme.Talent> results;
      results = talents();
      if (qualifier != null) {
        results = (NSArray<ch.filme.Talent>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<ch.filme.Talent>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }

  public void addToTalents(ch.filme.Talent object) {
    includeObjectIntoPropertyWithKey(object, _Movie.TALENTS_KEY);
  }

  public void removeFromTalents(ch.filme.Talent object) {
    excludeObjectFromPropertyWithKey(object, _Movie.TALENTS_KEY);
  }

  public void addToTalentsRelationship(ch.filme.Talent object) {
    log.debug("adding {} to talents relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      addToTalents(object);
    }
    else {
      addObjectToBothSidesOfRelationshipWithKey(object, _Movie.TALENTS_KEY);
    }
  }

  public void removeFromTalentsRelationship(ch.filme.Talent object) {
    log.debug("removing {} from talents relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      removeFromTalents(object);
    }
    else {
      removeObjectFromBothSidesOfRelationshipWithKey(object, _Movie.TALENTS_KEY);
    }
  }

  public ch.filme.Talent createTalentsRelationship() {
    EOEnterpriseObject eo = EOUtilities.createAndInsertInstance(editingContext(),  ch.filme.Talent.ENTITY_NAME );
    addObjectToBothSidesOfRelationshipWithKey(eo, _Movie.TALENTS_KEY);
    return (ch.filme.Talent) eo;
  }

  public void deleteTalentsRelationship(ch.filme.Talent object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Movie.TALENTS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllTalentsRelationships() {
    Enumeration<ch.filme.Talent> objects = talents().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteTalentsRelationship(objects.nextElement());
    }
  }

  public NSArray<ch.filme.Video> videos() {
    return (NSArray<ch.filme.Video>)storedValueForKey(_Movie.VIDEOS_KEY);
  }

  public NSArray<ch.filme.Video> videos(EOQualifier qualifier) {
    return videos(qualifier, null, false);
  }

  public NSArray<ch.filme.Video> videos(EOQualifier qualifier, boolean fetch) {
    return videos(qualifier, null, fetch);
  }

  public NSArray<ch.filme.Video> videos(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<ch.filme.Video> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = ERXQ.equals(ch.filme.Video.MOVIE_KEY, this);

      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        fullQualifier = ERXQ.and(qualifier, inverseQualifier);
      }

      results = ch.filme.Video.fetchVideos(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = videos();
      if (qualifier != null) {
        results = (NSArray<ch.filme.Video>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<ch.filme.Video>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }

  public void addToVideos(ch.filme.Video object) {
    includeObjectIntoPropertyWithKey(object, _Movie.VIDEOS_KEY);
  }

  public void removeFromVideos(ch.filme.Video object) {
    excludeObjectFromPropertyWithKey(object, _Movie.VIDEOS_KEY);
  }

  public void addToVideosRelationship(ch.filme.Video object) {
    log.debug("adding {} to videos relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      addToVideos(object);
    }
    else {
      addObjectToBothSidesOfRelationshipWithKey(object, _Movie.VIDEOS_KEY);
    }
  }

  public void removeFromVideosRelationship(ch.filme.Video object) {
    log.debug("removing {} from videos relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      removeFromVideos(object);
    }
    else {
      removeObjectFromBothSidesOfRelationshipWithKey(object, _Movie.VIDEOS_KEY);
    }
  }

  public ch.filme.Video createVideosRelationship() {
    EOEnterpriseObject eo = EOUtilities.createAndInsertInstance(editingContext(),  ch.filme.Video.ENTITY_NAME );
    addObjectToBothSidesOfRelationshipWithKey(eo, _Movie.VIDEOS_KEY);
    return (ch.filme.Video) eo;
  }

  public void deleteVideosRelationship(ch.filme.Video object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Movie.VIDEOS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllVideosRelationships() {
    Enumeration<ch.filme.Video> objects = videos().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteVideosRelationship(objects.nextElement());
    }
  }

  public NSArray<ch.filme.Voting> votings() {
    return (NSArray<ch.filme.Voting>)storedValueForKey(_Movie.VOTINGS_KEY);
  }

  public NSArray<ch.filme.Voting> votings(EOQualifier qualifier) {
    return votings(qualifier, null, false);
  }

  public NSArray<ch.filme.Voting> votings(EOQualifier qualifier, boolean fetch) {
    return votings(qualifier, null, fetch);
  }

  public NSArray<ch.filme.Voting> votings(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<ch.filme.Voting> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = ERXQ.equals(ch.filme.Voting.MOVIE_KEY, this);

      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        fullQualifier = ERXQ.and(qualifier, inverseQualifier);
      }

      results = ch.filme.Voting.fetchVotings(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = votings();
      if (qualifier != null) {
        results = (NSArray<ch.filme.Voting>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<ch.filme.Voting>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }

  public void addToVotings(ch.filme.Voting object) {
    includeObjectIntoPropertyWithKey(object, _Movie.VOTINGS_KEY);
  }

  public void removeFromVotings(ch.filme.Voting object) {
    excludeObjectFromPropertyWithKey(object, _Movie.VOTINGS_KEY);
  }

  public void addToVotingsRelationship(ch.filme.Voting object) {
    log.debug("adding {} to votings relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      addToVotings(object);
    }
    else {
      addObjectToBothSidesOfRelationshipWithKey(object, _Movie.VOTINGS_KEY);
    }
  }

  public void removeFromVotingsRelationship(ch.filme.Voting object) {
    log.debug("removing {} from votings relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      removeFromVotings(object);
    }
    else {
      removeObjectFromBothSidesOfRelationshipWithKey(object, _Movie.VOTINGS_KEY);
    }
  }

  public ch.filme.Voting createVotingsRelationship() {
    EOEnterpriseObject eo = EOUtilities.createAndInsertInstance(editingContext(),  ch.filme.Voting.ENTITY_NAME );
    addObjectToBothSidesOfRelationshipWithKey(eo, _Movie.VOTINGS_KEY);
    return (ch.filme.Voting) eo;
  }

  public void deleteVotingsRelationship(ch.filme.Voting object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Movie.VOTINGS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllVotingsRelationships() {
    Enumeration<ch.filme.Voting> objects = votings().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteVotingsRelationship(objects.nextElement());
    }
  }


  public static Movie createMovie(EOEditingContext editingContext, NSTimestamp dateReleased
, String posterName
, String rated
, String title
, String trailerName
) {
    Movie eo = (Movie) EOUtilities.createAndInsertInstance(editingContext, _Movie.ENTITY_NAME);
    eo.setDateReleased(dateReleased);
    eo.setPosterName(posterName);
    eo.setRated(rated);
    eo.setTitle(title);
    eo.setTrailerName(trailerName);
    return eo;
  }

  public static ERXFetchSpecification<Movie> fetchSpec() {
    return new ERXFetchSpecification<Movie>(_Movie.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Movie> fetchAllMovies(EOEditingContext editingContext) {
    return _Movie.fetchAllMovies(editingContext, null);
  }

  public static NSArray<Movie> fetchAllMovies(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Movie.fetchMovies(editingContext, null, sortOrderings);
  }

  public static NSArray<Movie> fetchMovies(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Movie> fetchSpec = new ERXFetchSpecification<Movie>(_Movie.ENTITY_NAME, qualifier, sortOrderings);
    NSArray<Movie> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Movie fetchMovie(EOEditingContext editingContext, String keyName, Object value) {
    return _Movie.fetchMovie(editingContext, ERXQ.equals(keyName, value));
  }

  public static Movie fetchMovie(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Movie> eoObjects = _Movie.fetchMovies(editingContext, qualifier, null);
    Movie eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Movie that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Movie fetchRequiredMovie(EOEditingContext editingContext, String keyName, Object value) {
    return _Movie.fetchRequiredMovie(editingContext, ERXQ.equals(keyName, value));
  }

  public static Movie fetchRequiredMovie(EOEditingContext editingContext, EOQualifier qualifier) {
    Movie eoObject = _Movie.fetchMovie(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Movie that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Movie localInstanceIn(EOEditingContext editingContext, Movie eo) {
    Movie localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
