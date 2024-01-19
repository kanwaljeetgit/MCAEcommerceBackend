package com.lpu.ecommerce.converter;

import com.fasterxml.jackson.databind.JsonNode;
import com.lpu.ecommerce.utils.JsonUtils;
import jakarta.persistence.AttributeConverter;

/**
 * @author KANWALJEET on 03-01-2024
 * @project ecommerce
 **/
public class JSONObjectConverter implements AttributeConverter<JsonNode, String> {
    @Override
    public String convertToDatabaseColumn(JsonNode attribute) {
        if (attribute != null) {
            return attribute.toString();
        } else {
            return null;
        }
    }

    @Override
    public JsonNode convertToEntityAttribute(String dbData) {
        if (dbData != null) {
            try {
                return JsonUtils.getObjectMapper().readTree(dbData);
            }catch (Exception e) {
                //log.error("stacktrace", e);
                return null;
            }
        } else {
            return null;
        }
    }
}
