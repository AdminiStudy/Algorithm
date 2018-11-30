package Conversions;

import java.util.Scanner;

/**
 * Converts any Octal number to a Binary number
 * 
 * @author Zachary Jones
 *
 */
public class OctalToBinary {

	/**
	 * Main method
	 * 
	 * @param args Command line arguments
	 */
	public static void main(String args[]) {
		
		System.out.println("Octal to Binary");
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter the number : ");
		int o = Integer.parseInt(sc.nextLine(), 8);
		System.out.println("Binary equivalent: " + convertOctalToBinary(o));
		sc.close();
	}

	/**
	 * This method converts an octal number to a binary number.
	 * 
	 * @param o The octal number
	 * @return The binary number
	 */
	public static String convertOctalToBinary(int o) {

		String binary = Integer.toBinaryString(o);
		System.out.println("Binary Value is : " + binary);
		return binary;
	}
}
