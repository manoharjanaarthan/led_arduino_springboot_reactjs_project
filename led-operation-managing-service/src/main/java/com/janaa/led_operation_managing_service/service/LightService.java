package com.janaa.led_operation_managing_service.service;

import com.janaa.led_operation_managing_service.entity.LightHistory;
import com.janaa.led_operation_managing_service.repo.LightHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LightService {

    private final LightHistoryRepository repository;
    private final ArduinoSerialService arduinoSerialService;

    public void operate(String operation, String color) {
        operation = operation.toUpperCase();
        color = color.toUpperCase();
        switch (operation) {
            case "ON":
                switchOn(color);
                break;
            case "OFF":
                switchOff(color);
                break;
            default:
                throw new IllegalArgumentException(
                        "Invalid operation. Use ON or OFF");
        }
    }

    private void switchOn(String color) {
        boolean alreadyOn =
                repository.existsByColorAndStatus(color, "ON");
        if (alreadyOn) {
            throw new IllegalStateException(
                    color + " light is already ON.");
        }
        LightHistory history = new LightHistory();
        history.setColor(color);
        history.setStatus("ON");
        history.setStartTime(LocalDateTime.now());
        repository.save(history);
        arduinoSerialService.sendCommand(color + "_ON");
    }

    private void switchOff(String color) {
        LightHistory history =
                repository.findFirstByColorAndStatusOrderByStartTimeDesc(
                                color,
                                "ON")
                        .orElseThrow(() ->
                                new IllegalStateException(
                                        color + " light is already OFF."));
        LocalDateTime end = LocalDateTime.now();
        history.setEndTime(end);
        history.setDurationMs(
                Duration.between(
                                history.getStartTime(),
                                end)
                        .toMillis());
        history.setStatus("OFF");
        repository.save(history);
        arduinoSerialService.sendCommand(color + "_OFF");
    }


}
