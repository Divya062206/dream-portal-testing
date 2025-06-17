package utilities;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class AIUtils 
{
	 private static final String API_KEY = "your-api-key";

	    public static String classifyDream(String dreamText) {
	        OpenAiService service = new OpenAiService(API_KEY);

	        CompletionRequest request = CompletionRequest.builder()
	            .prompt("Classify the dream as Good or Bad: \"" + dreamText + "\"")
	            .model("text-davinci-003")
	            .maxTokens(10)
	            .temperature(0.5)
	            .build();

	        return service.createCompletion(request).getChoices().get(0).getText().trim();
	    }

}
