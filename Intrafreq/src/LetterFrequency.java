import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class LetterFrequency {
    private String inputText;
    private String rotatedText;

    public LetterFrequency(String inputText) {
        this.inputText = inputText;
        this.rotate13();
    }

    public JSONObject getFrequencyText() {
        return computeFrequencyJSON(this.inputText);
    }

    public JSONObject getFrequencyRotatedText() {
        return computeFrequencyJSON(this.rotatedText);
    }
    
    public String getRotatedText() {
        return rotatedText;
    }

    private JSONObject computeFrequencyJSON(String inputText) {
        Map<String, Integer> frequencyMap = new HashMap<String, Integer>();
        for(int i=0; i<inputText.length(); i++) {
            char letter = inputText.charAt(i);
            String lowerLetter = new String(""+letter);
            lowerLetter = lowerLetter.toLowerCase();

            // will count the lowercase and uppercase into the same entry in map
            Integer letterFrequency = frequencyMap.get(lowerLetter);
            if(letterFrequency == null) {
                letterFrequency = Integer.valueOf(0);
            }

            letterFrequency += 1;
            frequencyMap.put(lowerLetter, letterFrequency);
        }

        Set<String> letters = frequencyMap.keySet();

        // convert the map to a json object
        JSONObject json = new JSONObject();
        for(Iterator it = letters.iterator(); it.hasNext();) {
            String key = (String)it.next();

            if(!key.equals(" ")) {
                //System.out.println(key + ":" + frequencyMap.get(key));
                json.put(key, frequencyMap.get(key));
            }

        }
        return json;
    }

    private void rotate13() {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < inputText.length(); i++) {
            char c = inputText.charAt(i);
            if       (c >= 'a' && c <= 'm') c += 13;
            else if  (c >= 'A' && c <= 'M') c += 13;
            else if  (c >= 'n' && c <= 'z') c -= 13;
            else if  (c >= 'N' && c <= 'Z') c -= 13;
            out.append(c);
        }
        this.rotatedText = out.toString();
    }
}
