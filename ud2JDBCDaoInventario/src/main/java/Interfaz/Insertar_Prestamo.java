package Interfaz;

import java.time.LocalDateTime;
import java.util.Scanner;

import Dao.DaoSalida;
import Pojos.Salida;
import jdbc.ConexionJdbc;

public class Insertar_Prestamo {
	public static void main(String[] args) {
		ConexionJdbc conJdbc = null;
		Salida s = new Salida();
		DaoSalida daoSalida = new DaoSalida();
		Scanner tec = new Scanner(System.in);
		
		try {
			conJdbc=new ConexionJdbc("Configuracion/PropiedadesInventario");
			conJdbc.conectar();
			
			System.out.println("Usuario al que se el realiza el prestamo: ");
			Integer usu = tec.nextInt();
			System.out.println("Articulo que se presta: ");
			Integer art = tec.nextInt();
			LocalDateTime fechasalida = LocalDateTime.now();
			
			s.setArticulo(art);
			s.setFechaSalida(fechasalida);
			s.setUsuario(usu);
			
			daoSalida.grabar(s);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
