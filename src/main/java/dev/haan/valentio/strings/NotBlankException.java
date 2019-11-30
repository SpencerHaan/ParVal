package dev.haan.valentio.strings;

public class NotBlankException extends StringValidationException {

    public NotBlankException(String propertyName) {
        super("{0} must not be blank", propertyName);
    }
}
