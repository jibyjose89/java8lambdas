package org.lambda.unit2;

import java.util.function.BiConsumer;

public class ExceptionHandlingExample {

	public static void main(String[] args) {
		int [] someNumbers= {1,2,3,4,5};
		int key=0;
		OperationsImp op= new OperationsImp();
		doOperation(key, someNumbers,op);
		
		}

	private static void doOperation(int key, int[] someNumbers, OperationsImp op) {
		try {
		for(int i: someNumbers) {
			int sum=op.div(i, key);
			System.out.println(sum);
		}}
		catch(Exception e) {
			System.out.println("Exception caught");
		}
	}
}
