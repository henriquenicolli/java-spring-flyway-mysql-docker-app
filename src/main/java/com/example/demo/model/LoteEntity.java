package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_lote")
public class LoteEntity {

    @Id
    @Column(name = "lote_id")
    private Long loteId;

    private String valor;

    @ManyToMany
    @JoinTable(
            name = "tb_lote_boleto",
            joinColumns = @JoinColumn(name = "lote_id"),
            inverseJoinColumns = @JoinColumn(name = "boleto_id"))
    private Set<BoletoEntity> boletos = new HashSet<>();

}
