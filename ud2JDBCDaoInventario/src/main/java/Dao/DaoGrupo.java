package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Pojos.Grupo;
import dao.DaoGenerico;
import excepciones.BusinessException;
import jdbc.ConexionJdbc;

public class DaoGrupo extends DaoGenerico<Grupo, Integer> {
	PreparedStatement pstm = null;
	String sql;
	ResultSet rs;
	Integer id = 0;
	Connection con = ConexionJdbc.getConnection();
    @Override
    public void grabar(Grupo grupo) throws BusinessException {
        try {
            String sql = "INSERT INTO GRUPO VALUES(?,?)";
            pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, grupo.getIdgrupo());
            pstm.setString(2, grupo.getNombre());
            pstm.executeUpdate();
            rs = pstm.getGeneratedKeys();

            if (rs.first()) {    
                System.out.println(grupo.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new BusinessException("Error al insertar el grupo");
        } finally {
            ConexionJdbc.cerrar(pstm);
            ConexionJdbc.cerrar(rs);
        }
    }

    @Override
    public void actualizar(Grupo grupo) throws BusinessException {
        try {
            String sql = "UPDATE grupo SET nombre=? WHERE idgrupo=?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, grupo.getNombre());
            pstm.setString(2, grupo.getIdgrupo());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new BusinessException("Error al actualizar el grupo");
        } finally {
            ConexionJdbc.cerrar(pstm);
        }
    }
    public void borrar(String id) throws BusinessException{
    	try {
			sql = "DELETE FROM grupo WHERE idgrupo=?";
			pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstm.setString(1, id);
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
    public void borrar(Grupo grupo) throws BusinessException {
        borrar(grupo.getIdgrupo());
    }

    @Override
    public List<Grupo> buscarTodos() throws BusinessException {
        List<Grupo> grupos = new ArrayList<Grupo>();
        try {
            String sql = "SELECT * FROM grupo";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Grupo grupo = new Grupo();
                grupo.setIdgrupo(rs.getString(1));
                grupo.setNombre(rs.getString(2));
                grupos.add(grupo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new BusinessException("Error al buscar todos los grupos");
        } finally {
            ConexionJdbc.cerrar(pstm);
            ConexionJdbc.cerrar(rs);
        }
        return grupos;
    }

    @Override
    public Grupo buscarPorId(Integer id) throws BusinessException {
        Grupo result = new Grupo();
        try {
            String sql = "SELECT * FROM grupo WHERE idgrupo=?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            if (rs.first()) {
                result.setIdgrupo(rs.getString(1));
                result.setNombre(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new BusinessException("Error al buscar el grupo por ID");
        } finally {
            ConexionJdbc.cerrar(pstm);
            ConexionJdbc.cerrar(rs);
        }
        return result;
    }
}
