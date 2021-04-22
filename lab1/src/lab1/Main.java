package lab1;

import java.util.Scanner;
/**
 * Number of student's book is 4
 * C2 = 0 -> O1 = '+'
 * C3 = 1 -> C = 1
 * C5 = 4 -> O2 = '-'
 * C7 = 4 -> Type of i and j is char
 */
public class Main {

	public static void main(String[] args) {
		double S = 0;

		Scanner sc = new Scanner(System.in);
		System.out.println("Print a, b, n, m:");
		int a, b, n, m;
		// Reading custom a, b, n, m
		do {
			try{
				String a_str = sc.nextLine();
				a = Integer.parseInt(a_str);
				if (a < 0){
					System.out.println("Char cannot be negative, try once more time.");
					continue;
				}
				break;
			}
			catch (NumberFormatException e)
			{
				System.out.println("Couldn't parse your input.");
			}
		}
		while (true);

		do {
			try{
				String b_str = sc.nextLine();
				b = Integer.parseInt(b_str);
				if (b < 0){
					System.out.println("Char cannot be negative, try once more time.");
					continue;
				}
				break;
			}
			catch (NumberFormatException e)
			{
				System.out.println("Couldn't parse your input.");
			}
		}
		while (true);

		do {
			try{
				String n_str = sc.nextLine();
				n = Integer.parseInt(n_str);
				if (n < 0){
					System.out.println("Char cannot be negative, try once more time.");
					continue;
				}
				break;
			}
			catch (NumberFormatException e)
			{
				System.out.println("Couldn't parse your input.");
			}
		}
		while (true);

		do {
			try{
				String m_str = sc.nextLine();
				m = Integer.parseInt(m_str);
				if (m < 0){
					System.out.println("Char cannot be negative, try once more time.");
					continue;
				}
				break;
			}
			catch (NumberFormatException e)
			{
				System.out.println("Couldn't parse your input.");
			}
		}
		while (true);
		final int C = 1;
		if (a > n || b > m){
			System.out.println("Upper limit less than lower limit");
			return;
		}
		if (a + C <= 0 && n + C >= 0) {
			System.out.println("Value can not be calculated. Dividing by zero found");
			return;
		}
		for (char i = (char) a; i <= n; i++) {
			for (char j = (char) b; j <= m; j++) {
					S += ((double) (i - j) / (i + C));
			}
		}
		System.out.println("S = " + S);
		sc.close();
	}
}


