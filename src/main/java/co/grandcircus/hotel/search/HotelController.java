package co.grandcircus.hotel.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.hotel.search.dao.HotelDao;
import co.grandcircus.hotel.search.entity.Hotel;

@Controller
public class HotelController {
	
	@Autowired
	private HotelDao dao;
	
	@RequestMapping("/")
	public ModelAndView home() {
		List<Hotel> hotels = dao.findAll();
		Set<String> cities = new HashSet<>();
		for(Hotel hotel : hotels) {
			cities.add(hotel.getCity());
		}
		//System.out.println(cities);
		//System.out.println(hotels);
		
		return new ModelAndView("hotelhome", "listOfCities", cities);
	}
	
	@RequestMapping("/results-page")
	public ModelAndView showHotels(
			@RequestParam("theCity") String resultCity,
			@RequestParam("maxPrice") Integer resultMaxPrice) {
		
		List<Hotel> hotelsInCity = dao.findByCity(resultCity);
		List<Hotel> hotelsWithinPrice = new ArrayList<Hotel>();
		for (Hotel hotel : hotelsInCity) {
			if (resultMaxPrice >= hotel.getPricePerNight()) {
				hotelsWithinPrice.add(hotel);
			} 
		}
		
		//System.out.println(hotelsInCity);
		//System.out.println(hotelsWithinPrice);

		
				ModelAndView mv = new ModelAndView("results-page"); //this is the longhand version of the single line below
				mv.addObject("resultCityDisplay", resultCity);
				mv.addObject("listOfHotels", hotelsWithinPrice);
				//mv.addObject("withinPriceCityDisplay", hotelsWithinPrice);
				//mv.addObject("resultCityDisplay", hotelsWithinPrice);
				
				return mv;
				//return new ModelAndView("results-page", "resultCityDisplay", resultCity);
	}
	
	@RequestMapping("/details-page")
	public ModelAndView showDetails(
			@RequestParam("resultList") String detailHotelName) { //the problem is with trying to pass the parameter that way ${resultList.name} doesnt work either
		List<Hotel> shortListHotel = dao.findByName(detailHotelName);
		System.out.println(shortListHotel);
		return new ModelAndView("details-page", "resultDetailsDisplay", shortListHotel);
	}
	
	

}//class
