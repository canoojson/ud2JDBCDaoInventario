package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Pojos.Usuario;
import dao.DaoGenerico;
import excepciones.BusinessException;
import jdbc.ConexionJdbc;

public class DaoUsuario extends DaoGenerico<Usuario, Integer> {
	PreparedStatement pstm = null;
	String sql;
	ResultSet rs;
	Integer id = 0;
	Connection con = ConexionJdbc.getConnection();

	@Override
	public void grabar(Usuario usuario) throws BusinessException {
		try {
			String sql = "INSERT INTO USUARIO (username, password, tipo, rol, grupo, departamento, nombre, apellido1, apellido2, domicilio, poblacion, codpostal, email, telefono) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstm.setString(1, usuario.getUsername());
			pstm.setString(2, usuario.getPassword());
			pstm.setInt(3, usuario.getTipo());
			pstm.setInt(4, usuario.getRol());
			pstm.setString(5, usuario.getGrupo());
			pstm.setInt(6, usuario.getDepartamento());
			pstm.setString(7, usuario.getNombre());
			pstm.setString(8, usuario.getApellido1());
			pstm.setString(9, usuario.getApellido2());
			pstm.setString(10, usuario.getDomicilio());
			pstm.setString(11, usuario.getPoblacion());
			pstm.setString(12, usuario.getCodpostal());
			pstm.setString(13, usuario.getEmail());
			pstm.setString(14, usuario.getTelefono());

			pstm.executeUpdate();
			rs = pstm.getGeneratedKeys();

			if (rs.first()) {
				int id = rs.getInt(1);
				usuario.setIdusuario(id);
				System.out.println(usuario.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al insertar el usuario");
		} finally {
			ConexionJdbc.cerrar(pstm);
			ConexionJdbc.cerrar(rs);
		}
	}

	@Override
	public void actualizar(Usuario usuario) throws BusinessException {
		try {
			String sql = "UPDATE usuario SET username=?, password=?, tipo=?, rol=?, grupo=?, departamento=?, nombre=?, "
					+ "apellido1=?, apellido2=?, domicilio=?, poblacion=?, codpostal=?, email=?, telefono=? WHERE idusuario=?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, usuario.getUsername());
			pstm.setString(2, usuario.getPassword());
			pstm.setInt(3, usuario.getTipo());
			pstm.setInt(4, usuario.getRol());
			pstm.setString(5, usuario.getGrupo());
			pstm.setInt(6, usuario.getDepartamento());
			pstm.setString(7, usuario.getNombre());
			pstm.setString(8, usuario.getApellido1());
			pstm.setString(9, usuario.getApellido2());
			pstm.setString(10, usuario.getDomicilio());
			pstm.setString(11, usuario.getPoblacion());
			pstm.setString(12, usuario.getCodpostal());
			pstm.setString(13, usuario.getEmail());
			pstm.setString(14, usuario.getTelefono());
			pstm.setInt(15, usuario.getIdusuario());

			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al actualizar el usuario");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}
	public void actualizarDep(int iddeptAntg, int iddeptNew)throws BusinessException {
		try {
			String sql = "UPDATE usuario SET departamento=?  WHERE departamento=?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, iddeptNew );
			pstm.setInt(2, iddeptAntg);
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al actualizar el usuario");
		} finally {
			ConexionJdbc.cerrar(pstm);
		}
	}
	public void borrar(Integer id)throws BusinessException{
		try {
			sql = "DELETE FROM usuario WHERE idusuario=?";
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
	public void borrar(Usuario usuario) throws BusinessException {
		borrar(usuario.getIdusuario());
	}

	@Override
	public List<Usuario> buscarTodos() throws BusinessException {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			String sql = "SELECT * FROM usuario";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setIdusuario(rs.getInt("idusuario"));
				usuario.setUsername(rs.getString("username"));
				usuario.setPassword(rs.getString("password"));
				usuario.setTipo(rs.getInt("tipo"));
				usuario.setRol(rs.getInt("rol"));
				usuario.setGrupo(rs.getString("grupo"));
				usuario.setDepartamento(rs.getInt("departamento"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido1(rs.getString("apellido1"));
				usuario.setApellido2(rs.getString("apellido2"));
				usuario.setDomicilio(rs.getString("domicilio"));
				usuario.setPoblacion(rs.getString("poblacion"));
				usuario.setCodpostal(rs.getString("codpostal"));
				usuario.setEmail(rs.getString("email"));
				usuario.setTelefono(rs.getString("telefono"));
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al buscar todos los usuarios");
		} finally {
			ConexionJdbc.cerrar(pstm);
			ConexionJdbc.cerrar(rs);
		}
		return usuarios;
	}

	@Override
	public Usuario buscarPorId(Integer id) throws BusinessException {
		Usuario result = new Usuario();
		try {
			String sql = "SELECT * FROM usuario WHERE idusuario=?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();

			if (rs.first()) {
				result.setIdusuario(rs.getInt("idusuario"));
				result.setUsername(rs.getString("username"));
				result.setPassword(rs.getString("password"));
				result.setTipo(rs.getInt("tipo"));
				result.setRol(rs.getInt("rol"));
				result.setGrupo(rs.getString("grupo"));
				result.setDepartamento(rs.getInt("departamento"));
				result.setNombre(rs.getString("nombre"));
				result.setApellido1(rs.getString("apellido1"));
				result.setApellido2(rs.getString("apellido2"));
				result.setDomicilio(rs.getString("domicilio"));
				result.setPoblacion(rs.getString("poblacion"));
				result.setCodpostal(rs.getString("codpostal"));
				result.setEmail(rs.getString("email"));
				result.setTelefono(rs.getString("telefono"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al buscar el usuario por ID");
		} finally {
			ConexionJdbc.cerrar(pstm);
			ConexionJdbc.cerrar(rs);
		}
		return result;
	}
	public ArrayList<Usuario> buscarPorDepartamento(Integer iddept) throws BusinessException {
		ArrayList<Usuario> result= new ArrayList<Usuario>();
		try {
			
			String sql = "SELECT * FROM usuario WHERE departamento=?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, iddept);
			rs = pstm.executeQuery();

			while(rs.next()) {
				Usuario usu = new Usuario();
				usu.setIdusuario(rs.getInt("idusuario"));
				usu.setUsername(rs.getString("username"));
				usu.setPassword(rs.getString("password"));
				usu.setTipo(rs.getInt("tipo"));
				usu.setRol(rs.getInt("rol"));
				usu.setGrupo(rs.getString("grupo"));
				usu.setDepartamento(rs.getInt("departamento"));
				usu.setNombre(rs.getString("nombre"));
				usu.setApellido1(rs.getString("apellido1"));
				usu.setApellido2(rs.getString("apellido2"));
				usu.setDomicilio(rs.getString("domicilio"));
				usu.setPoblacion(rs.getString("poblacion"));
				usu.setCodpostal(rs.getString("codpostal"));
				usu.setEmail(rs.getString("email"));
				usu.setTelefono(rs.getString("telefono"));
				result.add(usu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al buscar el usuario por ID");
		} finally {
			ConexionJdbc.cerrar(pstm);
			ConexionJdbc.cerrar(rs);
		}
		return result;
	}

	public Boolean comprobarUsrPaswd(String vusr, String vpswd) throws BusinessException{
    	Boolean result=false;
		try {
    		String sql = "SELECT * FROM usuario WHERE username=? and password=?";
    		pstm = con.prepareStatement(sql);
            pstm.setString(1, vusr);
            pstm.setString(2, vpswd);
            rs = pstm.executeQuery();
            if (rs.first()) {
				result=true;
			}else {
				result= false;
			}
            return result;
    	}catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Error al consultar.");
		}finally {
			ConexionJdbc.cerrar(pstm);
			ConexionJdbc.cerrar(rs);
		}
    }
}
