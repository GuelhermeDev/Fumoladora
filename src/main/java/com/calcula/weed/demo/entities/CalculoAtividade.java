package com.calcula.weed.demo.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;



@Entity
@Table(name = "calculos_atividade")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CalculoAtividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "salario_bruto")
    private double salarioBruto;

    @Column(name = "hora_inicio")
    private LocalTime horaInicio;

    @Column(name = "hora_fim")
    private LocalTime horaFim;

    @Column(name = "valor_recebido")
    private double valorRecebido;

    public CalculoAtividade(double salarioBruto, LocalTime horaInicio, LocalTime horaFim, double valorRecebido) {
        this.salarioBruto = salarioBruto;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.valorRecebido = valorRecebido;
    }
}
