import java.util.ArrayList;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.ModelFactory;

import ManejoDeDatos.Space;

public class Space {
	
	private String hasName;
	private ArrayList<String> name;
	private String hasSchedule;
	private String hasEquipment;
	private String hasDescriptionEntity;
	private String hasDescription;
	private String hasRoute;
	private int hasTelephone;
	private int hasAccesibility;
	private String hasURL;
	private String hasEmail;
	private String hasContact;
	private String hasType; //???
	
	private String hasLocation;
	
	public Space() {
		
	}
	
	// GETERS DE LOS ATRIBUTOS
	
	public String getHasName() {
		return this.hasName;
	}
	
	public ArrayList<String> getName() {
		return this.name;
	}

	public void setName(ArrayList<String> name) {
		this.name = name;
	}
	
	
	public String getHasSchedule() {
		return this.hasSchedule;
	}
	
	public String getHasEquipment() {
		return this.hasEquipment;
	}
	
	public String getHasDescriptionEntity() {
		return this.hasDescriptionEntity;
	}
	
	public String getHasDescription() {
		return this.hasDescription;
	}
	
	public String getHasRoute() {
		return this.hasRoute;
	}
	
	public int getHasTelephone() {
		return this.hasTelephone;
	}
	
	public int getHasAccesibility() {
		return this.hasAccesibility;
	}
	
	public String getHasURL() {
		return this.hasURL;
	}
	
	public String getHasEmail() {
		return this.hasEmail;
	}
	
	public String getHasContact() {
		return this.hasContact;
	}
	
	public String getHasType() {
		return this.hasType;
	}
	
	public String getHasLocation() {
		return this.hasLocation;
	}
	
	// SETERS DE LOS ATRIBUTOS
	
	public void setHasName(String hasName) {
		this.hasName = hasName;
	}
	
	public void setHasSchedule(String hasSchedule) {
		this.hasSchedule = hasSchedule;
	}
	
	public void setHasEquipment(String hasEquipment) {
		this.hasEquipment = hasEquipment;
	}
	
	public void setHasDescriptionEntity(String hasDescriptionEntity) {
		this.hasDescriptionEntity = hasDescriptionEntity;
	}
	
	public void setHasDescription(String hasDescription) {
		this.hasDescription = hasDescription;
	}
	
	public void setHasRoute(String hasRoute) {
		this.hasRoute = hasRoute;
	}
	
	public void setHasTelephone(int hasTelephone) {
		this.hasTelephone = hasTelephone;
	}
	
	public void setHasAccesibility(int hasAccesibility) {
		this.hasAccesibility = hasAccesibility;
	}
	
	public void setHasURL(String hasURL) {
		this.hasURL = hasURL;
	}
	
	public void setHasEmailL(String hasEmail) {
		this.hasEmail = hasEmail;
	}
	
	public void setHasContact(String hasContact) {
		this.hasContact = hasContact;
	}
	
	public void setHasType(String hasType) {
		this.hasType = hasType;
	}
	
	public void setHasLocation(String hasLocation) {
		this.hasLocation = hasLocation;
	}
	
	public static void sparqltest()
	{
		Space space = new Space();
		ArrayList<String> arr = new ArrayList<String>();
		
		space.setHasName("hasName");
		
		System.out.println(space.getHasName() + "\n");

	    OntModel model = ModelFactory.createOntologyModel();
	    
	    model.read(inputFile,null,"N-TRIPLES");

	    String queryString=
			"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n"
					+ "PREFIX owl: <http://www.w3.org/2002/07/owl#> \n"
					+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> \n"
					+ "SELECT DISTINCT ?name WHERE { \n"
					+ "        { ?pred <https://freewifizones/madrid/space#" + space.getHasName() + "> ?name. \n"		
					+ "}"
					+ "}";
		Query query= QueryFactory.create(queryString);
		QueryExecution qexec=QueryExecutionFactory.create(query, model);
		
		try {
		    ResultSet results = qexec.execSelect();
		    while ( results.hasNext()){
		        QuerySolution soln = results.nextSolution();
		        arr.add(soln.toString());
		        System.out.println(soln);
		    }
		    
		} finally {
			space.setName(arr);
			System.out.println("\n ++++++++++ \n" + arr.toString());
			qexec.close();
		  }
	}

}
