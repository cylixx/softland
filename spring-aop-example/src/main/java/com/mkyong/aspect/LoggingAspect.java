package com.mkyong.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;

import com.actinver.eactinver.anonymous.web.ws.annotation.ValidateOperation;
import com.mkyong.annotation.MyAnnotation;

@Aspect
public class LoggingAspect {

	/*@Before("execution(* com.mkyong.customer.bo.CustomerBo.addCustomer(..))")
	public void logBefore(JoinPoint joinPoint) {

		System.out.println("logBefore() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}*/

	/*@After("execution(* com.mkyong.customer.bo.CustomerBo.addCustomer(..))")
	public void logAfter(JoinPoint joinPoint) {

		System.out.println("logAfter() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("******");

	}*/
	
	/*@AfterReturning(
			pointcut = "execution(* com.mkyong.customer.bo.CustomerBo.addCustomerReturnValue(..))",
			returning= "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {

		System.out.println("logAfterReturning() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("Method returned value is : " + result);
		System.out.println("******");

	}*/
	
	/*@AfterThrowing(
			pointcut = "execution(* com.mkyong.customer.bo.CustomerBo.addCustomerThrowException(..))",
			throwing= "error")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {

		System.out.println("logAfterThrowing() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("Exception : " + error);
		System.out.println("******");

	}*/
	
	
	@Around("execution(* com.mkyong.customer.bo.CustomerBo.addCustomerAround(..))")
	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {

		System.out.println("logAround() is running!");
		System.out.println("hijacked method : " + joinPoint.getSignature().getName());
		System.out.println("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));
		
		System.out.println("Around before is running!");
		joinPoint.proceed();
		System.out.println("Around after is running!");
		
		System.out.println("******");
	}
	
	//@Around("execution(public * *(..)) && @annotation(com.mkyong.annotation.MyAnnotation)")
	@Around("execution(public * *(..)) && @annotation(com.mkyong.annotation.MyAnnotation)")
	//public void procede(ProceedingJoinPoint joinPoint, MyAnnotation mannotation) throws Throwable {
	public void procede(ProceedingJoinPoint joinPoint) throws Throwable {
	    
	    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        MyAnnotation anno = method.getAnnotation(MyAnnotation.class);
	    
	    
	    System.out.println("Point cut {}" + joinPoint.toShortString());
//	    System.out.println("MyAnnotation {}" + mannotation.value());

	    if (method.isAnnotationPresent(MyAnnotation.class)) {
		    MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
//		    Annotation anno = method.class.getAnnotation(MyAnnotation.class);
		    System.out.println("El valor de la annotation es:" + myAnnotation.value());
	    } else {
	    	System.out.println("No se encontro la anotacion en el metodo...");
	    }
	    
	    //return myAnnotation;
	}
	
}