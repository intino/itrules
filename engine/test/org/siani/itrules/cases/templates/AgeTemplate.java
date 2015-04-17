package org.siani.itrules.cases.templates;

import org.siani.itrules.Encoding;
import org.siani.itrules.Template;

import java.util.Locale;

public class AgeTemplate extends Template {


    public AgeTemplate(Locale locale, Encoding encoding) {
        super(locale, encoding);
    }

    public static String format(Object object) {
        return new AgeTemplate(Locale.getDefault(), Encoding.getDefault()).render(object);
    }

    @Override
    protected void definition() {

    }
}
