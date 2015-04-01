package org.siani.itrules.engine;

import org.siani.itrules.model.AbstractFrame;
import org.siani.itrules.model.Frame;

import java.util.Iterator;

public class FrameFinder {

    private final Frame frame;

    public FrameFinder(Frame frame) {
        this.frame = frame;
    }

    public static FrameFinder with(AbstractFrame frame) {
        return new FrameFinder((Frame) frame);
    }


    public static Filter byName(final String name) {
        return new Filter() {
            @Override
            public boolean accept(String slot, Frame frame) {
                return slot.equalsIgnoreCase(name);
            }
        };
    }


    public static Filter byType(final String type) {
        return new Filter() {
            @Override
            public boolean accept(String slot, Frame frame) {
                return frame.is(type);
            }
        };
    }

    public Frame find(Filter filter) {
        for (String slot : frame.slots()) {
            Frame result = find(filter, slot);
            if (result != null) return result;
        }
        return null;
    }

    private Frame find(Filter filter, String slot) {
        Iterator<AbstractFrame> frames = frame.frames(slot);
        while (frames.hasNext()) {
            AbstractFrame frame = frames.next();
            if (frame.isPrimitive()) continue;
            if (filter.accept(slot, (Frame) frame)) return (Frame) frame;
        }
        return null;
    }

    public interface Filter {
        public boolean accept(String slot, Frame frame);
    }



}
