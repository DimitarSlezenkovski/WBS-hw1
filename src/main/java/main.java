import org.apache.jena.rdf.model.*;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.vocabulary.VCARD;
import org.apache.jena.vocabulary.VCARD4;

public class main {
    public static void main(String[] args) {
        Model model = ModelFactory.createDefaultModel();

        Resource Dimitar = model.createResource("https://www.instagram.com/dimitarslezenkovski/");
        Resource Finki = model.createResource("https://www.finki.ukim.mk/");
        Resource Skopje = model.createResource("https://skopje.gov.mk/");
        Resource Karposh = model.createResource("https://karpos.gov.mk/");
        Resource Macedonia = model.createResource("https://en.wikipedia.org/wiki/North_Macedonia");

        Dimitar.addProperty(VCARD.FN, "Dimitar Slezenkovski");
        Dimitar.addProperty(VCARD.NICKNAME, "Dime");
        Dimitar.addProperty(VCARD.BDAY, "13-04-1999");
        Dimitar.addProperty(VCARD.ADR, "St. 500 No. 49, Ilinden, Skopje");
        Dimitar.addProperty(VCARD.TITLE, "Software Engineer");
        Dimitar.addProperty(VCARD.N, Finki);

        Karposh.addProperty(VCARD.GEO, Skopje);

        Finki.addProperty(VCARD.ADR, Karposh);

        Skopje.addProperty(VCARD.GEO, Macedonia);

        Macedonia.addProperty(VCARD.GEO, "Europe");


        StmtIterator stmtIterator = model.listStatements();
        System.out.println("Writing with model.listStatements():");
        while (stmtIterator.hasNext()){
            Statement statement = stmtIterator.nextStatement();
            Resource subject = statement.getSubject();
            Property predicate = statement.getPredicate();
            RDFNode object = statement.getObject();

            System.out.print(subject.toString() + " - ");
            System.out.print(predicate.toString() + " - ");
            if (object instanceof Resource)
                System.out.println(object.toString() + ".");
            else
                System.out.println("\"" + object.toString() + "\".");
        }

        System.out.println("Printing with model.print(), in RDF/XML:");
        model.write(System.out);

        System.out.println("Printing with model.print(), in Pretty RDF/XML:");
        model.write(System.out, "RDF/XML-ABBREV");

        System.out.println("Printing with model.print(), in N-Triples:");
        model.write(System.out, "N-TRIPLES");

        System.out.println("Printing with model.print(), in Turtle:");
        model.write(System.out, "TURTLE");

    }
}
