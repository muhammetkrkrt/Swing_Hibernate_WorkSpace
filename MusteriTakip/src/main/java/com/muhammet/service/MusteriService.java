package com.muhammet.service;

import com.muhammet.entity.Musteri;
import com.muhammet.repository.MusteriRepository;
import com.muhammet.utility.MyFactoryService;

public class MusteriService extends MyFactoryService<Musteri, MusteriRepository>{
    public MusteriService(){
        super(new MusteriRepository());
    }  
}
