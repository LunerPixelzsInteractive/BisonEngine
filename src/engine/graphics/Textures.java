package engine.graphics;

import org.lwjgl.stb.STBImage;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.system.MemoryStack;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class Textures {
    private final int textureID;
    private final int width, height;

    public Textures(String filepath) {
        ByteBuffer image;
        try (MemoryStack stack = MemoryStack.stackPush()) {
            IntBuffer w = stack.mallocInt(1);  // Width of the image
            IntBuffer h = stack.mallocInt(1);  // Height of the image
            IntBuffer comp = stack.mallocInt(1);  // Color components (RGBA)

            // Load the image
            image = STBImage.stbi_load(filepath, w, h, comp, 4);  // 4 for RGBA

            if (image == null) {
                throw new RuntimeException("Failed to load image: " + STBImage.stbi_failure_reason());
            }

            // Get image width and height
            this.width = w.get();
            this.height = h.get();

            // Generate OpenGL texture
            textureID = GL11.glGenTextures();
            GL11.glBindTexture(GL11.GL_TEXTURE_2D, textureID);

            // Upload the texture to OpenGL
            GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, width, height, 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, image);

            // Set texture parameters (e.g., filtering)
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);

            // Free the image buffer after loading
            STBImage.stbi_image_free(image);
        }
    }

    // Bind the texture to OpenGL
    public void bind() {
        GL13.glActiveTexture(GL13.GL_TEXTURE0);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, textureID);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    // Cleanup: Delete the texture when done
    public void cleanup() {
        GL11.glDeleteTextures(textureID);
    }
}

