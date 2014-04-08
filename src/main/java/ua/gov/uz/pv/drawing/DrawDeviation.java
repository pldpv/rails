/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.uz.pv.drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;
import ua.gov.uz.pv.entity.Deviation;
import ua.gov.uz.pv.helper.IntervalInformation;

/**
 *
 * @author Евген
 */
public class DrawDeviation implements Drawable {
    
    private IntervalInformation ii;
    private int scale;
    private final Deviation deviation;
    private final Integer lineHeight;
    private static final HashMap<String, Integer> devPos = new HashMap<String, Integer>();
    private final int penWidth;
    private final Graphics2D g2;
    
    public DrawDeviation(Deviation dev, Graphics g,IntervalInformation ii, int scale,int lineHeight) {
        this.ii=ii;
        this.scale=scale;
        this.deviation = dev;
        this.lineHeight=lineHeight;
        g2=(Graphics2D)g;
        penWidth = 1000 / scale;
        devPos.put("П", 0);
        devPos.put("Р", lineHeight);
        devPos.put("У", 2 * lineHeight);
        devPos.put("Суж", 3 * lineHeight);
        devPos.put("Пр.л", 4 * lineHeight);
        devPos.put("Пр.п", 5 * lineHeight);
    }
    
    public void draw() {
        g2.setColor(getColor());
        g2.fillRect(getX(), getY(), penWidth, lineHeight);
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

    private int getX() {
        return ((deviation.getKm() - ii.kmS) * 1000 + deviation.getM() - ii.mS) * 1000 / scale;
    }

    private int getY() {
        return devPos.get(deviation.getDeviation());
    }
}
