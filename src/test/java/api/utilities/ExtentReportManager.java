//package api.utilities;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//
//public class ExtentReportManager implements ITestListener {
//    private static final ExtentReports extentReports = new ExtentReports();
//
//    public ExtentReports onStart(ITestContext testContext) {
//        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
//        reporter.config().setReportName("Sample Extent Report");
//        extentReports.attachReporter(reporter);
//        extentReports.setSystemInfo("Blog Name", "SW Test Academy");
//        extentReports.setSystemInfo("Author", "Onur Baskirt");
//        return extentReports;
//    }
//
//}
