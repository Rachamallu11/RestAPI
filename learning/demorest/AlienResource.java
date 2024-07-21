package com.learning.demorest;




import java.util.Arrays;
import java.util.List;

import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

//we are creating the alienresource for creating the alien objects here

@Path("aliens")  // when ever we call aliens i want one resource
public class AlienResource 

{
	AlienRepository repo = new AlienRepository();
	@GET                                    //without writing the get we are not get the o/p at browser 
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})  //we have specify the data which we are converting 
	
	public List<Alien> getAliens() {
		
		System.out.println("get aliens called...");	
		
//		Alien a1 =new Alien();
//		a1.setName("Satya");
//		a1.setPoints(5);
//		
//		Alien a2 =new Alien();
//		a1.setName("Rana");
//		a1.setPoints(10);
		
// it is fetching the data from the database using the AlienRepository and we are creted the new object for that 
		
		return repo.getAliens();
		
	}
	
	//if i want to get one particular id in postman o/p we are creating here 
	
	@GET
	@Path("alien/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_JSON})   //if we want both then we keep in a array
	public Alien getAlien(@PathParam("id") int id)
	{
		return repo.getAlien(101);
	}
	
	//why path("alien") is we are creating the path is changing to "aliens/alien"
	@POST
	@Path("alien")
	public Alien createAlien(Alien a1) {
		
		System.out.println(a1);
		repo.create(a1);   //we have to create the repository which will add the data in repository
		
		return a1;
		
		
	}

}
