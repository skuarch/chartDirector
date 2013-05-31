package charts;

import ChartDirector.Chart;
import ChartDirector.LineLayer;
import ChartDirector.XYChart;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author skuarch
 */
public class LineSymbols extends XYChart implements ChartCustom {

    private String title;
    private String titleY = "";
    private String titleX = "";
    private String titleSymbol = "";
    private String[] labels = null;
    private double[] data = null;
    private int fontAngle = 0;

    //==========================================================================
    public LineSymbols(int height, int width) {
        super(height, width);
    } // end BarChart 

    //==========================================================================
    public LineSymbols(String title, int height, int width, double[] data, String[] labels) {
        super(height, width);
        this.title = title;
        this.data = data;
        this.labels = labels;
    } // end LineSymbols 

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
        
        setPlotArea(60, 45, 730, 480, 0xffffff, -1, -1, 0xc0c0c0, -1);
        addLegend(60, 20, false, "Arial Bold", 6).setBackground(Chart.Transparent);
        addTitle(title, "Arial Bold", 10, 0x000000).setBackground(patternColor(new int[]{0xffffff, 0xffffff}, 2));
        xAxis().setLabels(labels).setFontAngle(fontAngle);        
        xAxis().setMargin(8, 8);
        yAxis().setTitle(titleY);
        xAxis().setTitle(titleX);
        LineLayer layer = addLineLayer2();
        layer.addDataSet(data, 0x40cf40, titleSymbol).setDataSymbol2("view/img/small_computer.png");
        layer.setLineWidth(3);

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

    //==========================================================================
    public void setTitleSymbol(String titleSymbol) {
        this.titleSymbol = titleSymbol;
    }    
    
} // end LineSymbols