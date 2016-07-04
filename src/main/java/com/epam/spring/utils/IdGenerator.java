package com.epam.spring.utils;

public interface IdGenerator {
	
	public int generate(DataType data);
	
	public void addDataType(DataType data);
}
