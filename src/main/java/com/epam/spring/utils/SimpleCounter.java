package com.epam.spring.utils;

import java.util.Map;

public class SimpleCounter implements Counter {
	
	private Map<DataType, Integer> countsOfData;
	
	public SimpleCounter(Map<DataType, Integer> countsOfData) {
		this.countsOfData = countsOfData;
	}
	
	public int getCount(DataType data) {
		return this.countsOfData.get(data);
	}
	public void increase(DataType data) {
		this.countsOfData.put(data, this.countsOfData.get(data) + 1);
	}
	public void reduce(DataType data) {
		this.countsOfData.put(data, this.countsOfData.get(data) - 1);
	}
	public void reset(DataType data) {
		this.countsOfData.put(data, 0);
	}
	public void addDataType(DataType data) {
		if (this.countsOfData.get(data) != null) {
			this.countsOfData.put(data, 0);
		}
	}
}
