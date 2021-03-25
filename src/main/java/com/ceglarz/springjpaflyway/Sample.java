package com.ceglarz.springjpaflyway;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Sample {

    @Id
    private int id;
    private String name;
}
