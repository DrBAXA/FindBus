package com.findbus.controller;

import com.findbus.entity.Location;
import com.findbus.service.GatheringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	@RequestMapping(value = "/{busId}", method = RequestMethod.GET)
	public ResponseEntity<Void> getData(@PathVariable("busId") int id,
										@RequestParam double lat,
										@RequestParam double lng,
										@RequestParam int timestamp){
		gatheringService.receiveData(id, new Location(lat, lng, timestamp));
		return new ResponseEntity<>(HttpStatus.OK);
	}
}