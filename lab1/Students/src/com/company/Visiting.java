package com.company;

import java.util.Date;

/**
 * The class  <b>Visiting object</b> of which is a representation of the pair that the student missed
 */
public class Visiting {
    /**
     *id object class Visiting
     */
    private int id;
    /**
     * Student who missed or not missed lesson
     */
    private Student student;
    /**
     * Date when Student missed or not missed lesson
     */
    private Date date;
    /**
     * Lesson which Student missed or not missed
     */
    private String lesson;
    /**
     * Missed or NotMissed (true or false)
     */
    private boolean missed;

    /**
     * Class which realization Pattern Builder for class Visiting
     */
    public static class Builder{
        /**
         * object Visiting
         */
        public Visiting visiting;

        public Builder() {
            visiting = new Visiting();
        }

        /**
         * initialization field id in our object
         * @param id
         * @return object with Id
         */
        public Builder withId(int id){
            visiting.id = id;
            return  this;
        }
        /**
         * initialization field Student in our object
         * @param student
         * @return object with student
         */
        public Builder withStudent(Student student){
            visiting.student = student;
            return  this;
        }
        /**
         * initialization field date in our object
         * @param date
         * @return object with date
         */
        public Builder withDate(Date date){
            visiting.date = date;
            return this;
        }
        /**
         * initialization field lesson in our object
         * @param lesson
         * @return object with lesson which he missed/not missed
         */
        public Builder withLessons(String lesson) {
            visiting.lesson = lesson;
            return this;
        }
        /**
         * initialization field missed in our object
         * @param missed
         * @return object with init missed  field (true or false)
         */
        public Builder withMissed(boolean missed){
            visiting.missed = missed;
            return this;
        }

        /**
         * This method build your object
         * @return
         */
        public Visiting build(){
            return visiting;
        }
    }
    @Override
    public String toString() {
        return "Visiting : "
                + "\n\t : " + this.student.toString()
                + "\n\tName : " + this.date
                + "\n\tSurname : " +  this.lesson
                + "\n\tAge : "+  this.missed;
    }
    @Override
    public int hashCode(){
        return id;
    }
    @Override
    public boolean equals(Object visiting1){
        Visiting visiting = (Visiting) visiting1;
       if(this.id == visiting.id && this.date ==visiting.date && this.lesson == visiting.lesson)
           return true;
            else return false;
    }
}
