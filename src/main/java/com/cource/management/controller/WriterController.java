package com.cource.management.controller;

import com.cource.management.Entity.Writer;
import com.cource.management.Exception.CourseNotFoundException;
import com.cource.management.customresponse.CustomResponse;
import com.cource.management.service.WriterService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/writers")
public class WriterController {

    private final WriterService writerService;

    private String code;

    private Object data;

    public WriterController(WriterService writerService) {
        this.writerService = writerService;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_MANAGER','ROLE_USER')")
    public ResponseEntity<?> getWriterById(@PathVariable Long id) {
        try {
            Optional<Writer> writer = writerService.getWriterById(id);
            data = writer;
            code = "SUCCESS";
        } catch (
                CourseNotFoundException courseNotFoundException) {
            code = "DATA_NOT_CREATED";
            data = null;
        } catch (RuntimeException runtimeException) {
            code = "RUNTIME_EXCEPTION";
            data = null;
        } catch (Exception exception) {
            code = "EXCEPTION";
            data = null;
        } finally {
            return CustomResponse.response(code, data);
        }
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_MANAGER','ROLE_USER')")
    public ResponseEntity<?> getAllWriters() {
        try {
            List<Writer> writers = writerService.getAllWriters();
            data = writers;
            code = "SUCCESS";
        } catch (
                CourseNotFoundException courseNotFoundException) {
            code = "DATA_NOT_CREATED";
            data = null;
        } catch (RuntimeException runtimeException) {
            code = "RUNTIME_EXCEPTION";
            data = null;
        } catch (Exception exception) {
            code = "EXCEPTION";
            data = null;
        } finally {
            return CustomResponse.response(code, data);
        }
    }


    @PostMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_MANAGER')")
    public ResponseEntity<?> createWriter(@RequestBody Writer writer) {
        try {
            Writer createdWriter = writerService.createWriter(writer);
            data = createdWriter;
            code = "CREATED";
        } catch (
                CourseNotFoundException courseNotFoundException) {
            code = "DATA_NOT_CREATED";
            data = null;
        } catch (RuntimeException runtimeException) {
            code = "RUNTIME_EXCEPTION";
            data = null;
        } catch (Exception exception) {
            code = "EXCEPTION";
            data = null;
        } finally {
            return CustomResponse.response(code, data);
        }
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> updateWriter(@PathVariable Long id, @RequestBody Writer writer) {
        try {
            Writer updatedWriter = writerService.updateWriter(id, writer);
            data = updatedWriter;
            code = "CREATED";
        } catch (
                CourseNotFoundException courseNotFoundException) {
            code = "DATA_NOT_CREATED";
            data = null;
        } catch (RuntimeException runtimeException) {
            code = "RUNTIME_EXCEPTION";
            data = null;
        } catch (Exception exception) {
            code = "EXCEPTION";
            data = null;
        } finally {
            return CustomResponse.response(code, data);
        }
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> deleteWriter(@PathVariable Long id) {
        try {
            writerService.deleteWriter(id);
            data = "writer deleted : "+id;
            code = "CREATED";
        } catch (
                CourseNotFoundException courseNotFoundException) {
            code = "DATA_NOT_CREATED";
            data = null;
        } catch (RuntimeException runtimeException) {
            code = "RUNTIME_EXCEPTION";
            data = null;
        } catch (Exception exception) {
            code = "EXCEPTION";
            data = null;
        } finally {
            return CustomResponse.response(code, data);
        }
    }
}