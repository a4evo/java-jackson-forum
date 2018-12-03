package telran.forum.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import telran.forum.domain.Post;

public class ForumRestoreAppl {
	static ObjectMapper mapper;
		
	//static field initialization
	static {	
		mapper = new ObjectMapper();
		mapper.findAndRegisterModules();
	}
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		JavaType valueType = mapper.getTypeFactory().constructMapLikeType(HashMap.class, Long.class, Post.class);
		Map<Long, Post> forum = mapper.readValue(new File("forum.json"), valueType);
		
		System.out.println(forum);
	}

}
