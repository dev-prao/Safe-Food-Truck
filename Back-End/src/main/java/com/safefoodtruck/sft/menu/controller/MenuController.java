package com.safefoodtruck.sft.menu.controller;

import com.safefoodtruck.sft.menu.dto.request.MenuListRegistRequestDto;
import com.safefoodtruck.sft.menu.service.MenuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/menu")
@RestController
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @GetMapping
    @Operation(summary = "메뉴 등록", description = "메뉴를 등록할 때 사용하는 API")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "메뉴등록에 성공하였습니다!",
            content = @Content(mediaType = "application/json")
        ),
        @ApiResponse(
            responseCode = "500",
            description = "Error Message 로 전달함",
            content = @Content(mediaType = "application/json")
        )
    })
    public ResponseEntity<?> registMenu(@RequestBody MenuListRegistRequestDto menuListRegistRequestDto) {
//        SecurityContextHolder.getContext().getAuthentication().

//        menuService.registMenu(menuListRegistRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body("메뉴 등록에 성공하였습니다!");
    }
}
