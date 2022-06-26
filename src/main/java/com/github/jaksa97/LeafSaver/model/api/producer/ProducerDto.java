package com.github.jaksa97.LeafSaver.model.api.producer;

import lombok.*;
import javax.persistence.*;

@Entity
@AllArgsConstructor
@Data
public class ProducerDto {
    @Id
    @GeneratedValue
    private int id;

    private String name;
}
