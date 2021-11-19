package cool.qingqing.SpringBootTest01.entity;

/**
 * @author 高山青
 * @Date 2021/11/14  -   23:03
 */
public class CityVo {
	private String name;

	public String getName() {
		return name;
	}

	public CityVo(String name, String state) {
		this.name = name;
		this.state = state;
	}

	@Override
	public String toString() {
		return "CityVo{" +
				"name='" + name + '\'' +
				", state='" + state + '\'' +
				'}';
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	private String state;
}
