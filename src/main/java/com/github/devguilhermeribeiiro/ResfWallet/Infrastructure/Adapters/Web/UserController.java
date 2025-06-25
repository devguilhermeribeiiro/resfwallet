package com.github.devguilhermeribeiiro.ResfWallet.Infrastructure.Adapters.Web;

import java.util.Map;
import java.util.UUID;

import com.github.devguilhermeribeiiro.ResfWallet.Application.Dtos.UserRequestDto;
import com.github.devguilhermeribeiiro.ResfWallet.Application.Dtos.UserResponseDto;
import com.github.devguilhermeribeiiro.ResfWallet.Application.Exceptions.NotFoundException;
import com.github.devguilhermeribeiiro.ResfWallet.Application.Services.UserService;

import io.javalin.http.Handler;

public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public Handler getUser = ctx -> {
        UUID id = UUID.fromString(ctx.pathParam("id"));

        try {
            UserResponseDto userResponseDto = userService.getUser(id);
            ctx.json(userResponseDto).status(200);
        } catch (NotFoundException e) {
            ctx.json(Map.of("Error", e.getMessage())).status(404);
        }
    };

    public Handler createUser = ctx -> {
        UserRequestDto userRequestDto = ctx.bodyAsClass(UserRequestDto.class);
        UserResponseDto userResponseDto = userService.createUser(userRequestDto);

        ctx.json(userResponseDto).status(200);
    };

    public Handler updateUser = ctx -> {
        UUID id = UUID.fromString(ctx.pathParam("id"));
    
        try {
            UserRequestDto userRequestDto = ctx.bodyAsClass(UserRequestDto.class);
            UserResponseDto userResponseDto = userService.updateUser(id, userRequestDto);
    
            ctx.json(userResponseDto).status(200);
        } catch (NotFoundException e) {
            ctx.json(Map.of("Error", e.getMessage())).status(404);
        }
    };

    public Handler deleteUser = ctx -> {
        UUID id = UUID.fromString(ctx.pathParam("id"));
        var response = userService.deleteUser(id);

        if (response != 0) {
            ctx.json(Map.of("Error", "User not found")).status(404);
        }

        ctx.json(Map.of("Success", "Deleted")).status(200);
    };
    
}
