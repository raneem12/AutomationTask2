import javax.xml.bind.annotation.*;

/**
 * Created by rzzayed on 6/22/17.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "validate-text")
public class Text extends Item{

    @XmlAttribute(name = "value")
    protected String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
