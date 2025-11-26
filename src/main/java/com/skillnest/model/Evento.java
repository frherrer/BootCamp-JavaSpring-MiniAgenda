package com.skillnest.model;

import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Evento {

	@NotBlank(message = "Título es obligatorio")
	private String titulo;

	@NotNull(message = "Fecha es obligatoria")
	private LocalDate fecha;

	private String descripcion;

	@NotBlank(message = "Responsable es obligatorio")
	private String responsable;

	public Evento() {
	}

	public Evento(String titulo, LocalDate fecha, String descripcion, String responsable) {
		this.titulo = titulo;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.responsable = responsable;
	}

	// getters y setters
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
}
