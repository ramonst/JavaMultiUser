// DO NOT EDIT.  Make changes to RentalTerms.java instead.
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
public abstract class _RentalTerms extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "RentalTerms";

  // Attribute Keys
  public static final ERXKey<Long> CHECK_OUT_LENGTH = new ERXKey<Long>("checkOutLength");
  public static final ERXKey<Double> COST = new ERXKey<Double>("cost");
  public static final ERXKey<Double> DEPOSIT_AMOUNT = new ERXKey<Double>("depositAmount");
  public static final ERXKey<String> NAME = new ERXKey<String>("name");

  // Relationship Keys
  public static final ERXKey<ch.filme.Video> VIDEOS = new ERXKey<ch.filme.Video>("videos");

  // Attributes
  public static final String CHECK_OUT_LENGTH_KEY = CHECK_OUT_LENGTH.key();
  public static final String COST_KEY = COST.key();
  public static final String DEPOSIT_AMOUNT_KEY = DEPOSIT_AMOUNT.key();
  public static final String NAME_KEY = NAME.key();

  // Relationships
  public static final String VIDEOS_KEY = VIDEOS.key();

  private static final Logger log = LoggerFactory.getLogger(_RentalTerms.class);

  public RentalTerms localInstanceIn(EOEditingContext editingContext) {
    RentalTerms localInstance = (RentalTerms)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Long checkOutLength() {
    return (Long) storedValueForKey(_RentalTerms.CHECK_OUT_LENGTH_KEY);
  }

  public void setCheckOutLength(Long value) {
    log.debug( "updating checkOutLength from {} to {}", checkOutLength(), value);
    takeStoredValueForKey(value, _RentalTerms.CHECK_OUT_LENGTH_KEY);
  }

  public Double cost() {
    return (Double) storedValueForKey(_RentalTerms.COST_KEY);
  }

  public void setCost(Double value) {
    log.debug( "updating cost from {} to {}", cost(), value);
    takeStoredValueForKey(value, _RentalTerms.COST_KEY);
  }

  public Double depositAmount() {
    return (Double) storedValueForKey(_RentalTerms.DEPOSIT_AMOUNT_KEY);
  }

  public void setDepositAmount(Double value) {
    log.debug( "updating depositAmount from {} to {}", depositAmount(), value);
    takeStoredValueForKey(value, _RentalTerms.DEPOSIT_AMOUNT_KEY);
  }

  public String name() {
    return (String) storedValueForKey(_RentalTerms.NAME_KEY);
  }

  public void setName(String value) {
    log.debug( "updating name from {} to {}", name(), value);
    takeStoredValueForKey(value, _RentalTerms.NAME_KEY);
  }

  public NSArray<ch.filme.Video> videos() {
    return (NSArray<ch.filme.Video>)storedValueForKey(_RentalTerms.VIDEOS_KEY);
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
      EOQualifier inverseQualifier = ERXQ.equals(ch.filme.Video.RENTAL_TERMS_KEY, this);

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
    includeObjectIntoPropertyWithKey(object, _RentalTerms.VIDEOS_KEY);
  }

  public void removeFromVideos(ch.filme.Video object) {
    excludeObjectFromPropertyWithKey(object, _RentalTerms.VIDEOS_KEY);
  }

  public void addToVideosRelationship(ch.filme.Video object) {
    log.debug("adding {} to videos relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      addToVideos(object);
    }
    else {
      addObjectToBothSidesOfRelationshipWithKey(object, _RentalTerms.VIDEOS_KEY);
    }
  }

  public void removeFromVideosRelationship(ch.filme.Video object) {
    log.debug("removing {} from videos relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      removeFromVideos(object);
    }
    else {
      removeObjectFromBothSidesOfRelationshipWithKey(object, _RentalTerms.VIDEOS_KEY);
    }
  }

  public ch.filme.Video createVideosRelationship() {
    EOEnterpriseObject eo = EOUtilities.createAndInsertInstance(editingContext(),  ch.filme.Video.ENTITY_NAME );
    addObjectToBothSidesOfRelationshipWithKey(eo, _RentalTerms.VIDEOS_KEY);
    return (ch.filme.Video) eo;
  }

  public void deleteVideosRelationship(ch.filme.Video object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _RentalTerms.VIDEOS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllVideosRelationships() {
    Enumeration<ch.filme.Video> objects = videos().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteVideosRelationship(objects.nextElement());
    }
  }


  public static RentalTerms createRentalTerms(EOEditingContext editingContext, Long checkOutLength
, Double cost
, Double depositAmount
, String name
) {
    RentalTerms eo = (RentalTerms) EOUtilities.createAndInsertInstance(editingContext, _RentalTerms.ENTITY_NAME);
    eo.setCheckOutLength(checkOutLength);
    eo.setCost(cost);
    eo.setDepositAmount(depositAmount);
    eo.setName(name);
    return eo;
  }

  public static ERXFetchSpecification<RentalTerms> fetchSpec() {
    return new ERXFetchSpecification<RentalTerms>(_RentalTerms.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<RentalTerms> fetchAllRentalTermses(EOEditingContext editingContext) {
    return _RentalTerms.fetchAllRentalTermses(editingContext, null);
  }

  public static NSArray<RentalTerms> fetchAllRentalTermses(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _RentalTerms.fetchRentalTermses(editingContext, null, sortOrderings);
  }

  public static NSArray<RentalTerms> fetchRentalTermses(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<RentalTerms> fetchSpec = new ERXFetchSpecification<RentalTerms>(_RentalTerms.ENTITY_NAME, qualifier, sortOrderings);
    NSArray<RentalTerms> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static RentalTerms fetchRentalTerms(EOEditingContext editingContext, String keyName, Object value) {
    return _RentalTerms.fetchRentalTerms(editingContext, ERXQ.equals(keyName, value));
  }

  public static RentalTerms fetchRentalTerms(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<RentalTerms> eoObjects = _RentalTerms.fetchRentalTermses(editingContext, qualifier, null);
    RentalTerms eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one RentalTerms that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static RentalTerms fetchRequiredRentalTerms(EOEditingContext editingContext, String keyName, Object value) {
    return _RentalTerms.fetchRequiredRentalTerms(editingContext, ERXQ.equals(keyName, value));
  }

  public static RentalTerms fetchRequiredRentalTerms(EOEditingContext editingContext, EOQualifier qualifier) {
    RentalTerms eoObject = _RentalTerms.fetchRentalTerms(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no RentalTerms that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static RentalTerms localInstanceIn(EOEditingContext editingContext, RentalTerms eo) {
    RentalTerms localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
