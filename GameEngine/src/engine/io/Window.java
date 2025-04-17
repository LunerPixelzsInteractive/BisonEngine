package engine.io;

import java.nio.DoubleBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL11;

public class Window {
	private int width, height;
	private String title;
	
	private long window;
	private long monitor;
	
	private boolean[] Keys = new boolean[GLFW.GLFW_KEY_LAST];
	private boolean[] mouseButtons = new boolean[GLFW.GLFW_MOUSE_BUTTON_LAST];

	public Window(int width, int height, String title) {
		
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	public void create() {
		 if(!GLFW.glfwInit()) {
			 System.err.println("Error: GLFW could not initialized");
			 System.exit(-1);
			 
		 }
		 
		GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_FALSE);
		window = GLFW.glfwCreateWindow(width, height, title, 0, 0);
		monitor = GLFW.glfwGetPrimaryMonitor();
		
		if(window == 0) {
			 System.err.println("Error: Window could not be created");
			 System.exit(-1);
			
		}
		
		GLFWVidMode videoMode = GLFW.glfwGetVideoMode(monitor);
		GLFW.glfwSetWindowPos(window, (videoMode.width() - width) / 2, (videoMode.height() - height) / 2);
		
		GLFW.glfwShowWindow(window);
	}
	
	public void update() {
		for(int i = 0; i < GLFW.GLFW_KEY_LAST; i++) Keys[i] = isKeyDown(i);
		for(int i = 0; i < GLFW.GLFW_MOUSE_BUTTON_LAST; i++) mouseButtons[i] = isMouseDown(i);
		
		GLFW.glfwPollEvents();
		
	}
	
	public void swapBuffers() {
		GLFW.glfwSwapBuffers(window);
		
	}
	
	public boolean closed() {
		return GLFW.glfwWindowShouldClose(window);
		
	}
	
	public boolean isKeyDown(int KeyCode) {
		return GLFW.glfwGetKey(window, KeyCode) == 1;
		
	}
	
	public boolean isMouseDown(int mouseButton) {
		return GLFW.glfwGetMouseButton(window, mouseButton) == 1;
		
	}
	
	public boolean isKeyPressed(int KeyCode) {
		return isKeyDown(KeyCode) && !Keys[KeyCode];
		
	}
	
	public boolean isKeyReleased(int KeyCode) {
		return !isKeyDown(KeyCode) && Keys[KeyCode];
		
	}
	
	public boolean isMousePressed(int mouseButton) {
		return isMouseDown(mouseButton) && !mouseButtons[mouseButton];
		
	}
	
	public boolean isMouseReleased(int mouseButton) {
		return !isMouseDown(mouseButton) && mouseButtons[mouseButton];
		
	}
	
	public double getMouseX() {
		DoubleBuffer buffer = BufferUtils.createDoubleBuffer(1);
		GLFW.glfwGetCursorPos(window, buffer, null);
		
		return buffer.get(0);
	}
	
	public double getMouseY() {
		DoubleBuffer buffer = BufferUtils.createDoubleBuffer(1);
		GLFW.glfwGetCursorPos(window, null, buffer);

		return buffer.get(0);

	}
	
}
