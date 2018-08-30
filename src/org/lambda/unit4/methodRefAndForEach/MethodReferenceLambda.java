package org.lambda.unit4.methodRefAndForEach;

public class MethodReferenceLambda {

	public static void main(String[] args) {
		Thread t= new Thread(MethodReferenceLambda::printMessage);//()->method()
														//MethodReferenceLambda::printMessage == ()->printMessage()
		t.start();
	}
	public static void printMessage() {
		System.out.println("hello");
	}

}
