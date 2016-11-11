// DO NOT EDIT.  Make changes to FeeType.java instead.
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
public abstract class _FeeType extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "FeeType";

  // Attribute Keys
  public static final ERXKey<Long> ENABLED = new ERXKey<Long>("enabled");
  public static final ERXKey<String> FEE_TYPE = new ERXKey<String>("feeType");
  public static final ERXKey<Long> ORDER_BY = new ERXKey<Long>("orderBy");

  // Relationship Keys
  public static final ERXKey<ch.filme.Fee> FEES = new ERXKey<ch.filme.Fee>("fees");

  // Attributes
  public static final String ENABLED_KEY = ENABLED.key();
  public static final String FEE_TYPE_KEY = FEE_TYPE.key();
  public static final String ORDER_BY_KEY = ORDER_BY.key();

  // Relationships
  public static final String FEES_KEY = FEES.key();

  private static final Logger log = LoggerFactory.getLogger(_FeeType.class);

  public FeeType localInstanceIn(EOEditingContext editingContext) {
    FeeType localInstance = (FeeType)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Long enabled() {
    return (Long) storedValueForKey(_FeeType.ENABLED_KEY);
  }

  public void setEnabled(Long value) {
    log.debug( "updating enabled from {} to {}", enabled(), value);
    takeStoredValueForKey(value, _FeeType.ENABLED_KEY);
  }

  public String feeType() {
    return (String) storedValueForKey(_FeeType.FEE_TYPE_KEY);
  }

  public void setFeeType(String value) {
    log.debug( "updating feeType from {} to {}", feeType(), value);
    takeStoredValueForKey(value, _FeeType.FEE_TYPE_KEY);
  }

  public Long orderBy() {
    return (Long) storedValueForKey(_FeeType.ORDER_BY_KEY);
  }

  public void setOrderBy(Long value) {
    log.debug( "updating orderBy from {} to {}", orderBy(), value);
    takeStoredValueForKey(value, _FeeType.ORDER_BY_KEY);
  }

  public NSArray<ch.filme.Fee> fees() {
    return (NSArray<ch.filme.Fee>)storedValueForKey(_FeeType.FEES_KEY);
  }

  public NSArray<ch.filme.Fee> fees(EOQualifier qualifier) {
    return fees(qualifier, null, false);
  }

  public NSArray<ch.filme.Fee> fees(EOQualifier qualifier, boolean fetch) {
    return fees(qualifier, null, fetch);
  }

  public NSArray<ch.filme.Fee> fees(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<ch.filme.Fee> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = ERXQ.equals(ch.filme.Fee.FEE_TYPE_KEY, this);

      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        fullQualifier = ERXQ.and(qualifier, inverseQualifier);
      }

      results = ch.filme.Fee.fetchFees(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = fees();
      if (qualifier != null) {
        results = (NSArray<ch.filme.Fee>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<ch.filme.Fee>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }

  public void addToFees(ch.filme.Fee object) {
    includeObjectIntoPropertyWithKey(object, _FeeType.FEES_KEY);
  }

  public void removeFromFees(ch.filme.Fee object) {
    excludeObjectFromPropertyWithKey(object, _FeeType.FEES_KEY);
  }

  public void addToFeesRelationship(ch.filme.Fee object) {
    log.debug("adding {} to fees relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      addToFees(object);
    }
    else {
      addObjectToBothSidesOfRelationshipWithKey(object, _FeeType.FEES_KEY);
    }
  }

  public void removeFromFeesRelationship(ch.filme.Fee object) {
    log.debug("removing {} from fees relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      removeFromFees(object);
    }
    else {
      removeObjectFromBothSidesOfRelationshipWithKey(object, _FeeType.FEES_KEY);
    }
  }

  public ch.filme.Fee createFeesRelationship() {
    EOEnterpriseObject eo = EOUtilities.createAndInsertInstance(editingContext(),  ch.filme.Fee.ENTITY_NAME );
    addObjectToBothSidesOfRelationshipWithKey(eo, _FeeType.FEES_KEY);
    return (ch.filme.Fee) eo;
  }

  public void deleteFeesRelationship(ch.filme.Fee object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _FeeType.FEES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllFeesRelationships() {
    Enumeration<ch.filme.Fee> objects = fees().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteFeesRelationship(objects.nextElement());
    }
  }


  public static FeeType createFeeType(EOEditingContext editingContext, Long enabled
, String feeType
, Long orderBy
) {
    FeeType eo = (FeeType) EOUtilities.createAndInsertInstance(editingContext, _FeeType.ENTITY_NAME);
    eo.setEnabled(enabled);
    eo.setFeeType(feeType);
    eo.setOrderBy(orderBy);
    return eo;
  }

  public static ERXFetchSpecification<FeeType> fetchSpec() {
    return new ERXFetchSpecification<FeeType>(_FeeType.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<FeeType> fetchAllFeeTypes(EOEditingContext editingContext) {
    return _FeeType.fetchAllFeeTypes(editingContext, null);
  }

  public static NSArray<FeeType> fetchAllFeeTypes(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _FeeType.fetchFeeTypes(editingContext, null, sortOrderings);
  }

  public static NSArray<FeeType> fetchFeeTypes(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<FeeType> fetchSpec = new ERXFetchSpecification<FeeType>(_FeeType.ENTITY_NAME, qualifier, sortOrderings);
    NSArray<FeeType> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static FeeType fetchFeeType(EOEditingContext editingContext, String keyName, Object value) {
    return _FeeType.fetchFeeType(editingContext, ERXQ.equals(keyName, value));
  }

  public static FeeType fetchFeeType(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<FeeType> eoObjects = _FeeType.fetchFeeTypes(editingContext, qualifier, null);
    FeeType eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one FeeType that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static FeeType fetchRequiredFeeType(EOEditingContext editingContext, String keyName, Object value) {
    return _FeeType.fetchRequiredFeeType(editingContext, ERXQ.equals(keyName, value));
  }

  public static FeeType fetchRequiredFeeType(EOEditingContext editingContext, EOQualifier qualifier) {
    FeeType eoObject = _FeeType.fetchFeeType(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no FeeType that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static FeeType localInstanceIn(EOEditingContext editingContext, FeeType eo) {
    FeeType localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
