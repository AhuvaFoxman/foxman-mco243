package foxman.scheduler;

public class Job {

	private String name;
	private Priority priority;
	private Priority dynamicPriority;

	private JobState state;
	private JobType type;
	private int timeLeftToRun;
	private Long deadLine;
	private Long lastRanAtTime;

	public long getLastRanAtTime() {
		return lastRanAtTime;
	}

	public void setLastRanAtTime(long lastRanAtTime) {
		this.lastRanAtTime = lastRanAtTime;
	}

	public Job(String name, Priority priority, JobType type, int timeLeftToRun) {
		this.name = name;
		this.priority = priority;
		this.type = type;
		this.timeLeftToRun = timeLeftToRun;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Priority getDynamicPriority() {
		return dynamicPriority;
	}

	public void setDynamicPriority(Priority dynamicPriority) {
		this.dynamicPriority = dynamicPriority;
	}

	public JobState getState() {
		return state;
	}

	public void setState(JobState state) {
		this.state = state;
	}

	public int getTimeLeftToRun() {
		return timeLeftToRun;
	}

	public void setTimeLeftToRun(int timeLeftRun) {
		this.timeLeftToRun = timeLeftRun;
	}

	public JobType getType() {
		return type;
	}

	public Long getDeadline() {
		return this.deadLine;
	}

	public void setDeadline(Long deadline) {
		this.deadLine = deadline;
	}

	public void decrementTimeLeftToRun(int actualTimeSlice) {
		this.timeLeftToRun -= actualTimeSlice;

	}

	public boolean isFinished() {
		return timeLeftToRun <= 0;
	}

	public int compareTo(Job other) {
		return this.name.compareTo(other.name);
	}

}