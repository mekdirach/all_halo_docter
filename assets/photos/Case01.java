package day3;

import java.util.Scanner;

public class Case01 {

	public static void resolve1( ) {
		Scanner input = new Scanner(System.in);
		
		int i,j,n1,n2,angka=0;
		
		System.out.println("n1:");
		n1 = input.nextInt();
		
		System.out.println("n2:");
		n2 = input.nextInt();
		
		int[][] arr = new int [2][n1];
			for (i = 0; i < arr.length; i++) {
				for (j = 0; j < n1; j++) {
					
				}
			}
		
		
		
	}
	
	public static void resolve1( ) {
		Scanner input = new Scanner(System.in);
	
		int i,j,n1,n2,angka=0;
		
		System.out.println("n1:");
		n1 = input.nextInt();
		
		System.out.println("n2:");
		n2 = input.nextInt();
		
		int[][] arr = new int [2][n1];
		
		for (i = 0;i < arr.length; i++) {
			for (j = 1; j <= arr[1].length; j++) {
			
				if (i==0) {
					arr[i][j-1] = j-1;
				
				} else {
					if (i = 2 && j % 3 == 0) {
						arr[i][j-1] = (-angka);
						angka = angka * (n2);
						
					} else if (j>=1) {
						arr[i][j-1] = angka;
						angka = angka * (n2);

					}
					
					
				} 
					
					
			}
			
			System.out.print(Arrays.toString(arr[i]));
			
		
	}
}
