package kata3;

import java.awt.Container;
import java.awt.Dimension;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;


public class HistogramDisplay extends ApplicationFrame{
    
    private Histogram<String> histogram;
    
    public HistogramDisplay(String title, Histogram<String> histogram){
        super(title);
        this.histogram = histogram;
        setContentPane(createPanel());
        pack();
    }
    
    public void execute(){
        setVisible(true);
    }

    private JPanel createPanel() {
        ChartPanel chartPanel = new ChartPanel(createChart(createDataSet()));
        chartPanel.setPreferredSize(new Dimension(500, 400));
        
        return chartPanel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataset){
        JFreeChart chart = ChartFactory.createBarChart("Histogram...", "Dominios Emails", "Nº Emails", dataset, PlotOrientation.VERTICAL, false, false, rootPaneCheckingEnabled);
        
        return chart;
    }
    
    private DefaultCategoryDataset createDataSet(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for(String key:this.histogram.keySet()){
            dataset.addValue(this.histogram.get(key), "", key);
        }
        return dataset;
    }
}
