package com.cource.management.mapper;

import org.mapstruct.Mapper;

import com.cource.management.Entity.Writer;
import com.cource.management.dto.WriterDto;

@Mapper(componentModel = "spring")
public interface WriterMapper {

//	@Mapping(source = "CId", target = "language.id")
	public Writer toWriter(WriterDto writerDTO);

//	@Mapping(source = "id", target = "WId")
//	@Mapping(source = "LId", target = "language.id")
	public WriterDto toWriterDTO(Writer writer);
}
