
public class Edificios {

	
	private String[] listaEdificios; 
    private String [] infoEdificio  ;




	public String [] getListaEdificios (String seleccion) {
		
		//TODO 
		
		String [] lista = {seleccion , "Biblioteca1","Biblioteca2"};
		listaEdificios= lista;
		return listaEdificios;
		
	}
	
	

	public String [] getInfoEdificios (String seleccion) {
		
		//TODO
		
		String [] lista = {seleccion,"horario","info"};
		infoEdificio = lista; 
		return infoEdificio;
		
	}
	
	
	public String [] getLista1 () {
			
			//TODO 
			
			String [] lista = {"Biblioteca1","Biblioteca2"};
			listaEdificios= lista;
			return listaEdificios;
			
	}


}
