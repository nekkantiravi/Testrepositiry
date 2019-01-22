import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.smava.test.automation.utility.ResourceHelper;

public class JasonToJava {

	public static void main(String[] args) {

		ObjectMapper mapper=new ObjectMapper();
		try {
			MyPojo[]pojo=mapper.readValue(new File(ResourceHelper.getResourcePath("/src/main/resources/configFile/Sampledata.jason")), MyPojo[].class);
			String data=pojo[1].getLast_name() + " " + pojo[0].getLast_name();
			    System.out.println(data);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
