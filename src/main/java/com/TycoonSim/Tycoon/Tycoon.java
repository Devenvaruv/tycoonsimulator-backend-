package com.TycoonSim.Tycoon;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

/**
 * Represents a Tycoon entity.
 */
@Entity(name = "tycoon")
public class Tycoon {

    @Id
    Long id;

    String handle;
    int score;
    String date;

    /**
     * Constructs a Tycoon object with the given parameters.
     *
     * @param handle the handle of the Tycoon
     * @param score  the score of the Tycoon
     * @param date   the date of the Tycoon record
     */
    public Tycoon(String handle, int score, String date) {
        this.handle = handle;
        this.score = score;
        this.date = date;
    }

    /**
     * Gets the ID of the Tycoon.
     *
     * @return the ID of the Tycoon
     */
    public long getId() {
        return this.id;
    }

    /**
     * Sets the ID of the Tycoon.
     *
     * @param id the ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the score of the Tycoon.
     *
     * @return the score of the Tycoon
     */
    public int getScore() {
        return score;
    }

    /**
     * Sets the score of the Tycoon.
     *
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Gets the date of the Tycoon record.
     *
     * @return the date of the Tycoon record
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the date of the Tycoon record.
     *
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Gets the handle of the Tycoon.
     *
     * @return the handle of the Tycoon
     */
    public String getHandle() {
        return handle;
    }

    /**
     * Sets the handle of the Tycoon.
     *
     * @param handle the handle to set
     */
    public void setHandle(String handle) {
        this.handle = handle;
    }

    /**
     * Returns a string representation of the Tycoon object.
     *
     * @return a string representation of the Tycoon object
     */
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
