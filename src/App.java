import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        Path path = Paths.get("teste.txt");
        List<String> linhas = Files.readAllLines(path);

        SentenceGenerator generator = new SentenceGenerator();
        SvgDrawer drawer = new SvgDrawer();
        
         String axiom = linhas.get(0);
         String sentence = axiom;

         for(int i=0; i<2;i++){
            sentence = generator.generate(sentence);
        }      
        
        drawer.draw(sentence);
         
        System.out.println("------------------------------------------------------------");
    }
}
