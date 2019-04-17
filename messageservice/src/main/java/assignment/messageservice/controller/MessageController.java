package assignment.messageservice.controller;


import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import assignment.messageservice.model.Message;
import assignment.messageservice.repo.MessageRepository;

@RestController
public class MessageController {

	@Autowired
	private MessageRepository messageRepository;
	

	
	@GetMapping("/getmessages")
	public List<Message> retrieveMessages(){
		System.out.println("Hi From controller");
		return messageRepository.findAll();
		
	}
	
	@GetMapping("/getmessages/{key}")
	public Message retrieveSpecificMessage(@PathVariable int key){
		Optional<Message> message=messageRepository.findById(key);
		return message.orElse(new Message(key,"Does not exists please post"));
	
	}
	
	@PostMapping("/message")
	public Message createMessage(@RequestBody Message message){		    
	        return this.messageRepository.save(message);
	    }
	}

