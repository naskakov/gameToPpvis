package Controller;

import java.awt.Color;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import Model.Player;
import Model.Visitor;

public class Controller {
	public Player player;
	public Visitor visitor;
	public int a;
	public int oldCount = -1;
	public int count = 0;
	public int timeForLevel = 0;
	public Color colorForClothes;
	
	public Controller(){
		player = new Player();
		visitor = new Visitor();
	}
	
	public void MyTimer() {
	Timer timer = new Timer();
	timer.schedule(new TimerTask() {
		  @Override
		  public void run() {
			  if(oldCount < count) {
			  Random gen = new Random();
		      a = gen.nextInt(10);
		      oldCount++;
			  }else {
				  cancel();
				  JOptionPane.showMessageDialog(null, "Game over");
			  }	  
		  }
		}, 100, timeForLevel*1000 );
	}
}
