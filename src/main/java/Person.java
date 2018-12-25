import java.io.Serializable;

import lombok.Data;
@Data
public class Person implements Serializable{

	private static final long serialVersionUID = 7592930394427200495L;
	
	private String name;
	private int age;
	private int id;
}
