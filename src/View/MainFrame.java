package View;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.Controller;
import Controller.Input;
public class MainFrame {
    JFrame frame;
    Controller controller;

    public MainFrame(Controller controller) {
    	
    	this.controller=controller;
    	
        frame = new JFrame("Studio");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(new Input(controller));
        frame.add(new Draw(controller,this));
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
}
