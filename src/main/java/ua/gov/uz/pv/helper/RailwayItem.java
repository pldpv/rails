/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.uz.pv.helper;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import org.hibernate.FetchMode;
import ua.gov.uz.pv.entity.Deviation;
import ua.gov.uz.pv.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import ua.gov.uz.pv.drawing.DrawDeviation;
import ua.gov.uz.pv.drawing.DrawRailway;

/**
 *
 * @author ֵגדום
 */
public class RailwayItem {

    List<Deviation> deviation;
    
    Session session = null;
    public IntervalInformation ii;
    private final int imageScale;
    private final BufferedImage bImage
            = new BufferedImage(1000, 120, BufferedImage.TYPE_INT_RGB);
    
    public RailwayItem(Integer scale,IntervalInformation ii) {
        this.imageScale = scale;
        this.ii=ii;
    }

    private List<Deviation> getDevList(){
        deviation = new ArrayList<Deviation>();
        session = HibernateUtil.getSessionFactory().openSession();
        deviation = session.createCriteria(Deviation.class)
                .setFetchMode("direction", FetchMode.JOIN)
                .add(Restrictions.eq("direction.idDirection",ii.idDirection))
                .add(Restrictions.eq("line",ii.line))
                .add(Restrictions.between("coordinate", ii.kmS*1000+ii.mS,ii.kmE*1000+ii.mE))
                .list();
        session.close();
       return deviation; 
   }
   
   public void draw(){
           for (Deviation dev:deviation){
               DrawRailway drawDev=new DrawDeviation(dev,ii,imageScale);
               Graphics2D g2 =bImage.createGraphics();
               drawDev.draw(g2,imageScale);
           }
   }
   public void saveImg() {
        try {
            ImageIO.write(bImage, "PNG", new File("c:\\"+ii.kmS+","+ii.mS+".PNG"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
