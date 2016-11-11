// DO NOT EDIT.  Make changes to RentalsUser.java instead.
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
public abstract class _RentalsUser extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "RentalsUser";

  // Attribute Keys
  public static final ERXKey<Long> ACCESS_LEVEL = new ERXKey<Long>("accessLevel");
  public static final ERXKey<String> LOGIN = new ERXKey<String>("login");
  public static final ERXKey<String> PASSWORD = new ERXKey<String>("password");

  // Relationship Keys
  public static final ERXKey<ch.filme.Customer> CUSTOMER = new ERXKey<ch.filme.Customer>("customer");

  // Attributes
  public static final String ACCESS_LEVEL_KEY = ACCESS_LEVEL.key();
  public static final String LOGIN_KEY = LOGIN.key();
  public static final String PASSWORD_KEY = PASSWORD.key();

  // Relationships
  public static final String CUSTOMER_KEY = CUSTOMER.key();

  private static final Logger log = LoggerFactory.getLogger(_RentalsUser.class);

  public RentalsUser localInstanceIn(EOEditingContext editingContext) {
    RentalsUser localInstance = (RentalsUser)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Long accessLevel() {
    return (Long) storedValueForKey(_RentalsUser.ACCESS_LEVEL_KEY);
  }

  public void setAccessLevel(Long value) {
    log.debug( "updating accessLevel from {} to {}", accessLevel(), value);
    takeStoredValueForKey(value, _RentalsUser.ACCESS_LEVEL_KEY);
  }

  public String login() {
    return (String) storedValueForKey(_RentalsUser.LOGIN_KEY);
  }

  public void setLogin(String value) {
    log.debug( "updating login from {} to {}", login(), value);
    takeStoredValueForKey(value, _RentalsUser.LOGIN_KEY);
  }

  public String password() {
    return (String) storedValueForKey(_RentalsUser.PASSWORD_KEY);
  }

  public void setPassword(String value) {
    log.debug( "updating password from {} to {}", password(), value);
    takeStoredValueForKey(value, _RentalsUser.PASSWORD_KEY);
  }

  public ch.filme.Customer customer() {
    return (ch.filme.Customer)storedValueForKey(_RentalsUser.CUSTOMER_KEY);
  }

  public void setCustomer(ch.filme.Customer value) {
    takeStoredValueForKey(value, _RentalsUser.CUSTOMER_KEY);
  }

  public void setCustomerRelationship(ch.filme.Customer value) {
    log.debug("updating customer from {} to {}", customer(), value);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      setCustomer(value);
    }
    else if (value == null) {
      ch.filme.Customer oldValue = customer();
      if (oldValue != null) {
        removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _RentalsUser.CUSTOMER_KEY);
      }
    } else {
      addObjectToBothSidesOfRelationshipWithKey(value, _RentalsUser.CUSTOMER_KEY);
    }
  }


  public static RentalsUser createRentalsUser(EOEditingContext editingContext, Long accessLevel
, String login
, String password
) {
    RentalsUser eo = (RentalsUser) EOUtilities.createAndInsertInstance(editingContext, _RentalsUser.ENTITY_NAME);
    eo.setAccessLevel(accessLevel);
    eo.setLogin(login);
    eo.setPassword(password);
    return eo;
  }

  public static ERXFetchSpecification<RentalsUser> fetchSpec() {
    return new ERXFetchSpecification<RentalsUser>(_RentalsUser.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<RentalsUser> fetchAllRentalsUsers(EOEditingContext editingContext) {
    return _RentalsUser.fetchAllRentalsUsers(editingContext, null);
  }

  public static NSArray<RentalsUser> fetchAllRentalsUsers(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _RentalsUser.fetchRentalsUsers(editingContext, null, sortOrderings);
  }

  public static NSArray<RentalsUser> fetchRentalsUsers(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<RentalsUser> fetchSpec = new ERXFetchSpecification<RentalsUser>(_RentalsUser.ENTITY_NAME, qualifier, sortOrderings);
    NSArray<RentalsUser> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static RentalsUser fetchRentalsUser(EOEditingContext editingContext, String keyName, Object value) {
    return _RentalsUser.fetchRentalsUser(editingContext, ERXQ.equals(keyName, value));
  }

  public static RentalsUser fetchRentalsUser(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<RentalsUser> eoObjects = _RentalsUser.fetchRentalsUsers(editingContext, qualifier, null);
    RentalsUser eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one RentalsUser that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static RentalsUser fetchRequiredRentalsUser(EOEditingContext editingContext, String keyName, Object value) {
    return _RentalsUser.fetchRequiredRentalsUser(editingContext, ERXQ.equals(keyName, value));
  }

  public static RentalsUser fetchRequiredRentalsUser(EOEditingContext editingContext, EOQualifier qualifier) {
    RentalsUser eoObject = _RentalsUser.fetchRentalsUser(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no RentalsUser that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static RentalsUser localInstanceIn(EOEditingContext editingContext, RentalsUser eo) {
    RentalsUser localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
