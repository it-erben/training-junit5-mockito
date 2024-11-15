package com.iterben.advanced.extensions.context;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class TimingExtension implements BeforeEachCallback, AfterEachCallback {

    private static final String START_TIME_KEY = "startTime";

    @Override
    public void beforeEach(ExtensionContext context) {
        // Speichert die Startzeit vor jedem Test im Store
        context.getStore(ExtensionContext.Namespace.GLOBAL)
            .put(START_TIME_KEY, System.currentTimeMillis());
    }

    @Override
    public void afterEach(ExtensionContext context) {
        // Berechnet und gibt die Testdauer aus
        Long startTime = context.getStore(ExtensionContext.Namespace.GLOBAL)
            .remove(START_TIME_KEY, Long.class);
        long duration = System.currentTimeMillis() - startTime;
        System.out.println(context.getDisplayName() + " took " + duration + " ms.");
    }
}
