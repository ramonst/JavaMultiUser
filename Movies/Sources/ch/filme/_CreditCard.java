// DO NOT EDIT.  Make changes to CreditCard.java instead.
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
public abstract class _CreditCard extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "CreditCard";

  // Attribute Keys
  public static final ERXKey<NSTimestamp> AUTHORIZATION_DATE = new ERXKey<NSTimestamp>("authorizationDate");
  public static final ERXKey<String> AUTHORIZATION_NUM = new ERXKey<String>("authorizationNum");
  public static final ERXKey<String> CARD_NUMBER = new ERXKey<String>("cardNumber");
  public static final ERXKey<Double> CLIMIT = new ERXKey<Double>("climit");
  public static final ERXKey<NSTimestamp> EXPIRATION_DATE = new ERXKey<NSTimestamp>("expirationDate");

  // Relationship Keys
  public static final ERXKey<ch.filme.Customer> CUSTOMER = new ERXKey<ch.filme.Customer>("customer");

  // Attributes
  public static final String AUTHORIZATION_DATE_KEY = AUTHORIZATION_DATE.key();
  public static final String AUTHORIZATION_NUM_KEY = AUTHORIZATION_NUM.key();
  public static final String CARD_NUMBER_KEY = CARD_NUMBER.key();
  public static final String CLIMIT_KEY = CLIMIT.key();
  public static final String EXPIRATION_DATE_KEY = EXPIRATION_DATE.key();

  // Relationships
  public static final String CUSTOMER_KEY = CUSTOMER.key();

  private static final Logger log = LoggerFactory.getLogger(_CreditCard.class);

  public CreditCard localInstanceIn(EOEditingContext editingContext) {
    CreditCard localInstance = (CreditCard)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public NSTimestamp authorizationDate() {
    return (NSTimestamp) storedValueForKey(_CreditCard.AUTHORIZATION_DATE_KEY);
  }

  public void setAuthorizationDate(NSTimestamp value) {
    log.debug( "updating authorizationDate from {} to {}", authorizationDate(), value);
    takeStoredValueForKey(value, _CreditCard.AUTHORIZATION_DATE_KEY);
  }

  public String authorizationNum() {
    return (String) storedValueForKey(_CreditCard.AUTHORIZATION_NUM_KEY);
  }

  public void setAuthorizationNum(String value) {
    log.debug( "updating authorizationNum from {} to {}", authorizationNum(), value);
    takeStoredValueForKey(value, _CreditCard.AUTHORIZATION_NUM_KEY);
  }

  public String cardNumber() {
    return (String) storedValueForKey(_CreditCard.CARD_NUMBER_KEY);
  }

  public void setCardNumber(String value) {
    log.debug( "updating cardNumber from {} to {}", cardNumber(), value);
    takeStoredValueForKey(value, _CreditCard.CARD_NUMBER_KEY);
  }

  public Double climit() {
    return (Double) storedValueForKey(_CreditCard.CLIMIT_KEY);
  }

  public void setClimit(Double value) {
    log.debug( "updating climit from {} to {}", climit(), value);
    takeStoredValueForKey(value, _CreditCard.CLIMIT_KEY);
  }

  public NSTimestamp expirationDate() {
    return (NSTimestamp) storedValueForKey(_CreditCard.EXPIRATION_DATE_KEY);
  }

  public void setExpirationDate(NSTimestamp value) {
    log.debug( "updating expirationDate from {} to {}", expirationDate(), value);
    takeStoredValueForKey(value, _CreditCard.EXPIRATION_DATE_KEY);
  }

  public ch.filme.Customer customer() {
    return (ch.filme.Customer)storedValueForKey(_CreditCard.CUSTOMER_KEY);
  }

  public void setCustomer(ch.filme.Customer value) {
    takeStoredValueForKey(value, _CreditCard.CUSTOMER_KEY);
  }

  public void setCustomerRelationship(ch.filme.Customer value) {
    log.debug("updating customer from {} to {}", customer(), value);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      setCustomer(value);
    }
    else if (value == null) {
      ch.filme.Customer oldValue = customer();
      if (oldValue != null) {
        removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _CreditCard.CUSTOMER_KEY);
      }
    } else {
      addObjectToBothSidesOfRelationshipWithKey(value, _CreditCard.CUSTOMER_KEY);
    }
  }


  public static CreditCard createCreditCard(EOEditingContext editingContext, NSTimestamp authorizationDate
, String authorizationNum
, String cardNumber
, Double climit
, NSTimestamp expirationDate
) {
    CreditCard eo = (CreditCard) EOUtilities.createAndInsertInstance(editingContext, _CreditCard.ENTITY_NAME);
    eo.setAuthorizationDate(authorizationDate);
    eo.setAuthorizationNum(authorizationNum);
    eo.setCardNumber(cardNumber);
    eo.setClimit(climit);
    eo.setExpirationDate(expirationDate);
    return eo;
  }

  public static ERXFetchSpecification<CreditCard> fetchSpec() {
    return new ERXFetchSpecification<CreditCard>(_CreditCard.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<CreditCard> fetchAllCreditCards(EOEditingContext editingContext) {
    return _CreditCard.fetchAllCreditCards(editingContext, null);
  }

  public static NSArray<CreditCard> fetchAllCreditCards(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _CreditCard.fetchCreditCards(editingContext, null, sortOrderings);
  }

  public static NSArray<CreditCard> fetchCreditCards(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<CreditCard> fetchSpec = new ERXFetchSpecification<CreditCard>(_CreditCard.ENTITY_NAME, qualifier, sortOrderings);
    NSArray<CreditCard> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static CreditCard fetchCreditCard(EOEditingContext editingContext, String keyName, Object value) {
    return _CreditCard.fetchCreditCard(editingContext, ERXQ.equals(keyName, value));
  }

  public static CreditCard fetchCreditCard(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<CreditCard> eoObjects = _CreditCard.fetchCreditCards(editingContext, qualifier, null);
    CreditCard eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one CreditCard that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static CreditCard fetchRequiredCreditCard(EOEditingContext editingContext, String keyName, Object value) {
    return _CreditCard.fetchRequiredCreditCard(editingContext, ERXQ.equals(keyName, value));
  }

  public static CreditCard fetchRequiredCreditCard(EOEditingContext editingContext, EOQualifier qualifier) {
    CreditCard eoObject = _CreditCard.fetchCreditCard(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no CreditCard that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static CreditCard localInstanceIn(EOEditingContext editingContext, CreditCard eo) {
    CreditCard localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
