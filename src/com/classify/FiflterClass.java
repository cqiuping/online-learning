package com.classify;

import java.util.Arrays;
import java.util.List;


public class FiflterClass {

	public int  countKeywords(String text,List<String> keywords){
		KeywordFilterBuilder builder = new KeywordFilterBuilder();
		builder.setKeywords(keywords);
		builder.setSkipChars(Arrays.asList('*', ' ', '_', '-', '£¬'));
		KeywordFilter filter = builder.build();
		int count=0;
		for(int i=0;i<keywords.size();i++)
		{
			count+=filter.count(text, keywords.get(i));
		}
		return count;
	}
}
