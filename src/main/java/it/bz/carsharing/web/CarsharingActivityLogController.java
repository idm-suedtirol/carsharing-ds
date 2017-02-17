package it.bz.carsharing.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.bz.idm.carsharing.ActivityLogger;
import it.bz.idm.carsharing.wsdl.ListVehicleOccupancyByStationResponse.VehicleAndOccupancies;
import it.bz.idm.carsharing.wsdl.StationAndVehicles;

@Controller
public class CarsharingActivityLogController {
	@Autowired
	private ActivityLogger activityLogger;

	@RequestMapping("/stationAndVehicles")
	public @ResponseBody ResponseEntity<List<StationAndVehicles>> stationAndVehicles() {
		ResponseEntity<List<StationAndVehicles>> entity = new ResponseEntity<List<StationAndVehicles>>(
				activityLogger.getStationAndVehicles(), HttpStatus.OK);
		return entity;
	}

	@RequestMapping("/vehicleOccupancies")
	public @ResponseBody ResponseEntity<List<VehicleAndOccupancies>> vehicleOccupancies() {
		ResponseEntity<List<VehicleAndOccupancies>> responseEntity = new ResponseEntity<List<VehicleAndOccupancies>>(
				activityLogger.getVehicleAndOccupancies(), HttpStatus.OK);
		return responseEntity;
	}
}
