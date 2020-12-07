package encryptdecrypt;

class Converter {

    private String mode = "enc";
    private String algorithm = "shift";
    private int key = 0;
    private String data = "";
    private String resultData = "";

    public void convert() {
        if (this.mode.equals("enc")) {
            setResultData(Encryption.transform(this.data, this.algorithm, this.key));
        }
        if (this.mode.equals("dec")) {
            setResultData(Decryption.transform(this.data, this.algorithm, this.key));
        }
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getResultData() {
        return resultData;
    }

    public void setResultData(String resultData) {
        this.resultData = resultData;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
