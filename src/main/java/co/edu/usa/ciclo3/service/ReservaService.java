/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.ciclo3.service;

import co.edu.usa.ciclo3.modelo.Reserva;
import co.edu.usa.ciclo3.repository.ReservaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hgc68
 */
@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;
    
    public List<Reserva> getAll(){
        return reservaRepository.getAll();
    }
    
    public Optional<Reserva> getReserva(int id){
        return reservaRepository.getReserva(id);
    }
    
    public Reserva save(Reserva reserva){
        if(reserva.getIdReservation()==null){
            return reservaRepository.save(reserva);  
        }else{
            Optional<Reserva> paux5=reservaRepository.getReserva(reserva.getIdReservation());
            if(!paux5.isPresent()){
                return reservaRepository.save(reserva);
            }else{
                return reserva;
            }
        }
        
    }
    
    public Reserva update(Reserva reserva){
        if(reserva.getIdReservation()!=null){
            Optional<Reserva> e= reservaRepository.getReserva(reserva.getIdReservation());
            if(!e.isPresent()){

                if(reserva.getStartDate()!=null){
                    e.get().setStartDate(reserva.getStartDate());
                }
                if(reserva.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reserva.getDevolutionDate());
                }
                if(reserva.getStatus()!=null){
                    e.get().setStatus(reserva.getStatus());
                }
                reservaRepository.save(e.get());
                return e.get();
            }else{
                return reserva;
            }
        }else{
            return reserva;
        }
    }

    public boolean deleteReserva(int reservaId) {
        Boolean aBoolean = getReserva(reservaId).map(reserva -> {
            reservaRepository.delete(reserva);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
