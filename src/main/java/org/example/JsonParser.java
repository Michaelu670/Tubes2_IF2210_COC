package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class JsonParser {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Person person = new Person(10, "a");
        Person person1 = new Person();

        try (FileWriter f = new FileWriter("src/main/resources/abc.json")) {
            gson.toJson(person, f);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            person1 = gson.fromJson(new FileReader("src/main/resources/abc.json"), Person.class);
            System.out.println(person1.toString());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }



}
