package com.inmyshow.webbase.action.utils;

import java.io.IOException;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;

/**处理json转换适应jqGird,jqGird不认毫秒
 * @author HanHongmin
 *
 */
public class CustomJsonDateSerializer extends JsonSerializer<Date>{

	@Override
	public void serialize(Date date, JsonGenerator jgen, SerializerProvider arg2)
			throws IOException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(jgen, date.getTime()/1000);  
	}  
  

}
