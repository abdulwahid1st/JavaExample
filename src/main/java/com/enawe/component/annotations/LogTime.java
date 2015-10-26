package com.enawe.component.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * example-springmvc
 * com.enawe.component.annotations > LogTime.java
 * @author N Abdul Wh
 *
 * Aug 15, 2015 - 3:14:02 PM
 * 
 * Marker annotation object to be applied to any methods
 * which the life time of it want to be logged.
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogTime {

}
