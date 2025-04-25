package game;

import org.lwjgl.glfw.GLFW;

import engine.io.Window;

public class Main {

	public static final int WIDTH = 800, HEIGHT = 600, FPS = 60;
	public static Window window = new Window(WIDTH, HEIGHT, FPS, "Debug");
	
	public static void main(String[] args) {
		window.create(); // Creates window
		window.setBackgroundColor(1.0f, 0.0f, 0.0f); //sets windows color
		
		//game loop
		while(!window.closed()) {
			if(window.isUpdating()) {
				window.update();
				//Put game loop code in here
				if(window.isKeyPressed(GLFW.GLFW_KEY_G)) System.out.println("Input handler is working:)");//You can remove this if you want it's just to test the input handler
				
				window.swapBuffers();
			}
		}
		
		window.stop();
	}

}
