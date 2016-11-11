// DO NOT EDIT.  Make changes to Bestellung.java instead.
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
public abstract class _Bestellung extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Bestellung";

  // Attribute Keys
  public static final ERXKey<NSTimestamp> DATUM = new ERXKey<NSTimestamp>("datum");

  // Relationship Keys
  public static final ERXKey<ch.wiss.EOBasics.eo.Bestellposition> BESTELLPOSITIONEN = new ERXKey<ch.wiss.EOBasics.eo.Bestellposition>("bestellpositionen");
  public static final ERXKey<ch.wiss.EOBasics.eo.Kunde> KUNDE = new ERXKey<ch.wiss.EOBasics.eo.Kunde>("kunde");

  // Attributes
  public static final String DATUM_KEY = DATUM.key();

  // Relationships
  public static final String BESTELLPOSITIONEN_KEY = BESTELLPOSITIONEN.key();
  public static final String KUNDE_KEY = KUNDE.key();

  private static final Logger log = LoggerFactory.getLogger(_Bestellung.class);

  public Bestellung localInstanceIn(EOEditingContext editingContext) {
    Bestellung localInstance = (Bestellung)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public NSTimestamp datum() {
    return (NSTimestamp) storedValueForKey(_Bestellung.DATUM_KEY);
  }

  public void setDatum(NSTimestamp value) {
    log.debug( "updating datum from {} to {}", datum(), value);
    takeStoredValueForKey(value, _Bestellung.DATUM_KEY);
  }

  public ch.wiss.EOBasics.eo.Kunde kunde() {
    return (ch.wiss.EOBasics.eo.Kunde)storedValueForKey(_Bestellung.KUNDE_KEY);
  }

  public void setKunde(ch.wiss.EOBasics.eo.Kunde value) {
    takeStoredValueForKey(value, _Bestellung.KUNDE_KEY);
  }

  public void setKundeRelationship(ch.wiss.EOBasics.eo.Kunde value) {
    log.debug("updating kunde from {} to {}", kunde(), value);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      setKunde(value);
    }
    else if (value == null) {
      ch.wiss.EOBasics.eo.Kunde oldValue = kunde();
      if (oldValue != null) {
        removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _Bestellung.KUNDE_KEY);
      }
    } else {
      addObjectToBothSidesOfRelationshipWithKey(value, _Bestellung.KUNDE_KEY);
    }
  }

  public NSArray<ch.wiss.EOBasics.eo.Bestellposition> bestellpositionen() {
    return (NSArray<ch.wiss.EOBasics.eo.Bestellposition>)storedValueForKey(_Bestellung.BESTELLPOSITIONEN_KEY);
  }

  public NSArray<ch.wiss.EOBasics.eo.Bestellposition> bestellpositionen(EOQualifier qualifier) {
    return bestellpositionen(qualifier, null, false);
  }

  public NSArray<ch.wiss.EOBasics.eo.Bestellposition> bestellpositionen(EOQualifier qualifier, boolean fetch) {
    return bestellpositionen(qualifier, null, fetch);
  }

  public NSArray<ch.wiss.EOBasics.eo.Bestellposition> bestellpositionen(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<ch.wiss.EOBasics.eo.Bestellposition> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = ERXQ.equals(ch.wiss.EOBasics.eo.Bestellposition.BESTELLUNG_KEY, this);

      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        fullQualifier = ERXQ.and(qualifier, inverseQualifier);
      }

      results = ch.wiss.EOBasics.eo.Bestellposition.fetchBestellpositions(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = bestellpositionen();
      if (qualifier != null) {
        results = (NSArray<ch.wiss.EOBasics.eo.Bestellposition>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<ch.wiss.EOBasics.eo.Bestellposition>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }

  public void addToBestellpositionen(ch.wiss.EOBasics.eo.Bestellposition object) {
    includeObjectIntoPropertyWithKey(object, _Bestellung.BESTELLPOSITIONEN_KEY);
  }

  public void removeFromBestellpositionen(ch.wiss.EOBasics.eo.Bestellposition object) {
    excludeObjectFromPropertyWithKey(object, _Bestellung.BESTELLPOSITIONEN_KEY);
  }

  public void addToBestellpositionenRelationship(ch.wiss.EOBasics.eo.Bestellposition object) {
    log.debug("adding {} to bestellpositionen relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      addToBestellpositionen(object);
    }
    else {
      addObjectToBothSidesOfRelationshipWithKey(object, _Bestellung.BESTELLPOSITIONEN_KEY);
    }
  }

  public void removeFromBestellpositionenRelationship(ch.wiss.EOBasics.eo.Bestellposition object) {
    log.debug("removing {} from bestellpositionen relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      removeFromBestellpositionen(object);
    }
    else {
      removeObjectFromBothSidesOfRelationshipWithKey(object, _Bestellung.BESTELLPOSITIONEN_KEY);
    }
  }

  public ch.wiss.EOBasics.eo.Bestellposition createBestellpositionenRelationship() {
    EOEnterpriseObject eo = EOUtilities.createAndInsertInstance(editingContext(),  ch.wiss.EOBasics.eo.Bestellposition.ENTITY_NAME );
    addObjectToBothSidesOfRelationshipWithKey(eo, _Bestellung.BESTELLPOSITIONEN_KEY);
    return (ch.wiss.EOBasics.eo.Bestellposition) eo;
  }

  public void deleteBestellpositionenRelationship(ch.wiss.EOBasics.eo.Bestellposition object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Bestellung.BESTELLPOSITIONEN_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllBestellpositionenRelationships() {
    Enumeration<ch.wiss.EOBasics.eo.Bestellposition> objects = bestellpositionen().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteBestellpositionenRelationship(objects.nextElement());
    }
  }


  public static Bestellung createBestellung(EOEditingContext editingContext, NSTimestamp datum
, ch.wiss.EOBasics.eo.Kunde kunde) {
    Bestellung eo = (Bestellung) EOUtilities.createAndInsertInstance(editingContext, _Bestellung.ENTITY_NAME);
    eo.setDatum(datum);
    eo.setKundeRelationship(kunde);
    return eo;
  }

  public static ERXFetchSpecification<Bestellung> fetchSpec() {
    return new ERXFetchSpecification<Bestellung>(_Bestellung.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Bestellung> fetchAllBestellungs(EOEditingContext editingContext) {
    return _Bestellung.fetchAllBestellungs(editingContext, null);
  }

  public static NSArray<Bestellung> fetchAllBestellungs(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Bestellung.fetchBestellungs(editingContext, null, sortOrderings);
  }

  public static NSArray<Bestellung> fetchBestellungs(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Bestellung> fetchSpec = new ERXFetchSpecification<Bestellung>(_Bestellung.ENTITY_NAME, qualifier, sortOrderings);
    NSArray<Bestellung> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Bestellung fetchBestellung(EOEditingContext editingContext, String keyName, Object value) {
    return _Bestellung.fetchBestellung(editingContext, ERXQ.equals(keyName, value));
  }

  public static Bestellung fetchBestellung(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Bestellung> eoObjects = _Bestellung.fetchBestellungs(editingContext, qualifier, null);
    Bestellung eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Bestellung that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Bestellung fetchRequiredBestellung(EOEditingContext editingContext, String keyName, Object value) {
    return _Bestellung.fetchRequiredBestellung(editingContext, ERXQ.equals(keyName, value));
  }

  public static Bestellung fetchRequiredBestellung(EOEditingContext editingContext, EOQualifier qualifier) {
    Bestellung eoObject = _Bestellung.fetchBestellung(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Bestellung that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Bestellung localInstanceIn(EOEditingContext editingContext, Bestellung eo) {
    Bestellung localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
