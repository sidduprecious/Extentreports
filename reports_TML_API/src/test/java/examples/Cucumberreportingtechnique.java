package examples;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import com.intuit.karate.Runner.Builder;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

class Cucumberreportingtechnique {

    @Test
    void testParallel() {
    	
    	Results results = Runner.path("classpath:examples")
    			.outputCucumberJson(true)
    			.parallel(1);
        System.out.println(results.getFeaturesPassed());
        System.out.println(results.getFeaturesFailed());
        System.out.println(results.getReportDir());
        generateCucumberReport(results.getReportDir());
       
        
        CustomExtentReport extentReport = new CustomExtentReport().withKarateResult(results)
        		.withReportDir(results.getReportDir()).withReportTitle("TML API Test Automation");
        extentReport.generateExtentReport();
    }
    private void generateCucumberReport(String reportDirLocation) {
		File reportDir = new File(reportDirLocation);
		Collection<File> jsonCollection = FileUtils.listFiles(reportDir, new String[] {"json"}, true);
		
		List<String> jsonFiles = new ArrayList<String>();
		jsonCollection.forEach(file -> jsonFiles.add(file.getAbsolutePath()));
		
		Configuration configuration = new Configuration(reportDir, "Karate Run");
		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		reportBuilder.generateReports();
	}

}
