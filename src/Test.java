import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;

public class Test {
    private WebDriver Naver;
    private WebDriver eleven;
    private WebElement element;
    private static String[] n_store;
    private static String[] n_price;
    private static String[] e_store;
    private static String[] e_price;

    public Test() {
        System.setProperty("webdriver.chrome.driver", "/Users/seungjuLee/eclipse-workspace/Project_crawling/chromedriver");
    }

    public void n_search(String search) {
        try {
            Naver = new ChromeDriver();

            // 네이버 쇼핑 홈페이지로 들어간다.
            Naver.get("http://search.shopping.naver.com/search/all?query=&frm=NVSHATC");

            // 검색창에 입력할 텍스트타입 공란을 찾는다.
            element = Naver.findElement(By.className("searchInput_search_input__1Eclz"));

            // search로 값을 받아온 입력값을 검색창에 입력한다.
            element.sendKeys(search);

            // 엔터를 입력해 검색을 한다.
            element.sendKeys(Keys.ENTER);

            // 이 for문을 통해 목록을 불러올 것이다.
            for(int i = 0; i < 4; i++) {
                // store - 상품이름, price - 상품 가격
                // 상품이름은 그대로 아무 이상이 없다면 xpath로 값을 가져온다.
                // 여기서 결과 값이 만약에 없다면 예외가 발생한다.
                n_store[i] = Naver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div[2]/div[3]/div[1]/ul/div/div[" + (i + 1) + "]/li/div/div[2]/div[1]/a")).getText();
                n_price[i] = Naver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div[2]/div[3]/div[1]/ul/div/div[" + (i + 1) + "]/li/div/div[2]/div[2]/strong/span/span")).getText();
            }

            for (int i = 0; i < 4; i++) {
                char[] p = n_price[i].toCharArray();

                // 그런데 가격들중에서 하나만 왼쪽에 광고가 붙어있는 경우도 있다. 이때는 d_price[i]값에 '최저' 라는 값이 붙는다.
                // 그때를 대비에 첫 값이 숫자가 아닌 경우에 다시 오른쪽 값을 xpath로 넣는 알고리즘을 추가한다.
                if (p[0] < '0' + 0 || p[0] > '0' + 9) {
                    n_price[i] = Naver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div[2]/div[3]/div[1]/ul/div/div[" + (i + 1) + "]/li/div/div[2]/div[2]/strong/span/span[2]")).getText();
                }
            }
        } catch(Exception e) {
                e.printStackTrace();
                System.out.println("입력 결과가 없습니다.");
                n_price[0] = "N";
        }
        Naver.quit();
    }

    public void e_search(String search) {
        eleven = new ChromeDriver();
        eleven.get("http://www.11st.co.kr/?gclid=Cj0KCQjwwY-LBhD6ARIsACvT72NHD0munKKYvBwdOMDwMXYb3XmWzfQDE3UDgHKBnKK21xyW4EGjSvgaAszSEALw_wcB&utm_term=E_11%B9%F8%B0%A1&utm_campaign=0311+PC+%BA%EA%B7%A3%B5%E5+%C0%CF%C4%A1+%C4%B7%C6%E4%C0%CE+%BD%C5%B1%D4+BO&utm_source=%B1%B8%B1%DB_PC_S&utm_medium=%B0%CB%BB%F6");
        element = eleven.findElement(By.xpath("//*[@id=\"tSearch\"]/form/fieldset/input"));

        element.sendKeys(search);
        element.sendKeys(Keys.ENTER);

        try {
            for (int i = 0; i < 4; i++) {
                // store - 상품이름, price - 상품 가격
                // 상품이름은 그대로 아무 이상이 없다면 xpath로 값을 가져온다.
                // 여기서 결과 값이 만약에 없다면 예외가 발생한다.
                e_store[i] = eleven.findElement(By.xpath("//*[@id=\"layBodyWrap\"]/div/div/div[3]/div/section[2]/ul/li[" + (i + 1) + "]/div/div[2]/div[1]/div[1]/a/strong")).getText();
                try {
                    // 가격표 자리에 별점이 있을때가 있고, 없을 때가 있다. 별점이 없는 경우에는 예외를 발생시켜 다르게 처리를 해준다.
                    e_price[i] = eleven.findElement(By.xpath("//*[@id=\"layBodyWrap\"]/div/div/div[3]/div/section[2]/ul/li[" + (i + 1) + "]/div/div[2]/div[1]/div[3]/dl/dd/span[1]")).getText() + "원";
                } catch (Exception e) {
                    e_price[i] = eleven.findElement(By.xpath("//*[@id=\"layBodyWrap\"]/div/div/div[3]/div/section[2]/ul/li[" + (i + 1) + "]/div/div[2]/div[1]/div[2]/dl/dd/span[1]")).getText() + "원";
                }
            }
        } catch(Exception ie) {
            ie.printStackTrace();
            System.out.println("입력 결과가 없습니다.");
            e_price[0] = "N";
        }

        eleven.quit();
    }

    public static void display_all() {
        // 불러온 값들을 토대로 출력한다.
        System.out.println("검색결과");

        // 검색 결과가 없는 경우에는 값을 따로 넣어주어 else문으로 이동하게 한다.
        if (n_price[0] != "N") {
            System.out.println("----- 네이버 -----");
            for (int i = 0; i < 4; i++) {
                System.out.println(n_store[i] + " : " + n_price[i]);
            }
        } else {
            System.out.println("---네이버는 입력 결과가 없습니다.---");
        }

        if (e_price[0] != "N") {
            System.out.println("----- 11번가 -----");
            for (int i = 0; i < 4; i++) {
                System.out.println(e_store[i] + " : " + e_price[i]);
            }
        } else {
            System.out.println("11번가는 입력 결과가 없습니다.");
        }
    }

    public static void main(String args[]) {
        Scanner p = new Scanner(System.in);
        n_store = new String[4];
        n_price = new String[4];
        e_store = new String[4];
        e_price = new String[4];

        String value = p.nextLine();
        Test search = new Test();
        search.n_search(value);
        search.e_search(value);

        display_all();
    }
}
