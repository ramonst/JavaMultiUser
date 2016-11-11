// DO NOT EDIT.  Make changes to Fee.java instead.
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
public abstract class _Fee extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Fee";

  // Attribute Keys
  public static final ERXKey<Double> AMOUNT = new ERXKey<Double>("amount");
  public static final ERXKey<NSTimestamp> DATE_PAID = new ERXKey<NSTimestamp>("datePaid");

  // Relationship Keys
  public static final ERXKey<ch.filme.FeeType> FEE_TYPE = new ERXKey<ch.filme.FeeType>("feeType");
  public static final ERXKey<ch.filme.Rental> RENTAL = new ERXKey<ch.filme.Rental>("rental");

  // Attributes
  public static final String AMOUNT_KEY = AMOUNT.key();
  public static final String DATE_PAID_KEY = DATE_PAID.key();

  // Relationships
  public static final String FEE_TYPE_KEY = FEE_TYPE.key();
  public static final String RENTAL_KEY = RENTAL.key();

  private static final Logger log = LoggerFactory.getLogger(_Fee.class);

  public Fee localInstanceIn(EOEditingContext editingContext) {
    Fee localInstance = (Fee)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Double amount() {
    return (Double) storedValueForKey(_Fee.AMOUNT_KEY);
  }

  public void setAmount(Double value) {
    log.debug( "updating amount from {} to {}", amount(), value);
    takeStoredValueForKey(value, _Fee.AMOUNT_KEY);
  }

  public NSTimestamp datePaid() {
    return (NSTimestamp) storedValueForKey(_Fee.DATE_PAID_KEY);
  }

  public void setDatePaid(NSTimestamp value) {
    log.debug( "updating datePaid from {} to {}", datePaid(), value);
    takeStoredValueForKey(value, _Fee.DATE_PAID_KEY);
  }

  public ch.filme.FeeType feeType() {
    return (ch.filme.FeeType)storedValueForKey(_Fee.FEE_TYPE_KEY);
  }

  public void setFeeType(ch.filme.FeeType value) {
    takeStoredValueForKey(value, _Fee.FEE_TYPE_KEY);
  }

  public void setFeeTypeRelationship(ch.filme.FeeType value) {
    log.debug("updating feeType from {} to {}", feeType(), value);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      setFeeType(value);
    }
    else if (value == null) {
      ch.filme.FeeType oldValue = feeType();
      if (oldValue != null) {
        removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _Fee.FEE_TYPE_KEY);
      }
    } else {
      addObjectToBothSidesOfRelationshipWithKey(value, _Fee.FEE_TYPE_KEY);
    }
  }

  public ch.filme.Rental rental() {
    return (ch.filme.Rental)storedValueForKey(_Fee.RENTAL_KEY);
  }

  public void setRental(ch.filme.Rental value) {
    takeStoredValueForKey(value, _Fee.RENTAL_KEY);
  }

  public void setRentalRelationship(ch.filme.Rental value) {
    log.debug("updating rental from {} to {}", rental(), value);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      setRental(value);
    }
    else if (value == null) {
      ch.filme.Rental oldValue = rental();
      if (oldValue != null) {
        removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _Fee.RENTAL_KEY);
      }
    } else {
      addObjectToBothSidesOfRelationshipWithKey(value, _Fee.RENTAL_KEY);
    }
  }


  public static Fee createFee(EOEditingContext editingContext, Double amount
, NSTimestamp datePaid
) {
    Fee eo = (Fee) EOUtilities.createAndInsertInstance(editingContext, _Fee.ENTITY_NAME);
    eo.setAmount(amount);
    eo.setDatePaid(datePaid);
    return eo;
  }

  public static ERXFetchSpecification<Fee> fetchSpec() {
    return new ERXFetchSpecification<Fee>(_Fee.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Fee> fetchAllFees(EOEditingContext editingContext) {
    return _Fee.fetchAllFees(editingContext, null);
  }

  public static NSArray<Fee> fetchAllFees(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Fee.fetchFees(editingContext, null, sortOrderings);
  }

  public static NSArray<Fee> fetchFees(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Fee> fetchSpec = new ERXFetchSpecification<Fee>(_Fee.ENTITY_NAME, qualifier, sortOrderings);
    NSArray<Fee> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Fee fetchFee(EOEditingContext editingContext, String keyName, Object value) {
    return _Fee.fetchFee(editingContext, ERXQ.equals(keyName, value));
  }

  public static Fee fetchFee(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Fee> eoObjects = _Fee.fetchFees(editingContext, qualifier, null);
    Fee eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Fee that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Fee fetchRequiredFee(EOEditingContext editingContext, String keyName, Object value) {
    return _Fee.fetchRequiredFee(editingContext, ERXQ.equals(keyName, value));
  }

  public static Fee fetchRequiredFee(EOEditingContext editingContext, EOQualifier qualifier) {
    Fee eoObject = _Fee.fetchFee(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Fee that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Fee localInstanceIn(EOEditingContext editingContext, Fee eo) {
    Fee localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
