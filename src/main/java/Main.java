import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by rzzayed on 6/21/17.
 */
public class Main {
    private static WebDriver driver;
    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        String baserl = "http://demo.guru99.com/";



        JAXBContext context = JAXBContext.newInstance(Page.class);
        Unmarshaller um = context.createUnmarshaller();
        Page page = (Page) um.unmarshal(new FileReader("reg.xml"));

        System.out.println(page.toString());



        driver.get(String.valueOf(page.getURL()));

        Form form = page.getForm();

        for (Param param : form.getParams()) {
            DriverUtils.findElementByAll(driver,param.getName()).sendKeys(param.getValue());
        }

        DriverUtils.findElementByAll(driver,form.getFormName()).submit();
        //driver.findElement(By.name("btnLogin")).click();




    }
}
