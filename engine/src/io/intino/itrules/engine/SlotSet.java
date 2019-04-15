package io.intino.itrules.engine;

import io.intino.itrules.model.AbstractFrame;

import java.util.*;

public class SlotSet {
    private Map<String, List<AbstractFrame>> map = new LinkedHashMap<>();

    public static SlotSet create() {
        return new SlotSet();
    }

    private SlotSet() {

    }

    public List<AbstractFrame> get(String name) {
        if (!containsKey(name)) map.put(name.toLowerCase(), new ArrayList<>());
        return map.get(name.toLowerCase());
    }

    public boolean containsKey(String name) {
        return map.containsKey(name.toLowerCase());
    }

    public SlotSet add(String name, AbstractFrame frame) {
        get(name).add(frame);
        return this;
    }

    public SlotSet add(String name, List<AbstractFrame> frames) {
        get(name).addAll(frames);
        return this;
    }

    public Map<String, List<AbstractFrame>> map() {
        return map;
    }


    public int size() {
        return map.size();
    }

    public String[] names() {
        return map.keySet().toArray(new String[map.size()]);
    }

    public void add(SlotSet slots) {
        this.map.putAll(slots.map);
    }
}
