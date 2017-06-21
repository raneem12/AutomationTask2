import javax.xml.bind.annotation.*;

/**
 * Created by rzzayed on 6/21/17.
 */
@XmlRootElement(name = "param")
@XmlAccessorType(XmlAccessType.FIELD)
public class Param
{
    @XmlAttribute(name = "name")
    private String name;
    @XmlAttribute(name = "value")
    private String value;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
