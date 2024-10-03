package com.calcula.weed.demo.services;


import com.calcula.weed.demo.entities.CalculoAtividade;
import com.calcula.weed.demo.repositories.CalculoAtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalTime;

@Service
public class CalculoAtividadeService {

    @Autowired
    private CalculoAtividadeRepository calculoAtividadeRepository;

    public BigDecimal calcularValorRecebido(double salarioBruto, LocalTime horaInicio, LocalTime horaFim){

        Duration duracao = Duration.between(horaInicio, horaFim);
        double horasTrabalhadas = duracao.toMinutes() / 60.0;
        double valorPorHora = salarioBruto / 160;
        double valorRecebido = valorPorHora * horasTrabalhadas;

        BigDecimal valorArredondado = new BigDecimal(valorRecebido).setScale(2, RoundingMode.HALF_UP);

        CalculoAtividade calculoAtividade = new CalculoAtividade(salarioBruto, horaInicio, horaFim, valorRecebido);
        return valorArredondado;

    }
}
