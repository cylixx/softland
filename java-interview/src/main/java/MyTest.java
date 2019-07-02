public class MyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int moded = 5 % 2;
		System.out.println("mod=" + moded);
		
	}
	

// 2019-05-09 Propblema 1 WorldQuant - Encontrar la compañias con promedio menor a 40000	
//	OK
//	SELECT DISTINCT C.NAME FROM COMPANY C, SALARY SA, (
//	    SELECT S.COMPANY_ID, AVG(S.SALARY) AS PROM FROM SALARY S GROUP BY COMPANY_ID
//	) TMP WHERE C.ID=SA.COMPANY_ID AND C.ID=TMP.COMPANY_ID AND TMP.PROM>40000;
	
	
}
