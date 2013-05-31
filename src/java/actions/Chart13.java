package actions;

import charts.Bar;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;


/**
 *
 * @author skuarch
 */
public class Chart13 extends ActionSupport {

    private String stringChart = null;
    private String image = null;

    //==========================================================================
    @Override
    public String execute() throws Exception {

        double[] data = {Math.random() * 1000, Math.random() * 1000, Math.random() * 1000, Math.random() * 1000, Math.random() * 1000, Math.random() * 1000, Math.random() * 1000, Math.random() * 1000, Math.random() * 1000, Math.random() * 1000};
        String[] labels = {"1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005"};

        try {

            Bar chart = new Bar("chanclas", 600, 360, data, labels);
            chart.setTitleY("andale wey");
            chart.createChart();

            stringChart = chart.getStringChart(ServletActionContext.getRequest());
            image = ServletActionContext.getResponse().encodeURL("getchart.jsp?" + stringChart);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Action.SUCCESS;
    }

    //==========================================================================
    public String getStringChart() {
        return stringChart;
    }

    public void setStringChart(String stringChart) {
        this.stringChart = stringChart;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
} // end class