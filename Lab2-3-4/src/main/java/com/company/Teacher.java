package com.company;

import com.google.gson.Gson;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.lang.annotation.Target;
import java.util.List;

/**
 * Class <b>Teacher</b> in university/college
 * @author Alexander Slekla
 */
public class Teacher implements ISerializable{

    private int id;
    private String name;
    private String surname;
    /**
     * List Lessons which teacher teach
     */
    private List<String> lessons;
    private int age;
    private Sex sex;



    @Override
    public void json_serialization(String fileName) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(this,writer);
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void xml_serialization(String fileName) {
        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(Teacher.class);

            Marshaller marshaller = jaxbContext.createMarshaller();

            File file = new File(fileName);

            marshaller.marshal(this, file);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Class which realized pattern Builder
     */
    public static class Builder{
        private Teacher teacher;

        public Builder(int id,String name, String surname,int age, Sex sex, List<String> lessons){
            teacher.id = id;
            teacher.name = name;
            teacher.surname = surname;
            teacher.age = age;
            teacher.sex = sex;
            teacher.lessons = lessons;
        }

        public Builder() {
            teacher = new Teacher();
        }
        public Teacher.Builder withId(int id){
            teacher.id = id;
            return this;
        }
        public Teacher.Builder withName(String name){
            teacher.name = name;
            return this;
        }

        public Teacher.Builder withSurname(String surname){
            teacher.surname = surname;
            return this;
        }

        public Teacher.Builder withAge(int age){
            teacher.age = age;
            return this;
        }

        public Teacher.Builder withSex(Sex sex){
            teacher.sex = sex;
            return this;
        }
        public Teacher.Builder withFullname(String name, String surname){
            teacher.name = name;
            teacher.surname = surname;
            return this;
        }

        public Teacher.Builder withLessons(List<String> lessons){
            teacher.lessons = lessons;
            return this;
        }
        public Teacher build(){
            return teacher;
        }
    }

    /**
     * Override toString Method
     * @return String which consist all data about Students
     */
    @Override
    public String toString() {
        return "Data about teacher : "
                + "\n\tID : " + this.id
                + "\n\tName : " + this.name
                + "\n\tSurname : " +  this.surname
                + "\n\tAge : "+  this.age
                + "\n\tSex : " +  this.sex.toString()
                + "\n\tLessons : " + this.lessons.toString();
    }

    /**
     * Override HashCode Method
     * @return id Teacher
     */
    @Override
    public int hashCode() {
        return this.id;
    }

    /**
     * Override equals method
     * @return True/False
     */
    @Override
    public boolean equals(Object obj) {
        Teacher teacher = (Teacher) obj;
        return  this.id ==teacher.id;
    }
}
