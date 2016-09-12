package com.meadowsapps.meadowslib.graphics;

import java.awt.*;

/**
 * Created by dmeadows on 9/9/16.
 */
public interface RenderableI {

    /**
     * Defines how the Renderer should render the Renderable
     * object
     *
     * @param g <code>java.awt.Graphics</code> instance to
     *          paint on
     */
    void render(Graphics g);

    /**
     * Gets the location of the Renderable object inside of the Renderer
     *
     * @return the location of the Renderable
     */
    Point getLocation();

    /**
     * Sets the location of the Renderable object inside of the Renderer
     * and sets <code>dirty</code> to <code>true</code> so the Renderer
     * will update
     *
     * @param location the new location of the Renderable
     */
    void setLocation(Point location);

    /**
     * Sets the location of the Renderable object inside of the Renderer
     * and sets <code>dirty</code> to <code>true</code> so the Renderer
     * will update
     *
     * @param x the new x location of the Renderable
     * @param y the new y location of the Renderable
     */
    void setLocation(int x, int y);

    /**
     * Gets the size of the Renderable object inside of the Renderer
     *
     * @return the size of the Renderable
     */
    Dimension getSize();

    /**
     * Sets the size of the Renderable object inside of the Renderer
     * and sets <code>dirty</code> to <code>true</code> so the Renderer
     * will update
     *
     * @param size the new size of the Renderable
     */
    void setSize(Dimension size);

    /**
     * Sets the size of the Renderable object inside of the Renderer
     * and sets <code>dirty</code> to <code>true</code> so the Renderer
     * will update
     *
     * @param width  the new width of the Renderable
     * @param height the new height of the Renderable
     */
    void setSize(int width, int height);

    /**
     * Gets if the Renderable object is dirty to determine if
     * the Renderer needs to update on it's next repaint cycle
     *
     * @return if the Renderable is dirty
     */
    boolean isDirty();

    /**
     * Sets the dirty bit for the Renderable object so
     * the Renderer will update
     *
     * @param dirty new dirty state
     */
    void setDirty(boolean dirty);

}
