import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class ModuleFiveDocumentation extends ApplicationFrame {

	// Constructor to create the panel and chart
	// @param applicationTitle represents the title of the application.
	// @param chartTitle represents the title of the chart.
	public ModuleFiveDocumentation( String applicationTitle , String chartTitle ) {
	      super(applicationTitle);
	      JFreeChart lineChart = ChartFactory.createLineChart(
	         chartTitle,
	         "Input","Time",
	         createDataset(),
	         PlotOrientation.VERTICAL,
	         true,true,false);
	         
	      ChartPanel chartPanel = new ChartPanel( lineChart );
	      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
	      setContentPane( chartPanel );
	   }
	
	// Creates the dataset that contains the results of the tests for the iterative and recursive Fibonacci implementation
	// @return dataset, returns the dataset containing the Fibonacci Sequence runtimes
	private DefaultCategoryDataset createDataset( ) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
		long startTime;
		long endTime;
		
		for (int i = 0; i <= 8; i++) {
			startTime = System.nanoTime();
			runRecursiveFib(i);
			endTime = System.nanoTime();
			if (i > 1) dataset.addValue((endTime - startTime), "Recursive" , String.valueOf(i));
		}
		
		for (int i = 0; i <= 8; i++) {
			startTime = System.nanoTime();
			runIterativeFib(i);
			endTime = System.nanoTime();
			if (i > 1) dataset.addValue((endTime - startTime), "Iterative" , String.valueOf(i));
		}

	      return dataset;
	   }
	
	public static void main(String[] args) {
		// Create the chart
		ModuleFiveDocumentation chart = new ModuleFiveDocumentation(
		         "Iterative vs Recursive" ,
		         "Iterative vs Recursive");

		// Make it visable
		chart.pack( );
		RefineryUtilities.centerFrameOnScreen( chart );
		chart.setVisible( true );
	}

	// Takes in input and returns the nth index in the Fibonacci Sequence in a recursive fashion
	// @param n Input to indicate the nth number in the Fibonacci Sequence. Assumes n is positive.
	// @return integer representing nth index in Fibonacci Sequence.
	public static int runRecursiveFib(int n) {
		if (n <= 1)
			return n;
		return runRecursiveFib(n-1) + runRecursiveFib(n-2);
	}
	
	// Takes in input and returns the nth index in the Fibonacci Sequence in an iterative fashion
	// @param n Input to indicate the nth number in the Fibonacci Sequence. Assumes n is positive.
	// @return integer representing nth index in Fibonacci Sequence.
	public static int runIterativeFib(int n) {
		int f[] = new int[n+2];
		int i;
		
		f[0] = 0;
	    f[1] = 1;
	    
	    for (i = 2; i <= n; i++) {
	        f[i] = f[i-1] + f[i-2];
	    }
	    
	    return f[n];
	}
}