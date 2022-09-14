# @Transactional on default method

This project reproduces a bug with Quarkus.

## Bug description

The `@Transactional` annotation is not observed by Quarkus if placed on a default method. If such a method is used to persist an entity then the call will fail with a `TransactionRequiredException`.
The `@Transactional` annotation is not observed by Quarkus if placed on a default method. If such a method is used to persist an entity then the call will fail with a `TransactionRequiredException`.

**Example**
```java
public interface MyInterface {
  void nonTransactionalMethod(String field);

  @POST
  @Path("/createDefault")
  @Transactional
  default void transactionalDefaultMethod(@QueryParam("field") String field) {
    nonTransactionalMethod("Default: " + field);
  }
}
```

## Expected behavior

A default method annotated with `@Transactional` must start a transaction if no current transaction is active.

## Actual behavior

The `@Transactional` annotation on default methods is ignored and persisting an entity in such a method fails with a `TransactionRequiredException`.

## Reproducer

This projects includes two unit tests in the class `MyResourceTest`.
- `testTransactionEndpoint` uses an endpoint implemented by a class method. This tests
- `testDefaultTransactionEndpoint` uses an endpoint implemented by a default method.
