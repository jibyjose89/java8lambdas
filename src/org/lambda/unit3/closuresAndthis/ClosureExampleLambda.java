package org.lambda.unit3.closuresAndthis;

public class ClosureExampleLambda {
	public static void main(String[] args) {
		int a=10;
		int b=20;
		process(a,i-> System.out.println(i+b));
	}

	private static void process(int a, Process p) {
		p.add(a);
	}
}
