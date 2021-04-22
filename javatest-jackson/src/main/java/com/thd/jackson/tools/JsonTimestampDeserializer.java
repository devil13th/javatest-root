package com.thd.jackson.tools;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * 时间戳序列化器
 *
 * @author: wanglei62
 * @DATE: 2020/4/1 11:11
 **/
public class JsonTimestampDeserializer extends JsonDeserializer<Timestamp> {

    @Override
    public Timestamp deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return der(jsonParser,deserializationContext,null);
    }

    @Override
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException {
        return der(jsonParser,ctxt,typeDeserializer);
    }

    private Timestamp der(JsonParser jsonParser, DeserializationContext context, TypeDeserializer typeDeserializer) throws IOException {
        String value = jsonParser.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy||MM||dd HH:mm:ss");
        try{
            return new Timestamp(sdf.parse(value).getTime());
        }catch(Exception e){
            throw new RuntimeException("Timestamp格式错误");
        }
    }
}
