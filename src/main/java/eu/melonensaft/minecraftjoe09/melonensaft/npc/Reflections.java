package eu.melonensaft.minecraftjoe09.melonensaft.npc;

import java.lang.reflect.Field;

public class Reflections {

    public void setValue(Object object, String name, Object value) {
        try {
            Field field = object.getClass().getDeclaredField(name);
            field.setAccessible(true);
            field.set(object, value);
        } catch (Exception exception) {}
    }

    public Object getValue(Object object, String name)
}
