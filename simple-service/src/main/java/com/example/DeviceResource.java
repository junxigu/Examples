package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("device")
public class DeviceResource {

	private DeviceDao deviceDao = new DeviceDao();

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Device getDevice(@QueryParam("ip") final String ip) {
		return ip != null ? deviceDao.getDevice(ip) : null;
	}
	
	@PUT
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Device updateDevice(final Device device) {
		return device != null ? deviceDao.updateDevice(device) : null;
	}
}
