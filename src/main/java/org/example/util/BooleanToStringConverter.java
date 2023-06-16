package org.example.util;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class BooleanToStringConverter implements AttributeConverter<Boolean, String> {
    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        return (attribute != null && attribute) ? "true" : "false";
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        return "true".equalsIgnoreCase(dbData);
    }
}
