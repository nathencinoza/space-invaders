package game;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;




/**
 * JavaFX App
 */
public class App extends Application {
	
	final Map<KeyCode, Action> controls = Map.of(
	        KeyCode.LEFT, new MoveLeft(),
	        KeyCode.RIGHT, new MoveRight(),
	        KeyCode.SPACE, new Shoot()
	);
	
	
    @Override
    public void start(Stage stage) {
    	stage.setTitle("Space Invaders");
    	var canvas = new Canvas(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

    	//Escena cuando el juego esta andando
    	Group group2 = new Group(); 
    	
        var gameScene = new Scene(group2, canvas.getWidth(), canvas.getHeight(), Color.BLACK);
        
        group2.getChildren().add(canvas); 
        
        setupMainLoop(gameScene, canvas.getGraphicsContext2D(), stage);
        

           
        //Escena del menú principal   
    	Group group1 = new Group(); 
    	
        var startScene = new Scene(group1, canvas.getWidth(), canvas.getHeight(), Color.BLACK);
        
        //Imagen del logo de space invaders
        ImageView imgView = new ImageView(new Image(getClass().getResourceAsStream("res/space_logo.png")));
        imgView.setX(90);
        imgView.setY(60);
        imgView.setFitHeight(200);
        imgView.setFitWidth(500);
        group1.getChildren().add(imgView);
        
        //Boton para empezar el juego
        Button startButton = new Button(); 
        startButton.setLayoutX(270);
        startButton.setLayoutY(300);
        startButton.setText("START");
        startButton.setStyle("-fx-text-fill: #000000; -fx-background-color: #FFE844;-fx-border-width: 4px; -fx-border-color: #d1b806; -fx-border-radius: 10 10 10 10; -fx-background-radius: 12 12 12 12");
        startButton.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 30));
        startButton.setOnAction(e -> stage.setScene(gameScene)); 
        group1.getChildren().add(startButton);
        
       
        stage.setScene(startScene);
        stage.show();
    }
    
    //Escena de la pantalla cuando se acaba el juego
    public void gameOver(Stage stage, int score) {
    	var canvas = new Canvas(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
    	Group group = new Group(); 
        group.getChildren().add(canvas);

        var gameOverScene = new Scene(group, canvas.getWidth(), canvas.getHeight(), Color.BLACK);
        
        //Imagen de game over
        ImageView imgView = new ImageView(new Image(getClass().getResourceAsStream("res/over.png")));
        imgView.setX(140);
        imgView.setY(50);
        imgView.setFitHeight(200);
        imgView.setFitWidth(400);
        group.getChildren().add(imgView);
        
        //Rectangulo para mostrar el puntaje final
        Rectangle rectangle = new Rectangle();
        StackPane stackPane = new StackPane();
        Text text = new Text("SCORE: " + String.valueOf(score)+ " POINTS"); 
        rectangle.setWidth(220);
        rectangle.setHeight(50);
        rectangle.setArcWidth(20);
        rectangle.setArcHeight(20);
        rectangle.setStyle("-fx-fill: #FFE844; -fx-stroke: #d1b806; -fx-stroke-width: 4;");
        text.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 20));
        stackPane.getChildren().add(rectangle); 
        stackPane.getChildren().add(text); 
        stackPane.setLayoutX(215);
        stackPane.setLayoutY(290);
        group.getChildren().add(stackPane);
        
        
        //Boton para iniciar el juego nuevamente
        Button restartButton  = new Button(); 
        restartButton.setLayoutX(212);
        restartButton.setLayoutY(380);
        restartButton.setText("MAIN MENU");
        restartButton.setStyle("-fx-text-fill: #000000; -fx-background-color: #41fc03;-fx-border-width: 5px; -fx-border-color: #3bb013; -fx-border-radius: 10 10 10 10; -fx-background-radius: 12 12 12 12");
        restartButton.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 30));
        restartButton.setOnAction(e -> this.start(stage)); 
        group.getChildren().add(restartButton);
        
        stage.setScene(gameOverScene);

        stage.show();       
        

    }
    
	void setupMainLoop(Scene scene, GraphicsContext gc, Stage stage) {
		var keysPressed = new HashSet<KeyCode>();		
        scene.setOnKeyPressed(e -> { keysPressed.add(e.getCode()); });
        scene.setOnKeyReleased(e -> { keysPressed.remove(e.getCode()); });
           
     
	
    new AnimationTimer() {
    	SpaceInvadersGame spaceInvaders = new SpaceInvadersGame(); 
    	
    	long last = 0; 
    	
		@Override
		public void handle(long now) {
	        try {
				render(gc, spaceInvaders);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

	        var actions = new ArrayList<Action>();
	        for (var k : keysPressed) {
	        	var action = controls.get(k);
	        	if (action != null) {
	        		actions.add(action);
	        	}
	        }
	        long dt = last == 0 ? 0 : now - last;
	        if(!spaceInvaders.update(actions, dt)) {
	        	stop();
	        	gameOver(stage, spaceInvaders.getScore());

	        } 	
	        last = now;  
		}
	}.start();

    
}
	//Dibuja todo para el juego
	  private void render(GraphicsContext gc, SpaceInvadersGame spaceInvaders) throws FileNotFoundException {
	    	gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
	    	drawPlayer(gc, spaceInvaders.getPlayer(), spaceInvaders.getPlayer().playerPosition());
	    	drawBullet(gc, spaceInvaders.getPlayer().playerBullet());
	    	drawBullet(gc, spaceInvaders.getAlienArmy().alienBullet());
	    	drawInfo(gc, spaceInvaders);

	    	for (int i = 0; i < spaceInvaders.getAlienArmy().alienArmyLenght(); i++) {
	    		drawAlien(gc, spaceInvaders.getAlienArmy().getAliens().get(i)); 
	    	}
	    }
	
	  //Todas las funciones para dibujar el jugador, los aliens, las balas, las vidas y puntaje
	  private void drawPlayer(GraphicsContext gc, Player player, int position) throws FileNotFoundException {
		  	Image img = new Image(getClass().getResourceAsStream("res/Cannon.png"));
	    	gc.drawImage(img, 
	    			position + Constants.PLAYER_WIDTH/2,
	    			Constants.SCREEN_HEIGHT - Constants.PLAYER_HEIGHT,
	    			Constants.PLAYER_WIDTH,
	    			Constants.PLAYER_HEIGHT);
			
	    }
	  
	  private void drawAlien(GraphicsContext gc, Alien alien) throws FileNotFoundException {
		  Image img = new Image(getClass().getResourceAsStream("res/alien.png"));
	    	gc.drawImage(img, 
	    			alien.alienXCoordenate(),
	    			alien.alienYCoordenate(),
	    			Constants.ALIEN_WIDTH,
	    			Constants.ALIEN_HEIGHT);
			
	    }
	  
	  private void drawBullet(GraphicsContext gc, Bullet bullet) throws FileNotFoundException {
		  gc.setFill(Color.valueOf(bullet.color()));
		  gc.fillRect(
	    			bullet.bulletXPosition() - Constants.BULLET_WIDTH / 2,
	    			bullet.bulletYPosition() - Constants.BULLET_HEIGHT / 2,
	    			Constants.BULLET_WIDTH,
	    			Constants.BULLET_HEIGHT
	    	);
	  }

	  
	  private void drawInfo(GraphicsContext gc, SpaceInvadersGame spaceInvaders ) {
	    	gc.setFill(Color.WHITE);
	        gc.setTextAlign(TextAlignment.CENTER);
	        gc.setTextBaseline(VPos.TOP);
	    	gc.fillText(String.valueOf(spaceInvaders.getPlayer().playerLives()) + " LIVES", 40, 10); 
	    	gc.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
	    	gc.fillText(String.valueOf(spaceInvaders.getScore()) + " POINTS", 625, 10); 
	    	gc.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
	   }
	 
    public static void main(String[] args) throws FileNotFoundException, IOException  {
        launch();
    }

}