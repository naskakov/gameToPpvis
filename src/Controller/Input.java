package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import Model.Player;

public class Input  extends KeyAdapter {
	public Player player;
    public Controller controller;
    
    public Input(Controller controller) {
        this.controller = controller;
        player = controller.player;
    }
	
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == 68 || key == KeyEvent.VK_RIGHT) {
            player.right=true;
        }
        if (key == 65 || key == KeyEvent.VK_LEFT) {
            player.left=true;
        }
        if (key == 87 || key == KeyEvent.VK_UP) {
            player.up=true;
        }
        if (key == 83 || key == KeyEvent.VK_DOWN) {
            player.down=true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == 68 || key == KeyEvent.VK_RIGHT) {
            player.right = false;
        }
        if (key == 65 || key == KeyEvent.VK_LEFT) {
            player.left = false;
        }
        if (key == 87 || key == KeyEvent.VK_UP) {
            player.up = false;
        }
        if (key == 83 || key == KeyEvent.VK_DOWN) {
            player.down = false;
        }
    }
    
}
