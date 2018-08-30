package org.lambda.unit2;

import java.util.function.BiConsumer;

public class ExceptionHandlingWrapperLambda {
	public static void main(String[] args) {
		int [] someNumbers= {1,2,3,4,5};
		int key=0;
		doOperation(key, someNumbers,wrapperLambda((a, b) -> System.out.println(a/b)));
		
		}

	private static void doOperation(int key, int[] someNumbers, BiConsumer<Integer, Integer> consumer) {
		for(int i:someNumbers) {
			consumer.accept(i, key);
		}
	}
	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
		return (a,b)->{		
			try {
		consumer.accept(a, b);
		}
		catch(Exception e) {
			System.out.println("Arithmetic exception caught");
		}
		};
	}
}
