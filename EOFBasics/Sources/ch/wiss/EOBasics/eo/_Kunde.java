// DO NOT EDIT.  Make changes to Kunde.java instead.
package ch.wiss.EOBasics.eo;

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
public abstract class _Kunde extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Kunde";

  // Attribute Keys
  public static final ERXKey<String> NACHNAME = new ERXKey<String>("nachname");
  public static final ERXKey<String> VORNAME = new ERXKey<String>("vorname");

  // Relationship Keys
  public static final ERXKey<ch.wiss.EOBasics.eo.Bestellung> BESTELLUNGEN = new ERXKey<ch.wiss.EOBasics.eo.Bestellung>("bestellungen");

  // Attributes
  public static final String NACHNAME_KEY = NACHNAME.key();
  public static final String VORNAME_KEY = VORNAME.key();

  // Relationships
  public static final String BESTELLUNGEN_KEY = BESTELLUNGEN.key();

  private static final Logger log = LoggerFactory.getLogger(_Kunde.class);

  public Kunde localInstanceIn(EOEditingContext editingContext) {
    Kunde localInstance = (Kunde)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String nachname() {
    return (String) storedValueForKey(_Kunde.NACHNAME_KEY);
  }

  public void setNachname(String value) {
    log.debug( "updating nachname from {} to {}", nachname(), value);
    takeStoredValueForKey(value, _Kunde.NACHNAME_KEY);
  }

  public String vorname() {
    return (String) storedValueForKey(_Kunde.VORNAME_KEY);
  }

  public void setVorname(String value) {
    log.debug( "updating vorname from {} to {}", vorname(), value);
    takeStoredValueForKey(value, _Kunde.VORNAME_KEY);
  }

  public NSArray<ch.wiss.EOBasics.eo.Bestellung> bestellungen() {
    return (NSArray<ch.wiss.EOBasics.eo.Bestellung>)storedValueForKey(_Kunde.BESTELLUNGEN_KEY);
  }

  public NSArray<ch.wiss.EOBasics.eo.Bestellung> bestellungen(EOQualifier qualifier) {
    return bestellungen(qualifier, null, false);
  }

  public NSArray<ch.wiss.EOBasics.eo.Bestellung> bestellungen(EOQualifier qualifier, boolean fetch) {
    return bestellungen(qualifier, null, fetch);
  }

  public NSArray<ch.wiss.EOBasics.eo.Bestellung> bestellungen(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<ch.wiss.EOBasics.eo.Bestellung> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = ERXQ.equals(ch.wiss.EOBasics.eo.Bestellung.KUNDE_KEY, this);

      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        fullQualifier = ERXQ.and(qualifier, inverseQualifier);
      }

      results = ch.wiss.EOBasics.eo.Bestellung.fetchBestellungs(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = bestellungen();
      if (qualifier != null) {
        results = (NSArray<ch.wiss.EOBasics.eo.Bestellung>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<ch.wiss.EOBasics.eo.Bestellung>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }

  public void addToBestellungen(ch.wiss.EOBasics.eo.Bestellung object) {
    includeObjectIntoPropertyWithKey(object, _Kunde.BESTELLUNGEN_KEY);
  }

  public void removeFromBestellungen(ch.wiss.EOBasics.eo.Bestellung object) {
    excludeObjectFromPropertyWithKey(object, _Kunde.BESTELLUNGEN_KEY);
  }

  public void addToBestellungenRelationship(ch.wiss.EOBasics.eo.Bestellung object) {
    log.debug("adding {} to bestellungen relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      addToBestellungen(object);
    }
    else {
      addObjectToBothSidesOfRelationshipWithKey(object, _Kunde.BESTELLUNGEN_KEY);
    }
  }

  public void removeFromBestellungenRelationship(ch.wiss.EOBasics.eo.Bestellung object) {
    log.debug("removing {} from bestellungen relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      removeFromBestellungen(object);
    }
    else {
      removeObjectFromBothSidesOfRelationshipWithKey(object, _Kunde.BESTELLUNGEN_KEY);
    }
  }

  public ch.wiss.EOBasics.eo.Bestellung createBestellungenRelationship() {
    EOEnterpriseObject eo = EOUtilities.createAndInsertInstance(editingContext(),  ch.wiss.EOBasics.eo.Bestellung.ENTITY_NAME );
    addObjectToBothSidesOfRelationshipWithKey(eo, _Kunde.BESTELLUNGEN_KEY);
    return (ch.wiss.EOBasics.eo.Bestellung) eo;
  }

  public void deleteBestellungenRelationship(ch.wiss.EOBasics.eo.Bestellung object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Kunde.BESTELLUNGEN_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllBestellungenRelationships() {
    Enumeration<ch.wiss.EOBasics.eo.Bestellung> objects = bestellungen().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteBestellungenRelationship(objects.nextElement());
    }
  }


  public static Kunde createKunde(EOEditingContext editingContext, String nachname
) {
    Kunde eo = (Kunde) EOUtilities.createAndInsertInstance(editingContext, _Kunde.ENTITY_NAME);
    eo.setNachname(nachname);
    return eo;
  }

  public static ERXFetchSpecification<Kunde> fetchSpec() {
    return new ERXFetchSpecification<Kunde>(_Kunde.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Kunde> fetchAllKundes(EOEditingContext editingContext) {
    return _Kunde.fetchAllKundes(editingContext, null);
  }

  public static NSArray<Kunde> fetchAllKundes(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Kunde.fetchKundes(editingContext, null, sortOrderings);
  }

  public static NSArray<Kunde> fetchKundes(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Kunde> fetchSpec = new ERXFetchSpecification<Kunde>(_Kunde.ENTITY_NAME, qualifier, sortOrderings);
    NSArray<Kunde> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Kunde fetchKunde(EOEditingContext editingContext, String keyName, Object value) {
    return _Kunde.fetchKunde(editingContext, ERXQ.equals(keyName, value));
  }

  public static Kunde fetchKunde(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Kunde> eoObjects = _Kunde.fetchKundes(editingContext, qualifier, null);
    Kunde eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Kunde that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Kunde fetchRequiredKunde(EOEditingContext editingContext, String keyName, Object value) {
    return _Kunde.fetchRequiredKunde(editingContext, ERXQ.equals(keyName, value));
  }

  public static Kunde fetchRequiredKunde(EOEditingContext editingContext, EOQualifier qualifier) {
    Kunde eoObject = _Kunde.fetchKunde(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Kunde that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Kunde localInstanceIn(EOEditingContext editingContext, Kunde eo) {
    Kunde localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
