// DO NOT EDIT.  Make changes to Director.java instead.
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
public abstract class _Director extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Director";

  // Attribute Keys

  // Relationship Keys
  public static final ERXKey<ch.filme.Movie> MOVIE = new ERXKey<ch.filme.Movie>("movie");

  // Attributes

  // Relationships
  public static final String MOVIE_KEY = MOVIE.key();

  private static final Logger log = LoggerFactory.getLogger(_Director.class);

  public Director localInstanceIn(EOEditingContext editingContext) {
    Director localInstance = (Director)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public ch.filme.Movie movie() {
    return (ch.filme.Movie)storedValueForKey(_Director.MOVIE_KEY);
  }

  public void setMovie(ch.filme.Movie value) {
    takeStoredValueForKey(value, _Director.MOVIE_KEY);
  }

  public void setMovieRelationship(ch.filme.Movie value) {
    log.debug("updating movie from {} to {}", movie(), value);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      setMovie(value);
    }
    else if (value == null) {
      ch.filme.Movie oldValue = movie();
      if (oldValue != null) {
        removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _Director.MOVIE_KEY);
      }
    } else {
      addObjectToBothSidesOfRelationshipWithKey(value, _Director.MOVIE_KEY);
    }
  }


  public static Director createDirector(EOEditingContext editingContext) {
    Director eo = (Director) EOUtilities.createAndInsertInstance(editingContext, _Director.ENTITY_NAME);
    return eo;
  }

  public static ERXFetchSpecification<Director> fetchSpec() {
    return new ERXFetchSpecification<Director>(_Director.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Director> fetchAllDirectors(EOEditingContext editingContext) {
    return _Director.fetchAllDirectors(editingContext, null);
  }

  public static NSArray<Director> fetchAllDirectors(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Director.fetchDirectors(editingContext, null, sortOrderings);
  }

  public static NSArray<Director> fetchDirectors(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Director> fetchSpec = new ERXFetchSpecification<Director>(_Director.ENTITY_NAME, qualifier, sortOrderings);
    NSArray<Director> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Director fetchDirector(EOEditingContext editingContext, String keyName, Object value) {
    return _Director.fetchDirector(editingContext, ERXQ.equals(keyName, value));
  }

  public static Director fetchDirector(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Director> eoObjects = _Director.fetchDirectors(editingContext, qualifier, null);
    Director eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Director that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Director fetchRequiredDirector(EOEditingContext editingContext, String keyName, Object value) {
    return _Director.fetchRequiredDirector(editingContext, ERXQ.equals(keyName, value));
  }

  public static Director fetchRequiredDirector(EOEditingContext editingContext, EOQualifier qualifier) {
    Director eoObject = _Director.fetchDirector(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Director that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Director localInstanceIn(EOEditingContext editingContext, Director eo) {
    Director localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
