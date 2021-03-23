package ru.netology;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class ClientDataInfo {
    private final String name;
    private final String phone;
    private final String city;
    private final String firstDate;
    private final String newDate;
}

