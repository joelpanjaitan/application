import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class testNisp {
    private final ConcurrentSkipListMap<String, String> store = new ConcurrentSkipListMap<>();
    private final ConcurrentHashMap<String, List<String>> prefixMap = new ConcurrentHashMap<>();

    public void put(String key, String value){
        String oldValue = store.put(key, value);
        if (oldValue!= null){
            removeFromPrefixMap(key, oldValue);
        }
        addToPrefixMap(key,value);
    }

    public String get(String key){
        return store.get(key);
    }

    public void delete(String key){
        String finalResult = store.remove(key);
        if (finalResult!=null){
            removeFromPrefixMap(key, finalResult);
        }
    }

    public List<String> getKeysByPrefix(String prefix){
        return new ArrayList<>(store.navigableKeySet().subSet(prefix, true, prefix + Character.MAX_VALUE, true));
    }

    private void addToPrefixMap(String key, String value){
         for (int i = 1; i <= key.length(); i++) {
            String prefix = key.substring(0, i);
            prefixMap.computeIfAbsent(prefix, k -> new CopyOnWriteArrayList<>()).add(key);
        }
    }

    private void removeFromPrefixMap(String key, String oldValue){
        for (int i = 1; i <= key.length(); i++) {
            String prefix = key.substring(0, i);
            List<String> keys = prefixMap.get(prefix);
            if (keys != null) {
                keys.remove(key);
                if (keys.isEmpty()) {
                    prefixMap.remove(prefix);
                }
            }
        }
    }

    public static void main(String[] args){
        testNisp kvStore = new testNisp();
        kvStore.put("food","bar");
        System.out.println(kvStore.get("food"));

        kvStore.put("foo","bar");
        System.out.println(kvStore.getKeysByPrefix("foo"));

        kvStore.delete("foo");
        System.out.println(kvStore.getKeysByPrefix("foo"));
    }
}
