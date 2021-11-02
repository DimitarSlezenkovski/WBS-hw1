import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.VCARD;

import java.io.InputStream;

public class ReadAndNavigate {
    public static void main(String[] args) {
        Model model = ModelFactory.createDefaultModel();

        InputStream in = FileManager.getInternal().open("./src/main/resources/data.xml");

        if (in == null)
            System.out.println("File path is invalid. Please enter a valid path.");
        model.read(in, "");

        Resource Dimitar = model.getResource("https://www.instagram.com/dimitarslezenkovski/");

        System.out.println(Dimitar.getProperty(VCARD.FN).getString());
        System.out.println(Dimitar.getProperty(VCARD.ADR).getString());
        System.out.println(Dimitar.getProperty(VCARD.TITLE).getString());

    }
}
