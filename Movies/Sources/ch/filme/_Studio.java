// DO NOT EDIT.  Make changes to Studio.java instead.
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
public abstract class _Studio extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Studio";

  // Attribute Keys
  public static final ERXKey<Double> BUDGET = new ERXKey<Double>("budget");
  public static final ERXKey<String> NAME = new ERXKey<String>("name");

  // Relationship Keys
  public static final ERXKey<ch.filme.Movie> MOVIES = new ERXKey<ch.filme.Movie>("movies");

  // Attributes
  public static final String BUDGET_KEY = BUDGET.key();
  public static final String NAME_KEY = NAME.key();

  // Relationships
  public static final String MOVIES_KEY = MOVIES.key();

  private static final Logger log = LoggerFactory.getLogger(_Studio.class);

  public Studio localInstanceIn(EOEditingContext editingContext) {
    Studio localInstance = (Studio)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Double budget() {
    return (Double) storedValueForKey(_Studio.BUDGET_KEY);
  }

  public void setBudget(Double value) {
    log.debug( "updating budget from {} to {}", budget(), value);
    takeStoredValueForKey(value, _Studio.BUDGET_KEY);
  }

  public String name() {
    return (String) storedValueForKey(_Studio.NAME_KEY);
  }

  public void setName(String value) {
    log.debug( "updating name from {} to {}", name(), value);
    takeStoredValueForKey(value, _Studio.NAME_KEY);
  }

  public NSArray<ch.filme.Movie> movies() {
    return (NSArray<ch.filme.Movie>)storedValueForKey(_Studio.MOVIES_KEY);
  }

  public NSArray<ch.filme.Movie> movies(EOQualifier qualifier) {
    return movies(qualifier, null, false);
  }

  public NSArray<ch.filme.Movie> movies(EOQualifier qualifier, boolean fetch) {
    return movies(qualifier, null, fetch);
  }

  public NSArray<ch.filme.Movie> movies(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<ch.filme.Movie> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = ERXQ.equals(ch.filme.Movie.STUDIO_KEY, this);

      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        fullQualifier = ERXQ.and(qualifier, inverseQualifier);
      }

      results = ch.filme.Movie.fetchMovies(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = movies();
      if (qualifier != null) {
        results = (NSArray<ch.filme.Movie>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<ch.filme.Movie>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }

  public void addToMovies(ch.filme.Movie object) {
    includeObjectIntoPropertyWithKey(object, _Studio.MOVIES_KEY);
  }

  public void removeFromMovies(ch.filme.Movie object) {
    excludeObjectFromPropertyWithKey(object, _Studio.MOVIES_KEY);
  }

  public void addToMoviesRelationship(ch.filme.Movie object) {
    log.debug("adding {} to movies relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      addToMovies(object);
    }
    else {
      addObjectToBothSidesOfRelationshipWithKey(object, _Studio.MOVIES_KEY);
    }
  }

  public void removeFromMoviesRelationship(ch.filme.Movie object) {
    log.debug("removing {} from movies relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      removeFromMovies(object);
    }
    else {
      removeObjectFromBothSidesOfRelationshipWithKey(object, _Studio.MOVIES_KEY);
    }
  }

  public ch.filme.Movie createMoviesRelationship() {
    EOEnterpriseObject eo = EOUtilities.createAndInsertInstance(editingContext(),  ch.filme.Movie.ENTITY_NAME );
    addObjectToBothSidesOfRelationshipWithKey(eo, _Studio.MOVIES_KEY);
    return (ch.filme.Movie) eo;
  }

  public void deleteMoviesRelationship(ch.filme.Movie object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Studio.MOVIES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllMoviesRelationships() {
    Enumeration<ch.filme.Movie> objects = movies().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteMoviesRelationship(objects.nextElement());
    }
  }


  public static Studio createStudio(EOEditingContext editingContext, Double budget
, String name
) {
    Studio eo = (Studio) EOUtilities.createAndInsertInstance(editingContext, _Studio.ENTITY_NAME);
    eo.setBudget(budget);
    eo.setName(name);
    return eo;
  }

  public static ERXFetchSpecification<Studio> fetchSpec() {
    return new ERXFetchSpecification<Studio>(_Studio.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Studio> fetchAllStudios(EOEditingContext editingContext) {
    return _Studio.fetchAllStudios(editingContext, null);
  }

  public static NSArray<Studio> fetchAllStudios(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Studio.fetchStudios(editingContext, null, sortOrderings);
  }

  public static NSArray<Studio> fetchStudios(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Studio> fetchSpec = new ERXFetchSpecification<Studio>(_Studio.ENTITY_NAME, qualifier, sortOrderings);
    NSArray<Studio> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Studio fetchStudio(EOEditingContext editingContext, String keyName, Object value) {
    return _Studio.fetchStudio(editingContext, ERXQ.equals(keyName, value));
  }

  public static Studio fetchStudio(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Studio> eoObjects = _Studio.fetchStudios(editingContext, qualifier, null);
    Studio eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Studio that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Studio fetchRequiredStudio(EOEditingContext editingContext, String keyName, Object value) {
    return _Studio.fetchRequiredStudio(editingContext, ERXQ.equals(keyName, value));
  }

  public static Studio fetchRequiredStudio(EOEditingContext editingContext, EOQualifier qualifier) {
    Studio eoObject = _Studio.fetchStudio(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Studio that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Studio localInstanceIn(EOEditingContext editingContext, Studio eo) {
    Studio localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
