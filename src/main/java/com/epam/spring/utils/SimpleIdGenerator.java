package com.epam.spring.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleIdGenerator implements IdGenerator{

	private Map<DataType, Integer> idOfData;
	
	public SimpleIdGenerator(List<DataType> dataTypes) {
		this.idOfData = new HashMap<DataType, Integer>();
		for (int i = 0; i < dataTypes.size(); ++i) {
			this.idOfData.put(dataTypes.get(i), 0);
		}
	}
	
	public int generate(DataType data) {
	    this.idOfData.put(data, this.idOfData.get(data) + 1);
	    return this.idOfData.get(data);
	}

	public void addDataType(DataType data) {
		if (this.idOfData.get(data) != null) {
			this.idOfData.put(data, 0);
		}
	}
}
