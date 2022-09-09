package com.example.renACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.renACar.entities.concretes.OrderedAdditional;

public interface OrderedAdditionalDao extends JpaRepository<OrderedAdditional, Integer> {

	boolean existsByOrderedAdditionalId(int orderedAdditionalId);
    boolean existsByRental_Id(int Id);
    boolean existsByAdditional_AdditionalId(int additionalId);
    List<OrderedAdditional> getAllByAdditional_AdditionalIdAndRental_Id(int additionalId, int Id);

    List<OrderedAdditional> getAllByRental_Id(int Id);
    List<OrderedAdditional> getAllByAdditional_AdditionalId(int additionalId);
}
