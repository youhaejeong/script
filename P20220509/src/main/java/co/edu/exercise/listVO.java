package co.edu.exercise;

public class listVO {
	private String title;
	
	
	
	

	public listVO(String title) {
		super();
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "listVO [title=" + title + "]";
	}
	
	

}
