import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class FeaturesRequest {

    private List<String> feature;

    @XmlElement(name = "Feature")
    public List<String> getFeature() {
        return feature;
    }

    public void setFeature(List<String> feature) {
        this.feature = feature;
    }

    public FeaturesRequest(){
        feature = new ArrayList<String>();
    }
}
