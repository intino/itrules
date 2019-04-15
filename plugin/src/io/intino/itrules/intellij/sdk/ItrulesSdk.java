package io.intino.itrules.intellij.sdk;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.List;

public interface ItrulesSdk {

    @NotNull
    String getSdkHomePath();

    @NotNull
    File getItrulesCfgFile();

    @NotNull
    File[] getLibraries();

    @Nullable
    String getVersion();

    boolean isValid();

    @NotNull
    List<String> getUserLibraryPaths();

    @NotNull
    File getApplicationSchemeFile();

}
