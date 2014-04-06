/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.gov.uz.pv.drawing;

import java.util.ArrayList;
import ua.gov.uz.pv.helper.RailwayItem;
import java.util.List;
import ua.gov.uz.pv.entity.Deviation;
import ua.gov.uz.pv.helper.IntervalInformation;

/**
 *
 * @author ֵגדום
 */
public class DrawRailwayItem {
    private List<RailwayItem> railItem=new ArrayList<RailwayItem>();
    IntervalInformation ii;
    private final Integer scale,length;
    public DrawRailwayItem(Integer scale,IntervalInformation ii) {
        this.ii=ii;
        this.scale=scale;
        length=(ii.kmE-ii.kmS)*1000+(ii.mE-ii.mS);
        
    }
    
    private void getRailwayItems(){
        for (int i=0;i<length;i+=scale){
            int kmS=(ii.kmS*1000+ii.mS+i)/1000;
            int mS=(ii.mS+i>=1000)?ii.mS+i-1000:ii.mS+i;
            int kmE=(kmS*1000+mS+scale)/1000;
            int mE=(i+scale>length)?ii.mE:(mS+scale)%1000;
            railItem.add(new RailwayItem(scale, 
                    new IntervalInformation(ii.idDirection, kmS, mS, kmE, mE, ii.line)));
        }
    }
    public List<RailwayItem> getList(){
        getRailwayItems();
        return railItem;
    }
    public static void main(String ... args){
        System.out.println("getList");
        IntervalInformation ii =new IntervalInformation(22403, 193,0 , 194, 18, 1);
        DrawRailwayItem dd=new DrawRailwayItem(100, ii);
        for (RailwayItem item:dd.getList()){
            item.draw();
            item.saveImg();
            System.out.println("Start"+item.ii.kmS+" "+item.ii.mS
                    +"-"+ item.ii.kmE+" "+item.ii.mE);
            for (Deviation dev:item.getDevList()){
                System.out.println("Deviation:"+dev.getKm()+" "+ dev.getM());
            }
        }
    }
}
