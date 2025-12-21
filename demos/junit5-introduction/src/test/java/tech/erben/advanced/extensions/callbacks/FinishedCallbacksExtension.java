package tech.erben.advanced.extensions.callbacks;

import org.junit.jupiter.api.extension.*;

public class FinishedCallbacksExtension implements BeforeAllCallback, AfterAllCallback, BeforeEachCallback, AfterEachCallback {

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        System.out.println("Starting all tests in class: " + context.getRequiredTestClass().getName());
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        System.out.println("Finished all tests in class: " + context.getRequiredTestClass().getName());
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        System.out.println("Starting test: " + context.getDisplayName());
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        System.out.println("Finished test: " + context.getDisplayName());
    }
}
