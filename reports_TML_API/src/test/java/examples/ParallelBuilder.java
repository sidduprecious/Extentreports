package examples;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import com.intuit.karate.Runner.Builder;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ParallelBuilder {

    @Test
    void testParallel() {
    	Builder aRunner = new Builder();
        aRunner.path("classpath:examples");
        Results results =aRunner.parallel(5);
        System.out.println(results.getFeaturesPassed());
        System.out.println(results.getFeaturesFailed());
        
    }

}
