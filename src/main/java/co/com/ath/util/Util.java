package co.com.ath.util;

import co.com.ath.model.Request;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.math.BigDecimal;

public class Util {
    /**
     * Instancia de Gson para convertir de String a Objecto
     */
    private static Gson gson = new Gson();

    /**
     * Instancia de ObjectMapper para mapear objetos
     */
    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Metodo para convertir un objeto a String
     */

    public static Object string2Object(String json, Class<? extends Object> classOfT) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Double.class, new JsonSerializer<Double>() {

            @Override
            public JsonElement serialize(Double src, final Type typOfSrc, final JsonSerializationContext context) {
                BigDecimal value = BigDecimal.valueOf(src);
                return new JsonPrimitive(value);
            }
        });
        gson = gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();

        // Se cambio debido a q
        return gson.fromJson(json, classOfT);
    }

    /**
     * Método para convertir un objeto a String JSON
     */
    public static String object2String(Object typeObject) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Double.class, new JsonSerializer<Double>() {
            @Override
            public JsonElement serialize(Double src, final Type typeOfSrc, final JsonSerializationContext context) {
                BigDecimal value = BigDecimal.valueOf(src);
                return new JsonPrimitive(value);
            }
        });
        gson = gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        return gson.toJson(typeObject);
    }


}
