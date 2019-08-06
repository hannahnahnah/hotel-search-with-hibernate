package co.grandcircus.hotel.search.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.grandcircus.hotel.search.entity.Hotel;

@Repository
@Transactional
public class HotelDao {
	
	@PersistenceContext
	private EntityManager em;

	
	public List<Hotel> findAll() {
		return em.createQuery("FROM Hotel", Hotel.class).getResultList();
	}
	
	public List<Hotel> findByCity(String city) {
		return em.createQuery("FROM Hotel WHERE city = :city ORDER BY pricePerNight ASC", Hotel.class)
				.setParameter("city", city)
				.getResultList();
	}
	
	public List<Hotel> findByName(String name) {
		return em.createQuery("FROM Hotel WHERE name = :name ORDER BY pricePerNight ASC", Hotel.class)
				.setParameter("name", name)
				.getResultList();
	}
	
	public List<Hotel> orderByPrice() {
		return em.createQuery("FROM Hotel ORDER BY pricePerNight ASC", Hotel.class).getResultList();
	}
	
	public Hotel findById(Long id) {
		return em.find(Hotel.class, id);
	}
	
	public void create(Hotel hotel) {
		em.persist(hotel);
	}
	
	public void edit(Hotel hotel) {
		em.merge(hotel);
	}
	
	public void delete(Long id) {
		Hotel hotel = em.getReference(Hotel.class, id);
		em.remove(hotel);
	}

}
