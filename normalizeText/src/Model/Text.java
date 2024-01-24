
package Model;

public class Text {
    private String inputFile = "input.txt";;
    private String outputFile = "output.txt";;
    private StringBuffer text;

    public Text() {
    }

    public Text(String inputF, String outputF) {
        this.text = new StringBuffer();
        this.inputFile = inputF;
        this.outputFile = outputF;
    }

    public String getInputFile() {
        return inputFile;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }

    public StringBuffer getText() {
        return text;
    }

    public void setText(StringBuffer text) {
        this.text = text;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Text{");
        sb.append(text);
        sb.append('}');
        return sb.toString();
    }
    

}
