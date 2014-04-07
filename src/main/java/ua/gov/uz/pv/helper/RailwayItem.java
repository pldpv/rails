/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.uz.pv.helper;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.imageio.ImageIO;
import org.hibernate.FetchMode;
import ua.gov.uz.pv.entity.Deviation;
import ua.gov.uz.pv.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import ua.gov.uz.pv.drawing.DrawDeviation;
import ua.gov.uz.pv.drawing.Drawable;

/**
 *
 * @author Евген
 */
public class RailwayItem {

    private List<Deviation> deviation;
    private HashMap<List<Object>, BufferedImage> hm;
    Session session = null;
    private IntervalInformation ii;
    private final int scale;
    private final BufferedImage bImage
            = new BufferedImage(1000, 60, BufferedImage.TYPE_INT_RGB);

    public RailwayItem(Integer scale, IntervalInformation ii) {
        this.scale = scale;
        this.ii = ii;
        getDevList();
    }

    private void getDevList() {
        deviation = new ArrayList<Deviation>();
        session = HibernateUtil.getSessionFactory().openSession();
        deviation = session.createCriteria(Deviation.class)
                .setFetchMode("direction", FetchMode.JOIN)
                .add(Restrictions.eq("direction.idDirection", ii.idDirection))
                .add(Restrictions.eq("line", ii.line))
                .add(Restrictions.between("coordinate", ii.kmS * 1000 + ii.mS, ii.kmE * 1000 + ii.mE))
                .list();
        session.close();
    }

    public List<Deviation> getList() {
        return deviation;
    }

    public void draw() {
        
    }



    public void saveImg() {
        try {
            ImageIO.write(bImage, "PNG", new File("c:\\" + ii.kmS + "," + ii.mS + ".PNG"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private BufferedImage drawDeviationList(){
        BufferedImage bImage = new BufferedImage(1000, 60, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2=bImage.createGraphics();
        for (Deviation dev : deviation) {
            Drawable drawDev = new DrawDeviation(dev, g2, ii, scale);
            drawDev.draw();
        }
        return bImage;
    }
}
