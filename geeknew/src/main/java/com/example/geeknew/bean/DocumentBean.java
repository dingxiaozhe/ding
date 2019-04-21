package com.example.geeknew.bean;

public class DocumentBean {
    private String title;
    private String count;
    private String pic;
    private String tab;
    private String time;
    private String author;
    private String lastPerson;
    public String url;
    public DocumentBean(){}

    public DocumentBean(String title, String count, String pic, String tab, String time, String author, String lastPerson, String url) {
        this.title = title;
        this.count = count;
        this.pic = pic;
        this.tab = tab;
        this.time = time;
        this.author = author;
        this.lastPerson = lastPerson;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getTab() {
        return tab;
    }

    public void setTab(String tab) {
        this.tab = tab;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLastPerson() {
        return lastPerson;
    }

    public void setLastPerson(String lastPerson) {
        this.lastPerson = lastPerson;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "DocumentBean{" +
                "title='" + title + '\'' +
                ", count='" + count + '\'' +
                ", pic='" + pic + '\'' +
                ", tab='" + tab + '\'' +
                ", time='" + time + '\'' +
                ", author='" + author + '\'' +
                ", lastPerson='" + lastPerson + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
