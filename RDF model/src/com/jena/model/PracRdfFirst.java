package com.jena.model;
import com.hp.hpl.jena.datatypes.xsd.XSDDatatype;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Resource;
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;


public class PracRdfFirst extends Object {
	
	public static void main (String args[])  throws IOException {
		
	//String dataFileName = "C:/Documents and Settings/Stefanos/Desktop/ppi";
	
	
	
	//br = new BufferedReader(new FileReader("C:\\testing.txt"));
	
//String sURI = "http://burningbird.net/articles/monsters1.htm";
//String sPostcon = "http://www.burningbird.net/postcon/elements/1.0/";
//String sRelated = "related";
	try {
File datap = new File("/C://Documents and Settings//Stefanos//My Documents//workspace//jena2//ppi.log");
//System.out.println(datap.getCanonicalPath());
BufferedReader bReader = new BufferedReader(
        new FileReader(datap));

String line;
while ((line = bReader.readLine()) != null) {
	 
    /**
     * Splitting the content of tabbed separated line
     */
    String datavalue[] = line.split("\t");
    String value1 = datavalue[0];
    String value2 = datavalue[1];
    String value3 = datavalue[2];
    long value4 = Integer.parseInt(datavalue[3]);
    
    String sPostcon="http://www.protein_interactions.com/";
    String sRelated="interacts"; //define properties
    String sRelated2="Interaction_type";
    String sRelated3="PubIdentifier";
    


    
    

// Create an empty graph
Model model = ModelFactory.createDefaultModel();
// Create the resource
Resource protein = model.createResource(sPostcon+value1);
// Create the predicate (property)
Property interacts = model.createProperty(sPostcon, sRelated);
// Add the properties with associated values (objects)
protein.addProperty(interacts,
value2,XSDDatatype.XSDstring);

Property type = model.createProperty(sPostcon, sRelated2);
//Add the properties with associated values (objects)

protein.addProperty(type,
value3,XSDDatatype.XSDstring);

Property pub = model.createProperty(sPostcon, sRelated3);
//Add the properties with associated values (objects)

protein.addLiteral(pub,
value4);

//Print RDF/XML of model to system output
model.write(new PrintWriter(System.out));
}
bReader.close();
} catch (Exception e) {
System.out.println("Failed: " + e);
}

	}	
	
}


