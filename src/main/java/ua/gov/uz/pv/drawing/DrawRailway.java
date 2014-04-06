package ua.gov.uz.pv.drawing;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import ua.gov.uz.pv.helper.IntervalInformation;

/**
 *
 * @author œ√Ã
 */
public class DrawRailway {
    
    IntervalInformation ii;
    int scale;
         
    
    public void draw(Graphics g,Integer scale){};
    public DrawRailway(IntervalInformation ii,int scale){
        this.ii=ii;
        this.scale=scale;
    }
    
   
}
