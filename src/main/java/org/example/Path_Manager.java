package org.example;
import processing.core.PApplet;
import processing.core.PVector;
import processing.event.KeyEvent;

import java.awt.*;
public class Path_Manager {
    public Path[] paths;
    private static Path_Manager pathManager;
    private Path_Manager() {

    }
    public static Path_Manager getInstance() {
        if (pathManager == null) {
            pathManager = new Path_Manager();
        }
        return pathManager;
    }
    public void spawnPath() {

    }
}
