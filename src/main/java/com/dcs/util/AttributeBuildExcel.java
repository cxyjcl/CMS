package com.dcs.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface AttributeBuildExcel {

	int order() default Integer.MAX_VALUE;

	boolean needMerge() default false;

	String excelColumName() default "";
}
