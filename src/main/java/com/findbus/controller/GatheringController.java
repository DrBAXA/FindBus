package com.findbus.controller;

import com.findbus.entity.BusLocation;
import com.findbus.service.GatheringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/gathering")
public class GatheringController {

	@Autowired
	private GatheringService gatheringService;

	@RequestMapping(value = "/{busId}", method = RequestMethod.GET, produces="text/html")
	public void getData(@PathVariable("busId") int id,
										@RequestParam("lat") double lat,
										@RequestParam("lng") double lng,
										@RequestParam("time") int time){
		gatheringService.receiveData(id, new BusLocation(lat, lng, time));
		//return new ResponseEntity<>(HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
	}
}