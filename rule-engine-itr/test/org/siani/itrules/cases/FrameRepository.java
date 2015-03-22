package org.siani.itrules.cases;

import org.siani.itrules.model.DateTime;
import org.siani.itrules.model.Frame;

import java.util.HashMap;
import java.util.Map;

public class FrameRepository {
    public static Map<String, Frame> frames = createFrames();

    private static Map<String, Frame> createFrames() {
        Map<String, Frame> frames = new HashMap<>();
        frames.put("InMiddleEarth", inMiddleEarthFrame());
        frames.put("JavaClass", javaClassFrame());
        frames.put("OptionalAttributes", rosterFrame());
        frames.put("NestedFrames", rosterFrame());
        frames.put("NestedInterfaces", nestedInterfaces());
        frames.put("Eval", eval());
        return frames;
    }

    private static Frame inMiddleEarthFrame() {
        Frame frame = new Frame("Message");
        frame.addFrame("From", "frodo@hobbiton.me");
        frame.addFrame("To", "gandalf@elrond.me");
        frame.addFrame("To", "bilbo@hobbiton.me");
        frame.addFrame("Subject", "The ring");
        frame.addFrame("Text", "I wish the Ring had never come to me.");
        frame.addFrame("Text", "I wish none of this had happened.");
        return frame;
    }


    private static Frame javaClassFrame() {
        Frame frame = new Frame("Class");
        frame.addFrame("name", "Customer");
        frame.addFrame("final", "final");
        frame.addFrame("superclass", "Client");
        frame.addFrame("interface", "Company");
        frame.addFrame("interface", "TaxPayer");
        frame.addFrame("attribute", new Frame("Attribute", "Const") {{
            addFrame("name", "CUSTOMER_NAME");
            addFrame("type", "String");
            addFrame("default", "\"CUSTOMER\"");
        }});
        frame.addFrame("attribute", new Frame("Attribute", "ReadOnly") {{
            addFrame("name", "familyName");
            addFrame("type", "String");
        }});
        frame.addFrame("attribute", new Frame("Attribute") {{
            addFrame("name", "maxAge");
            addFrame("type", "Integer");
            addFrame("default", "100");
        }});
        return frame;
    }

    private static Frame rosterFrame() {
        Frame frame = new Frame("Roster");
        frame.addFrame("Coach", new Frame("Person") {{
            addFrame("Name", "Juan Antonio Orenga");
            addFrame("Birthday", new DateTime("29/07/1966"));
            addFrame("Country", "Spain");
        }});
        frame.addFrame("Player", new Frame("Person") {{
            addFrame("Name", "Pau Gasol");
            addFrame("Birthday", new DateTime("06/07/1980"));
            addFrame("Country", "Spain");
            addFrame("Club", "L.A. Lakers");
        }});
        frame.addFrame("Player", new Frame("Person") {{
            addFrame("Name", "Rudy Fernandez");
            addFrame("Birthday", new DateTime("04/04/1985"));
            addFrame("Country", "Spain");
        }});
        frame.addFrame("Player", new Frame("Person") {{
            addFrame("Name", "Juan Carlos Navarro");
            addFrame("Birthday", new DateTime("17/06/1980"));
            addFrame("Country", "Spain");
        }});
        return frame;
    }

    private static Frame nestedInterfaces() {
        final Frame frame = new Frame("class");
        frame.addFrame("package", "org.sample");
        frame.addFrame("concept", new Frame("concept") {{
            addFrame("name", "Form");
            addFrame("concept", new Frame("concept", "action") {{
                addFrame("name", "Handler");
                addFrame("parent", "org.sample.Handler");
            }});
            addFrame("concept", new Frame("concept") {{
                addFrame("name", "Field");
                addFrame("concept", new Frame("concept", "action") {{
                    addFrame("name", "Handler");
                    addFrame("parent", "org.sample.Form.Handler");
                }});
            }});
            addFrame("concept", new Frame("concept") {{
                addFrame("name", "TextField");
                addFrame("parent", "Field");
                addFrame("concept", new Frame("concept", "action") {{
                    addFrame("name", "Handler");
                    addFrame("parent", "org.sample.Form.Handler");
                }});
            }});
        }});
        frame.addFrame("concept", new Frame("concept", "action", "private") {{
            addFrame("name", "Handler");
        }});
        frame.addFrame("concept", new Frame("concept") {{
            addFrame("name", "Collection");
            addFrame("concept", new Frame("concept") {{
                addFrame("name", "Item");
            }});
        }});
        return frame;
    }

    private static Frame eval() {
        Frame frame = new Frame("Contract");
        frame.addFrame("Owner", new Frame("Person") {{
            addFrame("Name", "Tere Galvez");
            addFrame("Address", "Triana 20");
            addFrame("City", "Las Palmas");
            addFrame("IdCard", "4050321");
        }});
        frame.addFrame("Pet", new Frame("Dog") {{
            addFrame("Chip", "X204512");
            addFrame("Especie", "Caniche");
            addFrame("Age", "2");
        }});
        frame.addFrame("Date", new DateTime("27/09/2014"));
        return frame;
    }



}
