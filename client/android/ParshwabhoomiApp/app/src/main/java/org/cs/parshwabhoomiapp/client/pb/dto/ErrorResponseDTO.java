package org.cs.parshwabhoomiapp.client.pb.dto;

import android.util.JsonReader;
import android.util.JsonWriter;
import android.util.Log;

import org.cs.parshwabhoomiapp.client.framework.dto.JSONSerializable;

import java.io.IOException;

public class ErrorResponseDTO implements JSONSerializable{
	public static final String TAG = ErrorResponseDTO.class.getSimpleName();

	public ErrorResponseDTO() {
		super();
	}
	
	public ErrorResponseDTO(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	private int code;
	private String message;
	
	public enum HTTP_STATUS_CODE {
		BAD_REQUEST(4400),
		UNAUTHORIZED(4401),
		FORBIDDEN(4403),
		NOT_FOUND(4404),
		CONFLICT(4409),
		INTERNAL_SERVER_ERROR(5500);
		
		
		private int code;
		
		private HTTP_STATUS_CODE(int code) {
			this.code = code;
		}
		
		public int getCode() {
			return code;
		}
		
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void readJSON(JsonReader jsonReader) {
		Log.i(TAG, "Reading from JSON");
		try {
			while (jsonReader.hasNext()) {
				String name = jsonReader.nextName();
				if (name.equals("code")) {
					code = Integer.parseInt(jsonReader.nextString());
				} else if (name.equals("message")) {
					message = jsonReader.nextString();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void writeJSON(JsonWriter jsonWriter) {

	}
}
