import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rzzayed on 6/21/17.
 */
public class Main {
    private static WebDriver driver;

    public static void main(String[] args) throws JAXBException, FileNotFoundException {
         Map<String,String> hashMap = new HashMap<String, String>();
        ChromeDriverManager.getInstance().setup();

        driver = DriverManager.get().newInstance(DriversInfo.CHROME);
        //String baserl = "http://demo.guru99.com/";



        JAXBContext context = JAXBContext.newInstance(Scenario.class);
        Unmarshaller um = context.createUnmarshaller();
        Scenario scenario = (Scenario) um.unmarshal(new FileReader("reg.xml"));

        for (Page page : scenario.getPages()) {
            if (page.getURL() != null) {
                driver.get(page.getURL());
            }
            ArrayList<Item> items = page.getItems();
            for (Item item : items) {
                if (item instanceof Form) {

                    for (Param param : ((Form) item).getParams()) {
                        DriverUtils.findElementByAll(driver, param.getName()).sendKeys(param.getValue());
                    }

                    DriverUtils.findElementByAll(driver, ((Form) item).getFormName()).submit();
                    //driver.findElement(By.name("btnLogin")).click();
                } else if (item instanceof GetText) {
                    hashMap.put(((GetText) item).getKey(),DriverUtils.findElementByAll(driver, ((GetText) item).getId()).getText());
                }
                else System.out.println("no");


            }


        }
    }
}
