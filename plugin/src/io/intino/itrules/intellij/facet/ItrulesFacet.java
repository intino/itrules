package io.intino.itrules.intellij.facet;

import com.intellij.facet.*;
import com.intellij.openapi.module.Module;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ItrulesFacet extends Facet<ItrulesFacetConfiguration> {
    public static final FacetTypeId<ItrulesFacet> ID = new FacetTypeId<>("itrules");

    public ItrulesFacet(@NotNull FacetType facetType,
                        @NotNull Module module,
                        @NotNull String name,
                        @NotNull ItrulesFacetConfiguration configuration) {
        super(facetType, module, name, configuration, null);
    }

    public static FacetType<ItrulesFacet, ItrulesFacetConfiguration> getFacetType() {
        return FacetTypeRegistry.getInstance().findFacetType(ID);
    }

    @Nullable
    public static ItrulesFacet of(@Nullable Module module) {
        if (module == null) return null;
        return FacetManager.getInstance(module).getFacetByType(ID);
    }

}
