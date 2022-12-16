package ru.skypro.automationSocks.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.skypro.automationSocks.record.SocksRecord;
import ru.skypro.automationSocks.service.SocksService;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@RestController
@RequestMapping("/api/socks")
@Validated
public class SocksController {
    private final SocksService socksService;

    public SocksController(SocksService socksService) {
        this.socksService = socksService;
    }

    @GetMapping()
    public ResponseEntity<Integer> findCountOfSocksByColorAndCotton(
            @RequestParam(name = "color")
            @NotBlank(message = "color is empty")
            String color,
            @RequestParam(name = "operation")
            @NotBlank(message = "operation is empty")
            String operation,
            @RequestParam(name = "cottonPart")
            @Max(value = 100, message = "max 100")
            @Min(value = 0, message = "min 0")
            Integer cotton) {
        return ResponseEntity.ok(socksService.findCountOfSocks(color, operation, cotton));
    }

    @PostMapping("/income")
    public ResponseEntity<String> incomeSocks(
            @Valid @RequestBody SocksRecord socksRecord) {
        return ResponseEntity.ok(socksService.addCountSocks(socksRecord));

    }

    @PostMapping("/outcome")
    public ResponseEntity<String> outcomeSocks(
            @Valid @RequestBody SocksRecord socksRecord) {
        return ResponseEntity.ok(socksService.removeCountSocks(socksRecord));

    }

}
