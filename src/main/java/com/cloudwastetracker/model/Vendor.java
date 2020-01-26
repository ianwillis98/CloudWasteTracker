package com.cloudwastetracker.model;

import java.util.List;

public class Vendor {
	
	public List<Result> result;
	
	public static class Result {
		
		public String key;
		
		public String label; 
		
		public String description;
		
	}

}
