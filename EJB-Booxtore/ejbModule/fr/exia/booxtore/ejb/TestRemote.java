package fr.exia.booxtore.ejb;

import javax.ejb.Remote;

@Remote
public interface TestRemote {
	public String getTest();
}
