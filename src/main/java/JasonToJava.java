import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JasonToJava {

	public static void main(String[] args) {

		ObjectMapper mapper=new ObjectMapper();
		try {
			MyPojo[]pojo=mapper.readValue(new File("src/mainresources/configFile/Sampledata.jason"), MyPojo[].class);
			System.out.println(pojo[1].getLast_name() + " " + pojo[0].getLast_name());
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
