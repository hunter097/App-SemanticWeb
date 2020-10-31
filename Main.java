import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.ModelFactory;

public class Main {
	// Variable which charges our rdf file
	private static final String inputFile = "/Users/usuario/eclipse-workspace/PuntosWifi/src/handsOn.rdf";
	
	public static void main(String[]args) {
		// *We create an Ontology model
		//OntModel model = ModelFactory.createOntologyModel();
		// *Reading our rdf
		//model.read(inputFile,null,"RDF/XML");
		//model.write(System.out,"RDF/XML");
		
		
		Interface interfaz = new Interface();
		
		Edificios listaEdificios = new Edificios();

		Lugares listaDistritos = new Lugares();
		
		
	
		
		interfaz.init(listaEdificios.getLista1(),listaDistritos.getLista2());
        interfaz.setResizable(true);
        interfaz.setVisible(true);    
        
      
        
	}	

}
