package db;

public class EmpBean implements java.io.Serializable {
	private String project;
	private String category;
	private String task;
	private String FromTime;
	private String ToTime;
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getFromTime() {
		return FromTime;
	}
	public void setFromTime(String fromTime) {
		FromTime = fromTime;
	}
	public String getToTime() {
		return ToTime;
	}
	public void setToTime(String toTime) {
		ToTime = toTime;
	}
	
	

}