package game.gui;


import game.engine.Battle;
import game.engine.lanes.Lane;
import game.engine.weapons.PiercingCannon;
import game.engine.weapons.SniperCannon;
import game.engine.weapons.VolleySpreadCannon;
import game.engine.weapons.WallTrap;

import java.io.File;

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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import game.gui.StartPage; 
public class WeaponShopGUI extends Application{
	Stage WStage;
	public WeaponShopGUI(){
		Stage WStage= new Stage();
		Group weaponRoot = new Group(); 
		//Label for weapon shop
		Label title= new Label("Click on a weapon for info");
		
		//HBox for first two Weapons
		HBox row1=new HBox();
		// Rectangle first Two Weapons
		Rectangle snibler= new Rectangle(300,200);
		Rectangle biercing= new Rectangle(300,200);
		row1.getChildren().addAll(snibler,biercing);
		//HBox for first buy
		HBox buy1=new HBox(); 
		Button buySnibler= new Button("Buy");
		Button buyBiercing= new Button("Buy");
		//HBox for second two Weapons
		buy1.getChildren().addAll(buySnibler,buyBiercing); 
		HBox row2=new HBox(); 
		//Rectangle for Second Two Weapons
		Rectangle volleySbread= new Rectangle(300,200);
		Rectangle wallTrab= new Rectangle(300,200);
		row2.getChildren().addAll(volleySbread,wallTrab); 
		//HBox for second buy
		HBox buy2=new HBox(); 
		Button buyVolley= new Button("Buy");
		Button buyTrab= new Button("Buy");
		buy2.getChildren().addAll(buyVolley,buyTrab); 
		//VBox be containing evrything
		VBox all=new VBox(); 
		all.getChildren().addAll(title,row1,buy1,row2,buy2);
		
		//Vbox for Each Weapon
		VBox sniblerBox= new VBox(); 
		//Label for Name Snibler
		Label esmySnibler= new Label("Sniper Cannon"); 
		//Label for Description
		SniperCannon sniblerBot= new SniperCannon(35); 
		Label sniblerDisc= new Label("Shoots Closest Target in Lane" +"/n Damage: "+ sniblerBot.getDamage());
		//HBox for buy and Price
		HBox hSnibler= new HBox();
		Label sniblerPrice = new Label("25"); 
		Button sniblerReturn= new Button("Return"); 
		hSnibler.getChildren().addAll(sniblerPrice,sniblerReturn);
		sniblerBox.getChildren().addAll(esmySnibler,sniblerDisc,hSnibler);
		//Vbox for Each Weapon
		VBox biercingBox= new VBox(); 
		//Label for Name Biercing
		Label esmyBiercing= new Label("Piercing Cannon"); 
		//Label for Description
		PiercingCannon BiercingBot= new PiercingCannon(10); 
		Label biercingDisc= new Label("Shoots Closest 5 Targets in Lane" +"/n Damage: "+ BiercingBot.getDamage());
		//HBox for buy and Price
		HBox hBiercing=new HBox();
		Label biercingPrice = new Label("25"); 
		Button biercingReturn= new Button("Return"); 
		hBiercing.getChildren().addAll(biercingPrice,biercingReturn);
		biercingBox.getChildren().addAll(esmyBiercing,biercingDisc,hBiercing);
		//Vbox for Each Weapon
		VBox volleySbreadBox= new VBox(); 
		//Label for Name volleySbread
		Label esmySbread= new Label("Volley Spread Cannon"); 
		//Label for Description
		VolleySpreadCannon sBreadBot= new VolleySpreadCannon(5, 20, 50); 
		Label sbreadDisc= new Label("Shoots All Titans Within Range: "+ sBreadBot.getMinRange() + sBreadBot.getMaxRange() +"/n Damage: "+ sBreadBot.getDamage());
		//HBox for buy and Price
		HBox hSbread= new HBox(); 
		Label sBreadPrice = new Label("100"); 
		Button sBreadReturn= new Button("Return"); 
		hSbread.getChildren().addAll(sBreadPrice,sBreadReturn);
		volleySbreadBox.getChildren().addAll(esmySbread,sbreadDisc,hSbread);
		//Vbox for Each Weapon
		VBox trabBox= new VBox(); 
		//Label for Name Wall Trap
		Label esmyTrab= new Label("Wall Trap"); 
		//Label for Description
		WallTrap trabBot= new WallTrap(100); 
		Label trabDisc= new Label("Attacks one Titan on the Wall" +"/n Damage: "+ trabBot.getDamage());
		//HBox for buy and Price
		HBox hTrab= new HBox(); 
		Label trabPrice = new Label("75"); 
		Button trabReturn= new Button("Return"); 
		hTrab.getChildren().addAll(trabPrice,trabReturn);
		trabBox.getChildren().addAll(esmyTrab,trabDisc,hTrab);
		Scene infoSnibler= new Scene(sniblerBox);
		Scene infoBiercing=new Scene(biercingBox); 
		Scene infoVolley=new Scene(volleySbreadBox); 
		Scene infoTrab=new Scene(trabBox); 
		Scene WScene=new Scene(weaponRoot); 
		weaponRoot.getChildren().add(all);
		WStage.show();
		WStage.setScene(WScene); 
		
		
	}
	public void start(Stage primaryStage) throws Exception {
		WeaponShopGUI W = new WeaponShopGUI();
		
		
		
	}

	

}
