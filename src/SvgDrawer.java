import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class SvgDrawer {
    public void draw(String sentence) throws IOException{

        File f = new File("draw.html");
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));

        Integer xInicial = 10000/2 ;
        Integer yInicial = 10000/2;
        Integer xFinal = xInicial;
        Integer yFinal = yInicial;
        Integer anguloDesenho = 90;
        Integer anguloInicial = 90;
        Integer tamanho = 30;
        Boolean horizontal = false;
        Integer direcao = -1;

        bw.write("<svg width='10000' height='10000'>");
        for(int i=0; i < sentence.length(); i++){

            Boolean desenhar = false;
            Character currentChar = sentence.charAt(i);
            Integer valorX;
            Integer valorY;

            //Decide quem anda e quem fica parado (Horizontal ou Vertical)
            if(horizontal == true){
                valorX = (int)Math.ceil(Math.sin(Math.toRadians(anguloDesenho)) * tamanho);
                valorY = (int)Math.round(Math.sin(Math.toRadians(90 - anguloDesenho)) * tamanho);
            }else{
                valorX = (int)Math.ceil(Math.sin(Math.toRadians(90- anguloDesenho)) * tamanho);
                valorY = (int)Math.round(Math.sin(Math.toRadians(anguloDesenho)) * tamanho);
            }
          
            
            if(currentChar == 'F' || currentChar == 'f'){
                desenhar = true;
                if(horizontal){
                    xFinal = xInicial+(valorX*direcao);
                    yFinal = yInicial +(valorY*direcao); 
                }
                else{
                    xFinal = xInicial+(valorX*direcao);
                    yFinal = yInicial +(tamanho*direcao); 
                }

            }else if(currentChar == '+'){
                anguloInicial += 90;
               
                if(anguloInicial ==360){
                    anguloInicial = 0;
                }

                if(anguloInicial == 90 || anguloInicial == 270){
                    horizontal = false;
                }
                else{
                    horizontal = true;
                }

                if(anguloInicial == 0 || anguloInicial == 270){
                    direcao = 1;
                }  
                else{
                    direcao = -1;
                }
                    
            }else if(currentChar == '-'){
               
                anguloInicial -= 90;

                if(anguloInicial < 0)
                    anguloInicial = 270;

                if(anguloInicial == 90 || anguloInicial == 270){
                    horizontal = false;
                }   
                else{
                    horizontal = true;
                }

                if(anguloInicial == 0 || anguloInicial == 270){
                    direcao = 1;
                } 
                else{
                    direcao = -1;
                }
                    
            }
            if(desenhar){

                if(currentChar !='f'){
                    String txtFinal = "<line x1='caminhoXInicial' y1='caminhoYInicial' x2='caminhoXFinal' y2='caminhoYFinal' style='stroke:rgb(0,0,0);stroke-width:3' />";
               
                    txtFinal = txtFinal.replace("caminhoXInicial", Integer.toString(xInicial));      
                    txtFinal = txtFinal.replace("caminhoYInicial", Integer.toString(yInicial));
                    txtFinal = txtFinal.replace("caminhoXFinal", Integer.toString(xFinal));    
                    txtFinal = txtFinal.replace("caminhoYFinal", Integer.toString(yFinal)); 
                    bw.write(txtFinal);
                }
                
                xInicial += (valorX * direcao);
                yInicial += (valorY * direcao);
                
            }
        }

        bw.close();
    }
}

