import greenfoot.*;
import java.util.Random;

public class Head extends Actor {
    
    // Variáveis de instância para controlar o estado e comportamento da cabeça da cobra.
    
    static private boolean alive;  // Indica se a cobra está viva.
    
    private int direction = 0;      // Armazena a direção da cabeça (0: direita, 1: baixo, 2: esquerda, 3: cima).
    
    private int length = 3;         // Armazena o comprimento inicial da cobra.
    
    private static final int scale = 3;  // Escala usada para aumentar o comprimento da cobra.
    
    Random r = new Random();
    
    private Body nextNode = null;   // Próximo segmento do corpo que será adicionado.
    
    private Body temp;               // Variável temporária.
    
    private boolean temp1 = false;   // Indica se uma tecla foi pressionada após a morte.
    

    // Método chamado a cada quadro.
    public void act() {
        if (alive) {
            // Lógica para controle da cabeça pelo jogador.
            
            if(Greenfoot.isKeyDown("right") && direction != 2) direction = 0;
            else if(Greenfoot.isKeyDown("down") && direction != 3) direction = 1;
            else if(Greenfoot.isKeyDown("left") && direction != 0) direction = 2;
            else if(Greenfoot.isKeyDown("up") && direction != 1) direction = 3;

            setRotation(direction * 90);
            nextNode = new Body(length - 1, direction * 90, nextNode);
            getWorld().addObject(nextNode, getX(), getY());
            move(1);

            if(getOneIntersectingObject(Food.class) != null) foundFood();
            if(getOneIntersectingObject(Body.class) != null || isAtEdge()) death();
        } else {
            // Lógica para lidar com a morte da cobra.
            
            if(Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("right")){}
            else temp1 = true;

            // Reinicia o jogo se alguma tecla for pressionada após a morte.
            
            if((Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("right")) && temp1) {
                Greenfoot.setWorld(new MyWorld());
            }
        }
    }

    // Método chamado quando a comida é encontrada.
    
    private void foundFood() {
        
        length += scale;  // Aumenta o comprimento da cobra.
        
        nextNode.increase();  // Aumenta o comprimento do corpo.
        
        getWorld().removeObject(getOneIntersectingObject(Food.class));  // Remove a comida encontrada.
        
        getWorld().addObject(new Food(), r.nextInt(MyWorld.getMyWidth()), r.nextInt(MyWorld.getMyHeight())); 
        // Adiciona uma nova comida em uma posição aleatória.
    }

    // Método para verificar se a cabeça está nas bordas do mundo.
    
    public boolean isAtEdge() {
        // Retorna verdadeiro se a cabeça estiver fora das bordas do mundo.
        
        return (getX() < 0 || getX() >= MyWorld.getMyWidth() || getY() < 0 || getY() >= MyWorld.getMyHeight());
    }

    // Método chamado quando a cobra morre.
    
    public void death() {
        // Cria um contador exibindo a pontuação e adiciona ao mundo.
        
        Counter counter = new Counter("Score: ");
        getWorld().addObject(counter, MyWorld.getMyWidth() / 2, MyWorld.getMyHeight() / 2);
        // Define o valor do contador como o comprimento da cobra mais 1.
        counter.setValue(length + 1);
        // Define a cobra como morta.
        alive = false;
    }

    // Métodos estáticos para obter a escala da cobra e verificar se está viva.
    public static int getScale() {
        // Retorna a escala da cobra.
        return scale;
    }

    public static boolean getAlive() {
        // Retorna true se a cobra está viva, false se ela estiver morta.
        return alive;
    }

    // Construtor da cabeça.
    public Head() {
        alive = true;  // Inicializa as variáveis para o controle da cabeça.
    }
}

