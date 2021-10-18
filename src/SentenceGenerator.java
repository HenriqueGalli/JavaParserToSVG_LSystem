import java.util.ArrayList;

public class SentenceGenerator {

    ArrayList<Rule> rules = new ArrayList<Rule>();
   
    Rule r1 = new Rule('F', "FF+[+F-F-F]-[-F+F+F]");

    public String generate(String sentence){
        String nextSentence = "";
        rules.add(r1);

        for(Integer i=0;i<sentence.length();i++){
            Character currentChar = sentence.charAt(i);
            Boolean found = false;
            for(Integer j=0; j<rules.size();j++){
                if(currentChar == rules.get(j).RuleStart){
                    found = true;
                    nextSentence += rules.get(j).RuleEnd;
                    break;
                }
            }
            if(!found){
                nextSentence += currentChar;
            }
        }
        System.out.println(nextSentence);
        return nextSentence;
    }

}
