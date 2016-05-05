package foxman.scheduler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SelfishRoundRobinScheduler extends Scheduler {

	public ArrayList<Job> activeQueue;
	public ArrayList<Job> waitingQueue;

	public SelfishRoundRobinScheduler(List<Job> jobs) {
		super(jobs);
		putIntoCorrectQueues();
	}

	private void putIntoCorrectQueues() {

		for (Job j : jobs) {
			if (j.getPriority() == Priority.High) {
				activeQueue.add(j);

			} else {
				waitingQueue.add(j);
			}
		}

	}

	@Override
	public void run() {
		while (activeQueue.size() != 0) {

			executeProcess();
		}

		while (waitingQueue.size() != 0) {
			raisePriority();
			executeProcess();
		}
	}

	private void raisePriority() {
		Iterator<Job> iter = waitingQueue.iterator();

		while (iter.hasNext()) {
			Job j = iter.next();
			int next = j.getPriority().ordinal() + 1;
			if (next < Priority.values().length) {
				j.setPriority(Priority.values()[next]);

			}
			if (j.getPriority() == Priority.High) {
				activeQueue.add(j);
				iter.remove();
			}

		}
	}

	private void executeProcess() {
		Job job = activeQueue.remove(0);
		int actualTimeSlice = executeJob(job);
		totalTime += actualTimeSlice;
		if (!job.isFinished() && job.getPriority() == Priority.High) {
			activeQueue.add(job);
		}
	}

}
