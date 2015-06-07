package br.com.hospitalWS.model;

public class PlaceDetail {

	
	public String name;
	@Override
	public String toString() {
		return "Place [name=" + name + ", placeId=" + placeId + ", lat=" + lat
			+ ", lon=" + lon + ", ratings=" + ratings + ", Endereço="+end+"]";
	}
	
	public String placeId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getPlaceId() {
		return placeId;
	}
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	
	
	public String lat;
	public String lon;
	public String end;
	public int ratings;
	
}
