// DO NOT EDIT.  Make changes to Review.java instead.
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
public abstract class _Review extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Review";

  // Attribute Keys
  public static final ERXKey<NSData> REVIEW = new ERXKey<NSData>("review");
  public static final ERXKey<String> REVIEWER = new ERXKey<String>("reviewer");

  // Relationship Keys
  public static final ERXKey<ch.filme.Movie> MOVIE = new ERXKey<ch.filme.Movie>("movie");

  // Attributes
  public static final String REVIEW_KEY = REVIEW.key();
  public static final String REVIEWER_KEY = REVIEWER.key();

  // Relationships
  public static final String MOVIE_KEY = MOVIE.key();

  private static final Logger log = LoggerFactory.getLogger(_Review.class);

  public Review localInstanceIn(EOEditingContext editingContext) {
    Review localInstance = (Review)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public NSData review() {
    return (NSData) storedValueForKey(_Review.REVIEW_KEY);
  }

  public void setReview(NSData value) {
    log.debug( "updating review from {} to {}", review(), value);
    takeStoredValueForKey(value, _Review.REVIEW_KEY);
  }

  public String reviewer() {
    return (String) storedValueForKey(_Review.REVIEWER_KEY);
  }

  public void setReviewer(String value) {
    log.debug( "updating reviewer from {} to {}", reviewer(), value);
    takeStoredValueForKey(value, _Review.REVIEWER_KEY);
  }

  public ch.filme.Movie movie() {
    return (ch.filme.Movie)storedValueForKey(_Review.MOVIE_KEY);
  }

  public void setMovie(ch.filme.Movie value) {
    takeStoredValueForKey(value, _Review.MOVIE_KEY);
  }

  public void setMovieRelationship(ch.filme.Movie value) {
    log.debug("updating movie from {} to {}", movie(), value);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      setMovie(value);
    }
    else if (value == null) {
      ch.filme.Movie oldValue = movie();
      if (oldValue != null) {
        removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _Review.MOVIE_KEY);
      }
    } else {
      addObjectToBothSidesOfRelationshipWithKey(value, _Review.MOVIE_KEY);
    }
  }


  public static Review createReview(EOEditingContext editingContext, String reviewer
) {
    Review eo = (Review) EOUtilities.createAndInsertInstance(editingContext, _Review.ENTITY_NAME);
    eo.setReviewer(reviewer);
    return eo;
  }

  public static ERXFetchSpecification<Review> fetchSpec() {
    return new ERXFetchSpecification<Review>(_Review.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Review> fetchAllReviews(EOEditingContext editingContext) {
    return _Review.fetchAllReviews(editingContext, null);
  }

  public static NSArray<Review> fetchAllReviews(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Review.fetchReviews(editingContext, null, sortOrderings);
  }

  public static NSArray<Review> fetchReviews(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Review> fetchSpec = new ERXFetchSpecification<Review>(_Review.ENTITY_NAME, qualifier, sortOrderings);
    NSArray<Review> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Review fetchReview(EOEditingContext editingContext, String keyName, Object value) {
    return _Review.fetchReview(editingContext, ERXQ.equals(keyName, value));
  }

  public static Review fetchReview(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Review> eoObjects = _Review.fetchReviews(editingContext, qualifier, null);
    Review eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Review that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Review fetchRequiredReview(EOEditingContext editingContext, String keyName, Object value) {
    return _Review.fetchRequiredReview(editingContext, ERXQ.equals(keyName, value));
  }

  public static Review fetchRequiredReview(EOEditingContext editingContext, EOQualifier qualifier) {
    Review eoObject = _Review.fetchReview(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Review that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Review localInstanceIn(EOEditingContext editingContext, Review eo) {
    Review localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
