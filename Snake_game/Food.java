import greenfoot.*;
import java.util.Random;

public class Food extends Actor {
    
    // Instância da classe Random para gerar números aleatórios.
    
    Random r = new Random();
    
    // Método chamado a cada quadro.
    public void act() {
        
        // Enquanto houver interseção com um objeto da classe Body (corpo da cobra),
        // reposiciona a comida em uma nova posição aleatória.
        
        while (getOneIntersectingObject(Body.class) != null) {
            
            // Define a nova posição da comida usando números aleatórios.
            
            setLocation(r.nextInt(MyWorld.getMyWidth()), r.nextInt(MyWorld.getMyHeight()));
        }
        
        // Comentário: Reposiciona a comida se estiver sobreposta pelo corpo.
    }
}
