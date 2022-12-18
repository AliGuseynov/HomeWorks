package Model;

public enum ItemCategory {
    BOOK("BOOK"),
    ELECTRONICS("ELECTRONICS"),
    PET("PET"),
    FOOD("FOOD");

    private String value;

    public String getValue() {
        return value;
    }

    ItemCategory(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return this.getValue();
    }
}
