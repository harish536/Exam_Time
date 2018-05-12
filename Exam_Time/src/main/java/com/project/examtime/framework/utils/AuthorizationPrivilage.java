package com.project.examtime.framework.utils;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.examtime.constants.PrivilegeEnum;


/**
 * 
 * @author Harish
 * 
 * 
 *
 */


@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface AuthorizationPrivilage {

	PrivilegeEnum privilege() default PrivilegeEnum.READ;

}


