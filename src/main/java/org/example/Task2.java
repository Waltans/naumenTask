package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Task2 {
	public static void main(String[] args) {
		Random random = new Random();
		int size = random.nextInt();
		
		ArrayList<Double> list = new ArrayList<>();
		
		for (int i = 0; i < size; i++) {
			list.add(random.nextDouble() * 100);
		}
		insertionSort(list);
		
		System.out.println("Отсортированный список: " + list);
	}
	
	public static void insertionSort(ArrayList<Double> list) {
		for (int i = 1; i < list.size(); i++) {
			Double key = list.get(i);
			int j = i - 1;
			
			while (j >= 0 && list.get(j) > key) {
				list.set(j + 1, list.get(j));
				j--;
			}
			list.set(j + 1, key);
		}
	}
	
}
