package second_task;

public class swap_variables {
	
	public static void main(String[] args) {
		int a = 4;
		int b = 7;
		System.out.println("Before swap: a = " + a + " b = " + b);
		a = a + b; // a=11
		b = a - b; // b=4
		a = a - b; // a=7
		System.out.println("After swap: a = " + a + " b = " + b);
	}
}
