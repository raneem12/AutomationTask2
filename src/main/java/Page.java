import javax.xml.bind.annotation.*;
import java.util.ArrayList;

/**
 * Created by rzzayed on 6/21/17.
 */
@XmlRootElement(name = "page")
@XmlAccessorType(XmlAccessType.FIELD)
public class Page
{
    @XmlElementRef
    private ArrayList<Item> items = new ArrayList<Item>();

    @XmlAttribute(name = "url")
    private String URL;


    @XmlAttribute(name="page_name")
    private String name;


    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public ArrayList<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Page{" +
                "URL='" + URL + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
