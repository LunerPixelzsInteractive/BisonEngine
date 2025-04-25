package engine.shaders;

import org.joml.Matrix4f;

public class BasicShader extends Shader{

	private static final String VERTEX_FILE = "src/engine/shaders/basicVertexShader.vs", 
			                    FRAGMENT_FILE = "src/engine/shaders/basicFragmentShader.fs";
	
	private int transformationLocation;
	
	public BasicShader() {
		super(VERTEX_FILE, FRAGMENT_FILE);
		
	}

	@Override
	public void bindAllAttributes() {
		super.bindAttributes(0, "vertices");
		super.bindAttributes(1, "textCoords");
		
	}

	@Override
	protected void getAllUniforms() {
		transformationLocation = super.getUniform("transformation");
	}
	
	public void loadTransformationMatrix(Matrix4f matrix) {
		super.loadMatrixUniform(transformationLocation, matrix);
	}
}
