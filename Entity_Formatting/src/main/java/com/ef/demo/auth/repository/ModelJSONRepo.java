package com.ef.demo.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ef.demo.model.ModelJSON;

@Repository
public interface ModelJSONRepo extends JpaRepository<ModelJSON, Long> {
	
}
