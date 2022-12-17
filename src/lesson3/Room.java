package lesson3;

public class Room {
    int windowCount;
    int maxPeople;
    private ClassType ClassName;


    public Room(int windowCount, int maxPeople, ClassType className) {
        this.windowCount = windowCount;
        this.maxPeople = maxPeople;
        this.ClassName = className;
    }

    public Room() {
    }

    public int getWindowCount() {
        return windowCount;
    }

    public void setWindowCount(int windowCount) {
        this.windowCount = windowCount;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public ClassType getClassName() {
        return ClassName;
    }

    public void setClassName(ClassType className) {
        ClassName = className;
    }
}
