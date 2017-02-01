package effective.generics;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Typesafe heterogeneous container.
 * <p>
 * Created by tomi on 1/25/17.
 */
public class Favorites {

    private final Map<Class<?>, Object> container = new HashMap<>();

    public <TypeSafe> void putFav(final Class<TypeSafe> type, final TypeSafe instance) {

        if (type == null) throw new NullPointerException();

        container.put(type, instance);
    }

    public <T> T getFav(final Class<T> clazz) {
        return clazz.cast(container.get(clazz));
    }
}
