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
    
    public HistogramDisplay(String title){
        super(title);
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
        
        dataset.addValue(2, "", "ulpgc.es");
        dataset.addValue(7, "", "dis.ulpgc.es");
        dataset.addValue(1, "", "gmail.com");
        dataset.addValue(2, "", "hotmail.com");
        dataset.addValue(15, "", "eii.ulpgc.es");
        return dataset;
    }
}
