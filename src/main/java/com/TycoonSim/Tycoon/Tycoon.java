package com.TycoonSim.Tycoon;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

@Entity(name = "tycoon")
public class Tycoon {
    @Id
    Long id;

    String handle;
    int score;
    String date;

    public Tycoon(String handle , int score , String date){
        this.handle = handle;
        this.score = score;
        this.date = date;
    }

    public long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id=id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    @Override
    public String toString() {
        return "TycoonRecord{" +
                "id=" + id +
                ", score=" + score +
                ", handle='" + handle + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}

