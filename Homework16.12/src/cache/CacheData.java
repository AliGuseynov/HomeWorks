package cache;

import java.time.LocalDateTime;

public class CacheData<T>{
    T item;

    private LocalDateTime usedTime;

    public CacheData(T item, LocalDateTime usedTime) {
        this.item = item;
        this.usedTime = usedTime;
    }

    public T getItem() {
        return (T)item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public LocalDateTime getUsedTime() {
        return usedTime;
    }

    public void setUsedTime(LocalDateTime usedTime) {
        this.usedTime = usedTime;
    }
}
