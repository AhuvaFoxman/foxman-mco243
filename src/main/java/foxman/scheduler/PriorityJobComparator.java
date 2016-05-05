package foxman.scheduler;

import java.util.Comparator;

public class PriorityJobComparator implements Comparator<Job> {

	public int compare(Job a, Job b) {
		return a.getPriority().compareTo(b.getPriority());
	}

}