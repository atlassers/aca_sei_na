package it.euris.academy.cinema.exception;

public class IdMustBeNullException extends RuntimeException {
  private static final long serialVersionUID = 11547588023389561L;

  public IdMustBeNullException() {
    super("Id must be null. You sent a dto with an id already present");
  }
  public IdMustBeNullException(String message) {
    super(message);
  }
}
