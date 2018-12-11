package com.test.data;

import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * Test data bean
 */
@Entity
@Cache
@ApiModel("Test object")
public class LibroBean {

    @Id
    @ApiModelProperty(required = true)
    private Long id;

    @ApiModelProperty(required = true)
    private String nombre;

    @ApiModelProperty(required = true)
    @Index
    private String autor;

    @ApiModelProperty(required = true)
    private Integer anio;

    @ApiModelProperty(required = true)
    private String genero;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", autor=" + autor + ", anio=" + anio + ", genero="
				+ genero + "]";
	}
	
	public String toSearch() {
		return id +"|"+ nombre +"|"+ autor +"|"+ anio +"|"+ genero;
	}

}
