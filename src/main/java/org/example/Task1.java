package org.example;

import java.util.Arrays;
import java.util.Random;

public class Task1 {
	
	public void calculatePositiveItem(boolean b){
		int[] numbers = generateArrayWithRandomNumbers();
		
		System.out.println(Arrays.stream(numbers).filter(n -> n > 0).sum());
	}
	
	private int[] generateArrayWithRandomNumbers() {
		Random random = new Random();
		int arraySize = random.nextInt();
		
		int[] array = new int[arraySize];
		
		for (int i = 0; i < arraySize; i++) {
			array[i] = random.nextInt();
		}
		
		return array;
	}
}
