package com.example.urlshort.services;

import com.example.urlshort.entities.Ref;
import com.example.urlshort.repositories.RefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
import java.util.Random;

@Service
public class RefService {
    private RefRepository refRepository;

    @Autowired
    public void setRefRepository(RefRepository refRepository) {
        this.refRepository = refRepository;
    }

    public Optional<Ref> getRefById(Long id) {
        return refRepository.findById(id);
    }

    public Optional<Ref> getRefByShortKey(String shortKey) {
        return refRepository.findByShortKey(shortKey);
    }

    public void save(Ref ref) {
        refRepository.save(ref);
    }

    public String generateShortKey() {
        String dict = "abcdefghigklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        int len = 5;

        for (int i = 0; i < len; i++) {
            int index = random.nextInt(0, dict.length());
            stringBuilder.append(dict.charAt(index));
        }
        return stringBuilder.toString();
    }

    public String getShortKey(String longRef) {
        try {
            URL url = new URL(longRef);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "URL not valid";
        }
        Ref ref = new Ref(longRef, generateShortKey());
        refRepository.save(ref);
        return ref.getShortKey();
    }
}
