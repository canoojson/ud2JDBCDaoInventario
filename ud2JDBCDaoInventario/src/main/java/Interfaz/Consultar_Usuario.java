package Interfaz;

import java.util.Scanner;

import Dao.DaoUsuario;
import Pojos.Usuario;
import jdbc.ConexionJdbc;

public class Consultar_Usuario {
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
			tec.nextLine();
			daousuario = new DaoUsuario();
			usu = daousuario.buscarPorId(id);
			if (usu != null) {
				Integer tipo = usu.getTipo();
				if (tipo == 1) {
					System.out.println("El departamento es el " + usu.getDepartamento());
				} else if (tipo == 2) {
					System.out.println("El grupo es el " + usu.getGrupo());
				}
			} else {
				System.out.println("No existe un usuario con esa id");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
