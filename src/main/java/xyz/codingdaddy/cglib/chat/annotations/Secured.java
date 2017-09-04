package xyz.codingdaddy.cglib.chat.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Identifies the methods which require the user to be authenticated in order to
 * perform an action.
 * 
 * @author serhiy
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Secured {

}
