package by.it.patsko.jd01_10;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Param {
    int a();
    int b();
}
