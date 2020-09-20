package com.pathsegment.resources;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;

import org.glassfish.jersey.jaxb.internal.XmlCollectionJaxbProvider.App;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;

@Path("/property")
public class PropertyResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{propertyType}/{city}/{location}/search")
	public String search(@PathParam("propertyType") PathSegment propertyTypePathSegment,
			@PathParam("city") PathSegment cityTypePathSegment,
			@PathParam("location") PathSegment locationTypePathSegment, @QueryParam("minPrice") String minPrice,
			@QueryParam("maxPrice") String maxPrice, @QueryParam("floor") String floor,
			@QueryParam("amenities") String[] amenities) {

		StringBuilder builder = new StringBuilder();

		builder.append("propertyType : ").append(propertyTypePathSegment.getPath()).append(":")
				.append(matrixParameters(propertyTypePathSegment.getMatrixParameters()));

		builder.append(" city : ").append(cityTypePathSegment.getPath())
				.append(matrixParameters(cityTypePathSegment.getMatrixParameters()));

		builder.append(" loaction : ").append(locationTypePathSegment.getPath())
				.append(matrixParameters(locationTypePathSegment.getMatrixParameters()));

		builder.append(" minPrice : ").append(minPrice).append(" maxPrice : ").append(maxPrice).append(" floor : ")
				.append(floor).append(" amenities : ");

		for (String am : amenities) {
			builder.append("[").append(am).append("]");
		}

		return builder.toString();
	}

	private String matrixParameters(MultivaluedMap<String, String> inMap) {
		StringBuilder builder = new StringBuilder();

		for (String paramName : inMap.keySet()) {
			builder.append(" " + paramName + " : ");
			ArrayList<String> paramValues = (ArrayList<String>) inMap.get(paramName);
			for (String paramValue : paramValues) {
				builder.append(" [").append(paramValue).append("] ");
			}

			builder.append(";");

		}
		return builder.toString();
	}
}
