package com.meadowsapps.meadowslib.graphics;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmeadows on 9/9/16.
 */
public class Renderer extends Canvas {

    /**
     * List of all the Renderable objects the Renderer is
     * responsible for rendering
     */
    private List<RenderableI> renderables = new ArrayList<RenderableI>();

    /**
     * An empty array of Renderable objects. Used to convert the
     * Renderable list to an array of Renderables
     */
    private static final RenderableI[] EMPTY_ARRAY = new RenderableI[0];

    /**
     * Paints the Renderable objects if they are dirty
     *
     * @param g the <code>java.awt.Graphics</code> instance
     *          to paint on
     */
    @Override
    public void paint(Graphics g) {
        for (RenderableI renderable : renderables) {
            if (renderable.isDirty()) {
                renderable.render(g);
                renderable.setDirty(false);
            }
        }
    }

    /**
     * Adds the specified Renderable to the list of Renderable
     * objects if the list does not already contain the Renderable
     * object. Once added, the Renderer sets the new Renderable's
     * dirty bit to true and the Renderer repaints to reflect this
     * new operation
     *
     * @param renderable the new Renderable to render
     */
    public void addRenderable(RenderableI renderable) {
        if (!renderables.contains(renderable)) {
            if (renderables.add(renderable)) {
                renderable.setDirty(true);
                repaint();
            }
        }
    }

    /**
     * Removes the specified Renderable from the list of Renderable
     * objects if the list contains the Renderable object. Once
     * removed, the Renderer repaints the reflect this new
     * operation
     *
     * @param renderable the Renderable to remove
     */
    public void removeRenderable(RenderableI renderable) {
        if (renderables.contains(renderable)) {
            if (renderables.remove(renderable)) {
                repaint();
            }
        }
    }

    /**
     * Gets an array of Renderable objects the Renderer is responsible
     * for rendering
     *
     * @return an array of Renderable objects
     */
    public RenderableI[] getRenderables() {
        return renderables.toArray(EMPTY_ARRAY);
    }

}
