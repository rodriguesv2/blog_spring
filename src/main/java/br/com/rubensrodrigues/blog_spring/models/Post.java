package br.com.rubensrodrigues.blog_spring.models;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@DateTimeFormat
	private Calendar dataCriacao;
	private String titulo;
	@Type(type="text")
	private String texto;
	@DateTimeFormat
	private Calendar dataModificacao;
	private Categoria categoria;
	/*
	 * @OneToMany private Usuario usuario;
	 */
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Calendar getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Calendar getDataModificacao() {
		return dataModificacao;
	}
	public void setDataModificacao(Calendar dataModificacao) {
		this.dataModificacao = dataModificacao;
	}	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	//Resumo da descrição para a lista da home
	public String getAmostraTexto() {
		if(texto.length() > 350)
			return texto.substring(0, 350)+"[...]";
		return texto;
	}
}
