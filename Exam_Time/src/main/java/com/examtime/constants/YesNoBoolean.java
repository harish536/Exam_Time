package com.examtime.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Harish
 *
 */
public enum YesNoBoolean {

	TRUE(1, "Yes", true), FALSE(0, "No", false);

	private final int intValue;
	private final String stringValue;
	private final boolean booleanValue;

	private static final Map<Boolean, YesNoBoolean> valueMap = new HashMap<Boolean, YesNoBoolean>();
	private static final Map<Integer, YesNoBoolean> intMap = new HashMap<Integer, YesNoBoolean>();
	private static final Map<String, YesNoBoolean> stringMap = new HashMap<String, YesNoBoolean>();

	static {
		for (YesNoBoolean constant : YesNoBoolean.class.getEnumConstants()) {
			valueMap.put(Boolean.valueOf(constant.toBoolean()), constant);
			intMap.put(constant.tointValue(), constant);
			stringMap.put(constant.toString(), constant);
		}
	}

	private YesNoBoolean(final int intValue, final String stringValue, final boolean booleanValue) {
		this.intValue = intValue;
		this.stringValue = stringValue;
		this.booleanValue = booleanValue;
	}

	public int tointValue() {
		return this.intValue;
	}

	@Override
	public String toString() {
		return this.stringValue;
	}

	public boolean toBoolean() {
		return this.booleanValue;
	}

	public static YesNoBoolean fromBoolean(final boolean booleanValue) {
		return valueMap.get(booleanValue);
	}

	public static YesNoBoolean fromStringChar(final int value) {
		return intMap.get(value);
	}

	public static YesNoBoolean fromString(final String stringValue) {
		return stringMap.get(stringValue);
	}
}
