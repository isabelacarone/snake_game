import greenfoot.*;
import java.util.Random;
// Essa classe representa o mundo do jogo da cobrinha. 

public class MyWorld extends World {
    // A largura e altura do mundo.
    
    public static final int width = 40;
    public static final int height = 25;
    
    // Construtor do mundo da cobrinha
    
    public MyWorld() {    
        super(40, 25, 20, false);
        Greenfoot.setSpeed(36);
        prepare();
        setPaintOrder(Counter.class, Head.class, Body.class, Food.class);

        // Aqui definimos um plano de fundo para o jogo.
        
        GreenfootImage backgroundImage = new GreenfootImage("parede.jpg");
        setBackground(backgroundImage);
    }
    
    // Possui a largura do mundo.
    
    public static int getMyWidth() {
        return width;
    }
    
    // Possui a altura do mundo.
    
    public static int getMyHeight() {
        return height;
    }
    
    // Criando uma instância da classe Random chamada de r. 
    // Essa instância é usada para gerar números aleatórios dentro do código.
    
    Random r = new Random();
    
    // Aqui temos o Método para preparar o mundo inicialmente.
    
    private void prepare() {
        Head head = new Head();
        
        // A partir do head geramos a cabeça da cobrinha.
        
        addObject(head, getMyHeight() / 2, getMyHeight() / 2);
        
        // Coloca a cabeça da cobrinha no centro do mundo. 
        
        addObject(new Food(), r.nextInt(getMyHeight()), r.nextInt(getMyHeight()));
        
        // Aqui definimos a posição da comida de uma forma aleatória.
    }
}