import greenfoot.*;

// Essa classe vai definir o corpo da cobrinha e seus segmentos. 

public class Body extends Actor {
    private int length;
    private Body nextNode;

    // Método chamado a cada quadro.
    
    public void act() {   
        // 0 == length vai verificar se a cobrinha tem comprimento ou não.
        // Heaf.getAlive vai verificar se a cobrinha tá viva ou não.
        
        if (0 == length--  && Head.getAlive()) getWorld().removeObject(this);
        
        // Remove o segmento do corpo quando seu comprimento atinge zero, ou seja, 
        // irá determinar a morte da cobrinha
        // Se todas forem verdadeiras isso irá avisar se a cobrinha tá viva ou morta. 
    }

    // Construtor que inicializa o segmento do corpo com um comprimento, rotação e referência ao próximo segmento.
    
    public Body(int pLength, int rotation, Body next) {
        
        length = pLength;      // Comprimento do novo segmento do corpo.
        setRotation(rotation); // a rotação inicial do novo segmento do corpo.
        nextNode = next;       // Isso aqui conecta o "novo corpo" ao restante.
    }

    // Método para aumentar o comprimento do segmento do corpo.
    
    public void increase() {
        length += Head.getScale();
        
        // O comprimento é aumentado de acordo com a escalda da cabeça da cobrinha.
        // Usando o Head.getScale vai retornar a escala da cobra
                                                    
        if (nextNode != null) nextNode.increase(); 
        
        // Aqui verificamos que o proximo "nextNode" vai ser nulo ou não.
        // Se não for nulo o comprimento do corpo sera aumentado. 
        // Se for nulo o comprimento do corpo não irá ser aumentado. 
    }
}
