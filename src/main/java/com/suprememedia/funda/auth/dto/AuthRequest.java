package com.suprememedia.funda.auth.dto;

public record AuthRequest(
        String userName,
        String password
) {
}
