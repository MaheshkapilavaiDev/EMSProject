package com.employyemanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.employyemanagementsystem.service.AnalyticsService;

import java.util.Map;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

	@Autowired
	private AnalyticsService service;

	@GetMapping("/dashboard")
	@PreAuthorize("hasRole('ADMIN')")
	public Map<String, Object> getDashboard() {
		return service.getDashboardData();

	}
}
