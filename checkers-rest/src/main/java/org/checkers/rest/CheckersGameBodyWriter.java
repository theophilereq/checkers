package org.checkers.rest;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import org.checkers.core.PieceColour;
import org.checkers.jpa.CheckersAdapter;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

@Provider
@Produces({ "application/json", "*/*" })
public class CheckersGameBodyWriter implements MessageBodyWriter<CheckersAdapter> {

	@Context
	UriInfo info;

	private CheckersAdapter game;

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return type.equals(CheckersAdapter.class);
	}

	@Override
	public long getSize(CheckersAdapter t, Class<?> type, Type genericType, Annotation[] annotations,
			MediaType mediaType) {
		return 0;
	}

	@Override
	public void writeTo(CheckersAdapter t, Class<?> type, Type genericType, Annotation[] annotations,
			MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
					throws IOException, WebApplicationException {

		JsonFactory factory = new JsonFactory();
		JsonGenerator jg = factory.createGenerator(entityStream, JsonEncoding.UTF8);

		jg.writeStartObject();

		PieceColour winner = game.getWinner();
		jg.writeStringField("winner", winner != null ? winner.toString() : "");
		jg.writeStringField("token", game.getToken());

		jg.writeFieldName("cols");
		jg.writeStartArray();

		for (int i = 0; i < game.getColumnsNumber(); i++) {
			jg.writeStartObject();

			jg.writeFieldName("playAction");
			jg.writeStartObject();
			jg.writeStringField("method", "POST");
			jg.writeStringField("url", info.getAbsolutePath() + "/" + i);
			jg.writeEndObject();

			jg.writeFieldName("cells");
			jg.writeStartArray();
			for (int j = 0; j < game.getRowsNumber(); j++) {
				PieceColour cell = game.getCell(i, j);
				jg.writeString(cell != null ? cell.toString() : "");
			}
			jg.writeEndArray();
			jg.writeEndObject();
		}
		jg.writeEndArray();
		jg.writeEndObject();
		jg.flush();
	}
}
