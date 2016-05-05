package foxman.scheduler;

import java.util.Comparator;

public class DeadlineComparator implements Comparator<Job> {

	@Override
	public int compare(Job o1, Job o2) {
		return o1.getDeadline().compareTo(o2.getDeadline());
	}

}
