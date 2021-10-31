/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.ciclo3.repository;

import co.edu.usa.ciclo3.modelo.Reserva;
import co.edu.usa.ciclo3.repository.crud.ReservaCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hgc68
 */
@Repository
public class ReservaRepository {
    @Autowired
    private ReservaCrudRepository reservaCrudRepository;
    public List<Reserva> getAll(){
        return (List<Reserva>) reservaCrudRepository.findAll();
    }
    public Optional<Reserva> getReserva(int id){
        return reservaCrudRepository.findById(id);
    }

    public Reserva save(Reserva reserva){
        return reservaCrudRepository.save(reserva);
    }
    public void delete(Reserva reserva){
       reservaCrudRepository.delete(reserva);
    }
}
