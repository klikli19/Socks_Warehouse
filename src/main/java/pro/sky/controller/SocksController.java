package pro.sky.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.dto.SocksDTO;
import pro.sky.service.SocksService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/socks")
@Tag(name = "Носки")
public class SocksController {
    private final SocksService service;

    @Operation(
            summary = "Добавление носков на склад",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Удалось добавить приход",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = SocksDTO.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Параметры запроса отсутствуют или имеют некорректный формат",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = SocksDTO.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Произошла ошибка, не зависящая от вызывающей стороны.)",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = SocksDTO.class)
                            )
                    )
            }
    )
    @PostMapping("/income")
    public ResponseEntity<SocksDTO> addSocks(@RequestBody SocksDTO dto) {
        return ResponseEntity.ok(service.addSocks(dto));
    }

    @Operation(
            summary = "Отпуск носков со склада",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Удалось отпустить со склада",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = SocksDTO.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Параметры запроса отсутствуют или имеют некорректный формат",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = SocksDTO.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Произошла ошибка, не зависящая от вызывающей стороны.)",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = SocksDTO.class)
                            )
                    )
            }
    )
    @PostMapping("/outcome")
    public ResponseEntity<SocksDTO> releaseSocks(@RequestBody SocksDTO dto) {
        return ResponseEntity.ok(service.releaseSocks(dto));
    }

    @Operation(
            summary = "Общее количество носков на складе, соответствующих параметрам",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Запрос выполнен",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = SocksDTO.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Параметры запроса отсутствуют или имеют некорректный формат",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = SocksDTO.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Произошла ошибка, не зависящая от вызывающей стороны.)",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = SocksDTO.class)
                            )
                    )
            }
    )
    @GetMapping
    public ResponseEntity<?> getTotalNumberOfSocks(@Parameter(description = "Цвет носков") @RequestParam String color,
                                                   @Parameter(description = "Значение % хлопка (от 0 до 100)")
                                                   @RequestParam Integer cottonPart,
                                                   @Parameter(description = "Оператор сравнения процента хлопка, " +
                                                           "введите одно из: moreThan, lessThan, equal (в любом регистре)")
                                                       @RequestParam String operation) {
        return ResponseEntity.ok(service.getTotalNumberOfSocks(color, cottonPart, operation));
    }
}
