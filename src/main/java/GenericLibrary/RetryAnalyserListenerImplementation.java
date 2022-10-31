package GenericLibrary;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
/**
 * This class is used to transform the fully quailified class name to xml 
 * @author LAVA KUMAR
 *
 */
public class RetryAnalyserListenerImplementation implements IAnnotationTransformer{
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(GenericLibrary.RetryAnalyserImplementation.class);
		
	}
}