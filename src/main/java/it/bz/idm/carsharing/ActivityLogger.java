package it.bz.idm.carsharing;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.bz.idm.carsharing.wsdl.ListVehicleOccupancyByStationResponse.VehicleAndOccupancies;
import it.bz.idm.carsharing.wsdl.StationAndVehicles;

@Component
public class ActivityLogger {

	List<StationAndVehicles> stationAndVehicles;
	List<VehicleAndOccupancies> vehicleAndOccupancies;

	public List<StationAndVehicles> getStationAndVehicles() {
		if (stationAndVehicles == null)
			stationAndVehicles = new ArrayList<StationAndVehicles>();
		return stationAndVehicles;
	}

	public List<VehicleAndOccupancies> getVehicleAndOccupancies() {
		if (vehicleAndOccupancies == null)
			vehicleAndOccupancies = new ArrayList<VehicleAndOccupancies>();
		return vehicleAndOccupancies;
	}
	
	@Autowired
	public ActivityLogger(){
		
	}

}
