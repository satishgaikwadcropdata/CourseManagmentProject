package com.cropdata.iservice;

import java.util.List;

import com.cropdata.dto.WriterDTO;
import com.cropdata.entity.Writer;

public interface IWriterService {

	public Writer saveCourse(WriterDTO writerDTO);

	public List<Writer> getAllCourse();

	public Writer updateWriter(WriterDTO writerDTO);

	public Writer deleteWriterById(Integer wId);

	public Writer findByWriterId(Integer wId);

}
