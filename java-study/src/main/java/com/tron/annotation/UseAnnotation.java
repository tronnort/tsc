package com.tron.annotation;

import com.sun.org.apache.regexp.internal.RE;

@Tron("zhenwuhuan")
public class UseAnnotation {
    private String name;
    public Integer age;

    UseAnnotation() {
        Tron annotation = UseAnnotation.class.getAnnotation(Tron.class);
        this.name = annotation.value();
        this.age = annotation.age();
    }

    public String getName() {
        return name;
    }
}
