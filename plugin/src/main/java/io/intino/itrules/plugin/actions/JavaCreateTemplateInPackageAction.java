/*
 * Copyright 2024
 * Octavio Roncal Andrés
 * José Juan Hernández Cabrera
 * José Évora Gomez
 *
 * This File is Part of ItRules Project
 *
 * ItRules Project is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ItRules Project is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with itrules Library.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.intino.itrules.plugin.actions;

import com.intellij.ide.actions.CreateTemplateInPackageAction;
import com.intellij.java.JavaBundle;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationAction;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtilCore;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.projectRoots.JavaSdk;
import com.intellij.openapi.projectRoots.JavaSdkType;
import com.intellij.openapi.projectRoots.ex.JavaSdkUtil;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.roots.ModuleRootModificationUtil;
import com.intellij.openapi.roots.ui.configuration.SdkLookupUtil;
import com.intellij.openapi.roots.ui.configuration.SdkPopupFactory;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.jps.model.java.JavaModuleSourceRootTypes;
import org.jetbrains.jps.model.module.JpsModuleSourceRootType;

import javax.swing.*;
import java.util.Set;
import java.util.function.Supplier;

public abstract class JavaCreateTemplateInPackageAction<T extends PsiElement> extends CreateTemplateInPackageAction<T> {

	protected JavaCreateTemplateInPackageAction(String text, String description, Icon icon, boolean inSourceOnly) {
		super(text, description, icon, inSourceOnly ? JavaModuleSourceRootTypes.SOURCES : null);
	}

	protected JavaCreateTemplateInPackageAction(@NotNull Supplier<String> dynamicText,
												@NotNull Supplier<String> dynamicDescription,
												Icon icon,
												boolean inSourceOnly) {
		super(dynamicText, dynamicDescription, icon, inSourceOnly ? JavaModuleSourceRootTypes.SOURCES : null);
	}

	protected JavaCreateTemplateInPackageAction(String text,
												String description,
												Icon icon,
												Set<? extends JpsModuleSourceRootType<?>> rootTypes) {
		super(text, description, icon, rootTypes);
	}

	@Override
	protected boolean checkPackageExists(PsiDirectory directory) {
		return doCheckPackageExists(directory);
	}

	public static boolean doCheckPackageExists(PsiDirectory directory) {
		PsiPackage pkg = JavaDirectoryService.getInstance().getPackage(directory);
		if (pkg == null) {
			return false;
		}

		String name = pkg.getQualifiedName();
		return StringUtil.isEmpty(name) || PsiNameHelper.getInstance(directory.getProject()).isQualifiedName(name);
	}

	@Override
	protected @Nullable T createFile(String name, String templateName, PsiDirectory dir) {
		T file = super.createFile(name, templateName, dir);
		setupJdk(dir, file);
		return file;
	}

	public static void setupJdk(PsiDirectory dir, PsiElement file) {
		Module module = ModuleUtilCore.findModuleForPsiElement(dir);
		if (file != null && module != null && ModuleRootManager.getInstance(module).getSdk() == null) {
			Project project = dir.getProject();
			ModuleRootModificationUtil.setSdkInherited(module);
			ProgressManager.getInstance().run(new Task.Backgroundable(project, JavaBundle.message("progress.title.looking.for.jdk"), true) {
				@Override
				public void run(@NotNull ProgressIndicator indicator) {
					SdkLookupUtil.findAndSetupSdk(project, indicator, JavaSdk.getInstance(), sdk -> {
						JavaSdkUtil.applyJdkToProject(project, sdk);
						Notifications.Bus.notify(new Notification("Setup SDK", JavaBundle.message("notification.content.was.set.up", sdk.getVersionString()), NotificationType.INFORMATION).addAction(
								new NotificationAction(JavaBundle.message("notification.content.change.jdk")) {
									@Override
									public void actionPerformed(@NotNull AnActionEvent e,
																@NotNull Notification notification) {
										SdkPopupFactory
												.newBuilder()
												.withProject(project)
												.withSdkTypeFilter(type -> type instanceof JavaSdkType)
												.updateProjectSdkFromSelection()
												.onPopupClosed(() -> notification.hideBalloon())
												.buildPopup()
												.showPopup(e);
									}
								}));
						return null;
					});
				}
			});
		}
	}
}