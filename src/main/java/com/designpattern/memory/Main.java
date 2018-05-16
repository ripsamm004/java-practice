package com.designpattern.memory;

public class Main {

	public static void main(String args[]) {
		Main main = new Main();
		main.start();

		// B
		// b
		// C
	}
	
	public void start() {
		String last = "Z";
		Container container = new Container();
		container.setInitial("C");
		another(container,last);
		System.out.print(container.getInitial());
	}
	
	public void another(Container initialHolder, String newInitial) {
		newInitial.toLowerCase(); // NOT change the newInitial but create a new string "z"
		initialHolder.setInitial("B");
		Container initial2 = new Container();
		initialHolder=initial2;
		System.out.print(initialHolder.getInitial());
		System.out.print(newInitial);
	}
}
