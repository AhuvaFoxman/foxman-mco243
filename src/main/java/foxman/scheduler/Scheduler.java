package foxman.scheduler;

import java.util.List;
import java.util.Random;

public abstract class Scheduler implements Runnable {

	protected List<Job> jobs;
	public static final int TIME_SLICE = 10;
	public static final int OVER_HEAD = 1;
	protected int numJobsCompleted;
	protected int totalTime;
	protected Random rand = new Random();

	public Scheduler(List<Job> jobs) {
		this.jobs = jobs;
		totalTime = 0;
		numJobsCompleted = 0;
	}

	@Override
	public abstract void run();

	public int executeJob(Job job) {
		job.setState(JobState.Running);

		job.setLastRanAtTime(System.currentTimeMillis());

		int actualTimeSlice = computeActualTimeSLice(job);
		job.decrementTimeLeftToRun(actualTimeSlice);

		if (job.isFinished()) {
			jobs.remove(0);
			numJobsCompleted++;
		}

		else {
			job.setState(JobState.Ready);
		}
		return actualTimeSlice;
	}

	public int computeActualTimeSLice(Job job) {
		Random rand = new Random();

		int timeLeftToRun = job.getTimeLeftToRun();
		int actualTimeSlice;
		if (job.getType() == JobType.IO) {
			actualTimeSlice = Math.min(timeLeftToRun, rand.nextInt(TIME_SLICE));
		} else {
			actualTimeSlice = Math.min(timeLeftToRun, TIME_SLICE);
		}
		return actualTimeSlice;
	}

}