package com.example.start.task2.extension;

import com.example.start.task2.dao.UserDao;
import com.example.start.task2.service.UserService;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import static org.junit.jupiter.api.extension.ExtensionContext.*;

public class UserServiceParamResolver implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == UserService.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        var store =extensionContext.getStore(Namespace.create(extensionContext.getTestMethod()));
        return store.getOrComputeIfAbsent(UserService.class, it-> new UserService( null));
    }
}
