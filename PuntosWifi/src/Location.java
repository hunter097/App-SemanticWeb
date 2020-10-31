import java.util.ArrayList;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.ModelFactory;

public class Location {
	
	// Variables usadas por clase Location
	//private double coordinates, geographicalCoordinates;
	private String coordinates, geographicalCoordinates;
	private String address, addressName, addressType, typeNum, floor, orientation, latitude, longitude,
						locality, province;
	private static String neighborhood;
	private String district;
	//private int num, cp, xcoordinate, ycoordinate;
	private String num, cp, xcoordinate, ycoordinate;
	private ArrayList<String> info = new ArrayList<String>();
	
	// Creo una lista ArrayList para almacenar los distritos
	private static ArrayList<String> districtList = new ArrayList<>();
	private static ArrayList<String> neighborhoodList = new ArrayList<>();


	
	// Archivo de entrada para las pruebas
	private static final String inputFile = "output-with-links.nt";

	// Main con las pruebas
	
	public static void main(String [] args) {
		returnDistrictList();
		returnNeighborhood();
		
	}
	
	// Metodo auxiliar que nos devuelve la lista de los distritos
	private static ArrayList<String> returnDistrictList () {
		OntModel model = ModelFactory.createOntologyModel();
		
		model.read(inputFile,null,"N-TRIPLES");
		
		Location loc = new Location();
		
		String queryInstruction = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
				+ "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
				+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
				+ "SELECT DISTINCT ?name \n"
				+ "    WHERE {\n"
				+ "        { ?pred <https://freewifizones/madrid/location#" + loc.get_district_() +"> ?name \n"
				+ "}"
				+ "}";
		
		Query query = QueryFactory.create(queryInstruction);
		QueryExecution qexec = QueryExecutionFactory.create(query,model);
		
		try {
			ResultSet results = qexec.execSelect();
			while(results.hasNext()) {
				QuerySolution sol = results.nextSolution();
				districtList.add(sol.toString().substring(9,sol.toString().length()-2));
			}
			System.out.println(districtList);
		} finally {
			qexec.close();
		}
		return districtList;
	}
	
	// Metodo auxiliar que nos devuelve la lista de los barrios
		private static ArrayList<String> returnNeighborhood () {
			OntModel model = ModelFactory.createOntologyModel();
			
			model.read(inputFile,null,"N-TRIPLES");
			
			Location loc = new Location();
			
			String queryInstruction = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
					+ "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
					+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
					+ "SELECT DISTINCT ?name \n"
					+ "    WHERE {\n"
					+ "        { ?pred <https://freewifizones/madrid/location#" + loc.get_neighborhood_() +"> ?name \n"
					+ "}"
					+ "}";
			
			Query query = QueryFactory.create(queryInstruction);
			QueryExecution qexec = QueryExecutionFactory.create(query,model);
			
			try {
				ResultSet results = qexec.execSelect();
				while(results.hasNext()) {
					QuerySolution sol = results.nextSolution();
					neighborhoodList.add(sol.toString().substring(9,sol.toString().length()-2));
				}
				System.out.println(neighborhoodList);
			} finally {
				qexec.close();
			}
			return neighborhoodList;
		}
	
	public ArrayList<String> getLocationAtributes(){
		info.add(this.coordinates+"");
		info.add(this.address);
		info.add(this.addressName);
		info.add(this.addressType);
		info.add(this.typeNum);
		info.add(this.num+"");
		info.add(this.floor);
		info.add(this.orientation);
		info.add(this.locality);
		info.add(this.province);
		info.add(this.cp+"");
		info.add(this.neighborhood);
		info.add(this.district);
		info.add(this.xcoordinate+"");
		info.add(this.ycoordinate+"");
		info.add(this.latitude);
		info.add(this.longitude);
		info.add(this.geographicalCoordinates+"");
		
		return info;
	}
	
	public void deteleLocationAtributes() {
		info.clear();
	}
	
	// Getters and Setters
	public String getCoordinates() {
		return "coordinates";
	}
	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}
	public String getGeographicalCoordinates() {
		return "geographicalCoordinates";
	}
	public void setGeographicalCoordinates(String geographicalCoordinates) {
		this.geographicalCoordinates = geographicalCoordinates;
	}
	public String getAddress() {
		return "address";
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddressName() {
		return "addressName";
	}
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	public String getAddressType() {
		return "addressType";
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	public String getTypeNum() {
		return "typeNum";
	}
	public void setTypeNum(String typeNum) {
		this.typeNum = typeNum;
	}
	public String getFloor() {
		return "floor";
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getOrientation() {
		return "orientation";
	}
	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}
	public String getLatitude() {
		return "latitude";
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return "longitude";
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String get_locality_() {
		return "locality";
	}
	public void set_locality_(String _locality_) {
		this.locality = _locality_;
	}
	public String get_province_() {
		return "province";
	}
	public void set_province_(String _province_) {
		this.province = _province_;
	}
	public String get_neighborhood_() {
		return "neighborhood";
	}
	public void set_neighborhood_(String _neighborhood_) {
		this.neighborhood = _neighborhood_;
	}
	public String get_district_() {
		return "district";
	}
	public void set_district_(String _district_) {
		this.district = _district_;
	}
	public String getNum() {
		return "num";
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getCp() {
		return "cp";
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getXcoordinate() {
		return "xcoordinate";
	}
	public void setXcoordinate(String xcoordinate) {
		this.xcoordinate = xcoordinate;
	}
	public String getYcoordinate() {
		return "ycoordinate";
	}
	public void setYcoordinate(String ycoordinate) {
		this.ycoordinate = ycoordinate;
	}
	
	
}
