package charts;

import ChartDirector.Chart;
import ChartDirector.XYChart;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author skuarch
 */
public class Bar extends XYChart implements ChartCustom {

    private String title;
    private String titleY = "";
    private String titleX = "";
    private String[] labels = null;
    private double[] data = null;
    private int fontAngle = 0;

    //==========================================================================
    public Bar(int height, int width) {
        super(height, width);
    } // end BarChart 

    //==========================================================================
    public Bar(String title, int height, int width, double[] data, String[] labels) {
        super(height, width);
        this.title = title;
        this.data = data;
        this.labels = labels;
    } // end BarChart 

    //==========================================================================
    @Override
    public void createChart() {        

        if (data == null) {
            throw new NullPointerException("data is null");
        }

        if (labels == null) {
            throw new NullPointerException("labels is null");
        }

        if (title == null) {
            throw new NullPointerException("title is null");
        }

        if (titleY == null) {
            throw new NullPointerException("titleY is null");
        }

        setPlotArea(60, 40, 730, 470, this.linearGradientColor(60, 40, 60, 280, 0xffffff, 0xffffff), -1, 0xa6a6a6, 0xa6a6a6);
        addBarLayer3(data).setBorderColor(Chart.Transparent, Chart.softLighting(Chart.Left));
        addTitle(title, "Arial Bold", 10);
        xAxis().setLabels(labels);
        xAxis().setLabelStyle("Arial Bold", 10, 0x000000).setFontAngle(fontAngle);
        xAxis().setTickOffset(0.5);
        yAxis().setTitle(titleY, "Arial Bold", 10);
        xAxis().setTitle(titleX);
        xAxis().setWidth(2);
        yAxis().setWidth(2);
    }

    //==========================================================================
    @Override
    public String getStringChart(HttpServletRequest request) {
        return this.makeSession(request, title + Math.random());
    }

    //==========================================================================
    @Override
    public void setData(double[] data) {
        this.data = data;
    } // end setData

    //==========================================================================
    @Override
    public void setTitle(String title) {
        this.title = title;
    } // end setTitle

    //==========================================================================
    @Override
    public void setTitleY(String titleY) {
        this.titleY = titleY;
    }

    //==========================================================================
    @Override
    public void setLabels(String[] labels) {
        this.labels = labels;
    } // end setLabels

    //==========================================================================
    @Override
    public int getFontAngle() {
        return fontAngle;
    }

    //==========================================================================
    @Override
    public void setFontAngle(int fontAngle) {
        this.fontAngle = fontAngle;
    }

    //==========================================================================
    @Override
    public void setTitleX(String titleX) {
        this.titleX = titleX;
    }
} // end class