package engine.render;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

public class Model {
	private int vertexArrayID, vertexBufferID, vertexCount;
	
	private float[] vertices;
	
	public Model(float[] vertices) {
		this.vertices = vertices;
		vertexCount = vertices.length / 3;
		
	}

	public void create() {
		FloatBuffer buffer = BufferUtils.createFloatBuffer(vertices.length);
		buffer.put(vertices);
		buffer.flip();
		
		vertexArrayID = GL30.glGenVertexArrays();
		GL30.glBindVertexArray(vertexArrayID);
		
		vertexBufferID = GL15.glGenBuffers();
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vertexBufferID);
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
		
		GL20.glEnableVertexAttribArray(0);
		GL20.glVertexAttribPointer(0, 3, GL11.GL_FLOAT, false, 0, 0);
		GL30.glBindVertexArray(0);
		GL20.glEnableVertexAttribArray(0);
		
	}
	
	public void remove() {
		GL30.glDeleteVertexArrays(vertexArrayID);
		GL15.glDeleteBuffers(vertexBufferID);
		
	}

	public int getVertexArrayID() {
		return vertexArrayID;
	}

	public int getVertexBufferID() {
		return vertexBufferID;
	}

	public int getVertexCount() {
		return vertexCount;
	}
	
	
}
