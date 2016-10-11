package org.stepio.strings.model;

/**
 * DTO for handling errors, allows sending messages to client.
 *
 * @author stepio
 */
public class ErrorResponse {

    protected String message;

    public ErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
