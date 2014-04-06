/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.uz.pv.drawing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import ua.gov.uz.pv.entity.Deviation;
import ua.gov.uz.pv.helper.IntervalInformation;

/**
 *
 * @author ПГМ
 */
public class DeviationDraw extends DrawRailway {

    private final Deviation deviation;
    private static final Integer LINE_HEIGHT = 20;
    private static final Integer IMG_HEIGHT = 100;
    private static final BufferedImage bImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, BufferedImage.TYPE_INT_RGB);
    private static final HashMap<String, Integer> devPos = new HashMap<String, Integer>();
    private static final Font fn = new Font("Arial", Font.PLAIN, LINE_HEIGHT - 1);
    private static Graphics2D g2;
    
    static {
        g2 = (Graphics2D) bImage.createGraphics();
        g2.setColor(Color.white);
        g2.fillRect(0, 0, IMG_WIDTH, IMG_HEIGHT);
        g2.setColor(Color.black);
        drawGrid();
        drawLegend();

    }

    public DeviationDraw(Deviation dev,IntervalInformation ii ,int scale) {
        super(ii,scale);
        this.deviation = dev;
    }

    public void draw() {
        g2.setColor(getColor());
     //   g2.fillRect(metersToPixels(deviation.getM()) + X_START, getYpos(),
       //         metersToPixels(deviation.getDeviationLength()), LINE_HEIGHT / 2);
        //g2.setColor(Color.black);
     //    g2.drawRect(metersToPixels(deviation.getM()) + X_START, getYpos(),
       ///        metersToPixels(deviation.getDeviationLength()) , LINE_HEIGHT/2);
        BasicStroke pen1= new BasicStroke(2);
        g2.setStroke(pen1);
        g2.drawLine(deviation.getM() + X_START, getYpos(),
             deviation.getM() + X_START, getYpos() + LINE_HEIGHT);
        saveImg();
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

    private int getYpos() {
        return devPos.get(deviation.getDeviation());
    }

    private int getX() {
        return 0;
    }

    private static void drawGrid() {
        float[] dash = {5, 3, 1, 3};
        BasicStroke pen = new BasicStroke(1, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_BEVEL, 10, dash, 0);
        g2.drawLine(X_START / 2, 0, X_START / 2, IMG_HEIGHT);

        //Drawing working space grid
        g2.drawRect(0, 0, bImage.getWidth() - 1, bImage.getHeight() - 1);
        g2.drawLine(X_START, 0, X_START, bImage.getHeight());
        for (int i = 100; i < 1000; i += 100) {
            g2.drawLine(metersToPixels(i) + X_START, 0, X_START + metersToPixels(i), IMG_HEIGHT);
        }
        for (int i = LINE_HEIGHT; i < bImage.getHeight(); i += LINE_HEIGHT) {
            g2.setStroke(pen);
            g2.drawLine(X_START, i, bImage.getWidth(), i);
        }
    }

    private static void drawLegend() {
        //Map of deviations

        devPos.put("П", 0);
        devPos.put("Р", LINE_HEIGHT);
        devPos.put("У", 2*LINE_HEIGHT);
        devPos.put("Суж", 3*LINE_HEIGHT);
        devPos.put("Пр.л", 4*LINE_HEIGHT);
        devPos.put("Пр.п", 4*LINE_HEIGHT);
        FontMetrics f = g2.getFontMetrics(fn);
        
        g2.setFont(fn);
        g2.setColor(Color.black);
        g2.drawString("Стан Колії", X_START / 4 - f.stringWidth("Стан Колії") / 2, IMG_HEIGHT / 2);
        for (String s : devPos.keySet()) {

            g2.setColor(Color.black);
            g2.setRenderingHint(
                    RenderingHints.KEY_TEXT_ANTIALIASING,
                    RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
            BasicStroke penBas = new BasicStroke(1);
            g2.setStroke(penBas);
            if (s.equals("Пр.п") || s.equals("Пр.л")) {
                g2.drawString("Пр", X_START / 2 + X_START / 4 - f.stringWidth("Пр") / 2, devPos.get(s) + LINE_HEIGHT-1);
            } else {
                g2.drawString(s, X_START / 2 + X_START / 4 - f.stringWidth(s) / 2, devPos.get(s) + LINE_HEIGHT-1);
            }
            g2.drawLine(X_START / 2, devPos.get(s), X_START, devPos.get(s));
        }
    }

    private void saveImg() {
        try {
            ImageIO.write(bImage, "PNG", new File("c:\\1.PNG"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
