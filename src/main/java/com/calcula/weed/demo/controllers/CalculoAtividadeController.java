package com.calcula.weed.demo.controllers;


import com.calcula.weed.demo.services.CalculoAtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalTime;

@Controller
public class CalculoAtividadeController {

    @Autowired
    private CalculoAtividadeService calculoAtividadeService;



    @GetMapping("/")
    public String index() {
        return "index";
    }


    @PostMapping("/calcular")
    public String calcularValor(@RequestParam("salarioBruto") double salarioBruto,
                                @RequestParam("horaInicio") String horaInicio,
                                @RequestParam("horaFim") String horaFim,
                                Model model) {
        LocalTime inicio = LocalTime.parse(horaInicio);
        LocalTime fim = LocalTime.parse(horaFim);


        BigDecimal calculoAtividade = calculoAtividadeService.calcularValorRecebido(salarioBruto, inicio, fim);


        model.addAttribute("valorRecebido", calculoAtividade);
        return "index";
    }
}