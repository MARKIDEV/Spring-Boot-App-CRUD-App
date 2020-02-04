package com.instrumentation.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.instrumentation.demo.models.Instrument;

public interface InstrumentRepository extends JpaRepository<Instrument, Long> {

}
