// DO NOT EDIT.  Make changes to Unit.java instead.
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
public abstract class _Unit extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Unit";

  // Attribute Keys
  public static final ERXKey<NSTimestamp> DATE_ACQUIRED = new ERXKey<NSTimestamp>("dateAcquired");
  public static final ERXKey<String> NOTES = new ERXKey<String>("notes");

  // Relationship Keys
  public static final ERXKey<ch.filme.Rental> RENTALS = new ERXKey<ch.filme.Rental>("rentals");
  public static final ERXKey<ch.filme.Video> VIDEO = new ERXKey<ch.filme.Video>("video");

  // Attributes
  public static final String DATE_ACQUIRED_KEY = DATE_ACQUIRED.key();
  public static final String NOTES_KEY = NOTES.key();

  // Relationships
  public static final String RENTALS_KEY = RENTALS.key();
  public static final String VIDEO_KEY = VIDEO.key();

  private static final Logger log = LoggerFactory.getLogger(_Unit.class);

  public Unit localInstanceIn(EOEditingContext editingContext) {
    Unit localInstance = (Unit)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public NSTimestamp dateAcquired() {
    return (NSTimestamp) storedValueForKey(_Unit.DATE_ACQUIRED_KEY);
  }

  public void setDateAcquired(NSTimestamp value) {
    log.debug( "updating dateAcquired from {} to {}", dateAcquired(), value);
    takeStoredValueForKey(value, _Unit.DATE_ACQUIRED_KEY);
  }

  public String notes() {
    return (String) storedValueForKey(_Unit.NOTES_KEY);
  }

  public void setNotes(String value) {
    log.debug( "updating notes from {} to {}", notes(), value);
    takeStoredValueForKey(value, _Unit.NOTES_KEY);
  }

  public ch.filme.Video video() {
    return (ch.filme.Video)storedValueForKey(_Unit.VIDEO_KEY);
  }

  public void setVideo(ch.filme.Video value) {
    takeStoredValueForKey(value, _Unit.VIDEO_KEY);
  }

  public void setVideoRelationship(ch.filme.Video value) {
    log.debug("updating video from {} to {}", video(), value);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      setVideo(value);
    }
    else if (value == null) {
      ch.filme.Video oldValue = video();
      if (oldValue != null) {
        removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _Unit.VIDEO_KEY);
      }
    } else {
      addObjectToBothSidesOfRelationshipWithKey(value, _Unit.VIDEO_KEY);
    }
  }

  public NSArray<ch.filme.Rental> rentals() {
    return (NSArray<ch.filme.Rental>)storedValueForKey(_Unit.RENTALS_KEY);
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
      EOQualifier inverseQualifier = ERXQ.equals(ch.filme.Rental.UNIT_KEY, this);

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
    includeObjectIntoPropertyWithKey(object, _Unit.RENTALS_KEY);
  }

  public void removeFromRentals(ch.filme.Rental object) {
    excludeObjectFromPropertyWithKey(object, _Unit.RENTALS_KEY);
  }

  public void addToRentalsRelationship(ch.filme.Rental object) {
    log.debug("adding {} to rentals relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      addToRentals(object);
    }
    else {
      addObjectToBothSidesOfRelationshipWithKey(object, _Unit.RENTALS_KEY);
    }
  }

  public void removeFromRentalsRelationship(ch.filme.Rental object) {
    log.debug("removing {} from rentals relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      removeFromRentals(object);
    }
    else {
      removeObjectFromBothSidesOfRelationshipWithKey(object, _Unit.RENTALS_KEY);
    }
  }

  public ch.filme.Rental createRentalsRelationship() {
    EOEnterpriseObject eo = EOUtilities.createAndInsertInstance(editingContext(),  ch.filme.Rental.ENTITY_NAME );
    addObjectToBothSidesOfRelationshipWithKey(eo, _Unit.RENTALS_KEY);
    return (ch.filme.Rental) eo;
  }

  public void deleteRentalsRelationship(ch.filme.Rental object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Unit.RENTALS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllRentalsRelationships() {
    Enumeration<ch.filme.Rental> objects = rentals().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteRentalsRelationship(objects.nextElement());
    }
  }


  public static Unit createUnit(EOEditingContext editingContext, NSTimestamp dateAcquired
, String notes
) {
    Unit eo = (Unit) EOUtilities.createAndInsertInstance(editingContext, _Unit.ENTITY_NAME);
    eo.setDateAcquired(dateAcquired);
    eo.setNotes(notes);
    return eo;
  }

  public static ERXFetchSpecification<Unit> fetchSpec() {
    return new ERXFetchSpecification<Unit>(_Unit.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Unit> fetchAllUnits(EOEditingContext editingContext) {
    return _Unit.fetchAllUnits(editingContext, null);
  }

  public static NSArray<Unit> fetchAllUnits(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Unit.fetchUnits(editingContext, null, sortOrderings);
  }

  public static NSArray<Unit> fetchUnits(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Unit> fetchSpec = new ERXFetchSpecification<Unit>(_Unit.ENTITY_NAME, qualifier, sortOrderings);
    NSArray<Unit> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Unit fetchUnit(EOEditingContext editingContext, String keyName, Object value) {
    return _Unit.fetchUnit(editingContext, ERXQ.equals(keyName, value));
  }

  public static Unit fetchUnit(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Unit> eoObjects = _Unit.fetchUnits(editingContext, qualifier, null);
    Unit eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Unit that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Unit fetchRequiredUnit(EOEditingContext editingContext, String keyName, Object value) {
    return _Unit.fetchRequiredUnit(editingContext, ERXQ.equals(keyName, value));
  }

  public static Unit fetchRequiredUnit(EOEditingContext editingContext, EOQualifier qualifier) {
    Unit eoObject = _Unit.fetchUnit(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Unit that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Unit localInstanceIn(EOEditingContext editingContext, Unit eo) {
    Unit localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
