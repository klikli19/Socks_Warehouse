package pro.sky.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.dto.SocksDTO;
import pro.sky.service.SocksService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/socks")
public class SocksController {
    private final SocksService service;

    @PostMapping("/income")
    public ResponseEntity<SocksDTO> addSocks(@RequestBody SocksDTO dto) {
        return ResponseEntity.ok(service.addSocks(dto));
    }

    @PostMapping("/outcome")
    public ResponseEntity<SocksDTO> releaseSocks(@RequestBody SocksDTO dto) {
        return ResponseEntity.ok(service.releaseSocks(dto));
    }

    @GetMapping
    public ResponseEntity<?> getTotalNumberOfSocks(String color, Integer cottonPart, String operation) {
        return ResponseEntity.ok(service.getTotalNumberOfSocks(color, cottonPart, operation));
    }
}
