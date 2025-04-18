package main;

import org.lwjgl.glfw.GLFW;

import engine.io.Window;
import engine.render.Model;
import engine.render.Renderer;
import engine.shaders.BasicShader;

public class Main {
	
	public static final int WIDTH = 800, HEIGHT = 600, FPS = 60;
	public static Window window = new Window(WIDTH, HEIGHT, FPS, "Debug");
	public static Renderer renderer = new Renderer();
	public static BasicShader shader = new BasicShader();

	public static void main(String[] args) {
		 window.create();
		 window.setBackgroundColor(1.0f, 0.0f, 0.0f);
		 
		 shader.create();
		 
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
				
				shader.bind();
				renderer.renderModel(model);
				
				window.swapBuffers();
				
			}
		 }
		 
		 shader.remove();
		 model.remove();
		 window.stop();
		 
	}

}
