package com.dushyant.services;

/**
 * Yes!! i am aware that it doesn't throw any exception incase method is not found, that's the idea
 * 
 * @param <E>
 */
public final class Method<E> {

  public static final Object[] EMPTY_OBJECTS = new Object[] {};
  public static final Class<?>[] EMPTY_CLASSES = new Class<?>[] {};
  public static final Class<?> DEFAULT_RETURN_TYPE = Object.class;


  /**
   * 
   */
  private Method() {}

  /**
   * @param object
   * @param method
   * @return
   */
  public static Object execute(Object object, String method) {
    return executeIfMethodExists(object, method, EMPTY_OBJECTS, EMPTY_CLASSES, DEFAULT_RETURN_TYPE);
  }

  /**
   * @param object
   * @param method
   * @param returnClass
   * @return
   */
  public static <E> E execute(Object object, String method, Class<? extends E> returnClass) {
    return executeIfMethodExists(object, method, EMPTY_OBJECTS, EMPTY_CLASSES, returnClass);
  }

  /**
   * @param object
   * @param method
   * @param parameterObjects
   * @param parameterTypes
   * @return
   */
  public static Object execute(Object object, String method, Object[] parameterObjects,
      Class<?>[] parameterTypes) {
    return executeIfMethodExists(object, method, parameterObjects, parameterTypes,
        DEFAULT_RETURN_TYPE);
  }

  /**
   * @param object
   * @param method
   * @param parameterObjects
   * @param parameterTypes
   * @param returnClass
   * @return
   */
  public static <E> E execute(Object object, String method, Object[] parameterObjects,
      Class<?>[] parameterTypes, Class<? extends E> returnClass) {
    return executeIfMethodExists(object, method, parameterObjects, parameterTypes, returnClass);
  }

  /**
   * @param object
   * @param method
   * @param parameterObject
   * @param parameterType
   * @return
   */
  public static Object execute(Object object, String method, Object parameterObject,
      Class<?> parameterType) {
    return executeIfMethodExists(object, method, new Object[] {parameterObject},
        new Class<?>[] {parameterType}, DEFAULT_RETURN_TYPE);
  }

  /**
   * @param object
   * @param method
   * @param parameterObject
   * @param parameterType
   * @param returnClass
   * @return
   */
  public static <E> E execute(Object object, String method, Object parameterObject,
      Class<?> parameterType, Class<? extends E> returnClass) {
    return executeIfMethodExists(object, method, new Object[] {parameterObject},
        new Class<?>[] {parameterType}, returnClass);
  }

  /**
   * @param object
   * @param method
   * @param parameterObjects
   * @param parameterType
   * @return
   */
  public static Object execute(Object object, String method, Object[] parameterObjects,
      Class<?> parameterType) {
    return executeIfMethodExists(object, method, parameterObjects, new Class<?>[] {parameterType},
        DEFAULT_RETURN_TYPE);
  }

  /**
   * @param object
   * @param method
   * @param parameterObjects
   * @param parameterType
   * @param returnClass
   * @return
   */
  public static <E> E execute(Object object, String method, Object[] parameterObjects,
      Class<?> parameterType, Class<? extends E> returnClass) {
    return executeIfMethodExists(object, method, parameterObjects, new Class<?>[] {parameterType},
        returnClass);
  }

  /**
   * @param object
   * @param method
   * @param parameterObject
   * @param parameterTypes
   * @return
   */
  public static Object execute(Object object, String method, Object parameterObject,
      Class<?>[] parameterTypes) {
    return executeIfMethodExists(object, method, new Object[] {parameterObject}, parameterTypes,
        DEFAULT_RETURN_TYPE);
  }

  /**
   * @param object
   * @param method
   * @param parameterObject
   * @param parameterTypes
   * @param returnClass
   * @return
   */
  public static <E> E execute(Object object, String method, Object parameterObject,
      Class<?>[] parameterTypes, Class<? extends E> returnClass) {
    return executeIfMethodExists(object, method, new Object[] {parameterObject}, parameterTypes,
        returnClass);
  }

  /**
   * @param object
   * @param method
   * @param parameterObjects
   * @param parameterTypes
   * @param returnClass
   * @return
   */
  public static <E> E executeIfMethodExists(Object object, String method,
      Object[] parameterObjects, Class<?>[] parameterTypes, Class<? extends E> returnClass) {
    Object objectToReturn = null;
    if (isAnyNull(object, method)) {
      return null;
    }
    try {
      Class<? extends Object> class1 = object.getClass();
      java.lang.reflect.Method method2 = class1.getMethod(method, parameterTypes);
      method2.setAccessible(true);
      objectToReturn = method2.invoke(object, parameterObjects);
    } catch (Exception e) {
      e.printStackTrace();
    }
    if (returnClass.isInstance(objectToReturn)) {
      return returnClass.cast(objectToReturn);
    }
    return null;
  }



  /**
   * @param objects
   * @return
   */
  private static boolean isAnyNull(Object... objects) {
    if (objects == null) {
      return true;
    }
    for (Object object : objects) {
      if (object == null) {
        return true;
      }
    }
    return false;
  }
}

