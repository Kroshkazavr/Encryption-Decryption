package encryptdecrypt;

class Converter {

    private String mode = "enc";
    private String algorithm;
    private int key = 0;
    private String data = "";
    private String resultData = "";


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

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
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

    public void convert() {

        if (this.getMode().equalsIgnoreCase("enc")) {
            this.setResultData(Encryptor.enc(this.getData(), this.getKey()));
        } else if (this.getMode().equalsIgnoreCase("dec")) {
            this.setResultData(Decryptor.dec(this.getData(), this.getKey()));
        } else {
            System.out.println("Encryption/Decryption uncompleted - WRONG MODE.");
        }

    }

}
