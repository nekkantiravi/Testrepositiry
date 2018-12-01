import org.codehaus.jackson.annotate.JsonIgnore;

public class MyPojo {

	private int id;
	//@JsonIgnore
	private String first_name;
	private String last_name;

	public int getId() {
		return id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

}
