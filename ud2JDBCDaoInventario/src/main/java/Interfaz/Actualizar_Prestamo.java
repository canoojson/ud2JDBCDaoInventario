package Interfaz;

import java.time.LocalDateTime;
import java.util.Scanner;

import Dao.DaoSalida;
import jdbc.ConexionJdbc;

public class Actualizar_Prestamo {
	public static void main(String[] args) {
		ConexionJdbc conJdbc = null;
		DaoSalida daoSalida = new DaoSalida();
		Scanner tec = new Scanner(System.in);
		
		try {
			conJdbc = new ConexionJdbc("Configuracion/PropiedadesInventario");
			conJdbc.conectar();
			
			System.out.println("Id del prestamo: ");
			Integer id = tec.nextInt();
			
			LocalDateTime fechadev = LocalDateTime.now();
			
			daoSalida.actualizarFechaDevolucion(fechadev, id);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
