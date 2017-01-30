/*
carsharing-ds: car sharing datasource for the integreen cloud

Copyright (C) 2015 TIS Innovation Park - Bolzano/Bozen - Italy

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package it.bz.idm.carsharing.api;

/**
 * 
 * @author Davide Montesin <d@vide.bz>
 */
public class ListStationsByCityResponse {
	String faultCode;
	String faultString;
	Object [] detail;

	public static class CityAndStations {
		City city = new City();
		CarsharingStationDto[] station;

		public City getCity() {
			return this.city;
		}

		public CarsharingStationDto[] getStation() {
			return this.station;
		}
	}

	CityAndStations[] cityAndStations;

	public CityAndStations[] getCityAndStations() {
		return this.cityAndStations;
	}

	public String getFaultCode() {
		return faultCode;
	}

	public String getFaultString() {
		return faultString;
	}

	public Object[] getDetail() {
		return detail;
	}

}
