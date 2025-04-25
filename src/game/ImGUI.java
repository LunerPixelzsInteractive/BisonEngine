package game;

import imgui.ImGui;
import imgui.app.Application;
import imgui.app.Configuration;

public class ImGUI extends Application {
    @Override
    protected void configure(Configuration config) {
        config.setTitle("Debug-IMGUI");
    }

    @Override
    public void process() {
        ImGui.text("Hello, World!");
    }

    public static void main(String[] args) {
        launch(new ImGUI());
    }
}
