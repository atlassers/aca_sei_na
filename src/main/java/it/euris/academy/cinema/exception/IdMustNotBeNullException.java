package it.euris.academy.cinema.exception;

public class IdMustNotBeNullException extends RuntimeException {
  private static final long serialVersionUID = 11547588023389561L;

  public IdMustNotBeNullException() {
    super("Id must not be null.");
  }

  public IdMustNotBeNullException(String message) {
    super(message);
  }
}
