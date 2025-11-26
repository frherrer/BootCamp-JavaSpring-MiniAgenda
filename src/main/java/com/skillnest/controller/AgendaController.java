package com.skillnest.controller;

import com.skillnest.model.Evento;
import com.skillnest.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;

@Controller
public class AgendaController {

	@Autowired
	private AgendaService agendaService;

	// Mostrar formulario (GET)
	@GetMapping({ "/", "/evento/form" })
	public String mostrarFormulario(Model model) {
		model.addAttribute("evento", new Evento());
		return "evento_form";
	}

	// Recibir y validar formulario (POST)
	@PostMapping("/evento/guardar")
	public String guardarEvento(@Valid @ModelAttribute("evento") Evento evento, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			return "evento_form";
		}
		agendaService.agregarEvento(evento);
		return "redirect:/eventos";
	}

	// Mostrar eventos agrupados por día (GET)
	@GetMapping("/eventos")
	public String mostrarEventos(Model model) {
		Map<LocalDate, List<Evento>> agrupados = agendaService.eventosAgrupadosPorDia();
		model.addAttribute("agrupados", agrupados);
		return "eventos_por_dia";
	}

	// Buscar por fecha
	@GetMapping("/eventos/buscar")
	public String buscarPorFecha(@RequestParam("fecha") String fechaStr, Model model) {
		try {
			LocalDate fecha = LocalDate.parse(fechaStr);
			List<Evento> lista = agendaService.listarEventosPorFecha(fecha);
			model.addAttribute("resultados", lista);
		} catch (DateTimeParseException ex) {
			model.addAttribute("error", "Formato de fecha no válido. Use YYYY-MM-DD");
		}
	
		return "eventos_por_dia";
	}
}
