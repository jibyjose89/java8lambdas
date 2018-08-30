package org.lambda.unit2;

import java.util.function.BiConsumer;

public class ExceptionHandlingWithLambda {
	public static void main(String[] args) {
		int [] someNumbers= {1,2,3,4,5};
		int key=0;
		doOperation(key, someNumbers,(a, b) -> System.out.println(a/b));
		
		}

	private static void doOperation(int key, int[] someNumbers, BiConsumer<Integer, Integer> consumer) {
		try {
		for(int i:someNumbers) {
			consumer.accept(i, key);
		}}
		catch(Exception e) {
			System.out.println("Arithmetic Exception caught");
		}
	}
	
}
