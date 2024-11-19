package Interfaz;

import java.util.Scanner;

import Dao.DaoGrupo;
import Pojos.Grupo;
import jdbc.ConexionJdbc;

public class Insertar_grupo {
public static void main(String[] args) {
	ConexionJdbc conJdbc = null;
	Grupo g = null;
	DaoGrupo daoGrupo=null;
	String nom_Grupo=null;
	String id_Grupo="";
	Scanner tec= new Scanner(System.in);
	
	try {
		conJdbc=new ConexionJdbc("Configuracion/PropiedadesInventario");
		conJdbc.conectar();
		
		System.out.println("Nombre del nuevo grupo:");
		nom_Grupo=tec.nextLine();
		System.out.println("Id del grupo:");
		id_Grupo = tec.nextLine();
		
		g=new Grupo(id_Grupo,nom_Grupo);
		daoGrupo= new DaoGrupo();
		daoGrupo.grabar(g);
	} catch (Exception e) {
		// TODO: handle exception
	}
}

}
