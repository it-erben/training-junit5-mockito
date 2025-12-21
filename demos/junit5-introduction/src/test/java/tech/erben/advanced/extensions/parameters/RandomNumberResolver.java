package tech.erben.advanced.extensions.parameters;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;

public class RandomNumberResolver implements ParameterResolver {

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return parameterContext.getParameter().getType() == int.class && parameterContext.getAnnotatedElement().isAnnotationPresent(RandomNumber.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return (int) (Math.random() * 100); // Zufallszahl zwischen 0 und 99
    }
}
