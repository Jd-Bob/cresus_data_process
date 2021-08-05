package mg.orange.cresus.enumerator;

public enum DateFormat {

    YYYYMMDD_DASH("yyyyMMDD", "yyyy-MM-dd");

    private final String key;
    private final String value;

    DateFormat(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
