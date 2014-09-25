package org.siani.itrules;

public interface AbstractFrame {

	public boolean is(String type);

	public Attribute[] attributes(String attribute);

	public boolean has(String attribute);

	public interface Attribute {

		public boolean isFrame();

		public AbstractFrame asFrame();

		public Object value();

	}

}
