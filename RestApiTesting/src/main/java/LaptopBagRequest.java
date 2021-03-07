import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Laptop")
public class LaptopBagRequest {
    private String brandName;

    private String laptopName;

    private String id;

    private FeaturesRequest featuresRequest;

    @XmlElement(name = "BrandName")
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    @XmlElement(name = "LaptopName")
    public String getLaptopName() {
        return laptopName;
    }

    public void setLaptopName(String laptopName) {
        this.laptopName = laptopName;
    }

    @XmlElement(name="Id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement(name = "Features")
    public FeaturesRequest getFeaturesRequest() {
        return featuresRequest;
    }

    public void setFeaturesRequest(FeaturesRequest featuresRequest) {
        this.featuresRequest = featuresRequest;
    }
}
