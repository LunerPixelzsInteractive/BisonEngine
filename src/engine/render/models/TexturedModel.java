package engine.render.models;

import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL30;

import engine.render.Material;

public class TexturedModel extends Model{
	
private int vertexArrayID, vertexBufferID, textureCoordBufferID, indicesBufferID, vertexCount;
private Material material;

	
	public TexturedModel(float[] vertices, float[] textureCoords,int[] indices, String file) {
		vertexArrayID = super.createVertexArray();
		indicesBufferID = super.bindIndicesBuffer(indices);
		vertexBufferID = super.storeData(0, 3, vertices);
		textureCoordBufferID = super.storeData(1, 2, textureCoords);
		vertexCount = indices.length;
		GL30.glBindVertexArray(0);
		material = new Material(file);
	}
	public void remove() {
		GL30.glDeleteVertexArrays(vertexArrayID);
		GL15.glDeleteBuffers(vertexBufferID);
		GL15.glDeleteBuffers(textureCoordBufferID);
		GL15.glDeleteBuffers(indicesBufferID);
		
		material.remove();
	}

	public int getVertexArrayID() {
		return vertexArrayID;
	}

	public int getVertexCount() {
		return vertexCount;
	}

	public Material getMaterial() {
		return material;
	}
}
