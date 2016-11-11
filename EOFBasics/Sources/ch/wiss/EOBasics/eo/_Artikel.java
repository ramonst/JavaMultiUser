// DO NOT EDIT.  Make changes to Artikel.java instead.
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
public abstract class _Artikel extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Artikel";

  // Attribute Keys
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  public static final ERXKey<java.math.BigDecimal> PREIS = new ERXKey<java.math.BigDecimal>("preis");

  // Relationship Keys
  public static final ERXKey<ch.wiss.EOBasics.eo.Bestellposition> BESTELLPOSITIONEN = new ERXKey<ch.wiss.EOBasics.eo.Bestellposition>("bestellpositionen");

  // Attributes
  public static final String NAME_KEY = NAME.key();
  public static final String PREIS_KEY = PREIS.key();

  // Relationships
  public static final String BESTELLPOSITIONEN_KEY = BESTELLPOSITIONEN.key();

  private static final Logger log = LoggerFactory.getLogger(_Artikel.class);

  public Artikel localInstanceIn(EOEditingContext editingContext) {
    Artikel localInstance = (Artikel)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String name() {
    return (String) storedValueForKey(_Artikel.NAME_KEY);
  }

  public void setName(String value) {
    log.debug( "updating name from {} to {}", name(), value);
    takeStoredValueForKey(value, _Artikel.NAME_KEY);
  }

  public java.math.BigDecimal preis() {
    return (java.math.BigDecimal) storedValueForKey(_Artikel.PREIS_KEY);
  }

  public void setPreis(java.math.BigDecimal value) {
    log.debug( "updating preis from {} to {}", preis(), value);
    takeStoredValueForKey(value, _Artikel.PREIS_KEY);
  }

  public NSArray<ch.wiss.EOBasics.eo.Bestellposition> bestellpositionen() {
    return (NSArray<ch.wiss.EOBasics.eo.Bestellposition>)storedValueForKey(_Artikel.BESTELLPOSITIONEN_KEY);
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
      EOQualifier inverseQualifier = ERXQ.equals(ch.wiss.EOBasics.eo.Bestellposition.ARTIKEL_KEY, this);

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
    includeObjectIntoPropertyWithKey(object, _Artikel.BESTELLPOSITIONEN_KEY);
  }

  public void removeFromBestellpositionen(ch.wiss.EOBasics.eo.Bestellposition object) {
    excludeObjectFromPropertyWithKey(object, _Artikel.BESTELLPOSITIONEN_KEY);
  }

  public void addToBestellpositionenRelationship(ch.wiss.EOBasics.eo.Bestellposition object) {
    log.debug("adding {} to bestellpositionen relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      addToBestellpositionen(object);
    }
    else {
      addObjectToBothSidesOfRelationshipWithKey(object, _Artikel.BESTELLPOSITIONEN_KEY);
    }
  }

  public void removeFromBestellpositionenRelationship(ch.wiss.EOBasics.eo.Bestellposition object) {
    log.debug("removing {} from bestellpositionen relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      removeFromBestellpositionen(object);
    }
    else {
      removeObjectFromBothSidesOfRelationshipWithKey(object, _Artikel.BESTELLPOSITIONEN_KEY);
    }
  }

  public ch.wiss.EOBasics.eo.Bestellposition createBestellpositionenRelationship() {
    EOEnterpriseObject eo = EOUtilities.createAndInsertInstance(editingContext(),  ch.wiss.EOBasics.eo.Bestellposition.ENTITY_NAME );
    addObjectToBothSidesOfRelationshipWithKey(eo, _Artikel.BESTELLPOSITIONEN_KEY);
    return (ch.wiss.EOBasics.eo.Bestellposition) eo;
  }

  public void deleteBestellpositionenRelationship(ch.wiss.EOBasics.eo.Bestellposition object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Artikel.BESTELLPOSITIONEN_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllBestellpositionenRelationships() {
    Enumeration<ch.wiss.EOBasics.eo.Bestellposition> objects = bestellpositionen().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteBestellpositionenRelationship(objects.nextElement());
    }
  }


  public static Artikel createArtikel(EOEditingContext editingContext, String name
, java.math.BigDecimal preis
) {
    Artikel eo = (Artikel) EOUtilities.createAndInsertInstance(editingContext, _Artikel.ENTITY_NAME);
    eo.setName(name);
    eo.setPreis(preis);
    return eo;
  }

  public static ERXFetchSpecification<Artikel> fetchSpec() {
    return new ERXFetchSpecification<Artikel>(_Artikel.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Artikel> fetchAllArtikels(EOEditingContext editingContext) {
    return _Artikel.fetchAllArtikels(editingContext, null);
  }

  public static NSArray<Artikel> fetchAllArtikels(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Artikel.fetchArtikels(editingContext, null, sortOrderings);
  }

  public static NSArray<Artikel> fetchArtikels(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Artikel> fetchSpec = new ERXFetchSpecification<Artikel>(_Artikel.ENTITY_NAME, qualifier, sortOrderings);
    NSArray<Artikel> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Artikel fetchArtikel(EOEditingContext editingContext, String keyName, Object value) {
    return _Artikel.fetchArtikel(editingContext, ERXQ.equals(keyName, value));
  }

  public static Artikel fetchArtikel(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Artikel> eoObjects = _Artikel.fetchArtikels(editingContext, qualifier, null);
    Artikel eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Artikel that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Artikel fetchRequiredArtikel(EOEditingContext editingContext, String keyName, Object value) {
    return _Artikel.fetchRequiredArtikel(editingContext, ERXQ.equals(keyName, value));
  }

  public static Artikel fetchRequiredArtikel(EOEditingContext editingContext, EOQualifier qualifier) {
    Artikel eoObject = _Artikel.fetchArtikel(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Artikel that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Artikel localInstanceIn(EOEditingContext editingContext, Artikel eo) {
    Artikel localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
