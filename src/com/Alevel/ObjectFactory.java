package com.Alevel;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class ObjectFactory {

    private static ObjectFactory instance;
    private Reflections reflections;

    private ObjectFactory() {
        this.reflections = new Reflections("ua.com.Alevel");
    }

    public static ObjectFactory getInstance() {
        if (instance == null) {
            instance = new ObjectFactory();
        }
        return instance;
    }

    public <T> T getImplClass(Class<T> aClass) {
        System.out.println("aClass = " + aClass);
        Set<Class<? extends T>> set = reflections.getSubTypesOf(aClass);
        System.out.println("set = " + set.size());
        for (Class<? extends T> aClass1 : set) {
            if (!aClass1.isAnnotationPresent(Deprecated.class)) {
                try {
                    return aClass1.getDeclaredConstructor().newInstance();
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
