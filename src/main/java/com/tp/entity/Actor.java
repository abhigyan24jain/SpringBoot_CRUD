package com.tp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Actor {
    @Id
    private Integer actorId;
    private String actorName;
    private String movieName;
    private Double movieCollection;
}
