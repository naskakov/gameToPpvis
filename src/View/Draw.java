package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import Controller.Controller;

public class Draw extends JPanel 
{	
	 Controller controller;
	 MainFrame mainFrame;
	 boolean rectangle = false;
	 boolean circle = false;
	 boolean oval = false;
	 Color colorForClothes;
	
	 public Draw(Controller controller,MainFrame mainFrame)
	    {
	        this.controller=controller;
	        this.mainFrame = mainFrame;
	    }
	 
	 public void paintComponent(Graphics g)
	    {
		 	super.paintComponent(g);
		 	drawPlayer(g);
		 	drawRectangle(g);
		 	drawOval(g);
		 	drawOval_1(g);
		 	Color colorForVisitor = new Color(72, 61, 139);
	        g.setColor(colorForVisitor);

	        if (controller.a <= 3) {
	        	g.fillOval(controller.visitor.x, controller.visitor.y, controller.visitor.w, controller.visitor.h);
	        } else if (controller.a > 3 && controller.a <= 6) {
	        	g.fillOval(controller.visitor.x, controller.visitor.y, controller.visitor.w + 50, controller.visitor.h);
	        } else {
	        	g.fillRect(controller.visitor.x, controller.visitor.y, controller.visitor.w, controller.visitor.h);
	        }
	        drawCount(g);
	        
	    }
	 
	 public void drawPlayer(Graphics g) {
		 g.setColor(Color.BLACK);
		 if ( controller.player.x + controller.player.w >= 20 &&
				 controller.player.x <= 20 + 100 &&
				 controller.player.y + controller.player.h >= 10 &&
				 controller.player.y <= 10 + 100) {
			 g.setColor(Color.BLUE);
			 rectangle = true;
			 oval = false;
			 circle = false;
		 } else if( controller.player.x + controller.player.w >= 350 &&
				 controller.player.x <= 350 + 100 &&
				 controller.player.y + controller.player.h >= 10 &&
				 controller.player.y <= 10 + 100) {
			 g.setColor(Color.BLUE);
			 circle = true;
			 rectangle = false;
			 oval = false;
		 }else if ( controller.player.x + controller.player.w >= 640 &&
				 controller.player.x <= 640 + 150 &&
				 controller.player.y + controller.player.h >= 10 &&
				 controller.player.y <= 10 + 100) {
			 g.setColor(Color.BLUE);
			 oval = true;
			 rectangle = false;
			 circle = false;
		 }
	        g.fillRect(controller.player.x, controller.player.y, controller.player.w, controller.player.h);
	      if ( controller.a > 6 && rectangle == true && controller.player.x + controller.player.w  >= controller.visitor.x &&
	    		  controller.player.x <= controller.visitor.x + controller.visitor.w &&
					controller.player.y + controller.player.h >= controller.visitor.y &&
					controller.player.y <= controller.visitor.y + controller.visitor.h) {
				 	controller.count++;
				 	g.setColor(Color.BLUE);
				 	rectangle = false;
			 }else if ( controller.a <= 6 && controller.a >3 && oval == true && controller.player.x + controller.player.w  >= controller.visitor.x &&
	    		  controller.player.x <= controller.visitor.x + controller.visitor.w &&
					controller.player.y + controller.player.h >= controller.visitor.y &&
					controller.player.y <= controller.visitor.y + controller.visitor.h) {
				 	controller.count++;
				 	g.setColor(Color.BLUE);
				 	oval = false;
			 }else if ( controller.a <= 3 && circle == true && controller.player.x + controller.player.w  >= controller.visitor.x &&
	    		  controller.player.x <= controller.visitor.x + controller.visitor.w &&
					controller.player.y + controller.player.h >= controller.visitor.y &&
					controller.player.y <= controller.visitor.y + controller.visitor.h) {
				 	controller.count++;
				 	g.setColor(Color.BLUE);
				 	circle = false;
			 }
	        controller.player.move();
	        mainFrame.frame.repaint();   
	 }
	 
	 public void drawCount(Graphics g) {
		    String score = String.valueOf(controller.count);
		    String scoreFinish = String.valueOf(controller.count - controller.oldCount);
	        Font font = new Font("Tahoma", Font.BOLD|Font.ITALIC, 20);
	        g.setColor(Color.BLACK);
	        g.setFont(font);
	        g.drawString("Очки: " + score, 10, 530);
	        g.drawString("Очки до проигрыша: " + scoreFinish,10, 550);
	 }
	 
	 public void drawRectangle(Graphics g) {
		 g.setColor(controller.colorForClothes);
	     g.fillRect(20, 10, 100, 100);
	 }
	 
	 public void drawOval(Graphics g) {
		 g.setColor(controller.colorForClothes);
	     g.fillOval(350, 10, 100, 100);
	 }
	 
	 public void drawOval_1(Graphics g) {
		 g.setColor(controller.colorForClothes);
	     g.fillOval(620, 10, 150, 100);
	 }
	 
	
	
}
