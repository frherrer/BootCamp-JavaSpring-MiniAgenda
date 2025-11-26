package com.skillnest.service;

import com.skillnest.model.Evento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class AgendaServiceTest {

    @Autowired
    private AgendaService agendaService;

    @BeforeEach
    public void setup() {
   
    }

    @Test
    public void testAgregarYListarEventos() {
        Evento e = new Evento("Cumple Juan", LocalDate.of(2025, 11, 20), "Torta en la oficina", "Juan");
        agendaService.agregarEvento(e);
        List<Evento> lista = agendaService.listarEventos();
        Assertions.assertTrue(lista.stream().anyMatch(ev -> ev.getTitulo().equals("Cumple Juan")));
    }

    @Test
    public void testRecuperarPorFecha() {
        LocalDate fecha = LocalDate.of(2025, 11, 21);
        Evento e1 = new Evento("Junta Ventas", fecha, "Revisión trimestral", "María");
        agendaService.agregarEvento(e1);
        List<Evento> porFecha = agendaService.listarEventosPorFecha(fecha);
        Assertions.assertFalse(porFecha.isEmpty());
        Assertions.assertEquals("Junta Ventas", porFecha.get(0).getTitulo());
    }
}
