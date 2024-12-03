package Interfaz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Dao.DaoRol;
import Pojos.Rol;
import jdbc.ConexionJdbc;

public class Consultar_Roles {
	public static void main(String[] args) {
		ConexionJdbc conJdbc = null;
		DaoRol daoRol = null;
		try {
			conJdbc = new ConexionJdbc("Configuracion/PropiedadesInventario");
			conJdbc.conectar();
			
			daoRol = new DaoRol();
			
			List<Rol> roles = new ArrayList<Rol>();
			
			roles = daoRol.buscarTodos();
			
			for (int i = 0; i < roles.size(); i++) {
				Rol r = roles.get(i);
				System.out.println(r.toString());
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
