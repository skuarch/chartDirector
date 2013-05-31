package charts;

import ChartDirector.Chart;
import ChartDirector.PieChart;
import ChartDirector.TextBox;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author skuarch
 */
public class Pie extends PieChart implements ChartCustom{

    private String title = "";    
    private String[] labels = null;
    private double[] data = null;
    private int angle = 135;
    
    //==========================================================================
    public Pie(int width, int height) {
        super(width, height);
    }    
    
    //==========================================================================
    public Pie(String title, int height, int width, double[] data, String[] labels) {
        super(height, width);
        this.title = title;
        this.data = data;
        this.labels = labels;
    } // end Pie 
    
    //==========================================================================
    @Override
    public void createChart(){
        
        if (data == null) {
            throw new NullPointerException("data is null");
        }

        if (labels == null) {
            throw new NullPointerException("labels is null");
        }

        if (title == null) {
            throw new NullPointerException("title is null");
        }
        
        addTitle(title, "Arial Bold", 10);
        setPieSize(390, 200, 120);        
        set3D(18);        
        setLabelLayout(Chart.SideLayout);        
        TextBox t = setLabelStyle();
        t.setBackground(Chart.SameAsMainColor, Chart.Transparent, Chart.glassEffect());
        t.setRoundedCorners(4);        
        setLineColor(Chart.SameAsMainColor, 0x000000);        
        setStartAngle(angle);        
        setData(data, labels);
        
    }

    //==========================================================================
    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    //==========================================================================
    @Override
    public void setTitleY(String titleY) {
        throw new UnsupportedOperationException("Not supported");
    }

    //==========================================================================
    @Override
    public void setTitleX(String titleX) {
        throw new UnsupportedOperationException("Not supported");
    }

    //==========================================================================
    @Override
    public void setLabels(String[] labels) {
        this.labels = labels;
    }

    //==========================================================================
    public void setAngle(int angle) {
        this.angle = angle;
    }

    //==========================================================================
    @Override
    public String getStringChart(HttpServletRequest request) {
        return this.makeSession(request, title + Math.random());
    }

    //==========================================================================
    @Override
    public int getFontAngle() {
        throw new UnsupportedOperationException("Not supported");
    }

    //==========================================================================
    @Override
    public void setFontAngle(int fontAngle) {
        throw new UnsupportedOperationException("Not supported");
    }   
    
    
} // end class