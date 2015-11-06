package org.siani.itrules.engine;

import org.siani.itrules.RuleSetReader;
import org.siani.itrules.Source;
import org.siani.itrules.engine.logger.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class RuleSetLoader {

    public static RuleSet load(Source source) {
        try {
            return ruleSetReader(source).read(source.charset());
        } catch (Exception e) {
            new Logger().log("Source %s could not be loaded\n", source.getName(), e.getMessage());
            return new RuleSet();
        }
    }

    private static RuleSetReader ruleSetReader(Source source) throws ClassNotFoundException, NoSuchMethodException, FileNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<RuleSetReader> constructor = ruleSetReaderClass(source).getConstructor(InputStream.class);
        return constructor.newInstance(new FileInputStream(source));
    }

    @SuppressWarnings("unchecked")
    private static Class<RuleSetReader> ruleSetReaderClass(Source source) throws ClassNotFoundException {
        return (Class<RuleSetReader>) Class.forName(of(source));
    }

    private static String of(Source source) {
        return "org.siani.itrules.readers." + capitalize(extension(source.getName())) + "RuleSetReader";
    }

    private static String extension(String name) {
        return name.substring(name.lastIndexOf(".") + 1);
    }

    private static String capitalize(String text) {
        return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
    }

}
