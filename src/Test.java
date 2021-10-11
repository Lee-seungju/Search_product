import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;

public class Test {
    private final WebDriver Naver;
//    private final WebDriver Coupang;
    private WebElement element;

    public Test() {
        System.setProperty("webdriver.chrome.driver", "/Users/seungjuLee/eclipse-workspace/Project_crawling/chromedriver");
        Naver = new ChromeDriver();
        //        Coupang = new ChromeDriver();
    }

    public void n_search(String search) {
        try {
            Naver.get("http://search.shopping.naver.com/search/all?query=&frm=NVSHATC");
            element = Naver.findElement(By.className("searchInput_search_input__1Eclz"));
            element.sendKeys(search);
            element.sendKeys(Keys.ENTER);

            //        클릭 버튼을 누르게 하고싶다면 여기
            //        element = Naver.findElement(By.className("searchInput_btn_search__2Jzpc"));
            //        element.click();

            String[] store = new String[4];
            String[] price = new String[4];

            store[0] = Naver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div[2]/div[3]/div[1]/ul/div/div[1]/li/div/div[2]/div[1]/a")).getText();
            price[0] = Naver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div[2]/div[3]/div[1]/ul/div/div[1]/li/div/div[2]/div[2]/strong/span/span[2]")).getText();
            store[1] = Naver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div[2]/div[3]/div[1]/ul/div/div[2]/li/div/div[2]/div[1]/a")).getText();
            price[1] = Naver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div[2]/div[3]/div[1]/ul/div/div[2]/li/div/div[2]/div[2]/strong/span/span[2]")).getText();
            store[2] = Naver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div[2]/div[3]/div[1]/ul/div/div[3]/li/div/div[2]/div[1]/a")).getText();
            price[2] = Naver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div[2]/div[3]/div[1]/ul/div/div[3]/li/div/div[2]/div[2]/strong/span/span[2]")).getText();
            store[3] = Naver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div[2]/div[3]/div[1]/ul/div/div[4]/li/div[1]/div[2]/div[1]/a")).getText();
            price[3] = Naver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div[2]/div[3]/div[1]/ul/div/div[4]/li/div[1]/div[2]/div[2]/strong/span/span[2]")).getText();

            System.out.println("검색결과");
            System.out.println("----- 네이버 -----");
            for (int i = 0; i < 4; i++) {
                System.out.println(store[i] + " : " + price[i]);
            }
        } catch(Exception e) {
            try {
                String[] d_store = new String[4];
                String[] d_price = new String[4];

                d_store[0] = Naver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div[2]/div[3]/div[1]/ul/div/div[1]/li/div/div[2]/div[1]/a")).getText();
                d_price[0] = Naver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div[2]/div[3]/div[1]/ul/div/div[1]/li/div/div[2]/div[2]/strong/span/span")).getText();
                d_store[1] = Naver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div[2]/div[3]/div[1]/ul/div/div[2]/li/div/div[2]/div[1]/a")).getText();
                d_price[1] = Naver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div[2]/div[3]/div[1]/ul/div/div[2]/li/div/div[2]/div[2]/strong/span/span")).getText();
                d_store[2] = Naver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div[2]/div[3]/div[1]/ul/div/div[3]/li/div/div[2]/div[1]/a")).getText();
                d_price[2] = Naver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div[2]/div[3]/div[1]/ul/div/div[3]/li/div/div[2]/div[2]/strong/span/span")).getText();
                d_store[3] = Naver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div[2]/div[3]/div[1]/ul/div/div[4]/li/div[1]/div[2]/div[1]/a")).getText();
                d_price[3] = Naver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div[2]/div[3]/div[1]/ul/div/div[4]/li/div[1]/div[2]/div[2]/strong/span/span")).getText();

                System.out.println("검색결과");
                System.out.println("----- 네이버 -----");
                for (int i = 0; i < 4; i++) {
                    System.out.println(d_store[i] + " : " + d_price[i]);
                }
            } catch(Exception ie) {
                ie.printStackTrace();
                System.out.println("입력 결과가 없습니다.");
            }
        }
        Naver.quit();
    }

//    public void c_search(String search) {
//        Coupang.get("http://www.coupang.com/np/search?q=%ED%82%A4%EB%B3%B4%EB%93%9C&channel=recent");
//        element = Coupang.findElement(By.xpath("//*[@id=\"headerSearchKeyword\"]"));
//        element.sendKeys(search);
//        element.sendKeys(Keys.ENTER);
//
//        Coupang.quit();
//    }

    public static void main(String args[]) {
        Scanner p = new Scanner(System.in);
        String value = p.nextLine();
        Test search = new Test();
        search.n_search(value);
//        search.c_search(args[1].toString());
    }
}
