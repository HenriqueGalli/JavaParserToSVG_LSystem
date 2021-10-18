public class SvgDrawer {
  
    public void draw(String sentence){
        
        for(int i=0; i < sentence.length(); i++){
            Character currentChar = sentence.charAt(i);
            if(currentChar == 'F'){
                //desenhar linha
                //ir para o proximo ponto
            }
            else if(currentChar == '+'){
                //rotacionar para a direita
            } else if(currentChar == '-'){
                //rotacionar para a esquerda
            } else if(currentChar == '['){
                //vai sem desenhar
            } else if(currentChar == ']'){
                //volta a desenhar
            }
        }
    }
}
