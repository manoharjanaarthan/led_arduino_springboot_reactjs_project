package com.janaa.led_operation_managing_service.controller;

import com.janaa.led_operation_managing_service.service.LightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/light")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class LedOperationController {

    private final LightService lightService;

    @PostMapping("/{operation}/{color}")
    public ResponseEntity<String> operateLight(
            @PathVariable String operation,
            @PathVariable String color) {

        lightService.operate(operation, color);

        return ResponseEntity.ok(
                String.format("%s light switched %s",
                        color.toUpperCase(),
                        operation.toUpperCase()));
    }
}
