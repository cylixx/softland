public class MyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int moded = 5 % 2;
		System.out.println("mod 10 % 7=" + 10 % 7);
		System.out.println("mod 7 % 10=" + 7 % 10);
		System.out.println("mod 20 % 10=" + 20 % 10);
		System.out.println("mod 1 % 2=" + 1 % 2);
		System.out.println("mod 5 % 2=" + 5 % 2);
		System.out.println("mod 4 % 2=" + 4 % 2);
		System.out.println("mod 5 % 5=" + 5 % 5);
		
		System.out.println("mod 1189730224 % 100=" + 1189730224 % 100);
		
		System.out.println("50 / 2  = " + 50/2);
		System.out.println("25 / 2  = " + 25/2);
		System.out.println("4 / 2  = " + 4/2);
		System.out.println("3 / 2  = " + 3/2);
		System.out.println("2 / 2  = " + 2/2);
		System.out.println("1 / 2  = " + 1/2);
		System.out.println("0 / 2  = " + 0/2);
		System.out.println("5 / 5  = " + 5/5);
		//System.out.println("1 / 0  = " + 1/0);  //Error / by zero
		
	}
	

// 2019-05-09 Propblema 1 WorldQuant - Encontrar la compañias con promedio menor a 40000	
//	OK
//	SELECT DISTINCT C.NAME FROM COMPANY C, SALARY SA, (
//	    SELECT S.COMPANY_ID, AVG(S.SALARY) AS PROM FROM SALARY S GROUP BY COMPANY_ID
//	) TMP WHERE C.ID=SA.COMPANY_ID AND C.ID=TMP.COMPANY_ID AND TMP.PROM>40000;
	
	
}
