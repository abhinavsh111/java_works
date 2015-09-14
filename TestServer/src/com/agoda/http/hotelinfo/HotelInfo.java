package com.agoda.http.hotelinfo;

/**
 * @author abhinav
 *
 */
/**
 * Its a simple pojo used to store the info about hotel data
 *
 */
public class HotelInfo implements Comparable<HotelInfo>{

	private String cityId;
	private String hotelId;
	private String roomType;
	private double price;
	/**
	 * @return the cityId
	 */
	public String getCityId() {
		return cityId;
	}
	/**
	 * @param cityId the cityId to set
	 */
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	/**
	 * @return the hotelId
	 */
	public String getHotelId() {
		return hotelId;
	}
	/**
	 * @param hotelId the hotelId to set
	 */
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	/**
	 * @return the roomType
	 */
	public String getRoomType() {
		return roomType;
	}
	/**
	 * @param roomType the roomType to set
	 */
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * Sorts the data on the basis of price
	 */
	@Override
	public int compareTo(HotelInfo o) {
		if(this.getPrice()<o.getPrice())
			return -1;
		else if(this.getPrice()>o.getPrice())
			return 1;
		return 0;
	}
	
	
}
