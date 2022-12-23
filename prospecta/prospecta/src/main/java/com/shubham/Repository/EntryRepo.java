package com.shubham.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shubham.model.Entry;

public interface EntryRepo extends JpaRepository<Entry, Integer>{
	public List<Entry> findByCategory(String cat);
}
