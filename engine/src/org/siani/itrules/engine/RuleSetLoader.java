package org.siani.itrules.engine;

import org.siani.itrules.RuleSetReader;
import org.siani.itrules.engine.logger.DebugLogger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class RuleSetLoader {

    public static RuleSet load(File file) {
        try {
            return ruleSetReader(file).read();
        } catch (Exception e) {
            new DebugLogger().debug("RuleSet %s could not be load\n\t%s", file.getName(), e.getMessage());
            return new RuleSet();
        }
    }

    private static RuleSetReader ruleSetReader(File file) throws ClassNotFoundException, NoSuchMethodException, FileNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<RuleSetReader> constructor = ruleSetReaderClass(file).getConstructor(InputStream.class);
        return constructor.newInstance(new FileInputStream(file));
    }

    @SuppressWarnings("unchecked")
    private static Class<RuleSetReader> ruleSetReaderClass(File file) throws ClassNotFoundException {
        return (Class<RuleSetReader>) Class.forName(of(file));
    }

    private static String of(File file) {
        return "org.siani.itrules.reader." + extension(file.getName()) + ".RuleSetReader";
    }

    private static String extension(String name) {
        return name.substring(name.lastIndexOf(".") + 1).toLowerCase();
    }

}
