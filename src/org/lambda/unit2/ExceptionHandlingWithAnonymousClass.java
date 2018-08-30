package org.lambda.unit2;

public class ExceptionHandlingWithAnonymousClass {
	public static void main(String[] args) {
		int [] someNumbers= {1,2,3,4,5};
		int key=1;
		doOperation(key, someNumbers,new Operation() {
			
			@Override
			public void div(int a, int b) {
				System.out.println(a/b);
			}
		});
		
		}

	private static void doOperation(int key, int[] someNumbers, Operation operations) {
		try {
		for(int i:someNumbers) {
			operations.div(i, key);
		}}
		catch(Exception e) {
			System.out.println("Arithmetic Exception caught");
		}
	}

}
interface Operation {
	public void div(int a, int b);

}

