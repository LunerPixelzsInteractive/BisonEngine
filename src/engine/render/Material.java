package engine.render;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.*;
import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.stb.STBImage.*;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.file.Paths;

import org.lwjgl.system.MemoryStack;

public class Material {
    private int textureID;

    public Material(String path) {
        textureID = loadTexture("res/textures/" + path);
    }

    private int loadTexture(String path) {
        int width, height;
        ByteBuffer image;

        try (MemoryStack stack = MemoryStack.stackPush()) {
            IntBuffer w = stack.mallocInt(1);
            IntBuffer h = stack.mallocInt(1);
            IntBuffer channels = stack.mallocInt(1);

            stbi_set_flip_vertically_on_load(false);
            image = stbi_load(path, w, h, channels, 4);
            if (image == null) {
                throw new RuntimeException("Could not load texture: " + stbi_failure_reason());
            }

            width = w.get();
            height = h.get();
        }

        int id = glGenTextures();
        glBindTexture(GL_TEXTURE_2D, id);
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0,
                     GL_RGBA, GL_UNSIGNED_BYTE, image);

        glGenerateMipmap(GL_TEXTURE_2D);
        stbi_image_free(image);

        return id;
    }

    public void remove() {
        glDeleteTextures(textureID);
    }

    public int getTexturID() {
        return textureID;
    }
}
