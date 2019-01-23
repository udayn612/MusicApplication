package com.stackroute.domain;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data

public class Music {

    @Id
    private int trackId; //id for Music class
    private String trackName;//name for Music class
    private String trackComment;//comment for Music class

}
