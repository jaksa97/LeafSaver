package com.github.jaksa97.LeafSaver.model.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cure")
public class CureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private DrugEntity drug;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private DiseaseEntity disease;

    @Column(length = 1023, name = "instruction")
    private String instruction;
}
