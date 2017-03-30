import java.util.*;

public class MapWithValueSets<K, V> {

    private final Map<K, Set<V>> map;
    private final Comparator<V> comparator;

    public MapWithValueSets() {

        map = new HashMap<>();
        comparator = null;
    }

    public MapWithValueSets(final Comparator<V> comparator) {

        this.comparator = comparator;
        this.map = new HashMap<>();
    }

    public void put(K key, V value) {

        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {

            final Set<V> setToInsert;

            if (comparator == null) {
                setToInsert = new TreeSet<>();
            } else {
                setToInsert = new TreeSet<>(comparator);
            }

            setToInsert.add(value);

            map.put(key, setToInsert);
        }
    }

    public Set<V> deleteKey(K key) {
        return map.remove(key);
    }

    public Boolean deleteValue(K key, V value) {

        return map.containsKey(key) && map.get(key).contains(value) ? map.get(key).remove(value) : false;
    }

    public Set<V> get(K key) {

        return map.get(key);
    }
}
