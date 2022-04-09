package com.oracle.jfr;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

public class SampleApplication {

	public static void main(String[] args) {
		RandomGenerator random = RandomGenerator.getDefault();
		List<Integer> listOfInts = new ArrayList<>();
		
		for(int i = 0; i < 1000000000; i++) {
			listOfInts.add(random.nextInt());
		} 
	}

}
