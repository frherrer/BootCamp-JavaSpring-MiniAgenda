package com.skillnest.service;

import com.skillnest.model.Evento;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface AgendaService {
	void agregarEvento(Evento evento);

	List<Evento> listarEventos();

	List<Evento> listarEventosPorFecha(LocalDate fecha);

	Map<LocalDate, List<Evento>> eventosAgrupadosPorDia();
}
