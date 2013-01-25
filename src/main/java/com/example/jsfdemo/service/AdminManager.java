package com.example.jsfdemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.example.jsfdemo.domain.Human;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.example.jsfdemo.domain.Human;


@ApplicationScoped
public class AdminManager {
	private List<Human> db = new ArrayList<Human>();

	public void addHuman(Human human) {
		Human newHuman = new Human();

		newHuman.setName(human.getName());
		newHuman.setPesel(human.getPesel());


		db.add(newHuman);
	}

	// usuwa humana z wybranym peselem
	public void deleteHuman(Human human) {
		Human humanToRemove = null;
		for (Human p : db) {
			if (human.getPesel().equals(p.getPesel())) {
				humanToRemove = p;
				break;
			}
		}
		if (humanToRemove != null)
			db.remove(humanToRemove);
	}

	public List<Human> getAllHumans() {
		return db;
	}
}
