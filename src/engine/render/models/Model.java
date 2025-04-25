package engine.render.models;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

public abstract class Model {
	private int indicesBufferID, vertexCount;

	private float[] vertices;
	
	private int[] indices;

	protected int createVertexArray() {
		int vertexArrayID =  GL30.glGenVertexArrays();
		GL30.glBindVertexArray(vertexArrayID);
		return vertexArrayID;
	}
	
	protected int storeData(int attributeNumber, int coordSize, float[] data) {
		FloatBuffer buffer = BufferUtils.createFloatBuffer(data.length);
        buffer.put(data).flip();

        int vertexBufferID = GL15.glGenBuffers();
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vertexBufferID);
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);

        GL20.glVertexAttribPointer(attributeNumber, coordSize, GL11.GL_FLOAT, false, 0, 0);
        GL20.glEnableVertexAttribArray(attributeNumber);

        return vertexBufferID;
		
	}
	
	protected int bindIndicesBuffer(int[] indices) {
		IntBuffer indicesBuffer = BufferUtils.createIntBuffer(indices.length);
		indicesBuffer.put(indices);
		indicesBuffer.flip();
		
		indicesBufferID = GL15.glGenBuffers();
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, indicesBufferID);
		GL20.glEnableVertexAttribArray(0);
		GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, indicesBuffer, GL15.GL_STATIC_DRAW);
		return indicesBufferID;
	}
	
}
