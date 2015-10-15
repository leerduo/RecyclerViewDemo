package it.tech.recyclerviewdemo.bean;

/**
 * Created by chenfuduo on 2015/10/15.
 */
public class EventInfo {
    private String address;
    private String begin_time;
    private String end_time;
    private String image;
    //参加活动的人数
    private String participant_count;
    //活动的标题
    private String title;
    //对活动感兴趣的人数
    private String wisher_count;

    public EventInfo() {
    }

    public EventInfo(String address, String begin_time,
                     String end_time, String image,
                     String participant_count, String title,
                     String wisher_count) {
        this.address = address;
        this.begin_time = begin_time;
        this.end_time = end_time;
        this.image = image;
        this.participant_count = participant_count;
        this.title = title;
        this.wisher_count = wisher_count;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(String begin_time) {
        this.begin_time = begin_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getParticipant_count() {
        return participant_count;
    }

    public void setParticipant_count(String participant_count) {
        this.participant_count = participant_count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWisher_count() {
        return wisher_count;
    }

    public void setWisher_count(String wisher_count) {
        this.wisher_count = wisher_count;
    }

    @Override
    public String toString() {
        return "EventInfo{" +
                "address='" + address + '\'' +
                ", begin_time='" + begin_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", image='" + image + '\'' +
                ", participant_count='" + participant_count + '\'' +
                ", title='" + title + '\'' +
                ", wisher_count='" + wisher_count + '\'' +
                '}';
    }
}
