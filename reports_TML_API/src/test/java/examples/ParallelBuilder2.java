package examples;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import com.intuit.karate.Runner.Builder;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ParallelBuilder2 {

    @Test
    void testParallel() {
    	
        Results results =Runner.path("classpath:examples").parallel(2);
        
        System.out.println(results.getFeaturesPassed());
        System.out.println(results.getFeaturesFailed());
        Assertions.assertEquals(0, results.getFeaturesFailed());
    }

}
