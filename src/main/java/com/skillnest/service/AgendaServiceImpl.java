package com.skillnest.service;

import org.springframework.stereotype.Service;
import com.skillnest.model.Evento;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AgendaServiceImpl implements AgendaService {

	// Simula base de datos en memoria 
	private final List<Evento> eventos = new ArrayList<>();

	@Override
	public void agregarEvento(Evento evento) {
		eventos.add(evento);
	}

	@Override
	public List<Evento> listarEventos() {
		return new ArrayList<>(eventos);
	}

	@Override
	public List<Evento> listarEventosPorFecha(LocalDate fecha) {
		return eventos.stream().filter(e -> fecha.equals(e.getFecha())).collect(Collectors.toList());
	}

	@Override
	public Map<LocalDate, List<Evento>> eventosAgrupadosPorDia() {
		return eventos.stream().collect(Collectors.groupingBy(Evento::getFecha));
	}
}
