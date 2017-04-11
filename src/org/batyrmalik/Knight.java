package org.batyrmalik;

public class Knight {
    private int id;
    private int hits=100;
    private boolean stepIsDone;
    private String name;
    private boolean current;

    public Knight(int id) {
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }
}
