package main;

import org.lwjgl.glfw.GLFW;

import engine.io.Window;
import engine.render.Model;
import engine.render.Renderer;

public class Main {
	
	public static final int WIDTH = 800, HEIGHT = 600, FPS = 60;
	public static Window window = new Window(WIDTH, HEIGHT, FPS, "LWJGL 3");
	public static Renderer renderer = new Renderer();

	public static void main(String[] args) {
		 window.create();
		 window.setBackgroundColor(1.0f, 0.0f, 0.0f);
		 
		 Model model = new Model(new float[] {
				 -0.5f, 0.5f, 0.0f,  //Top Left 0
				  0.5f, 0.5f, 0.0f,  //Top Right 1
				  -0.5f, -0.5f, 0.0f,// Bottom Left 2
				  0.5f, -0.5f, 0.0f, //Bottom Right 3
				  
		 }, new int[] {
			0, 1, 2,
			2, 3, 1
				 
		 });
		 model.create();

		 while(!window.closed()) {
			if(window.isUpdating()) {
				
				window.update();
				
				renderer.renderModel(model);
				
				window.swapBuffers();
				
			}
		 }
		 
		 window.stop();
		 model.remove();
		 
	}

}
