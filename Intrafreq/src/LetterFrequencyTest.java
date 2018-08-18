
import org.json.simple.JSONObject;

public class LetterFrequencyTest {

    public static void main(String[] args) {
        String inputText = "The test for letter frequency is starting now";

        LetterFrequency letterFrequency = new LetterFrequency(inputText);
        JSONObject jsonInputText = letterFrequency.getFrequencyText();
        JSONObject jsonRotate13 = letterFrequency.getFrequencyRotatedText();

        // test json
        System.out.println("JSON object content: for input text:\n" + jsonInputText);
        System.out.println("JSON object content for rotated text:" + jsonRotate13);

        JSONObject response = new JSONObject();
        response.put("input", inputText);
        response.put("freq_bef", jsonInputText);
        response.put("rot13", letterFrequency.getRotatedText());
        response.put("freq_aft", jsonRotate13);

        System.out.println("\nFinal json:\n" + response);

    }


}
