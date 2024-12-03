package Interfaz;

import java.time.LocalDate;
import java.sql.Date;
import java.util.Scanner;

import Dao.DaoArticulo;
import Pojos.Articulo;
import jdbc.ConexionJdbc;

public class ActualizarEstado_Articulo {
	public static void main(String[] args) {
		ConexionJdbc conJdbc = null;
		DaoArticulo daoArticulo = null;
		Articulo a = null;
		Scanner tec = new Scanner(System.in);
		
		try {
			conJdbc = new ConexionJdbc("Configuracion/PropiedadesInventario");
			conJdbc.conectar();
			
			daoArticulo = new DaoArticulo();
			
			System.out.println("Id del articulo: ");
			Integer idarticulo = tec.nextInt();
			tec.nextLine();
			System.out.println("Nuevo estado: ");
			String estado = tec.nextLine();
			System.out.println("Id usuario baja:");
			Integer idusuariobaja = tec.nextInt();
			
			LocalDate fecha = LocalDate.now();
			
			Date fechabaja = Date.valueOf(fecha);
			
			daoArticulo.actualizarEstado(fechabaja, idusuariobaja, estado, idarticulo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
