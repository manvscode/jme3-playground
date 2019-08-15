package com.joemarrero;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.renderer.Caps;
import com.jme3.renderer.Renderer;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.math.ColorRGBA;
import com.jme3.system.AppSettings;
import com.jme3.system.JmeContext;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Application extends SimpleApplication {
    private Logger mLogger = Logger.getLogger(Application.class.getName());


    public static void main(String[] args){
        AppSettings settings = new AppSettings(true);
        settings.setResolution(512, 512);
        settings.setBitsPerPixel(32);
        settings.setDepthBits(8);
        settings.setAlphaBits(8);
        settings.setAudioRenderer(null);
        settings.setSamples(0);
        settings.setVSync(false);
        settings.putBoolean("GraphicsDebug", true);

        Application app = new Application();
        app.setDisplayFps(false);
        app.setDisplayStatView(false);
        app.setSettings(settings);

        // This will work!
        //app.start(JmeContext.Type.Display, false);

        // This will fail!
        app.start(JmeContext.Type.OffscreenSurface, false);
    }

    @Override
    public void simpleInitApp() {
        Renderer renderer = getRenderer();
        if (renderer != null) {
            Collection<Caps> capabilities = getRenderer().getCaps();
            mLogger.log(Level.INFO, "Capabilities: {0}", capabilities);
        }

        Box b = new Box(1, 1, 1); // create cube shape
        Geometry geom = new Geometry("Box", b);  // create cube geometry from the shape
        Material mat = new Material(assetManager,
                "Common/MatDefs/Misc/Unshaded.j3md");  // create a simple material
        mat.setColor("Color", ColorRGBA.Red);   // set color of material to blue
        geom.setMaterial(mat);                   // set the cube's material
        rootNode.attachChild(geom);              // make the cube appear in the scene
    }

    @Override
    public void handleError(String errMsg, Throwable t) {
        mLogger.log(Level.SEVERE, errMsg, t);
        stop(); // stop the application
    }
}
