package by.it.korobeinikov.jd01_10;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Param {
    int a() default 4;
    int b();
}
