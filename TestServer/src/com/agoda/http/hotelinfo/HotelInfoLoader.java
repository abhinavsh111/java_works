
package com.agoda.http.hotelinfo;

/**
* @author abhinav
*
*/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * This class reads the csv file which contains the hotel info 
 * and send back the result
 *
 */
public class HotelInfoLoader {

	private String csvFile;

	public HotelInfoLoader(String filePath)
	 {
		 csvFile = filePath;		 
	 }
 /**
  * This method reads the csv file and filters the 
  * requested api data
  */
/**
 * 
 * @param cityCd
 * @return Map
 */
  public Map<String,List<HotelInfo>> getHotelInfo(String cityCd) {
		
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";
	Map<String,List<HotelInfo>> hotelMap = new HashMap<String,List<HotelInfo>>();
	List<HotelInfo> hotelByCityist = new ArrayList<>();;
	try {

		br = new BufferedReader(new FileReader(csvFile));
		br.readLine();
		while ((line = br.readLine()) != null) {

		        // use comma as separator
			String[] country = line.split(cvsSplitBy);
			if(country[0].equalsIgnoreCase(cityCd))
			{
			HotelInfo hotelDb = new HotelInfo();
			hotelDb.setCityId(country[0]);
			hotelDb.setHotelId(country[1]);
			hotelDb.setRoomType(country[2]);
			hotelDb.setPrice(Double.parseDouble(country[3]));
			hotelByCityist.add(hotelDb);
			hotelMap.put(hotelDb.getCityId(), hotelByCityist);
			}
		}

	} catch (FileNotFoundException e) {
		e.printStackTrace();
		return Collections.emptyMap();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	return hotelMap;
  }

}