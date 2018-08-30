package org.lambda.unit3.closuresAndthis;

public class ClosureExampleWithAnonymousClass {

	public static void main(String[] args) {
		int a=10;
		int b=20;
		process(a,new Process() {
			
			@Override
			public void add(int a) {
				System.out.println(a+b);
			}
		});
	}

	private static void process(int a, Process p) {
		p.add(a);
	}

}

interface Process{
	void add(int a);
}
