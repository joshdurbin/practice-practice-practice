import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class TestCaches {

    static final Integer SIZE_OF_CACHE = 2;

    Map<Integer, String> eldestEntryEvictingCache;
    LRUCache<Long, String> lruCache;

    @Before
    public void init() {

        // if need to be synchronized, use collections static method
        //Collections.synchronizedMap(new EldestEntryEvictingCache(2));
        // a user must serialize on the map returned from the aforementioned map
        eldestEntryEvictingCache = new EldestEntryEvictingCache(SIZE_OF_CACHE);

        eldestEntryEvictingCache.put(512, "San Francisco");
        eldestEntryEvictingCache.put(773, "Chicago");
        eldestEntryEvictingCache.put(217, "Central Illinois");

        lruCache = new LRUCache<>(SIZE_OF_CACHE);

        lruCache.put(1L, "Durbin");
        lruCache.put(2L, "James");

        lruCache.get(1L);

        lruCache.put(3L, "Tracey");
        lruCache.put(3L, "Smith");
    }

    @Test
    public void lruCacheShouldContainMostRecentInsertedAndAccessedEntries() {

        assertTrue(lruCache.get(1L).equals("Durbin"));
        assertNull(lruCache.get(2L));
        assertTrue(lruCache.get(3L).equals("Smith"));
    }

    @Test
    public void lruCacheShouldBeSizeLimited() {

        assertTrue(lruCache.size() == 2);
    }

    @Test
    public void eldestEntryEvictingCacheShouldBeSizeLimited() {

        assertTrue(lruCache.size() == 2);
    }

    @Test
    public void eldestEntryEvictingCacheShouldContainMostRecentTwoInsertedEntries() {

        assertTrue(eldestEntryEvictingCache.containsKey(773));
        assertTrue(eldestEntryEvictingCache.containsKey(217));
    }

    @Test
    public void eldestEntryEvictingCacheShouldNotContainFirstEntryDueToEviction() {

        assertFalse(eldestEntryEvictingCache.containsKey(512));
    }
}
