package engine.io;

import java.nio.DoubleBuffer;

import org.joml.Vector3f;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

public class Window {
	private int width, height;
	private String title;
	private double fps_cap, time, prossedTime = 0;
	
	private long window;
	private Vector3f backgroundColor;
	
	private long monitor;
	
	private boolean[] Keys = new boolean[GLFW.GLFW_KEY_LAST];
	private boolean[] mouseButtons = new boolean[GLFW.GLFW_MOUSE_BUTTON_LAST];

	public Window(int width, int height, int fps, String title) {
		
		this.width = width;
		this.height = height;
		this.title = title;
		
		fps_cap = 1.0 / fps;
		
		backgroundColor = new Vector3f(0.0f, 0.0f, 0.0f);
	}
	
	public void create() {
		 if(!GLFW.glfwInit()) {
			 System.err.println("Error: GLFW could not initialized");
			 System.exit(-1);
			 
		 }
		 
		GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE);
		GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_FALSE);
		window = GLFW.glfwCreateWindow(width, height, title, 0, 0);
		monitor = GLFW.glfwGetPrimaryMonitor();
		
		if(window == 0) {
			 System.err.println("Error: Window could not be created");
			 System.exit(-1);
			
		}
		
		GLFW.glfwMakeContextCurrent(window);
		GL.createCapabilities();
		
		GLFWVidMode videoMode = GLFW.glfwGetVideoMode(monitor);
		GLFW.glfwSetWindowPos(window, (videoMode.width() - width) / 2, (videoMode.height() - height) / 2);
				
		GLFW.glfwShowWindow(window);
		
		time = getTime();
	}
	
	
	public void update() {
		for(int i = 0; i < GLFW.GLFW_KEY_LAST; i++) Keys[i] = isKeyDown(i);
		for(int i = 0; i < GLFW.GLFW_MOUSE_BUTTON_LAST; i++) mouseButtons[i] = isMouseDown(i);
		
		GL11.glClearColor(backgroundColor.x, backgroundColor.y, backgroundColor.z, 1.0f);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		GLFW.glfwPollEvents();
		
	}
	
	public void stop() {
		GLFW.glfwTerminate();
		
	}
	
	public void swapBuffers() {
		GLFW.glfwSwapBuffers(window);
		
	}
	
	public double getTime() {
		return (double) System.nanoTime() / (double) 1000000000;
		
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
	
	public boolean isUpdating() {
	    double currentTime = getTime();
	    double delta = currentTime - time;

	    if (delta >= fps_cap) {
	        time = currentTime;
	        return true;
	    }

	    return false;
	}


	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public String getTitle() {
		return title;
	}

	public double getFPS() {
		return fps_cap;
	}

	public long getWindow() {
		return window;
	}
	
	public void setBackgroundColor(float r, float g, float b) {
		backgroundColor = new Vector3f(r, g, b);
		
	}
	
}
