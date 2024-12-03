package Pojos;

import java.time.LocalDateTime;

public class Salida {
	private Integer idSalida;
	private Integer usuario;
	private Integer articulo;
	private LocalDateTime fechaSalida;
	private LocalDateTime fechaDevolucion;

	public Salida() {
	}

	/* LOCAL DATETIME */
	public Salida(Integer idSalida, Integer idUsuario, Integer idArticulo, LocalDateTime fechaSalida,
			LocalDateTime fechaDevolucion) {
		this.idSalida = idSalida;
		this.usuario = idUsuario;
		this.articulo = idArticulo;
		this.fechaSalida = fechaSalida;
		this.fechaDevolucion = fechaDevolucion;
	}

	public Integer getIdSalida() {
		return idSalida;
	}

	public void setIdSalida(Integer idSalida) {
		this.idSalida = idSalida;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer idUsuario) {
		this.usuario = idUsuario;
	}

	public Integer getArticulo() {
		return articulo;
	}

	public void setArticulo(Integer idArticulo) {
		this.articulo = idArticulo;
	}

	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public LocalDateTime getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(LocalDateTime fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idSalida == null) ? 0 : idSalida.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salida other = (Salida) obj;
		if (idSalida == null) {
			if (other.idSalida != null)
				return false;
		} else if (!idSalida.equals(other.idSalida))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Salida [idSalida=" + idSalida + ", idUsuario=" + usuario + ", idArticulo=" + articulo + ", fechaSalida="
				+ fechaSalida + ", fechaDevolucion=" + fechaDevolucion + "]";
	}

}