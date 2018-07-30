package edu.uacm.mx;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the autor database table.
 * 
 */
@Entity
@Table(name="autor")
@NamedQuery(name="Autor.findAll", query="SELECT a FROM Autor a")
public class Autor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private String id;

	@Column(name="anio_nac")
	private short anioNac;

	@Column(length=100)
	private String nacionalidad;

	@Column(length=200)
	private String nombre;

	//bi-directional many-to-many association to Libro
	@ManyToMany
	@JoinTable(
		name="autor_libro"
		, joinColumns={
			@JoinColumn(name="id_autor", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_libro", nullable=false)
			}
		)
	private List<Libro> libros;

	public Autor() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public short getAnioNac() {
		return this.anioNac;
	}

	public void setAnioNac(short anioNac) {
		this.anioNac = anioNac;
	}

	public String getNacionalidad() {
		return this.nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Libro> getLibros() {
		return this.libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

}