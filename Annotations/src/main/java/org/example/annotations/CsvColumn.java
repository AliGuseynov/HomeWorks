package org.example.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CsvColumn {
    public String name() default "";

    public String model() default "";

    public int engineSize() default 1600;

    public String driveWheels() default "RWD";
}