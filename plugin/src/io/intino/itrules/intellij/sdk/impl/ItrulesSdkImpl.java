package io.intino.itrules.intellij.sdk.impl;

import com.intellij.openapi.application.PathManager;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.util.io.JarUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import io.intino.itrules.intellij.sdk.ItrulesSdk;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

import static java.io.File.separator;

public class ItrulesSdkImpl implements ItrulesSdk {
    private static final Logger LOG = Logger.getInstance("#com.intellij.itrules.sdk.impl.ItrulesSdkImpl");
    private final String myHomePath;

    public ItrulesSdkImpl(String homePath) {
        myHomePath = homePath;
    }

    private static File[] getJarsFromDirectory(File libFolder) {
        List<File> jars = new ArrayList<>();
        final File[] files = libFolder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".jar")) {
                    jars.add(file);
                }
            }
        }
        return jars.toArray(new File[jars.size()]);
    }

    @NotNull
    @Override
    public File getApplicationSchemeFile() {
        return new File(myHomePath, "docs/itrules.xsd");
    }

    @NotNull
    public File[] getLibraries() {
        return getJarsFromDirectory(new File(myHomePath, "lib"));
    }

    @NotNull
    public String getSdkHomePath() {
        return myHomePath;
    }

    @NotNull
    @Override
    public File getItrulesCfgFile() {
        return new File(myHomePath, "itrulescfg.properties");
    }

    @Override
    @Nullable
    public String getVersion() {
        return JarUtil.getJarAttribute(getItrulesCfgFile(), "org/siani/itrules/info/", Attributes.Name.SPECIFICATION_VERSION);
    }

    public boolean isValid() {
        return getItrulesCfgFile().exists();
    }

    @NotNull
    @Override
    public List<String> getUserLibraryPaths() {
        File libDirectory = new File(PathManager.getPluginsPath() + separator + "plugin" + separator + "lib" + separator);
        if (!libDirectory.exists())
            libDirectory = new File(PathManager.getPluginsPath() + separator + "itrules" + separator + "lib" + separator);
        List<String> libs = new ArrayList<>();
        libs.add(libDirectory.getPath() + separator + "engine.jar");
        return libs;
    }

}
