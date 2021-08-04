package com.kevinsoto.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import javax.validation.constraints.Digits;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;


@Entity
@Table(name="Vacantes")
public class Vacante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	//@NotEmpty(message="Proporcione la vacante")
	//@Pattern(regexp = "[A-Za-z]+[\\s]+[A-Za-z]+",message="Proporcione la vacante")
	private String nombre;
	private String descripcion;
	//@NotNull(message="Proporcione una cantidad para el salario")
	//@Min(value=1,message="El valor minimo es 1 peso")
	//@Digits(integer=6, fraction=2, message="Verificar la cantidad")
	private Double salario;
	private LocalDate fecha = LocalDate.now();
	private Integer destacado;
	private String estatus;
	private String imagen="error.png";
	private String detalles;
	//@Transient
	@OneToOne
	@JoinColumn(name="idCategoria")
	private Categoria categoria;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	
	public Integer getDestacado() {
		return destacado;
	}
	public void setDestacado(Integer destacado) {
		this.destacado = destacado;
	}
	
	
	
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
	public String getDetalles() {
		return detalles;
	}
	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
	
	
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	@Override
	public String toString() {
		return "Vacante [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", salario=" + salario
				+ ", fecha=" + fecha + ", destacado=" + destacado + ", estatus=" + estatus + ", imagen=" + imagen
				+ ", detalles=" + detalles + ", categoria=" + categoria + "]";
	}
	
	
	
}
