#version 330 core

in vec2 passTexCoord;
out vec4 outColor;

uniform sampler2D textureSampler;

void main() {
    outColor = texture(textureSampler, passTexCoord);
}
