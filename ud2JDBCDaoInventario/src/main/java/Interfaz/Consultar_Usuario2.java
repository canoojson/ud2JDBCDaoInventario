package Interfaz;

import java.util.Scanner;

import Dao.DaoUsuario;
import Pojos.Usuario;
import jdbc.ConexionJdbc;

public class Consultar_Usuario2 {
	public static void main(String[] args) {
		ConexionJdbc conJdbc = null;
		DaoUsuario daousuario = null;
		Usuario usu = new Usuario();
		int id;
		Scanner tec = new Scanner(System.in);
		
		try {
			conJdbc = new ConexionJdbc("Configuracion/PropiedadesInventario");
			conJdbc.conectar();

			System.out.println("Id usuario:");
			id = tec.nextInt();
			daousuario = new DaoUsuario();
			usu = daousuario.buscarPorId(id);
			if (usu != null) {
				System.out.println("Nombre del usuario: " + usu.getNombre());
				System.out.println("Apellidos del usuario: " + usu.getApellido1() + " " + usu.getApellido2());
			} else {
				System.out.println("No existe un usuario con esa id");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
