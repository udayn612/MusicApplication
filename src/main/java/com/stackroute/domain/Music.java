package com.stackroute.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Music {

    @Id
    int trackId;
    String trackName;
    String trackComment;

    public Music(int trackId, String trackName, String trackComment) {
        this.trackId = trackId;
        this.trackName = trackName;
        this.trackComment = trackComment;
    }

    @Override
    public String toString() {
        return "Music{" +
                "trackId=" + trackId +
                ", trackName='" + trackName + '\'' +
                ", trackComment='" + trackComment + '\'' +
                '}';
    }

    public Music() {
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getTrackComment() {
        return trackComment;
    }

    public void setTrackComment(String trackComment) {
        this.trackComment = trackComment;
    }
}
