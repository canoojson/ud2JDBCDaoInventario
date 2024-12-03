package Pojos;

import java.sql.Date;

public class Articulo {
	private Integer idarticulo;
	private String numserie;
	private String estado;
	private Date fechaalta;
	private Date fechabaja;
	private Integer usuarioalta;
	private Integer usuariobaja;
	private Integer modelo;
	private Integer departamento;
	private Integer espacio;
	private Integer dentrode;
	private String observaciones;
	
	public Articulo(Integer idarticulo, String numserie, String estado, Date fechaalta, Date fechabaja,
			Integer usuarioalta, Integer usuariobaja, Integer modelo, Integer departamento, Integer espacio,
			Integer dentrode, String observaciones) {
		super();
		this.idarticulo = idarticulo;
		this.numserie = numserie;
		this.estado = estado;
		this.fechaalta = fechaalta;
		this.fechabaja = fechabaja;
		this.usuarioalta = usuarioalta;
		this.usuariobaja = usuariobaja;
		this.modelo = modelo;
		this.departamento = departamento;
		this.espacio = espacio;
		this.dentrode = dentrode;
		this.observaciones = observaciones;
	}
	
	public Articulo() {
		super();
	}

	public Integer getIdarticulo() {
		return idarticulo;
	}
	public void setIdarticulo(Integer idarticulo) {
		this.idarticulo = idarticulo;
	}
	public String getNumserie() {
		return numserie;
	}
	public void setNumserie(String numserie) {
		this.numserie = numserie;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFechaalta() {
		return fechaalta;
	}
	public void setFechaalta(Date fechaalta) {
		this.fechaalta = fechaalta;
	}
	public Date getFechabaja() {
		return fechabaja;
	}
	public void setFechabaja(Date fechabaja) {
		this.fechabaja = fechabaja;
	}
	public Integer getUsuarioalta() {
		return usuarioalta;
	}
	public void setUsuarioalta(Integer usuarioalta) {
		this.usuarioalta = usuarioalta;
	}
	public Integer getUsuariobaja() {
		return usuariobaja;
	}
	public void setUsuariobaja(Integer usuariobaja) {
		this.usuariobaja = usuariobaja;
	}
	public Integer getModelo() {
		return modelo;
	}
	public void setModelo(Integer modelo) {
		this.modelo = modelo;
	}
	public Integer getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Integer departamento) {
		this.departamento = departamento;
	}
	public Integer getEspacio() {
		return espacio;
	}
	public void setEspacio(Integer espacio) {
		this.espacio = espacio;
	}
	public Integer getDentrode() {
		return dentrode;
	}
	public void setDentrode(Integer dentrode) {
		this.dentrode = dentrode;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dentrode == null) ? 0 : dentrode.hashCode());
		result = prime * result + ((departamento == null) ? 0 : departamento.hashCode());
		result = prime * result + ((espacio == null) ? 0 : espacio.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((fechaalta == null) ? 0 : fechaalta.hashCode());
		result = prime * result + ((fechabaja == null) ? 0 : fechabaja.hashCode());
		result = prime * result + ((idarticulo == null) ? 0 : idarticulo.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((numserie == null) ? 0 : numserie.hashCode());
		result = prime * result + ((observaciones == null) ? 0 : observaciones.hashCode());
		result = prime * result + ((usuarioalta == null) ? 0 : usuarioalta.hashCode());
		result = prime * result + ((usuariobaja == null) ? 0 : usuariobaja.hashCode());
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
		Articulo other = (Articulo) obj;
		if (dentrode == null) {
			if (other.dentrode != null)
				return false;
		} else if (!dentrode.equals(other.dentrode))
			return false;
		if (departamento == null) {
			if (other.departamento != null)
				return false;
		} else if (!departamento.equals(other.departamento))
			return false;
		if (espacio == null) {
			if (other.espacio != null)
				return false;
		} else if (!espacio.equals(other.espacio))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (fechaalta == null) {
			if (other.fechaalta != null)
				return false;
		} else if (!fechaalta.equals(other.fechaalta))
			return false;
		if (fechabaja == null) {
			if (other.fechabaja != null)
				return false;
		} else if (!fechabaja.equals(other.fechabaja))
			return false;
		if (idarticulo == null) {
			if (other.idarticulo != null)
				return false;
		} else if (!idarticulo.equals(other.idarticulo))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (numserie == null) {
			if (other.numserie != null)
				return false;
		} else if (!numserie.equals(other.numserie))
			return false;
		if (observaciones == null) {
			if (other.observaciones != null)
				return false;
		} else if (!observaciones.equals(other.observaciones))
			return false;
		if (usuarioalta == null) {
			if (other.usuarioalta != null)
				return false;
		} else if (!usuarioalta.equals(other.usuarioalta))
			return false;
		if (usuariobaja == null) {
			if (other.usuariobaja != null)
				return false;
		} else if (!usuariobaja.equals(other.usuariobaja))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Articulo [idarticulo=" + idarticulo + ", numserie=" + numserie + ", estado=" + estado + ", fechaalta="
				+ fechaalta + ", fechabaja=" + fechabaja + ", usuarioalta=" + usuarioalta + ", usuariobaja="
				+ usuariobaja + ", modelo=" + modelo + ", departamento=" + departamento + ", espacio=" + espacio
				+ ", dentrode=" + dentrode + ", observaciones=" + observaciones + "]";
	}
	
	
}
