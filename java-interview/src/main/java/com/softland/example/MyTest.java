package com.softland.example;
public class MyTest {

	public static void main(String[] args) {
		
		int moded = 5 % 2;
		System.out.println("mod 10 % 7=" + 10 % 7);
		System.out.println("mod 7 % 10=" + 7 % 10);
		System.out.println("mod 20 % 10=" + 20 % 10);
		System.out.println("mod 1 % 2=" + 1 % 2);
		System.out.println("mod 5 % 2=" + 5 % 2);
		System.out.println("mod 4 % 2=" + 4 % 2);
		System.out.println("mod 8 % 2=" + 8 % 2);
		System.out.println("mod 5 % 5=" + 5 % 5);
		
		
		System.out.println("----------");
		System.out.println("mod 0 % 5=" + 0 % 5);
		System.out.println("mod 1 % 5=" + 1 % 5);
		System.out.println("mod 4 % 5=" + 4 % 5);
		System.out.println("mod 5 % 5=" + 5 % 5);
		System.out.println("mod 6 % 5=" + 6 % 5);
		System.out.println("----------"); 
		
		System.out.println("mod -1 % 5 =" + -1 % 5);
		System.out.println("mod 9 % 5 =" + 9 % 5);
		System.out.println("mod 10 % 5 =" + 10 % 5);
		
		System.out.println("mod 1189730224 % 100=" + 1189730224 % 100);
		
		System.out.println("50 / 2  = " + 50/2);
		System.out.println("25 / 2  = " + 25/2);
		System.out.println("4 / 2  = " + 4/2);
		System.out.println("3 / 2  = " + 3/2);
		System.out.println("2 / 2  = " + 2/2);
		System.out.println("1 / 2  = " + 1/2);
		System.out.println("0 / 2  = " + 0/2);
		System.out.println("5 / 5  = " + 5/5);
		
		System.out.println("97 / 26  = " + 97/26);
		System.out.println("122 / 26  = " + 122/26);
		//System.out.println("1 / 0  = " + 1/0);  //Error / by zero
		
		System.out.println("\n//--------------------------------------------------");
		String output_path = System.getenv("OUTPUT_PATH"); 
		System.out.println("output_path=" + output_path);
		System.out.println("PATH=" + System.getenv("PATH"));
		System.out.println("PATH=" + System.getenv("HOME"));
		System.out.println("System.getenv()=" + System.getenv());
		
	}
	

// 2019-05-09 Propblema 1 WorldQuant - Encontrar la compañias con promedio menor a 40000	
//	OK
//	SELECT DISTINCT C.NAME FROM COMPANY C, SALARY SA, (
//	    SELECT S.COMPANY_ID, AVG(S.SALARY) AS PROM FROM SALARY S GROUP BY COMPANY_ID
//	) TMP WHERE C.ID=SA.COMPANY_ID AND C.ID=TMP.COMPANY_ID AND TMP.PROM>40000;
	
	
}
