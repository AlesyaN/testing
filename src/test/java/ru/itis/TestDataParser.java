package ru.itis;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class TestDataParser {

    private List<Object> listOfObjects;

    public TestDataParser() {
        listOfObjects = new ArrayList<>();
        loadObjects();
    }

    private void loadObjects() {
        File file = new File(Const.FILE);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = null;

            while ((line = reader.readLine()) != null) {
                String[] lineArr = line.split("=");
                String className = lineArr[0];
                Class<?> type = Class.forName("ru.itis.models." + className);

                String json = lineArr[1];
                ObjectMapper mapper = new ObjectMapper();
                Object object = mapper.readValue(json, type);
                System.out.println(object);
                listOfObjects.add(object);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Exception while creating reader");
        } catch (IOException e) {
            System.out.println("Exception while reading from file");
        } catch (ClassNotFoundException e) {
            System.out.println("Exception while trying to find type");
        }
    }

    public List<Object> get(String className) {
        List<Object> result = new ArrayList<>();
        try {
            Class<?> type = Class.forName("ru.itis.models." + className);
            for (Object object: listOfObjects) {
                if (object.getClass().equals(type)) {
                    result.add(object);
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Exception while trying to get object of type " + className);
        }
        return result;
    }
}
