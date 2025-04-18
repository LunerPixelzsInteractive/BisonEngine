package engine.render;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;

public class Renderer {
	public void renderModel(Model model) {
		GL30.glBindVertexArray(model.getVertexArrayID());
		GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, model.getVertexCount());
		GL30.glDeleteVertexArrays(0);
		
	}

}
