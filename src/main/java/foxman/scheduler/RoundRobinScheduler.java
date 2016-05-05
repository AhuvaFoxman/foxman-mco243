package foxman.scheduler;

import java.util.List;

public class RoundRobinScheduler extends Scheduler {

	public RoundRobinScheduler(List<Job> jobs,
			PriorityJobComparator priorityJobComparator) {

		super(jobs);
	}

	@Override
	public void run() {

		while (!jobs.isEmpty()) {

			Job job = jobs.get(0);
			int actualTimeSlice = executeJob(job);
			totalTime += actualTimeSlice;

			if (!job.isFinished()) {
				jobs.add(job); // add it to the back of the queue

			}

		}

	}

}
