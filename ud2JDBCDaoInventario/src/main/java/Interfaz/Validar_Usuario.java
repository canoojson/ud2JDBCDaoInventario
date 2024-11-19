package Interfaz;

import java.util.Scanner;

import Dao.DaoUsuario;
import Pojos.Usuario;
import jdbc.ConexionJdbc;

public class Validar_Usuario {
	public static void main(String[] args) {
		ConexionJdbc conJdbc = null;
		DaoUsuario daousuario = null;
		String username;
		String password;
		Scanner tec = new Scanner(System.in);

		try {
			conJdbc = new ConexionJdbc("Configuracion/PropiedadesInventario");
			conJdbc.conectar();

			System.out.println("Username: ");
			username = tec.next();
			System.out.println("Password: ");
			password = tec.next();
			tec.nextLine();
			daousuario = new DaoUsuario();
			if (daousuario.comprobarUsrPaswd(username, password)) {
				System.out.println("Usuario y contraseña correctos");
			} else {
				System.out.println("Datos incorrectos");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
