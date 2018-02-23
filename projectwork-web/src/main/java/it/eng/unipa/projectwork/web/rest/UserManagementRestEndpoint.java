package it.eng.unipa.projectwork.web.rest;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

import it.eng.unipa.projectwork.service.UserService;
import it.eng.unipa.projectwork.web.converter.ConverterUtils;
import it.eng.unipa.projectwork.web.dto.UserDTO;

/*import it.eng.book.auction.event.ClosedAuctionEvent;
import it.eng.book.auction.event.OfferAuctionEvent;
import it.eng.book.auction.event.TimerAuctionEvent;
import it.eng.book.service.AuctionEventManager;*/

@Path("/user")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@Stateless
public class UserManagementRestEndpoint {
	
	@EJB
	UserService userService;

	
	
	@GET
	@Path("/get")
	@RolesAllowed(value="USER")
   public UserDTO get(@Context SecurityContext sc){
		String username  = sc.getUserPrincipal().getName(); 
		
		UserDTO userDTO  =  ConverterUtils.convert(userService.getUser(username),UserDTO.class);
		
		return userDTO;
		
	}
	
	

}
