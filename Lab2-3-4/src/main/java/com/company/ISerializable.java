package com.company;
import java.io.*;
import java.io.Serializable;

/**
 * Interface for writing objects to different file types
 */
public interface ISerializable extends Serializable {
    default void txt_serialization(String fileName){
         try {
              if (this != null) {
                   ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                           new FileOutputStream(fileName));
                   objectOutputStream.writeObject(this.toString());
                   objectOutputStream.flush();
                   objectOutputStream.close();
              }
         }
         catch (FileNotFoundException e) {
              e.printStackTrace();
         } catch (IOException e) {
              e.printStackTrace();
         }
    };

      void json_serialization(String fileName);

     void xml_serialization(String fileName);

}
