package foxman.scheduler;

import java.util.Comparator;

public class FifoJobComparator implements Comparator<Job> {

	@Override
	public int compare(Job o1, Job o2) {

		return o1.getName().compareTo(o2.getName());
	}

}