package cache;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CacheController<T>{

    int cacheSize;
    private CacheData[] cacheData;

    public CacheController(int cacheSize) {
        this.cacheSize = cacheSize;
        cacheData = new CacheData[cacheSize];
    }

    public void addData(T data){

        int freeSlot = findFreeSlot();

        if (freeSlot == -1){ // clear Last Recent Used slot
            freeSlot = findLatestUsedId();
            cacheData[freeSlot] = new CacheData<>(data, LocalDateTime.now());
        } else {
            cacheData[freeSlot] = new CacheData<>(data, LocalDateTime.now());
        }

    }

    public T getElement(int index){
        Integer minusOne = -1;

        if (index >= cacheSize){return (T)minusOne;}

        CacheData cacheItem =cacheData[index];

        if (cacheItem != null){
            return (T)cacheItem.getItem();
        } else {return (T)minusOne;}
    }

    public List<T> getAll(){
        List<T> outList = new ArrayList<>();
        for (CacheData data: cacheData){
            if (data != null){
                System.out.println(data.getItem());
                outList.add((T)data);
            }
        }
        return outList;
    }

    private int findFreeSlot(){
        for (int i = 0; i<cacheSize; i++){
            if (cacheData[i] == null){
                return i;
            }
        }
        return -1;
    }
    private int findLatestUsedId(){
        int idOut = 0;
        LocalDateTime dateToCheck = cacheData[0].getUsedTime();
        for (int i = 0; i<cacheSize; i++){
                if (cacheData[i].getUsedTime().isBefore(dateToCheck)){
                    idOut = i;
                    dateToCheck = cacheData[i].getUsedTime();
                }
        }
        return idOut;
    }




    }
