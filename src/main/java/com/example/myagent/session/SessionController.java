package com.example.myagent.session;

import com.example.myagent.message.ChatMessage;
import com.example.myagent.message.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin//允许跨域访问
@RestController
@RequestMapping("/session")
//@RequestParam带单个参数：id,name...,@RequestBody带一个整体
public class SessionController {
    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @PostMapping(path = "/add")//http://localhost:8080/session/add
    public String addSession(@RequestBody Session session) {//Session类名,session为实例
        sessionRepository.save(session);
        return "Saved";
    }

    @GetMapping(path = "/all")//http://localhost:8080/session/all
    public Iterable<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    @PostMapping(path = "/delete") //http://localhost:8080/session/delete?id=xxx
    public String deleteSession(@RequestParam String sessionId) {
        sessionRepository.deleteById(sessionId);
        return "Deleted";
    }

    @PostMapping(path = "/message/add")//http://localhost:8080/session/message/add
    public String addMessage(@RequestParam String sessionId,@RequestBody ChatMessage message){
        Session session = sessionRepository.findById(sessionId).get();
        message.setSession(session);
        chatMessageRepository.save(message);
        return "Saved";
    }
}
