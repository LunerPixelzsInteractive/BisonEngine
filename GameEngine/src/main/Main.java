package main;

import org.lwjgl.glfw.GLFW;

import engine.io.Window;

public class Main {

	public static void main(String[] args) {
		 final int WIDTH = 800, HEIGHT = 600, FPS = 60;
		
		 Window window = new Window(WIDTH, HEIGHT, FPS, "LWJGL 3");
		 window.create();

		 while(!window.closed()) {
			if(window.isUpdating()) {
				window.update();
				if(window.isKeyPressed(GLFW.GLFW_KEY_A)) System.out.println("Pressed A");
				if(window.isKeyReleased(GLFW.GLFW_KEY_A)) System.out.println("Released A");
				if(window.isMousePressed(GLFW.GLFW_MOUSE_BUTTON_LEFT)) System.out.println("Pressed mouse at " + window.getMouseX()+ ":" + window.getMouseY());
				if(window.isMouseReleased(GLFW.GLFW_MOUSE_BUTTON_LEFT)) System.out.println("Released mouse at " + window.getMouseX()+ ":" + window.getMouseY());

				window.swapBuffers();
				
			}
		 }
	}

}
