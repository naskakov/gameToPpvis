package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.Controller;

public class BeginFrame {
	JFrame beginFrame;
	JComboBox comboBoxForColor;
	JComboBox comboBox;
	JPanel panel;
	Controller controller;
	public Color color�lothes;
	
	public BeginFrame(Controller controller) {
		this.controller = controller;
		beginFrame = new JFrame("Start");
		beginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		String[] items = { "������ �������","���������� �������","������� �������" };
    	comboBox = new JComboBox(items);
    	comboBox.setSelectedItem(null);
    	
    	JLabel labelForLevel = new JLabel("��������� ������:");
    	Font bigFont = new Font("serif", Font.BOLD, 28);
    	labelForLevel.setFont(bigFont);
    	
    	comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
            	 if (e.getStateChange() == ItemEvent.SELECTED) {
                     String item = e.getItem().toString();
            	if(item.equals("������ �������")) {
            		controller.timeForLevel = 9;
            	}else if(item.equals("���������� �������")){
            		controller.timeForLevel = 7;
            	}else {
            		controller.timeForLevel = 1;
            	}
            	 }
            }
        });
    	
    	JLabel labelForColor = new JLabel("����:");
    	labelForColor.setFont(bigFont);
    	
    	String[] colors = { "�������","�������","������","�������", "���������" };
    	comboBoxForColor = new JComboBox(colors);
    	comboBoxForColor.setSelectedItem(null);
    	
    	comboBoxForColor.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
            	 if (e.getStateChange() == ItemEvent.SELECTED) {
                     String item = e.getItem().toString();
            	if(item.equals("�������")) {
            		Color color�lothes = new Color(0,255,255);
            		controller.colorForClothes = color�lothes;
            	}else if(item.equals("�������")){
            		Color color�lothes = new Color(255, 105, 180);
            		controller.colorForClothes = color�lothes;
            	}else if(item.equals("�������")){
            		Color color�lothes = new Color(0,100,0);
            		controller.colorForClothes = color�lothes;
            	}else if(item.equals("���������")){
            		Color color�lothes = new Color(0, 206, 209);
            		controller.colorForClothes = color�lothes;
            	}else {
            		Color color�lothes = new Color(255,251,0);
            		controller.colorForClothes = color�lothes;
            	}
            	 }
            }
        });
    	
    	JButton button = new JButton("�����");
    	beginFrame.getContentPane().add(BorderLayout.SOUTH, button);
    	button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				beginFrame.setVisible(false); 
				beginFrame.dispose();
				MainFrame mainFrame = new MainFrame(controller);
				controller.MyTimer();
				
				
			}
		});
    	
    	panel.add(labelForLevel);
    	panel.add(comboBox);
    	panel.add(labelForColor);
    	panel.add(comboBoxForColor);
    	
    	beginFrame.getContentPane().add(BorderLayout.NORTH, panel);
		
		beginFrame.setSize(400, 400);
		beginFrame.setLocationRelativeTo(null);
		beginFrame.setVisible(true);
		
	}
}
