package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Pojos.Salida;
import dao.DaoGenerico;
import excepciones.BusinessException;
import jdbc.ConexionJdbc;

public class DaoSalida extends DaoGenerico<Salida, Integer>{ 
	PreparedStatement pstm = null;
	String sql;
	ResultSet rs;
	Integer id = 0;
	Connection con = ConexionJdbc.getConnection();
	@Override
	public void grabar(Salida s) throws BusinessException {
		try{
			//Preparar para la insercion
			sql = "INSERT INTO salida "
					+ "(usuario,articulo,fechasalida) "
					+ "VALUES (?,?,?)";
			
			pstm = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			pstm.setInt(1,s.getUsuario());
			pstm.setInt(2,s.getArticulo());			 
			pstm.setTimestamp(3,java.sql.Timestamp.valueOf(s.getFechaSalida()));
		//La fecha de devoluci�n se actualiza al devolvel el art�culo
			/*pstm.setTimestamp(4,java.sql.Timestamp.valueOf(o.getFechaDevolucion()));*/

			//insertar
			pstm.executeUpdate();
			
			//obtener clave generada
			rs= pstm.getGeneratedKeys();
			if (rs.first()) {
				Integer id = rs.getInt(1);
				s.setIdSalida(id);
			}
		} catch (SQLException e){
			e.printStackTrace();
			throw new BusinessException("Error al insertar");
		} finally{
			ConexionJdbc.cerrar(pstm);
		}
	}

	@Override
	public void actualizar(Salida o) throws BusinessException {
		try{
			//Preparar la actualizacion.
			sql = "UPDATE salida"
					+ " SET  usuario = ?, articulo = ? , fechasalida = ? , fechadevolucion = ? "
					+ " WHERE idsalida = ?";
			
			pstm = con.prepareStatement(sql);
			pstm.setInt(1,o.getUsuario());
			pstm.setInt(2,o.getArticulo());
			pstm.setTimestamp(3,java.sql.Timestamp.valueOf(o.getFechaSalida()));
			pstm.setTimestamp(4,java.sql.Timestamp.valueOf(o.getFechaDevolucion()));
			pstm.setInt(5, o.getIdSalida());
			
			//Ejecutar la actualizacion
			int actualizados = pstm.executeUpdate();
			if(actualizados == 0) throw new BusinessException("La salida a modificar no existe");

		} catch (SQLException e){
			throw new BusinessException("Error al actualizar");
		} finally{
			ConexionJdbc.cerrar(pstm);
		}
		
		
	}
	@Override
	public List<Salida> buscarTodos()  throws BusinessException {
		List<Salida> result = new ArrayList<Salida>();
		try{
			sql = "SELECT * FROM salida";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()){
				Salida s  = new Salida();
				s.setIdSalida(rs.getInt(1));
				s.setUsuario(rs.getInt(2));
				LocalDateTime fechaSal =
						rs.getTimestamp("fechaSalida").toLocalDateTime();
				s.setFechaSalida(fechaSal);
						
				result.add(s);
			}
			return result;
			
		} catch (SQLException e){
			e.printStackTrace();
			throw new BusinessException("Error al consultar");
		} finally{
			ConexionJdbc.cerrar(pstm);
		}
	}

	//METODOS DE GESTION ------------------------------

	public void actualizarFechaDevolucion(LocalDateTime f, Integer id) throws BusinessException{
		try {
			sql = "UPDATE salida SET fechadevolucion=? WHERE idsalida=?";
			pstm = con.prepareStatement(sql);
			
			pstm.setTimestamp(1, java.sql.Timestamp.valueOf(f));
			pstm.setInt(2, id);
			int actualizados = pstm.executeUpdate();
			if(actualizados == 0) throw new BusinessException("La salida a modificar no existe");
			
		}catch (SQLException e){
			e.printStackTrace();
			throw new BusinessException("Error al consultar");
		} finally{
			ConexionJdbc.cerrar(pstm);
		}
	}

	
	
}
