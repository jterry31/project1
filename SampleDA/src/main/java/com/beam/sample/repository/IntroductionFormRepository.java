package com.beam.sample.repository;

import com.beam.sample.domain.Introduction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by x0r on 18/07/16.
 */
public interface IntroductionFormRepository extends JpaRepository<Introduction, String> {
}
