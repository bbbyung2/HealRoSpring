package com.health.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.entity.CardioResult;
import com.health.entity.CoronaryResult;
import com.health.entity.DiabetesResult;
import com.health.repository.CardioResultRepository;
import com.health.repository.CoronaryResultRepository;
import com.health.repository.DiabetesResultRepository;

@Service
public class ResultService {
	@Autowired
	CoronaryResultRepository coronaryResultRepo;
	@Autowired
	CardioResultRepository cardioResultRepo;
	@Autowired
	DiabetesResultRepository diabetesResultRepo;
	
	public void create(String userName) {
		CoronaryResult coronaryTemp = new CoronaryResult();
		coronaryTemp.setUserName(userName);
		coronaryResultRepo.save(coronaryTemp);
		
		CardioResult cardioTemp = new CardioResult();
		cardioTemp.setUserName(userName);
		cardioResultRepo.save(cardioTemp);
		
		DiabetesResult diabetesTemp = new DiabetesResult();
		diabetesTemp.setUserName(userName);
		diabetesResultRepo.save(diabetesTemp);
	}
	
	public CardioResult searchCardio(String userName) {
		return cardioResultRepo.findByUserName(userName);
	}
	
	public CoronaryResult searchCoronary(String userName) {
		return coronaryResultRepo.findByUserName(userName);
	}
	
	public DiabetesResult searchDiabetes(String userName) {
		return diabetesResultRepo.findByUserName(userName);
	}
	
	public void recordResult(int diseaseType, Float odd, String userNickName, String date) {
		if(diseaseType == 0) {
			cardioResultRepo.recordResultCardio(odd, userNickName, date);
		}
		else if(diseaseType == 1) {
			coronaryResultRepo.recordResultCoronary(odd, userNickName, date);
		}
		else if(diseaseType == 2) {
			diabetesResultRepo.recordResultDiabetes(odd, userNickName, date);
		}
		else if(diseaseType == 10) {
			cardioResultRepo.recordResultCardioPast(odd, userNickName, date);
		}
		else if(diseaseType == 11) {
			coronaryResultRepo.recordResultCoronaryPast(odd, userNickName, date);
		}
		else if(diseaseType == 12) {
			diabetesResultRepo.recordResultDiabetesPast(odd, userNickName, date);
		}
	}
}
