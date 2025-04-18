package engine.render;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

public class Model {
	private int vertexArrayID, vertexBufferID, indicesBufferID, vertexCount;
	
	private float[] vertices;
	
	private int[] indices;
	
	public Model(float[] vertices, int[] indices) {
		this.vertices = vertices;
		this.indices = indices;
		vertexCount = indices.length;
	}

	public void create() {
		FloatBuffer buffer = BufferUtils.createFloatBuffer(vertices.length);
		buffer.put(vertices);
		buffer.flip();
		
		IntBuffer indicesBuffer = BufferUtils.createIntBuffer(indices.length);
		indicesBuffer.put(indices);
		indicesBuffer.flip();
		
		vertexArrayID = GL30.glGenVertexArrays();
		GL30.glBindVertexArray(vertexArrayID);
		
		vertexBufferID = GL15.glGenBuffers();
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vertexBufferID);
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
		
		indicesBufferID = GL15.glGenBuffers();
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, indicesBufferID);
		GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, indicesBuffer, GL15.GL_STATIC_DRAW);
		
		GL20.glEnableVertexAttribArray(0);
		GL20.glVertexAttribPointer(0, 3, GL11.GL_FLOAT, false, 0, 0);
		GL30.glBindVertexArray(0);
	}
	
	public void remove() {
		GL30.glDeleteVertexArrays(vertexArrayID);
		GL15.glDeleteBuffers(vertexBufferID);
		GL15.glDeleteBuffers(indicesBufferID);
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
