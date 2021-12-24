
package com.company;

import java.io.*;
import com.google.gson.Gson;

import javax.xml.bind.*;
import javax.xml.bind.annotation.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Class <b>Student</b> this is Model Students
 * @author Alexander Slekla
 */
@XmlRootElement
public class Student implements ISerializable{


    /**
     * student`s  id
     */

    @XmlElement
    private int id;
    /**
     * student`s  name
     */
    @XmlElement
    private String name;
    /**
     * student`s second name
     */
    @XmlElement
    private String surname;
    /**
     * student`s  speciality in university
     */
    @XmlElement
    private String speciality;
    /**
     * student`s  number group
     */
    @XmlElement
    private int group;
    /**
     * student`s  age
     */
    @XmlElement
    private int age;
    /**
     * student`s sex
     */
    @XmlElement
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
           JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);

           Marshaller marshaller = jaxbContext.createMarshaller();

           File file = new File(fileName);

           marshaller.marshal(this, file);
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    /**
     * Pattern Builder
     */
    public static class Builder{
        /**
         * Student class object
         */
        private Student newStudent;

        /**
         * This is constructor with all param
         * @param id
         * @param name
         * @param surname
         * @param speciality
         * @param age
         * @param group
         * @param sex
         */
        public Builder(int id,String name, String surname, String speciality, int group, int age, Sex sex){
            newStudent.id = id;
            newStudent.name = name;
            newStudent.surname = surname;
            newStudent.speciality = speciality;
            newStudent.group = group;
            newStudent.age = age;
            newStudent.sex = sex;
        }

        public Builder() {
            newStudent = new Student();
        }
        /**
         *
         * @param id
         * @return obj init by id
         */
        public Builder withId(int id){
            newStudent.id = id;
            return this;
        }
        /**
         *
         * @param name
         * @return obj init by name
         */
        public Builder withName(String name){
            newStudent.name = name;
            return this;
        }
        /**
         *
         * @param surname
         * @return obj init by surname
         */
        public Builder withSurname(String surname){
            newStudent.surname = surname;
            return this;
        }

        /**
         *
         * @param age
         * @return obj init by age
         */
        public Builder withAge(int age){
            newStudent.age = age;
            return this;
        }
        public Builder withSpecialyty(String specialyty){
            newStudent.speciality = specialyty;
            return this;
        }

        /**
         *
         * @param group
         * @return object initialized by group
         */
        public Builder withGroup(int group){
            newStudent.group = group;
            return this;
        }
        /**
         * @param sex
         * @return object initialized by sex
         */
        public Builder withSex(Sex sex){
            newStudent.sex = sex;
            return this;
        }

        /**
         *
         * @param name
         * @param surname
         * @return object initialized by name and surname
         */
        public Builder withFullname(String name, String surname){
            newStudent.name = name;
            newStudent.surname = surname;
            return this;
        }
        public Student build(){
            return newStudent;
        }
    }

    /**
     * Override toString Method
     * @return String which consist all data about Students
     */
    @Override
    public String toString() {
        return "Data about students : "
                + "\n\tID : " + this.id
                + "\n\tName : " + this.name
                + "\n\tSurname : " +  this.surname
                + "\n\tAge : "+  this.age
                +"\n\tSpeciality : " +  this.speciality
                + "\n\tGroup : " +  this.group
                + "\n\tSex : " +  this.sex.toString();
    }
    /**
     * Override hashCode Method
     * @return obj id
     */
    @Override
    public int hashCode() {
        return this.id;
    }
    /**
     * Override Equals Method
     * @return True/False
     */
    @Override
    public boolean equals(Object obj) {
        Student student = (Student) obj;
        return  this.id ==student.id;
    }
}
