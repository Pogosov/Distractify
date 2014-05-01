package distracify;

/**
 * Created by pogosov on 29.04.2014.
 */
import java.io.Serializable;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.testng.annotations.Test;

public class ExampleJavaTestClass extends AbstractJavaSamplerClient implements Serializable {
    private static final long serialVersionUID = 1L;

    // set up default arguments for the JMeter GUI
    @Override
    public Arguments getDefaultParameters() {
        Arguments defaultParameters = new Arguments();
        defaultParameters.addArgument("URL", "http://news.distractify2.qarea.org/");
        return defaultParameters;
    }

    @Override
    public SampleResult runTest(JavaSamplerContext context) {

        SampleResult result = new SampleResult();
        result.sampleStart(); // start stopwatch

        try {
            java.net.URL url = new java.net.URL("http://news.distractify2.qarea.org/");
            java.net.HttpURLConnection connection = (
                    java.net.HttpURLConnection
                    )url.openConnection(); // have to cast connection
            connection.setRequestMethod("GET");
            connection.connect();

            result.sampleEnd(); // stop stopwatch
            result.setSuccessful( true );
            result.setResponseMessage( "Successfully performed action" );
            result.setResponseCodeOK(); // 200 code
            result.setResponseData(connection.getHeaderField("X-VCache"),"windows-1251");
            connection.disconnect();
        } catch (Exception e) {
            result.sampleEnd(); // stop stopwatch
            result.setSuccessful( false );
            result.setResponseMessage( "Exception: " + e );
            // get stack trace as a String to return as document data
            java.io.StringWriter stringWriter = new java.io.StringWriter();
            e.printStackTrace( new java.io.PrintWriter( stringWriter ) );
            result.setResponseData( stringWriter.toString() );
            result.setDataType( org.apache.jmeter.samplers.SampleResult.TEXT );
            result.setResponseCode( "500" );
        }

        return result;
    }

    @Test
    public void user1()
    {
        JavaSamplerContext context= new JavaSamplerContext(getDefaultParameters());
        SampleResult sample=runTest(context);
        System.out.println("|bout: " + sample.getResponseDataAsString());
    }
}
