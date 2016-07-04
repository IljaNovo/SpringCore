package com.epam.spring.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleCounter{
	
	private static Map<DataType, Integer> countsOfData;
	private static SimpleCounter elem;
	
	private SimpleCounter() {
	}
	
	public static void addListDataType(List<DataType> dataTypes) {
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
	
	public static int getCount(DataType data) {
		return countsOfData.get(data);
	}
	
	public static void increase(DataType data) {
		countsOfData.put(data, countsOfData.get(data) + 1);
	}
	
	public static void reduce(DataType data) {
		countsOfData.put(data, countsOfData.get(data) - 1);
	}
	
	public static void reset(DataType data) {
		countsOfData.put(data, 0);
	}
	
	public static void addDataType(DataType data) {
		if (countsOfData.get(data) != null) {
			countsOfData.put(data, 0);
		}
	}
}
