package com.cropdata.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cropdata.dto.WriterDTO;
import com.cropdata.entity.Writer;
import com.cropdata.exception.WriterNotFoundException;
import com.cropdata.iservice.IWriterService;
import com.cropdata.mapper.WriterMapper;
import com.cropdata.repository.WriterRepository;

@Service
public class WriterServiceImpl implements IWriterService {

	@Autowired
	private WriterRepository writerRepository;

	@Autowired
	private WriterMapper writerMapper;

	@Override
	public Writer saveCourse(WriterDTO writerDTO) {
		Writer writer = null;
		try {
			writer = writerRepository.save(writerMapper.toWriter(writerDTO));

		} catch (Exception e) {
			e.printStackTrace();
			throw new WriterNotFoundException("Customer Present");
		}
		return writer;
	}

	@Override
	public List<Writer> getAllCourse() {
		List<Writer> writersList = new ArrayList<>();
		try {
			writersList = writerRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new WriterNotFoundException();
		}
		return writersList;
	}

	@Override
	public Writer updateWriter(WriterDTO writerDTO) {
		Writer writer = writerRepository.findById(writerDTO.getWId()).get();
		try {

			if (writer.getWId() != null) {

				writer = writerRepository.save(writerMapper.toWriter(writerDTO));

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new WriterNotFoundException();
		}
		return writer;
	}

	@Override
	public Writer deleteWriterById(Integer wId) {
		Writer writer = writerRepository.findById(wId).get();
		try {
			if (writer.getWId() != null) {
				writerRepository.delete(writer);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new WriterNotFoundException();
		}
		return writer;
	}

	@Override
	public Writer findByWriterId(Integer wId) {
		Writer writer = new Writer();
		try {
			if (wId != null) {
				writer = writerRepository.findById(wId).get();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new WriterNotFoundException();
		}
		return writer;
	}

}
