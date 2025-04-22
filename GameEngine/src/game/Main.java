package game;

import engine.io.Window;

public class Main {

	//Window Settings
	public static final int WIDTH = 800, HEIGHT = 600, FPS = 60;
	public static Window window = new Window(WIDTH, HEIGHT, FPS, "Debug");
	
	public static void main(String[] args) {
		window.create();//creates window
		window.setBackgroundColor(0.0f, 0.0f, 0.0f); //set windows background color(r, g, b)

		//game loop
		while(!window.closed()) {
			if(window.isUpdating()) {
				
				window.update();
				
				//put your game loop code in here
				
				window.swapBuffers();
			}
			
		}
	}

}
