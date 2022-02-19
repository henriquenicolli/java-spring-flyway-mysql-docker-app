package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Comparator;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_boleto")
public class BoletoEntity implements Comparable<BoletoEntity> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "boleto_id")
    private Long boletoId;

    @Column(name = "valor")
    private BigDecimal valor;


    @Override
    public int compareTo(BoletoEntity o) {
        return valor.compareTo(o.getValor());
    }
}
