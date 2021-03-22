package ru.netology;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class ClientDataInfo {
    private final String validName1WithoutSpecialLetter;
    private final String validPhone;
    private final String validCity;
    private final String firstDate;
    private final String newDate;
    private final String invalidName;
    private final String validName2WithSpecialLetter;
    private final String invalidPhone;
    private final String invalidCity;
}

