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

import it.bz.idm.carsharing.api.ListStationsByCityRequest.ListStationsByCitySubRequest;
import it.bz.idm.carsharing.api.ServiceRequest.SubRequest;

/**
 * 
 * @author Davide Montesin <d@vide.bz>
 */
public class ListStationsByCityRequest extends ServiceRequest<ListStationsByCitySubRequest>
{
   static class ListStationsByCitySubRequest extends SubRequest
   {
      String[] cityUID;

      public String[] getCityUID()
      {
         return this.cityUID;
      }
   }

   public ListStationsByCityRequest(String... cityUID)
   {
      this.request = new ListStationsByCitySubRequest();
      this.request.cityUID = cityUID;
      this.function = "Api.listStationsByCity";
   }

}
