package distractify;

/**
 * Created by pogosov on 29.04.2014.
 */
/*import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;*/
import org.apache.james.mime4j.dom.datetime.DateTime;

import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Requests {

    public void runTest( java.net.URL url,String user,int URLnumber) {

        /*SampleResult result = new SampleResult();
        result.sampleStart(); // start stopwatch*/
        try {
            java.net.HttpURLConnection connection = (
                    java.net.HttpURLConnection
                    )url.openConnection(); // have to cast connection
            connection.setRequestMethod("GET");
            connection.connect();
            connection.disconnect();
            System.out.println(user+"(URL#"+URLnumber+"): "+connection.getHeaderField("X-VCache"));
            /*result.sampleEnd(); // stop stopwatch
            result.setSuccessful( true );
            result.setResponseMessage( "Successfully performed action" );
            result.setResponseCodeOK(); // 200 code
            connection.disconnect();*/
        } catch (Exception e) {
           /* result.sampleEnd(); // stop stopwatch
            result.setSuccessful( false );
            result.setResponseMessage( "Exception: " + e );
            // get stack trace as a String to return as document data
            java.io.StringWriter stringWriter = new java.io.StringWriter();
            e.printStackTrace( new java.io.PrintWriter( stringWriter ) );
            result.setResponseData( stringWriter.toString() );
            result.setDataType( org.apache.jmeter.samplers.SampleResult.TEXT );
            result.setResponseCode( "500" );*/
            System.out.println(user+"(URL#"+URLnumber+"): Connection error");
        }
    }


    public void usertest (String user)
    {

        try {
            System.out.println("Start time of "+user+": "+new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()));
            runTest(new java.net.URL(PropertyLoader.loadProperty("url1")), user, 1);
            runTest(new java.net.URL(PropertyLoader.loadProperty("url2")), user, 2);
            runTest(new java.net.URL(PropertyLoader.loadProperty("url3")), user, 3);
            runTest(new java.net.URL(PropertyLoader.loadProperty("url4")), user, 4);
            System.out.println("Finish time of "+user+": "+new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()));
        }
        catch (MalformedURLException ex){
            System.out.println(ex.toString());
        }
    }


}