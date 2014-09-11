import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

public class RestTemplateTest {
	public static void main(String[] args) {
		Map<String, String> vars = new HashMap<String, String>();
		vars.put("id", "111");
		vars.put("content", "222");
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject("http://restful.neowiz.co.kr/restful/command/{id}/content/{content}", String.class, vars);
		System.out.println("result : " + result);
	}
}
