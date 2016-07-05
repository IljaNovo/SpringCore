package com.epam.spring.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.spring.data.DataType;

public class SimpleCounter {

	private static Map<DataType, Integer> countsOfData;
	private static SimpleCounter elem;

	private SimpleCounter() {
	}

	public void addListDataType(List<DataType> dataTypes) {
		countsOfData = new HashMap<DataType, Integer>();
		for (int i = 0; i < dataTypes.size(); ++i) {
			countsOfData.put(dataTypes.get(i), 0);
		}
	}

	public static SimpleCounter instanse() {
		if (elem == null) {
			elem = new SimpleCounter();
		}
		return elem;
	}

	public int getCount(DataType data) {
		return countsOfData.get(data);
	}

	public void increase(DataType data) {
		countsOfData.put(data, countsOfData.get(data) + 1);
	}

	public void reduce(DataType data) {
		countsOfData.put(data, countsOfData.get(data) - 1);
	}

	public void reset(DataType data) {
		countsOfData.put(data, 0);
	}

	public void addDataType(DataType data) {
		if (countsOfData.get(data) != null) {
			countsOfData.put(data, 0);
		}
	}
}
