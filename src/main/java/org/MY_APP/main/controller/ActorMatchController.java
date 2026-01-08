package org.MY_APP.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ActorMatchController {

    @GetMapping("/actor-match")
    public String actorMatchPage() {
        return "actor-match";
    }

    @PostMapping("/actor-match")
    public String handleActorMatch(
            @RequestParam("photo") MultipartFile photo
    ) {

        if (photo.isEmpty()) {
            return "redirect:/actor-match";
        }

        System.out.println("✅ PHOTO RECEIVED: " + photo.getOriginalFilename());

        // 👉 Εδώ θα μπει μετά το AI
        // face recognition → actor match

        return "redirect:/actor-match";
    }
}
