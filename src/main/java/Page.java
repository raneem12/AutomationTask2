import javax.xml.bind.annotation.*;

/**
 * Created by rzzayed on 6/21/17.
 */
@XmlRootElement(name = "page")
@XmlAccessorType(XmlAccessType.FIELD)
public class Page
{
    @XmlAttribute(name = "url")
    private String URL;


    @XmlAttribute(name="page_name")
    private String name;

    @XmlElement(name = "form")
    private Form form;

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

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    @Override
    public String toString() {
        return "Page{" +
                "URL='" + URL + '\'' +
                ", name='" + name + '\'' +
                ", form=" + form +
                '}';
    }
}
