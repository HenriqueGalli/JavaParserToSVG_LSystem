public class App {
    public static void main(String[] args) throws Exception {
        SentenceGenerator generator = new SentenceGenerator();

        
         String axiom = "F";
         String sentence = axiom;

         for(int i=0; i<3;i++){
            sentence = generator.generate(sentence);
        }
         
        System.out.println("------------------------------------------------------------");
    }
}
