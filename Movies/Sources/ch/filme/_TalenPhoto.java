// DO NOT EDIT.  Make changes to TalenPhoto.java instead.
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
public abstract class _TalenPhoto extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "TalentPhoto";

  // Attribute Keys
  public static final ERXKey<NSData> PHOTO = new ERXKey<NSData>("photo");

  // Relationship Keys

  // Attributes
  public static final String PHOTO_KEY = PHOTO.key();

  // Relationships

  private static final Logger log = LoggerFactory.getLogger(_TalenPhoto.class);

  public TalenPhoto localInstanceIn(EOEditingContext editingContext) {
    TalenPhoto localInstance = (TalenPhoto)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public NSData photo() {
    return (NSData) storedValueForKey(_TalenPhoto.PHOTO_KEY);
  }

  public void setPhoto(NSData value) {
    log.debug( "updating photo from {} to {}", photo(), value);
    takeStoredValueForKey(value, _TalenPhoto.PHOTO_KEY);
  }


  public static TalenPhoto createTalentPhoto(EOEditingContext editingContext) {
    TalenPhoto eo = (TalenPhoto) EOUtilities.createAndInsertInstance(editingContext, _TalenPhoto.ENTITY_NAME);
    return eo;
  }

  public static ERXFetchSpecification<TalenPhoto> fetchSpec() {
    return new ERXFetchSpecification<TalenPhoto>(_TalenPhoto.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<TalenPhoto> fetchAllTalentPhotos(EOEditingContext editingContext) {
    return _TalenPhoto.fetchAllTalentPhotos(editingContext, null);
  }

  public static NSArray<TalenPhoto> fetchAllTalentPhotos(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _TalenPhoto.fetchTalentPhotos(editingContext, null, sortOrderings);
  }

  public static NSArray<TalenPhoto> fetchTalentPhotos(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<TalenPhoto> fetchSpec = new ERXFetchSpecification<TalenPhoto>(_TalenPhoto.ENTITY_NAME, qualifier, sortOrderings);
    NSArray<TalenPhoto> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static TalenPhoto fetchTalentPhoto(EOEditingContext editingContext, String keyName, Object value) {
    return _TalenPhoto.fetchTalentPhoto(editingContext, ERXQ.equals(keyName, value));
  }

  public static TalenPhoto fetchTalentPhoto(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<TalenPhoto> eoObjects = _TalenPhoto.fetchTalentPhotos(editingContext, qualifier, null);
    TalenPhoto eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one TalentPhoto that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static TalenPhoto fetchRequiredTalentPhoto(EOEditingContext editingContext, String keyName, Object value) {
    return _TalenPhoto.fetchRequiredTalentPhoto(editingContext, ERXQ.equals(keyName, value));
  }

  public static TalenPhoto fetchRequiredTalentPhoto(EOEditingContext editingContext, EOQualifier qualifier) {
    TalenPhoto eoObject = _TalenPhoto.fetchTalentPhoto(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no TalentPhoto that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static TalenPhoto localInstanceIn(EOEditingContext editingContext, TalenPhoto eo) {
    TalenPhoto localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
