/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.gov.uz.pv.drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import ua.gov.uz.pv.entity.Deviation;
import ua.gov.uz.pv.helper.IntervalInformation;

/**
 *
 * @author Евген
 */
public class DrawDeviation extends DrawRailway {
    private final Deviation deviation;
    private static final Integer LINE_HEIGHT = 20;
    private static final HashMap<String, Integer> devPos = new HashMap<String, Integer>();
    public DrawDeviation(Deviation dev,IntervalInformation ii ,int scale) {
        super(ii,scale);
        this.deviation=dev;
        devPos.put("П", 0);
        devPos.put("Р", LINE_HEIGHT);
        devPos.put("У", 2*LINE_HEIGHT);
        devPos.put("Суж", 3*LINE_HEIGHT);
        devPos.put("Пр.л", 4*LINE_HEIGHT);
        devPos.put("Пр.п", 4*LINE_HEIGHT);
    }
   
    private Color getColor() {
        switch (deviation.getLevel()) {
            case 5:
                return Color.RED;
            case 4:
                return Color.YELLOW;
            case 3:
                return Color.GREEN;
        }
        return Color.BLACK;
    }
    private int getX(){
        return ((deviation.getKm()-ii.kmS)*1000 + deviation.getM()-ii.mS)*1000/scale;
    }
    private int getY() {
        return devPos.get(deviation.getDeviation());
    }
    public void draw(Graphics g,Integer scale){
        Graphics2D g2= (Graphics2D)g;
        g2.setColor(getColor());
        g2.drawLine(getX(), getY(), getX(), LINE_HEIGHT+getY());
    }
    
}
