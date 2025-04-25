package main;

import org.joml.Vector3f;
import org.lwjgl.glfw.GLFW; 

import engine.io.Window;
import engine.render.Renderer;
import engine.render.models.Model;
import engine.render.models.ModelEntity;
import engine.render.models.TexturedModel;
import engine.render.models.UntexturedModel;
import engine.shaders.BasicShader;

public class Main {
	
	public static final int WIDTH = 800, HEIGHT = 600, FPS = 60;
	public static Window window = new Window(WIDTH, HEIGHT, FPS, "Debug");
	public static BasicShader shader = new BasicShader();
	public static Renderer renderer = new Renderer(shader);
	
	public static void main(String[] args) {
		 window.create();
		 window.setBackgroundColor(1.0f, 0.0f, 0.0f);
		 
		 shader.create();
		 
		 TexturedModel model = new TexturedModel(new float[] {
				 -0.5f, 0.5f, 0,  //Top Left 0
				  0.5f, 0.5f, 0,  //Top Right 1
				  -0.5f, -0.5f, 0,// Bottom Left 2
				  0.5f, -0.5f, 0, //Bottom Right 3
				  
		 }, new float[] {
				0, 0,
				1, 0,
				0, 1,
				1, 1
				 
		 },new int[] {
			0, 2, 1,
			1, 2, 3
				 
		 }, "Image.png");
		 
		 ModelEntity entity = new ModelEntity(model, new Vector3f(0, 0, 0), new Vector3f(0, 0, 0), new Vector3f(1, 0.5f, 1));

		 while(!window.closed()) {
			if(window.isUpdating()) {
				
				window.update();
				
				if(window.isKeyDown(GLFW.GLFW_KEY_Q)) entity.addRotationY(-0.05f);
				if(window.isKeyDown(GLFW.GLFW_KEY_E)) entity.addRotationY(0.05f);
				if(window.isKeyDown(GLFW.GLFW_KEY_A)) entity.addPositionX(-0.007f);
				if(window.isKeyDown(GLFW.GLFW_KEY_D)) entity.addPositionX(0.007f);
				if(window.isKeyDown(GLFW.GLFW_KEY_W)) entity.addPositionY(0.007f);
				if(window.isKeyDown(GLFW.GLFW_KEY_S)) entity.addPositionY(-0.007f);
				
				shader.bind();
				renderer.renderModelEntity(entity);
				
				window.swapBuffers();
				
			}
		 }
		 
		 shader.remove();
		 //model.remove();
		 window.stop();
		 
	}

}
