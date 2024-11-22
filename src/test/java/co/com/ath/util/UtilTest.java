package co.com.ath.util;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.google.gson.Gson;

import java.math.BigDecimal;

public class UtilTest {

    // Test para el método string2Object
    @Test
    public void testString2Object() {
        String json = "{\"name\":\"Ronald\", \"age\":30, \"height\":180.5}";
        Person expectedPerson = new Person("Ronald", 30, 180.5);

        Person actualPerson = (Person) Util.string2Object(json, Person.class);

        assertEquals(expectedPerson.getName(), actualPerson.getName());
        assertEquals(expectedPerson.getAge(), actualPerson.getAge());
        assertEquals(expectedPerson.getHeight(), actualPerson.getHeight());
    }

    // Test para el método object2String
    @Test
    public void testObject2String() {
        Person person = new Person("Ronald", 30, 180.5);
        String expectedJson = "{\"name\":\"Ronald\",\"age\":30,\"height\":180.5}";

        String actualJson = Util.object2String(person);

        assertEquals(expectedJson, actualJson);
    }

    // Test para verificar la conversión de Double a BigDecimal en el JSON
    @Test
    public void testDoubleToBigDecimalSerialization() {
        double value = 180.5;
        Person person = new Person("Ronald", 30, value);

        String json = Util.object2String(person);
        assertTrue(json.contains("180.5"));

        Person deserializedPerson = (Person) Util.string2Object(json, Person.class);
        assertEquals(value, deserializedPerson.getHeight());
    }

    // Clase auxiliar para representar a la persona
    public static class Person {
        private String name;
        private int age;
        private double height;

        public Person(String name, int age, double height) {
            this.name = name;
            this.age = age;
            this.height = height;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public double getHeight() {
            return height;
        }
    }
}