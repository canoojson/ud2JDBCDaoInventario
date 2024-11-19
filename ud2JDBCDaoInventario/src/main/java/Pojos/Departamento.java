package Pojos;

public class Departamento {
	private Integer iddepartamento;
	private String nombre;
 	public Departamento() {}
	
	public Departamento(Integer id, String nombre) {
		this.iddepartamento=id;
		this.nombre=nombre;
			}

	public Integer getIddepartamento() {
		return iddepartamento;
	}

	public void setIddepartamento(Integer iddepartamento) {
		this.iddepartamento = iddepartamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iddepartamento == null) ? 0 : iddepartamento.hashCode());
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
		Departamento other = (Departamento) obj;
		if (iddepartamento == null) {
			if (other.iddepartamento != null)
				return false;
		} else if (!iddepartamento.equals(other.iddepartamento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Departamento [iddepartamento=" + iddepartamento + ", nombre=" + nombre + "]";
	}
	
	public int compareTo(Object obj) {
		Departamento other=(Departamento)obj;
		return iddepartamento.compareTo(other.iddepartamento);
	}

	
		
}
	
	

	
