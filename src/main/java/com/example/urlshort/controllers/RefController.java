package com.example.urlshort.controllers;

import com.example.urlshort.entities.Ref;
import com.example.urlshort.services.RefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class RefController {
    private RefService refService;

    @Autowired
    public void setRefService(RefService refService) {
        this.refService = refService;
    }

    @GetMapping
    @ResponseBody
    public String getShortKey(@RequestParam String longRef) {
        return refService.getShortKey(longRef);
    }

    @GetMapping("/{shortKey}")
    public ResponseEntity<Void> redirect(@PathVariable(value = "shortKey") String shortKey) {
        Optional<Ref> ref = refService.getRefByShortKey(shortKey);
        if (ref.isPresent()) {
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(ref.get().getLongRef())).build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
