package engine.render.models;

import org.joml.Matrix4f;
import org.joml.Vector3f;

import engine.maths.MatrixMath;

public class ModelEntity {
	private TexturedModel model;
	private Vector3f position, angle, scale;
	
	public ModelEntity(TexturedModel model, Vector3f position, Vector3f angle, Vector3f scale) {
		this.model = model;
		this.position = position;
		this.angle = angle;
		this.scale = scale;
	}
	
	public Matrix4f getTransformationMatrix() {
		return MatrixMath.createTransformationMatrix(position, angle, scale);
		
	}
	
	 public void addPositionX(float value) {
	 		position.x += value;
	 	}
	 	
	 	public void addPositionY(float value) {
	 		position.y += value;
	 	}
	 
	 	public void addPositionZ(float value) {
	 		position.z += value;
	 	}
	 	
	 	public void addRotationX(float value) {
	 		angle.x += value;
	 	}
	 	
	 	public void addRotationY(float value) {
	 		angle.y += value;
	 	}
	 
	 	public void addRotationZ(float value) {
	 		angle.z += value;
	 	}
	 	
	 	public void addScaleX(float value) {
	 		scale.x += value;
	 	}
	 	
	 	public void addScaleY(float value) {
	 		scale.y += value;
	 	}
	 	
	 	public void addScaleZ(float value) {
	 		scale.z += value;
	 	}
	 	
	 	public TexturedModel getModel() {
	 		return model;
	 	}
	 	
	 	public void setModel(TexturedModel model) {
	 		this.model = model;
	 	}
	 	
	 	public float getPositionX() {
	 		return position.x;
	 	}
	 	
	 	public float getPositionY() {
	 		return position.y;
	 	}
	 	
	 	public float getPositionZ() {
	 		return position.z;
	 	}
	 	
	 	public void setPositionX(float value) {
	 		this.position.x = value;
	 	}
	 	
	 	public void setPositionY(float value) {
	 		this.position.y = value;
	 	}
	 	
	 	public void setPositionZ(float value) {
	 		this.position.z = value;
	 	}
	 	
	 	public float getRotationX() {
	 		return position.x;
	 	}
	 	
	 	public float getRotationY() {
	 		return position.y;
	 	}
	 	
	 	public float getRotationZ() {
	 		return position.z;
	 	}
	 	
	 	public void setRotationX(float value) {
	 		this.angle.x = value;
	 	}
	 	
	 	public void setRotationY(float value) {
	 		this.angle.y = value;
	 	}
	 	
	 	public void setRotationZ(float value) {
	 		this.angle.z = value;
	 	}
	 	
	 	public float getScaleX() {
	 		return scale.x;
	 	}
	 	
	 	public float getScaleY() {
	 		return scale.y;
	 	}
	 	
	 	public float getScaleZ() {
	 		return scale.z;
	 	}
	 	
	 	public void setScaleX(float value) {
	 		this.scale.x = value;
	 	}
	 	
	 	public void setScaleY(float value) {
	 		this.scale.y = value;
	 	}
	 	
	 	public void setScaleZ(float value) {
	 		this.scale.z = value;
	 	}
}
