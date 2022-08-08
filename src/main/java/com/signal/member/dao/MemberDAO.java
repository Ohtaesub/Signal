package com.signal.member.dao;

import java.util.HashMap;

public interface MemberDAO {

	String overlayClientId(String cl_id);

	String overlayEmail(String cl_email);

	int clientJoin(HashMap<String, String> params);

}
