package it.tech.recyclerviewdemo.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenfuduo on 2015/10/15.
 */
public class EventResultInfo {

    private int count;
    private List<EventInfo> events = new ArrayList<>();
    private int start;
    private int total;

    public EventResultInfo() {
    }

    public EventResultInfo(int count, List<EventInfo> events, int start, int total) {
        this.count = count;
        this.events = events;
        this.start = start;
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<EventInfo> getEvents() {
        return events;
    }

    public void setEvents(List<EventInfo> events) {
        this.events = events;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "EventResultInfo{" +
                "count=" + count +
                ", events=" + events +
                ", start=" + start +
                ", total=" + total +
                '}';
    }
}
