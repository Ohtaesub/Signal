package com.signal.objection.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.signal.all.dto.ObjectionDTO;

public interface ObjectionDAO {

	ArrayList<ObjectionDTO> clientObjectionList();

	ArrayList<ObjectionDTO> comObjectionList();

	ArrayList<ObjectionDTO> adminObjectionList();

	ArrayList<ObjectionDTO> adminBlindList();

	int clientDbjectionRegDo(HashMap<String, String> params);

}
