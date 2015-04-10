package org.siani.itrules.intellij.sdk;

import com.intellij.openapi.components.ServiceManager;
import org.jetbrains.annotations.NotNull;

public abstract class ItrulesSdkManager {
	public static ItrulesSdkManager getInstance() {
		return ServiceManager.getService(ItrulesSdkManager.class);
	}

	@NotNull
	public abstract ItrulesSdk findSdk(@NotNull String sdkPath);

}
