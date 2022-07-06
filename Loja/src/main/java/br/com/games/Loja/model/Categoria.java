package br.com.games.Loja.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {

	@Id
	private String categoria;
	
	private String genero;
	
	private String generosecundario;

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getGenerosecundario() {
		return generosecundario;
	}

	public void setGenerosecundario(String generosecundario) {
		this.generosecundario = generosecundario;
	}
}
