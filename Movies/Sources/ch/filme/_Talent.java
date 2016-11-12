// DO NOT EDIT.  Make changes to Talent.java instead.
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
public abstract class _Talent extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Talent";

  // Attribute Keys
  public static final ERXKey<String> FIRST_NAME = new ERXKey<String>("firstName");
  public static final ERXKey<String> LAST_NAME = new ERXKey<String>("lastName");

  // Relationship Keys
  public static final ERXKey<ch.filme.MovieRole> MOVIE_ROLES = new ERXKey<ch.filme.MovieRole>("movieRoles");
  public static final ERXKey<ch.filme.Movie> MOVIES = new ERXKey<ch.filme.Movie>("movies");

  // Attributes
  public static final String FIRST_NAME_KEY = FIRST_NAME.key();
  public static final String LAST_NAME_KEY = LAST_NAME.key();

  // Relationships
  public static final String MOVIE_ROLES_KEY = MOVIE_ROLES.key();
  public static final String MOVIES_KEY = MOVIES.key();

  private static final Logger log = LoggerFactory.getLogger(_Talent.class);

  public Talent localInstanceIn(EOEditingContext editingContext) {
    Talent localInstance = (Talent)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String firstName() {
    return (String) storedValueForKey(_Talent.FIRST_NAME_KEY);
  }

  public void setFirstName(String value) {
    log.debug( "updating firstName from {} to {}", firstName(), value);
    takeStoredValueForKey(value, _Talent.FIRST_NAME_KEY);
  }

  public String lastName() {
    return (String) storedValueForKey(_Talent.LAST_NAME_KEY);
  }

  public void setLastName(String value) {
    log.debug( "updating lastName from {} to {}", lastName(), value);
    takeStoredValueForKey(value, _Talent.LAST_NAME_KEY);
  }

  public NSArray<ch.filme.MovieRole> movieRoles() {
    return (NSArray<ch.filme.MovieRole>)storedValueForKey(_Talent.MOVIE_ROLES_KEY);
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
      EOQualifier inverseQualifier = ERXQ.equals(ch.filme.MovieRole.TALENT_KEY, this);

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
    includeObjectIntoPropertyWithKey(object, _Talent.MOVIE_ROLES_KEY);
  }

  public void removeFromMovieRoles(ch.filme.MovieRole object) {
    excludeObjectFromPropertyWithKey(object, _Talent.MOVIE_ROLES_KEY);
  }

  public void addToMovieRolesRelationship(ch.filme.MovieRole object) {
    log.debug("adding {} to movieRoles relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      addToMovieRoles(object);
    }
    else {
      addObjectToBothSidesOfRelationshipWithKey(object, _Talent.MOVIE_ROLES_KEY);
    }
  }

  public void removeFromMovieRolesRelationship(ch.filme.MovieRole object) {
    log.debug("removing {} from movieRoles relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      removeFromMovieRoles(object);
    }
    else {
      removeObjectFromBothSidesOfRelationshipWithKey(object, _Talent.MOVIE_ROLES_KEY);
    }
  }

  public ch.filme.MovieRole createMovieRolesRelationship() {
    EOEnterpriseObject eo = EOUtilities.createAndInsertInstance(editingContext(),  ch.filme.MovieRole.ENTITY_NAME );
    addObjectToBothSidesOfRelationshipWithKey(eo, _Talent.MOVIE_ROLES_KEY);
    return (ch.filme.MovieRole) eo;
  }

  public void deleteMovieRolesRelationship(ch.filme.MovieRole object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Talent.MOVIE_ROLES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllMovieRolesRelationships() {
    Enumeration<ch.filme.MovieRole> objects = movieRoles().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteMovieRolesRelationship(objects.nextElement());
    }
  }

  public NSArray<ch.filme.Movie> movies() {
    return (NSArray<ch.filme.Movie>)storedValueForKey(_Talent.MOVIES_KEY);
  }

  public NSArray<ch.filme.Movie> movies(EOQualifier qualifier) {
    return movies(qualifier, null);
  }

  public NSArray<ch.filme.Movie> movies(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    NSArray<ch.filme.Movie> results;
      results = movies();
      if (qualifier != null) {
        results = (NSArray<ch.filme.Movie>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<ch.filme.Movie>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }

  public void addToMovies(ch.filme.Movie object) {
    includeObjectIntoPropertyWithKey(object, _Talent.MOVIES_KEY);
  }

  public void removeFromMovies(ch.filme.Movie object) {
    excludeObjectFromPropertyWithKey(object, _Talent.MOVIES_KEY);
  }

  public void addToMoviesRelationship(ch.filme.Movie object) {
    log.debug("adding {} to movies relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      addToMovies(object);
    }
    else {
      addObjectToBothSidesOfRelationshipWithKey(object, _Talent.MOVIES_KEY);
    }
  }

  public void removeFromMoviesRelationship(ch.filme.Movie object) {
    log.debug("removing {} from movies relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      removeFromMovies(object);
    }
    else {
      removeObjectFromBothSidesOfRelationshipWithKey(object, _Talent.MOVIES_KEY);
    }
  }

  public ch.filme.Movie createMoviesRelationship() {
    EOEnterpriseObject eo = EOUtilities.createAndInsertInstance(editingContext(),  ch.filme.Movie.ENTITY_NAME );
    addObjectToBothSidesOfRelationshipWithKey(eo, _Talent.MOVIES_KEY);
    return (ch.filme.Movie) eo;
  }

  public void deleteMoviesRelationship(ch.filme.Movie object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Talent.MOVIES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllMoviesRelationships() {
    Enumeration<ch.filme.Movie> objects = movies().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteMoviesRelationship(objects.nextElement());
    }
  }


  public static Talent createTalent(EOEditingContext editingContext, String firstName
, String lastName
) {
    Talent eo = (Talent) EOUtilities.createAndInsertInstance(editingContext, _Talent.ENTITY_NAME);
    eo.setFirstName(firstName);
    eo.setLastName(lastName);
    return eo;
  }

  public static ERXFetchSpecification<Talent> fetchSpec() {
    return new ERXFetchSpecification<Talent>(_Talent.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Talent> fetchAllTalents(EOEditingContext editingContext) {
    return _Talent.fetchAllTalents(editingContext, null);
  }

  public static NSArray<Talent> fetchAllTalents(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Talent.fetchTalents(editingContext, null, sortOrderings);
  }

  public static NSArray<Talent> fetchTalents(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Talent> fetchSpec = new ERXFetchSpecification<Talent>(_Talent.ENTITY_NAME, qualifier, sortOrderings);
    NSArray<Talent> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Talent fetchTalent(EOEditingContext editingContext, String keyName, Object value) {
    return _Talent.fetchTalent(editingContext, ERXQ.equals(keyName, value));
  }

  public static Talent fetchTalent(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Talent> eoObjects = _Talent.fetchTalents(editingContext, qualifier, null);
    Talent eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Talent that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Talent fetchRequiredTalent(EOEditingContext editingContext, String keyName, Object value) {
    return _Talent.fetchRequiredTalent(editingContext, ERXQ.equals(keyName, value));
  }

  public static Talent fetchRequiredTalent(EOEditingContext editingContext, EOQualifier qualifier) {
    Talent eoObject = _Talent.fetchTalent(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Talent that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Talent localInstanceIn(EOEditingContext editingContext, Talent eo) {
    Talent localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
