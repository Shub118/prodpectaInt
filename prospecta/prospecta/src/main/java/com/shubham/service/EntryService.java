package com.shubham.service;

import java.util.List;

import com.shubham.Exception.EntryException;
import com.shubham.model.Entry;
import com.shubham.model.TitleDescDTO;

public interface EntryService {
	public Entry saveEntry(Entry entry);
	public List<Entry> getAllentries()throws EntryException ;
	public List<TitleDescDTO> getEntriesOnCateg(String Category)throws EntryException ;
}
