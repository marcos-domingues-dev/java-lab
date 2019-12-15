package br.com.bytebank.bytebanksystem.model;

import java.util.Comparator;

public class AccountComparator implements Comparator<Account>{

	@Override
	public int compare(Account al, Account ar) {
		return Integer.compare(al.getNumber(), ar.getNumber());
	}

}
