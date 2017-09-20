package com.imark.common.util;

import java.lang.annotation.*;

@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemLog {
	// 模块
	String module() default "";

	// 方法,1,新增，3，更新，3，删除
	String methods() default "";

	// 描述
	String description() default "";
}

//说明了Annotation所修饰的对象范围：Annotation可被用于 packages、types（类、接口、枚举、Annotation类型）、类型成员（方法、构造方法、成员变量、枚举值）、方法参数和本地变量（如循环变量、catch参数）
//定义了该Annotation被保留的时间长短
//如果注解在声明时使用了@Documented，则在制作javadoc时注解信息会加入javadoc