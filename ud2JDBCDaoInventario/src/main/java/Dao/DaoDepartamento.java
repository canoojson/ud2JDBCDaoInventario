package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Pojos.Departamento;
import dao.DaoGenerico;
import excepciones.BusinessException;
import jdbc.ConexionJdbc;

public class DaoDepartamento extends DaoGenerico<Departamento, Integer> {
	PreparedStatement pstm = null;
	String sql;
	ResultSet rs;
	Integer id = 0;
	Connection con = ConexionJdbc.getConnection();

	@Override
	public void grabar(Departamento d) throws BusinessException {

		try {
			// sentencia sql con la operacion de control insertar
			sql = "INSERT INTO DEPARTAMENTO (nombre) VALUES(?)";
			// Configuro el PreparedStatement para retornar el id (key)
			// autonumerico generado, en este caso el id del departamento
			pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstm.setString(1, d.getNombre());
			pstm.executeUpdate();
			rs = pstm.getGeneratedKeys();

			if (rs.first()) {
				id = rs.getInt(1);
				d.setIddepartamento(id);
				System.out.println(d.toString());
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
	}

	@Override
	public void borrar(Integer id) throws BusinessException {
		try {
			sql = "DELETE FROM departamento WHERE iddepartamento=?";
			pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstm.setInt(1, id);
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new BusinessException("Error al borrar");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}

	@Override
	public Departamento buscarPorId(Integer id) throws BusinessException {
		Departamento result = new Departamento();
		try {
			sql = "SELECT * FROM departamento WHERE iddepartamento=?";
			pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();

			if (rs.first()) {
				
				result.setIddepartamento(rs.getInt(1));
				result.setNombre(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {
			ConexionJdbc.cerrar(pstm);
			ConexionJdbc.cerrar(rs);
		}
		return result;
	}
	public Departamento buscarPorNombre(String n) throws BusinessException {
		Departamento result = new Departamento();
		try {
			sql = "SELECT * FROM departamento WHERE nombre like ?";
			pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstm.setString(1, "%" + n + "%");
			rs = pstm.executeQuery();

			if (rs.first()) {
				result.setIddepartamento(rs.getInt(1));
				result.setNombre(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {
			ConexionJdbc.cerrar(pstm);
			ConexionJdbc.cerrar(rs);
		}
		return result;
	}
	 @Override
	    public void actualizar(Departamento d) throws BusinessException {
	        try {
	            sql = "UPDATE departamento SET nombre=? WHERE iddepartamento=?";
	            pstm = con.prepareStatement(sql);
	            pstm.setString(1, d.getNombre());
	            pstm.setInt(2, d.getIddepartamento());
	            pstm.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new BusinessException("Error al actualizar");
	        } finally {
	            ConexionJdbc.cerrar(pstm);
	        }
	    }

	    @Override
	    public void borrar(Departamento d) throws BusinessException {
	        borrar(d.getIddepartamento());
	    }

	    @Override
	    public List<Departamento> buscarTodos() throws BusinessException {
	        List<Departamento> departamentos = new ArrayList<Departamento>();
	        try {
	            sql = "SELECT * FROM departamento";
	            pstm = con.prepareStatement(sql);
	            rs = pstm.executeQuery();

	            while (rs.next()) {
	                Departamento departamento = new Departamento();
	                departamento.setIddepartamento(rs.getInt(1));
	                departamento.setNombre(rs.getString(2));
	                departamentos.add(departamento);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new BusinessException("Error al buscar todos los departamentos");
	        } finally {
	            ConexionJdbc.cerrar(pstm);
	            ConexionJdbc.cerrar(rs);
	        }
	        return departamentos;
	    }

	    @Override
	    public void grabarOActualizar(Departamento d) throws BusinessException {
	        if (d.getIddepartamento() != null && buscarPorId(d.getIddepartamento()) != null) {
	            actualizar(d);
	        } else {
	            grabar(d);
	        }
	    }
}
