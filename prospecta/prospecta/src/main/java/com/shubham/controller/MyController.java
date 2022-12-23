package com.shubham.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.Exception.EntryException;
import com.shubham.model.Entry;
import com.shubham.model.TitleDescDTO;
import com.shubham.service.EntryService;

@RestController
public class MyController {
	
	@Autowired
	EntryService entryDao;
	
	@GetMapping("/entry/{cat}")
	public ResponseEntity<List<TitleDescDTO>> gettitleDescOnCategory(@PathVariable("cat") String category) throws EntryException{
		List<TitleDescDTO> ans = entryDao.getEntriesOnCateg(category);
		
		return new ResponseEntity<>(ans,HttpStatus.OK);
	}
	
	@PostMapping("/entry")
	public ResponseEntity<Entry> saveEntry(@RequestBody Entry entry){
		Entry savedEntry = entryDao.saveEntry(entry);
		
		return new ResponseEntity<>(savedEntry,HttpStatus.OK);
	}
	
	@GetMapping("/entries")
	public ResponseEntity<List<Entry>> getEntries() throws EntryException{
		List<Entry>entries = entryDao.getAllentries();
		
		return new ResponseEntity<>(entries,HttpStatus.OK);
	}
}
