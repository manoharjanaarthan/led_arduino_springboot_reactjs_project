package com.janaa.led_operation_managing_service.repo;

import com.janaa.led_operation_managing_service.entity.LightHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LightHistoryRepository extends JpaRepository<LightHistory, String> {

    boolean existsByColorAndStatus(String color, String status);

    Optional<LightHistory> findFirstByColorAndStatusOrderByStartTimeDesc(
            String color,
            String status);
}
