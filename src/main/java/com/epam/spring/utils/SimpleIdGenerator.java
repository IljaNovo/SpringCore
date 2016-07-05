package com.epam.spring.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.spring.data.DataType;

public class SimpleIdGenerator {

	private static Map<DataType, Integer> idOfData = new HashMap<DataType, Integer>();
	private static SimpleIdGenerator elem;

	private SimpleIdGenerator() {
	}

	public static SimpleIdGenerator instanse() {
		if (elem == null) {
			elem = new SimpleIdGenerator();
		}
		return elem;
	}

	public void addListDataTypes(List<DataType> dataTypes) {
		idOfData = new HashMap<DataType, Integer>();
		for (int i = 0; i < dataTypes.size(); ++i) {
			idOfData.put(dataTypes.get(i), 0);
		}
	}

	public int generate(DataType data) {
		idOfData.put(data, idOfData.get(data) + 1);
		return idOfData.get(data);
	}

	public void addDataType(DataType data) {
		if (idOfData.get(data) != null) {
			idOfData.put(data, 0);
		}
	}
}
