//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//
//public class SeleniumTest {
//
//    public static void main(String[] args) {
//
//        SeleniumTest selTest = new SeleniumTest();
//        selTest.crawl();
//
//    }
//    //WebDriver
//    private WebDriver driver;
//
//    private WebElement webElement;
//
//    //Properties
//    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
//    public static final String WEB_DRIVER_PATH = "/Users/seungjulee/Downloads/selenium-java-3.141.59/chromedriver";
//
//    //크롤링 할 URL
//    private String base_url;
//
//    public SeleniumTest() {
//        super();
//
//        //System Property SetUp
//        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
//
//
//        //Driver SetUp
//        ChromeOptions options = new ChromeOptions();
//        options.setCapability("ignoreProtectedModeSettings", true);
//        driver = new ChromeDriver(options);
//
//        base_url = "https://www.daum.net";
//
//
//
//    }
//
//    public void crawl() {
//
//        try {
//            //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
//            driver.get(base_url);
//
//            //iframe으로 구성된 곳은 해당 프레임으로 전환시킨다.
//            driver.switchTo().frame(driver.findElement(By.id("loginForm")));
//
//            //iframe 내부에서 id 필드 탐색
//            webElement = driver.findElement(By.id("id"));
//            String daum_id ="your id";
//            webElement.sendKeys(daum_id);
//
//            //iframe 내부에서 pw 필드 탐색
//            webElement = driver.findElement(By.id("inputPwd"));
//            String daum_pw ="your pw";
//            webElement.sendKeys(daum_pw);
//
//
//            //로그인 버튼 클릭
//            webElement = driver.findElement(By.id("loginSubmit"));
//            webElement.submit();
//
//
//            Thread.sleep(20000);
//
//        } catch (Exception e) {
//
//            e.printStackTrace();
//
//        } finally {
//
//            driver.close();
//        }
//
//    }
//
//}
//

