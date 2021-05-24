package com.roytuts.java.junit.dynamic.tests;

public final class MinMaxElementFinder {

	public static int findMax(int arr[]) {
		int max = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}

		return max;
	}

	public static int findMin(int arr[]) {
		int min = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (min > arr[i]) {
				min = arr[i];
			}
		}

		return min;
	}

}
