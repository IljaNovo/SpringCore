package com.epam.spring.utils;

public interface Counter {
	
	public int getCount(DataType data);
	
	public void increase(DataType data);
	
	public void reduce(DataType data);
	
	public void reset(DataType data);
	
	public void addDataType(DataType data);
}
