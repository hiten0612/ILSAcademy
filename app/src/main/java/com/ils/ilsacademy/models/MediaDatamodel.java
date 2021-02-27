package com.ils.ilsacademy.models;

public class MediaDatamodel {
    String title;
    String des;
    String link;

    public MediaDatamodel()
    {

    }

    public MediaDatamodel(String title, String des, String link) {
        this.title = title;
        this.des = des;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
