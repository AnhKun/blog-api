package com.springboot.blog.converter;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NameTokenizers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapper {
    private final ModelMapper modelMapper;

    public Mapper(){
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSourceNameTokenizer(NameTokenizers.UNDERSCORE);
    }

    public <T> T toModel(Object obj, Class<T> zClass){
        return modelMapper.map(obj, zClass);
    }

    public <T, Y> List<T> toList(List<Y> aList, Class<T> zClass ){
        return aList.stream().map(e -> toModel(e, zClass)).toList();
    }
}
