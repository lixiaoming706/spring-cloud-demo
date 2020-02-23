package com.lxm.demo.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

/**
 * 切面
 * @author Administrator
 *
 */

@Aspect
@Component
public class LogAspect {
	
	 @Pointcut("execution(public int  com.lxm.demo.aop.MathCalculator.*(..))") 
	public void ponitCut() {}
	
	
	@Before("execution(* com.lxm.demo.aop.MathCalculator.*(..))") 
	public void logStart(JoinPoint joinPoint) {
		
		String name = joinPoint.getSignature().getName();
		System.out.println(name);
		System.out.println(name);
		System.out.println(name);
		System.out.println(name);
		System.out.println("除法运行了。。。参数列表是：{"+Arrays.asList(joinPoint.getArgs())+"}");
	}
	
	@After("ponitCut()")
	public void logEnd() {
		System.out.println("除法结束。。。。");
	}
	
	@AfterReturning(value="com.lxm.demo.aop.LogAspect.ponitCut()",returning = "result")
	public void logReturn(Object result) {
		System.out.println("除法正常返回。。运行结果是：{"+result+"}");
	}
	
	@AfterThrowing(value="com.lxm.demo.aop.LogAspect.ponitCut()",throwing = "ex")
	public void logException(Exception ex) {
		System.out.println("除法异常。。。异常信息：{}");
	}
}
