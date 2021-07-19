package com.Alevel;

public class Collections {

    private int count;
    private int iter;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getIter() {
        return iter;
    }

    public void setIter(int iter) {
        this.iter = iter;
    }


    @Override
    public String toString() {
        return "Collections{" +
                "count=" + count +
                ", iter=" + iter +
                '}';
    }
}
