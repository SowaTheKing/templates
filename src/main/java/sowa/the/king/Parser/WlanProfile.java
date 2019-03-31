package sowa.the.king.Parser;

public class WlanProfile {
    private String type;
    private String name;
    private String numberOfSSIDs;
    private String SSIDname;
    private String networkType;
    private String radioType;
    private String vendorExtension;
    private String authentication;
    private String cipher;
    private String securityKey;
    private String keyContent;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberOfSSIDs() {
        return numberOfSSIDs;
    }

    public void setNumberOfSSIDs(String numberOfSSIDs) {
        this.numberOfSSIDs = numberOfSSIDs;
    }

    public String getSSIDname() {
        return SSIDname;
    }

    public void setSSIDname(String SSIDname) {
        this.SSIDname = SSIDname;
    }

    public String getNetworkType() {
        return networkType;
    }

    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }

    public String getRadioType() {
        return radioType;
    }

    public void setRadioType(String radioType) {
        this.radioType = radioType;
    }

    public String getVendorExtension() {
        return vendorExtension;
    }

    public void setVendorExtension(String vendorExtension) {
        this.vendorExtension = vendorExtension;
    }

    public String getAuthentication() {
        return authentication;
    }

    public void setAuthentication(String authentication) {
        this.authentication = authentication;
    }

    public String getCipher() {
        return cipher;
    }

    public void setCipher(String cipher) {
        this.cipher = cipher;
    }

    public String getSecurityKey() {
        return securityKey;
    }

    public void setSecurityKey(String securityKey) {
        this.securityKey = securityKey;
    }

    public String getKeyContent() {
        return keyContent;
    }

    public void setKeyContent(String keyContent) {
        this.keyContent = keyContent;
    }

    @Override
    public String toString() {
        return "WlanProfile{" +
                "\r\n\ttype='" + type + '\'' +
                "\r\n\t, name='" + name + '\'' +
                "\r\n\t, numberOfSSIDs='" + numberOfSSIDs + '\'' +
                "\r\n\t, SSIDname='" + SSIDname + '\'' +
                "\r\n\t, networkType='" + networkType + '\'' +
                "\r\n\t, radioType='" + radioType + '\'' +
                "\r\n\t, vendorExtension='" + vendorExtension + '\'' +
                "\r\n\t, authentication='" + authentication + '\'' +
                "\r\n\t, cipher='" + cipher + '\'' +
                "\r\n\t, securityKey='" + securityKey + '\'' +
                "\r\n\t, keyContent='" + keyContent + '\'' +
                '}' + "\r\n\r\n\r\n";
    }
}
