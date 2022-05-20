package com.webapp.acc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.acc.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, String>{

}
