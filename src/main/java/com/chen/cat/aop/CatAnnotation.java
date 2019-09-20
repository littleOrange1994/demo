package com.chen.cat.aop;


import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
/**
 * @author fancheng.zeng
 * @title
 * @email Fancheng.Zeng@geely.com
 * @create 2019/9/12
 * @desc
 */
@Retention(RUNTIME)
@Target(ElementType.METHOD)
public @interface CatAnnotation {
}
