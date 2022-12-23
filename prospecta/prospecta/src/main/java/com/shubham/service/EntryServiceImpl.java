package com.shubham.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubham.Exception.EntryException;
import com.shubham.Repository.EntryRepo;
import com.shubham.model.Entry;
import com.shubham.model.TitleDescDTO;


@Service
public class EntryServiceImpl implements EntryService{
	
	@Autowired
	EntryRepo eDao;
	
	@Override
	public Entry saveEntry(Entry entry) {
		
		Entry savedEntry = eDao.save(entry);
		
		return savedEntry;
	}

	@Override
	public List<Entry> getAllentries() throws EntryException {
		List<Entry> entries = eDao.findAll();
		if(entries.isEmpty()) throw new EntryException("No Entries Available");
		return entries;
	}

	@Override
	public List<TitleDescDTO> getEntriesOnCateg(String Category) throws EntryException {
		List<Entry> entries = eDao.findByCategory(Category);
		List<TitleDescDTO> titleDescs = new ArrayList<>();
		
		for(Entry e:  entries) {
			if(e.getCategory().equals(Category))
				titleDescs.add(new TitleDescDTO(e.getTitle(),e.getDescription()));
		}
		return titleDescs;
	}

}
