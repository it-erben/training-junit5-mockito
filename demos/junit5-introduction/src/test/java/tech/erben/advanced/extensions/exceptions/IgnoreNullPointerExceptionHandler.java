package tech.erben.advanced.extensions.exceptions;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

public class IgnoreNullPointerExceptionHandler implements TestExecutionExceptionHandler {

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        if (throwable instanceof NullPointerException) {
            System.out.println("NullPointerException ignored in test: " + context.getDisplayName());
        } else {
            throw throwable; // andere Exceptions erneut werfen
        }
    }
}
