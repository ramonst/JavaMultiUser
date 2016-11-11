// DO NOT EDIT.  Make changes to Rental.java instead.
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
public abstract class _Rental extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Rental";

  // Attribute Keys
  public static final ERXKey<NSTimestamp> DATE_OUT = new ERXKey<NSTimestamp>("dateOut");
  public static final ERXKey<NSTimestamp> DATE_RETURNED = new ERXKey<NSTimestamp>("dateReturned");

  // Relationship Keys
  public static final ERXKey<ch.filme.Customer> CUSTOMER = new ERXKey<ch.filme.Customer>("customer");
  public static final ERXKey<ch.filme.Fee> FEES = new ERXKey<ch.filme.Fee>("fees");
  public static final ERXKey<ch.filme.Unit> UNIT = new ERXKey<ch.filme.Unit>("unit");

  // Attributes
  public static final String DATE_OUT_KEY = DATE_OUT.key();
  public static final String DATE_RETURNED_KEY = DATE_RETURNED.key();

  // Relationships
  public static final String CUSTOMER_KEY = CUSTOMER.key();
  public static final String FEES_KEY = FEES.key();
  public static final String UNIT_KEY = UNIT.key();

  private static final Logger log = LoggerFactory.getLogger(_Rental.class);

  public Rental localInstanceIn(EOEditingContext editingContext) {
    Rental localInstance = (Rental)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public NSTimestamp dateOut() {
    return (NSTimestamp) storedValueForKey(_Rental.DATE_OUT_KEY);
  }

  public void setDateOut(NSTimestamp value) {
    log.debug( "updating dateOut from {} to {}", dateOut(), value);
    takeStoredValueForKey(value, _Rental.DATE_OUT_KEY);
  }

  public NSTimestamp dateReturned() {
    return (NSTimestamp) storedValueForKey(_Rental.DATE_RETURNED_KEY);
  }

  public void setDateReturned(NSTimestamp value) {
    log.debug( "updating dateReturned from {} to {}", dateReturned(), value);
    takeStoredValueForKey(value, _Rental.DATE_RETURNED_KEY);
  }

  public ch.filme.Customer customer() {
    return (ch.filme.Customer)storedValueForKey(_Rental.CUSTOMER_KEY);
  }

  public void setCustomer(ch.filme.Customer value) {
    takeStoredValueForKey(value, _Rental.CUSTOMER_KEY);
  }

  public void setCustomerRelationship(ch.filme.Customer value) {
    log.debug("updating customer from {} to {}", customer(), value);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      setCustomer(value);
    }
    else if (value == null) {
      ch.filme.Customer oldValue = customer();
      if (oldValue != null) {
        removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _Rental.CUSTOMER_KEY);
      }
    } else {
      addObjectToBothSidesOfRelationshipWithKey(value, _Rental.CUSTOMER_KEY);
    }
  }

  public ch.filme.Unit unit() {
    return (ch.filme.Unit)storedValueForKey(_Rental.UNIT_KEY);
  }

  public void setUnit(ch.filme.Unit value) {
    takeStoredValueForKey(value, _Rental.UNIT_KEY);
  }

  public void setUnitRelationship(ch.filme.Unit value) {
    log.debug("updating unit from {} to {}", unit(), value);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      setUnit(value);
    }
    else if (value == null) {
      ch.filme.Unit oldValue = unit();
      if (oldValue != null) {
        removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _Rental.UNIT_KEY);
      }
    } else {
      addObjectToBothSidesOfRelationshipWithKey(value, _Rental.UNIT_KEY);
    }
  }

  public NSArray<ch.filme.Fee> fees() {
    return (NSArray<ch.filme.Fee>)storedValueForKey(_Rental.FEES_KEY);
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
      EOQualifier inverseQualifier = ERXQ.equals(ch.filme.Fee.RENTAL_KEY, this);

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
    includeObjectIntoPropertyWithKey(object, _Rental.FEES_KEY);
  }

  public void removeFromFees(ch.filme.Fee object) {
    excludeObjectFromPropertyWithKey(object, _Rental.FEES_KEY);
  }

  public void addToFeesRelationship(ch.filme.Fee object) {
    log.debug("adding {} to fees relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      addToFees(object);
    }
    else {
      addObjectToBothSidesOfRelationshipWithKey(object, _Rental.FEES_KEY);
    }
  }

  public void removeFromFeesRelationship(ch.filme.Fee object) {
    log.debug("removing {} from fees relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      removeFromFees(object);
    }
    else {
      removeObjectFromBothSidesOfRelationshipWithKey(object, _Rental.FEES_KEY);
    }
  }

  public ch.filme.Fee createFeesRelationship() {
    EOEnterpriseObject eo = EOUtilities.createAndInsertInstance(editingContext(),  ch.filme.Fee.ENTITY_NAME );
    addObjectToBothSidesOfRelationshipWithKey(eo, _Rental.FEES_KEY);
    return (ch.filme.Fee) eo;
  }

  public void deleteFeesRelationship(ch.filme.Fee object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Rental.FEES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllFeesRelationships() {
    Enumeration<ch.filme.Fee> objects = fees().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteFeesRelationship(objects.nextElement());
    }
  }


  public static Rental createRental(EOEditingContext editingContext, NSTimestamp dateOut
, NSTimestamp dateReturned
) {
    Rental eo = (Rental) EOUtilities.createAndInsertInstance(editingContext, _Rental.ENTITY_NAME);
    eo.setDateOut(dateOut);
    eo.setDateReturned(dateReturned);
    return eo;
  }

  public static ERXFetchSpecification<Rental> fetchSpec() {
    return new ERXFetchSpecification<Rental>(_Rental.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Rental> fetchAllRentals(EOEditingContext editingContext) {
    return _Rental.fetchAllRentals(editingContext, null);
  }

  public static NSArray<Rental> fetchAllRentals(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Rental.fetchRentals(editingContext, null, sortOrderings);
  }

  public static NSArray<Rental> fetchRentals(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Rental> fetchSpec = new ERXFetchSpecification<Rental>(_Rental.ENTITY_NAME, qualifier, sortOrderings);
    NSArray<Rental> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Rental fetchRental(EOEditingContext editingContext, String keyName, Object value) {
    return _Rental.fetchRental(editingContext, ERXQ.equals(keyName, value));
  }

  public static Rental fetchRental(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Rental> eoObjects = _Rental.fetchRentals(editingContext, qualifier, null);
    Rental eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Rental that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Rental fetchRequiredRental(EOEditingContext editingContext, String keyName, Object value) {
    return _Rental.fetchRequiredRental(editingContext, ERXQ.equals(keyName, value));
  }

  public static Rental fetchRequiredRental(EOEditingContext editingContext, EOQualifier qualifier) {
    Rental eoObject = _Rental.fetchRental(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Rental that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Rental localInstanceIn(EOEditingContext editingContext, Rental eo) {
    Rental localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
