import greenfoot.*;

// Esta classe representa um contador no jogo.

public class Counter extends Actor {
    // Cores utilizadas.
    
    private static final Color transparent = new Color(0, 0, 0, 0);
    private GreenfootImage background;
    private int value;
    private int target;
    private String prefix;

    // Construtor que inicializa o contador com um prefixo.
    
    public Counter(String prefix) {
        
        // Obtém a imagem padrão do contador.
        
        background = getImage();
        
        // Inicializa os valores do contador.
        
        value = 0;
        target = 0;
        
        // Define o prefixo padrão exibido antes do valor.
        
        this.prefix = "Pontos: ";
        
        // Atualiza a imagem do contador.
        
        updateImage();
    }

    // Método chamado a cada quadro para animar o contador até o valor alvo.
    
    public void act() {
        // Se o valor atual é menor que o valor alvo, 
        // incrementa o valor e atualiza a imagem.
        
        if (value < target) {
            value++;
            updateImage();
        } 
        
        // Se o valor atual é maior que o valor alvo
        // decrementa o valor e atualiza a imagem.
        
        else if (value > target) {
            value--;
            updateImage();
        }
    }

    // Método para adicionar um novo valor ao contador.
    public void add(int score) {
        
        // Adiciona o valor passado como pontuação ao valor alvo do contador.
        
        target += score;
        
    }

    // Método para obter o valor atual do contador.
    
    public int getValue() {
        
        // Retorna o valor alvo do contador.
        
        return target;
    }

    // Método para definir um novo valor no contador sem animação.
    
    public void setValue(int newValue) {
        
        // Define tanto o valor atual quanto o valor alvo 
        // como o novo valor especificado.
        target = newValue;
        
        value = newValue;
        
        // Atualiza a imagem do contador.
        
        updateImage();
    }

    // Método para definir um prefixo que será exibido antes do valor do contador.
    
    public void setPrefix(String prefix) {
        
        // Define o novo prefixo.
        
        this.prefix = prefix;
        
        // Atualiza a imagem do contador.
        
        updateImage();
    }

    // Método para atualizar a imagem do contador com o valor atual.
    
    private void updateImage() {
        
        // Cria uma nova imagem usando a imagem de fundo do contador.
        
        GreenfootImage image = new GreenfootImage(background);
        
        // Cria uma imagem de texto com o prefixo e o valor atual.
        
        GreenfootImage text = new GreenfootImage
        (prefix + value, 22, Color.BLACK, transparent);

        // Redimensiona a imagem de fundo se o texto for mais 
        // largo que a imagem de fundo.
        
        if (text.getWidth() > image.getWidth() - 20) {
            image.scale(text.getWidth() + 20, image.getHeight());
        }

        // Desenha o texto no centro da imagem de fundo.
        
        image.drawImage(text, (image.getWidth() - text.getWidth()) / 2, (image.getHeight() - text.getHeight()) / 2);
        
        // Define a imagem atualizada como a imagem do contador.
        setImage(image);
    }
}
