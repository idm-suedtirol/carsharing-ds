package it.bz.idm.carsharing;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import it.bz.idm.carsharing.api.ApiClient;

@Component
public class Scheduler {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private HashMap<String, String[]> vehicleIdsByStationIds;
	private String[] cityUIDs = { "1000087" };

	private ApiClient apiClient = null;

	// library missing
	// IXMLRPCPusher xmlrpcPusher;

	private CarsharingConnector carsharingConnector = null;

	public Scheduler() {
		carsharingConnector = new CarsharingConnector();
		apiClient = new ApiClient();
	}

	/**
	 * for getting the static data like vehicle and stationlist from the
	 * carsharingAPI and push them to te integreen-platform
	 */
	@Scheduled(cron = "0 0 0 * * *") // every day at midnight
	public void staticTask() {

		logger.info("Static Task started");
		try {
			vehicleIdsByStationIds = carsharingConnector.connectForStaticData(cityUIDs, apiClient);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO correct logging and not only toString of object
		for (String[] strings : vehicleIdsByStationIds.values())
			for (String string : strings)
				logger.info("Stations added to integreenplatform: " + string);
		logger.info("Static Task finished");
	}

	/**
	 * for getting real time data like the vehicle and stationlist from the
	 * carsharingAPI and push them to te integreen-platform
	 */
	@Scheduled(fixedRate = 600000) // 10 minutes interval
	public void realTimeTask() {

		logger.info("Real Time Task");
		if (vehicleIdsByStationIds != null)
			carsharingConnector.connectForRealTimeData(cityUIDs, vehicleIdsByStationIds, apiClient);
		else
			try {
				vehicleIdsByStationIds = carsharingConnector.connectForStaticData(cityUIDs, apiClient);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		logger.info("Real Time Task finished");
	}
}