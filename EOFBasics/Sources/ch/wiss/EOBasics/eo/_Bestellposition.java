// DO NOT EDIT.  Make changes to Bestellposition.java instead.
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
public abstract class _Bestellposition extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Bestellposition";

  // Attribute Keys

  // Relationship Keys
  public static final ERXKey<ch.wiss.EOBasics.eo.Artikel> ARTIKEL = new ERXKey<ch.wiss.EOBasics.eo.Artikel>("artikel");
  public static final ERXKey<ch.wiss.EOBasics.eo.Bestellung> BESTELLUNG = new ERXKey<ch.wiss.EOBasics.eo.Bestellung>("bestellung");

  // Attributes

  // Relationships
  public static final String ARTIKEL_KEY = ARTIKEL.key();
  public static final String BESTELLUNG_KEY = BESTELLUNG.key();

  private static final Logger log = LoggerFactory.getLogger(_Bestellposition.class);

  public Bestellposition localInstanceIn(EOEditingContext editingContext) {
    Bestellposition localInstance = (Bestellposition)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public ch.wiss.EOBasics.eo.Artikel artikel() {
    return (ch.wiss.EOBasics.eo.Artikel)storedValueForKey(_Bestellposition.ARTIKEL_KEY);
  }

  public void setArtikel(ch.wiss.EOBasics.eo.Artikel value) {
    takeStoredValueForKey(value, _Bestellposition.ARTIKEL_KEY);
  }

  public void setArtikelRelationship(ch.wiss.EOBasics.eo.Artikel value) {
    log.debug("updating artikel from {} to {}", artikel(), value);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      setArtikel(value);
    }
    else if (value == null) {
      ch.wiss.EOBasics.eo.Artikel oldValue = artikel();
      if (oldValue != null) {
        removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _Bestellposition.ARTIKEL_KEY);
      }
    } else {
      addObjectToBothSidesOfRelationshipWithKey(value, _Bestellposition.ARTIKEL_KEY);
    }
  }

  public ch.wiss.EOBasics.eo.Bestellung bestellung() {
    return (ch.wiss.EOBasics.eo.Bestellung)storedValueForKey(_Bestellposition.BESTELLUNG_KEY);
  }

  public void setBestellung(ch.wiss.EOBasics.eo.Bestellung value) {
    takeStoredValueForKey(value, _Bestellposition.BESTELLUNG_KEY);
  }

  public void setBestellungRelationship(ch.wiss.EOBasics.eo.Bestellung value) {
    log.debug("updating bestellung from {} to {}", bestellung(), value);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      setBestellung(value);
    }
    else if (value == null) {
      ch.wiss.EOBasics.eo.Bestellung oldValue = bestellung();
      if (oldValue != null) {
        removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _Bestellposition.BESTELLUNG_KEY);
      }
    } else {
      addObjectToBothSidesOfRelationshipWithKey(value, _Bestellposition.BESTELLUNG_KEY);
    }
  }


  public static Bestellposition createBestellposition(EOEditingContext editingContext, ch.wiss.EOBasics.eo.Artikel artikel, ch.wiss.EOBasics.eo.Bestellung bestellung) {
    Bestellposition eo = (Bestellposition) EOUtilities.createAndInsertInstance(editingContext, _Bestellposition.ENTITY_NAME);
    eo.setArtikelRelationship(artikel);
    eo.setBestellungRelationship(bestellung);
    return eo;
  }

  public static ERXFetchSpecification<Bestellposition> fetchSpec() {
    return new ERXFetchSpecification<Bestellposition>(_Bestellposition.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Bestellposition> fetchAllBestellpositions(EOEditingContext editingContext) {
    return _Bestellposition.fetchAllBestellpositions(editingContext, null);
  }

  public static NSArray<Bestellposition> fetchAllBestellpositions(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Bestellposition.fetchBestellpositions(editingContext, null, sortOrderings);
  }

  public static NSArray<Bestellposition> fetchBestellpositions(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Bestellposition> fetchSpec = new ERXFetchSpecification<Bestellposition>(_Bestellposition.ENTITY_NAME, qualifier, sortOrderings);
    NSArray<Bestellposition> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Bestellposition fetchBestellposition(EOEditingContext editingContext, String keyName, Object value) {
    return _Bestellposition.fetchBestellposition(editingContext, ERXQ.equals(keyName, value));
  }

  public static Bestellposition fetchBestellposition(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Bestellposition> eoObjects = _Bestellposition.fetchBestellpositions(editingContext, qualifier, null);
    Bestellposition eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Bestellposition that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Bestellposition fetchRequiredBestellposition(EOEditingContext editingContext, String keyName, Object value) {
    return _Bestellposition.fetchRequiredBestellposition(editingContext, ERXQ.equals(keyName, value));
  }

  public static Bestellposition fetchRequiredBestellposition(EOEditingContext editingContext, EOQualifier qualifier) {
    Bestellposition eoObject = _Bestellposition.fetchBestellposition(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Bestellposition that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Bestellposition localInstanceIn(EOEditingContext editingContext, Bestellposition eo) {
    Bestellposition localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
