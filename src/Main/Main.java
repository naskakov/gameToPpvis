package Main;

import Controller.Controller;
import View.BeginFrame;
import View.MainFrame;

public class Main {

	public static void main(String[] args) {
		
		Controller controller = new Controller();
        BeginFrame frame = new BeginFrame(controller);
	}

}
