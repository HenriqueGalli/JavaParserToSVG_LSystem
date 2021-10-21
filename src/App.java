public class App {
    public static void main(String[] args) throws Exception {
        SentenceGenerator generator = new SentenceGenerator();
        NovoSvgDrawer drawer = new NovoSvgDrawer();

        
         String axiom = "F+F+F+F";
         String sentence = axiom;

         for(int i=0; i<2;i++){
            sentence = generator.generate(sentence);
        }
        
        
        drawer.draw(sentence);

         
        System.out.println("------------------------------------------------------------");
    }
}
