package Pojos;

public class TipoUsuario {
	private Integer idtipousuario;
	private String nombre;

	public TipoUsuario(Integer idtipousuario, String nombre) {
		super();
		this.idtipousuario = idtipousuario;
		this.nombre = nombre;
	}

	public TipoUsuario() {
	}

	public Integer getIdtipousuario() {
		return idtipousuario;
	}

	public void setIdtipousuario(Integer idtipousuario) {
		this.idtipousuario = idtipousuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "TipoUsuario [idtipousuario=" + idtipousuario + ", nombre=" + nombre + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idtipousuario == null) ? 0 : idtipousuario.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		TipoUsuario other = (TipoUsuario) obj;
		if (idtipousuario == null) {
			if (other.idtipousuario != null)
				return false;
		} else if (!idtipousuario.equals(other.idtipousuario))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	public int compareTo(Object obj) {
		TipoUsuario other = (TipoUsuario) obj;
		return idtipousuario.compareTo(other.idtipousuario);
	}
}
