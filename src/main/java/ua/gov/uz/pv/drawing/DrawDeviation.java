/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.uz.pv.drawing;

import java.awt.BasicStroke;
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
    private static final Integer LINE_HEIGHT = 10;
    private static final HashMap<String, Integer> devPos = new HashMap<String, Integer>();
    private final int penWidth;
    private Graphics2D g2;
    
    public DrawDeviation(Deviation dev, Graphics g,IntervalInformation ii, int scale) {
        this.ii=ii;
        this.scale=scale;
        this.deviation = dev;
        g2=(Graphics2D)g;
        penWidth = 1000 / scale;
        devPos.put("П", 0);
        devPos.put("Р", LINE_HEIGHT);
        devPos.put("У", 2 * LINE_HEIGHT);
        devPos.put("Суж", 3 * LINE_HEIGHT);
        devPos.put("Пр.л", 4 * LINE_HEIGHT);
        devPos.put("Пр.п", 5 * LINE_HEIGHT);
    }

    
    public void draw() {
        drawGrid();
        g2.setColor(getColor());
        g2.fillRect(getX(), getY(), penWidth, LINE_HEIGHT);
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

    private void drawGrid() {
        float[] dash = {5, 3, 1, 3};
        BasicStroke pen = new BasicStroke(1, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_BEVEL, 10, dash, 0);

        //Drawing working space grid
        g2.setColor(Color.white);
        g2.drawRect(0, 0, 999, 59);
        for (int i = 100; i < 1000; i += 100) {
            g2.drawLine(i, 0, i, LINE_HEIGHT * 6);
        }
        for (int i = LINE_HEIGHT; i < 6 * LINE_HEIGHT; i += LINE_HEIGHT) {
            g2.setStroke(pen);
            g2.setColor(Color.white);
            g2.drawLine(0, i, 1000, i);
        }

    }
}
