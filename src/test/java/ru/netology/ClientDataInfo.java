package ru.netology;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class ClientDataInfo {
    private final String validName;
    private final String validPhone;
    private final String validCity;
    private final String firstDate;
    private final String newDate;
}

