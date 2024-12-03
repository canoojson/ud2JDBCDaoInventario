package Interfaz;


import java.util.Scanner;

import Dao.DaoGrupo;
import Pojos.Grupo;
import jdbc.ConexionJdbc;

public class Actualizar_Grupo {
	public static void main(String[] args) {
		ConexionJdbc conJdbc = null;
		DaoGrupo daoGrupo = null;
		Grupo g = null;
		Scanner tec = new Scanner(System.in);
		try {
			conJdbc = new ConexionJdbc("Configuracion/PropiedadesInventario");
			conJdbc.conectar();
			
			daoGrupo = new DaoGrupo();
			
			System.out.println("Id del grupo: ");
			String idGrupo = tec.nextLine();
			System.out.println("Nombre del grupo: ");
			String nombre = tec.nextLine();
			
			g = new Grupo(idGrupo, nombre);
			
			daoGrupo.actualizar(g);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
