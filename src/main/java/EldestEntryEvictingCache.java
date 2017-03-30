import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class EldestEntryEvictingCache<T, E> extends LinkedHashMap<T, E> {

    private final Integer maximumEntries;

    public EldestEntryEvictingCache(final Integer maxEntries) {
        super(maxEntries);
        this.maximumEntries = maxEntries;
    }

    @Override
    protected boolean removeEldestEntry(Entry eldest) {
        return size() > maximumEntries;
    }

    @Override
    public E get(Object key) {
        return super.get(key);
    }

    @Override
    public E put(T key, E value) {
        return super.put(key, value);
    }
}
