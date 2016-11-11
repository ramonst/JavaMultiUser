// DO NOT EDIT.  Make changes to Customer.java instead.
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
public abstract class _Customer extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Customer";

  // Attribute Keys
  public static final ERXKey<String> CITY = new ERXKey<String>("city");
  public static final ERXKey<String> FIRST_NAME = new ERXKey<String>("firstName");
  public static final ERXKey<String> LAST_NAME = new ERXKey<String>("lastName");
  public static final ERXKey<NSTimestamp> MEMBER_SINCE = new ERXKey<NSTimestamp>("memberSince");
  public static final ERXKey<String> PHONE = new ERXKey<String>("phone");
  public static final ERXKey<String> STATE = new ERXKey<String>("state");
  public static final ERXKey<String> STREET_ADDRESS = new ERXKey<String>("streetAddress");
  public static final ERXKey<String> ZIP = new ERXKey<String>("zip");

  // Relationship Keys
  public static final ERXKey<ch.filme.CreditCard> CREDIT_CARDS = new ERXKey<ch.filme.CreditCard>("creditCards");
  public static final ERXKey<ch.filme.Rental> RENTALS = new ERXKey<ch.filme.Rental>("rentals");
  public static final ERXKey<ch.filme.RentalsUser> RENTALS_USERS = new ERXKey<ch.filme.RentalsUser>("rentalsUsers");

  // Attributes
  public static final String CITY_KEY = CITY.key();
  public static final String FIRST_NAME_KEY = FIRST_NAME.key();
  public static final String LAST_NAME_KEY = LAST_NAME.key();
  public static final String MEMBER_SINCE_KEY = MEMBER_SINCE.key();
  public static final String PHONE_KEY = PHONE.key();
  public static final String STATE_KEY = STATE.key();
  public static final String STREET_ADDRESS_KEY = STREET_ADDRESS.key();
  public static final String ZIP_KEY = ZIP.key();

  // Relationships
  public static final String CREDIT_CARDS_KEY = CREDIT_CARDS.key();
  public static final String RENTALS_KEY = RENTALS.key();
  public static final String RENTALS_USERS_KEY = RENTALS_USERS.key();

  private static final Logger log = LoggerFactory.getLogger(_Customer.class);

  public Customer localInstanceIn(EOEditingContext editingContext) {
    Customer localInstance = (Customer)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String city() {
    return (String) storedValueForKey(_Customer.CITY_KEY);
  }

  public void setCity(String value) {
    log.debug( "updating city from {} to {}", city(), value);
    takeStoredValueForKey(value, _Customer.CITY_KEY);
  }

  public String firstName() {
    return (String) storedValueForKey(_Customer.FIRST_NAME_KEY);
  }

  public void setFirstName(String value) {
    log.debug( "updating firstName from {} to {}", firstName(), value);
    takeStoredValueForKey(value, _Customer.FIRST_NAME_KEY);
  }

  public String lastName() {
    return (String) storedValueForKey(_Customer.LAST_NAME_KEY);
  }

  public void setLastName(String value) {
    log.debug( "updating lastName from {} to {}", lastName(), value);
    takeStoredValueForKey(value, _Customer.LAST_NAME_KEY);
  }

  public NSTimestamp memberSince() {
    return (NSTimestamp) storedValueForKey(_Customer.MEMBER_SINCE_KEY);
  }

  public void setMemberSince(NSTimestamp value) {
    log.debug( "updating memberSince from {} to {}", memberSince(), value);
    takeStoredValueForKey(value, _Customer.MEMBER_SINCE_KEY);
  }

  public String phone() {
    return (String) storedValueForKey(_Customer.PHONE_KEY);
  }

  public void setPhone(String value) {
    log.debug( "updating phone from {} to {}", phone(), value);
    takeStoredValueForKey(value, _Customer.PHONE_KEY);
  }

  public String state() {
    return (String) storedValueForKey(_Customer.STATE_KEY);
  }

  public void setState(String value) {
    log.debug( "updating state from {} to {}", state(), value);
    takeStoredValueForKey(value, _Customer.STATE_KEY);
  }

  public String streetAddress() {
    return (String) storedValueForKey(_Customer.STREET_ADDRESS_KEY);
  }

  public void setStreetAddress(String value) {
    log.debug( "updating streetAddress from {} to {}", streetAddress(), value);
    takeStoredValueForKey(value, _Customer.STREET_ADDRESS_KEY);
  }

  public String zip() {
    return (String) storedValueForKey(_Customer.ZIP_KEY);
  }

  public void setZip(String value) {
    log.debug( "updating zip from {} to {}", zip(), value);
    takeStoredValueForKey(value, _Customer.ZIP_KEY);
  }

  public NSArray<ch.filme.CreditCard> creditCards() {
    return (NSArray<ch.filme.CreditCard>)storedValueForKey(_Customer.CREDIT_CARDS_KEY);
  }

  public NSArray<ch.filme.CreditCard> creditCards(EOQualifier qualifier) {
    return creditCards(qualifier, null, false);
  }

  public NSArray<ch.filme.CreditCard> creditCards(EOQualifier qualifier, boolean fetch) {
    return creditCards(qualifier, null, fetch);
  }

  public NSArray<ch.filme.CreditCard> creditCards(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<ch.filme.CreditCard> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = ERXQ.equals(ch.filme.CreditCard.CUSTOMER_KEY, this);

      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        fullQualifier = ERXQ.and(qualifier, inverseQualifier);
      }

      results = ch.filme.CreditCard.fetchCreditCards(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = creditCards();
      if (qualifier != null) {
        results = (NSArray<ch.filme.CreditCard>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<ch.filme.CreditCard>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }

  public void addToCreditCards(ch.filme.CreditCard object) {
    includeObjectIntoPropertyWithKey(object, _Customer.CREDIT_CARDS_KEY);
  }

  public void removeFromCreditCards(ch.filme.CreditCard object) {
    excludeObjectFromPropertyWithKey(object, _Customer.CREDIT_CARDS_KEY);
  }

  public void addToCreditCardsRelationship(ch.filme.CreditCard object) {
    log.debug("adding {} to creditCards relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      addToCreditCards(object);
    }
    else {
      addObjectToBothSidesOfRelationshipWithKey(object, _Customer.CREDIT_CARDS_KEY);
    }
  }

  public void removeFromCreditCardsRelationship(ch.filme.CreditCard object) {
    log.debug("removing {} from creditCards relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      removeFromCreditCards(object);
    }
    else {
      removeObjectFromBothSidesOfRelationshipWithKey(object, _Customer.CREDIT_CARDS_KEY);
    }
  }

  public ch.filme.CreditCard createCreditCardsRelationship() {
    EOEnterpriseObject eo = EOUtilities.createAndInsertInstance(editingContext(),  ch.filme.CreditCard.ENTITY_NAME );
    addObjectToBothSidesOfRelationshipWithKey(eo, _Customer.CREDIT_CARDS_KEY);
    return (ch.filme.CreditCard) eo;
  }

  public void deleteCreditCardsRelationship(ch.filme.CreditCard object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Customer.CREDIT_CARDS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllCreditCardsRelationships() {
    Enumeration<ch.filme.CreditCard> objects = creditCards().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteCreditCardsRelationship(objects.nextElement());
    }
  }

  public NSArray<ch.filme.Rental> rentals() {
    return (NSArray<ch.filme.Rental>)storedValueForKey(_Customer.RENTALS_KEY);
  }

  public NSArray<ch.filme.Rental> rentals(EOQualifier qualifier) {
    return rentals(qualifier, null, false);
  }

  public NSArray<ch.filme.Rental> rentals(EOQualifier qualifier, boolean fetch) {
    return rentals(qualifier, null, fetch);
  }

  public NSArray<ch.filme.Rental> rentals(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<ch.filme.Rental> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = ERXQ.equals(ch.filme.Rental.CUSTOMER_KEY, this);

      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        fullQualifier = ERXQ.and(qualifier, inverseQualifier);
      }

      results = ch.filme.Rental.fetchRentals(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = rentals();
      if (qualifier != null) {
        results = (NSArray<ch.filme.Rental>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<ch.filme.Rental>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }

  public void addToRentals(ch.filme.Rental object) {
    includeObjectIntoPropertyWithKey(object, _Customer.RENTALS_KEY);
  }

  public void removeFromRentals(ch.filme.Rental object) {
    excludeObjectFromPropertyWithKey(object, _Customer.RENTALS_KEY);
  }

  public void addToRentalsRelationship(ch.filme.Rental object) {
    log.debug("adding {} to rentals relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      addToRentals(object);
    }
    else {
      addObjectToBothSidesOfRelationshipWithKey(object, _Customer.RENTALS_KEY);
    }
  }

  public void removeFromRentalsRelationship(ch.filme.Rental object) {
    log.debug("removing {} from rentals relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      removeFromRentals(object);
    }
    else {
      removeObjectFromBothSidesOfRelationshipWithKey(object, _Customer.RENTALS_KEY);
    }
  }

  public ch.filme.Rental createRentalsRelationship() {
    EOEnterpriseObject eo = EOUtilities.createAndInsertInstance(editingContext(),  ch.filme.Rental.ENTITY_NAME );
    addObjectToBothSidesOfRelationshipWithKey(eo, _Customer.RENTALS_KEY);
    return (ch.filme.Rental) eo;
  }

  public void deleteRentalsRelationship(ch.filme.Rental object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Customer.RENTALS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllRentalsRelationships() {
    Enumeration<ch.filme.Rental> objects = rentals().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteRentalsRelationship(objects.nextElement());
    }
  }

  public NSArray<ch.filme.RentalsUser> rentalsUsers() {
    return (NSArray<ch.filme.RentalsUser>)storedValueForKey(_Customer.RENTALS_USERS_KEY);
  }

  public NSArray<ch.filme.RentalsUser> rentalsUsers(EOQualifier qualifier) {
    return rentalsUsers(qualifier, null, false);
  }

  public NSArray<ch.filme.RentalsUser> rentalsUsers(EOQualifier qualifier, boolean fetch) {
    return rentalsUsers(qualifier, null, fetch);
  }

  public NSArray<ch.filme.RentalsUser> rentalsUsers(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<ch.filme.RentalsUser> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = ERXQ.equals(ch.filme.RentalsUser.CUSTOMER_KEY, this);

      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        fullQualifier = ERXQ.and(qualifier, inverseQualifier);
      }

      results = ch.filme.RentalsUser.fetchRentalsUsers(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = rentalsUsers();
      if (qualifier != null) {
        results = (NSArray<ch.filme.RentalsUser>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<ch.filme.RentalsUser>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }

  public void addToRentalsUsers(ch.filme.RentalsUser object) {
    includeObjectIntoPropertyWithKey(object, _Customer.RENTALS_USERS_KEY);
  }

  public void removeFromRentalsUsers(ch.filme.RentalsUser object) {
    excludeObjectFromPropertyWithKey(object, _Customer.RENTALS_USERS_KEY);
  }

  public void addToRentalsUsersRelationship(ch.filme.RentalsUser object) {
    log.debug("adding {} to rentalsUsers relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      addToRentalsUsers(object);
    }
    else {
      addObjectToBothSidesOfRelationshipWithKey(object, _Customer.RENTALS_USERS_KEY);
    }
  }

  public void removeFromRentalsUsersRelationship(ch.filme.RentalsUser object) {
    log.debug("removing {} from rentalsUsers relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      removeFromRentalsUsers(object);
    }
    else {
      removeObjectFromBothSidesOfRelationshipWithKey(object, _Customer.RENTALS_USERS_KEY);
    }
  }

  public ch.filme.RentalsUser createRentalsUsersRelationship() {
    EOEnterpriseObject eo = EOUtilities.createAndInsertInstance(editingContext(),  ch.filme.RentalsUser.ENTITY_NAME );
    addObjectToBothSidesOfRelationshipWithKey(eo, _Customer.RENTALS_USERS_KEY);
    return (ch.filme.RentalsUser) eo;
  }

  public void deleteRentalsUsersRelationship(ch.filme.RentalsUser object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Customer.RENTALS_USERS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllRentalsUsersRelationships() {
    Enumeration<ch.filme.RentalsUser> objects = rentalsUsers().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteRentalsUsersRelationship(objects.nextElement());
    }
  }


  public static Customer createCustomer(EOEditingContext editingContext, String city
, String firstName
, String lastName
, NSTimestamp memberSince
, String phone
, String streetAddress
, String zip
) {
    Customer eo = (Customer) EOUtilities.createAndInsertInstance(editingContext, _Customer.ENTITY_NAME);
    eo.setCity(city);
    eo.setFirstName(firstName);
    eo.setLastName(lastName);
    eo.setMemberSince(memberSince);
    eo.setPhone(phone);
    eo.setStreetAddress(streetAddress);
    eo.setZip(zip);
    return eo;
  }

  public static ERXFetchSpecification<Customer> fetchSpec() {
    return new ERXFetchSpecification<Customer>(_Customer.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Customer> fetchAllCustomers(EOEditingContext editingContext) {
    return _Customer.fetchAllCustomers(editingContext, null);
  }

  public static NSArray<Customer> fetchAllCustomers(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Customer.fetchCustomers(editingContext, null, sortOrderings);
  }

  public static NSArray<Customer> fetchCustomers(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Customer> fetchSpec = new ERXFetchSpecification<Customer>(_Customer.ENTITY_NAME, qualifier, sortOrderings);
    NSArray<Customer> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Customer fetchCustomer(EOEditingContext editingContext, String keyName, Object value) {
    return _Customer.fetchCustomer(editingContext, ERXQ.equals(keyName, value));
  }

  public static Customer fetchCustomer(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Customer> eoObjects = _Customer.fetchCustomers(editingContext, qualifier, null);
    Customer eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Customer that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Customer fetchRequiredCustomer(EOEditingContext editingContext, String keyName, Object value) {
    return _Customer.fetchRequiredCustomer(editingContext, ERXQ.equals(keyName, value));
  }

  public static Customer fetchRequiredCustomer(EOEditingContext editingContext, EOQualifier qualifier) {
    Customer eoObject = _Customer.fetchCustomer(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Customer that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Customer localInstanceIn(EOEditingContext editingContext, Customer eo) {
    Customer localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
