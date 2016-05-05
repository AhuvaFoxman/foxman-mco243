package foxman.scheduler;

import java.util.Collections;
import java.util.List;

public class DeadlineScheduler extends Scheduler {

	private DeadlineComparator comparator;

	public DeadlineScheduler(List<Job> jobs, DeadlineComparator comparator) {
		super(jobs);

		this.comparator = comparator;

	}

	@Override
	public void run() {

		Job lastJob = null;
		while (!jobs.isEmpty()) {
			Collections.sort(jobs, comparator);
			Job job = jobs.get(0);
			int actualTimeSlice = executeJob(job);

			totalTime += actualTimeSlice;

			if (job != lastJob) {
				totalTime += OVER_HEAD;
				lastJob = job;
			}
		}
	}

}
