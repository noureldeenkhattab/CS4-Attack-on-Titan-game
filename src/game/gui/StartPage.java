package game.gui;
import game.engine.Battle;
import game.engine.exceptions.InsufficientResourcesException;
import game.engine.exceptions.InvalidLaneException;
import game.engine.lanes.Lane;
import game.engine.weapons.PiercingCannon;
import game.engine.weapons.SniperCannon;
import game.engine.weapons.VolleySpreadCannon;
import game.engine.weapons.WallTrap;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class StartPage extends Application {
	boolean ewallFlag1 = false;
	boolean ewallFlag2 = false;
	boolean ewallFlag3 = false;
	boolean hwallFlag1 = false;
	boolean hwallFlag2 = false;
	boolean hwallFlag3 = false;
	boolean hwallFlag4 = false;
	boolean hwallFlag5 = false;
	private String difficulty = "E";
	public void setDifficulty(String diff){
    	this.difficulty = diff;
    }
	public String getDifficulty(){
		return difficulty;
	}
	private int initRes = 250;
	private int nofLanes = 3;
	private int hinitRes = 125;
	private int hnofLanes = 5;
	public void setInitres(int res){
    	this.initRes = res;
    }
	public int getInitres(){
		return initRes;
	}
	public void setNofLanes(int nofLanes){
    	this.nofLanes = nofLanes;
    }
	public int getNofLanes(){
		return nofLanes;
	}
	static Button hweaponShopButton = new Button("Weapon Shop");
	static Button hpassTurnButton = new Button("Pass Turn");
	static Button weaponShopButton= new Button("Weapon Shop"); 
  	 static Button passTurnButton= new Button("Pass Turn"); 
    public void start(Stage stage) throws Exception {
    	Battle hBattle = new Battle(1, 0, 100, hnofLanes, hinitRes);
    	Battle battle = new Battle(1, 0, 100, nofLanes, initRes);
    	Lane Lane1 = battle.getLanes().poll();
    	Lane Lane2 = battle.getLanes().poll();
    	Lane Lane3 = battle.getLanes().poll();
    	
    	Lane hLane1 = hBattle.getLanes().poll();
    	Lane hLane2 = hBattle.getLanes().poll();
    	Lane hLane3 = hBattle.getLanes().poll();
    	Lane hLane4 = hBattle.getLanes().poll();
    	Lane hLane5 = hBattle.getLanes().poll();
        
        Group root = new Group();
        Group easyroot = new Group();
        VBox infoRoot = new VBox();
        Group hardroot = new Group();
        Scene start = new Scene(root);
        Scene easy = new Scene(easyroot, 1600, 750);
        Scene hard = new Scene(hardroot);
        Scene infoScene = new Scene(infoRoot);
        // Scroll
        
   		battle.getLanes().add(Lane1);
   		battle.getLanes().add(Lane2);
   		battle.getLanes().add(Lane3);
        Label intro = new Label("Welcome to the Attack on Titan game. This is a tower defense game whose goal is to survive onslaughts of titans for as long as possible. Most importantly, good luck and have fun!");
        Label instructions = new Label("The primary objective is to protect the walls in each lane by buying weapons using resources gathered from defeating titans. \n Once a wall is destroyed, the corresponding lane becomes lost and weapons can no longer be placed on it. \n Each turn, you can either buy a weapon from the Weapon Shop or pass to skip the buying phase. After that, titans will spawn and move towards your walls. ");
        Label easyLabel = new Label("The number of lanes is 3, and the initial resources per lane is 250.");
        Label hardLabel = new Label("The number of lanes is 5, and the initial resources per lane is 125. Not for the faint of heart.");
        Button infoReturn = new Button("RETURN");
        GridPane laneGrid = new GridPane();
        laneGrid.setVgap(55);
        for (int i = 0; i <= battle.getTitanSpawnDistance(); i++) {
            ColumnConstraints colConstraints = new ColumnConstraints();
            colConstraints.setPercentWidth(1);
            laneGrid.getColumnConstraints().add(colConstraints);
        }
        infoReturn.setOnMouseClicked(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
               stage.setScene(start);
             }
           });
        infoRoot.getChildren().addAll(intro,instructions,easyLabel,hardLabel,infoReturn);
        stage.setTitle("Attack on Titan");
        Label welcome = new Label("Attack on Titan");
        welcome.setFont(new Font(50));
        welcome.setTranslateX(820);
        welcome.setTranslateY(100);
        welcome.setTextFill(Color.WHITE); 
        Label selectDiff = new Label("Select a difficulty");
        selectDiff.setFont(new Font(30));
        selectDiff.setTranslateX(870);
        selectDiff.setTranslateY(300);
        selectDiff.setTextFill(Color.WHITE); 
        Label emptyTest = new Label();
        emptyTest.setAlignment(Pos.TOP_LEFT);
        Button ezmode = new Button("EASY");
        Button hardMode = new Button("HARD");
        Button startGame = new Button("START");
        Circle info = new Circle(100);
        info.setFill(Color.DARKSEAGREEN);
        ezmode.setTranslateX(710);
        ezmode.setTranslateY(400);
        ezmode.setScaleX(4);
        ezmode.setScaleY(4);
        hardMode.setScaleX(4);
        hardMode.setScaleY(4);
        hardMode.setTranslateX(1200);
        hardMode.setTranslateY(400);
        info.setTranslateX(300);
        info.setTranslateY(850);
        startGame.setTranslateX(1400);
        startGame.setTranslateY(850);
        startGame.setScaleX(5);
        startGame.setScaleY(5);
        root.getChildren().addAll(welcome,selectDiff,ezmode,hardMode,info,startGame);
       // BackgroundFill startbg= new BackgroundFill(new ImagePattern(image),null,null); 
       // Background Startb= new Background(startbg); 
        start.setFill(Color.BURLYWOOD);  
      
        
        ezmode.setOnMouseClicked(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
               setDifficulty("E");
               setInitres(250);
               setNofLanes(3);
               battle.getLanes().add(Lane1);
       		battle.getLanes().add(Lane2);
       		battle.getLanes().add(Lane3);
             }
           });
           hardMode.setOnMouseClicked(new EventHandler<Event>() {
               @Override
               public void handle(Event event) {
                  setDifficulty("H");
                  setInitres(125);
                  setNofLanes(5);
                  
                  hBattle.getLanes().add(hLane1);
          		   hBattle.getLanes().add(hLane2);
          		   hBattle.getLanes().add(hLane3);
          		   hBattle.getLanes().add(hLane4);
       		   hBattle.getLanes().add(hLane5);
                }
              });
        startGame.setOnMouseClicked(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
            	if(getDifficulty()=="E")
            		stage.setScene(easy);
            	if(getDifficulty()=="H")
            		stage.setScene(hard);
               stage.setFullScreen(true);               
               stage.show();
            }
        });
        info.setOnMouseClicked(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
               stage.setScene(infoScene);
             }
           });
        //EASY MODE
        
        
     // Create an HBox to contain walls and lanes
        //HBox laneContainer = new HBox();

        // Create VBox for walls
        //VBox walls = new VBox();
        Rectangle wallRectangle1 = new Rectangle(250, 300); // Wall width and height
        wallRectangle1.setFill(Color.ANTIQUEWHITE);
        wallRectangle1.setStroke(Color.BURLYWOOD); // Outline color
        wallRectangle1.setStrokeWidth(2); // Outline width

        Rectangle wallRectangle2 = new Rectangle(250, 300); // Wall width and height
        wallRectangle2.setFill(Color.ANTIQUEWHITE);
        wallRectangle2.setStroke(Color.BURLYWOOD); // Outline color
        wallRectangle2.setStrokeWidth(2); // Outline width

        Rectangle wallRectangle3 = new Rectangle(250, 300); // Wall width and height
        wallRectangle3.setFill(Color.ANTIQUEWHITE);
        wallRectangle3.setStroke(Color.BURLYWOOD); // Outline color
        wallRectangle3.setStrokeWidth(2); // Outline width

        // Add wall rectangles to walls VBox
        //walls.getChildren().addAll(wallRectangle1, wallRectangle2, wallRectangle3);

        // Create VBox for lanes
        //VBox lanes = new VBox();
        //HBox Lane1,Wall1
        HBox Comb1=new HBox(); 
        //HBox Lane2,Wall2
        HBox Comb2=new HBox(); 
        //HBox Lane3,Wall3
        HBox Comb3=new HBox(); 
        //Vbox all lanes
        VBox mainComb=new VBox();
        
        
        
        Rectangle laneRectangle1 = new Rectangle(1700, 300); // Lane width and height
        laneRectangle1.setFill(Color.BURLYWOOD);
        laneRectangle1.setStroke(Color.BLACK); // Outline color
        laneRectangle1.setStrokeWidth(2); // Outline width
        //Adding Lane1 and Wall1 to HBox
        Comb1.getChildren().addAll(wallRectangle1,laneRectangle1); 

        Rectangle laneRectangle2 = new Rectangle(1700, 300); // Lane width and height
        laneRectangle2.setFill(Color.BURLYWOOD);
        laneRectangle2.setStroke(Color.BLACK); // Outline color
        laneRectangle2.setStrokeWidth(2); // Outline width
      //Adding Lane2 and Wall2 to HBox
        Comb2.getChildren().addAll(wallRectangle2,laneRectangle2); 

        Rectangle laneRectangle3 = new Rectangle(1700, 300); // Lane width and height
        laneRectangle3.setFill(Color.BURLYWOOD);
        laneRectangle3.setStroke(Color.BLACK); // Outline color
        laneRectangle3.setStrokeWidth(2); // Outline width
      //Adding Lane3 and Wall3 to HBox
        Comb3.getChildren().addAll(wallRectangle3,laneRectangle3); 
        //Creating HUD and Weapon for each Lane
        Rectangle lowerRectangle= new Rectangle(1920,55);
        lowerRectangle.setFill(Color.BURLYWOOD);
        lowerRectangle.setStroke(Color.BLACK);
        lowerRectangle.setStrokeWidth(2);
        Rectangle upperRectangle=new Rectangle(1920,55);  
        upperRectangle.setFill(Color.BURLYWOOD);
        upperRectangle.setStroke(Color.BLACK);
        upperRectangle.setStrokeWidth(2);
        Rectangle Lane1Weapon= new Rectangle(1920,55);
        Lane1Weapon.setFill(Color.BURLYWOOD);
        Lane1Weapon.setStroke(Color.BLACK);
        Lane1Weapon.setStrokeWidth(2);
        Rectangle Lane2Weapon=new Rectangle(1920,55); 
        Lane2Weapon.setFill(Color.BURLYWOOD);
        Lane2Weapon.setStroke(Color.BLACK);
        Lane2Weapon.setStrokeWidth(2);
        Rectangle Lane3Weapon=new Rectangle(1920,55); 
        Lane3Weapon.setFill(Color.BURLYWOOD);
        Lane3Weapon.setStroke(Color.BLACK);
        Lane3Weapon.setStrokeWidth(2);
       
        passTurnButton.setOnMouseClicked(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
               battle.passTurn();
             }
           });
        
        //HBox for puma
        HBox puma=new HBox(); 
        Label score = new Label("Score: " + battle.getScore() + "      ");
        Label turn = new Label("Turn: " + battle.getNumberOfTurns()+ "      ");
        Label phase = new Label("Phase: " + battle.getBattlePhase()+ "      ");
       //HBox for Resources and Weapon Shop
        HBox rWeapon= new HBox(); 
        Label resources= new Label("Resources: " + battle.getResourcesGathered());
        resources.setFont(new Font(20));
        rWeapon.getChildren().addAll(resources,weaponShopButton,passTurnButton); 
        rWeapon.setTranslateY(1150);
        rWeapon.setTranslateX(1000);
        score.setFont(new Font(25));
        turn.setFont(new Font(25));
        phase.setFont(new Font(25));
        puma.getChildren().addAll(score,turn,phase);
        mainComb.getChildren().addAll(upperRectangle,Lane1Weapon,Comb1,Lane2Weapon,Comb2,Lane3Weapon,Comb3,lowerRectangle);

        // Add lane rectangles to lanes VBox
        //lanes.getChildren().addAll(upperRectangle,Lane1Weapon,laneRectangle1, Lane2Weapon,laneRectangle2,Lane3Weapon,laneRectangle3,lowerRectangle);

        // Add walls and lanes VBoxes to laneContainer HBox
        //laneContainer.getChildren().addAll(walls, lanes);
      



//        HBox labelsContainer = new HBox();
//        Label score = new Label("Score: " + battle.getScore() + "      ");
//        Label turn = new Label("Turn: " + battle.getNumberOfTurns()+ "      ");
//        Label phase = new Label("Phase: " + battle.getBattlePhase()+ "      ");
//        score.setFont(new Font(25));
//        turn.setFont(new Font(25));
//        phase.setFont(new Font(25));
        
        //labelsContainer.getChildren().addAll(score, turn, phase);
        //VBox for all and Lane attributes
        VBox attributes=new VBox(); 

        
        Label W1hp = new Label("HP: " + Lane1.getLaneWall().getCurrentHealth() + "");
        W1hp.setTranslateY(255);
        W1hp.setFont(new Font(16));
        Label W2hp = new Label("HP: " + Lane2.getLaneWall().getCurrentHealth() + "");
        W2hp.setTranslateY(562);
        W2hp.setFont(new Font(16));
        Label W3hp = new Label("HP: " + Lane3.getLaneWall().getCurrentHealth() + "");
        W3hp.setTranslateY(870);
        W3hp.setFont(new Font(16));

//        W1hp.setAlignment(Pos.CENTER);
//        W2hp.setAlignment(Pos.CENTER);
//        W3hp.setAlignment(Pos.CENTER);
//        W1hp.setTranslateY(-800);
//        W2hp.setTranslateY(-400);
//        W3hp.setTranslateY(-125);
        
        Label DL1 = new Label("Danger Level: " + Lane1.getDangerLevel() + "");
        DL1.setTranslateY(256);
        DL1.setFont(new Font(16));
        Label DL2 = new Label("Danger Level: " + Lane2.getDangerLevel() + "");
        DL2.setTranslateY(563);
        DL2.setFont(new Font(16));
        Label DL3 = new Label("Danger Level: " + Lane3.getDangerLevel() + "");
        DL3.setTranslateY(871);
        DL3.setFont(new Font(16));
        DL1.setTextFill(Color.DARKRED);
        DL2.setTextFill(Color.DARKRED);
        DL3.setTextFill(Color.DARKRED);

//        DL1.setAlignment(Pos.CENTER);
//        DL2.setAlignment(Pos.CENTER);
//        DL3.setAlignment(Pos.CENTER);
//        DL1.setTranslateY(-700);
//        DL2.setTranslateY(-405);
//        DL3.setTranslateY(-130);
//        W1hp.toFront();
        attributes.getChildren().addAll(W1hp,DL1,W2hp,DL2,W3hp,DL3);
        easyroot.getChildren().addAll(mainComb,puma, attributes,rWeapon);
       
        

        stage.setScene(start);
        stage.show();
        
        ///////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////
        //WEAPON SHOP BUTTON
        Stage WStage= new Stage();
		Group weaponRoot = new Group(); 
		//Label for weapon shop
		Label title= new Label("Click on a weapon for info");
		
		//HBox for first two Weapons
		HBox row1=new HBox();
		// Rectangle first Two Weapons
		Rectangle snibler= new Rectangle(300,200);
		Rectangle biercing= new Rectangle(300,200);
		snibler.setFill(Color.BEIGE); 
		snibler.setStrokeWidth(2);
		snibler.setStroke(Color.BURLYWOOD);
		biercing.setFill(Color.BEIGE);
		biercing.setStrokeWidth(2);
		biercing.setStroke(Color.BURLYWOOD);
		row1.getChildren().addAll(snibler,biercing);
		//HBox for first buy
		HBox buy1=new HBox(); 
		Button buySnibler= new Button("Buy");
		Button buyBiercing= new Button("Buy");
		buySnibler.setTranslateX(125);
		buyBiercing.setTranslateX(375);
		//HBox for second two Weapons
		buy1.getChildren().addAll(buySnibler,buyBiercing); 
		HBox row2=new HBox(); 
		//Rectangle for Second Two Weapons
		Rectangle volleySbread= new Rectangle(300,200);
		volleySbread.setFill(Color.BEIGE);
		volleySbread.setStrokeWidth(2);
		volleySbread.setStroke(Color.BURLYWOOD);
		Rectangle wallTrab= new Rectangle(300,200);
		wallTrab.setFill(Color.BEIGE); 
		wallTrab.setStrokeWidth(2);
		wallTrab.setStroke(Color.BURLYWOOD);
		row2.getChildren().addAll(volleySbread,wallTrab); 
		//HBox for second buy
		HBox buy2=new HBox(); 
		Button buyVolley= new Button("Buy");
		Button buyTrab= new Button("Buy");
		buyVolley.setTranslateX(125);
		buyTrab.setTranslateX(375);
		buy2.getChildren().addAll(buyVolley,buyTrab); 
		//VBox be containing evrything
		VBox all=new VBox(); 
		all.getChildren().addAll(title,row1,buy1,row2,buy2);
		VBox sniblerBox= new VBox(); 
		//Label for Name Snibler
		Label esmySnibler= new Label("Sniper Cannon"); 
		//Label for Description
		SniperCannon sniblerBot= new SniperCannon(35); 
		Label sniblerDisc= new Label("Shoots Closest Target in Lane" +"\n Damage: "+ sniblerBot.getDamage());
		//HBox for buy and Price
		HBox hSnibler= new HBox();
		Label sniblerPrice = new Label("25"); 
		Button sniblerReturn= new Button("Return"); 
		hSnibler.getChildren().addAll(sniblerReturn,sniblerPrice);
		sniblerBox.getChildren().addAll(sniblerDisc,hSnibler);
		//Vbox for Each Weapon
		VBox biercingBox= new VBox(); 
		//Label for Name Biercing
		Label esmyBiercing= new Label("Piercing Cannon"); 
		//Label for Description
		PiercingCannon BiercingBot= new PiercingCannon(10); 
		Label biercingDisc= new Label("Shoots Closest 5 Targets in Lane" +"\n Damage: "+ BiercingBot.getDamage());
		//HBox for buy and Price
		HBox hBiercing=new HBox();
		HBox hBiercingPrice = new HBox();
		Label biercingPrice = new Label("25");
		biercingPrice.setFont(new Font(18));
		hBiercingPrice.getChildren().addAll(sniblerPrice);
		hBiercingPrice.setTranslateX(50);
		Button biercingReturn= new Button("Return"); 
		hBiercing.getChildren().addAll(biercingReturn);
		biercingBox.getChildren().addAll(biercingDisc,hBiercingPrice,hBiercing);
		//Vbox for Each Weapon
		VBox volleySbreadBox= new VBox(); 
		//Label for Name volleySbread
		Label esmySbread= new Label("Volley Spread Cannon"); 
		//Label for Description
		VolleySpreadCannon sBreadBot= new VolleySpreadCannon(5, 20, 50); 
		Label sbreadDisc= new Label("Shoots All Titans Within Range: "+ "Min:"+ sBreadBot.getMinRange() + ",Max:"+ sBreadBot.getMaxRange() +"\n Damage: "+ sBreadBot.getDamage());
		//HBox for buy and Price
		HBox hSbread= new HBox(); 
		Label sBreadPrice = new Label("100"); 
		Button sBreadReturn= new Button("Return"); 
		hSbread.getChildren().addAll(sBreadPrice,sBreadReturn);
		volleySbreadBox.getChildren().addAll(sbreadDisc,hSbread);
		
		//Vbox for Each Weapon
		VBox trabBox= new VBox(); 
		//Label for Name Wall Trap
		Label esmyTrab= new Label("Wall Trap"); 
		//Label for Description
		WallTrap trabBot= new WallTrap(100); 
		Label trabDisc= new Label("Attacks one Titan on the Wall" +"\n Damage: "+ trabBot.getDamage());
		//HBox for buy and Price
		HBox hTrab= new HBox(); 
		Label trabPrice = new Label("75"); 
		Button trabReturn= new Button("Return"); 
		hTrab.getChildren().addAll(trabPrice,trabReturn);
		trabBox.getChildren().addAll(trabDisc,hTrab);
		Scene infoSnibler= new Scene(sniblerBox);
		Scene infoBiercing=new Scene(biercingBox); 
		Scene infoVolley=new Scene(volleySbreadBox); 
		Scene infoTrab=new Scene(trabBox); 
		Scene WScene=new Scene(weaponRoot); 
		
		sniblerPrice.setTranslateX(100);
		sniblerPrice.setTranslateY(105);
		sniblerPrice.setFont(new Font(18));
		biercingPrice.setTranslateX(400);
		biercingPrice.setTranslateY(105);
		biercingPrice.setFont(new Font(18));
		sBreadPrice.setTranslateX(100);
		sBreadPrice.setTranslateY(330);
		sBreadPrice.setFont(new Font(18));
		trabPrice.setTranslateX(400);
		trabPrice.setTranslateY(330);
		trabPrice.setFont(new Font(18));
		esmySnibler.setTranslateX(100);
		esmySnibler.setTranslateY(75);
		esmySnibler.setFont(new Font(18));
		esmyBiercing.setTranslateX(400); 
		esmyBiercing.setTranslateY(75); 
		esmyBiercing.setFont(new Font(18));
		esmySbread.setTranslateX(75);
		esmySbread.setTranslateY(300);
		esmySbread.setFont(new Font(18));
		esmyTrab.setTranslateX(400); 
		esmyTrab.setTranslateY(300); 
		esmyTrab.setFont(new Font(18));
		WStage.setScene(WScene); 
		//HBox for Select Lane
		HBox laneSelection= new HBox();
		VBox labelWeBox=new VBox();
		Label selectLane= new Label("Select Lane");
		Button Lan1= new Button("Lane 1");
		Button Lan2= new Button("Lane 2");
		Button Lan3= new Button("Lane 3"); 
		laneSelection.getChildren().addAll(Lan1,Lan2,Lan3); 
		labelWeBox.getChildren().addAll(selectLane,laneSelection); 
		
		//Add to scene
		weaponRoot.getChildren().addAll(all,esmySnibler,esmyBiercing,esmySbread,esmyTrab,sniblerPrice, biercingPrice, sBreadPrice, trabPrice);
		//Scene Select Lane
		Scene sLane= new Scene(labelWeBox); 
		
		 
	        weaponShopButton.setScaleX(2.5);
	        weaponShopButton.setScaleY(2.5); 
	        weaponShopButton.setTranslateX(300);
	        passTurnButton.setScaleX(2.5);
	        passTurnButton.setScaleY(2.5);
	        passTurnButton.setTranslateX(500); 
	        weaponShopButton.setOnMouseClicked(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
            	WStage.show();
            	WStage.alwaysOnTopProperty();
            }
             
           });
		snibler.setOnMouseClicked(new EventHandler<Event>(){

			@Override
			public void handle(Event event) {
				WStage.setScene(infoSnibler);
				
			}
			
		});
		sniblerReturn.setOnMouseClicked(new EventHandler<Event>(){

			@Override
			public void handle(Event event) {
				WStage.setScene(WScene);
				
			}
			
		});
		biercing.setOnMouseClicked(new EventHandler<Event>(){

			@Override
			public void handle(Event event) {
				WStage.setScene(infoBiercing); 
				
			}
			
		});
		biercingReturn.setOnMouseClicked(new EventHandler<Event>(){
			public void handle(Event event){
				WStage.setScene(WScene); 
			}
		});
		volleySbread.setOnMouseClicked(new EventHandler<Event>(){

			@Override
			public void handle(Event event) {
				WStage.setScene(infoVolley); 
				
			}
			
		});
		sBreadReturn.setOnMouseClicked(new EventHandler<Event>(){

			@Override
			public void handle(Event event) {
				WStage.setScene(WScene); 
				
			}
			
		});
		wallTrab.setOnMouseClicked(new EventHandler<Event>(){

			@Override
			public void handle(Event event) {
				WStage.setScene(infoTrab);
				
			}
			
		});
		trabReturn.setOnMouseClicked(new EventHandler<Event>(){

			@Override
			public void handle(Event event) {
				WStage.setScene(WScene); 
				
			
			}
		});
		buySnibler.setOnMouseClicked(new EventHandler<Event>(){

			@Override
			public void handle(Event event) {
				WStage.setScene(sLane);
				wCodeSet(2);
				
			}
			
			
		});
		buyBiercing.setOnMouseClicked(new EventHandler<Event>(){

			@Override
			public void handle(Event event) {
				WStage.setScene(sLane);
				wCodeSet(1);
				
			}
		
		});
		buyVolley.setOnMouseClicked(new EventHandler<Event>(){
			public void handle(Event event){
				WStage.setScene(sLane);
				wCodeSet(3);
			}
		});
		buyTrab.setOnMouseClicked(new EventHandler<Event>(){

			@Override
			public void handle(Event event) {
				WStage.setScene(sLane); 
				wCodeSet(4);
			}
			
		});
		GridPane eTrabGrid = new GridPane();
		eTrabGrid.setVgap(55);
		eTrabGrid.setTranslateY(110);
		RowConstraints row = new RowConstraints(300);
		for(int i=0; i<3; i++){
		eTrabGrid.getRowConstraints().add(row);}
		HBox wL1 = new HBox();
		HBox wL2 = new HBox();
		HBox wL3 = new HBox();
		GridPane hTrabGrid = new GridPane();
		hTrabGrid.setVgap(100);
		hTrabGrid.setTranslateY(110);
		RowConstraints hrow = new RowConstraints(136);
		for(int i=0; i<3; i++){
			hTrabGrid.getRowConstraints().add(hrow);}
		HBox hwL1 = new HBox();
		hwL1.setTranslateX(250);
		hwL1.setTranslateY(88);
		HBox hwL2 = new HBox();
		hwL2.setTranslateX(250);
		hwL2.setTranslateY(266);
		HBox hwL3 = new HBox();
		hwL3.setTranslateX(250);
		hwL3.setTranslateY(454);
		HBox hwL4 = new HBox();
		hwL4.setTranslateX(250);
		hwL4.setTranslateY(642);
		HBox hwL5 = new HBox();
		hwL5.setTranslateX(250);
		hwL5.setTranslateY(850);
		wL1.setTranslateX(251);
		Lan1.setOnMouseClicked(new EventHandler<Event>(){

			@Override
			public void handle(Event event) {
				try {
					battle.purchaseWeapon(wCodeGet(),Lane1);
					resources.setText("Resources:" + battle.getResourcesGathered());
					if(wCodeGet()==1)
						wL1.getChildren().add(addBiercing()); 
					if(wCodeGet()==2)
						wL1.getChildren().add(addSnibler()); 
					if(wCodeGet()==3)
						wL1.getChildren().add(addSbread()); 
					if(wCodeGet()==4 && ewallFlag1 == false){
						eTrabGrid.add(addTrab(), 0, 1);
						ewallFlag1 = true;}
					else if(wCodeGet()==4 && ewallFlag1 == true){
						throw new IOException();
					}
					WStage.hide();
					WStage.setScene(WScene);
					
				} catch (InsufficientResourcesException e) {
					Stage exceptionStage = new Stage();
				    Group insuffResourcesGroup = new Group();
				    VBox insuffResourcesV = new VBox();
				    Label insuffResourcesL = new Label("Not enough resources to buy weapon.");
				    insuffResourcesV.getChildren().addAll(insuffResourcesL);
				    insuffResourcesGroup.getChildren().add(insuffResourcesV);
				    Scene insuffResourcesException = new Scene(insuffResourcesGroup);
				    exceptionStage.setScene(insuffResourcesException);
				    exceptionStage.show();
	            	exceptionStage.alwaysOnTopProperty();
				    
				} catch (InvalidLaneException e) {
					Stage exceptionStage = new Stage();
				    Group invalidLaneGroup = new Group();
				    VBox invalidLaneV = new VBox();
				    Label invalidLaneLabel = new Label("Lane is inactive. \n Please select another lane");
				    invalidLaneV.getChildren().addAll(invalidLaneLabel);
				    invalidLaneGroup.getChildren().add(invalidLaneV);
				    Scene invalidLaneException = new Scene(invalidLaneGroup);
				    exceptionStage.setScene(invalidLaneException);
				    exceptionStage.show();
	            	exceptionStage.alwaysOnTopProperty();
				}
				catch (IOException e) {
					Stage exceptionStage = new Stage();
					Group invalidwall = new Group();
				    VBox invalidwallv = new VBox();
				    Label invalidwalllabel = new Label("Wall trap exists on this lane!");
				    invalidwallv.getChildren().addAll(invalidwalllabel);
				    invalidwall.getChildren().add(invalidwallv);
				    Scene invalidLaneException = new Scene(invalidwall);
				    exceptionStage.setScene(invalidLaneException);
				    exceptionStage.show();
	            	exceptionStage.alwaysOnTopProperty();
				}
				
			}
			
		});
		
		Lan2.setOnMouseClicked(new EventHandler<Event>(){

			@Override
			public void handle(Event event) {
				try {
					battle.purchaseWeapon(wCodeGet(),Lane2);
					resources.setText("Resources:" + battle.getResourcesGathered());
					if(wCodeGet()==1)
						wL2.getChildren().add(addBiercing()); 
					if(wCodeGet()==2)
						wL2.getChildren().add(addSnibler()); 
					if(wCodeGet()==3)
						wL2.getChildren().add(addSbread()); 
					if(wCodeGet()==4 && ewallFlag2 == false){
						eTrabGrid.add(addTrab(), 0, 1);
						ewallFlag2 = true;}
					else if(wCodeGet()==4 && ewallFlag2 == true){
						throw new IOException();
					}
					WStage.hide();
					WStage.setScene(WScene);
				} catch (InsufficientResourcesException e) {
					Stage exceptionStage = new Stage();
				    Group insuffResourcesGroup = new Group();
				    VBox insuffResourcesV = new VBox();
				    Label insuffResourcesL = new Label("Not enough resources to buy weapon.");
				    insuffResourcesV.getChildren().addAll(insuffResourcesL);
				    insuffResourcesGroup.getChildren().add(insuffResourcesV);
				    Scene insuffResourcesException = new Scene(insuffResourcesGroup);
				    exceptionStage.setScene(insuffResourcesException);
				    exceptionStage.show();
	            	exceptionStage.alwaysOnTopProperty();
				    
				} catch (InvalidLaneException e) {
					Stage exceptionStage = new Stage();
				    Group invalidLaneGroup = new Group();
				    VBox invalidLaneV = new VBox();
				    Label invalidLaneLabel = new Label("Lane is inactive. \n Please select another lane");
				    invalidLaneV.getChildren().addAll(invalidLaneLabel);
				    invalidLaneGroup.getChildren().add(invalidLaneV);
				    Scene invalidLaneException = new Scene(invalidLaneGroup);
				    exceptionStage.setScene(invalidLaneException);
				    exceptionStage.show();
	            	exceptionStage.alwaysOnTopProperty();
				}
				catch (IOException e) {
					Stage exceptionStage = new Stage();
					Group invalidwall = new Group();
				    VBox invalidwallv = new VBox();
				    Label invalidwalllabel = new Label("Wall trap exists on this lane!");
				    invalidwallv.getChildren().addAll(invalidwalllabel);
				    invalidwall.getChildren().add(invalidwallv);
				    Scene invalidLaneException = new Scene(invalidwall);
				    exceptionStage.setScene(invalidLaneException);
				    exceptionStage.show();
	            	exceptionStage.alwaysOnTopProperty();
				}
				
			}
			
		});
		Lan3.setOnMouseClicked(new EventHandler<Event>(){

			@Override
			public void handle(Event event) {
				try {
					battle.purchaseWeapon(wCodeGet(),Lane3);
					resources.setText("Resources:" + battle.getResourcesGathered());
					if(wCodeGet()==1)
						wL3.getChildren().add(addBiercing()); 
					if(wCodeGet()==2)
						wL3.getChildren().add(addSnibler()); 
					if(wCodeGet()==3)
						wL3.getChildren().add(addSbread()); 
					if(wCodeGet()==4 && ewallFlag3 == false){
						eTrabGrid.add(addTrab(), 0, 1);
						ewallFlag3 = true;}
					else if(wCodeGet()==4 && ewallFlag3 == true){
						throw new IOException();
					}
					WStage.hide();
					WStage.setScene(WScene);
				} catch (InsufficientResourcesException e) {
					Stage exceptionStage = new Stage();
				    Group insuffResourcesGroup = new Group();
				    VBox insuffResourcesV = new VBox();
				    Label insuffResourcesL = new Label("Not enough resources to buy weapon.");
				    insuffResourcesV.getChildren().addAll(insuffResourcesL);
				    insuffResourcesGroup.getChildren().add(insuffResourcesV);
				    Scene insuffResourcesException = new Scene(insuffResourcesGroup);
				    exceptionStage.setScene(insuffResourcesException);
				    exceptionStage.show();
	            	exceptionStage.alwaysOnTopProperty();
				    
				} catch (InvalidLaneException e) {
					Stage exceptionStage = new Stage();
				    Group invalidLaneGroup = new Group();
				    VBox invalidLaneV = new VBox();
				    Label invalidLaneLabel = new Label("Lane is inactive. \n Please select another lane");
				    invalidLaneV.getChildren().addAll(invalidLaneLabel);
				    invalidLaneGroup.getChildren().add(invalidLaneV);
				    Scene invalidLaneException = new Scene(invalidLaneGroup);
				    exceptionStage.setScene(invalidLaneException);
				    exceptionStage.show();
	            	exceptionStage.alwaysOnTopProperty();
				}
				catch (IOException e) {
					Stage exceptionStage = new Stage();
					Group invalidwall = new Group();
				    VBox invalidwallv = new VBox();
				    Label invalidwalllabel = new Label("Wall trap exists on this lane!");
				    invalidwallv.getChildren().addAll(invalidwalllabel);
				    invalidwall.getChildren().add(invalidwallv);
				    Scene invalidLaneException = new Scene(invalidwall);
				    exceptionStage.setScene(invalidLaneException);
				    exceptionStage.show();
	            	exceptionStage.alwaysOnTopProperty();
				}
			}
			
		});
		////HARD MODE WS
		//HARD MODE WEAPON SHOP BUTTON
        Stage hWStage= new Stage();
		Group hweaponRoot = new Group(); 
		//Label for weapon shop
		Label htitle= new Label("Click on a weapon for info");
		
		//HBox for first two Weapons
		HBox hrow1=new HBox();
		// Rectangle first Two Weapons
		Rectangle hsnibler= new Rectangle(300,200);
		Rectangle hbiercing= new Rectangle(300,200);
		hsnibler.setFill(Color.BEIGE); 
		hsnibler.setStrokeWidth(2);
		hsnibler.setStroke(Color.BURLYWOOD);
		hbiercing.setFill(Color.BEIGE);
		hbiercing.setStrokeWidth(2);
		hbiercing.setStroke(Color.BURLYWOOD);
		hrow1.getChildren().addAll(hsnibler,hbiercing);
		//HBox for first buy
		HBox hbuy1=new HBox(); 
		Button hbuySnibler= new Button("Buy");
		Button hbuyBiercing= new Button("Buy");
		hbuySnibler.setTranslateX(125);
		hbuyBiercing.setTranslateX(375);
		//HBox for second two Weapons
		hbuy1.getChildren().addAll(hbuySnibler,hbuyBiercing); 
		HBox hrow2=new HBox(); 
		//Rectangle for Second Two Weapons
		Rectangle hvolleySbread= new Rectangle(300,200);
		hvolleySbread.setFill(Color.BEIGE);
		hvolleySbread.setStrokeWidth(2);
		hvolleySbread.setStroke(Color.BURLYWOOD);
		Rectangle hwallTrab= new Rectangle(300,200);
		hwallTrab.setFill(Color.BEIGE); 
		hwallTrab.setStrokeWidth(2);
		hwallTrab.setStroke(Color.BURLYWOOD);
		hrow2.getChildren().addAll(hvolleySbread,hwallTrab); 
		//HBox for second buy
		HBox hbuy2=new HBox(); 
		Button hbuyVolley= new Button("Buy");
		Button hbuyTrab= new Button("Buy");
		hbuyVolley.setTranslateX(125);
		hbuyTrab.setTranslateX(375);
		hbuy2.getChildren().addAll(hbuyVolley,hbuyTrab); 
		//VBox be containing evrything
		VBox hall=new VBox(); 
		hall.getChildren().addAll(htitle,hrow1,hbuy1,hrow2,hbuy2);
		
		//Vbox for Each Weapon
		VBox hsniblerBox= new VBox(); 
		//Label for Name Snibler
		Label hesmySnibler= new Label("Sniper Cannon"); 
		//Label for Description
		SniperCannon hsniblerBot= new SniperCannon(35); 
		Label hsniblerDisc= new Label("Shoots Closest Target in Lane" +"\n Damage: "+ hsniblerBot.getDamage());
		//HBox for buy and Price
		HBox hSniblerh= new HBox();
		Label hsniblerPrice = new Label("25"); 
		Button hsniblerReturn= new Button("Return"); 
		hSniblerh.getChildren().addAll(hsniblerReturn,hsniblerPrice);
		hsniblerBox.getChildren().addAll(hsniblerDisc,hSniblerh);
		//Vbox for Each Weapon
		VBox hbiercingBox= new VBox(); 
		//Label for Name Biercing
		Label hesmyBiercing= new Label("Piercing Cannon"); 
		//Label for Description
		PiercingCannon hBiercingBot= new PiercingCannon(10); 
		Label hbiercingDisc= new Label("Shoots Closest 5 Targets in Lane" +"\n Damage: "+ hBiercingBot.getDamage());
		//HBox for buy and Price
		HBox hBiercingh=new HBox();
		HBox hBiercingPriceh = new HBox();
		Label hbiercingPrice = new Label("25");
		hbiercingPrice.setFont(new Font(18));
		hBiercingPriceh.getChildren().addAll(hsniblerPrice);
		hBiercingPriceh.setTranslateX(50);
		Button hbiercingReturn= new Button("Return"); 
		hBiercingh.getChildren().addAll(hbiercingReturn);
		hbiercingBox.getChildren().addAll(hbiercingDisc,hBiercingPriceh,hBiercingh);
		//Vbox for Each Weapon
		VBox hvolleySbreadBox= new VBox(); 
		//Label for Name volleySbread
		Label hesmySbread= new Label("Volley Spread Cannon"); 
		//Label for Description
		VolleySpreadCannon hsBreadBot= new VolleySpreadCannon(5, 20, 50); 
		Label hsbreadDisc= new Label("Shoots All Titans Within Range: "+ "Min:"+ hsBreadBot.getMinRange() + ",Max:"+ sBreadBot.getMaxRange() +"\n Damage: "+ sBreadBot.getDamage());
		//HBox for buy and Price
		HBox hSbreadh= new HBox(); 
		Label hsBreadPrice = new Label("100"); 
		Button hsBreadReturn= new Button("Return"); 
		hSbreadh.getChildren().addAll(hsBreadPrice,hsBreadReturn);
		hvolleySbreadBox.getChildren().addAll(hsbreadDisc,hSbreadh);
		
		//Vbox for Each Weapon
		VBox htrabBox= new VBox(); 
		//Label for Name Wall Trap
		Label hesmyTrab= new Label("Wall Trap"); 
		//Label for Description
		WallTrap htrabBot= new WallTrap(100); 
		Label htrabDisc= new Label("Attacks one Titan on the Wall" +"\n Damage: "+ htrabBot.getDamage());
		//HBox for buy and Price
		HBox hTrabh= new HBox(); 
		Label htrabPrice = new Label("75"); 
		Button htrabReturn= new Button("Return"); 
		hTrabh.getChildren().addAll(htrabPrice,htrabReturn);
		htrabBox.getChildren().addAll(htrabDisc,hTrabh);
		Scene hinfoSnibler= new Scene(hsniblerBox);
		Scene hinfoBiercing=new Scene(hbiercingBox); 
		Scene hinfoVolley=new Scene(hvolleySbreadBox); 
		Scene hinfoTrab=new Scene(htrabBox); 
		Scene hWScene=new Scene(hweaponRoot); 
		
		hsniblerPrice.setTranslateX(100);
		hsniblerPrice.setTranslateY(105);
		hsniblerPrice.setFont(new Font(18));
		hbiercingPrice.setTranslateX(400);
		hbiercingPrice.setTranslateY(105);
		hbiercingPrice.setFont(new Font(18));
		hsBreadPrice.setTranslateX(100);
		hsBreadPrice.setTranslateY(330);
		hsBreadPrice.setFont(new Font(18));
		htrabPrice.setTranslateX(400);
		htrabPrice.setTranslateY(330);
		htrabPrice.setFont(new Font(18));
		hesmySnibler.setTranslateX(100);
		hesmySnibler.setTranslateY(75);
		hesmySnibler.setFont(new Font(18));
		hesmyBiercing.setTranslateX(400); 
		hesmyBiercing.setTranslateY(75); 
		hesmyBiercing.setFont(new Font(18));
		hesmySbread.setTranslateX(75);
		hesmySbread.setTranslateY(300);
		hesmySbread.setFont(new Font(18));
		hesmyTrab.setTranslateX(400); 
		hesmyTrab.setTranslateY(300); 
		hesmyTrab.setFont(new Font(18));
		hWStage.setScene(hWScene); 
		//HBox for Select Lane
		HBox hlaneSelection= new HBox();
		VBox hlabelWeBox=new VBox();
		Label hselectLane= new Label("Select Lane");
		Button hLan1= new Button("Lane 1");
		Button hLan2= new Button("Lane 2");
		Button hLan3= new Button("Lane 3"); 
		Button hLan4= new Button("Lane 4");
		Button hLan5= new Button("Lane 5");
		hlaneSelection.getChildren().addAll(hLan1,hLan2,hLan3, hLan4, hLan5); 
		hlabelWeBox.getChildren().addAll(hselectLane,hlaneSelection); 
		//Add to scene
		hweaponRoot.getChildren().addAll(hall,hesmySnibler,hesmyBiercing,hesmySbread,hesmyTrab,hsniblerPrice, hbiercingPrice, hsBreadPrice, htrabPrice);
		//Scene Select Lane
		Scene hsLane= new Scene(hlabelWeBox); 
		 //HARD MODE
		HBox hrWeapon= new HBox(); 
        Label hResources= new Label("Resources: " + hBattle.getResourcesGathered());
        hResources.setFont(new Font(20));
        hrWeapon.getChildren().addAll(hResources,hweaponShopButton,hpassTurnButton); 
        //Hard mode buttons
        hweaponShopButton.setScaleX(1.75);
        hweaponShopButton.setScaleY(1.75); 
        hweaponShopButton.setTranslateX(300);
        hweaponShopButton.setOnMouseClicked(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
            	hWStage.show();
            	hWStage.alwaysOnTopProperty();
            }
             
           });
		hsnibler.setOnMouseClicked(new EventHandler<Event>(){

			@Override
			public void handle(Event event) {
				hWStage.setScene(hinfoSnibler);
				
			}
			
		});
		hsniblerReturn.setOnMouseClicked(new EventHandler<Event>(){

			@Override
			public void handle(Event event) {
				hWStage.setScene(hWScene);
				
			}
			
		});
		hbiercing.setOnMouseClicked(new EventHandler<Event>(){

			@Override
			public void handle(Event event) {
				hWStage.setScene(hinfoBiercing); 
				
			}
			
		});
		hbiercingReturn.setOnMouseClicked(new EventHandler<Event>(){
			public void handle(Event event){
				hWStage.setScene(hWScene); 
			}
		});
		hvolleySbread.setOnMouseClicked(new EventHandler<Event>(){

			@Override
			public void handle(Event event) {
				hWStage.setScene(hinfoVolley); 
				
			}
			
		});
		hsBreadReturn.setOnMouseClicked(new EventHandler<Event>(){

			@Override
			public void handle(Event event) {
				hWStage.setScene(hWScene); 
				
			}
			
		});
		hwallTrab.setOnMouseClicked(new EventHandler<Event>(){

			@Override
			public void handle(Event event) {
				hWStage.setScene(hinfoTrab);
				
			}
			
		});
		htrabReturn.setOnMouseClicked(new EventHandler<Event>(){

			@Override
			public void handle(Event event) {
				hWStage.setScene(hWScene); 
				
			
			}
		});
		hbuySnibler.setOnMouseClicked(new EventHandler<Event>(){

			@Override
			public void handle(Event event) {
				hWStage.setScene(hsLane);
				wCodeSet(2);
				
			}
			
			
		});
		hbuyBiercing.setOnMouseClicked(new EventHandler<Event>(){

			@Override
			public void handle(Event event) {
				hWStage.setScene(hsLane);
				wCodeSet(1);
				
			}
		
		});
		hbuyVolley.setOnMouseClicked(new EventHandler<Event>(){
			public void handle(Event event){
				hWStage.setScene(hsLane);
				wCodeSet(3);
			}
		});
		hbuyTrab.setOnMouseClicked(new EventHandler<Event>(){

			@Override
			public void handle(Event event) {
				hWStage.setScene(hsLane); 
				wCodeSet(4);
			}
			
		});
        hLan1.setOnMouseClicked(new EventHandler<Event>(){

			@Override
			public void handle(Event event) {
				try {
					hBattle.purchaseWeapon(wCodeGet(),hLane1);
					hResources.setText("Resources:" + hBattle.getResourcesGathered());
					if(wCodeGet()==1)
						hwL1.getChildren().add(addBiercing()); 
					if(wCodeGet()==2)
						hwL1.getChildren().add(addSnibler()); 
					if(wCodeGet()==3)
						hwL1.getChildren().add(addSbread()); 
					if(wCodeGet()==4 && hwallFlag1 == false){
						hTrabGrid.add(addTrab(), 10, 1);
						hwallFlag1 = true;
					}
					else if(wCodeGet()==4 && hwallFlag1 == true){
						throw new IOException();}
					hWStage.hide();
					hWStage.setScene(hWScene);
				} catch (InsufficientResourcesException e) {
					Stage exceptionStage = new Stage();
				    Group insuffResourcesGroup = new Group();
				    VBox insuffResourcesV = new VBox();
				    Label insuffResourcesL = new Label("Not enough resources to buy weapon.");
				    insuffResourcesV.getChildren().addAll(insuffResourcesL);
				    insuffResourcesGroup.getChildren().add(insuffResourcesV);
				    Scene insuffResourcesException = new Scene(insuffResourcesGroup);
				    exceptionStage.setScene(insuffResourcesException);
				    exceptionStage.show();
	            	exceptionStage.alwaysOnTopProperty();
				    
				} catch (InvalidLaneException e) {
					Stage exceptionStage = new Stage();
				    Group invalidLaneGroup = new Group();
				    VBox invalidLaneV = new VBox();
				    Label invalidLaneLabel = new Label("Lane is inactive. \n Please select another lane");
				    invalidLaneV.getChildren().addAll(invalidLaneLabel);
				    invalidLaneGroup.getChildren().add(invalidLaneV);
				    Scene invalidLaneException = new Scene(invalidLaneGroup);
				    exceptionStage.setScene(invalidLaneException);
				    exceptionStage.show();
	            	exceptionStage.alwaysOnTopProperty();
				}
				catch (IOException e) {
					Stage exceptionStage = new Stage();
					Group invalidwall = new Group();
				    VBox invalidwallv = new VBox();
				    Label invalidwalllabel = new Label("Wall trap exists on this lane!");
				    invalidwallv.getChildren().addAll(invalidwalllabel);
				    invalidwall.getChildren().add(invalidwallv);
				    Scene invalidLaneException = new Scene(invalidwall);
				    exceptionStage.setScene(invalidLaneException);
				    exceptionStage.show();
	            	exceptionStage.alwaysOnTopProperty();
				}
				
			}
			
			
		});
        hLan2.setOnMouseClicked(new EventHandler<Event>(){

			@Override
			public void handle(Event event) {
				try {
					hBattle.purchaseWeapon(wCodeGet(),hLane2);
					hResources.setText("Resources:" + hBattle.getResourcesGathered());
					if(wCodeGet()==1)
						hwL2.getChildren().add(addBiercing()); 
					if(wCodeGet()==2)
						hwL2.getChildren().add(addSnibler()); 
					if(wCodeGet()==3)
						hwL2.getChildren().add(addSbread()); 
					if(wCodeGet()==4 && hwallFlag2 == false){
						hTrabGrid.add(addTrab(), 10, 2);
						hwallFlag2 = true;}
					else if(wCodeGet()==4 && hwallFlag2 == true){
						throw new IOException();
						}
					hWStage.hide();
					hWStage.setScene(hWScene);
				} catch (InsufficientResourcesException e) {
					Stage exceptionStage = new Stage();
				    Group insuffResourcesGroup = new Group();
				    VBox insuffResourcesV = new VBox();
				    Label insuffResourcesL = new Label("Not enough resources to buy weapon.");
				    insuffResourcesV.getChildren().addAll(insuffResourcesL);
				    insuffResourcesGroup.getChildren().add(insuffResourcesV);
				    Scene insuffResourcesException = new Scene(insuffResourcesGroup);
				    exceptionStage.setScene(insuffResourcesException);
				    exceptionStage.show();
	            	exceptionStage.alwaysOnTopProperty();
				    
				} catch (InvalidLaneException e) {
					Stage exceptionStage = new Stage();
				    Group invalidLaneGroup = new Group();
				    VBox invalidLaneV = new VBox();
				    Label invalidLaneLabel = new Label("Lane is inactive. \n Please select another lane");
				    invalidLaneV.getChildren().addAll(invalidLaneLabel);
				    invalidLaneGroup.getChildren().add(invalidLaneV);
				    Scene invalidLaneException = new Scene(invalidLaneGroup);
				    exceptionStage.setScene(invalidLaneException);
				    exceptionStage.show();
	            	exceptionStage.alwaysOnTopProperty();
				}
				catch (IOException e) {
					Stage exceptionStage = new Stage();
					Group invalidwall = new Group();
				    VBox invalidwallv = new VBox();
				    Label invalidwalllabel = new Label("Wall trap exists on this lane!");
				    invalidwallv.getChildren().addAll(invalidwalllabel);
				    invalidwall.getChildren().add(invalidwallv);
				    Scene invalidLaneException = new Scene(invalidwall);
				    exceptionStage.setScene(invalidLaneException);
				    exceptionStage.show();
	            	exceptionStage.alwaysOnTopProperty();
				}
				
			}
			
		});
        hLan3.setOnMouseClicked(new EventHandler<Event>(){

			@Override
			public void handle(Event event) {
				try {
					hBattle.purchaseWeapon(wCodeGet(),hLane3);
					hResources.setText("Resources:" + hBattle.getResourcesGathered());
					if(wCodeGet()==1)
						hwL3.getChildren().add(addBiercing()); 
					if(wCodeGet()==2)
						hwL3.getChildren().add(addSnibler()); 
					if(wCodeGet()==3)
						hwL3.getChildren().add(addSbread()); 
					if(wCodeGet()==4 && hwallFlag3 == false){
						hTrabGrid.add(addTrab(), 10, 3);
						hwallFlag3 = true;}
					else if(wCodeGet()==4 && hwallFlag3 == true){
						throw new IOException();}
					hWStage.hide();
					hWStage.setScene(hWScene);
				} catch (InsufficientResourcesException e) {
					Stage exceptionStage = new Stage();
				    Group insuffResourcesGroup = new Group();
				    VBox insuffResourcesV = new VBox();
				    Label insuffResourcesL = new Label("Not enough resources to buy weapon.");
				    insuffResourcesV.getChildren().addAll(insuffResourcesL);
				    insuffResourcesGroup.getChildren().add(insuffResourcesV);
				    Scene insuffResourcesException = new Scene(insuffResourcesGroup);
				    exceptionStage.setScene(insuffResourcesException);
				    exceptionStage.show();
	            	exceptionStage.alwaysOnTopProperty();
				    
				} catch (InvalidLaneException e) {
					Stage exceptionStage = new Stage();
				    Group invalidLaneGroup = new Group();
				    VBox invalidLaneV = new VBox();
				    Label invalidLaneLabel = new Label("Lane is inactive. \n Please select another lane");
				    invalidLaneV.getChildren().addAll(invalidLaneLabel);
				    invalidLaneGroup.getChildren().add(invalidLaneV);
				    Scene invalidLaneException = new Scene(invalidLaneGroup);
				    exceptionStage.setScene(invalidLaneException);
				    exceptionStage.show();
	            	exceptionStage.alwaysOnTopProperty();
				}
				catch (IOException e) {
					Stage exceptionStage = new Stage();
					Group invalidwall = new Group();
				    VBox invalidwallv = new VBox();
				    Label invalidwalllabel = new Label("Wall trap exists on this lane!");
				    invalidwallv.getChildren().addAll(invalidwalllabel);
				    invalidwall.getChildren().add(invalidwallv);
				    Scene invalidLaneException = new Scene(invalidwall);
				    exceptionStage.setScene(invalidLaneException);
				    exceptionStage.show();
	            	exceptionStage.alwaysOnTopProperty();
				}
				
			}
			
		});
        hLan4.setOnMouseClicked(new EventHandler<Event>(){

			@Override
			public void handle(Event event) {
				try {
					hBattle.purchaseWeapon(wCodeGet(),hLane4);
					hResources.setText("Resources:" + hBattle.getResourcesGathered());
					if(wCodeGet()==1)
						hwL4.getChildren().add(addBiercing()); 
					if(wCodeGet()==2)
						hwL4.getChildren().add(addSnibler()); 
					if(wCodeGet()==3)
						hwL4.getChildren().add(addSbread()); 
					if(wCodeGet()==4 && hwallFlag4 == false){
						hTrabGrid.add(addTrab(), 10, 4);
						hwallFlag4 = true;}
					else if(wCodeGet()==4 && hwallFlag4 == true){
						throw new IOException();}
					hWStage.hide();
					hWStage.setScene(hWScene);
				} catch (InsufficientResourcesException e) {
					Stage exceptionStage = new Stage();
				    Group insuffResourcesGroup = new Group();
				    VBox insuffResourcesV = new VBox();
				    Label insuffResourcesL = new Label("Not enough resources to buy weapon.");
				    insuffResourcesV.getChildren().addAll(insuffResourcesL);
				    insuffResourcesGroup.getChildren().add(insuffResourcesV);
				    Scene insuffResourcesException = new Scene(insuffResourcesGroup);
				    exceptionStage.setScene(insuffResourcesException);
				    exceptionStage.show();
	            	exceptionStage.alwaysOnTopProperty();
				    
				} catch (InvalidLaneException e) {
					Stage exceptionStage = new Stage();
				    Group invalidLaneGroup = new Group();
				    VBox invalidLaneV = new VBox();
				    Label invalidLaneLabel = new Label("Lane is inactive. \n Please select another lane");
				    invalidLaneV.getChildren().addAll(invalidLaneLabel);
				    invalidLaneGroup.getChildren().add(invalidLaneV);
				    Scene invalidLaneException = new Scene(invalidLaneGroup);
				    exceptionStage.setScene(invalidLaneException);
				    exceptionStage.show();
	            	exceptionStage.alwaysOnTopProperty();
				}
				catch (IOException e) {
					Stage exceptionStage = new Stage();
					Group invalidwall = new Group();
				    VBox invalidwallv = new VBox();
				    Label invalidwalllabel = new Label("Wall trap exists on this lane!");
				    invalidwallv.getChildren().addAll(invalidwalllabel);
				    invalidwall.getChildren().add(invalidwallv);
				    Scene invalidLaneException = new Scene(invalidwall);
				    exceptionStage.setScene(invalidLaneException);
				    exceptionStage.show();
	            	exceptionStage.alwaysOnTopProperty();
				}
				
			}
			
		});
        hLan5.setOnMouseClicked(new EventHandler<Event>(){

			@Override
			public void handle(Event event) {
				try {
					hBattle.purchaseWeapon(wCodeGet(),hLane5);
					hResources.setText("Resources:" + hBattle.getResourcesGathered());
					if(wCodeGet()==1)
						hwL5.getChildren().add(addBiercing()); 
					if(wCodeGet()==2)
						hwL5.getChildren().add(addSnibler()); 
					if(wCodeGet()==3)
						hwL5.getChildren().add(addSbread()); 
					if(wCodeGet()==4 && hwallFlag5 == false){
						hTrabGrid.add(addTrab(), 10, 5);
						hwallFlag5 = true;}
					else if(wCodeGet()==4 && hwallFlag5 == true){
						throw new IOException();}
					hWStage.hide();
					hWStage.setScene(hWScene);
				} catch (InsufficientResourcesException e) {
					Stage exceptionStage = new Stage();
				    Group insuffResourcesGroup = new Group();
				    VBox insuffResourcesV = new VBox();
				    Label insuffResourcesL = new Label("Not enough resources to buy weapon.");
				    insuffResourcesV.getChildren().addAll(insuffResourcesL);
				    insuffResourcesGroup.getChildren().add(insuffResourcesV);
				    Scene insuffResourcesException = new Scene(insuffResourcesGroup);
				    exceptionStage.setScene(insuffResourcesException);
				    exceptionStage.show();
	            	exceptionStage.alwaysOnTopProperty();
				    
				} catch (InvalidLaneException e) {
					Stage exceptionStage = new Stage();
				    Group invalidLaneGroup = new Group();
				    VBox invalidLaneV = new VBox();
				    Label invalidLaneLabel = new Label("Lane is inactive. \n Please select another lane");
				    invalidLaneV.getChildren().addAll(invalidLaneLabel);
				    invalidLaneGroup.getChildren().add(invalidLaneV);
				    Scene invalidLaneException = new Scene(invalidLaneGroup);
				    exceptionStage.setScene(invalidLaneException);
				    exceptionStage.show();
	            	exceptionStage.alwaysOnTopProperty();
				}
				catch (IOException e) {
					Stage exceptionStage = new Stage();
					Group invalidwall = new Group();
				    VBox invalidwallv = new VBox();
				    Label invalidwalllabel = new Label("Wall trap exists on this lane!");
				    invalidwallv.getChildren().addAll(invalidwalllabel);
				    invalidwall.getChildren().add(invalidwallv);
				    Scene invalidLaneException = new Scene(invalidwall);
				    exceptionStage.setScene(invalidLaneException);
				    exceptionStage.show();
	            	exceptionStage.alwaysOnTopProperty();
				}
				
			}
			
		});
        hpassTurnButton.setScaleX(1.75);
        hpassTurnButton.setScaleY(1.75);
        hpassTurnButton.setTranslateX(500); 
        hpassTurnButton.setOnMouseClicked(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
               hBattle.passTurn();
             }
           });
      //HBox for hPuma
        HBox hPuma=new HBox(); 
        Label hScore = new Label("Score: " + hBattle.getScore() + "      ");
        Label hTurn = new Label("Turn: " + hBattle.getNumberOfTurns()+ "      ");
        Label hPhase = new Label("Phase: " + hBattle.getBattlePhase()+ "      ");
       
      //HBox for hResources and hWeapon Shop
        
        hrWeapon.setTranslateY(1045);
        hrWeapon.setTranslateX(1000);
        hScore.setFont(new Font(25));
        hTurn.setFont(new Font(25));
        hPhase.setFont(new Font(25));
        hPuma.getChildren().addAll(hScore,hTurn,hPhase);
        
        //Vbox for all hardmode rectangles
        VBox hAll = new VBox();
        //HBoxes for walls and lanes
        HBox hComb1 = new HBox();
        HBox hComb2 = new HBox();
        HBox hComb3 = new HBox();
        HBox hComb4 = new HBox();
        HBox hComb5 = new HBox();
        //Rectangles for walls
        Rectangle wallRectHard1 = new Rectangle(250, 136);
        wallRectHard1.setFill(Color.ANTIQUEWHITE);
        wallRectHard1.setStroke(Color.BURLYWOOD); // Outline color
        wallRectHard1.setStrokeWidth(2); // Outline width

        Rectangle wallRectHard2 = new Rectangle(250, 136);
        wallRectHard2.setFill(Color.ANTIQUEWHITE);
        wallRectHard2.setStroke(Color.BURLYWOOD); // Outline color
        wallRectHard2.setStrokeWidth(2); // Outline width
        
        Rectangle wallRectHard3 = new Rectangle(250, 136);
        wallRectHard3.setFill(Color.ANTIQUEWHITE);
        wallRectHard3.setStroke(Color.BURLYWOOD); // Outline color
        wallRectHard3.setStrokeWidth(2); // Outline width
        
        Rectangle wallRectHard4 = new Rectangle(250, 136);
        wallRectHard4.setFill(Color.ANTIQUEWHITE);
        wallRectHard4.setStroke(Color.BURLYWOOD); // Outline color
        wallRectHard4.setStrokeWidth(2); // Outline width
        
        Rectangle wallRectHard5 = new Rectangle(250, 136);
        wallRectHard5.setFill(Color.ANTIQUEWHITE);
        wallRectHard5.setStroke(Color.BURLYWOOD); // Outline color
        wallRectHard5.setStrokeWidth(2); // Outline width
        //Rectangles for Lanes
        Rectangle laneRectHard1 = new Rectangle(1700, 136); // Lane width and height
        laneRectHard1.setFill(Color.ANTIQUEWHITE);
        laneRectHard1.setStroke(Color.BLACK); // Outline color
        laneRectHard1.setStrokeWidth(2); // Outline width
        
        Rectangle laneRectHard2 = new Rectangle(1700, 136); // Lane width and height
        laneRectHard2.setFill(Color.ANTIQUEWHITE);
        laneRectHard2.setStroke(Color.BLACK); // Outline color
        laneRectHard2.setStrokeWidth(2); // Outline width
        
        Rectangle laneRectHard3 = new Rectangle(1700, 136); // Lane width and height
        laneRectHard3.setFill(Color.ANTIQUEWHITE);
        laneRectHard3.setStroke(Color.BLACK); // Outline color
        laneRectHard3.setStrokeWidth(2); // Outline width
        
        Rectangle laneRectHard4 = new Rectangle(1700, 136); // Lane width and height
        laneRectHard4.setFill(Color.ANTIQUEWHITE);
        laneRectHard4.setStroke(Color.BLACK); // Outline color
        laneRectHard4.setStrokeWidth(2); // Outline width
        
        Rectangle laneRectHard5 = new Rectangle(1700, 136); // Lane width and height
        laneRectHard5.setFill(Color.ANTIQUEWHITE);
        laneRectHard5.setStroke(Color.BLACK); // Outline color
        laneRectHard5.setStrokeWidth(2); // Outline width

        //Adding walls and lanes to HBoxes
        hComb1.getChildren().addAll(wallRectHard1, laneRectHard1);
        hComb2.getChildren().addAll(wallRectHard2, laneRectHard2);
        hComb3.getChildren().addAll(wallRectHard3, laneRectHard3);
        hComb4.getChildren().addAll(wallRectHard4, laneRectHard4);
        hComb5.getChildren().addAll(wallRectHard5, laneRectHard5);
        
        Rectangle hLowerRectangle= new Rectangle(1920,55);
        hLowerRectangle.setFill(Color.BURLYWOOD);
        hLowerRectangle.setStroke(Color.BLACK);
        hLowerRectangle.setStrokeWidth(2);
        Rectangle hUpperRectangle=new Rectangle(1920,55);  
        hUpperRectangle.setFill(Color.BURLYWOOD);
        hUpperRectangle.setStroke(Color.BLACK);
        hUpperRectangle.setStrokeWidth(2);
        Rectangle hLane1Weapon= new Rectangle(1920,55);
        hLane1Weapon.setFill(Color.BURLYWOOD);
        hLane1Weapon.setStroke(Color.BLACK);
        hLane1Weapon.setStrokeWidth(2);
        Rectangle hLane2Weapon=new Rectangle(1920,55); 
        hLane2Weapon.setFill(Color.BURLYWOOD);
        hLane2Weapon.setStroke(Color.BLACK);
        hLane2Weapon.setStrokeWidth(2);
        Rectangle hLane3Weapon=new Rectangle(1920,55); 
        hLane3Weapon.setFill(Color.BURLYWOOD);
        hLane3Weapon.setStroke(Color.BLACK);
        hLane3Weapon.setStrokeWidth(2);
        Rectangle hLane4Weapon=new Rectangle(1920,55); 
        hLane4Weapon.setFill(Color.BURLYWOOD);
        hLane4Weapon.setStroke(Color.BLACK);
        hLane4Weapon.setStrokeWidth(2);
        Rectangle hLane5Weapon=new Rectangle(1920,55); 
        hLane5Weapon.setFill(Color.BURLYWOOD);
        hLane5Weapon.setStroke(Color.BLACK);
        hLane5Weapon.setStrokeWidth(2);
        
        //Attributes
        VBox hAttributes=new VBox(); 

        
        Label hW1hp = new Label("HP: " + Lane1.getLaneWall().getCurrentHealth() + "");
        hW1hp.setTranslateY(110);
        hW1hp.setFont(new Font(16));
        Label hW2hp = new Label("HP: " + Lane2.getLaneWall().getCurrentHealth() + "");
        hW2hp.setTranslateY(260);
        hW2hp.setFont(new Font(16));
        Label hW3hp = new Label("HP: " + Lane3.getLaneWall().getCurrentHealth() + "");
        hW3hp.setTranslateY(400);
        hW3hp.setFont(new Font(16));
        Label hW4hp = new Label("HP: " + Lane1.getLaneWall().getCurrentHealth() + "");
        hW4hp.setTranslateY(550);
        hW4hp.setFont(new Font(16));
        Label hW5hp = new Label("HP: " + Lane2.getLaneWall().getCurrentHealth() + "");
        hW5hp.setTranslateY(700);
        hW5hp.setFont(new Font(16));
        


        
        Label hDL1 = new Label("Danger Level: " + hLane1.getDangerLevel() + "");
        hDL1.setTranslateY(111);
        hDL1.setFont(new Font(16));
        hDL1.setTextFill(Color.DARKRED);
        Label hDL2 = new Label("Danger Level: " + hLane2.getDangerLevel() + "");
        hDL2.setTranslateY(261);
        hDL2.setFont(new Font(16));
        hDL2.setTextFill(Color.DARKRED);
        Label hDL3 = new Label("Danger Level: " + hLane3.getDangerLevel() + "");
        hDL3.setTranslateY(401);
        hDL3.setFont(new Font(16));
        hDL3.setTextFill(Color.DARKRED);
        Label hDL4 = new Label("Danger Level: " + hLane4.getDangerLevel() + "");
        hDL4.setTranslateY(551);
        hDL4.setFont(new Font(16));
        hDL4.setTextFill(Color.DARKRED);
        Label hDL5 = new Label("Danger Level: " + hLane5.getDangerLevel() + "");
        hDL5.setTranslateY(701);
        hDL5.setFont(new Font(16));
        hDL5.setTextFill(Color.DARKRED);
        
        


        hAttributes.getChildren().addAll(hW1hp,hDL1,hW2hp,hDL2,hW3hp,hDL3,hW4hp,hDL4,hW5hp,hDL5);
        //Adding all rectangles & Hboxes to VBox
        hAll.getChildren().addAll(hUpperRectangle,hLane1Weapon,hComb1,hLane2Weapon,hComb2,hLane3Weapon,hComb3,hLane4Weapon,hComb4,hLane5Weapon,hComb5,hLowerRectangle);
        hardroot.getChildren().addAll(hAll,hAttributes, hPuma, hrWeapon, hTrabGrid, hwL1, hwL2, hwL3, hwL4, hwL5);
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		///Lose Page
		//VBox for First Three labels
		VBox losing= new VBox(); 
		Label lost= new Label("You Lost");
		Label bLuck= new Label("Better Luck Next Time"); 
		Label showScore= new Label("Your Score:" + battle.getScore()); 
		losing.getChildren().addAll(lost,bLuck,showScore); 
		//HBox for Restart and view Lanes
		HBox loseButtons= new HBox(); 
		Button restartGame= new Button("Restart");
		Button viewLanes= new Button("View Lanes"); 
		loseButtons.getChildren().addAll(restartGame,viewLanes); 
		//VBox for Both
		VBox gameLost=new VBox(); 
		gameLost.getChildren().addAll(losing,loseButtons); 
		//Scene For Lost Screen
		Scene endGame= new Scene(gameLost); 
		//Handlers for Lose buttons
		restartGame.setOnMouseClicked(new EventHandler<Event>(){

			@Override
			public void handle(Event event) {
				stage.setScene(start);
				
			}
		
		});
		viewLanes.setOnMouseClicked(new EventHandler<Event>(){

			@Override
			public void handle(Event event) {
				if(getDifficulty()=="E")
					stage.setScene(sLane);
				
				
			}
			
		});
		if (battle.isGameOver()){
			stage.setScene(endGame); 
		}
			    
		
        
	}
    
    public static void removeButtons(){
    	hpassTurnButton.setDisable(true);
    	hweaponShopButton.setDisable(true);
    	passTurnButton.setDisable(true);
    	weaponShopButton.setDisable(true);
    }
    public static void enableButtons(){
    	hpassTurnButton.setDisable(false);
    	hweaponShopButton.setDisable(false);
    	passTurnButton.setDisable(false);
    	weaponShopButton.setDisable(false);
    }
    public void wCodeSet(int wCode){
		this.wCode = wCode;
	}
    int wCode;
    public int wCodeGet(){
    	return wCode;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    public Rectangle addBiercing(){
    	Rectangle Biercing = new Rectangle(20, 20);
    	Biercing.setFill(Color.CADETBLUE);
    	return Biercing;
    	
    }
    public Rectangle addSnibler(){
    	Rectangle Snibler = new Rectangle(20, 20);
    	Snibler.setFill(Color.THISTLE);
    	return Snibler;
    }
    public Rectangle addSbread(){
    	Rectangle Sbread = new Rectangle(20, 20);
    	Sbread.setFill(Color.DARKGRAY);
    	return Sbread;
    }
    public Rectangle addTrab(){
    	Rectangle Trab = new Rectangle(20, 20);
    	Trab.setFill(Color.CHARTREUSE);
    	return Trab;
    }
}

