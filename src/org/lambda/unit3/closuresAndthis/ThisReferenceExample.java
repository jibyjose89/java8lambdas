package org.lambda.unit3.closuresAndthis;

public class ThisReferenceExample {

	public static void main(String[] args) {
		ThisReferenceExample thisEx= new ThisReferenceExample();
		thisEx.doProcess(10,new ProcessThis() {
			
			@Override
			public void process(int i) {
				System.out.println("value of i is "+i);
				System.out.println(this);
			}
			public String toString() {
				return "Anonymous inner class";
				
			}
		});

	}

	private void doProcess(int i, ProcessThis processThis) {
		// TODO Auto-generated method stub
		processThis.process(i);
	}

	

}
interface ProcessThis{
	void process(int i);
}
