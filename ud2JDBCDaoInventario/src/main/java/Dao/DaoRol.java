package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Pojos.Departamento;
import Pojos.Rol;
import dao.DaoGenerico;
import excepciones.BusinessException;
import jdbc.ConexionJdbc;

public class DaoRol extends DaoGenerico<Rol, Integer>{
	PreparedStatement pstm = null;
	String sql;
	ResultSet rs;
	Integer id = 0;
	Connection con = ConexionJdbc.getConnection();
	
	@Override
	public void grabar(Rol r) throws BusinessException {

		try {
			// sentencia sql con la operacion de control insertar
			sql = "INSERT INTO ROL (nombre, descripcion) VALUES(?, ?)";
			// Configuro el PreparedStatement para retornar el id (key)
			// autonumerico generado, en este caso el id del departamento
			pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstm.setString(1, r.getNombre());
			pstm.setString(2, r.getDescripcion());
			pstm.executeUpdate();
			rs = pstm.getGeneratedKeys();

			if (rs.first()) {
				id = rs.getInt(1);
				r.setIdrol(id);
				System.out.println(r.toString());
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
			sql = "DELETE FROM rol WHERE idrol=?";
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
	public Rol buscarPorId(Integer id) throws BusinessException {
		Rol result = new Rol();
		try {
			sql = "SELECT * FROM rol WHERE idrol=?";
			pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();

			if (rs.first()) {
				result.setIdrol(rs.getInt(1));
				result.setNombre(rs.getString(2));
				result.setDescripcion(rs.getString(3));
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
	public Rol buscarPorNombre(String n) throws BusinessException {
		Rol result = new Rol();
		try {
			sql = "SELECT * FROM rol WHERE nombre like ?";
			pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstm.setString(1, "%" + n + "%");
			rs = pstm.executeQuery();

			if (rs.first()) {
				result.setIdrol(rs.getInt(1));
				result.setNombre(rs.getString(2));
				result.setDescripcion(rs.getString(3));
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
    public void actualizar(Rol r) throws BusinessException {
        try {
            sql = "UPDATE rol SET nombre=?, descripcion=? WHERE iddepartamento=?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, r.getNombre());
            pstm.setString(2, r.getDescripcion());
            pstm.setInt(3, r.getIdrol());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new BusinessException("Error al actualizar");
        } finally {
            ConexionJdbc.cerrar(pstm);
        }
    }

    @Override
    public void borrar(Rol d) throws BusinessException {
        borrar(d.getIdrol());
    }

    @Override
    public List<Rol> buscarTodos() throws BusinessException {
        List<Rol> roles = new ArrayList<Rol>();
        try {
            sql = "SELECT * FROM rol";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Rol rol = new Rol();
                rol.setIdrol(rs.getInt(1));
                rol.setNombre(rs.getString(2));
                rol.setDescripcion(rs.getString(3));
                roles.add(rol);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new BusinessException("Error al buscar todos los departamentos");
        } finally {
            ConexionJdbc.cerrar(pstm);
            ConexionJdbc.cerrar(rs);
        }
        return roles;
    }

    @Override
    public void grabarOActualizar(Rol r) throws BusinessException {
        if (r.getIdrol() != null && buscarPorId(r.getIdrol()) != null) {
            actualizar(r);
        } else {
            grabar(r);
        }
    }
}
