package Framework;

import jakarta.xml.bind.annotation.XmlElement;

class Property {
    private String name;
    private String ref;

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
}
