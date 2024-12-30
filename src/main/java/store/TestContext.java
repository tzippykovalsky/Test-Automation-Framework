package store;

import java.util.HashMap;
import java.util.Map;

public class TestContext {
    private static TestContext instance;
    private Map<String, Object> contextData = new HashMap<>();

    private TestContext() {}

    public static TestContext getInstance() {
        if (instance == null) {
            instance = new TestContext();
        }
        return instance;
    }

    public void set(String key, Object value) {
        contextData.put(key, value);
    }

    public Object get(String key) {
        return contextData.get(key);
    }

    public String getString(String key) {
        return (String) contextData.get(key);
    }
}
//USE
 // TestContext.getInstance().set("browser", System.getProperty("browser", "chrome"));
//
//        String browser = TestContext.getInstance().getString("browser");


