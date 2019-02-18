package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DirectSericeImpl;

@RestController
public class SendMessageController {

	@Autowired
	private DirectSericeImpl directSericeImpl;

	@GetMapping("/sendMessage")
	public List<String> sendMessage(String name) {
		return directSericeImpl.sendMessage(name);
	}
}
