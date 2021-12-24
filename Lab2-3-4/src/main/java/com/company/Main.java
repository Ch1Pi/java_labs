package com.company;
import com.company.Sex;
import com.company.Student;
import com.company.Teacher;

import java.util.ArrayList;
import java.util.Date;
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
                .withGroup(412)
                .withSpecialyty("Aplied Math")
                .withSex(Sex.Male)
                .build();
        Student student2 = new Student.Builder()
                .withId(12312)
                .withName("Vova")
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
        System.out.println("_______________________________________________________");
        student2.txt_serialization("student2.txt");

        student.json_serialization("student2.json");

        student.xml_serialization("student.xml");

        Visiting visiting = new Visiting.Builder()
                .withId(1313)
                .withStudent(student)
                .withLessons("MAth")
                .withDate(new Date(2021,12,12))
                .withMissed(false)
                .build();
        System.out.println(visiting.toString());
    }
}
