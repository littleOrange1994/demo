package com.chen.cat.aop;
import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Transaction;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author fancheng.zeng
 * @title
 * @email Fancheng.Zeng@geely.com
 * @create 2019/9/12
 * @desc  切面
 */

@Aspect
@Component
public class CatAopService {

    @Around(value = "execution(public * com..*.*(..))&&@annotation(CatAnnotation)")
    public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature joinPointObject = (MethodSignature) pjp.getSignature();
        Method method = joinPointObject.getMethod();
        String[] classNameTemps = method.getDeclaringClass().getName().split("\\.");
        String className=classNameTemps[classNameTemps.length-1];
        Transaction t = Cat.newTransaction("method", className+"#"+method.getName());

        try {
            Object res = pjp.proceed();
            System.out.println("方法执行完毕！");
            t.setSuccessStatus();
            return res;
        } catch (Throwable e) {
            t.setStatus(e);
            Cat.logError(e);
            throw e;
        } finally {
            t.complete();
        }
    }
}
