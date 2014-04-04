package ua.gov.uz.pv.drawing;

import java.awt.image.BufferedImage;

/**
 *
 * @author œ√Ã
 */
public abstract class DrawRailway {

    abstract void draw();
    static final Integer IMG_WIDTH = 1000;
    static final Integer X_START = 200;
    static final int Y_START = 0;
    
    /**
     * 
     * @param meter
     * @return pixels
     */
    protected static final int metersToPixels(int meter) {
        /**
         * TODO Converting Meters into Pixels 
         * depends on Image Width
         */
        return (IMG_WIDTH - X_START) * meter / 1000;
    }
}
