/**
 * @version 1.0.0
 * <b>Lab #1</b>
 */
package com.company;

import java.util.ArrayList;
import java.util.List;



/**
 *Class Main this is class where i`m testing my other classes
 */

public class Main {

    public static void main(String[] args) {
        /**
         *Create and initialization Student object
         */
        Student student = new Student.Builder()
                .withId(12312)
                .withName("Alexandr")
                .withSurname("Svekla")
                .withAge(17)
                .withGroup(402)
                .withSpecialyty("Aplied Math")
                .withSex(Sex.Male)
                .build();
        System.out.println(student.toString());
        List<String> lessons = new ArrayList<>();
        lessons.add("Math");
        lessons.add("OOP");
        lessons.add("English");
        /**
         *Create and initialization Teacher object
         */
        Teacher teacher = new Teacher.Builder()
                .withId(12312)
                .withName("Vasul")
                .withSurname("Vasulovuch")
                .withAge(17)
                .withSex(Sex.Male)
                .withLessons(lessons)
                .build();

        System.out.println(teacher.toString());
    }
}
