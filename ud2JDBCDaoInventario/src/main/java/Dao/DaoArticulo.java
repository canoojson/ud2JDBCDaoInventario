package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import Pojos.Articulo;
import dao.DaoGenerico;
import excepciones.BusinessException;
import jdbc.ConexionJdbc;

public class DaoArticulo extends DaoGenerico<Articulo, Integer> {
	PreparedStatement pstm = null;
	String sql;
	ResultSet rs;
	Integer id = 0;
	Connection con = ConexionJdbc.getConnection();

	public Articulo buscarPorNum(Integer id) throws BusinessException {
		Articulo a = null;
		try {
			sql = "SELECT * FROM articulo WHERE numserie=?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if (rs.first()) {
				a = new Articulo();

				a.setIdarticulo(rs.getInt("idarticulo"));
				a.setNumserie(rs.getString("numserie"));
				a.setEstado(rs.getString("estado"));
				a.setFechaalta(rs.getDate("fechaalta"));
				a.setFechabaja(rs.getDate("fechabaja"));
				a.setUsuarioalta(rs.getInt("usuarioalta"));
				a.setUsuariobaja(rs.getInt("usuariobaja"));
				a.setModelo(rs.getInt("modelo"));
				a.setDepartamento(rs.getInt("departamento"));
				a.setEspacio(rs.getInt("espacio"));
				a.setDentrode(rs.getInt("dentrode"));
				a.setObservaciones(rs.getString("observaciones"));
			}
			return a;
		} catch (SQLException e) {
			throw new BusinessException("Error al consultar");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}

	@Override
	public void actualizar(Articulo a) throws BusinessException {
		try {
			// Preparar la actualizaci�n.
			sql = "UPDATE articulo " + " SET numserie= ?, estado = ?, fechaalta= ?, fechabaja= ?,"
					+ " usuarioalta = ?, usuariobaja = ?, modelo = ?, departamento = ?, espacio = ?,"
					+ "dentrode = ?, observaciones = ?" + " WHERE idarticulo = ?";

			pstm = con.prepareStatement(sql);
			pstm.setString(1, a.getNumserie());
			pstm.setString(2, a.getEstado());
			pstm.setDate(3, new java.sql.Date(a.getFechaalta().getTime()));
			pstm.setDate(4, new java.sql.Date(a.getFechabaja().getTime()));
			pstm.setInt(5, a.getUsuarioalta());
			pstm.setInt(6, 481);
			pstm.setInt(7, a.getModelo());
			pstm.setInt(8, a.getDepartamento());
			pstm.setInt(9, a.getEspacio());
			pstm.setInt(10, a.getDentrode());
			pstm.setString(11, a.getObservaciones());
			pstm.setInt(12, a.getIdarticulo());

			// Ejecutar la actualizacion
			pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al actualizar");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}

	public void actualizarEstado(Date fechabaja, int usuariobaja, String estado, int idarticulo) throws BusinessException {
		try {
			sql = "UPDATE articulo SET fechabaja=?, usuariobaja = ?, estado = ? WHERE idarticulo = ?";
			
			pstm = con.prepareStatement(sql);
			pstm.setDate(1, fechabaja);
			pstm.setInt(2, usuariobaja);
			pstm.setString(3, estado);
			pstm.setInt(4, idarticulo);
			
			pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al actualizar");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}

	/*
	 * @Override public void grabarOActualizar(Articulo a) throws BusinessException
	 * { if(buscarPorId(a.getIdArticulo())!=null) grabar(a); else actualizar(a); }
	 */

	@Override
	public void borrar(Articulo a) throws BusinessException {
		borrar(a.getIdarticulo());
	}

	@Override
	public void borrar(Integer id) throws BusinessException {
		try {
			sql = "DELETE FROM articulo WHERE idarticulo= ?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.executeUpdate();
		} catch (SQLException e) {
			throw new BusinessException("Error al eliminar");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}

	@Override
	public Articulo buscarPorId(Integer id) throws BusinessException {
		Articulo a = null;
		try {
			sql = "SELECT * FROM articulo WHERE idarticulo=?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if (rs.first()) {
				a = new Articulo();

				a.setIdarticulo(rs.getInt("idarticulo"));
				a.setNumserie(rs.getString("numserie"));
				a.setEstado(rs.getString("estado"));
				a.setFechaalta(rs.getDate("fechaalta"));
				a.setFechabaja(rs.getDate("fechabaja"));
				a.setUsuarioalta(rs.getInt("usuarioalta"));
				a.setUsuariobaja(rs.getInt("usuariobaja"));
				a.setModelo(rs.getInt("modelo"));
				a.setDepartamento(rs.getInt("departamento"));
				a.setEspacio(rs.getInt("espacio"));
				a.setDentrode(rs.getInt("dentrode"));
				a.setObservaciones(rs.getString("observaciones"));
			}
			return a;
		} catch (SQLException e) {
			throw new BusinessException("Error al consultar");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}

	@Override
	public List<Articulo> buscarTodos() throws BusinessException {
		List<Articulo> result = new ArrayList<Articulo>();
		try {
			sql = "SELECT * FROM articulo ORDER BY idarticulo";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Articulo a = new Articulo();

				a.setIdarticulo(rs.getInt("idarticulo"));
				a.setNumserie(rs.getString("numserie"));
				a.setEstado(rs.getString("estado"));
				a.setFechaalta(rs.getDate("fechaalta"));
				a.setFechabaja(rs.getDate("fechabaja"));
				a.setUsuarioalta(rs.getInt("usuarioalta"));
				a.setUsuariobaja(rs.getInt("usuariobaja"));
				a.setModelo(rs.getInt("modelo"));
				a.setDepartamento(rs.getInt("departamento"));
				a.setEspacio(rs.getInt("espacio"));
				// a.setDentrode(rs.getInt("dentrode"));
				a.setObservaciones(rs.getString("observaciones"));

				result.add(a);
			}
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al consultar");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}

	public Articulo buscarUltimo() throws BusinessException {
		Articulo a = new Articulo();
		try {
			sql = "SELECT * FROM articulo ORDER BY idarticulo DESC LIMIT 1";
			pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstm.executeUpdate();
			rs = pstm.getGeneratedKeys();

			if (rs.next()) {
				a.setIdarticulo(rs.getInt(1));
				a.setNumserie(rs.getString(2));
				a.setEstado(rs.getString(3));
				a.setFechaalta(rs.getDate(4));
				a.setFechabaja(rs.getDate(5));
				a.setUsuarioalta(rs.getInt(6));
				a.setUsuariobaja(rs.getInt(7));
				a.setModelo(rs.getInt(8));
				a.setDepartamento(rs.getInt(9));
				a.setEspacio(rs.getInt(10));
				a.setDentrode(rs.getInt(11));
				a.setObservaciones(rs.getString(12));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al insertar");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConexionJdbc.cerrar(pstm);
			ConexionJdbc.cerrar(rs);
		}
		return a;
	}

}