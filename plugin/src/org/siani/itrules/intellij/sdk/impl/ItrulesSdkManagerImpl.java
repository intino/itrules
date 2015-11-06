package org.siani.itrules.intellij.sdk.impl;

import com.intellij.openapi.util.text.StringUtil;
import gnu.trove.THashMap;
import org.jetbrains.annotations.NotNull;
import org.siani.itrules.intellij.sdk.ItrulesSdk;
import org.siani.itrules.intellij.sdk.ItrulesSdkManager;

import java.util.Map;

public class ItrulesSdkManagerImpl extends ItrulesSdkManager {
    private final Map<String, ItrulesSdkImpl> myPath2Sdk = new THashMap<>();

    @NotNull
    @Override
    public ItrulesSdk findSdk(@NotNull String sdkPath) {
        sdkPath = StringUtil.trimEnd(sdkPath, "/");
        if (!myPath2Sdk.containsKey(sdkPath)) {
            myPath2Sdk.put(sdkPath, new ItrulesSdkImpl(sdkPath));
        }
        return myPath2Sdk.get(sdkPath);
    }
}
