package com.closa.global.functions;

import com.fasterxml.jackson.databind.util.StdConverter;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class StringToInstant extends StdConverter<String, Instant> {

    DateTimeFormatter formatter = DateTimeFormatter
            .ofPattern("yyyy-MM-dd HH:mm:ss:nnnnnnn O");
    @Override
    public Instant convert(String value){
        return Instant.parse(value) ;
    }
}
