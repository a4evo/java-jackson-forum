package telran.forum.controller;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import telran.forum.domain.Comment;
import telran.forum.domain.Post;

public class ForumAppl {
	static ObjectMapper mapper;
	
	//static field initialization
	static {	
		mapper = new ObjectMapper();
		mapper.findAndRegisterModules();
	}

	public static void main(String[] args) throws Exception {
		
		Map<Long, Post> forum = new HashMap<>();
		Post post = new Post(1l, "Java EE", "Java is the best for backend", "JavaFan", new HashSet<>( Arrays.asList("java", "server", "backend") ));
		forum.put(post.getId(), post);
		
		String json = mapper.writeValueAsString(forum);		
		System.out.println(json);
		
		Comment comment = new Comment("Stranger", "Awesome!");
		forum.get(1l).addComment(comment);
		forum.get(1l).addLike();
		
		json = mapper.writeValueAsString(forum);	
		System.out.println(json);

		mapper.writeValue(new File("forum.json"), forum);
	}

}
